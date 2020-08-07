package bg.softuni.tabula.events.dto;

import bg.softuni.tabula.events.model.EventType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDTO {

  @NotBlank
  private String title;

  @NotBlank
  @Size(min=10, message = "The description should be more than 10 characters.")
  private String description;

  @NotNull
  private EventType eventType;

  @Future
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime eventTime;

  @JsonIgnore
  public Date getEventTimeAsDate() {
    if (getEventTime() == null) {
      return null;
    } else {
      return Date.from(getEventTime().atZone(ZoneId.systemDefault()).toInstant());
    }
  }
}
