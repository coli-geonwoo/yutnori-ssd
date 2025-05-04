package org.example.state.game;

import java.util.ArrayList;
import java.util.List;
import org.example.service.GameService;

public class GameStateMachine {

  private GameStateContext context;
  private GameState currentState;
  private GameService gameService;

  private List<GameStateObserver> observers = new ArrayList<>();

  public GameStateMachine(GameService gameService) {
    this.context = new GameStateContext();
    this.currentState = new GameIdleState(context, this);
    this.gameService = gameService;
  }

  public GameState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(GameState state) {
    this.currentState = state;
    notifyObservers();
  }

  public void observe(GameStateObserver observer) {
    observers.add(observer);
  }

  public void unobserve(GameStateObserver observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (GameStateObserver observer : observers) {
      observer.onGameStateChanged();
    }
  }
}