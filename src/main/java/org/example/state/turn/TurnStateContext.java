package org.example.state.turn;

public class TurnStateContext {

  private TurnState currentState;

  public TurnStateContext() {
    this.currentState = new TurnIdleState(this);
  }

  public TurnState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(TurnState state) {
    this.currentState = state;
  }
}