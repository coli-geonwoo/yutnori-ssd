package org.example.state.game.event;

import org.example.state.game.GameState;

public class GameStartEvent extends GameEvent {

  @Override
  public void accept(GameState state) {
    System.out.println("GameStartEvent accepted by " + state.getClass().getSimpleName());
    state.handleEvent(this);
  }
}