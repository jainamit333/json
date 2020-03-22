package com.horizon.js.elements;

import static com.horizon.js.elements.ObjectValue.BUILD_OBJECT;

public class Json {

  private ObjectValue data;

  private Json(ObjectValue data) {
    this.data = data;
  }

  public Json append(final Entry entry) {
    this.data.addEntry(entry);
    return this;
  }

  public Json merge(final Json... jsons) {
    throw new RuntimeException("Not Implemented");
  }

  public static class JsonBuilder {

    public static Json START() {
      return BUILD_FROM_ENTRIES(null);
    }

    public static Json BUILD_FROM_ENTRIES(final Entry... entries) {
      Json json = new Json(BUILD_OBJECT(entries));
      return json;
    }
  }

  @Override
  public String toString() {
    return this.data.toString();
  }
}
