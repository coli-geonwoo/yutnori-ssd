package org.example.state.turn;

import org.example.state.StateMachine;
import org.example.state.turn.event.TurnEvent;

public class TurnStateMachine extends
    StateMachine<TurnState, TurnStateContext, TurnStateObserver, TurnStateManager, TurnEvent> {

  private TurnStateManager stateManager;
  private TurnStateContext context;

  public TurnStateMachine() {
    this.context = new TurnStateContext();
    this.stateManager = new TurnStateManager(context);
  }
}