package so.sonya.semwork.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import so.sonya.semwork.dto.request.CreateRoomInspectionRequest;
import so.sonya.semwork.dto.response.RoomInspectionResponse;
import so.sonya.semwork.service.RoomInspectionService;

import java.util.UUID;

@RestController
@RequestMapping("/api/roomInspections")
@RequiredArgsConstructor
@SecurityRequirement(name = "httpbasic")
public class RoomInspectionRestController {
    private final RoomInspectionService roomInspectionService;

    @GetMapping
    public PagedModel<RoomInspectionResponse> getAll(@ParameterObject Pageable pageable) {
        return new PagedModel<>(roomInspectionService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public RoomInspectionResponse getById(@PathVariable UUID id) {
        return roomInspectionService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasPermission(#request.roomId, 'RoomInspection', 'write')")
    public RoomInspectionResponse create(@RequestBody @Valid CreateRoomInspectionRequest request) {
        return roomInspectionService.create(request);
    }
}
