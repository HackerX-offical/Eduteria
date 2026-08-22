package com.github.kotvertolet.youtubejextractor;

import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.Cipher;
import com.github.kotvertolet.youtubejextractor.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes7.dex */
class IGsonFactoryImpl implements IGsonFactory {
    IGsonFactoryImpl() {
    }

    @Override // com.github.kotvertolet.youtubejextractor.IGsonFactory
    public Gson initGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Cipher.class, new CipherDeserializer());
        return gsonBuilder.create();
    }

    private class CipherDeserializer implements JsonDeserializer<Cipher> {
        private CipherDeserializer() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.JsonDeserializer
        public Cipher deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            String[] strArrSplit = jsonElement.getAsString().split("&");
            return new Cipher(strArrSplit[0].replace("s=", ""), strArrSplit[1].replace("sp=", ""), StringUtils.urlDecode(strArrSplit[2].replace("url=", "")));
        }
    }
}
