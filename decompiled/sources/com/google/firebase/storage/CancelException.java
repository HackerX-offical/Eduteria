package com.google.firebase.storage;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
class CancelException extends IOException {
    CancelException() {
        super("The operation was canceled.");
    }
}
