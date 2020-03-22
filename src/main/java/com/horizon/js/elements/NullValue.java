package com.horizon.js.elements;

public class NullValue extends SimpleValue {

  private static Object data = null;

  private NullValue() {
  }

  public static NullValue BUILD() {
    return new NullValue();
  }

  @Override
  public Object getValue() {
    return data;
  }
}
