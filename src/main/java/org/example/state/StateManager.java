package org.example.state;

import java.util.ArrayList;
import java.util.List;

public class StateManager<TState extends State, TStateObserver extends StateObserver<TState>> {

  protected TState currentState;

  private List<TStateObserver> observers = new ArrayList<>();

  public TState getCurrentState() {
    return currentState;
  }

  public void setCurrentState(TState state) {
    this.currentState = state;
    notifyObservers(state);
  }

  public void observe(TStateObserver observer) {
    observers.add(observer);
  }

  public void unobserve(TStateObserver observer) {
    observers.remove(observer);
  }

  public void notifyObservers(TState state) {
    for (TStateObserver observer : observers) {
      observer.onStateChanged(state);
    }
  }
}