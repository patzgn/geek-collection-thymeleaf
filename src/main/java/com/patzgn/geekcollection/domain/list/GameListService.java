package com.patzgn.geekcollection.domain.list;

import com.patzgn.geekcollection.domain.list.dto.GameListDto;
import com.patzgn.geekcollection.domain.user.User;
import com.patzgn.geekcollection.domain.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class GameListService {
    private final UserRepository userRepository;
    private final GameListRepository gameListRepository;

    public GameListService(UserRepository userRepository, GameListRepository gameListRepository) {
        this.userRepository = userRepository;
        this.gameListRepository = gameListRepository;
    }

    public Optional<GameListDto> findGameListByUsernameAndName(String username, String name) {
        return gameListRepository.findByUser_NameAndNameIgnoreCase(username, name)
                .map(GameListDtoMapper::map);
    }

}
