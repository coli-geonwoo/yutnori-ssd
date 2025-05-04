package org.example.state.turn;

import org.example.state.turn.event.TurnKillOtherEvent;
import org.example.state.turn.event.TurnNextTurnEvent;

public class TurnMovedPieceState extends TurnState {

  public TurnMovedPieceState(TurnStateContext context, TurnStateMachine machine) {
    super(context, machine);
  }

  @Override
  public void handleEvent(TurnKillOtherEvent event) {
    // Transition to the TurnIdleState
    context.setCurrentState(new TurnIdleState(context, machine));
  }

  @Override
  public void handleEvent(TurnNextTurnEvent event) {
    // Transition to the TurnIdleState
    context.setCurrentState(new TurnIdleState(context, machine));
  }
}