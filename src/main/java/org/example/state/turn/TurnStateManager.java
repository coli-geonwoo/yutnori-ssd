package org.example.state.turn;

import org.example.state.StateManager;

public class TurnStateManager extends StateManager<TurnState, TurnStateObserver> {

  public TurnStateManager(TurnStateContext context) {
    this.currentState = new TurnIdleState(context, this);
  }

}