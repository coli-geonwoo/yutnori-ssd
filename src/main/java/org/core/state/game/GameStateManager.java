package org.core.state.game;

import org.core.state.StateManager;
import org.core.state.game.state.GameIdleState;
import org.core.state.game.state.GameState;

public class GameStateManager extends StateManager<GameState, GameStateObserver> {

  public GameStateManager(GameStateContext context) {
    this.currentState = new GameIdleState(context, this);
  }

}