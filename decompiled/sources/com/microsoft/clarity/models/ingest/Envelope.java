package com.microsoft.clarity.models.ingest;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.csvreader.CsvReader;
import com.microsoft.clarity.models.SessionMetadata;
import com.microsoft.clarity.n.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/microsoft/clarity/models/ingest/Envelope;", "", "sessionMetadata", "Lcom/microsoft/clarity/models/SessionMetadata;", "pageNum", "", "sequence", "start", "", TypedValues.TransitionType.S_DURATION, "(Lcom/microsoft/clarity/models/SessionMetadata;IIJJ)V", "end", "platform", "upload", "serialize", "", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Envelope {
    private final long duration;
    private final int end;
    private final int pageNum;
    private final int platform;
    private final int sequence;
    private final SessionMetadata sessionMetadata;
    private final long start;
    private final int upload;

    public Envelope(SessionMetadata sessionMetadata, int i, int i2, long j, long j2) {
        Intrinsics.checkNotNullParameter(sessionMetadata, "sessionMetadata");
        this.sessionMetadata = sessionMetadata;
        this.pageNum = i;
        this.sequence = i2;
        this.start = j;
        this.duration = j2;
        this.platform = 1;
    }

    public final String serialize() {
        String strA = k.a(this.sessionMetadata.getVersion());
        String strA2 = k.a(this.sessionMetadata.getProjectId());
        String strA3 = k.a(this.sessionMetadata.getUserId());
        String strA4 = k.a(this.sessionMetadata.getSessionId());
        StringBuilder sb = new StringBuilder("[\"");
        sb.append(strA).append("\",").append(this.sequence).append(CsvReader.Letters.COMMA).append(this.start).append(CsvReader.Letters.COMMA).append(this.duration).append(",\"").append(strA2).append("\",\"").append(strA3).append("\",\"").append(strA4).append("\",").append(this.pageNum).append(CsvReader.Letters.COMMA).append(this.upload).append(CsvReader.Letters.COMMA).append(this.end).append(CsvReader.Letters.COMMA).append(this.platform).append(']');
        return sb.toString();
    }
}
