package com.horizon.js.elements;

public class LongValue extends SimpleValue<Long> {

  private long value;

  private LongValue(long value) {
    this.value = value;
  }
  public static LongValue BUILD(long value) {
    return new LongValue(value);
  }

  @Override
  public Long getValue() {
    return this.value;
  }
}
