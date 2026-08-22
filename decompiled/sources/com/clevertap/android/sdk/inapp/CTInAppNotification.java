package com.clevertap.android.sdk.inapp;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.db.Column;
import com.clevertap.android.sdk.inapp.customtemplates.CustomTemplateInAppData;
import com.clevertap.android.sdk.utils.ColorUtilsKt;
import com.clevertap.android.sdk.utils.JsonUtilsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CTInAppNotification.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0012\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010v\u001a\u00020!H\u0016J\u0018\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\t2\u0006\u0010z\u001a\u00020!H\u0016J\u0006\u0010{\u001a\u00020\u0005J\u0017\u0010|\u001a\u0004\u0018\u00010c2\u0006\u0010}\u001a\u00020!H\u0000¢\u0006\u0002\b~J\u001b\u0010\u007f\u001a\u0004\u0018\u00010\u00002\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0003\b\u0081\u0001J\u001a\u0010\u0082\u0001\u001a\u00020x2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0003\b\u0084\u0001J\u0011\u0010\u0085\u0001\u001a\u00020x2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020x2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J+\u0010\u0087\u0001\u001a\u00020\u00052\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\f2\u000b\u0010B\u001a\u0007\u0012\u0002\b\u00030\u008b\u0001H\u0002J\u0013\u0010\u008c\u0001\u001a\u00020\u00052\b\u0010\u008d\u0001\u001a\u00030\u0089\u0001H\u0002R\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000fR\u001e\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0017R\u001e\u0010-\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0017R\"\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000fR\"\u00100\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000fR\u001e\u00103\u001a\u0002022\u0006\u0010\u000b\u001a\u000202@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001e\u00106\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u001e\u00108\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u001e\u0010:\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0017R\u001e\u0010;\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0017R\u001e\u0010=\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0017R\"\u0010?\u001a\u0004\u0018\u00010>2\b\u0010\u000b\u001a\u0004\u0018\u00010>@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\"\u0010B\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000fR\u001e\u0010D\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u000fR\u001e\u0010F\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010$R\"\u0010H\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u001bR\"\u0010J\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u000fR\u001e\u0010L\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0017R\u001c\u0010N\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010QR\u001e\u0010R\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010$R\u001e\u0010T\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010$R\u001e\u0010W\u001a\u00020V2\u0006\u0010\u000b\u001a\u00020V@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u001e\u0010Z\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0017R\"\u0010\\\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u000fR\u001e\u0010^\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0017R\u001e\u0010`\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0017R\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020c0&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020c0)8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\be\u0010+R\u001e\u0010f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\u000fR\u001e\u0010i\u001a\u00020h2\u0006\u0010\u000b\u001a\u00020h@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u001e\u0010l\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\u0017R\u001e\u0010n\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u000fR\u001e\u0010p\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0017R\u001e\u0010r\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bs\u0010$R\u001e\u0010t\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bu\u0010$¨\u0006\u008f\u0001"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "Landroid/os/Parcelable;", "jsonObject", "Lorg/json/JSONObject;", "videoSupported", "", "<init>", "(Lorg/json/JSONObject;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "", "id", "getId", "()Ljava/lang/String;", Column.CAMPAIGN, "getCampaignId", "Lcom/clevertap/android/sdk/inapp/CTInAppType;", "inAppType", "getInAppType", "()Lcom/clevertap/android/sdk/inapp/CTInAppType;", "isExcludeFromCaps", "()Z", "_actionExtras", "actionExtras", "getActionExtras", "()Lorg/json/JSONObject;", "_jsonDescription", "jsonDescription", "getJsonDescription", "landscapeImageUrl", "getLandscapeImageUrl", "", "maxPerSession", "getMaxPerSession", "()I", "_buttons", "Ljava/util/ArrayList;", "Lcom/clevertap/android/sdk/inapp/CTInAppNotificationButton;", Constants.KEY_BUTTONS, "", "getButtons", "()Ljava/util/List;", "isLandscape", "isPortrait", "title", "getTitle", "message", "getMessage", "", "timeToLive", "getTimeToLive", "()J", "totalDailyCount", "getTotalDailyCount", "totalLifetimeCount", "getTotalLifetimeCount", CTLocalInApp.IS_LOCAL_INAPP, "fallBackToNotificationSettings", "getFallBackToNotificationSettings", "isRequestForPushPermission", "Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplateInAppData;", "customTemplateData", "getCustomTemplateData$clevertap_core_release", "()Lcom/clevertap/android/sdk/inapp/customtemplates/CustomTemplateInAppData;", "type", "getType$clevertap_core_release", "backgroundColor", "getBackgroundColor$clevertap_core_release", "buttonCount", "getButtonCount$clevertap_core_release", "customExtras", "getCustomExtras$clevertap_core_release", "customInAppUrl", "getCustomInAppUrl$clevertap_core_release", "isDarkenScreen", "isDarkenScreen$clevertap_core_release", "error", "getError$clevertap_core_release", "setError$clevertap_core_release", "(Ljava/lang/String;)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "getHeight$clevertap_core_release", "heightPercentage", "getHeightPercentage$clevertap_core_release", "", Constants.INAPP_ASPECT_RATIO, "getAspectRatio$clevertap_core_release", "()D", "isHideCloseButton", "isHideCloseButton$clevertap_core_release", "html", "getHtml$clevertap_core_release", "isTablet", "isTablet$clevertap_core_release", Constants.INAPP_JS_ENABLED, "isJsEnabled$clevertap_core_release", "_mediaList", "Lcom/clevertap/android/sdk/inapp/CTInAppNotificationMedia;", "mediaList", "getMediaList$clevertap_core_release", "messageColor", "getMessageColor$clevertap_core_release", "", Const.POSITION, "getPosition$clevertap_core_release", "()C", "isShowClose", "isShowClose$clevertap_core_release", "titleColor", "getTitleColor$clevertap_core_release", "isVideoSupported", "isVideoSupported$clevertap_core_release", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "getWidth$clevertap_core_release", "widthPercentage", "getWidthPercentage$clevertap_core_release", "describeContents", "writeToParcel", "", "dest", "flags", "hasStreamMedia", "getInAppMediaForOrientation", Constants.KEY_ORIENTATION, "getInAppMediaForOrientation$clevertap_core_release", "createNotificationForAction", "actionData", "createNotificationForAction$clevertap_core_release", "setCustomTemplateData", "inAppData", "setCustomTemplateData$clevertap_core_release", "configureWithJson", "legacyConfigureWithJson", "isKeyValid", "b", "Landroid/os/Bundle;", "key", "Lkotlin/reflect/KClass;", "validateNotifBundle", "notif", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTInAppNotification implements Parcelable {
    private static final String EMPTY_JSON = "{}";
    public static final double HTML_DEFAULT_ASPECT_RATIO = -1.0d;
    private JSONObject _actionExtras;
    private ArrayList<CTInAppNotificationButton> _buttons;
    private JSONObject _jsonDescription;
    private ArrayList<CTInAppNotificationMedia> _mediaList;
    private double aspectRatio;
    private String backgroundColor;
    private int buttonCount;
    private String campaignId;
    private JSONObject customExtras;
    private String customInAppUrl;
    private CustomTemplateInAppData customTemplateData;
    private String error;
    private boolean fallBackToNotificationSettings;
    private int height;
    private int heightPercentage;
    private String html;
    private String id;
    private CTInAppType inAppType;
    private boolean isDarkenScreen;
    private boolean isExcludeFromCaps;
    private boolean isHideCloseButton;
    private boolean isJsEnabled;
    private boolean isLandscape;
    private boolean isLocalInApp;
    private boolean isPortrait;
    private boolean isRequestForPushPermission;
    private boolean isShowClose;
    private boolean isTablet;
    private boolean isVideoSupported;
    private String landscapeImageUrl;
    private int maxPerSession;
    private String message;
    private String messageColor;
    private char position;
    private long timeToLive;
    private String title;
    private String titleColor;
    private int totalDailyCount;
    private int totalLifetimeCount;
    private String type;
    private int width;
    private int widthPercentage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<CTInAppNotification> CREATOR = new Parcelable.Creator<CTInAppNotification>() { // from class: com.clevertap.android.sdk.inapp.CTInAppNotification$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CTInAppNotification createFromParcel(Parcel in) {
            Intrinsics.checkNotNullParameter(in, "in");
            return new CTInAppNotification(in, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CTInAppNotification[] newArray(int size) {
            return new CTInAppNotification[size];
        }
    };

    /* JADX INFO: compiled from: CTInAppNotification.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CTInAppType.values().length];
            try {
                iArr[CTInAppType.CTInAppTypeFooter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CTInAppType.CTInAppTypeHeader.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CTInAppType.CTInAppTypeCover.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CTInAppType.CTInAppTypeHalfInterstitial.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CTInAppType.CTInAppTypeCoverImageOnly.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CTInAppType.CTInAppTypeHalfInterstitialImageOnly.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CTInAppType.CTInAppTypeInterstitialImageOnly.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ CTInAppNotification(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.id;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final CTInAppType getInAppType() {
        return this.inAppType;
    }

    /* JADX INFO: renamed from: isExcludeFromCaps, reason: from getter */
    public final boolean getIsExcludeFromCaps() {
        return this.isExcludeFromCaps;
    }

    public final JSONObject getActionExtras() {
        JSONObject jSONObject = this._actionExtras;
        if (jSONObject != null) {
            return CTXtensions.copy(jSONObject);
        }
        return null;
    }

    public final JSONObject getJsonDescription() {
        return CTXtensions.copy(this._jsonDescription);
    }

    public final String getLandscapeImageUrl() {
        return this.landscapeImageUrl;
    }

    public final int getMaxPerSession() {
        return this.maxPerSession;
    }

    public final List<CTInAppNotificationButton> getButtons() {
        return this._buttons;
    }

    /* JADX INFO: renamed from: isLandscape, reason: from getter */
    public final boolean getIsLandscape() {
        return this.isLandscape;
    }

    /* JADX INFO: renamed from: isPortrait, reason: from getter */
    public final boolean getIsPortrait() {
        return this.isPortrait;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getTimeToLive() {
        return this.timeToLive;
    }

    public final int getTotalDailyCount() {
        return this.totalDailyCount;
    }

    public final int getTotalLifetimeCount() {
        return this.totalLifetimeCount;
    }

    /* JADX INFO: renamed from: isLocalInApp, reason: from getter */
    public final boolean getIsLocalInApp() {
        return this.isLocalInApp;
    }

    public final boolean getFallBackToNotificationSettings() {
        return this.fallBackToNotificationSettings;
    }

    /* JADX INFO: renamed from: isRequestForPushPermission, reason: from getter */
    public final boolean getIsRequestForPushPermission() {
        return this.isRequestForPushPermission;
    }

    /* JADX INFO: renamed from: getCustomTemplateData$clevertap_core_release, reason: from getter */
    public final CustomTemplateInAppData getCustomTemplateData() {
        return this.customTemplateData;
    }

    /* JADX INFO: renamed from: getType$clevertap_core_release, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: getBackgroundColor$clevertap_core_release, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: getButtonCount$clevertap_core_release, reason: from getter */
    public final int getButtonCount() {
        return this.buttonCount;
    }

    /* JADX INFO: renamed from: getCustomExtras$clevertap_core_release, reason: from getter */
    public final JSONObject getCustomExtras() {
        return this.customExtras;
    }

    /* JADX INFO: renamed from: getCustomInAppUrl$clevertap_core_release, reason: from getter */
    public final String getCustomInAppUrl() {
        return this.customInAppUrl;
    }

    /* JADX INFO: renamed from: isDarkenScreen$clevertap_core_release, reason: from getter */
    public final boolean getIsDarkenScreen() {
        return this.isDarkenScreen;
    }

    /* JADX INFO: renamed from: getError$clevertap_core_release, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final void setError$clevertap_core_release(String str) {
        this.error = str;
    }

    /* JADX INFO: renamed from: getHeight$clevertap_core_release, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: getHeightPercentage$clevertap_core_release, reason: from getter */
    public final int getHeightPercentage() {
        return this.heightPercentage;
    }

    /* JADX INFO: renamed from: getAspectRatio$clevertap_core_release, reason: from getter */
    public final double getAspectRatio() {
        return this.aspectRatio;
    }

    /* JADX INFO: renamed from: isHideCloseButton$clevertap_core_release, reason: from getter */
    public final boolean getIsHideCloseButton() {
        return this.isHideCloseButton;
    }

    /* JADX INFO: renamed from: getHtml$clevertap_core_release, reason: from getter */
    public final String getHtml() {
        return this.html;
    }

    /* JADX INFO: renamed from: isTablet$clevertap_core_release, reason: from getter */
    public final boolean getIsTablet() {
        return this.isTablet;
    }

    /* JADX INFO: renamed from: isJsEnabled$clevertap_core_release, reason: from getter */
    public final boolean getIsJsEnabled() {
        return this.isJsEnabled;
    }

    public final List<CTInAppNotificationMedia> getMediaList$clevertap_core_release() {
        return this._mediaList;
    }

    /* JADX INFO: renamed from: getMessageColor$clevertap_core_release, reason: from getter */
    public final String getMessageColor() {
        return this.messageColor;
    }

    /* JADX INFO: renamed from: getPosition$clevertap_core_release, reason: from getter */
    public final char getPosition() {
        return this.position;
    }

    /* JADX INFO: renamed from: isShowClose$clevertap_core_release, reason: from getter */
    public final boolean getIsShowClose() {
        return this.isShowClose;
    }

    /* JADX INFO: renamed from: getTitleColor$clevertap_core_release, reason: from getter */
    public final String getTitleColor() {
        return this.titleColor;
    }

    /* JADX INFO: renamed from: isVideoSupported$clevertap_core_release, reason: from getter */
    public final boolean getIsVideoSupported() {
        return this.isVideoSupported;
    }

    /* JADX INFO: renamed from: getWidth$clevertap_core_release, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: getWidthPercentage$clevertap_core_release, reason: from getter */
    public final int getWidthPercentage() {
        return this.widthPercentage;
    }

    public CTInAppNotification(JSONObject jsonObject, boolean z) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        this._buttons = new ArrayList<>();
        this.backgroundColor = "#FFFFFF";
        this.aspectRatio = -1.0d;
        this._mediaList = new ArrayList<>();
        this.messageColor = Constants.BLACK;
        this.titleColor = Constants.BLACK;
        this.isVideoSupported = z;
        this._jsonDescription = jsonObject;
        try {
            String stringOrNull = JsonUtilsKt.getStringOrNull(jsonObject, "type");
            this.type = stringOrNull;
            if (stringOrNull != null && !Intrinsics.areEqual(stringOrNull, Constants.KEY_CUSTOM_HTML)) {
                configureWithJson(jsonObject);
                return;
            }
            legacyConfigureWithJson(jsonObject);
        } catch (JSONException e2) {
            this.error = "Invalid JSON: " + e2.getLocalizedMessage();
        }
    }

    private CTInAppNotification(Parcel parcel) {
        JSONObject jSONObject;
        this._buttons = new ArrayList<>();
        this.backgroundColor = "#FFFFFF";
        this.aspectRatio = -1.0d;
        this._mediaList = new ArrayList<>();
        this.messageColor = Constants.BLACK;
        this.titleColor = Constants.BLACK;
        this.id = parcel.readString();
        this.campaignId = parcel.readString();
        Object value = parcel.readValue(CTInAppType.class.getClassLoader());
        JSONObject jSONObject2 = null;
        this.inAppType = value instanceof CTInAppType ? (CTInAppType) value : null;
        this.html = parcel.readString();
        this.isExcludeFromCaps = parcel.readByte() != 0;
        this.isShowClose = parcel.readByte() != 0;
        this.isDarkenScreen = parcel.readByte() != 0;
        this.maxPerSession = parcel.readInt();
        this.totalLifetimeCount = parcel.readInt();
        this.totalDailyCount = parcel.readInt();
        this.position = (char) parcel.readInt();
        this.height = parcel.readInt();
        this.heightPercentage = parcel.readInt();
        this.width = parcel.readInt();
        this.widthPercentage = parcel.readInt();
        String string = parcel.readString();
        String str = EMPTY_JSON;
        this._jsonDescription = new JSONObject(string == null ? EMPTY_JSON : string);
        this.error = parcel.readString();
        if (parcel.readByte() == 0) {
            jSONObject = null;
        } else {
            String string2 = parcel.readString();
            jSONObject = new JSONObject(string2 == null ? EMPTY_JSON : string2);
        }
        this.customExtras = jSONObject;
        if (parcel.readByte() != 0) {
            String string3 = parcel.readString();
            jSONObject2 = new JSONObject(string3 != null ? string3 : str);
        }
        this._actionExtras = jSONObject2;
        this.type = parcel.readString();
        this.title = parcel.readString();
        String string4 = parcel.readString();
        this.titleColor = ColorUtilsKt.toValidColorOrFallback(string4 == null ? this.titleColor : string4, Constants.BLACK);
        String string5 = parcel.readString();
        this.backgroundColor = ColorUtilsKt.toValidColorOrFallback(string5 == null ? this.backgroundColor : string5, "#FFFFFF");
        this.message = parcel.readString();
        String string6 = parcel.readString();
        this.messageColor = ColorUtilsKt.toValidColorOrFallback(string6 == null ? this.messageColor : string6, Constants.BLACK);
        try {
            ArrayList<CTInAppNotificationButton> arrayListCreateTypedArrayList = parcel.createTypedArrayList(CTInAppNotificationButton.CREATOR);
            this._buttons = arrayListCreateTypedArrayList == null ? new ArrayList<>() : arrayListCreateTypedArrayList;
        } catch (Throwable unused) {
        }
        try {
            ArrayList<CTInAppNotificationMedia> arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(CTInAppNotificationMedia.CREATOR);
            this._mediaList = arrayListCreateTypedArrayList2 == null ? new ArrayList<>() : arrayListCreateTypedArrayList2;
        } catch (Throwable unused2) {
        }
        this.isHideCloseButton = parcel.readByte() != 0;
        this.buttonCount = parcel.readInt();
        this.isTablet = parcel.readByte() != 0;
        this.customInAppUrl = parcel.readString();
        this.isJsEnabled = parcel.readByte() != 0;
        this.isPortrait = parcel.readByte() != 0;
        this.isLandscape = parcel.readByte() != 0;
        this.isLocalInApp = parcel.readByte() != 0;
        this.fallBackToNotificationSettings = parcel.readByte() != 0;
        this.landscapeImageUrl = parcel.readString();
        this.timeToLive = parcel.readLong();
        this.customTemplateData = (CustomTemplateInAppData) parcel.readParcelable(CustomTemplateInAppData.class.getClassLoader());
        this.aspectRatio = parcel.readDouble();
        this.isRequestForPushPermission = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.campaignId);
        dest.writeValue(this.inAppType);
        dest.writeString(this.html);
        dest.writeByte(this.isExcludeFromCaps ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isShowClose ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isDarkenScreen ? (byte) 1 : (byte) 0);
        dest.writeInt(this.maxPerSession);
        dest.writeInt(this.totalLifetimeCount);
        dest.writeInt(this.totalDailyCount);
        dest.writeInt(this.position);
        dest.writeInt(this.height);
        dest.writeInt(this.heightPercentage);
        dest.writeInt(this.width);
        dest.writeInt(this.widthPercentage);
        dest.writeString(this._jsonDescription.toString());
        dest.writeString(this.error);
        if (this.customExtras == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeString(String.valueOf(this.customExtras));
        }
        if (this._actionExtras == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeString(String.valueOf(this._actionExtras));
        }
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeString(this.titleColor);
        dest.writeString(this.backgroundColor);
        dest.writeString(this.message);
        dest.writeString(this.messageColor);
        dest.writeTypedList(this._buttons);
        dest.writeTypedList(this._mediaList);
        dest.writeByte(this.isHideCloseButton ? (byte) 1 : (byte) 0);
        dest.writeInt(this.buttonCount);
        dest.writeByte(this.isTablet ? (byte) 1 : (byte) 0);
        dest.writeString(this.customInAppUrl);
        dest.writeByte(this.isJsEnabled ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isPortrait ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isLandscape ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isLocalInApp ? (byte) 1 : (byte) 0);
        dest.writeByte(this.fallBackToNotificationSettings ? (byte) 1 : (byte) 0);
        dest.writeString(this.landscapeImageUrl);
        dest.writeLong(this.timeToLive);
        dest.writeParcelable(this.customTemplateData, flags);
        dest.writeDouble(this.aspectRatio);
        dest.writeByte(this.isRequestForPushPermission ? (byte) 1 : (byte) 0);
    }

    public final boolean hasStreamMedia() {
        return !this._mediaList.isEmpty() && this._mediaList.get(0).isMediaStreamable();
    }

    public final CTInAppNotificationMedia getInAppMediaForOrientation$clevertap_core_release(int orientation) {
        Iterator<CTInAppNotificationMedia> it = this._mediaList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            CTInAppNotificationMedia cTInAppNotificationMedia = next;
            if (orientation == cTInAppNotificationMedia.getOrientation()) {
                return cTInAppNotificationMedia;
            }
        }
        return null;
    }

    public final CTInAppNotification createNotificationForAction$clevertap_core_release(CustomTemplateInAppData actionData) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.INAPP_ID_IN_PAYLOAD, this.id);
            jSONObject.put(Constants.NOTIFICATION_ID_TAG, this.campaignId);
            jSONObject.put("type", InAppActionType.CUSTOM_CODE.toString());
            jSONObject.put(Constants.KEY_EFC, 1);
            jSONObject.put(Constants.KEY_EXCLUDE_GLOBAL_CAPS, 1);
            jSONObject.put("wzrk_ttl", this.timeToLive);
            if (this._jsonDescription.has(Constants.INAPP_WZRK_PIVOT)) {
                jSONObject.put(Constants.INAPP_WZRK_PIVOT, this._jsonDescription.optString(Constants.INAPP_WZRK_PIVOT));
            }
            if (this._jsonDescription.has(Constants.INAPP_WZRK_CGID)) {
                jSONObject.put(Constants.INAPP_WZRK_CGID, this._jsonDescription.optString(Constants.INAPP_WZRK_CGID));
            }
            CTInAppNotification cTInAppNotification = new CTInAppNotification(jSONObject, this.isVideoSupported);
            cTInAppNotification.setCustomTemplateData$clevertap_core_release(actionData);
            return cTInAppNotification;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void setCustomTemplateData$clevertap_core_release(CustomTemplateInAppData inAppData) throws JSONException {
        this.customTemplateData = inAppData;
        if (inAppData != null) {
            inAppData.writeFieldsToJson$clevertap_core_release(this._jsonDescription);
        }
    }

    private final void configureWithJson(JSONObject jsonObject) {
        CTInAppNotificationMedia cTInAppNotificationMediaCreate;
        CTInAppNotificationMedia cTInAppNotificationMediaCreate2;
        try {
            this.id = jsonObject.optString(Constants.INAPP_ID_IN_PAYLOAD, "");
            this.campaignId = jsonObject.optString(Constants.NOTIFICATION_ID_TAG, "");
            this.type = jsonObject.getString("type");
            this.isLocalInApp = jsonObject.optBoolean(CTLocalInApp.IS_LOCAL_INAPP, false);
            this.fallBackToNotificationSettings = jsonObject.optBoolean(CTLocalInApp.FALLBACK_TO_NOTIFICATION_SETTINGS, false);
            int i = -1;
            this.isExcludeFromCaps = jsonObject.optInt(Constants.KEY_EFC, -1) == 1 || jsonObject.optInt(Constants.KEY_EXCLUDE_GLOBAL_CAPS, -1) == 1;
            this.totalLifetimeCount = jsonObject.optInt(Constants.KEY_TLC, -1);
            this.totalDailyCount = jsonObject.optInt(Constants.KEY_TDC, -1);
            this.maxPerSession = jsonObject.optInt(Constants.INAPP_MAX_DISPLAY_COUNT, -1);
            this.inAppType = CTInAppType.INSTANCE.fromString(this.type);
            this.isTablet = jsonObject.optBoolean(Constants.KEY_IS_TABLET, false);
            this.backgroundColor = ColorUtilsKt.toValidColorOrFallback(jsonObject.optString(Constants.KEY_BG, this.backgroundColor), "#FFFFFF");
            this.isPortrait = !jsonObject.has(Constants.KEY_PORTRAIT) || jsonObject.getBoolean(Constants.KEY_PORTRAIT);
            this.isLandscape = jsonObject.optBoolean(Constants.KEY_LANDSCAPE, false);
            this.timeToLive = jsonObject.optLong("wzrk_ttl", INSTANCE.defaultTtl());
            JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("title");
            if (jSONObjectOptJSONObject != null) {
                this.title = jSONObjectOptJSONObject.optString("text", "");
                this.titleColor = ColorUtilsKt.toValidColorOrFallback(jSONObjectOptJSONObject.optString("color", this.titleColor), Constants.BLACK);
            }
            JSONObject jSONObjectOptJSONObject2 = jsonObject.optJSONObject("message");
            if (jSONObjectOptJSONObject2 != null) {
                this.message = jSONObjectOptJSONObject2.optString("text", "");
                this.messageColor = ColorUtilsKt.toValidColorOrFallback(jSONObjectOptJSONObject2.optString("color", this.messageColor), Constants.BLACK);
            }
            this.isHideCloseButton = jsonObject.optBoolean("close", false);
            JSONObject jSONObjectOptJSONObject3 = jsonObject.optJSONObject("media");
            if (jSONObjectOptJSONObject3 != null && (cTInAppNotificationMediaCreate2 = CTInAppNotificationMedia.INSTANCE.create(jSONObjectOptJSONObject3, 1)) != null) {
                this._mediaList.add(cTInAppNotificationMediaCreate2);
            }
            JSONObject jSONObjectOptJSONObject4 = jsonObject.optJSONObject(Constants.KEY_MEDIA_LANDSCAPE);
            if (jSONObjectOptJSONObject4 != null && (cTInAppNotificationMediaCreate = CTInAppNotificationMedia.INSTANCE.create(jSONObjectOptJSONObject4, 2)) != null) {
                this._mediaList.add(cTInAppNotificationMediaCreate);
            }
            JSONArray jSONArrayOptJSONArray = jsonObject.optJSONArray(Constants.KEY_BUTTONS);
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject5 != null) {
                        this._buttons.add(new CTInAppNotificationButton(jSONObjectOptJSONObject5));
                        this.buttonCount++;
                    }
                }
            }
            this.isRequestForPushPermission = jsonObject.optBoolean(Constants.KEY_REQUEST_FOR_NOTIFICATION_PERMISSION, false);
            this.customTemplateData = CustomTemplateInAppData.INSTANCE.createFromJson(jsonObject);
            CTInAppType cTInAppType = this.inAppType;
            if (cTInAppType != null) {
                i = WhenMappings.$EnumSwitchMapping$0[cTInAppType.ordinal()];
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                    Iterator<CTInAppNotificationMedia> it = this._mediaList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        CTInAppNotificationMedia next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                        CTInAppNotificationMedia cTInAppNotificationMedia = next;
                        if (cTInAppNotificationMedia.isGIF() || cTInAppNotificationMedia.isAudio() || cTInAppNotificationMedia.isVideo()) {
                            cTInAppNotificationMedia.setMediaUrl("");
                            Logger.d("Unable to download to media. Wrong media type for template");
                        }
                    }
                    break;
                case 5:
                case 6:
                case 7:
                    if (!this._mediaList.isEmpty()) {
                        Iterator<CTInAppNotificationMedia> it2 = this._mediaList.iterator();
                        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                        while (it2.hasNext()) {
                            CTInAppNotificationMedia next2 = it2.next();
                            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                            CTInAppNotificationMedia cTInAppNotificationMedia2 = next2;
                            if (cTInAppNotificationMedia2.isGIF() || cTInAppNotificationMedia2.isAudio() || cTInAppNotificationMedia2.isVideo() || !cTInAppNotificationMedia2.isImage()) {
                                this.error = "Wrong media type for template";
                                break;
                            }
                        }
                    } else {
                        this.error = "No media type for template";
                    }
                    break;
            }
        } catch (JSONException e2) {
            this.error = "Invalid JSON: " + e2.getLocalizedMessage();
        }
    }

    private final void legacyConfigureWithJson(JSONObject jsonObject) {
        JSONObject jSONObject;
        Companion companion = INSTANCE;
        if (!validateNotifBundle(companion.getBundleFromJsonObject(jsonObject))) {
            this.error = "Invalid JSON";
            return;
        }
        try {
            this.id = jsonObject.optString(Constants.INAPP_ID_IN_PAYLOAD, "");
            this.campaignId = jsonObject.optString(Constants.NOTIFICATION_ID_TAG, "");
            boolean z = true;
            if (jsonObject.optInt(Constants.KEY_EFC, -1) != 1 && jsonObject.optInt(Constants.KEY_EXCLUDE_GLOBAL_CAPS, -1) != 1) {
                z = false;
            }
            this.isExcludeFromCaps = z;
            this.totalLifetimeCount = jsonObject.optInt(Constants.KEY_TLC, -1);
            this.totalDailyCount = jsonObject.optInt(Constants.KEY_TDC, -1);
            this.isJsEnabled = jsonObject.optBoolean(Constants.INAPP_JS_ENABLED, false);
            this.timeToLive = jsonObject.optLong("wzrk_ttl", companion.defaultTtl());
            this.isRequestForPushPermission = jsonObject.optBoolean(Constants.KEY_REQUEST_FOR_NOTIFICATION_PERMISSION, false);
            JSONObject jSONObjectOptJSONObject = jsonObject.optJSONObject("d");
            if (jSONObjectOptJSONObject != null) {
                this.html = jSONObjectOptJSONObject.getString("html");
                this.customInAppUrl = jSONObjectOptJSONObject.optString("url", "");
                if (jSONObjectOptJSONObject.optJSONObject(Constants.KEY_KV) != null) {
                    jSONObject = jSONObjectOptJSONObject.getJSONObject(Constants.KEY_KV);
                } else {
                    jSONObject = new JSONObject();
                }
                this.customExtras = jSONObject;
                JSONObject jSONObjectOptJSONObject2 = jsonObject.optJSONObject(Constants.INAPP_WINDOW);
                if (jSONObjectOptJSONObject2 != null) {
                    this.isDarkenScreen = jSONObjectOptJSONObject2.getBoolean(Constants.INAPP_NOTIF_DARKEN_SCREEN);
                    this.isShowClose = jSONObjectOptJSONObject2.getBoolean(Constants.INAPP_NOTIF_SHOW_CLOSE);
                    this.position = jSONObjectOptJSONObject2.getString(Constants.INAPP_POSITION).charAt(0);
                    this.width = jSONObjectOptJSONObject2.optInt(Constants.INAPP_X_DP, 0);
                    this.widthPercentage = jSONObjectOptJSONObject2.optInt(Constants.INAPP_X_PERCENT, 0);
                    this.height = jSONObjectOptJSONObject2.optInt(Constants.INAPP_Y_DP, 0);
                    this.heightPercentage = jSONObjectOptJSONObject2.optInt(Constants.INAPP_Y_PERCENT, 0);
                    this.maxPerSession = jSONObjectOptJSONObject2.optInt(Constants.INAPP_MAX_DISPLAY_COUNT, -1);
                    double dOptDouble = jSONObjectOptJSONObject2.optDouble(Constants.INAPP_ASPECT_RATIO, -1.0d);
                    this.aspectRatio = dOptDouble;
                    if (dOptDouble <= 0.0d) {
                        this.aspectRatio = -1.0d;
                    }
                }
                if (this.html != null) {
                    char c2 = this.position;
                    if (c2 == 't') {
                        if (this.aspectRatio != -1.0d || (this.widthPercentage == 100 && this.heightPercentage <= 30)) {
                            this.inAppType = CTInAppType.CTInAppTypeHeaderHTML;
                            return;
                        }
                        return;
                    }
                    if (c2 == 'b') {
                        if (this.aspectRatio != -1.0d || (this.widthPercentage == 100 && this.heightPercentage <= 30)) {
                            this.inAppType = CTInAppType.CTInAppTypeFooterHTML;
                            return;
                        }
                        return;
                    }
                    if (c2 == 'c') {
                        int i = this.widthPercentage;
                        if (i == 90 && this.heightPercentage == 85) {
                            this.inAppType = CTInAppType.CTInAppTypeInterstitialHTML;
                            return;
                        }
                        if (i == 100 && this.heightPercentage == 100) {
                            this.inAppType = CTInAppType.CTInAppTypeCoverHTML;
                        } else if (i == 90 && this.heightPercentage == 50) {
                            this.inAppType = CTInAppType.CTInAppTypeHalfInterstitialHTML;
                        }
                    }
                }
            }
        } catch (JSONException unused) {
            this.error = "Invalid JSON";
        }
    }

    private final boolean isKeyValid(Bundle b2, String key, KClass<?> type) {
        return b2.containsKey(key) && type.isInstance(b2.get(key));
    }

    private final boolean validateNotifBundle(Bundle notif) {
        try {
            Bundle bundle = notif.getBundle(Constants.INAPP_WINDOW);
            Bundle bundle2 = notif.getBundle("d");
            if (bundle == null || bundle2 == null || !(isKeyValid(bundle, Constants.INAPP_X_DP, Reflection.getOrCreateKotlinClass(Integer.class)) || isKeyValid(bundle, Constants.INAPP_X_PERCENT, Reflection.getOrCreateKotlinClass(Integer.class)))) {
                return false;
            }
            if ((isKeyValid(bundle, Constants.INAPP_Y_DP, Reflection.getOrCreateKotlinClass(Integer.class)) || isKeyValid(bundle, Constants.INAPP_Y_PERCENT, Reflection.getOrCreateKotlinClass(Integer.class))) && isKeyValid(bundle, Constants.INAPP_NOTIF_DARKEN_SCREEN, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) && isKeyValid(bundle, Constants.INAPP_NOTIF_SHOW_CLOSE, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) && isKeyValid(bundle2, "html", Reflection.getOrCreateKotlinClass(String.class)) && isKeyValid(bundle, Constants.INAPP_POSITION, Reflection.getOrCreateKotlinClass(String.class))) {
                String string = bundle.getString(Constants.INAPP_POSITION);
                Intrinsics.checkNotNull(string);
                char cCharAt = string.charAt(0);
                return cCharAt == 't' || cCharAt == 'r' || cCharAt == 'b' || cCharAt == 'l' || cCharAt == 'c';
            }
            return false;
        } catch (Throwable th) {
            Logger.v("Failed to parse in-app notification!", th);
            return false;
        }
    }

    /* JADX INFO: compiled from: CTInAppNotification.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/inapp/CTInAppNotification$Companion;", "", "<init>", "()V", "HTML_DEFAULT_ASPECT_RATIO", "", "EMPTY_JSON", "", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/clevertap/android/sdk/inapp/CTInAppNotification;", "defaultTtl", "", "getBundleFromJsonObject", "Landroid/os/Bundle;", "notif", "Lorg/json/JSONObject;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long defaultTtl() {
            return (System.currentTimeMillis() + 172800000) / ((long) 1000);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle getBundleFromJsonObject(JSONObject notif) {
            Bundle bundle = new Bundle();
            Iterator<String> itKeys = notif.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                String str = next;
                try {
                    Object obj = notif.get(str);
                    if (obj instanceof String) {
                        bundle.putString(str, (String) obj);
                    } else if (obj instanceof Character) {
                        bundle.putChar(str, ((Character) obj).charValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str, ((Number) obj).intValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(str, ((Number) obj).floatValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str, ((Number) obj).doubleValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str, ((Number) obj).longValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof JSONObject) {
                        bundle.putBundle(str, getBundleFromJsonObject((JSONObject) obj));
                    }
                } catch (JSONException unused) {
                    Logger.v("Key had unknown object. Discarding");
                }
            }
            return bundle;
        }
    }
}
