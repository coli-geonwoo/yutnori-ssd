package org.example.state.turn;

import org.example.state.turn.event.TurnMovePieceEvent;

public class TurnYutGeneratedState extends TurnState {

  public TurnYutGeneratedState(TurnStateContext context, TurnStateMachine machine) {
    super(context, machine);
  }

  @Override
  public void handleEvent(TurnMovePieceEvent event) {
    // Transition to the TurnMovedPieceState
    context.setCurrentState(new TurnMovedPieceState(context));
  }
}