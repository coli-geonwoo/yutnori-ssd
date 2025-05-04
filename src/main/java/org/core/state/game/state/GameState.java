package org.core.state.game.state;

import org.core.state.State;
import org.core.state.game.GameStateContext;
import org.core.state.game.GameStateManager;
import org.core.state.game.event.GameEvent;
import org.core.state.game.event.GameOverEvent;
import org.core.state.game.event.GameRestartEvent;
import org.core.state.game.event.GameStartEvent;


public class GameState extends State<GameStateContext, GameStateManager, GameEvent> {

  public GameState(GameStateContext context, GameStateManager stateManager) {
    super(context, stateManager);
  }

  public void handleEvent(GameOverEvent event) {
  }

  public void handleEvent(GameRestartEvent event) {
  }

  public void handleEvent(GameStartEvent event) {
  }

}