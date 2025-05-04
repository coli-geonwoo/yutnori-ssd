package org.core.state.turn.event;

import org.core.dto.YutGenerationRequest;
import org.core.state.turn.state.TurnState;

public class TurnGenerateYutEvent extends TurnEvent {

  public final YutGenerationRequest request;

  public TurnGenerateYutEvent(YutGenerationRequest request) {
    this.request = request;
  }

  @Override
  public void accept(TurnState state) {
    state.handleEvent(this);
  }
}