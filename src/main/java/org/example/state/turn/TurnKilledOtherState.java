package org.example.state.turn;

import org.example.state.turn.event.TurnNextTurnEvent;

public class TurnKilledOtherState extends TurnState {

  public TurnKilledOtherState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(TurnNextTurnEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnIdleState(context, stateManager));
  }
}