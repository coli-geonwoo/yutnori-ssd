package org.example.state.turn;

import org.example.service.GameService;
import org.example.state.StateMachine;
import org.example.state.game.GameStateMachine;
import org.example.state.turn.event.TurnEvent;

public class TurnStateMachine extends
    StateMachine<TurnState, TurnStateContext, TurnStateObserver, TurnStateManager, TurnEvent> {

  private TurnStateManager stateManager;
  private TurnStateContext context;

  public TurnStateMachine(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  public static TurnStateMachine create(GameService gameService,
      GameStateMachine gameStateMachine) {
    TurnStateContext context = new TurnStateContext(gameService, gameStateMachine);
    TurnStateManager stateManager = new TurnStateManager(context);
    return new TurnStateMachine(context, stateManager);
  }
}