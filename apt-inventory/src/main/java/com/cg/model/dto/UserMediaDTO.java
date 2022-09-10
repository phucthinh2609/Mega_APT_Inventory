package com.cg.model.dto;



import com.cg.model.Employee;
import com.cg.model.UserMedia;
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
public class UserMediaDTO implements Validator {

    private String id;
    private String cloudId;
    private String fileFolder;
    private String fileName;
    private String fileType;
    private String fileUrl;
    public UserMedia toUserMedia() {
        return new UserMedia()
                .setId(id)
                .setFileName(fileName)
                .setFileFolder(fileFolder)
                .setFileUrl(fileUrl)
                .setFileType(fileType)
                .setCloudId(cloudId);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
