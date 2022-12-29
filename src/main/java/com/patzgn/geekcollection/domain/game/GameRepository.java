package com.patzgn.geekcollection.domain.game;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("select g from Game g order by g.id desc")
    List<Game> findLatestById(Pageable page);
}
