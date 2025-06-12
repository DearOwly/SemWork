package so.sonya.semwork.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import so.sonya.semwork.dto.request.CreateEventRequest;
import so.sonya.semwork.dto.response.EventResponse;
import so.sonya.semwork.security.StudentDetails;
import so.sonya.semwork.service.EventService;

import java.util.UUID;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@SecurityRequirement(name = "httpbasic")
public class EventRestController {
    private final EventService eventService;

    @GetMapping
    public PagedModel<EventResponse> getAll(@ParameterObject Pageable pageable) {
        return new PagedModel<>(eventService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public EventResponse getById(@PathVariable UUID id) {
        return eventService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasPermission(null, 'Event', 'write')")
    public EventResponse create(@RequestBody @Valid CreateEventRequest request) {
        return eventService.create(request);
    }

    @PostMapping("/{id}/signUp")
    public void signUpToEvent(@PathVariable UUID id, StudentDetails studentDetails) {
        eventService.signUpToEvent(id, studentDetails.getId());
    }
}
