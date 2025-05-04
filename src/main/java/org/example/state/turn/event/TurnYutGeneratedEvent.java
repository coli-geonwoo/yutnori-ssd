package org.example.state.turn.event;

import org.example.state.turn.TurnState;

public class TurnYutGeneratedEvent extends TurnEvent {

  @Override
  public void accept(TurnState state) {
    state.handleEvent(this);
  }
}