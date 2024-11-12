package so.sonya.semwork.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import so.sonya.semwork.dto.request.CreateAnnouncementRequest;
import so.sonya.semwork.dto.response.AnnouncementResponse;
import so.sonya.semwork.service.AnnouncementService;

import java.util.UUID;

@RestController
@RequestMapping("/api/announcements")
@RequiredArgsConstructor
@SecurityRequirement(name = "httpbasic")
public class AnnouncementRestController {
    private final AnnouncementService announcementService;

    @GetMapping
    public PagedModel<AnnouncementResponse> getAll(@ParameterObject Pageable pageable) {
        return new PagedModel<>(announcementService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public AnnouncementResponse getById(@PathVariable UUID id) {
        return announcementService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasPermission(null, 'Announcement', 'write')")
    public AnnouncementResponse create(@RequestBody @Valid CreateAnnouncementRequest request) {
        return announcementService.create(request);
    }
}
