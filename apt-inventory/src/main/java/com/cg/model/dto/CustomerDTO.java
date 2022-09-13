package com.cg.model.dto;

import com.cg.model.Comment;
import com.cg.model.Customer;
import com.cg.model.UserMedia;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CustomerDTO implements Validator {
    private String id;
    private String companyName;
    private String email;
    private String fullName;
    private String password;
    private String phone;
    private LocationRegionDTO locationRegion;
    private RoleDTO role;
    private UserMediaDTO userMedia;

    public Customer toCustomer() {
        return new Customer()
                .setId(id)
                .setCompanyName(companyName)
                .setEmail(email)
                .setPassword(password)
                .setRole(role.toRole())
                .setFullName(fullName)
                .setPhone(phone)
                .setLocationRegion(locationRegion.toLocationRegion())
                .setUserMedia(userMedia.toUserMedia());
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
