package com.microsoft.clarity.models;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.microsoft.clarity.models.ingest.IngestConfigs;
import com.microsoft.clarity.n.i;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u00060\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0011R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0011R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0011R\u001f\u0010+\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0011R\u001f\u0010-\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0011¨\u00060"}, d2 = {"Lcom/microsoft/clarity/models/DynamicConfig;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "ingestUrl", "", "getIngestUrl", "()Ljava/lang/String;", "isClarityActivated", "", "()Z", "leanMode", "getLeanMode", "maskedActivities", "", "getMaskedActivities", "()Ljava/util/Set;", "maskedClasses", "getMaskedClasses", "maskedFragments", "getMaskedFragments", "maskedIds", "getMaskedIds", "maskingMode", "Lcom/microsoft/clarity/models/MaskingMode;", "getMaskingMode", "()Lcom/microsoft/clarity/models/MaskingMode;", "nativeMaskSelectors", "kotlin.jvm.PlatformType", "nativeUnmaskSelectors", "preferences", "Landroid/content/SharedPreferences;", "reportUrl", "getReportUrl", "unmaskedActivities", "getUnmaskedActivities", "unmaskedClasses", "getUnmaskedClasses", "unmaskedFragments", "getUnmaskedFragments", "unmaskedIds", "getUnmaskedIds", "webMaskSelectors", "getWebMaskSelectors", "webUnmaskSelectors", "getWebUnmaskSelectors", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String ingestUrl;
    private final boolean isClarityActivated;
    private final boolean leanMode;
    private final Set<String> maskedActivities;
    private final Set<String> maskedClasses;
    private final Set<String> maskedFragments;
    private final Set<String> maskedIds;
    private final MaskingMode maskingMode;
    private final Set<String> nativeMaskSelectors;
    private final Set<String> nativeUnmaskSelectors;
    private final SharedPreferences preferences;
    private final String reportUrl;
    private final Set<String> unmaskedActivities;
    private final Set<String> unmaskedClasses;
    private final Set<String> unmaskedFragments;
    private final Set<String> unmaskedIds;
    private final Set<String> webMaskSelectors;
    private final Set<String> webUnmaskSelectors;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/microsoft/clarity/models/DynamicConfig$Companion;", "", "()V", "getPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "isFetched", "", "updateSharedPreferences", "", "ingestConfigs", "Lcom/microsoft/clarity/models/ingest/IngestConfigs;", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SharedPreferences getPreferences(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getSharedPreferences("CLARITY_SHARED_PREFERENCES", 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…le, Context.MODE_PRIVATE)");
            return sharedPreferences;
        }

        public final boolean isFetched(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getPreferences(context).contains("CLARITY_CONFIG_FETCHED");
        }

        public final void updateSharedPreferences(Context context, IngestConfigs ingestConfigs) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ingestConfigs, "ingestConfigs");
            SharedPreferences.Editor editorEdit = getPreferences(context).edit();
            editorEdit.putBoolean("CLARITY_CONFIG_FETCHED", true);
            editorEdit.putBoolean("CLARITY_ACTIVATED", ingestConfigs.getActivate());
            editorEdit.putBoolean("LEAN_MODE_ACTIVATED", ingestConfigs.getLean());
            editorEdit.putString("REPORT_URL", ingestConfigs.getReportUrl());
            editorEdit.putString("INGEST_URL", ingestConfigs.getIngestUrl());
            editorEdit.putString("MASKING_MODE", ingestConfigs.getMaskingMode().toString());
            editorEdit.putStringSet("MASKED_WEB_ELEMENTS_LIST", ingestConfigs.getWebMaskSelectors());
            editorEdit.putStringSet("UNMASKED_WEB_ELEMENTS_LIST", ingestConfigs.getWebUnmaskSelectors());
            editorEdit.putStringSet("MASKED_NATIVE_LIST", ingestConfigs.getNativeMaskSelectors());
            editorEdit.putStringSet("UNMASKED_NATIVE_LIST", ingestConfigs.getNativeUnmaskSelectors());
            editorEdit.apply();
            i.b("Clarity shared preferences updated.");
        }
    }

    public DynamicConfig(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Companion companion = INSTANCE;
        SharedPreferences preferences = companion.getPreferences(context);
        this.preferences = preferences;
        if (!companion.isFetched(context)) {
            throw new IllegalStateException("Dynamic config has not been fetched yet!");
        }
        String string = preferences.getString("MASKING_MODE", "Strict");
        this.maskingMode = MaskingMode.valueOf(string != null ? string : "Strict");
        Set<String> stringSet = preferences.getStringSet("MASKED_WEB_ELEMENTS_LIST", SetsKt.emptySet());
        this.webMaskSelectors = stringSet == null ? SetsKt.emptySet() : stringSet;
        Set<String> stringSet2 = preferences.getStringSet("UNMASKED_WEB_ELEMENTS_LIST", SetsKt.emptySet());
        this.webUnmaskSelectors = stringSet2 == null ? SetsKt.emptySet() : stringSet2;
        Set<String> stringSet3 = preferences.getStringSet("MASKED_NATIVE_LIST", SetsKt.emptySet());
        stringSet3 = stringSet3 == null ? SetsKt.emptySet() : stringSet3;
        this.nativeMaskSelectors = stringSet3;
        Set<String> stringSet4 = preferences.getStringSet("UNMASKED_NATIVE_LIST", SetsKt.emptySet());
        this.nativeUnmaskSelectors = stringSet4 == null ? SetsKt.emptySet() : stringSet4;
        this.leanMode = preferences.getBoolean("LEAN_MODE_ACTIVATED", false);
        this.isClarityActivated = preferences.getBoolean("CLARITY_ACTIVATED", false);
        String string2 = preferences.getString("INGEST_URL", "https://www.clarity.ms/eus2/");
        this.ingestUrl = string2 != null ? string2 : "https://www.clarity.ms/eus2/";
        String string3 = preferences.getString("REPORT_URL", "https://www.clarity.ms/");
        this.reportUrl = string3 != null ? string3 : "https://www.clarity.ms/";
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : stringSet3) {
            String it = (String) obj;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (StringsKt.startsWith$default(it, InstructionFileId.DOT, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (String it2 : arrayList) {
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            arrayList2.add(StringsKt.drop(it2, 1));
        }
        this.maskedClasses = CollectionsKt.toSet(arrayList2);
        Set<String> set = this.nativeUnmaskSelectors;
        ArrayList<String> arrayList3 = new ArrayList();
        for (Object obj2 : set) {
            String it3 = (String) obj2;
            Intrinsics.checkNotNullExpressionValue(it3, "it");
            if (StringsKt.startsWith$default(it3, InstructionFileId.DOT, false, 2, (Object) null)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (String it4 : arrayList3) {
            Intrinsics.checkNotNullExpressionValue(it4, "it");
            arrayList4.add(StringsKt.drop(it4, 1));
        }
        this.unmaskedClasses = CollectionsKt.toSet(arrayList4);
        Set<String> set2 = this.nativeMaskSelectors;
        ArrayList<String> arrayList5 = new ArrayList();
        for (Object obj3 : set2) {
            String it5 = (String) obj3;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            if (StringsKt.startsWith$default(it5, "&", false, 2, (Object) null)) {
                arrayList5.add(obj3);
            }
        }
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        for (String it6 : arrayList5) {
            Intrinsics.checkNotNullExpressionValue(it6, "it");
            arrayList6.add(StringsKt.drop(it6, 1));
        }
        this.maskedActivities = CollectionsKt.toSet(arrayList6);
        Set<String> set3 = this.nativeUnmaskSelectors;
        ArrayList<String> arrayList7 = new ArrayList();
        for (Object obj4 : set3) {
            String it7 = (String) obj4;
            Intrinsics.checkNotNullExpressionValue(it7, "it");
            if (StringsKt.startsWith$default(it7, "&", false, 2, (Object) null)) {
                arrayList7.add(obj4);
            }
        }
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        for (String it8 : arrayList7) {
            Intrinsics.checkNotNullExpressionValue(it8, "it");
            arrayList8.add(StringsKt.drop(it8, 1));
        }
        this.unmaskedActivities = CollectionsKt.toSet(arrayList8);
        Set<String> set4 = this.nativeMaskSelectors;
        ArrayList<String> arrayList9 = new ArrayList();
        for (Object obj5 : set4) {
            String it9 = (String) obj5;
            Intrinsics.checkNotNullExpressionValue(it9, "it");
            if (StringsKt.startsWith$default(it9, "*", false, 2, (Object) null)) {
                arrayList9.add(obj5);
            }
        }
        ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
        for (String it10 : arrayList9) {
            Intrinsics.checkNotNullExpressionValue(it10, "it");
            arrayList10.add(StringsKt.drop(it10, 1));
        }
        this.maskedFragments = CollectionsKt.toSet(arrayList10);
        Set<String> set5 = this.nativeUnmaskSelectors;
        ArrayList<String> arrayList11 = new ArrayList();
        for (Object obj6 : set5) {
            String it11 = (String) obj6;
            Intrinsics.checkNotNullExpressionValue(it11, "it");
            if (StringsKt.startsWith$default(it11, "*", false, 2, (Object) null)) {
                arrayList11.add(obj6);
            }
        }
        ArrayList arrayList12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList11, 10));
        for (String it12 : arrayList11) {
            Intrinsics.checkNotNullExpressionValue(it12, "it");
            arrayList12.add(StringsKt.drop(it12, 1));
        }
        this.unmaskedFragments = CollectionsKt.toSet(arrayList12);
        Set<String> set6 = this.nativeMaskSelectors;
        ArrayList<String> arrayList13 = new ArrayList();
        for (Object obj7 : set6) {
            String it13 = (String) obj7;
            Intrinsics.checkNotNullExpressionValue(it13, "it");
            if (StringsKt.startsWith$default(it13, MqttTopic.MULTI_LEVEL_WILDCARD, false, 2, (Object) null)) {
                arrayList13.add(obj7);
            }
        }
        ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList13, 10));
        for (String it14 : arrayList13) {
            Intrinsics.checkNotNullExpressionValue(it14, "it");
            arrayList14.add(StringsKt.drop(it14, 1));
        }
        this.maskedIds = CollectionsKt.toSet(arrayList14);
        Set<String> set7 = this.nativeUnmaskSelectors;
        ArrayList<String> arrayList15 = new ArrayList();
        for (Object obj8 : set7) {
            String it15 = (String) obj8;
            Intrinsics.checkNotNullExpressionValue(it15, "it");
            if (StringsKt.startsWith$default(it15, MqttTopic.MULTI_LEVEL_WILDCARD, false, 2, (Object) null)) {
                arrayList15.add(obj8);
            }
        }
        ArrayList arrayList16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList15, 10));
        for (String it16 : arrayList15) {
            Intrinsics.checkNotNullExpressionValue(it16, "it");
            arrayList16.add(StringsKt.drop(it16, 1));
        }
        this.unmaskedIds = CollectionsKt.toSet(arrayList16);
    }

    public final String getIngestUrl() {
        return this.ingestUrl;
    }

    public final boolean getLeanMode() {
        return this.leanMode;
    }

    public final Set<String> getMaskedActivities() {
        return this.maskedActivities;
    }

    public final Set<String> getMaskedClasses() {
        return this.maskedClasses;
    }

    public final Set<String> getMaskedFragments() {
        return this.maskedFragments;
    }

    public final Set<String> getMaskedIds() {
        return this.maskedIds;
    }

    public final MaskingMode getMaskingMode() {
        return this.maskingMode;
    }

    public final String getReportUrl() {
        return this.reportUrl;
    }

    public final Set<String> getUnmaskedActivities() {
        return this.unmaskedActivities;
    }

    public final Set<String> getUnmaskedClasses() {
        return this.unmaskedClasses;
    }

    public final Set<String> getUnmaskedFragments() {
        return this.unmaskedFragments;
    }

    public final Set<String> getUnmaskedIds() {
        return this.unmaskedIds;
    }

    public final Set<String> getWebMaskSelectors() {
        return this.webMaskSelectors;
    }

    public final Set<String> getWebUnmaskSelectors() {
        return this.webUnmaskSelectors;
    }

    /* JADX INFO: renamed from: isClarityActivated, reason: from getter */
    public final boolean getIsClarityActivated() {
        return this.isClarityActivated;
    }
}
