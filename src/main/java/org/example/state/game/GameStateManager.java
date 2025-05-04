package org.example.state.game;

import org.example.state.StateManager;

public class GameStateManager extends StateManager<GameState, GameStateObserver> {

  public GameStateManager(GameStateContext context) {
    this.currentState = new GameIdleState(context, this);
  }

}