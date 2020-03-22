package com.horizon.js.elements;

import static com.horizon.js.elements.ArrayValue.BUILD;
import static com.horizon.js.elements.ObjectValue.BUILD_OBJECT;

public abstract class Entry<T extends Value> {

  private String key;
  private T value;

  private Entry(final String key, final T value) {

    if (key == null) {
      throw new IllegalArgumentException("Key cannot be null for entry");
    }
    this.key = key;
    this.value = value;
  }

  // TODO: 21/03/20 create generic creator also.
  public static Entry<NullValue> NULL_ENTRY(final String key) {
    return new Entry<NullValue>(key, NullValue.BUILD()) {
    };
  }

  public static Entry<LongValue> LONG_ENTRY(final String key, final LongValue value) {
    return new Entry<LongValue>(key, value) {
    };
  }

  public static Entry<StringValue> STRING_ENTRY(final String key, final StringValue value) {
    return new Entry<StringValue>(key, value) {
    };
  }

  public static Entry<BooleanValue> BOOLEAN_ENTRY(final String key, final BooleanValue value) {
    return new Entry<BooleanValue>(key, value) {
    };
  }

  public static Entry<DoubleValue> DOUBLE_ENTRY(final String key, final DoubleValue value) {
    return new Entry<DoubleValue>(key, value) {
    };
  }

  public static Entry<ObjectValue> OBJECT_ENTRY(final String key, final Entry... entries) {
    return new Entry<ObjectValue>(key, BUILD_OBJECT(entries)) {
    };
  }

  public static Entry<ArrayValue> ARRAY_ENTRY(final String key, final Value... values) {
    return new Entry<ArrayValue>(key, BUILD(values)) {
    };
  }

  public String getKey() {
    return key;
  }

  public T getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "\"" + key + "\"" + ":" + value.toString();
  }
}
