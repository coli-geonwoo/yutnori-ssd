package org.example.state.game;

import org.example.state.game.event.GameOverEvent;

public class GameInProgressState extends GameState {

  public GameInProgressState(GameStateContext context) {
    super(context);
  }

  @Override
  public void handleEvent(GameOverEvent event) {
    // Transition to the GameEndState
    context.setCurrentState(new GameEndState(context));
  }

}