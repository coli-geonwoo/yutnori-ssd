package org.example.state.game;

import org.example.state.game.event.GameStartEvent;

public class GameIdleState extends GameState {

  GameIdleState(GameStateContext context, GameStateMachine machine) {
    super(context, machine);
  }

  @Override
  public void handleEvent(GameStartEvent event) {
    // Transition to the GameStartState
    machine.setCurrentState(new GameInProgressState(context, machine));
  }
}