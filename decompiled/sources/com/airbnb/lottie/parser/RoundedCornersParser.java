package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.clevertap.android.sdk.Constants;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* JADX INFO: loaded from: classes4.dex */
public class RoundedCornersParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of(Constants.NOTIF_MSG, StreamManagement.AckRequest.ELEMENT, "hd");

    private RoundedCornersParser() {
    }

    static RoundedCorners parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        AnimatableFloatValue animatableFloatValue = null;
        while (jsonReader.hasNext()) {
            int iSelectName = jsonReader.selectName(NAMES);
            if (iSelectName == 0) {
                strNextString = jsonReader.nextString();
            } else if (iSelectName == 1) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, true);
            } else if (iSelectName == 2) {
                zNextBoolean = jsonReader.nextBoolean();
            } else {
                jsonReader.skipValue();
            }
        }
        if (zNextBoolean) {
            return null;
        }
        return new RoundedCorners(strNextString, animatableFloatValue);
    }
}
