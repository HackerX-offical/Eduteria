package org.jivesoftware.smack.parsing;

import java.io.IOException;
import org.jivesoftware.smack.UnparseableStanza;

/* JADX INFO: loaded from: classes10.dex */
public class ExceptionThrowingCallback implements ParsingExceptionCallback {
    @Override // org.jivesoftware.smack.parsing.ParsingExceptionCallback
    public void handleUnparsableStanza(UnparseableStanza unparseableStanza) throws IOException {
        throw new IOException(unparseableStanza.getParsingException());
    }
}
