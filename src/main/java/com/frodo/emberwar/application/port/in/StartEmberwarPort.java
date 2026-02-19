package com.frodo.emberwar.application.port.in;

import com.frodo.emberwar.domain.Game;
import com.frodo.emberwar.domain.Player;

/**
 * Input port for starting an Emberwar game for a given player.
 * Returns the full Game aggregate, including player and board.
 */
public interface StartEmberwarPort {
    Game startEmberwarGame(Player player);
}