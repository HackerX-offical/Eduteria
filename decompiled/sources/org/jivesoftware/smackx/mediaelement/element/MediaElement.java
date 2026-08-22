package org.jivesoftware.smackx.mediaelement.element;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;

/* JADX INFO: loaded from: classes10.dex */
public class MediaElement implements FormFieldChildElement {
    public static final String ELEMENT = "media";
    public static final String NAMESPACE = "urn:xmpp:media-element";
    public static final QName QNAME = new QName(NAMESPACE, "media");
    private final UInt16 height;
    private final List<Uri> uris;
    private final UInt16 width;

    public MediaElement(Builder builder) {
        this.height = builder.height;
        this.width = builder.width;
        this.uris = Collections.unmodifiableList(builder.uris);
    }

    public UInt16 getHeight() {
        return this.height;
    }

    public UInt16 getWidth() {
        return this.width;
    }

    public List<Uri> getUris() {
        return this.uris;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "media";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public QName getQName() {
        return QNAME;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.optAttributeCs(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.height).optAttributeCs(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.width).rightAngleBracket();
        xmlStringBuilder.append(this.uris);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public MediaElement from(FormField formField) {
        return (MediaElement) formField.getFormFieldChildElement(QNAME);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UInt16 height;
        private List<Uri> uris = new ArrayList();
        private UInt16 width;

        public Builder setHeightAndWidth(int i, int i2) {
            return setHeightAndWidth(UInt16.from(i), UInt16.from(i2));
        }

        public Builder setHeightAndWidth(UInt16 uInt16, UInt16 uInt162) {
            this.height = uInt16;
            this.width = uInt162;
            return this;
        }

        public Builder addUri(URI uri, String str) {
            return addUri(new Uri(uri, str));
        }

        public Builder addUri(Uri uri) {
            this.uris.add(uri);
            return this;
        }

        public MediaElement build() {
            return new MediaElement(this);
        }
    }

    public static final class Uri implements FullyQualifiedElement {
        public static final String ELEMENT = "uri";
        public static final QName QNAME = new QName(MediaElement.NAMESPACE, "uri");
        private final String type;
        private final URI uri;

        public Uri(URI uri, String str) {
            this.uri = (URI) Objects.requireNonNull(uri);
            this.type = (String) StringUtils.requireNotNullNorEmpty(str, "The 'type' argument must not be null or empty");
        }

        public URI getUri() {
            return this.uri;
        }

        public String getType() {
            return this.type;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "uri";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return MediaElement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public QName getQName() {
            return QNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("type", this.type).rightAngleBracket();
            xmlStringBuilder.escape(this.uri.toString());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }
}
