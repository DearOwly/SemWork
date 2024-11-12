package so.sonya.semwork.service;

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
import so.sonya.semwork.mapper.EventMapper;
import so.sonya.semwork.repository.EventRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EventService {
    private final EventMapper eventMapper;
    private final EventRepository eventRepository;

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
}
