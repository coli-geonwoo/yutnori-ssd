package org.example.state.turn;

import org.example.state.turn.event.TurnGenerateYutEvent;

public class TurnRegeneratingState extends TurnState {

  public TurnRegeneratingState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(TurnGenerateYutEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnGeneratedState(context, stateManager));
  }
}