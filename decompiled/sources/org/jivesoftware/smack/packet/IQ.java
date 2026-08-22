package org.jivesoftware.smack.packet;

import com.csvreader.CsvReader;
import java.util.List;
import java.util.Locale;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class IQ extends Stanza implements IqView {
    public static final String IQ_ELEMENT = "iq";
    public static final String QUERY_ELEMENT = "query";
    private final String childElementName;
    private final String childElementNamespace;
    private final QName childElementQName;
    private Type type;

    protected abstract IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder);

    protected IQ(IQ iq) {
        super(iq);
        this.type = Type.get;
        this.type = iq.getType();
        this.childElementName = iq.childElementName;
        this.childElementNamespace = iq.childElementNamespace;
        this.childElementQName = iq.childElementQName;
    }

    protected IQ(String str, String str2) {
        this(IqData.EMPTY, str, str2);
    }

    protected IQ(AbstractIqBuilder<?> abstractIqBuilder, String str, String str2) {
        super(abstractIqBuilder);
        this.type = Type.get;
        this.type = abstractIqBuilder.type;
        this.childElementName = str;
        this.childElementNamespace = str2;
        if (str == null) {
            this.childElementQName = null;
        } else {
            this.childElementQName = new QName(str2, str);
        }
    }

    @Override // org.jivesoftware.smack.packet.IqView
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = (Type) Objects.requireNonNull(type, "type must not be null");
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.packet.IQ$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr;
            try {
                iArr[Type.get.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[Type.set.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public boolean isRequestIQ() {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[this.type.ordinal()];
        return i == 1 || i == 2;
    }

    public boolean isResponseIQ() {
        return !isRequestIQ();
    }

    public final QName getChildElementQName() {
        return this.childElementQName;
    }

    public final String getChildElementName() {
        return this.childElementName;
    }

    public final String getChildElementNamespace() {
        return this.childElementNamespace;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public final String getElementName() {
        return IQ_ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Stanza
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IQ Stanza (");
        sb.append(getChildElementName()).append(' ').append(getChildElementNamespace());
        sb.append(") [");
        logCommonAttributes(sb);
        sb.append("type=").append(this.type).append(CsvReader.Letters.COMMA);
        sb.append(']');
        return sb.toString();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        addCommonAttributes(xmlStringBuilder);
        Type type = this.type;
        if (type == null) {
            xmlStringBuilder.attribute("type", "get");
        } else {
            xmlStringBuilder.attribute("type", type.toString());
        }
        xmlStringBuilder.rightAngleBracket();
        appendInnerXml(xmlStringBuilder);
        xmlStringBuilder.closeElement(IQ_ELEMENT);
        return xmlStringBuilder;
    }

    public final XmlStringBuilder getChildElementXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        appendInnerXml(xmlStringBuilder);
        return xmlStringBuilder;
    }

    private void appendInnerXml(XmlStringBuilder xmlStringBuilder) {
        if (this.type == Type.error) {
            appendErrorIfExists(xmlStringBuilder);
            return;
        }
        if (this.childElementName == null) {
            return;
        }
        IQChildElementXmlStringBuilder iQChildElementBuilder = getIQChildElementBuilder(new IQChildElementXmlStringBuilder(getChildElementName(), getChildElementNamespace(), null, xmlStringBuilder.getXmlEnvironment(), null));
        if (iQChildElementBuilder == null) {
            return;
        }
        xmlStringBuilder.append((XmlStringBuilder) iQChildElementBuilder);
        List<ExtensionElement> extensions = getExtensions();
        if (iQChildElementBuilder.isEmptyElement) {
            if (extensions.isEmpty()) {
                xmlStringBuilder.closeEmptyElement();
                return;
            }
            xmlStringBuilder.rightAngleBracket();
        }
        xmlStringBuilder.append(extensions);
        xmlStringBuilder.closeElement(iQChildElementBuilder.element);
    }

    public static IQ createResultIQ(IQ iq) {
        return new EmptyResultIQ(iq);
    }

    public static ErrorIQ createErrorResponse(IQ iq, StanzaError stanzaError) {
        if (!iq.isRequestIQ()) {
            throw new IllegalArgumentException("IQ must be of type 'set' or 'get'. Original IQ: " + ((Object) iq.toXML()));
        }
        ErrorIQ errorIQ = new ErrorIQ(stanzaError);
        errorIQ.setStanzaId(iq.getStanzaId());
        errorIQ.setFrom(iq.getTo());
        errorIQ.setTo(iq.getFrom());
        return errorIQ;
    }

    @Deprecated
    public static ErrorIQ createErrorResponse(IQ iq, StanzaError.Builder builder) {
        return createErrorResponse(iq, builder.build());
    }

    public static ErrorIQ createErrorResponse(IQ iq, StanzaError.Condition condition) {
        return createErrorResponse(iq, StanzaError.getBuilder(condition).build());
    }

    public enum Type {
        get,
        set,
        result,
        error;

        public static Type fromString(String str) {
            return valueOf(str.toLowerCase(Locale.US));
        }
    }

    public enum ResponseType {
        result(Type.result),
        error(Type.error);

        final Type type;

        ResponseType(Type type) {
            this.type = type;
        }

        Type getType() {
            return this.type;
        }
    }

    public static class IQChildElementXmlStringBuilder extends XmlStringBuilder {
        private final String element;
        private boolean isEmptyElement;

        /* synthetic */ IQChildElementXmlStringBuilder(String str, String str2, String str3, XmlEnvironment xmlEnvironment, AnonymousClass1 anonymousClass1) {
            this(str, str2, str3, xmlEnvironment);
        }

        public IQChildElementXmlStringBuilder(ExtensionElement extensionElement, XmlEnvironment xmlEnvironment) {
            this(extensionElement.getElementName(), extensionElement.getNamespace(), extensionElement.getLanguage(), xmlEnvironment);
        }

        private IQChildElementXmlStringBuilder(String str, String str2, String str3, XmlEnvironment xmlEnvironment) {
            super(str, str2, str3, xmlEnvironment);
            this.element = str;
        }

        public void setEmptyElement() {
            this.isEmptyElement = true;
        }
    }
}
