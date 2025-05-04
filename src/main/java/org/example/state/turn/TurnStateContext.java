package org.example.state.turn;

import org.example.service.GameService;
import org.example.state.game.GameStateMachine;

public class TurnStateContext {

  public GameService gameService;
  public GameStateMachine gameStateMachine;

  public TurnStateContext(GameService gameService, GameStateMachine gameStateMachine) {
    this.gameService = gameService;
    this.gameStateMachine = gameStateMachine;
  }
}