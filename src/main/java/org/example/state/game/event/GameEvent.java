package org.example.state.game.event;

import org.example.state.game.GameState;

public abstract class GameEvent {

  public abstract void accept(GameState state);
}