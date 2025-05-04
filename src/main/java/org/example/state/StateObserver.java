package org.example.state;

public interface StateObserver<TState extends State> {

  void onGameStateChanged(TState state);
}