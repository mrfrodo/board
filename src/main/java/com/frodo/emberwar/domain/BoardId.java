package com.frodo.emberwar.domain;

import java.util.UUID;

/**
 * Strongly-typed identifier for a {@link Board}.
 *
 * @param value the underlying UUID, must not be null
 */
public record BoardId(UUID value) {}