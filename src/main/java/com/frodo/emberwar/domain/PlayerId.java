package com.frodo.emberwar.domain;

import java.util.UUID;

/**
 * Strongly-typed identifier for a {@link Player}.
 *
 * @param value the underlying UUID, must not be null
 */
public record PlayerId(UUID value) {}