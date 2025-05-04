package org.core.state.turn.state;

import org.core.domain.yut.YutResult;
import org.core.state.turn.TurnStateContext;
import org.core.state.turn.TurnStateManager;
import org.core.state.turn.event.TurnRegenerateYutEvent;
import org.core.state.turn.event.TurnStartActionEvent;

public class TurnGeneratedState extends TurnState {

  public TurnGeneratedState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  public void onEnter() {
    // 최근에 생성된 것이 윷, 모일 경우
    if (context.lastYutResult() == YutResult.YUT ||
        context.lastYutResult() == YutResult.MO) {
      this.handleEvent(new TurnRegenerateYutEvent());
    } else {
      this.handleEvent(new TurnStartActionEvent());
    }
  }

  @Override
  public void handleEvent(TurnRegenerateYutEvent event) {
    stateManager.setCurrentState(new TurnRegeneratingState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnStartActionEvent event) {
    stateManager.setCurrentState(new TurnWaitForActionState(context, stateManager));
  }
}