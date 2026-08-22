package com.clevertap.android.sdk.inapp;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.inapp.CTLocalInApp;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CTLocalInApp.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp;", "", "<init>", "()V", "InAppType", "Companion", "Builder", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTLocalInApp {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String FALLBACK_TO_NOTIFICATION_SETTINGS = "fallbackToNotificationSettings";
    public static final String IS_LOCAL_INAPP = "isLocalInApp";

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    private CTLocalInApp() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: CTLocalInApp.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$InAppType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "ALERT", "HALF_INTERSTITIAL", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InAppType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InAppType[] $VALUES;
        public static final InAppType ALERT = new InAppType("ALERT", 0, CTInAppType.CTInAppTypeAlert.getType());
        public static final InAppType HALF_INTERSTITIAL = new InAppType("HALF_INTERSTITIAL", 1, CTInAppType.CTInAppTypeHalfInterstitial.getType());
        private final String type;

        private static final /* synthetic */ InAppType[] $values() {
            return new InAppType[]{ALERT, HALF_INTERSTITIAL};
        }

        public static EnumEntries<InAppType> getEntries() {
            return $ENTRIES;
        }

        private InAppType(String str, int i, String str2) {
            this.type = str2;
        }

        public final String getType() {
            return this.type;
        }

        static {
            InAppType[] inAppTypeArr$values = $values();
            $VALUES = inAppTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(inAppTypeArr$values);
        }

        public static InAppType valueOf(String str) {
            return (InAppType) Enum.valueOf(InAppType.class, str);
        }

        public static InAppType[] values() {
            return (InAppType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: CTLocalInApp.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Companion;", "", "<init>", "()V", "builder", "Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder;", "IS_LOCAL_INAPP", "", "FALLBACK_TO_NOTIFICATION_SETTINGS", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }

    /* JADX INFO: compiled from: CTLocalInApp.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0006\n\u000b\f\r\u000e\u000fB\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder;", "", "<init>", "()V", "jsonObject", "Lorg/json/JSONObject;", "setInAppType", "Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder1;", "inAppType", "Lcom/clevertap/android/sdk/inapp/CTLocalInApp$InAppType;", "Builder1", "Builder2", "Builder3", "Builder4", "Builder5", "Builder6", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        private JSONObject jsonObject = new JSONObject();

        public final Builder1 setInAppType(InAppType inAppType) throws JSONException {
            Intrinsics.checkNotNullParameter(inAppType, "inAppType");
            JSONObject jSONObject = this.jsonObject;
            jSONObject.put("type", inAppType.getType());
            jSONObject.put(CTLocalInApp.IS_LOCAL_INAPP, true);
            jSONObject.put("close", true);
            return new Builder1(jSONObject);
        }

        /* JADX INFO: compiled from: CTLocalInApp.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder1;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "setTitleText", "Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder2;", "titleText", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Builder1 {
            private JSONObject jsonObject;

            public Builder1(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                this.jsonObject = jsonObject;
            }

            public final Builder2 setTitleText(String titleText) throws JSONException {
                Intrinsics.checkNotNullParameter(titleText, "titleText");
                JSONObject jSONObject = this.jsonObject;
                jSONObject.put("title", new JSONObject().put("text", titleText));
                return new Builder2(jSONObject);
            }
        }

        /* JADX INFO: compiled from: CTLocalInApp.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder2;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "setMessageText", "Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder3;", "messageText", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Builder2 {
            private JSONObject jsonObject;

            public Builder2(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                this.jsonObject = jsonObject;
            }

            public final Builder3 setMessageText(String messageText) throws JSONException {
                Intrinsics.checkNotNullParameter(messageText, "messageText");
                JSONObject jSONObject = this.jsonObject;
                jSONObject.put("message", new JSONObject().put("text", messageText));
                return new Builder3(jSONObject);
            }
        }

        /* JADX INFO: compiled from: CTLocalInApp.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder3;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "followDeviceOrientation", "Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder4;", "deviceOrientation", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Builder3 {
            private JSONObject jsonObject;

            public Builder3(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                this.jsonObject = jsonObject;
            }

            public final Builder4 followDeviceOrientation(boolean deviceOrientation) throws JSONException {
                JSONObject jSONObject = this.jsonObject;
                jSONObject.put(Constants.KEY_PORTRAIT, true);
                jSONObject.put(Constants.KEY_LANDSCAPE, deviceOrientation);
                return new Builder4(jSONObject);
            }
        }

        /* JADX INFO: compiled from: CTLocalInApp.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder4;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "setPositiveBtnText", "Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder5;", "positiveBtnText", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Builder4 {
            private JSONObject jsonObject;

            public Builder4(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                this.jsonObject = jsonObject;
            }

            public final Builder5 setPositiveBtnText(String positiveBtnText) throws JSONException {
                Intrinsics.checkNotNullParameter(positiveBtnText, "positiveBtnText");
                JSONObject jSONObject = this.jsonObject;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", positiveBtnText);
                jSONObject2.put(Constants.KEY_RADIUS, "2");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", InAppActionType.CLOSE);
                Unit unit = Unit.INSTANCE;
                jSONObject2.put(Constants.KEY_ACTIONS, jSONObject3);
                jSONObject.put(Constants.KEY_BUTTONS, new JSONArray().put(0, jSONObject2));
                return new Builder5(jSONObject);
            }
        }

        /* JADX INFO: compiled from: CTLocalInApp.kt */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder5;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "setNegativeBtnText", "Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder6;", "negativeBtnText", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Builder5 {
            private JSONObject jsonObject;

            public Builder5(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                this.jsonObject = jsonObject;
            }

            public final Builder6 setNegativeBtnText(String negativeBtnText) throws JSONException {
                Intrinsics.checkNotNullParameter(negativeBtnText, "negativeBtnText");
                JSONObject jSONObject = this.jsonObject;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("text", negativeBtnText);
                jSONObject2.put(Constants.KEY_RADIUS, "2");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", InAppActionType.CLOSE);
                Unit unit = Unit.INSTANCE;
                jSONObject2.put(Constants.KEY_ACTIONS, jSONObject3);
                jSONObject.getJSONArray(Constants.KEY_BUTTONS).put(1, jSONObject2);
                return new Builder6(jSONObject);
            }
        }

        /* JADX INFO: compiled from: CTLocalInApp.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTLocalInApp$Builder$Builder6;", "", "jsonObject", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "setFallbackToSettings", "fallbackToSettings", "", "setBackgroundColor", "backgroundColor", "", "setImageUrl", "imageUrl", "contentDescription", "setTitleTextColor", "titleTextColor", "setMessageTextColor", "messageTextColor", "setBtnTextColor", "btnTextColor", "setBtnBackgroundColor", "btnBackgroundColor", "setBtnBorderColor", "btnBorderColor", "setBtnBorderRadius", "btnBorderRadius", "updateActionButtonArray", "Lkotlin/Function2;", "", InAppPurchaseConstants.METHOD_BUILD, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Builder6 {
            private JSONObject jsonObject;
            private final Function2<String, String, Unit> updateActionButtonArray;

            public Builder6(JSONObject jsonObject) {
                Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
                this.jsonObject = jsonObject;
                this.updateActionButtonArray = new Function2() { // from class: com.clevertap.android.sdk.inapp.CTLocalInApp$Builder$Builder6$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CTLocalInApp.Builder.Builder6.updateActionButtonArray$lambda$13(this.f$0, (String) obj, (String) obj2);
                    }
                };
            }

            public final Builder6 setFallbackToSettings(boolean fallbackToSettings) throws JSONException {
                this.jsonObject.put(CTLocalInApp.FALLBACK_TO_NOTIFICATION_SETTINGS, fallbackToSettings);
                return this;
            }

            public final Builder6 setBackgroundColor(String backgroundColor) throws JSONException {
                Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
                this.jsonObject.put(Constants.KEY_BG, backgroundColor);
                return this;
            }

            public final Builder6 setImageUrl(String imageUrl) {
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                return setImageUrl(imageUrl, null);
            }

            public final Builder6 setImageUrl(String imageUrl, String contentDescription) throws JSONException {
                Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", imageUrl);
                jSONObject.put("content_type", "image");
                if (contentDescription != null) {
                    jSONObject.put(Constants.KEY_ALT_TEXT, contentDescription);
                }
                JSONObject jSONObject2 = this.jsonObject;
                jSONObject2.put("media", jSONObject);
                if (jSONObject2.getBoolean(Constants.KEY_LANDSCAPE)) {
                    jSONObject2.put(Constants.KEY_MEDIA_LANDSCAPE, jSONObject);
                }
                return this;
            }

            public final Builder6 setTitleTextColor(String titleTextColor) throws JSONException {
                Intrinsics.checkNotNullParameter(titleTextColor, "titleTextColor");
                this.jsonObject.getJSONObject("title").put("color", titleTextColor);
                return this;
            }

            public final Builder6 setMessageTextColor(String messageTextColor) throws JSONException {
                Intrinsics.checkNotNullParameter(messageTextColor, "messageTextColor");
                this.jsonObject.getJSONObject("message").put("color", messageTextColor);
                return this;
            }

            public final Builder6 setBtnTextColor(String btnTextColor) {
                Intrinsics.checkNotNullParameter(btnTextColor, "btnTextColor");
                this.updateActionButtonArray.invoke("color", btnTextColor);
                return this;
            }

            public final Builder6 setBtnBackgroundColor(String btnBackgroundColor) {
                Intrinsics.checkNotNullParameter(btnBackgroundColor, "btnBackgroundColor");
                this.updateActionButtonArray.invoke(Constants.KEY_BG, btnBackgroundColor);
                return this;
            }

            public final Builder6 setBtnBorderColor(String btnBorderColor) {
                Intrinsics.checkNotNullParameter(btnBorderColor, "btnBorderColor");
                this.updateActionButtonArray.invoke(Constants.KEY_BORDER, btnBorderColor);
                return this;
            }

            public final Builder6 setBtnBorderRadius(String btnBorderRadius) {
                Intrinsics.checkNotNullParameter(btnBorderRadius, "btnBorderRadius");
                this.updateActionButtonArray.invoke(Constants.KEY_RADIUS, btnBorderRadius);
                return this;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit updateActionButtonArray$lambda$13(Builder6 this$0, String key, String value) throws JSONException {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                Integer[] numArr = {0, 1};
                for (int i = 0; i < 2; i++) {
                    this$0.jsonObject.getJSONArray(Constants.KEY_BUTTONS).getJSONObject(numArr[i].intValue()).put(key, value);
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: build, reason: from getter */
            public final JSONObject getJsonObject() {
                return this.jsonObject;
            }
        }
    }
}
