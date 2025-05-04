package org.core.state;

public abstract class State<TContext, TStateManager extends StateManager, TEvent extends StateEvent> {

  public TStateManager stateManager;
  protected TContext context;

  public State(TContext context, TStateManager stateManager) {
    this.context = context;
    this.stateManager = stateManager;
  }

  public void handleEvent(TEvent event) {
    event.accept(this);
  }

  public void onEnter() {
    // no-op
  }
}