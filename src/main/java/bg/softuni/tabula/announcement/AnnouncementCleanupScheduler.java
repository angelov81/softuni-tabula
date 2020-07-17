package bg.softuni.tabula.announcement;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AnnouncementCleanupScheduler {

  private AnnouncementService announcementService;

  //cleans up old announcements.
  @Scheduled(cron = "${tabula.clean-up}")
  public void cleanUpOldAnnouncements() {
    announcementService.cleanUpOldAnnouncements();
  }
}
