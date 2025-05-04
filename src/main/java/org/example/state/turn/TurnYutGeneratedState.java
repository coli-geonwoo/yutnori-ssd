package org.example.state.turn;

import org.example.state.turn.event.TurnMovePieceEvent;
import org.example.state.turn.event.TurnRegenerateYutEvent;

public class TurnYutGeneratedState extends TurnState {

  public TurnYutGeneratedState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(TurnMovePieceEvent event) {
    // Transition to the TurnMovedPieceState
    stateManager.setCurrentState(new TurnMovedPieceState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnRegenerateYutEvent event) {
    // Transition to the TurnMovedPieceState
    stateManager.setCurrentState(new TurnIdleState(context, stateManager));
  }
}