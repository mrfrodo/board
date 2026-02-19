package com.frodo.emberwar.domain;

/**
 * Represents the single player controlling the game.
 * For now, each player controls exactly one unit.
 */
public record Player(PlayerId id, String name, Unit unit) {}