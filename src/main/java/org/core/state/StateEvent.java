package org.core.state;

public interface StateEvent<TState extends State> {

  void accept(TState state);
}