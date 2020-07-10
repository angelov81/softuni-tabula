package bg.softuni.tabula.announcement.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnnouncementDTO {

  private Long id;

  private Instant createdOn;

  private Instant updatedOn;

  @NotBlank
  private String title;

  @NotBlank
  @Size(min=10, message = "The descirption should be more than 10 characters.")
  private String description;

}
