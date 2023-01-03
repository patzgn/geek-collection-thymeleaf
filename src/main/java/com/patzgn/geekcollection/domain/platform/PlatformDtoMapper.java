package com.patzgn.geekcollection.domain.platform;

import com.patzgn.geekcollection.domain.platform.dto.PlatformDto;

public class PlatformDtoMapper {
    static PlatformDto map(Platform platform) {
        return new PlatformDto(
                platform.getId(),
                platform.getName()
        );
    }
}
