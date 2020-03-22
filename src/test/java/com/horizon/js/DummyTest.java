package com.horizon.js;

import static com.horizon.js.elements.Entry.ARRAY_ENTRY;
import static com.horizon.js.elements.Entry.BOOLEAN_ENTRY;
import static com.horizon.js.elements.Entry.DOUBLE_ENTRY;
import static com.horizon.js.elements.Entry.LONG_ENTRY;
import static com.horizon.js.elements.Entry.NULL_ENTRY;
import static com.horizon.js.elements.Entry.OBJECT_ENTRY;
import static com.horizon.js.elements.Entry.STRING_ENTRY;

import com.horizon.js.elements.ArrayValue;
import com.horizon.js.elements.BooleanValue;
import com.horizon.js.elements.DoubleValue;
import com.horizon.js.elements.Entry;
import com.horizon.js.elements.Json;
import com.horizon.js.elements.LongValue;
import com.horizon.js.elements.ObjectValue;
import com.horizon.js.elements.StringValue;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class DummyTest {

  @Test
  public void entryCreation() {

    final Entry<ObjectValue> assetMetadata = OBJECT_ENTRY("assetMetadata",
        STRING_ENTRY("clientId", StringValue.BUILD(UUID.randomUUID().toString())),
        LONG_ENTRY("headRevisionUntil", LongValue.BUILD(System.currentTimeMillis()))
    );

    final ObjectValue version1 = ObjectValue.BUILD_OBJECT(
        LONG_ENTRY("versionNumber", LongValue.BUILD(1L)),
        STRING_ENTRY("createdBy", StringValue.BUILD(UUID.randomUUID().toString())),
        LONG_ENTRY("headRevisionUntil", LongValue.BUILD(System.currentTimeMillis()))
    );

    final ObjectValue version2 = ObjectValue.BUILD_OBJECT(
        LONG_ENTRY("versionNumber", LongValue.BUILD(2L)),
        STRING_ENTRY("createdBy", StringValue.BUILD(UUID.randomUUID().toString())),
        LONG_ENTRY("headRevisionUntil", LongValue.BUILD(System.currentTimeMillis()))
    );

    final Entry<ArrayValue> assetVersions = ARRAY_ENTRY("versions", version1, version2);

    final Json json = Json.JsonBuilder.BUILD_FROM_ENTRIES(
        STRING_ENTRY("_id", StringValue.BUILD(UUID.randomUUID().toString())),
        STRING_ENTRY("name", StringValue.BUILD(UUID.randomUUID().toString())),
        NULL_ENTRY("lastUpdatedAt"),
        LONG_ENTRY("createdAt", LongValue.BUILD(System.currentTimeMillis())),
        DOUBLE_ENTRY("score", DoubleValue.BUILD(12.67)),
        BOOLEAN_ENTRY("isCollection", BooleanValue.BUILD(true))
    );
    json.append(assetMetadata)
        .append(assetVersions);
    System.out.println(json);

  }
}
