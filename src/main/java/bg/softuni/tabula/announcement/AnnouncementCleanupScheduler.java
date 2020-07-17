package bg.softuni.tabula.announcement;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AnnouncementCleanupScheduler {

  private AnnouncementService announcementService;

  //cleans up old announcements.
  @Scheduled(cron = "0 0 2 ? * SUN")
  public void cleanUpOldAnnouncements() {
    announcementService.cleanUpOldAnnouncements();
  }

}
