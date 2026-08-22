package org.jxmpp.xml.splitter;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class InvalidXmlException extends IOException {
    private static final long serialVersionUID = 1;
    private final char unexpectedChar;
    private final String xml;

    protected InvalidXmlException(CharSequence charSequence, char c2, CharSequence charSequence2) {
        super(charSequence.toString());
        this.unexpectedChar = c2;
        this.xml = charSequence2.toString();
    }

    public char getUnexpectedChar() {
        return this.unexpectedChar;
    }

    public String getParsedXmlSoFar() {
        return this.xml;
    }

    public static final class InvalidEmptyTagException extends InvalidXmlException {
        private static final long serialVersionUID = 1;

        private InvalidEmptyTagException(CharSequence charSequence, char c2, CharSequence charSequence2) {
            super(charSequence, c2, charSequence2);
        }

        public static InvalidEmptyTagException create(char c2, CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid empty tag, expected '>', but got '").append(c2).append("'. Parsed xml so far: ").append(charSequence);
            return new InvalidEmptyTagException(sb, c2, charSequence);
        }
    }

    public static final class InvalidAttributeDeclarationException extends InvalidXmlException {
        private static final long serialVersionUID = 1;

        private InvalidAttributeDeclarationException(CharSequence charSequence, char c2, CharSequence charSequence2) {
            super(charSequence, c2, charSequence2);
        }

        public static InvalidAttributeDeclarationException create(char c2, CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid attribute declaration, expected ''' or '\"', but got '").append(c2).append("'. Parsed xml so far: ").append(charSequence);
            return new InvalidAttributeDeclarationException(sb, c2, charSequence);
        }
    }
}
