package org.example.state.game;

import org.example.state.game.event.GameStartEvent;

public class GameIdleState extends GameState {

  GameIdleState(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(GameStartEvent event) {
    // Transition to the GameStartState
    stateManager.setCurrentState(new GameInProgressState(context, stateManager));
  }
}