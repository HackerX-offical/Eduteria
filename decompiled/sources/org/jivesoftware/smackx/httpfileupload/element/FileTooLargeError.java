package org.jivesoftware.smackx.httpfileupload.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class FileTooLargeError implements ExtensionElement {
    public static final String ELEMENT = "file-too-large";
    public static final String NAMESPACE = "urn:xmpp:http:upload:0";
    private final long maxFileSize;
    private final String namespace;

    public FileTooLargeError(long j) {
        this(j, "urn:xmpp:http:upload:0");
    }

    protected FileTooLargeError(long j, String str) {
        this.maxFileSize = j;
        this.namespace = str;
    }

    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return this.namespace;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.element("max-file-size", String.valueOf(this.maxFileSize));
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static FileTooLargeError from(IQ iq) {
        StanzaError error = iq.getError();
        if (error == null) {
            return null;
        }
        return (FileTooLargeError) error.getExtension(ELEMENT, "urn:xmpp:http:upload:0");
    }
}
