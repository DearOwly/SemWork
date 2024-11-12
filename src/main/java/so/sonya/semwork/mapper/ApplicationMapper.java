package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.request.CreateApplicationRequest;
import so.sonya.semwork.dto.response.ApplicationResponse;
import so.sonya.semwork.entity.Application;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = ApplicationTypeMapper.class
)
public interface ApplicationMapper {
    @Mapping(source = "applicant.id", target = "applicantId")
    ApplicationResponse toResponse(Application application);

    Application toEntity(CreateApplicationRequest createApplicationRequest);
}