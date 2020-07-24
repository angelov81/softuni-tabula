package bg.softuni.tabula.registration.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

  private String firstFieldName;
  private String secondFieldName;
  private String message;

  @Override
  public void initialize(FieldMatch constraintAnnotation) {
    this.firstFieldName = constraintAnnotation.first();
    this.secondFieldName = constraintAnnotation.second();
    this.message = constraintAnnotation.message();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {

    BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
    Object firstValue = wrapper.getPropertyValue(firstFieldName);
    Object secondValue = wrapper.getPropertyValue(secondFieldName);

    boolean valid =
        (firstValue == null && secondValue == null) ||
            (firstValue != null && firstValue.equals(secondValue));

    if (!valid) {
      context.
          buildConstraintViolationWithTemplate(message).
          //TODO: check why cannot add two property nodes
          addPropertyNode(firstFieldName).
          addConstraintViolation().
          disableDefaultConstraintViolation();
    }

    return valid;
  }
}
