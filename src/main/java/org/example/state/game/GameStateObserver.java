package org.example.state.game;

import org.example.state.StateObserver;

public interface GameStateObserver extends StateObserver<GameState> {

  void onGameStateChanged(GameState state);
}