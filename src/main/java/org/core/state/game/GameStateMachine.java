package org.core.state.game;

import org.core.dto.GameInitializeDto;
import org.core.state.StateMachine;
import org.core.state.game.event.GameEvent;
import org.core.state.game.state.GameState;

public class GameStateMachine extends
    StateMachine<GameState, GameStateContext, GameStateObserver, GameStateManager, GameEvent> {


  public GameStateMachine(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  public static GameStateMachine create(GameInitializeDto initialDto) {
    GameStateContext context = new GameStateContext(initialDto);
    GameStateManager stateManager = new GameStateManager(context);
    return new GameStateMachine(context, stateManager);
  }

  public boolean isGameOver() {
    return context.scoreBoard.isEnd();
  }
}