package com.amazonaws.services.kms.model.transform;

import com.amazonaws.services.kms.model.ReEncryptResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* JADX INFO: loaded from: classes4.dex */
public class ReEncryptResultJsonUnmarshaller implements Unmarshaller<ReEncryptResult, JsonUnmarshallerContext> {
    private static ReEncryptResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ReEncryptResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ReEncryptResult reEncryptResult = new ReEncryptResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("CiphertextBlob")) {
                reEncryptResult.setCiphertextBlob(SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("SourceKeyId")) {
                reEncryptResult.setSourceKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("KeyId")) {
                reEncryptResult.setKeyId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return reEncryptResult;
    }

    public static ReEncryptResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReEncryptResultJsonUnmarshaller();
        }
        return instance;
    }
}
