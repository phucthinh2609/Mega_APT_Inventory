package com.cg.model.dto;

import com.cg.model.*;
import com.cg.model.enums.EBussinessStatus;
import com.cg.utils.JsonToMapConverter;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDTO implements Serializable {

    private String id;

    @NotBlank(message = "Brand is required")
    @Size(max = 50, message = "The length of brand must be between 5 and 50 characters")
    private String brand;
    @NotBlank(message = "Model is required")
    @Size(max = 50, message = "The length of model must be between 5 and 50 characters")
    private String model;

    private String title;
    private String slug;
    private BigDecimal purchaseOrderPrice;

    @NotBlank(message = "Description is required")
    @Size(max = 50, message = "The length of description must be between 5 and 50 characters")
    private String description;

    private String configurationDetail;

    private EBussinessStatus businessStatus;

    private String blogId;

    private String fileName;

    private String fileFolder;

    private String fileUrl;

    private String cloudId;

    private String fileProductId;

    private List<MultipartFile> files;

    private MultipartFile file;

    private String fileType;

    public ProductDTO(String id, String title, BigDecimal purchaseOrderPrice, String description) {
        this.id = id;
        this.title = title;
        this.purchaseOrderPrice = purchaseOrderPrice;
        this.description = description;
    }

    public Product toProduct() {
        return new Product()
                .setId(id)
                .setBrand(brand)
                .setModel(model)
                .setTitle(title)
                .setSlug(slug)
                .setPurchaseOrderPrice(purchaseOrderPrice)
                .setDescription(description)
                .setConfigurationDetail(JsonToMapConverter.convertToDatabaseColumn(configurationDetail))
                .setBusinessStatus(businessStatus);
    }

    public ProductMedia toProductMedia(Product product) {
        return new ProductMedia()
                .setId(fileProductId)
                .setFileName(fileName)
                .setFileFolder(fileFolder)
                .setFileUrl(fileUrl)
                .setCloudId(cloudId)
                .setFileType(fileType)
                .setProduct(product);
    }
}
