package org.jivesoftware.smack.compress.packet;

import java.util.Objects;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Failure implements Nonza {
    public static final String ELEMENT = "failure";
    public static final String NAMESPACE = "http://jabber.org/protocol/compress";
    public static final QName QNAME = new QName("http://jabber.org/protocol/compress", "failure");
    private final CompressFailureError compressFailureError;
    private final StanzaError stanzaError;

    public enum CompressFailureError {
        setup_failed,
        processing_failed,
        unsupported_method;

        private final String compressFailureError = name().replace('_', '-');

        CompressFailureError() {
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.compressFailureError;
        }
    }

    public Failure(CompressFailureError compressFailureError) {
        this(compressFailureError, null);
    }

    public Failure(CompressFailureError compressFailureError, StanzaError stanzaError) {
        this.compressFailureError = (CompressFailureError) Objects.requireNonNull(compressFailureError);
        this.stanzaError = stanzaError;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "failure";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/compress";
    }

    public CompressFailureError getCompressFailureError() {
        return this.compressFailureError;
    }

    public StanzaError getStanzaError() {
        return this.stanzaError;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.emptyElement(this.compressFailureError);
        xmlStringBuilder.optElement(this.stanzaError);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
