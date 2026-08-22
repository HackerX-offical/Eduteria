package org.jivesoftware.smack.parsing;

import java.net.URISyntaxException;
import java.text.ParseException;

/* JADX INFO: loaded from: classes10.dex */
public class SmackParsingException extends Exception {
    private static final long serialVersionUID = 1;

    protected SmackParsingException(Exception exc) {
        super(exc);
    }

    public SmackParsingException(String str) {
        super(str);
    }

    public static class SmackTextParseException extends SmackParsingException {
        private static final long serialVersionUID = 1;

        public SmackTextParseException(ParseException parseException) {
            super(parseException);
        }
    }

    public static class SmackUriSyntaxParsingException extends SmackParsingException {
        private static final long serialVersionUID = 1;

        public SmackUriSyntaxParsingException(URISyntaxException uRISyntaxException) {
            super(uRISyntaxException);
        }
    }

    public static class RequiredValueMissingException extends SmackParsingException {
        private static final long serialVersionUID = 1;

        public RequiredValueMissingException(String str) {
            super(str);
        }
    }

    public static class RequiredAttributeMissingException extends RequiredValueMissingException {
        private static final long serialVersionUID = 1;

        public RequiredAttributeMissingException(String str) {
            super("The required attribute '" + str + "' is missing (or has the empty String as value)");
        }
    }
}
