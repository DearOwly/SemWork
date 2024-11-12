package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.response.GenderResponse;
import so.sonya.semwork.entity.Gender;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING
)
public interface GenderMapper {
    default GenderResponse toResponse(Gender gender) {
        return new GenderResponse(gender.toString(), gender.getDisplay());
    }
}
