package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.request.CreateAnnouncementRequest;
import so.sonya.semwork.dto.response.AnnouncementResponse;
import so.sonya.semwork.entity.Announcement;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING
)
public interface AnnouncementMapper {
    AnnouncementResponse toResponse(Announcement announcement);

    Announcement toEntity(CreateAnnouncementRequest createAnnouncementRequest);
}