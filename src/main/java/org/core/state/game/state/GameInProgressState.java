package org.core.state.game.state;

import org.core.state.game.GameStateContext;
import org.core.state.game.GameStateManager;
import org.core.state.game.event.GameOverEvent;

public class GameInProgressState extends GameState {

  public GameInProgressState(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(GameOverEvent event) {
    // Transition to the GameEndState
    stateManager.setCurrentState(new GameOverState(context, stateManager));
  }

}