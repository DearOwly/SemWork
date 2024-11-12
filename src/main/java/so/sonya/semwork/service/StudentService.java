package so.sonya.semwork.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import so.sonya.semwork.dto.request.CreateStudentRequest;
import so.sonya.semwork.dto.response.StudentResponse;
import so.sonya.semwork.entity.Student;
import so.sonya.semwork.mapper.StudentMapper;
import so.sonya.semwork.repository.StudentRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public Page<StudentResponse> getAll(Pageable pageable) {
        return studentRepository
            .findAll(pageable)
            .map(studentMapper::toResponse)
            .map(studentResponse -> {
                studentResponse.setPoints(studentRepository.getPointsById(studentResponse.getId()));
                return studentResponse;
            });
    }

    @Transactional(readOnly = true)
    public StudentResponse getById(UUID id) {
        return studentRepository
            .findById(id)
            .map(studentMapper::toResponse)
            .map(studentResponse -> {
                studentResponse.setPoints(studentRepository.getPointsById(studentResponse.getId()));
                return studentResponse;
            })
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    @Transactional(rollbackFor = Exception.class)
    public StudentResponse create(CreateStudentRequest request) {
        Student student = studentMapper.toEntity(request);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponse(savedStudent);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(UUID id) {
        studentRepository.deleteById(id);
    }
}
