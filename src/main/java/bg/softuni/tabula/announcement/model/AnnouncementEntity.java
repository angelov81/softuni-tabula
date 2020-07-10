package bg.softuni.tabula.announcement.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="announcements")
public class AnnouncementEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column
  private Instant createdOn;

  @NotNull
  @Column
  private Instant updatedOn;

  @NotNull
  @Column
  private String title;

  @NotNull
  @Column
  private String description;
}
