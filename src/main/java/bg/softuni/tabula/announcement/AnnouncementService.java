package bg.softuni.tabula.announcement;

import bg.softuni.tabula.announcement.model.AnnouncementDTO;
import bg.softuni.tabula.announcement.model.AnnouncementEntity;
import bg.softuni.tabula.announcement.model.AnnouncementMapper;
import bg.softuni.tabula.announcement.repository.AnnouncementRepository;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AnnouncementService {

  private final AnnouncementRepository announcementRepository;

  public List<AnnouncementDTO> findAll() {
    return announcementRepository.
        findAll().
        stream().
        map(AnnouncementMapper.INSTANCE::mapAnnouncementEntityToDto).
        collect(Collectors.toList());
  }

  public void cleanUpOldAnnouncements() {
    Instant endTime = Instant.now().minus(7, ChronoUnit.DAYS);
    announcementRepository.deleteByUpdatedOnBefore(endTime);
  }

  public void createOrUpdateAnnouncement(AnnouncementDTO announcementDTO) {
    AnnouncementEntity announcementEntity =
        AnnouncementMapper.INSTANCE.mapAnnouncementDtoToEntity(announcementDTO);

    if (announcementEntity.getCreatedOn() == null) {
      announcementEntity.setCreatedOn(Instant.now());
    }
    announcementEntity.setUpdatedOn(Instant.now());

    announcementRepository.save(announcementEntity);
  }

  public void delete(Long announcementId) {
    announcementRepository.deleteById(announcementId);
  }

}
