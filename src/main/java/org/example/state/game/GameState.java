package org.example.state.game;

import org.example.state.game.event.GameExitEvent;
import org.example.state.game.event.GameOverEvent;
import org.example.state.game.event.GameRestartEvent;
import org.example.state.game.event.GameStartEvent;

public abstract class GameState {

  protected GameStateContext context;
  protected GameStateMachine machine;

  public GameState(GameStateContext context, GameStateMachine machine) {
    this.context = context;
    this.machine = machine;
  }

  public void handleEvent(GameExitEvent event) {
  }

  public void handleEvent(GameOverEvent event) {
  }

  public void handleEvent(GameRestartEvent event) {
  }

  public void handleEvent(GameStartEvent event) {
  }

}