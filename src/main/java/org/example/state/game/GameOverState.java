package org.example.state.game;

import org.example.state.game.event.GameExitEvent;
import org.example.state.game.event.GameRestartEvent;

public class GameOverState extends GameState {

  public GameOverState(GameStateContext context) {
    super(context);
  }

  @Override
  public void handleEvent(GameRestartEvent event) {
    // Transition to the GameIdleState
    context.setCurrentState(new GameIdleState(context));
  }

  @Override
  public void handleEvent(GameExitEvent event) {
    //
  }
}