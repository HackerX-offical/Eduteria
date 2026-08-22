package org.jivesoftware.smackx.si.packet;

import java.util.Date;
import kotlin.text.Typography;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.filetransfer.FileTransferNegotiator;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class StreamInitiation extends IQ {
    public static final String ELEMENT = "si";
    public static final String NAMESPACE = "http://jabber.org/protocol/si";
    private Feature featureNegotiation;
    private File file;
    private String id;
    private String mimeType;

    public StreamInitiation() {
        super("si", "http://jabber.org/protocol/si");
    }

    public void setSessionID(String str) {
        this.id = str;
    }

    public String getSessionID() {
        return this.id;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return this.file;
    }

    public void setFeatureNegotiationForm(DataForm dataForm) {
        this.featureNegotiation = new Feature(dataForm);
    }

    public DataForm getFeatureNegotiationForm() {
        return this.featureNegotiation.getData();
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.si.packet.StreamInitiation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            int[] iArr = new int[IQ.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr;
            try {
                iArr[IQ.Type.set.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.result.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[getType().ordinal()];
        if (i == 1) {
            iQChildElementXmlStringBuilder.optAttribute("id", getSessionID());
            iQChildElementXmlStringBuilder.optAttribute("mime-type", getMimeType());
            iQChildElementXmlStringBuilder.attribute("profile", FileTransferNegotiator.SI_PROFILE_FILE_TRANSFER_NAMESPACE);
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.optElement(this.file);
        } else if (i == 2) {
            iQChildElementXmlStringBuilder.rightAngleBracket();
        } else {
            throw new IllegalArgumentException("IQ Type not understood");
        }
        Feature feature = this.featureNegotiation;
        if (feature != null) {
            iQChildElementXmlStringBuilder.append(feature.toXML());
        }
        return iQChildElementXmlStringBuilder;
    }

    public static class File implements ExtensionElement {
        private Date date;
        private String desc;
        private String hash;
        private boolean isRanged;
        private final String name;
        private final long size;

        public File(String str, long j) {
            if (str == null) {
                throw new NullPointerException("name cannot be null");
            }
            this.name = str;
            this.size = j;
        }

        public String getName() {
            return this.name;
        }

        public long getSize() {
            return this.size;
        }

        public void setHash(String str) {
            this.hash = str;
        }

        public String getHash() {
            return this.hash;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Date getDate() {
            return this.date;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public String getDesc() {
            return this.desc;
        }

        public void setRanged(boolean z) {
            this.isRanged = z;
        }

        public boolean isRanged() {
            return this.isRanged;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "file";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return FileTransferNegotiator.SI_PROFILE_FILE_TRANSFER_NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML(XmlEnvironment xmlEnvironment) {
            StringBuilder sb = new StringBuilder("<");
            sb.append(getElementName()).append(" xmlns=\"").append(getNamespace()).append("\" ");
            if (getName() != null) {
                sb.append("name=\"").append(StringUtils.escapeForXmlAttribute(getName())).append("\" ");
            }
            if (getSize() > 0) {
                sb.append("size=\"").append(getSize()).append("\" ");
            }
            if (getDate() != null) {
                sb.append("date=\"").append(XmppDateTime.formatXEP0082Date(this.date)).append("\" ");
            }
            if (getHash() != null) {
                sb.append("hash=\"").append(getHash()).append("\" ");
            }
            String str = this.desc;
            if ((str != null && str.length() > 0) || this.isRanged) {
                sb.append(Typography.greater);
                if (getDesc() != null && this.desc.length() > 0) {
                    sb.append("<desc>").append(StringUtils.escapeForXmlText(getDesc())).append("</desc>");
                }
                if (isRanged()) {
                    sb.append("<range/>");
                }
                sb.append("</").append(getElementName()).append(Typography.greater);
            } else {
                sb.append("/>");
            }
            return sb.toString();
        }
    }

    public static class Feature implements ExtensionElement {
        private final DataForm data;

        public Feature(DataForm dataForm) {
            this.data = dataForm;
        }

        public DataForm getData() {
            return this.data;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "http://jabber.org/protocol/feature-neg";
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "feature";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<feature xmlns=\"http://jabber.org/protocol/feature-neg\">" + this.data.toXML() + "</feature>";
        }
    }
}
