package com.horizon.js.elements;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectValue implements Value<Set<Entry>> {

  private HashMap<String, Entry> data;

  private ObjectValue() {
    this.data = new HashMap<>();
  }

  public static ObjectValue BUILD_OBJECT(final Entry... entries) {
    ObjectValue objectValue = new ObjectValue();
    Stream.of(entries).forEach(entry -> objectValue.data.put(entry.getKey(), entry));
    return objectValue;
  }

  public void addEntry(final Entry entry) {
    this.data.put(entry.getKey(), entry);
  }

  @Override
  public Set<Entry> getValue() {
    return Collections.unmodifiableSet(this.data.values().stream().collect(Collectors.toSet()));
  }

  @Override
  public String toString() {
    return "{ " + String
        .join(",", getValue().stream().map(Entry::toString).collect(Collectors.toSet())) + "}";
  }
}
