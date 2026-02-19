package com.frodo.emberwar.application;

import com.frodo.emberwar.application.port.in.StartEmberwarPort;
import com.frodo.emberwar.application.port.out.GameRepository;
import com.frodo.emberwar.domain.Board;
import com.frodo.emberwar.domain.Game;
import com.frodo.emberwar.domain.GameId;
import com.frodo.emberwar.domain.Player;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.UUID;

@Service
public class StartEmberwarService implements StartEmberwarPort {

    private final GameRepository gameRepository;
    private final ObjectMapper objectMapper = new ObjectMapper(); // create locally

    public StartEmberwarService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game startEmberwarGame(Player player) {
        try {
            InputStream is = getClass().getResourceAsStream("/board.json");
            Board board;

            if (is == null) {
                board = Board.initializeEmptyBoard(10, 10);
            } else {
                // deserialize board from JSON
                board = objectMapper.readValue(is, Board.class);
            }

            // Create game
            Game game = new Game(new GameId(UUID.randomUUID()), player, board);

            // Persist and return
            return gameRepository.save(game);

        } catch (Exception e) {
            throw new RuntimeException("Failed to start game", e);
        }
    }
}
