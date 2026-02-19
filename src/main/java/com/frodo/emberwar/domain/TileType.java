package com.frodo.emberwar.domain;

public enum TileType {
    FOREST(2),    // movement cost = 2
    PLAINS(1),    // movement cost = 1
    MOUNTAIN(3);  // movement cost = 3

    private final int movementCost;

    TileType(int movementCost) {       // constructor for each enum constant
        this.movementCost = movementCost;
    }

    public int getMovementCost() {      // getter method
        return movementCost;
    }
}