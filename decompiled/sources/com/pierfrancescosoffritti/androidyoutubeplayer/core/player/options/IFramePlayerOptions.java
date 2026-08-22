package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IFramePlayerOptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "", "playerOptions", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getOrigin", "", "getOrigin$core_release", InAppPurchaseConstants.METHOD_TO_STRING, "Builder", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IFramePlayerOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: default, reason: not valid java name */
    private static final IFramePlayerOptions f45default = new Builder().controls(1).build();
    private final JSONObject playerOptions;

    public /* synthetic */ IFramePlayerOptions(JSONObject jSONObject, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject);
    }

    private IFramePlayerOptions(JSONObject jSONObject) {
        this.playerOptions = jSONObject;
    }

    /* JADX INFO: compiled from: IFramePlayerOptions.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Companion;", "", "()V", CookieSpecs.DEFAULT, "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "getDefault", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IFramePlayerOptions getDefault() {
            return IFramePlayerOptions.f45default;
        }
    }

    public String toString() {
        String string = this.playerOptions.toString();
        Intrinsics.checkNotNullExpressionValue(string, "playerOptions.toString()");
        return string;
    }

    public final String getOrigin$core_release() throws JSONException {
        String string = this.playerOptions.getString("origin");
        Intrinsics.checkNotNullExpressionValue(string, "playerOptions.getString(Builder.ORIGIN)");
        return string;
    }

    /* JADX INFO: compiled from: IFramePlayerOptions.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\bJ\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\u0007J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Builder;", "", "()V", "builderOptions", "Lorg/json/JSONObject;", "addInt", "", "key", "", "value", "", "addString", Builder.AUTO_PLAY, Builder.CONTROLS, InAppPurchaseConstants.METHOD_BUILD, "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "ccLoadPolicy", "end", "endSeconds", "fullscreen", Builder.FS, "ivLoadPolicy", "langPref", "languageCode", "list", Builder.LIST_TYPE, "modestBranding", Builder.MUTE, "origin", Builder.REL, "start", "startSeconds", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private static final String AUTO_PLAY = "autoplay";
        private static final String CC_LANG_PREF = "cc_lang_pref";
        private static final String CC_LOAD_POLICY = "cc_load_policy";
        private static final String CONTROLS = "controls";
        private static final String ENABLE_JS_API = "enablejsapi";
        private static final String END = "end";
        private static final String FS = "fs";
        private static final String IV_LOAD_POLICY = "iv_load_policy";
        private static final String LIST = "list";
        private static final String LIST_TYPE = "listType";
        private static final String MUTE = "mute";
        public static final String ORIGIN = "origin";
        private static final String REL = "rel";
        private static final String START = "start";
        private final JSONObject builderOptions = new JSONObject();

        @Deprecated(message = "Deprecated and will have no effect")
        public final Builder modestBranding(int modestBranding) {
            return this;
        }

        public Builder() {
            addInt(AUTO_PLAY, 0);
            addInt(MUTE, 0);
            addInt(CONTROLS, 0);
            addInt(ENABLE_JS_API, 1);
            addInt(FS, 0);
            addString("origin", "https://www.youtube.com");
            addInt(REL, 0);
            addInt(IV_LOAD_POLICY, 3);
            addInt(CC_LOAD_POLICY, 0);
        }

        public final IFramePlayerOptions build() {
            return new IFramePlayerOptions(this.builderOptions, null);
        }

        public final Builder controls(int controls) {
            addInt(CONTROLS, controls);
            return this;
        }

        public final Builder autoplay(int controls) {
            addInt(AUTO_PLAY, controls);
            return this;
        }

        public final Builder mute(int controls) {
            addInt(MUTE, controls);
            return this;
        }

        public final Builder rel(int rel) {
            addInt(REL, rel);
            return this;
        }

        public final Builder ivLoadPolicy(int ivLoadPolicy) {
            addInt(IV_LOAD_POLICY, ivLoadPolicy);
            return this;
        }

        public final Builder langPref(String languageCode) {
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            addString(CC_LANG_PREF, languageCode);
            return this;
        }

        public final Builder ccLoadPolicy(int ccLoadPolicy) {
            addInt(CC_LOAD_POLICY, ccLoadPolicy);
            return this;
        }

        public final Builder origin(String origin) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            addString("origin", origin);
            return this;
        }

        public final Builder list(String list) {
            Intrinsics.checkNotNullParameter(list, "list");
            addString("list", list);
            return this;
        }

        public final Builder listType(String listType) {
            Intrinsics.checkNotNullParameter(listType, "listType");
            addString(LIST_TYPE, listType);
            return this;
        }

        public final Builder fullscreen(int fs) {
            addInt(FS, fs);
            return this;
        }

        public final Builder start(int startSeconds) {
            addInt("start", startSeconds);
            return this;
        }

        public final Builder end(int endSeconds) {
            addInt("end", endSeconds);
            return this;
        }

        private final void addString(String key, String value) {
            try {
                this.builderOptions.put(key, value);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + key + ": " + value);
            }
        }

        private final void addInt(String key, int value) {
            try {
                this.builderOptions.put(key, value);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + key + ": " + value);
            }
        }
    }
}
