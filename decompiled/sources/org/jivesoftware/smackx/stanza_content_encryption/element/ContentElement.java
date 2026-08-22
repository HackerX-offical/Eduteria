package org.jivesoftware.smackx.stanza_content_encryption.element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.hints.element.MessageProcessingHint;
import org.jivesoftware.smackx.sid.element.StanzaIdElement;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class ContentElement implements ExtensionElement {
    public static final String ELEMENT = "content";
    public static final String NAMESPACE = "urn:xmpp:sce:0";
    public static final String NAMESPACE_0 = "urn:xmpp:sce:0";
    private static final String NAMESPACE_UNVERSIONED = "urn:xmpp:sce";
    public static final QName QNAME = new QName("urn:xmpp:sce:0", "content");
    private final List<AffixElement> affixElements;
    private final PayloadElement payload;

    ContentElement(PayloadElement payloadElement, List<AffixElement> list) {
        this.payload = payloadElement;
        this.affixElements = Collections.unmodifiableList(list);
    }

    public PayloadElement getPayload() {
        return this.payload;
    }

    public List<AffixElement> getAffixElements() {
        return this.affixElements;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:sce:0";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "content";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilderRightAngleBracket = new XmlStringBuilder((ExtensionElement) this).rightAngleBracket();
        xmlStringBuilderRightAngleBracket.append(this.affixElements);
        xmlStringBuilderRightAngleBracket.append(this.payload);
        return xmlStringBuilderRightAngleBracket.closeElement(this);
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public QName getQName() {
        return QNAME;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private static final Set<String> BLACKLISTED_NAMESPACES = Collections.singleton(MessageProcessingHint.NAMESPACE);
        private static final Set<QName> BLACKLISTED_QNAMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(StanzaIdElement.QNAME, MultipleAddresses.QNAME)));
        private FromAffixElement from;
        private final List<AffixElement> otherAffixElements;
        private final List<ExtensionElement> payloadItems;
        private RandomPaddingAffixElement rpad;
        private TimestampAffixElement timestamp;

        private Builder() {
            this.from = null;
            this.timestamp = null;
            this.rpad = null;
            this.otherAffixElements = new ArrayList();
            this.payloadItems = new ArrayList();
        }

        public Builder addTo(Jid jid) {
            return addTo(new ToAffixElement(jid));
        }

        public Builder addTo(ToAffixElement toAffixElement) {
            this.otherAffixElements.add((AffixElement) Objects.requireNonNull(toAffixElement, "'to' affix element MUST NOT be null."));
            return this;
        }

        public Builder setFrom(Jid jid) {
            return setFrom(new FromAffixElement(jid));
        }

        public Builder setFrom(FromAffixElement fromAffixElement) {
            this.from = (FromAffixElement) Objects.requireNonNull(fromAffixElement, "'form' affix element MUST NOT be null.");
            return this;
        }

        public Builder setTimestamp(Date date) {
            return setTimestamp(new TimestampAffixElement(date));
        }

        public Builder setTimestamp(TimestampAffixElement timestampAffixElement) {
            this.timestamp = (TimestampAffixElement) Objects.requireNonNull(timestampAffixElement, "'time' affix element MUST NOT be null.");
            return this;
        }

        public Builder setRandomPadding() {
            this.rpad = new RandomPaddingAffixElement();
            return this;
        }

        public Builder setRandomPadding(String str) {
            return setRandomPadding(new RandomPaddingAffixElement(str));
        }

        public Builder setRandomPadding(RandomPaddingAffixElement randomPaddingAffixElement) {
            this.rpad = (RandomPaddingAffixElement) Objects.requireNonNull(randomPaddingAffixElement, "'rpad' affix element MUST NOT be empty.");
            return this;
        }

        public Builder addFurtherAffixElement(AffixElement affixElement) {
            this.otherAffixElements.add((AffixElement) Objects.requireNonNull(affixElement, "Custom affix element MUST NOT be null."));
            return this;
        }

        public Builder addPayloadItem(ExtensionElement extensionElement) {
            Objects.requireNonNull(extensionElement, "Payload item MUST NOT be null.");
            this.payloadItems.add(checkForIllegalPayloadsAndPossiblyThrow(extensionElement));
            return this;
        }

        public ContentElement build() {
            return new ContentElement(new PayloadElement(this.payloadItems), collectAffixElements());
        }

        private static ExtensionElement checkForIllegalPayloadsAndPossiblyThrow(ExtensionElement extensionElement) {
            QName qName = extensionElement.getQName();
            if (BLACKLISTED_QNAMES.contains(qName)) {
                throw new IllegalArgumentException("Element identified by " + qName + " is not allowed as payload item. See https://xmpp.org/extensions/xep-0420.html#server-processed");
            }
            String namespace = extensionElement.getNamespace();
            if (BLACKLISTED_NAMESPACES.contains(namespace)) {
                throw new IllegalArgumentException("Elements of namespace '" + namespace + "' are not allowed as payload items. See https://xmpp.org/extensions/xep-0420.html#server-processed");
            }
            return extensionElement;
        }

        private List<AffixElement> collectAffixElements() {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.rpad, this.from, this.timestamp));
            arrayList.addAll(this.otherAffixElements);
            return arrayList;
        }
    }
}
