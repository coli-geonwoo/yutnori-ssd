package org.example.state.game;

import org.example.state.game.event.GameExitEvent;
import org.example.state.game.event.GameRestartEvent;

public class GameOverState extends GameState {

  public GameOverState(GameStateContext context, GameStateMachine machine) {
    super(context, machine);
  }

  @Override
  public void handleEvent(GameRestartEvent event) {
    // Transition to the GameIdleState
    machine.setCurrentState(new GameIdleState(context, machine));
  }

  @Override
  public void handleEvent(GameExitEvent event) {
    //
  }
}