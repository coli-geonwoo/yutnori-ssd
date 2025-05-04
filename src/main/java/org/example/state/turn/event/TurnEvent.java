package org.example.state.turn.event;

import org.example.state.StateEvent;
import org.example.state.turn.TurnState;

public abstract class TurnEvent implements StateEvent<TurnState> {

  public abstract void accept(TurnState state);

}