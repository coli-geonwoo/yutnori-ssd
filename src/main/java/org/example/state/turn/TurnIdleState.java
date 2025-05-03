package org.example.state.turn;

import org.example.state.turn.event.TurnGenerateYutEvent;

public class TurnIdleState extends TurnState {

  public TurnIdleState(TurnStateContext context) {
    super(context);
  }

  @Override
  public void handleEvent(TurnGenerateYutEvent event) {
    // Transition to the TurnYutGeneratedState
    context.setCurrentState(new TurnYutGeneratedState(context));
  }

}