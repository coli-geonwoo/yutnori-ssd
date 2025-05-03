package org.example.state.turn;

public class TurnStateMachine {

  private TurnState currentState;
  private TurnStateContext context;

  public TurnStateMachine() {
    this.context = new TurnStateContext();
    this.currentState = new TurnIdleState(context);
  }

  public TurnState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(TurnState state) {
    this.currentState = state;
  }

}