package org.core.state.turn.event;

import org.core.domain.yut.YutResult;
import org.core.state.turn.state.TurnState;

public class TurnMovePieceEvent extends TurnEvent {

  public final String pieceId;
  public final String placeId;
  public final YutResult yutResult;

  public TurnMovePieceEvent(String pieceId, String placeId, YutResult yutResult) {
    this.pieceId = pieceId;
    this.placeId = placeId;
    this.yutResult = yutResult;
  }

  @Override
  public void accept(TurnState state) {
    state.handleEvent(this);
  }
}