package com.horizon.js.elements;

public class StringValue extends SimpleValue<String> {

  private String value;

  private StringValue(final String value) {
    if (value == null) {
      throw new IllegalArgumentException("Cannot create StringValue with null");
    }
    this.value = value;
  }

  public static StringValue BUILD(String value) {
    return new StringValue(value);
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "\"" + value + "\"";
  }
}
