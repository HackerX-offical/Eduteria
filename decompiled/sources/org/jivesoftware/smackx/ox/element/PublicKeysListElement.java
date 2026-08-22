package org.jivesoftware.smackx.ox.element;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public final class PublicKeysListElement implements ExtensionElement {
    public static final String ELEMENT = "public-keys-list";
    public static final String NAMESPACE = "urn:xmpp:openpgp:0";
    private final Map<OpenPgpV4Fingerprint, PubkeyMetadataElement> metadata;

    private PublicKeysListElement(TreeMap<OpenPgpV4Fingerprint, PubkeyMetadataElement> treeMap) {
        this.metadata = Collections.unmodifiableMap((Map) Objects.requireNonNull(treeMap));
    }

    public static Builder builder() {
        return new Builder();
    }

    public TreeMap<OpenPgpV4Fingerprint, PubkeyMetadataElement> getMetadata() {
        return new TreeMap<>(this.metadata);
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
        XmlStringBuilder xmlStringBuilderRightAngleBracket = new XmlStringBuilder((ExtensionElement) this).rightAngleBracket();
        xmlStringBuilderRightAngleBracket.append(this.metadata.values());
        xmlStringBuilderRightAngleBracket.closeElement(this);
        return xmlStringBuilderRightAngleBracket;
    }

    public static final class Builder {
        private final TreeMap<OpenPgpV4Fingerprint, PubkeyMetadataElement> metadata;

        private Builder() {
            this.metadata = new TreeMap<>();
        }

        public Builder addMetadata(PubkeyMetadataElement pubkeyMetadataElement) {
            Objects.requireNonNull(pubkeyMetadataElement);
            this.metadata.put(pubkeyMetadataElement.getV4Fingerprint(), pubkeyMetadataElement);
            return this;
        }

        public PublicKeysListElement build() {
            return new PublicKeysListElement(this.metadata);
        }
    }

    public static class PubkeyMetadataElement implements ExtensionElement {
        public static final String ATTR_DATE = "date";
        public static final String ATTR_V4_FINGERPRINT = "v4-fingerprint";
        public static final String ELEMENT = "pubkey-metadata";
        private final Date date;
        private final OpenPgpV4Fingerprint v4_fingerprint;

        public PubkeyMetadataElement(OpenPgpV4Fingerprint openPgpV4Fingerprint, Date date) {
            this.v4_fingerprint = (OpenPgpV4Fingerprint) Objects.requireNonNull(openPgpV4Fingerprint);
            this.date = (Date) Objects.requireNonNull(date);
            if (openPgpV4Fingerprint.length() != 40) {
                throw new IllegalArgumentException("OpenPGP v4 fingerprint must be 40 characters long.");
            }
        }

        public OpenPgpV4Fingerprint getV4Fingerprint() {
            return this.v4_fingerprint;
        }

        public Date getDate() {
            return this.date;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "urn:xmpp:openpgp:0";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            return new XmlStringBuilder((ExtensionElement) this).attribute(ATTR_V4_FINGERPRINT, getV4Fingerprint()).attribute("date", this.date).closeEmptyElement();
        }

        public int hashCode() {
            return getV4Fingerprint().hashCode() + (getDate().hashCode() * 3);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof PubkeyMetadataElement)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            PubkeyMetadataElement pubkeyMetadataElement = (PubkeyMetadataElement) obj;
            return getV4Fingerprint().equals(pubkeyMetadataElement.getV4Fingerprint()) && getDate().equals(pubkeyMetadataElement.getDate());
        }
    }
}
