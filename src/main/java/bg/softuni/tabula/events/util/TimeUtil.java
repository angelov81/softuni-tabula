package bg.softuni.tabula.events.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class TimeUtil {

  public static LocalDateTime asLocal(Instant instant) {
    return instant.
        atZone(ZoneId.systemDefault()).
        toLocalDateTime();
  }

  public static int getDaysInMonth(YearMonth monthInYear) {
    return (int) ChronoUnit.DAYS.between(
        monthInYear.atDay(1),
        monthInYear.atDay(1).plusMonths(1));
  }

  public static int getFirstDayInWeek(YearMonth monthInYear) {
    return monthInYear.
        atDay(1).
        getDayOfWeek().
        getValue() - 1;
  }

}
