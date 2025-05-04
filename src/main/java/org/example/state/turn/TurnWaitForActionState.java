package org.example.state.turn;

import org.example.state.turn.event.TurnKillOtherEvent;
import org.example.state.turn.event.TurnMovePieceEvent;
import org.example.state.turn.event.TurnTakeMyPiecesEvent;

public class TurnWaitForActionState extends TurnState {

  public TurnWaitForActionState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(TurnMovePieceEvent event) {
    // Transition to the TurnMovedPieceState
    stateManager.setCurrentState(new TurnMovedPieceState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnTakeMyPiecesEvent event) {
    // Transition to the TurnMovedPieceState
    stateManager.setCurrentState(new TurnTookPieceState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnKillOtherEvent event) {
    // Transition to the TurnMovedPieceState
    stateManager.setCurrentState(new TurnKilledOtherState(context, stateManager));
  }
}