package com.horizon.js.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayValue<T extends SimpleValue> implements Value {

  private List<Value> data;

  private ArrayValue() {
    this.data = new ArrayList<>();
  }

  public static ArrayValue BUILD(final Value... values) {
    final ArrayValue arrayValue = new ArrayValue();
    Stream.of(values).forEach(value -> arrayValue.data.add(value));
    return arrayValue;
  }

  public void addData(final Value value) {
    this.data.add(value);
  }

  @Override
  public String toString() {

    return "[ " + String
        .join(",", getValue().stream().map(Value::toString).collect(Collectors.toSet())) + "]";
  }

  @Override
  public List<Value> getValue() {
    return data;
  }
}
