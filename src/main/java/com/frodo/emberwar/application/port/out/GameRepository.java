package com.frodo.emberwar.application.port.out;

import com.frodo.emberwar.domain.Game;

public interface GameRepository {
    Game save(Game game);
}