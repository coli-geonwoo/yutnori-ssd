package org.core.state.game.state;

import org.core.state.game.GameStateContext;
import org.core.state.game.GameStateManager;
import org.core.state.game.event.GameStartEvent;

public class GameIdleState extends GameState {

  public GameIdleState(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(GameStartEvent event) {
    // Transition to the GameStartState
    stateManager.setCurrentState(new GameInProgressState(context, stateManager));
  }
}