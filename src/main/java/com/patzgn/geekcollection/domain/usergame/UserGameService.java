package com.patzgn.geekcollection.domain.usergame;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserGameService {

    private UserGameRepository userGameRepository;

    public Page<UserGameDto> findAllUserGames(String username, Pageable pageable) {

        return userGameRepository.findAllByUser_Name(username, pageable)
                .map(UserGameMapper::toDto);
    }

}
