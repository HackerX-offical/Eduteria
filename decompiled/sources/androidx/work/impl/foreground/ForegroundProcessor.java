package androidx.work.impl.foreground;

import androidx.work.ForegroundInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface ForegroundProcessor {
    void startForeground(String workSpecId, ForegroundInfo foregroundInfo);
}
