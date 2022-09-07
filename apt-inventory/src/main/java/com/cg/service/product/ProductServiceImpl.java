package com.cg.service.product;


import com.cg.exception.DataInputException;
import com.cg.model.Product;
import com.cg.model.ProductMedia;
import com.cg.model.dto.ProductDTO;
import com.cg.model.enums.EBussinessStatus;
import com.cg.model.enums.FileType;
import com.cg.repository.ProductMediaRepository;
import com.cg.repository.ProductRepository;
import com.cg.service.upload.UploadService;
import com.cg.utils.AppUtils;
import com.cg.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMediaRepository productMediaRepository;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UploadUtils uploadUtils;

    @Autowired
    private AppUtils appUtils;

//    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
//    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
//
//    public static String toSlug(String input) {
//        String noWhitespace = WHITESPACE.matcher(input).replaceAll("-");
//        String normalized = Normalizer.normalize(noWhitespace, Normalizer.Form.NFD);
//        String slug = NONLATIN.matcher(normalized).replaceAll("");
//        return slug.toLowerCase(Locale.ENGLISH);
//    }


    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findProductBySlug(String slug) {
        return productRepository.findProductBySlug(slug);
    }

    @Override
    public Product create(ProductDTO productDTO) {

        List<MultipartFile> fileList = productDTO.getFiles();
        productDTO.setPurchaseOrderPrice(new BigDecimal(0L));
        String config = productDTO.getConfigurationDetail();
        String[] ary = config.split("\"content\":\"");
        String strTitle = "";
        int length = 7;
        for (int i = 1;i < length;i++) {
            int indexValue = ary[i].indexOf("\"");
            ary[i] = ary[i].substring(0,indexValue-1);
            if (i != length - 1) {
                int indexValue1 = ary[i].indexOf(",");
                ary[i] = ary[i].substring(0,indexValue1);
                strTitle += ary[i].trim() +"/ ";
            }else {
                int indexValue1 = ary[i].indexOf(",");
                ary[i] = ary[i].substring(0,indexValue1);
                strTitle += ary[i].trim();
            }
        }
        String title = (productDTO.getTitle()).trim().replaceAll("\\s+", " ") + " " + strTitle;
        String slug = AppUtils.removeNonAlphanumeric(title);

        productDTO.setTitle(title);
        productDTO.setSlug(slug);
        productDTO.setBusinessStatus(EBussinessStatus.NEW_RELEASES);

        Product product = productRepository.save(productDTO.toProduct());

        for (MultipartFile file : fileList) {
            String fileType = file.getContentType();

            assert fileType != null;

            fileType = fileType.substring(0, 5);

            productDTO.setFileType(fileType);
            productDTO.setFile(file);

            ProductMedia productMedia = productMediaRepository.save(productDTO.toProductMedia(product));

            if (fileType.equals(FileType.IMAGE.getValue())) {
                uploadAndSaveProductImage(productDTO, product, productMedia);
            }

            if (fileType.equals(FileType.VIDEO.getValue())) {
                uploadAndSaveProductVideo(productDTO, product, productMedia);
            }
        }
        return product;
    }

    private void uploadAndSaveProductImage(ProductDTO productDTO, Product product, ProductMedia productMedia) {
        try {
            Map uploadResult = uploadService.uploadImage(productDTO.getFile(), uploadUtils.buildImageUploadParams(productMedia));
            String fileUrl = (String) uploadResult.get("secure_url");
            String fileFormat = (String) uploadResult.get("format");

            productMedia.setFileName(productMedia.getId() + "." + fileFormat);
            productMedia.setFileUrl(fileUrl);
            productMedia.setFileFolder(UploadUtils.IMAGE_UPLOAD_FOLDER);
            productMedia.setCloudId(productMedia.getFileFolder() + "/" + productMedia.getId());
            productMedia.setProduct(product);
            productMediaRepository.save(productMedia);

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload hình ảnh thất bại");
        }
    }

    private void uploadAndSaveProductVideo(ProductDTO productDTO, Product product, ProductMedia productMedia) {
        try {
            Map uploadResult = uploadService.uploadVideo(productDTO.getFile(), uploadUtils.buildVideoUploadParams(productMedia));
            String fileUrl = (String) uploadResult.get("secure_url");
            String fileFormat = (String) uploadResult.get("format");

            productMedia.setFileName(productMedia.getId() + "." + fileFormat);
            productMedia.setFileUrl(fileUrl);
            productMedia.setFileFolder(UploadUtils.VIDEO_UPLOAD_FOLDER);
            productMedia.setCloudId(productMedia.getFileFolder() + "/" + productMedia.getId());
            productMedia.setProduct(product);
            productMediaRepository.save(productMedia);

        } catch (IOException e) {
            e.printStackTrace();
            throw new DataInputException("Upload video thất bại");
        }
    }

    @Override
    public void delete(Product product) throws IOException {

        Optional<ProductMedia> productImageVideo = productMediaRepository.findByProduct(product);

        if (productImageVideo.isPresent()) {
            String publicId = productImageVideo.get().getCloudId();

            if (productImageVideo.get().getFileType().equals(FileType.IMAGE.getValue())) {
                uploadService.destroyImage(publicId, uploadUtils.buildImageDestroyParams(product, publicId));
            }

            if (productImageVideo.get().getFileType().equals(FileType.VIDEO.getValue())) {
                uploadService.destroyVideo(publicId, uploadUtils.buildVideoDestroyParams(product, publicId));
            }

            productMediaRepository.delete(productImageVideo.get());
        }

        productRepository.delete(product);

    }
}
