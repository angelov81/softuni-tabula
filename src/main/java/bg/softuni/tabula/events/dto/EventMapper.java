package bg.softuni.tabula.events.dto;

import bg.softuni.tabula.events.model.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {InstantMapper.class})
public interface EventMapper {

  EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

  @Mapping(source = "eventTime", target = "occurrence")
  EventEntity mapDtoToEntity(EventDTO dto);

  @Mapping(source = "occurrence", target = "eventTime")
  EventDTO mapEntityToDto(EventEntity entity);

  EventDTO copy(EventDTO eventDTO);
}
