package bg.softuni.tabula.events.model;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Table(name="events")
@Entity
public class EventEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @NotNull
  @Column(name="title")
  private String title;

  @NotNull
  @Column
  private String description;

  @NotNull
  @Column(name="event_type")
  @Enumerated(EnumType.STRING)
  private EventType eventType;

  @NotNull
  @Column
  private Instant occurrence;
}
