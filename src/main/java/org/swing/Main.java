package org.swing;

import org.example.service.GameService;
import org.example.state.game.GameStateMachine;

public class Main {

  public static void main(String[] args) {
    GameService gameService = new GameService();
    GameStateMachine gameStateMachine = new GameStateMachine(gameService);
  }
}