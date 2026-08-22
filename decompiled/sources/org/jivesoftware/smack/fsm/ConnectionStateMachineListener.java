package org.jivesoftware.smack.fsm;

import org.jivesoftware.smack.c2s.ModularXmppClientToServerConnection;

/* JADX INFO: loaded from: classes10.dex */
public interface ConnectionStateMachineListener {
    void onConnectionStateEvent(ConnectionStateEvent connectionStateEvent, ModularXmppClientToServerConnection modularXmppClientToServerConnection);
}
