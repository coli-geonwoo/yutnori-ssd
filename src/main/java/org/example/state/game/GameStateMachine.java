package org.example.state.game;

import org.example.state.StateMachine;
import org.example.state.game.event.GameEvent;

public class GameStateMachine extends
    StateMachine<GameState, GameStateContext, GameStateObserver, GameStateManager, GameEvent> {

  private GameStateContext context;
  private GameStateManager stateManager;

  public GameStateMachine(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  public static GameStateMachine create() {
    GameStateContext context = new GameStateContext();
    GameStateManager stateManager = new GameStateManager(context);
    return new GameStateMachine(context, stateManager);
  }
}