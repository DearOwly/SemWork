package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.request.CreateRoomInspectionRequest;
import so.sonya.semwork.dto.response.RoomInspectionResponse;
import so.sonya.semwork.entity.RoomInspection;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING
)
public interface RoomInspectionMapper {
    @Mapping(source = "room.id", target = "roomId")
    RoomInspectionResponse toResponse(RoomInspection roomInspection);

    @Mapping(source = "roomId", target = "room.id")
    RoomInspection toEntity(CreateRoomInspectionRequest createRoomInspectionRequest);
}