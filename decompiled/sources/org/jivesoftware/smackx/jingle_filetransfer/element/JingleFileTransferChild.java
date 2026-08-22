package org.jivesoftware.smackx.jingle_filetransfer.element;

import java.io.File;
import java.util.Date;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.jivesoftware.smackx.jingle.element.JingleContentDescriptionChildElement;

/* JADX INFO: loaded from: classes10.dex */
public class JingleFileTransferChild implements JingleContentDescriptionChildElement {
    public static final String ELEMENT = "file";
    public static final String ELEM_DATE = "date";
    public static final String ELEM_DESC = "desc";
    public static final String ELEM_MEDIA_TYPE = "media-type";
    public static final String ELEM_NAME = "name";
    public static final String ELEM_SIZE = "size";
    public static final String NAMESPACE = "urn:xmpp:jingle:apps:file-transfer:5";
    private final Date date;
    private final String desc;
    private final HashElement hash;
    private final String mediaType;
    private final String name;
    private final Range range;
    private final int size;

    public JingleFileTransferChild(Date date, String str, HashElement hashElement, String str2, String str3, int i, Range range) {
        this.date = date;
        this.desc = str;
        this.hash = hashElement;
        this.mediaType = str2;
        this.name = str3;
        this.size = i;
        this.range = range;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.desc;
    }

    public HashElement getHash() {
        return this.hash;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public Range getRange() {
        return this.range;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "file";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:jingle:apps:file-transfer:5";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("date", this.date);
        xmlStringBuilder.optElement("desc", this.desc);
        xmlStringBuilder.optElement(ELEM_MEDIA_TYPE, this.mediaType);
        xmlStringBuilder.optElement("name", this.name);
        xmlStringBuilder.optElement(this.range);
        int i = this.size;
        if (i > 0) {
            xmlStringBuilder.element("size", Integer.toString(i));
        }
        xmlStringBuilder.optElement(this.hash);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private Date date;
        private String desc;
        private HashElement hash;
        private String mediaType;
        private String name;
        private Range range;
        private int size;

        private Builder() {
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setDescription(String str) {
            this.desc = str;
            return this;
        }

        public Builder setHash(HashElement hashElement) {
            this.hash = hashElement;
            return this;
        }

        public Builder setMediaType(String str) {
            this.mediaType = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setSize(int i) {
            this.size = i;
            return this;
        }

        public Builder setRange(Range range) {
            this.range = range;
            return this;
        }

        public JingleFileTransferChild build() {
            return new JingleFileTransferChild(this.date, this.desc, this.hash, this.mediaType, this.name, this.size, this.range);
        }

        public Builder setFile(File file) {
            return setDate(new Date(file.lastModified())).setName(file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1)).setSize((int) file.length());
        }
    }
}
