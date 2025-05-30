package org.core.state.game;

import org.core.state.StateObserver;
import org.core.state.game.state.GameState;

public interface GameStateObserver extends StateObserver<GameState> {

  void onStateChanged(GameState state);
}