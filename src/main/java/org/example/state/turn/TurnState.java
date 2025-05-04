package org.example.state.turn;

import org.example.state.State;
import org.example.state.turn.event.TurnEvent;
import org.example.state.turn.event.TurnGenerateYutEvent;
import org.example.state.turn.event.TurnKillOtherEvent;
import org.example.state.turn.event.TurnMovePieceEvent;
import org.example.state.turn.event.TurnNextActionEvent;
import org.example.state.turn.event.TurnNextTurnEvent;
import org.example.state.turn.event.TurnRegenerateYutEvent;
import org.example.state.turn.event.TurnStartActionEvent;
import org.example.state.turn.event.TurnTakeMyPiecesEvent;
import org.example.state.turn.event.TurnYutGeneratedEvent;

public abstract class TurnState extends State<TurnStateContext, TurnStateManager, TurnEvent> {

  public TurnState(TurnStateContext context, TurnStateManager stateManager) {
    super(context, stateManager);
  }

  public void handleEvent(TurnYutGeneratedEvent event) {
  }

  public void handleEvent(TurnGenerateYutEvent event) {
  }

  public void handleEvent(TurnRegenerateYutEvent event) {
  }

  public void handleEvent(TurnStartActionEvent event) {
  }

  public void handleEvent(TurnKillOtherEvent event) {
  }

  public void handleEvent(TurnTakeMyPiecesEvent event) {
  }

  public void handleEvent(TurnMovePieceEvent event) {
  }

  public void handleEvent(TurnNextActionEvent event) {
  }

  public void handleEvent(TurnNextTurnEvent event) {
  }

}