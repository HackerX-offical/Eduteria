package org.jivesoftware.smack.parsing;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.UnparseableStanza;

/* JADX INFO: loaded from: classes10.dex */
public class ExceptionLoggingCallback implements ParsingExceptionCallback {
    private static final Logger LOGGER = Logger.getLogger(ExceptionLoggingCallback.class.getName());

    @Override // org.jivesoftware.smack.parsing.ParsingExceptionCallback
    public void handleUnparsableStanza(UnparseableStanza unparseableStanza) {
        LOGGER.log(Level.SEVERE, "Smack message parsing exception. Content: '" + ((Object) unparseableStanza.getContent()) + "'", (Throwable) unparseableStanza.getParsingException());
    }
}
