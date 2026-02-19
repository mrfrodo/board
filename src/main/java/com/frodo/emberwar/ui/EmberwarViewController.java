package com.frodo.emberwar.ui;

import com.frodo.emberwar.application.port.in.StartEmberwarPort;
import com.frodo.emberwar.domain.Game;
import com.frodo.emberwar.domain.Player;
import com.frodo.emberwar.domain.PlayerId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class EmberwarViewController {

    private final StartEmberwarPort startEmberwarPort;

    public EmberwarViewController(StartEmberwarPort startEmberwarPort) {
        this.startEmberwarPort = startEmberwarPort;
    }

    // Show the start form: templates/emberwar.html
    @GetMapping("/emberwar/ui")
    public String emberwarForm() {
        return "emberwar"; // Thymeleaf template with a simple start form
    }

    // Start the game and render the board: templates/emberwar-board.html
    @PostMapping("/emberwar/ui/start")
    public String startGame(@RequestParam String playerName, Model model) {
        Player player = new Player(new PlayerId(UUID.randomUUID()), playerName, null);
        Game game = startEmberwarPort.startEmberwarGame(player);

        model.addAttribute("game", game); // send game object to Thymeleaf template
        return "emberwar-board"; // resolves to emberwar-board.html
    }
}