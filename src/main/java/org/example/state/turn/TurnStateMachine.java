package org.example.state.turn;

import java.util.ArrayList;
import java.util.List;

public class TurnStateMachine {

  private TurnState currentState;
  private TurnStateContext context;

  private List<TurnStateObserver> observers = new ArrayList<>();

  public TurnStateMachine() {
    this.context = new TurnStateContext();
    this.currentState = new TurnIdleState(context, this);
  }

  public TurnState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(TurnState state) {
    this.currentState = state;
  }

  public void observe(TurnStateObserver observer) {
    observers.add(observer);
  }

  public void unobserve(TurnStateObserver observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (TurnStateObserver observer : observers) {
      observer.onGameStateChanged();
    }
  }
}