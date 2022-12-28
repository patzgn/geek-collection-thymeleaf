package com.patzgn.geekcollection.domain.game;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    @Query("select g from Game g order by g.id desc")
    List<Game> findLatestById(Pageable page);
}
