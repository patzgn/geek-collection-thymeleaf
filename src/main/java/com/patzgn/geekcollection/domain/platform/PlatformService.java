package com.patzgn.geekcollection.domain.platform;

import com.patzgn.geekcollection.domain.platform.dto.PlatformDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PlatformService {
    private final PlatformRepository platformRepository;

    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    public List<PlatformDto> findAllPlatforms() {
        return StreamSupport.stream(platformRepository.findAll().spliterator(), false)
                .map(PlatformDtoMapper::map)
                .toList();
    }
}
