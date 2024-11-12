package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.response.RoomResponse;
import so.sonya.semwork.entity.Room;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = GenderMapper.class
)
public interface RoomMapper {
    RoomResponse toResponse(Room room);
}