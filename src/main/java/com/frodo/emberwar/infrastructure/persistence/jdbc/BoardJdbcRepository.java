package com.frodo.emberwar.infrastructure.persistence.jdbc;

import com.frodo.emberwar.application.port.out.BoardRepository;
import com.frodo.emberwar.domain.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tools.jackson.databind.ObjectMapper;

@Repository
public class BoardJdbcRepository implements BoardRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public BoardJdbcRepository(JdbcTemplate jdbcTemplate, ObjectMapper objectMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Board save(Board board) {
        try {
            // Convert squares to JSON
            String squaresJson = objectMapper.writeValueAsString(board.tiles());

            // Simple insert for POC; replace with upsert as needed
            jdbcTemplate.update(
                    "INSERT INTO boards (id, squares_json) VALUES (?, ?) ON CONFLICT (id) DO UPDATE SET squares_json = ?",
                    board.id().value(), squaresJson, squaresJson
            );

        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize board squares", e);
        }
        return board;
    }
}