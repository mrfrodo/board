package com.frodo.emberwar.domain;

import java.util.List;
import java.util.UUID;

public record Board(BoardId id, int width, int height, List<Tile> tiles) {

    public static Board initializeEmptyBoard(int width, int height) {
        List<Tile> tiles = new java.util.ArrayList<>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles.add(new Tile(new Position(x, y), createRandomTileType()));
            }
        }
        return new Board(new BoardId(UUID.randomUUID()), width, height, tiles);
    }

    private static TileType createRandomTileType() {
        TileType[] types = TileType.values();
        int index = (int) (Math.random() * types.length);
        return types[index];
    }

    public Tile getTileAt(int x, int y) {
        return tiles.stream()
                .filter(t -> t.position().x() == x && t.position().y() == y)
                .findFirst()
                .orElse(null);
    }
}