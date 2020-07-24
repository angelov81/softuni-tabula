package bg.softuni.tabula.common.validators;

import java.time.LocalDateTime;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FutureValidator implements ConstraintValidator<Future, LocalDateTime> {
  @Override
  public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
    return value != null &&
        value.isAfter(LocalDateTime.now());
  }
}
