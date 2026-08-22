package org.jivesoftware.smack.debugger;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.util.ExceptionUtil;

/* JADX INFO: loaded from: classes10.dex */
public class ConsoleDebugger extends AbstractDebugger {
    private final SimpleDateFormat dateFormatter;

    public ConsoleDebugger(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.dateFormatter = new SimpleDateFormat("HH:mm:ss");
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    protected void log(String str) {
        String str2;
        synchronized (this.dateFormatter) {
            str2 = this.dateFormatter.format(new Date());
        }
        System.out.println(str2 + ' ' + str);
    }

    @Override // org.jivesoftware.smack.debugger.AbstractDebugger
    protected void log(String str, Throwable th) {
        log(str + '\n' + ExceptionUtil.getStackTrace(th));
    }

    public static final class Factory implements SmackDebuggerFactory {
        public static final SmackDebuggerFactory INSTANCE = new Factory();

        private Factory() {
        }

        @Override // org.jivesoftware.smack.debugger.SmackDebuggerFactory
        public SmackDebugger create(XMPPConnection xMPPConnection) throws IllegalArgumentException {
            return new ConsoleDebugger(xMPPConnection);
        }
    }
}
