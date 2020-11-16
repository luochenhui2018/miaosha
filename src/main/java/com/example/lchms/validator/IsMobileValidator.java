package com.example.lchms.validator;

import com.example.lchms.util.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author kuangfeng
 * @date 2020-11-04 14:37
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {
    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidatorUtil.isMobile(value);

        }
        else {
            if (StringUtils.isEmpty(value)){
                return true;
            }
            else {
                return ValidatorUtil.isMobile(value);

            }
        }
    }
}
