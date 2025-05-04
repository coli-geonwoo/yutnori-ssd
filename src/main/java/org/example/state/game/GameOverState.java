package org.example.state.game;

import org.example.state.game.event.GameExitEvent;
import org.example.state.game.event.GameRestartEvent;

public class GameOverState extends GameState {

  public GameOverState(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(GameRestartEvent event) {
    // Transition to the GameIdleState
    stateManager.setCurrentState(new GameIdleState(context, stateManager));
  }

  @Override
  public void handleEvent(GameExitEvent event) {
    //
  }
}