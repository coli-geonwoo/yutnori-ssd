package org.core.state.turn.state;

import org.core.state.turn.TurnStateContext;
import org.core.state.turn.TurnStateManager;
import org.core.state.turn.event.TurnNextActionEvent;
import org.core.state.turn.event.TurnNextTurnEvent;

public class TurnTookPieceState extends TurnState {

  public TurnTookPieceState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  public void onEnter() {
    // 남은 윷이 있을 경우
    if (context.hasYutResult()) {
      this.handleEvent(new TurnNextActionEvent());
    } else {
      this.handleEvent(new TurnNextTurnEvent());
    }
  }

  @Override
  public void handleEvent(TurnNextTurnEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnBeforeNextTurnState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnNextActionEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnWaitForActionState(context, stateManager));
  }
}