package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.response.StudentTypeResponse;
import so.sonya.semwork.entity.StudentType;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING
)
public interface StudentTypeMapper {
    default StudentTypeResponse toResponse(StudentType studentType) {
        return new StudentTypeResponse(studentType.toString(), studentType.getDisplay());
    }
}
