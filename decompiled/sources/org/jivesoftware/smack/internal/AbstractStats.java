package org.jivesoftware.smack.internal;

import java.io.IOException;
import org.jivesoftware.smack.util.ExtendedAppendable;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractStats {
    private transient String toStringCache;

    public abstract void appendStatsTo(ExtendedAppendable extendedAppendable) throws IOException;

    public final void appendStatsTo(Appendable appendable) throws IOException {
        appendStatsTo(new ExtendedAppendable(appendable));
    }

    public final String toString() {
        String str = this.toStringCache;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        try {
            appendStatsTo(sb);
            String string = sb.toString();
            this.toStringCache = string;
            return string;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
