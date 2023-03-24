package com.patzgn.geekcollection.domain.platform;

import com.patzgn.geekcollection.domain.platform.dto.PlatformDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/platforms")
@AllArgsConstructor
public class PlatformController {

    private final PlatformService platformService;

    @GetMapping
    List<PlatformDto> findAllPlatforms() {
        return platformService.findAllPlatforms();
    }

}
