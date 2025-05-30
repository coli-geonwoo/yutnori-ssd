package org.core.state.game.event;

import org.core.state.game.state.GameState;

public class GameRestartEvent extends GameEvent {

  @Override
  public void accept(GameState state) {
    state.handleEvent(this);
  }
}