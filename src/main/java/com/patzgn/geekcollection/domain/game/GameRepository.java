package com.patzgn.geekcollection.domain.game;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    Page<Game> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);

    Page<Game> findByPlatforms_NameIgnoreCase(String name, Pageable pageable);

    Page<Game> findByPlatforms_NameIgnoreCaseAndTitleContainingIgnoreCase(String name, String keyword, Pageable pageable);

    @Query("select g from Game g order by g.id desc")
    List<Game> findLatestById(Pageable page);
}
