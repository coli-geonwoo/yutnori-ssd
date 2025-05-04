package org.example.state;

public abstract class StateMachine<TState extends State, TContext, TStateObserver extends StateObserver<TState>, TStateManager extends StateManager<TState, TStateObserver>, TStateEvent extends StateEvent<TState>> {

  private TContext context;
  private TStateManager stateManager;

  public StateMachine(TContext context, TStateManager stateManager) {
    this.context = context;
    this.stateManager = stateManager;
  }

  public TState getCurrentState() {
    return stateManager.getCurrentState();
  }

  public void dispatchEvent(TStateEvent event) {
    System.out.println("[DEBUG] Dispatching event: " + event);
    getCurrentState().handleEvent(event);
  }

  public void observe(TStateObserver observer) {
    stateManager.observe(observer);
  }

  public void unobserve(TStateObserver observer) {
    stateManager.unobserve(observer);
  }

}