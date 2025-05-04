package org.example.state;

import org.example.state.turn.event.TurnEvent;

public class StateMachine<TState extends State, TContext, TStateObserver extends StateObserver<TState>, TStateManager extends StateManager<TState, TStateObserver>, TStateEvent extends StateEvent<TState>> {

  private TContext context;
  private TStateManager stateManager;

  public TState getCurrentState() {
    return stateManager.getCurrentState();
  }

  public void dispatchEvent(TurnEvent event) {
    getCurrentState().handleEvent(event);
  }

  public void observe(TStateObserver observer) {
    stateManager.observe(observer);
  }

  public void unobserve(TStateObserver observer) {
    stateManager.unobserve(observer);
  }

}