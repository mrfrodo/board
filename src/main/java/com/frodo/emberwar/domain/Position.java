package com.frodo.emberwar.domain;

public record Position(int x, int y) {

    public static final int BOARD_SIZE = 10;

    public Position {
        if (x < 0 || x >= BOARD_SIZE) {
            throw new IllegalArgumentException("x out of bounds");
        }

        if (y < 0 || y >= BOARD_SIZE) {
            throw new IllegalArgumentException("y out of bounds");
        }
    }
}
