package org.example.state.game;

import org.example.service.GameService;
import org.example.state.game.event.GameEvent;
import org.example.state.turn.TurnStateMachine;

public class GameStateMachine {

  private GameStateContext context;
  private GameState currentState;
  private GameService gameService;

  private TurnStateMachine turnStateMachine;

  public GameStateMachine(GameService gameService) {
    this.context = new GameStateContext();
    this.currentState = new GameIdleState(context);
    this.gameService = gameService;

    this.turnStateMachine = new TurnStateMachine();
  }

  public GameState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(GameState state) {
    this.currentState = state;
  }

  public void handleEvent(GameEvent event) {
    currentState.handleEvent(event);
  }

}