package bg.softuni.tabula.registration.model;

import bg.softuni.tabula.common.validators.FieldMatch;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldMatch(first = "password",
    second = "repeatPassword",
    message = "The passwords do not match")
public class RegistrationDTO {

  @Email
  @NotBlank
  private String email;

  @NotBlank
  private String password;

  @NotBlank
  private String repeatPassword;
}
