package org.jivesoftware.smackx.usertune.element;

import com.appnew.android.Utils.Const;
import java.net.URI;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt16;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

/* JADX INFO: loaded from: classes10.dex */
public final class UserTuneElement implements ExtensionElement {
    public static final String NAMESPACE = "http://jabber.org/protocol/tune";
    private final String artist;
    private final UInt16 length;
    private final Integer rating;
    private final String source;
    private final String title;
    private final String track;
    private final URI uri;
    public static final String ELEMENT = "tune";
    public static final QName QNAME = new QName("http://jabber.org/protocol/tune", ELEMENT);
    public static final UserTuneElement EMPTY_USER_TUNE = null;

    private UserTuneElement(Builder builder) {
        this.artist = builder.artist;
        this.length = builder.length;
        this.rating = builder.rating;
        this.source = builder.source;
        this.title = builder.title;
        this.track = builder.track;
        this.uri = builder.uri;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/tune";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    public String getArtist() {
        return this.artist;
    }

    public UInt16 getLength() {
        return this.length;
    }

    public Integer getRating() {
        return this.rating;
    }

    public String getSource() {
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTrack() {
        return this.track;
    }

    public URI getUri() {
        return this.uri;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        if (isEmptyUserTune()) {
            return xmlStringBuilder.closeEmptyElement();
        }
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("artist", this.artist);
        xmlStringBuilder.optElement(Range.ATTR_LENGTH, (CharSequence) this.length);
        xmlStringBuilder.optElement(Const.RATINGS, this.rating);
        xmlStringBuilder.optElement("source", this.source);
        xmlStringBuilder.optElement("title", this.title);
        xmlStringBuilder.optElement("track", this.track);
        xmlStringBuilder.optElement("uri", this.uri);
        return xmlStringBuilder.closeElement(getElementName());
    }

    private boolean isEmptyUserTune() {
        return equals(EMPTY_USER_TUNE);
    }

    public static boolean hasUserTuneElement(Message message) {
        return message.hasExtension(UserTuneElement.class);
    }

    public static UserTuneElement from(Message message) {
        return (UserTuneElement) message.getExtension(UserTuneElement.class);
    }

    public int hashCode() {
        return HashCode.builder().append(this.artist).append(this.length).append(this.rating).append(this.source).append(this.title).append(this.track).append(this.uri).build();
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.usertune.element.UserTuneElement$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14253x16d3452f(builder, (UserTuneElement) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-usertune-element-UserTuneElement, reason: not valid java name */
    /* synthetic */ void m14253x16d3452f(EqualsUtil.Builder builder, UserTuneElement userTuneElement) {
        builder.append(this.artist, userTuneElement.artist).append(this.length, userTuneElement.length).append(this.rating, userTuneElement.rating).append(this.source, userTuneElement.source).append(this.title, userTuneElement.title).append(this.track, userTuneElement.track).append(this.uri, userTuneElement.uri);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String artist;
        private UInt16 length;
        private Integer rating;
        private String source;
        private String title;
        private String track;
        private URI uri;

        private Builder() {
        }

        public Builder setArtist(String str) {
            this.artist = str;
            return this;
        }

        public Builder setLength(int i) {
            return setLength(UInt16.from(i));
        }

        public Builder setLength(UInt16 uInt16) {
            this.length = uInt16;
            return this;
        }

        public Builder setRating(int i) {
            this.rating = Integer.valueOf(i);
            return this;
        }

        public Builder setSource(String str) {
            this.source = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setTrack(String str) {
            this.track = str;
            return this;
        }

        public Builder setUri(URI uri) {
            this.uri = uri;
            return this;
        }

        public UserTuneElement build() {
            return new UserTuneElement(this);
        }
    }
}
