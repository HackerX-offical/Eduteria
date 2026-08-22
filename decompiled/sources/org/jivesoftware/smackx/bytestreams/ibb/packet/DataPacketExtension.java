package org.jivesoftware.smackx.bytestreams.ibb.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.stringencoder.Base64;

/* JADX INFO: loaded from: classes10.dex */
public class DataPacketExtension implements ExtensionElement {
    public static final String ELEMENT = "data";
    public static final String NAMESPACE = "http://jabber.org/protocol/ibb";
    public static final QName QNAME = new QName("http://jabber.org/protocol/ibb", "data");
    private final String data;
    private byte[] decodedData;
    private final UInt16 seq;
    private final String sessionID;

    public DataPacketExtension(String str, int i, String str2) {
        this(str, UInt16.from(i), str2);
    }

    public DataPacketExtension(String str, UInt16 uInt16, String str2) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Data must not be null");
        }
        this.sessionID = str;
        this.seq = (UInt16) Objects.requireNonNull(uInt16);
        this.data = str2;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public UInt16 getSeq() {
        return this.seq;
    }

    public String getData() {
        return this.data;
    }

    public byte[] getDecodedData() {
        byte[] bArr = this.decodedData;
        if (bArr != null) {
            return bArr;
        }
        if (this.data.matches(".*={1,2}+.+")) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(this.data);
        this.decodedData = bArrDecode;
        return bArrDecode;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "data";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/ibb";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        IQ.IQChildElementXmlStringBuilder iQChildElementBuilder = getIQChildElementBuilder(new IQ.IQChildElementXmlStringBuilder(this, xmlEnvironment));
        iQChildElementBuilder.closeElement(this);
        return iQChildElementBuilder;
    }

    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("seq", this.seq);
        iQChildElementXmlStringBuilder.attribute("sid", this.sessionID);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.append((CharSequence) this.data);
        return iQChildElementXmlStringBuilder;
    }
}
