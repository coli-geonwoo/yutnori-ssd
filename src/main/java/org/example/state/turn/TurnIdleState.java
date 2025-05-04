package org.example.state.turn;

import org.example.state.turn.event.TurnGenerateYutEvent;

public class TurnIdleState extends TurnState {

  public TurnIdleState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(TurnGenerateYutEvent event) {
    // Transition to the TurnYutGeneratedState
    stateManager.setCurrentState(new TurnYutGeneratedState(context, stateManager));
  }

}