package org.core.state.game.event;

import org.core.state.StateEvent;
import org.core.state.game.state.GameState;

public abstract class GameEvent implements StateEvent<GameState> {

  public abstract void accept(GameState state);
}