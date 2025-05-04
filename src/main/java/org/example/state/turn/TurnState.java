package org.example.state.turn;

import org.example.state.turn.event.TurnGenerateYutEvent;
import org.example.state.turn.event.TurnKillOtherEvent;
import org.example.state.turn.event.TurnMovePieceEvent;
import org.example.state.turn.event.TurnNextTurnEvent;

public abstract class TurnState {

  protected TurnStateContext context;
  protected TurnStateMachine machine;

  public TurnState(TurnStateContext context, TurnStateMachine machine) {
    this.context = context;
    this.machine = machine;
  }

  public void handleEvent(TurnGenerateYutEvent event) {
  }

  public void handleEvent(TurnKillOtherEvent event) {
  }

  public void handleEvent(TurnMovePieceEvent event) {
  }

  public void handleEvent(TurnNextTurnEvent event) {
  }

}