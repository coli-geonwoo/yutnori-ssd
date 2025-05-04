package org.example.state.game;

import org.example.service.GameService;
import org.example.state.StateMachine;
import org.example.state.game.event.GameEvent;

public class GameStateMachine extends
    StateMachine<GameState, GameStateContext, GameStateObserver, GameStateManager, GameEvent> {

  private GameStateContext context;
  private GameStateManager stateManager;
  private GameService gameService;

  public GameStateMachine(GameService gameService) {
    this.context = new GameStateContext();
    this.stateManager = new GameStateManager(context);
    this.gameService = gameService;
  }
}