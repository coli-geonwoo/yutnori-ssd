package org.example.state.turn;

import org.example.state.turn.event.TurnKillOtherEvent;
import org.example.state.turn.event.TurnNextTurnEvent;
import org.example.state.turn.event.TurnTakeMyPiecesEvent;

public class TurnMovedPieceState extends TurnState {

  public TurnMovedPieceState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  @Override
  public void handleEvent(TurnKillOtherEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnIdleState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnTakeMyPiecesEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnIdleState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnNextTurnEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnIdleState(context, stateManager));
  }
}