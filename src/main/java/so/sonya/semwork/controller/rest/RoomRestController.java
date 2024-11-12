package so.sonya.semwork.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import so.sonya.semwork.dto.response.RoomResponse;
import so.sonya.semwork.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
@SecurityRequirement(name = "httpbasic")
public class RoomRestController {
    private final RoomService roomService;

    @GetMapping
    public PagedModel<RoomResponse> getAll(@ParameterObject Pageable pageable) {
        return new PagedModel<>(roomService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public RoomResponse getById(@PathVariable Short id) {
        return roomService.getById(id);
    }
}
