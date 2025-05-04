package org.example.state.turn;

import org.example.state.turn.event.TurnMovePieceEvent;

public class TurnYutGeneratedState extends TurnState {

  public TurnYutGeneratedState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(TurnMovePieceEvent event) {
    // Transition to the TurnMovedPieceState
    stateManager.setCurrentState(new TurnMovedPieceState(context, stateManager));
  }
}