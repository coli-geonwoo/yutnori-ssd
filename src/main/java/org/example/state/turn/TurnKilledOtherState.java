package org.example.state.turn;

import org.example.state.turn.event.TurnRegenerateYutEvent;

public class TurnKilledOtherState extends TurnState {

  public TurnKilledOtherState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);

    this.handleEvent(new TurnRegenerateYutEvent());
  }

  @Override
  public void handleEvent(TurnRegenerateYutEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnRegeneratingState(context, stateManager));
  }
}