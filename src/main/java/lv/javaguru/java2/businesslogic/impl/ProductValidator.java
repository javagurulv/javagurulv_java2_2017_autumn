package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.ValidationError;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

public interface ProductValidator {
    Optional<ValidationError> validate(String productTitle, String productDescription);
}

@Component
class ProductValidatorImpl implements ProductValidator {

    @Override
    public Optional<ValidationError> validate(String productTitle,
                                              String productDescription) {
        if (StringUtils.isEmpty(productTitle)) {
            return Optional.of(new ValidationError("title", "Must be not empty!"));
        }
        if (StringUtils.isEmpty(productDescription)) {
            return Optional.of(new ValidationError("description", "Must be not empty!"));
        }
        return Optional.empty();
    }

}