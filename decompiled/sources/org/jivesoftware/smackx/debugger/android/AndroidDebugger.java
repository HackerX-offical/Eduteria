package org.jivesoftware.smackx.debugger.android;

import android.util.Log;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.debugger.AbstractDebugger;

/* JADX INFO: loaded from: classes10.dex */
public class AndroidDebugger extends AbstractDebugger {
    public AndroidDebugger(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    protected void log(String str) {
        Log.d("SMACK", str);
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    protected void log(String str, Throwable th) {
        Log.d("SMACK", str, th);
    }
}
