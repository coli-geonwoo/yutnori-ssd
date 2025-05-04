package org.example.state.turn;

import org.example.state.turn.event.TurnNextActionEvent;
import org.example.state.turn.event.TurnNextTurnEvent;

public class TurnMovedPieceState extends TurnState {

  public TurnMovedPieceState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);

    // 남은 윷이 있을 경우
    if (true) {
      this.handleEvent(new TurnNextActionEvent());
    }

    // 남은 윷이 없을 경우
    if (false) {
      this.handleEvent(new TurnNextTurnEvent());
    }
  }

  @Override
  public void handleEvent(TurnNextTurnEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnIdleState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnNextActionEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnWaitForActionState(context, stateManager));
  }
}