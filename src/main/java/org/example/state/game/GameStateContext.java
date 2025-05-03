package org.example.state.game;

public class GameStateContext {

  private GameState currentState;

  public GameStateContext() {
    this.currentState = new GameIdleState(this);
  }

  public GameState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(GameState state) {
    this.currentState = state;
  }
}