package org.example.state.game;

import org.example.state.game.event.GameStartEvent;

public class GameIdleState extends GameState {

  GameIdleState(GameStateContext context) {
    super(context);
  }

  @Override
  public void handleEvent(GameStartEvent event) {
    // Transition to the GameStartState
    context.setCurrentState(new GameInProgressState(context));
  }
}