package org.example.state.turn;

import org.example.state.game.event.GameOverEvent;
import org.example.state.turn.event.TurnGenerateYutEvent;

public class TurnIdleState extends TurnState {

  public TurnIdleState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);

    if (context.gameService.isEndGame()) {
      context.gameStateMachine.dispatchEvent(new GameOverEvent());
    }
  }

  @Override
  public void handleEvent(TurnGenerateYutEvent event) {
    stateManager.setCurrentState(new TurnGeneratedState(context, stateManager));
  }

}