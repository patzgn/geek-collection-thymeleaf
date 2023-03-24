package com.patzgn.geekcollection.domain.game;

import com.patzgn.geekcollection.domain.game.dto.GameDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/games")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @CrossOrigin
    @GetMapping
    Page<GameDto> findAllGames(Pageable pageable) {
        return gameService.findAllGames(pageable);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    ResponseEntity<GameDto> findGameById(@PathVariable Long id) {
        return gameService.findGameById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
