package org.core.state.turn.state;

import org.core.state.turn.TurnStateContext;
import org.core.state.turn.TurnStateManager;
import org.core.state.turn.event.TurnRegenerateYutEvent;

public class TurnKilledOtherState extends TurnState {

  public TurnKilledOtherState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  public void onEnter() {
    this.handleEvent(new TurnRegenerateYutEvent());
  }

  @Override
  public void handleEvent(TurnRegenerateYutEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnRegeneratingState(context, stateManager));
  }
}