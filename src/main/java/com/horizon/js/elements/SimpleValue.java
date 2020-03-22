package com.horizon.js.elements;

public abstract class SimpleValue<T> implements Value<T> {

  @Override
  public String toString() {
    return String.valueOf(getValue());
  }
}
