package bg.softuni.tabula.events.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarDayDTO {

  private int day;
  private boolean empty;
  private List<EventDTO> events;

  public List<EventDTO> getEvents() {
    return events == null ? Collections.emptyList() : events;
  }

  public static CalendarDayDTO ofEmpty(){
    CalendarDayDTO calendarDayDTO = new CalendarDayDTO();
    calendarDayDTO.setDay(0);
    calendarDayDTO.setEmpty(true);
    return calendarDayDTO;
  }

  public static CalendarDayDTO ofDay(int day){
    CalendarDayDTO calendarDayDTO = new CalendarDayDTO();
    calendarDayDTO.setDay(day);
    calendarDayDTO.setEmpty(false);
    return calendarDayDTO;
  }
}
