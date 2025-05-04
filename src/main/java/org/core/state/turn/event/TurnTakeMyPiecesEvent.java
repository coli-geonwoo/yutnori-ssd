package org.core.state.turn.event;

import org.core.state.turn.state.TurnState;

public class TurnTakeMyPiecesEvent extends TurnEvent {

  public final String pieceId;

  public TurnTakeMyPiecesEvent(String pieceId) {
    this.pieceId = pieceId;
  }

  @Override
  public void accept(TurnState state) {
    state.handleEvent(this);
  }
}