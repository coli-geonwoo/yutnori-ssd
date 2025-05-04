package org.core.state.turn.event;

import org.core.state.StateEvent;
import org.core.state.turn.state.TurnState;

public abstract class TurnEvent implements StateEvent<TurnState> {

  public abstract void accept(TurnState state);

}