package com.frodo.emberwar.application.port.out;

import com.frodo.emberwar.domain.Board;

public interface BoardRepository {
    Board save(Board board);
}