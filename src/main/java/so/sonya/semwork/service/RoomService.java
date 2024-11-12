package so.sonya.semwork.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import so.sonya.semwork.dto.response.RoomResponse;
import so.sonya.semwork.mapper.RoomMapper;
import so.sonya.semwork.repository.RoomRepository;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public Page<RoomResponse> getAll(Pageable pageable) {
        return roomRepository
            .findAll(pageable)
            .map(roomMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public RoomResponse getById(Short id) {
        return roomRepository
            .findById(id)
            .map(roomMapper::toResponse)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }
}
