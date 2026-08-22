package com.amazonaws.services.s3;

import com.amazonaws.services.s3.internal.FileDeletionEvent;

/* JADX INFO: loaded from: classes4.dex */
public interface OnFileDelete {
    void onFileDelete(FileDeletionEvent fileDeletionEvent);
}
