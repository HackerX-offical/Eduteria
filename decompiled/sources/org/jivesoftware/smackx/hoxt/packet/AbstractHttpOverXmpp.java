package org.jivesoftware.smackx.hoxt.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractHttpOverXmpp extends IQ {
    public static final String NAMESPACE = "urn:xmpp:http";
    private final Data data;
    private final HeadersExtension headers;
    private final String version;

    protected abstract IQ.IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder);

    protected AbstractHttpOverXmpp(String str, Builder<?, ?> builder) {
        super(str, "urn:xmpp:http");
        this.headers = ((Builder) builder).headers;
        this.data = ((Builder) builder).data;
        this.version = (String) Objects.requireNonNull(((Builder) builder).version, "version must not be null");
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        IQ.IQChildElementXmlStringBuilder iQHoxtChildElementBuilder = getIQHoxtChildElementBuilder(iQChildElementXmlStringBuilder);
        iQHoxtChildElementBuilder.optAppend(this.headers);
        iQHoxtChildElementBuilder.optAppend(this.data);
        return iQHoxtChildElementBuilder;
    }

    public String getVersion() {
        return this.version;
    }

    public HeadersExtension getHeaders() {
        return this.headers;
    }

    public Data getData() {
        return this.data;
    }

    public static abstract class Builder<B extends Builder<B, C>, C extends AbstractHttpOverXmpp> {
        private Data data;
        private HeadersExtension headers;
        private String version = "1.1";

        public abstract C build();

        protected abstract B getThis();

        public B setData(Data data) {
            this.data = data;
            return (B) getThis();
        }

        public B setHeaders(HeadersExtension headersExtension) {
            this.headers = headersExtension;
            return (B) getThis();
        }

        public B setVersion(String str) {
            this.version = str;
            return (B) getThis();
        }
    }

    private static abstract class HoxExtensionElement implements ExtensionElement {
        private HoxExtensionElement() {
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public final String getNamespace() {
            return "urn:xmpp:http";
        }
    }

    public static class Data extends HoxExtensionElement {
        public static final String ELEMENT = "data";
        private final NamedElement child;

        public Data(NamedElement namedElement) {
            super();
            this.child = namedElement;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append(this.child);
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public NamedElement getChild() {
            return this.child;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "data";
        }
    }

    public static class Text extends HoxExtensionElement {
        public static final String ELEMENT = "text";
        private final String text;

        public Text(String str) {
            super();
            this.text = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.text, this);
            return xmlStringBuilder;
        }

        public String getText() {
            return this.text;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "text";
        }
    }

    public static class Base64 extends HoxExtensionElement {
        public static final String ELEMENT = "base64";
        private final String text;

        public Base64(String str) {
            super();
            this.text = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.text, this);
            return xmlStringBuilder;
        }

        public String getText() {
            return this.text;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class Xml extends HoxExtensionElement {
        public static final String ELEMENT = "xml";
        private final String text;

        public Xml(String str) {
            super();
            this.text = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.text, this);
            return xmlStringBuilder;
        }

        public String getText() {
            return this.text;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class ChunkedBase64 extends HoxExtensionElement {
        public static final String ELEMENT = "chunkedBase64";
        private final String streamId;

        public ChunkedBase64(String str) {
            super();
            this.streamId = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute(Base64BinaryChunk.ATTRIBUTE_STREAM_ID, this.streamId);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public String getStreamId() {
            return this.streamId;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class Ibb extends HoxExtensionElement {
        public static final String ELEMENT = "ibb";
        private final String sid;

        public Ibb(String str) {
            super();
            this.sid = str;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("sid", this.sid);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public String getSid() {
            return this.sid;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }
}
