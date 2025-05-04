package org.example.state.game;

import org.example.state.game.event.GameOverEvent;

public class GameInProgressState extends GameState {

  public GameInProgressState(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(GameOverEvent event) {
    // Transition to the GameEndState
    stateManager.setCurrentState(new GameEndState(context, stateManager));
  }

}