package org.example.state.turn.event;

import org.example.state.turn.TurnState;

public abstract class TurnEvent {

  public abstract void accept(TurnState state);

}