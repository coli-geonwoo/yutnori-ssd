package org.example.state.game;

import org.example.state.game.event.GameOverEvent;

public class GameInProgressState extends GameState {

  public GameInProgressState(GameStateContext context, GameStateMachine machine) {
    super(context, machine);
  }

  @Override
  public void handleEvent(GameOverEvent event) {
    // Transition to the GameEndState
    machine.setCurrentState(new GameEndState(context, machine));
  }

}