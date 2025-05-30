package org.core.state;

public abstract class StateMachine<TState extends State, TContext, TStateObserver extends StateObserver<TState>, TStateManager extends StateManager<TState, TStateObserver>, TStateEvent extends StateEvent<TState>> {

  public final TContext context;
  protected TStateManager stateManager;

  public StateMachine(TContext context, TStateManager stateManager) {
    this.context = context;
    this.stateManager = stateManager;
  }

  public TState getCurrentState() {
    return stateManager.getCurrentState();
  }

  public void dispatchEvent(TStateEvent event) {
    getCurrentState().handleEvent(event);
  }

  public void observe(TStateObserver observer) {
    stateManager.observe(observer);
  }

  public void unobserve(TStateObserver observer) {
    stateManager.unobserve(observer);
  }

}