package com.amazonaws.services.s3.internal;

import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public interface ObjectRestoreResult {
    Boolean getOngoingRestore();

    Date getRestoreExpirationTime();

    void setOngoingRestore(boolean z);

    void setRestoreExpirationTime(Date date);
}
