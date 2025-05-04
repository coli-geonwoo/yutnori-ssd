package org.core.state.turn;

import org.core.state.StateManager;
import org.core.state.turn.state.TurnIdleState;
import org.core.state.turn.state.TurnState;

public class TurnStateManager extends StateManager<TurnState, TurnStateObserver> {

  public TurnStateManager(TurnStateContext context) {
    this.currentState = new TurnIdleState(context, this);
  }

}