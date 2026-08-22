package com.google.firebase.database.tubesock;

/* JADX INFO: compiled from: com.google.firebase:firebase-database@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface WebSocketEventHandler {
    void onClose();

    void onError(WebSocketException webSocketException);

    void onLogMessage(String str);

    void onMessage(WebSocketMessage webSocketMessage);

    void onOpen();
}
