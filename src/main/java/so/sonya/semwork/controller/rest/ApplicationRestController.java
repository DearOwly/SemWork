package so.sonya.semwork.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import so.sonya.semwork.dto.request.CreateApplicationRequest;
import so.sonya.semwork.dto.response.ApplicationResponse;
import so.sonya.semwork.security.StudentDetails;
import so.sonya.semwork.service.ApplicationService;

import java.util.UUID;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
@SecurityRequirement(name = "httpbasic")
public class ApplicationRestController {
    private final ApplicationService applicationService;

    @GetMapping
    public PagedModel<ApplicationResponse> getAll(
        @ParameterObject
        Pageable pageable,

        @AuthenticationPrincipal
        StudentDetails studentDetails
    ) {
        return new PagedModel<>(applicationService.getAllByApplicantId(studentDetails.getId(), pageable));
    }

    @GetMapping("/{id}")
    public ApplicationResponse getById(
        @PathVariable
        UUID id
    ) {
        return applicationService.getById(id);
    }

    @PostMapping
    public ApplicationResponse create(
        @RequestBody
        @Valid
        CreateApplicationRequest request,

        @AuthenticationPrincipal
        StudentDetails studentDetails
    ) {
        return applicationService.create(request, studentDetails.getId());
    }
}
