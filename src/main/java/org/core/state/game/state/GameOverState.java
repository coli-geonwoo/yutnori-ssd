package org.core.state.game.state;

import org.core.state.game.GameStateContext;
import org.core.state.game.GameStateManager;
import org.core.state.game.event.GameRestartEvent;

public class GameOverState extends GameState {

  public GameOverState(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(GameRestartEvent event) {
    // Transition to the GameIdleState
    stateManager.setCurrentState(new GameIdleState(context, stateManager));
  }
}