package so.sonya.semwork.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import so.sonya.semwork.dto.request.CreateRoomInspectionRequest;
import so.sonya.semwork.dto.response.RoomInspectionResponse;
import so.sonya.semwork.entity.RoomInspection;
import so.sonya.semwork.mapper.RoomInspectionMapper;
import so.sonya.semwork.repository.RoomInspectionRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RoomInspectionService {
    private final RoomInspectionMapper roomInspectionMapper;
    private final RoomInspectionRepository roomInspectionRepository;

    @Transactional(readOnly = true)
    public Page<RoomInspectionResponse> getAll(Pageable pageable) {
        return roomInspectionRepository
            .findAll(pageable)
            .map(roomInspectionMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public RoomInspectionResponse getById(UUID id) {
        return roomInspectionRepository
            .findById(id)
            .map(roomInspectionMapper::toResponse)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    @Transactional(rollbackFor = Exception.class)
    public RoomInspectionResponse create(CreateRoomInspectionRequest request) {
        RoomInspection roomInspection = roomInspectionMapper.toEntity(request);
        RoomInspection savedRoomInspection = roomInspectionRepository.save(roomInspection);
        return roomInspectionMapper.toResponse(savedRoomInspection);
    }
}
