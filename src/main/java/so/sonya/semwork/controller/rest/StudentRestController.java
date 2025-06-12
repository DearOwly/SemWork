package so.sonya.semwork.controller.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import so.sonya.semwork.dto.request.CreateStudentRequest;
import so.sonya.semwork.dto.response.StudentResponse;
import so.sonya.semwork.security.StudentDetails;
import so.sonya.semwork.service.StudentService;

import java.util.UUID;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@SecurityRequirement(name = "httpbasic")
public class StudentRestController {
    private final StudentService studentService;

    @GetMapping
    @PreAuthorize("hasPermission(null, 'Student', 'read')")
    public PagedModel<StudentResponse> getAll(@ParameterObject Pageable pageable) {
        return new PagedModel<>(studentService.getAll(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasPermission(null, 'Student', 'read')")
    public StudentResponse getById(@PathVariable UUID id) {
        return studentService.getById(id);
    }

    @GetMapping("/me")
    public StudentResponse getMe(@AuthenticationPrincipal StudentDetails studentDetails) {
        return studentService.getById(studentDetails.getId());
    }

    @PostMapping
    public StudentResponse create(@RequestBody @Valid CreateStudentRequest request) {
        return studentService.create(request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasPermission(null, 'Student', 'write')")
    public void deleteById(@PathVariable UUID id) {
        studentService.deleteById(id);
    }
}
