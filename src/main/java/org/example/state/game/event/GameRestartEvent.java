package org.example.state.game.event;

import org.example.state.game.GameState;

public class GameRestartEvent extends GameEvent {

  @Override
  public void accept(GameState state) {
    state.handleEvent(this);
  }
}