package com.patzgn.geekcollection.domain.usergame;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserGameRepository extends JpaRepository<UserGame, Long> {

    Page<UserGame> findAllByUser_Name(String name, Pageable pageable);

}

