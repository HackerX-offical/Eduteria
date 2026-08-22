package org.jivesoftware.smackx.ox.element;

import java.util.Date;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.stringencoder.Base64;

/* JADX INFO: loaded from: classes10.dex */
public class PubkeyElement implements ExtensionElement {
    public static final String ATTR_DATE = "date";
    public static final String ELEMENT = "pubkey";
    public static final String NAMESPACE = "urn:xmpp:openpgp:0";
    private final PubkeyDataElement dataElement;
    private final Date date;

    public PubkeyElement(PubkeyDataElement pubkeyDataElement, Date date) {
        this.dataElement = (PubkeyDataElement) Objects.requireNonNull(pubkeyDataElement);
        this.date = date;
    }

    public PubkeyDataElement getDataElement() {
        return this.dataElement;
    }

    public Date getDate() {
        return this.date;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).optAttribute("date", this.date).rightAngleBracket().append(getDataElement()).closeElement(this);
    }

    public static class PubkeyDataElement implements ExtensionElement {
        public static final String ELEMENT = "data";
        private final String b64Data;
        private transient byte[] pubKeyBytesCache;

        public PubkeyDataElement(String str) {
            this.b64Data = (String) Objects.requireNonNull(str);
        }

        public String getB64Data() {
            return this.b64Data;
        }

        public byte[] getPubKeyBytes() {
            if (this.pubKeyBytesCache == null) {
                this.pubKeyBytesCache = Base64.decode(this.b64Data);
            }
            return (byte[]) this.pubKeyBytesCache.clone();
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "data";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "urn:xmpp:openpgp:0";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            return new XmlStringBuilder(this, xmlEnvironment).rightAngleBracket().append((CharSequence) this.b64Data).closeElement(this);
        }
    }
}
