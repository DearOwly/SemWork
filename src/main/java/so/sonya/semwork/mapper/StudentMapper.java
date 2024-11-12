package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.request.CreateStudentRequest;
import so.sonya.semwork.dto.response.StudentResponse;
import so.sonya.semwork.entity.Student;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {
        GenderMapper.class,
        StudentTypeMapper.class
    }
)
public interface StudentMapper {
    @Mapping(source = "room.id", target = "roomId")
    StudentResponse toResponse(Student student);

    @Mapping(source = "roomId", target = "room.id")
    Student toEntity(CreateStudentRequest createStudentRequest);
}