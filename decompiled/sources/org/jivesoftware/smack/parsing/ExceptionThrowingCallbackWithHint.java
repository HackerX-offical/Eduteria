package org.jivesoftware.smack.parsing;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.UnparseableStanza;

/* JADX INFO: loaded from: classes10.dex */
public class ExceptionThrowingCallbackWithHint extends ExceptionThrowingCallback {
    private static final Logger LOGGER = Logger.getLogger(ExceptionThrowingCallbackWithHint.class.getName());

    @Override // org.jivesoftware.smack.parsing.ExceptionThrowingCallback, org.jivesoftware.smack.parsing.ParsingExceptionCallback
    public void handleUnparsableStanza(UnparseableStanza unparseableStanza) throws IOException {
        LOGGER.warning("Parsing exception encountered. This exception will be re-thrown, leading to a disconnect. You can change this behavior by setting a different ParsingExceptionCallback using setParsingExceptionCallback(). More information an be found in AbstractXMPPConnection's javadoc.");
        super.handleUnparsableStanza(unparseableStanza);
    }
}
