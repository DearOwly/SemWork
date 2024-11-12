package so.sonya.semwork.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import so.sonya.semwork.dto.request.CreateEventRequest;
import so.sonya.semwork.dto.response.EventResponse;
import so.sonya.semwork.entity.Event;
import so.sonya.semwork.entity.Student;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING
)
public interface EventMapper {
    @Mapping(target = "participantIds", expression = "java(participantsToParticipantIds(event.getParticipants()))")
    EventResponse toResponse(Event event);

    Event toEntity(CreateEventRequest createEventRequest);

    default List<UUID> participantsToParticipantIds(List<Student> participants) {
        return participants.stream().map(Student::getId).collect(Collectors.toList());
    }
}