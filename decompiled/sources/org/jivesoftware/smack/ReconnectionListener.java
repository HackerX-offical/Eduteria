package org.jivesoftware.smack;

/* JADX INFO: loaded from: classes10.dex */
public interface ReconnectionListener {
    void reconnectingIn(int i);

    void reconnectionFailed(Exception exc);
}
