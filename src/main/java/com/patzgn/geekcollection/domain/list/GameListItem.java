package com.patzgn.geekcollection.domain.list;

import com.patzgn.geekcollection.domain.game.Game;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
class GameListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

}
