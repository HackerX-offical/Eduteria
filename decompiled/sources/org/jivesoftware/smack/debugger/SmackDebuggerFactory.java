package org.jivesoftware.smack.debugger;

import org.jivesoftware.smack.XMPPConnection;

/* JADX INFO: loaded from: classes10.dex */
public interface SmackDebuggerFactory {
    SmackDebugger create(XMPPConnection xMPPConnection) throws IllegalArgumentException;
}
