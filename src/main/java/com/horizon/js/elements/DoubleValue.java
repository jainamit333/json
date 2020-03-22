package com.horizon.js.elements;

public class DoubleValue extends SimpleValue<Double> {

  private double value;

  private DoubleValue(double value) {
    this.value = value;
  }

  public static DoubleValue BUILD(double value) {
    return new DoubleValue(value);
  }

  @Override
  public Double getValue() {
    return value;
  }
}
