package com.patzgn.geekcollection.domain.platform;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlatformRepository extends CrudRepository<Platform, Long> {
    Optional<Platform> findByNameIgnoreCase(String name);
}
