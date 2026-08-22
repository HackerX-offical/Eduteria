package org.jivesoftware.smack.debugger;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPConnection;

/* JADX INFO: loaded from: classes10.dex */
public class JulDebugger extends AbstractDebugger {
    private static final Logger LOGGER = Logger.getLogger(JulDebugger.class.getName());

    public JulDebugger(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    protected void log(String str) {
        LOGGER.fine(str);
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    protected void log(String str, Throwable th) {
        LOGGER.log(Level.FINE, str, th);
    }
}
