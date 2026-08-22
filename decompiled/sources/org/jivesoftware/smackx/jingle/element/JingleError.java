package org.jivesoftware.smackx.jingle.element;

import java.util.Locale;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public final class JingleError implements ExtensionElement {
    public static String NAMESPACE = "urn:xmpp:jingle:errors:1";
    public static final JingleError OUT_OF_ORDER = new JingleError("out-of-order");
    public static final JingleError TIE_BREAK = new JingleError("tie-break");
    public static final JingleError UNKNOWN_SESSION = new JingleError("unknown-session");
    public static final JingleError UNSUPPORTED_INFO = new JingleError("unsupported-info");
    private final String errorName;

    private JingleError(String str) {
        this.errorName = str;
    }

    public String getMessage() {
        return this.errorName;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public static JingleError fromString(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "out-of-order":
                return OUT_OF_ORDER;
            case "unknown-session":
                return UNKNOWN_SESSION;
            case "tie-break":
                return TIE_BREAK;
            case "unsupported-info":
                return UNSUPPORTED_INFO;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return getMessage();
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return this.errorName;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }
}
