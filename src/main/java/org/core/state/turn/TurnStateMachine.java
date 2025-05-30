package org.core.state.turn;

import org.core.state.StateMachine;
import org.core.state.game.GameStateMachine;
import org.core.state.turn.event.TurnEvent;
import org.core.state.turn.state.TurnState;

public class TurnStateMachine extends
    StateMachine<TurnState, TurnStateContext, TurnStateObserver, TurnStateManager, TurnEvent> {

  public TurnStateMachine(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  public static TurnStateMachine create(GameStateMachine gameStateMachine) {
    TurnStateContext context = new TurnStateContext(gameStateMachine);
    TurnStateManager stateManager = new TurnStateManager(context);
    return new TurnStateMachine(context, stateManager);
  }
}