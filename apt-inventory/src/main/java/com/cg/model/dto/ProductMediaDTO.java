package com.cg.model.dto;


import com.cg.model.ProductMedia;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductMediaDTO implements Validator {

    private String id;

    private String cloudId;

    private String fileFolder;

    private String fileName;

    private String fileType;

    private String fileUrl;

    private ProductDTO product;

    public ProductMedia toProductMedia() {
        return new ProductMedia()
                .setId(id)
                .setCloudId(cloudId)
                .setFileFolder(fileFolder)
                .setFileName(fileName)
                .setFileType(fileType)
                .setFileUrl(fileUrl)
                .setProduct(product.toProduct());
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
