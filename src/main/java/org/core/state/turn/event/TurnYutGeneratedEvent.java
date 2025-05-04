package org.core.state.turn.event;

import org.core.state.turn.state.TurnState;

public class TurnYutGeneratedEvent extends TurnEvent {

  @Override
  public void accept(TurnState state) {
    state.handleEvent(this);
  }
}