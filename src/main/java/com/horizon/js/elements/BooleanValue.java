package com.horizon.js.elements;

public class BooleanValue extends SimpleValue<Boolean> {

  private boolean value;

  private BooleanValue(boolean value) {
    this.value = value;
  }

  public static BooleanValue BUILD(boolean value) {
    return new BooleanValue(value);
  }

  @Override
  public Boolean getValue() {
    return value;
  }
}
