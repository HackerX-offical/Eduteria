package org.jivesoftware.smack.parsing;

import java.io.IOException;
import org.jivesoftware.smack.UnparseableStanza;

/* JADX INFO: loaded from: classes10.dex */
public interface ParsingExceptionCallback {
    void handleUnparsableStanza(UnparseableStanza unparseableStanza) throws IOException;
}
