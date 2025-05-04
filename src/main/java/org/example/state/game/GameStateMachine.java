package org.example.state.game;

import org.example.service.GameService;
import org.example.state.StateMachine;
import org.example.state.game.event.GameEvent;

public class GameStateMachine extends
    StateMachine<GameState, GameStateContext, GameStateObserver, GameStateManager, GameEvent> {

  private GameStateContext context;
  private GameStateManager stateManager;
  private GameService gameService;

  public GameStateMachine(GameStateContext context, GameStateManager stateManager,
      GameService gameService) {
    super(context, stateManager);
    this.gameService = gameService;
  }

  public static GameStateMachine create(GameService gameService) {
    GameStateContext context = new GameStateContext();
    GameStateManager stateManager = new GameStateManager(context);
    return new GameStateMachine(context, stateManager, gameService);
  }
}