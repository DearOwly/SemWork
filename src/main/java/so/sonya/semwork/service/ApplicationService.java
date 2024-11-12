package so.sonya.semwork.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import so.sonya.semwork.dto.request.CreateApplicationRequest;
import so.sonya.semwork.dto.response.ApplicationResponse;
import so.sonya.semwork.entity.Application;
import so.sonya.semwork.mapper.ApplicationMapper;
import so.sonya.semwork.repository.ApplicationRepository;
import so.sonya.semwork.repository.StudentRepository;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ApplicationService {
    private final ApplicationMapper applicationMapper;
    private final ApplicationRepository applicationRepository;
    private final StudentRepository studentRepository;

    public Page<ApplicationResponse> getAllByApplicantId(UUID applicantId, Pageable pageable) {
        return applicationRepository
            .findByApplicant_Id(applicantId, pageable)
            .map(applicationMapper::toResponse);
    }

    public ApplicationResponse getById(UUID id) {
        return applicationRepository
            .findById(id)
            .map(applicationMapper::toResponse)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    public ApplicationResponse create(CreateApplicationRequest request, UUID applicantId) {
        Application application = applicationMapper.toEntity(request);
        application.setDate(LocalDate.now());
        application.setApplicant(studentRepository.findById(applicantId).orElse(null));
        Application resultApplication = applicationRepository.save(application);
        return applicationMapper.toResponse(resultApplication);
    }
}
