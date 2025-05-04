package org.example.state.turn;

import org.example.state.turn.event.TurnRegenerateYutEvent;
import org.example.state.turn.event.TurnStartActionEvent;

public class TurnGeneratedState extends TurnState {

  public TurnGeneratedState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);

    // 최근에 생성된 것이 윷, 모일 경우
    if (true) {
      this.handleEvent(new TurnRegenerateYutEvent());
    }

    // 그게 아닐 경우
    if (false) {
      this.handleEvent(new TurnStartActionEvent());
    }
  }

  @Override
  public void handleEvent(TurnRegenerateYutEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnRegeneratingState(context, stateManager));
  }

  @Override
  public void handleEvent(TurnStartActionEvent event) {
    // Transition to the TurnIdleState
    stateManager.setCurrentState(new TurnWaitForActionState(context, stateManager));
  }
}