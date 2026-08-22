package com.microsoft.clarity.models.observers;

import com.csvreader.CsvReader;
import com.microsoft.clarity.models.ingest.EventType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0003J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/microsoft/clarity/models/observers/SerializedWebViewEvent;", "Lcom/microsoft/clarity/models/observers/ObservedEvent;", "data", "", "absoluteTimestamp", "", "activityHashCode", "", "activityName", "webViewHashCode", "(Ljava/lang/String;JILjava/lang/String;I)V", "getActivityHashCode", "()I", "getActivityName", "()Ljava/lang/String;", "getData", "json", "Lorg/json/JSONArray;", "getJson", "()Lorg/json/JSONArray;", "json$delegate", "Lkotlin/Lazy;", "getWebViewHashCode", "getPageUrl", "getType", "isAnalyticsEvent", "", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SerializedWebViewEvent extends ObservedEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int activityHashCode;
    private final String activityName;
    private final String data;

    /* JADX INFO: renamed from: json$delegate, reason: from kotlin metadata */
    private final Lazy json;
    private final int webViewHashCode;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002¨\u0006\u000e"}, d2 = {"Lcom/microsoft/clarity/models/observers/SerializedWebViewEvent$Companion;", "", "()V", "create", "Lcom/microsoft/clarity/models/observers/SerializedWebViewEvent;", "data", "", "activityHashCode", "", "activityName", "webViewHashCode", "getEventAbsoluteTimestamp", "", "event", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final long getEventAbsoluteTimestamp(String event) {
            String strSubstring = event.substring(1, StringsKt.indexOf$default((CharSequence) event, CsvReader.Letters.COMMA, 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return Long.parseLong(strSubstring);
        }

        public final SerializedWebViewEvent create(String data, int activityHashCode, String activityName, int webViewHashCode) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            return new SerializedWebViewEvent(data, getEventAbsoluteTimestamp(data), activityHashCode, activityName, webViewHashCode, null);
        }
    }

    private SerializedWebViewEvent(String str, long j, int i, String str2, int i2) {
        super(j);
        this.data = str;
        this.activityHashCode = i;
        this.activityName = str2;
        this.webViewHashCode = i2;
        this.json = LazyKt.lazy(new Function0<JSONArray>() { // from class: com.microsoft.clarity.models.observers.SerializedWebViewEvent$json$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final JSONArray invoke() {
                return new JSONArray(this.this$0.getData());
            }
        });
    }

    public /* synthetic */ SerializedWebViewEvent(String str, long j, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, i, str2, i2);
    }

    private final JSONArray getJson() {
        return (JSONArray) this.json.getValue();
    }

    public final int getActivityHashCode() {
        return this.activityHashCode;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getData() {
        return this.data;
    }

    public final String getPageUrl() throws JSONException, IllegalAccessException {
        if (isAnalyticsEvent()) {
            throw new IllegalAccessException("Page Url is not available for analytics events!");
        }
        String string = getJson().getString(5);
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(5)");
        return string;
    }

    public final int getType() {
        return getJson().getInt(1);
    }

    public final int getWebViewHashCode() {
        return this.webViewHashCode;
    }

    public final boolean isAnalyticsEvent() {
        return (getType() == EventType.WebViewDiscover.getCustomOrdinal() || getType() == EventType.WebViewMutation.getCustomOrdinal()) ? false : true;
    }
}
