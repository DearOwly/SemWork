package so.sonya.semwork.service;

import com.sun.jdi.request.EventRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import so.sonya.semwork.dto.request.CreateEventRequest;
import so.sonya.semwork.dto.response.EventResponse;
import so.sonya.semwork.entity.Event;
import so.sonya.semwork.entity.Student;
import so.sonya.semwork.mapper.EventMapper;
import so.sonya.semwork.repository.EventRepository;
import so.sonya.semwork.repository.StudentRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EventService {
    private final EventMapper eventMapper;
    private final EventRepository eventRepository;
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public Page<EventResponse> getAll(Pageable pageable) {
        return eventRepository
            .findAll(pageable)
            .map(eventMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public EventResponse getById(UUID id) {
        return eventRepository
            .findById(id)
            .map(eventMapper::toResponse)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    @Transactional(rollbackFor = Exception.class)
    public EventResponse create(CreateEventRequest request) {
        Event event = eventMapper.toEntity(request);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toResponse(savedEvent);
    }

    @Transactional(rollbackFor = Exception.class)
    public void signUpToEvent(UUID eventId, UUID studentId) {
        Event event = eventRepository
                .findById(eventId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(eventId)));

        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(studentId)));

        event.getParticipants().add(student);
    }
}
