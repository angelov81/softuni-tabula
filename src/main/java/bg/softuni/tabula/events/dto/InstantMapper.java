package bg.softuni.tabula.events.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class InstantMapper {

  public Instant asInstant(LocalDateTime localDateTime) {
    return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
  }

  public LocalDateTime asLocalDateTime(Instant instant) {
    return instant.
        atZone(ZoneId.systemDefault()).
        toLocalDateTime();
  }
}
