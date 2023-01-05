package com.patzgn.geekcollection.domain.list;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface GameListRepository extends CrudRepository<GameList, Long> {
    Optional<GameList> findByUser_NameAndNameIgnoreCase(String userName, String name);
}
