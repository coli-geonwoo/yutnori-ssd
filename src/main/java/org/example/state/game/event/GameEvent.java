package org.example.state.game.event;

import org.example.state.StateEvent;
import org.example.state.game.GameState;

public abstract class GameEvent implements StateEvent<GameState> {

  public abstract void accept(GameState state);
}