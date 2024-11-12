package so.sonya.semwork.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import so.sonya.semwork.dto.request.CreateAnnouncementRequest;
import so.sonya.semwork.dto.response.AnnouncementResponse;
import so.sonya.semwork.entity.Announcement;
import so.sonya.semwork.mapper.AnnouncementMapper;
import so.sonya.semwork.repository.AnnouncementRepository;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AnnouncementService {
    private final AnnouncementMapper announcementMapper;
    private final AnnouncementRepository announcementRepository;

    @Transactional(readOnly = true)
    public Page<AnnouncementResponse> getAll(Pageable pageable) {
        return announcementRepository
            .findAll(pageable)
            .map(announcementMapper::toResponse);
    }

    @Transactional(readOnly = true)
    public AnnouncementResponse getById(UUID id) {
        return announcementRepository
            .findById(id)
            .map(announcementMapper::toResponse)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));
    }

    @Transactional(rollbackFor = Exception.class)
    public AnnouncementResponse create(CreateAnnouncementRequest request) {
        Announcement announcement = announcementMapper.toEntity(request);
        Announcement savedAnnouncement = announcementRepository.save(announcement);
        return announcementMapper.toResponse(savedAnnouncement);
    }
}
