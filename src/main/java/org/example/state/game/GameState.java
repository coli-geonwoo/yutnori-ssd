package org.example.state.game;

import org.example.state.State;
import org.example.state.game.event.GameEvent;
import org.example.state.game.event.GameExitEvent;
import org.example.state.game.event.GameOverEvent;
import org.example.state.game.event.GameRestartEvent;
import org.example.state.game.event.GameStartEvent;


public class GameState extends State<GameStateContext, GameStateManager, GameEvent> {

  public GameState(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  public void handleEvent(GameExitEvent event) {
  }

  public void handleEvent(GameOverEvent event) {
  }

  public void handleEvent(GameRestartEvent event) {
  }

  public void handleEvent(GameStartEvent event) {
  }

}