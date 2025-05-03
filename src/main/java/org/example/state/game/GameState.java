package org.example.state.game;

import org.example.state.game.event.GameExitEvent;
import org.example.state.game.event.GameOverEvent;
import org.example.state.game.event.GameRestartEvent;
import org.example.state.game.event.GameStartEvent;

public abstract class GameState {

  protected GameStateContext context;

  public GameState(GameStateContext context) {
    this.context = context;
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