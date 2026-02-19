package com.frodo.emberwar.infrastructure.rest;

import com.frodo.emberwar.application.port.in.StartEmberwarPort;
import com.frodo.emberwar.domain.Game;
import com.frodo.emberwar.domain.Player;
import com.frodo.emberwar.domain.PlayerId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/emberwar")
public class EmberwarRestController {

    private final StartEmberwarPort startEmberwarPort;

    public EmberwarRestController(StartEmberwarPort startEmberwarPort) {
        this.startEmberwarPort = startEmberwarPort;
    }

    @PostMapping("/start")
    public Game startGame(@RequestParam String playerName) {
        Player player = new Player(new PlayerId(UUID.randomUUID()), playerName, null);
        return startEmberwarPort.startEmberwarGame(player);
    }
}