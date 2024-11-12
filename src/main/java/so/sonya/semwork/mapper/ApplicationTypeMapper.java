package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.response.ApplicationTypeResponse;
import so.sonya.semwork.dto.response.StudentTypeResponse;
import so.sonya.semwork.entity.ApplicationType;
import so.sonya.semwork.entity.StudentType;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING
)
public interface ApplicationTypeMapper {
    default ApplicationTypeResponse toResponse(ApplicationType applicationType) {
        return new ApplicationTypeResponse(applicationType.toString(), applicationType.getDisplay());
    }
}
