package com.amazonaws.util.json;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class JsonUtils {
    private static volatile AwsJsonFactory factory = new GsonFactory();

    public enum JsonEngine {
        Gson,
        Jackson
    }

    /* JADX INFO: renamed from: com.amazonaws.util.json.JsonUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$util$json$JsonUtils$JsonEngine;

        static {
            int[] iArr = new int[JsonEngine.values().length];
            $SwitchMap$com$amazonaws$util$json$JsonUtils$JsonEngine = iArr;
            try {
                iArr[JsonEngine.Gson.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$util$json$JsonUtils$JsonEngine[JsonEngine.Jackson.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static void setJsonEngine(JsonEngine jsonEngine) {
        int i = AnonymousClass1.$SwitchMap$com$amazonaws$util$json$JsonUtils$JsonEngine[jsonEngine.ordinal()];
        if (i == 1) {
            factory = new GsonFactory();
        } else {
            if (i == 2) {
                factory = new JacksonFactory();
                return;
            }
            throw new RuntimeException("Unsupported json engine");
        }
    }

    static void setJsonEngine(AwsJsonFactory awsJsonFactory) {
        if (awsJsonFactory == null) {
            throw new IllegalArgumentException("factory can't be null");
        }
        factory = awsJsonFactory;
    }

    public static AwsJsonReader getJsonReader(Reader reader) {
        if (factory == null) {
            throw new IllegalStateException("Json engine is unavailable.");
        }
        return factory.getJsonReader(reader);
    }

    public static AwsJsonWriter getJsonWriter(Writer writer) {
        if (factory == null) {
            throw new IllegalStateException("Json engine is unavailable.");
        }
        return factory.getJsonWriter(writer);
    }

    public static Map<String, String> jsonToMap(Reader reader) {
        AwsJsonReader jsonReader = getJsonReader(reader);
        try {
            if (jsonReader.peek() == null) {
                return Collections.EMPTY_MAP;
            }
            HashMap map = new HashMap();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (jsonReader.isContainer()) {
                    jsonReader.skipValue();
                } else {
                    map.put(strNextName, jsonReader.nextString());
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            return Collections.unmodifiableMap(map);
        } catch (IOException e2) {
            throw new AmazonClientException("Unable to parse JSON String.", e2);
        }
    }

    public static Map<String, String> jsonToMap(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        return jsonToMap(new StringReader(str));
    }

    public static String mapToString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "{}";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jsonWriter.name(entry.getKey()).value(entry.getValue());
            }
            jsonWriter.endObject();
            jsonWriter.close();
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AmazonClientException("Unable to serialize to JSON String.", e2);
        }
    }

    private static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
