package com.microsoft.clarity.models.ingest;

import com.csvreader.CsvReader;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\n\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/microsoft/clarity/models/ingest/BaseWebViewEvent;", "Lcom/microsoft/clarity/models/ingest/SessionEvent;", "webViewHashCode", "", "data", "", "absoluteTimestamp", "", "webViewActivityName", "webViewActivityHashCode", "type", "(ILjava/lang/String;JLjava/lang/String;II)V", "getAbsoluteTimestamp", "()J", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "Lcom/microsoft/clarity/models/ingest/EventType;", "getType", "()Lcom/microsoft/clarity/models/ingest/EventType;", "getWebViewActivityHashCode", "()I", "getWebViewActivityName", "getWebViewHashCode", "serialize", "setTimestamp", "", "timestamp", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseWebViewEvent extends SessionEvent {
    private final long absoluteTimestamp;
    private String data;
    private final EventType type;
    private final int webViewActivityHashCode;
    private final String webViewActivityName;
    private final int webViewHashCode;

    public BaseWebViewEvent(int i, String data, long j, String webViewActivityName, int i2, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(webViewActivityName, "webViewActivityName");
        this.webViewHashCode = i;
        this.data = data;
        this.absoluteTimestamp = j;
        this.webViewActivityName = webViewActivityName;
        this.webViewActivityHashCode = i2;
        for (EventType eventType : EventType.values()) {
            if (eventType.getCustomOrdinal() == i3) {
                this.type = eventType;
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public final long getAbsoluteTimestamp() {
        return this.absoluteTimestamp;
    }

    public final String getData() {
        return this.data;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    public final int getWebViewActivityHashCode() {
        return this.webViewActivityHashCode;
    }

    public final String getWebViewActivityName() {
        return this.webViewActivityName;
    }

    public final int getWebViewHashCode() {
        return this.webViewHashCode;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        return this.data;
    }

    public final void setData(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.data = str;
    }

    public final void setTimestamp(long timestamp) {
        this.data = StringsKt.replaceRange((CharSequence) this.data, RangesKt.until(1, StringsKt.indexOf$default((CharSequence) this.data, CsvReader.Letters.COMMA, 0, false, 6, (Object) null)), (CharSequence) String.valueOf(timestamp)).toString();
    }
}
