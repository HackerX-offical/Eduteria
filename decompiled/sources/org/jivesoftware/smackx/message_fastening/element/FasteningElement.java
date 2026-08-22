package org.jivesoftware.smackx.message_fastening.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

/* JADX INFO: loaded from: classes10.dex */
public final class FasteningElement implements ExtensionElement {
    public static final String ATTR_CLEAR = "clear";
    public static final String ATTR_ID = "id";
    public static final String ATTR_SHELL = "shell";
    public static final String ELEMENT = "apply-to";
    public static final String NAMESPACE = "urn:xmpp:fasten:0";
    private final boolean clear;
    private final List<ExternalElement> externalPayloads;
    private final OriginIdElement referencedStanzasOriginId;
    private final boolean shell;
    private final List<ExtensionElement> wrappedPayloads;

    private FasteningElement(OriginIdElement originIdElement, List<ExtensionElement> list, List<ExternalElement> list2, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        this.externalPayloads = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.wrappedPayloads = arrayList2;
        this.referencedStanzasOriginId = (OriginIdElement) Objects.requireNonNull(originIdElement, "Fastening element MUST contain an origin-id.");
        arrayList2.addAll(list);
        arrayList.addAll(list2);
        this.clear = z;
        this.shell = z2;
    }

    public OriginIdElement getReferencedStanzasOriginId() {
        return this.referencedStanzasOriginId;
    }

    public List<ExtensionElement> getWrappedPayloads() {
        return Collections.unmodifiableList(this.wrappedPayloads);
    }

    public List<ExternalElement> getExternalPayloads() {
        return Collections.unmodifiableList(this.externalPayloads);
    }

    public boolean isRemovingElement() {
        return this.clear;
    }

    public boolean isShellElement() {
        return this.shell;
    }

    public static boolean hasFasteningElement(Message message) {
        return message.hasExtension(ELEMENT, "urn:xmpp:fasten:0");
    }

    public static boolean hasFasteningElement(MessageBuilder messageBuilder) {
        return messageBuilder.hasExtension(FasteningElement.class);
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:fasten:0";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilderRightAngleBracket = new XmlStringBuilder((ExtensionElement) this).attribute("id", this.referencedStanzasOriginId.getId()).optBooleanAttribute(ATTR_CLEAR, isRemovingElement()).optBooleanAttribute(ATTR_SHELL, isShellElement()).rightAngleBracket();
        addPayloads(xmlStringBuilderRightAngleBracket);
        return xmlStringBuilderRightAngleBracket.closeElement(this);
    }

    private void addPayloads(XmlStringBuilder xmlStringBuilder) {
        Iterator<ExternalElement> it = this.externalPayloads.iterator();
        while (it.hasNext()) {
            xmlStringBuilder.append(it.next());
        }
        Iterator<ExtensionElement> it2 = this.wrappedPayloads.iterator();
        while (it2.hasNext()) {
            xmlStringBuilder.append(it2.next());
        }
    }

    public static FasteningElement createShellElementForSensitiveElement(FasteningElement fasteningElement) {
        return createShellElementForSensitiveElement(fasteningElement.getReferencedStanzasOriginId());
    }

    public static FasteningElement createShellElementForSensitiveElement(String str) {
        return createShellElementForSensitiveElement(new OriginIdElement(str));
    }

    public static FasteningElement createShellElementForSensitiveElement(OriginIdElement originIdElement) {
        return builder().setOriginId(originIdElement).setShell().build();
    }

    public void applyTo(MessageBuilder messageBuilder) {
        if (hasFasteningElement(messageBuilder)) {
            throw new IllegalArgumentException("Stanza cannot contain more than one apply-to elements.");
        }
        messageBuilder.addExtension(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private OriginIdElement originId;
        private final List<ExtensionElement> wrappedPayloads = new ArrayList();
        private final List<ExternalElement> externalPayloads = new ArrayList();
        private boolean isClear = false;
        private boolean isShell = false;

        public Builder setOriginId(String str) {
            return setOriginId(new OriginIdElement(str));
        }

        public Builder setOriginId(OriginIdElement originIdElement) {
            this.originId = originIdElement;
            return this;
        }

        public Builder addWrappedPayload(ExtensionElement extensionElement) {
            return addWrappedPayloads(Collections.singletonList(extensionElement));
        }

        public Builder addWrappedPayloads(List<ExtensionElement> list) {
            this.wrappedPayloads.addAll(list);
            return this;
        }

        public Builder addExternalPayload(ExternalElement externalElement) {
            return addExternalPayloads(Collections.singletonList(externalElement));
        }

        public Builder addExternalPayloads(List<ExternalElement> list) {
            this.externalPayloads.addAll(list);
            return this;
        }

        public Builder setClear() {
            this.isClear = true;
            return this;
        }

        public Builder setShell() {
            this.isShell = true;
            return this;
        }

        public FasteningElement build() {
            validateThatIfIsShellThenOtherwiseEmpty();
            return new FasteningElement(this.originId, this.wrappedPayloads, this.externalPayloads, this.isClear, this.isShell);
        }

        private void validateThatIfIsShellThenOtherwiseEmpty() {
            if (this.isShell) {
                if (this.isClear || !this.wrappedPayloads.isEmpty() || !this.externalPayloads.isEmpty()) {
                    throw new IllegalArgumentException("A fastening that is a shell element must be otherwise empty and cannot have a 'clear' attribute.");
                }
            }
        }
    }
}
