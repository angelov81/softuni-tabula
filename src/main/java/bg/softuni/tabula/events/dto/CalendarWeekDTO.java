package bg.softuni.tabula.events.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarWeekDTO {

  private List<CalendarDayDTO> days;

  public List<CalendarDayDTO> getDays() {
    return days == null ? Collections.emptyList() : days;
  }

  public void addDay(CalendarDayDTO calendarDayDTO) {
    if (days == null) {
      days = new ArrayList<>();
    }
    days.add(calendarDayDTO);
  }
}
