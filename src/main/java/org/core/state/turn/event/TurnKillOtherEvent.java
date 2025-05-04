package org.core.state.turn.event;

import org.core.state.turn.state.TurnState;

public class TurnKillOtherEvent extends TurnEvent {

  public final String pieceId;

  public TurnKillOtherEvent(String pieceId) {
    this.pieceId = pieceId;
  }

  @Override
  public void accept(TurnState state) {
    state.handleEvent(this);
  }
}