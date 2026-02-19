package com.frodo.emberwar.infrastructure.persistence.jdbc;

import com.frodo.emberwar.application.port.out.GameRepository;
import com.frodo.emberwar.domain.Game;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.ObjectMapper;

@Repository
public class GameJdbcRepository implements GameRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public GameJdbcRepository(JdbcTemplate jdbcTemplate, ObjectMapper objectMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Game save(Game game) {
        try {
            // Convert tiles to JSON
            String tilesJson = objectMapper.writeValueAsString(game.board().tiles());
            String player = game.player().name();

            // Simple insert for H2
            jdbcTemplate.update(
                    "INSERT INTO game (id, player_name, tiles_json) VALUES (?, ?, ?)",
                    game.id().value().toString(), player, tilesJson
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize board tiles", e);
        }
        return game;
    }
}