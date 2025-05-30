package org.core.state;

public interface StateObserver<TState extends State> {

  void onStateChanged(TState state);
}