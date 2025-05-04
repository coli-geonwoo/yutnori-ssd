package org.core.state.turn.state;

import org.core.state.turn.TurnStateContext;
import org.core.state.turn.TurnStateManager;
import org.core.state.turn.event.TurnToIdleEvent;

public class TurnBeforeNextTurnState extends TurnState {

  public TurnBeforeNextTurnState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  public void onEnter() {
    context.turn.nextTurn();
    this.handleEvent(new TurnToIdleEvent());
  }

  @Override
  public void handleEvent(TurnToIdleEvent event) {
    stateManager.setCurrentState(new TurnIdleState(context, stateManager));
  }
}