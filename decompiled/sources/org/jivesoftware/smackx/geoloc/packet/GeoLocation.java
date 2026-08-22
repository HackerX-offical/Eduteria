package org.jivesoftware.smackx.geoloc.packet;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.UserDataStore;
import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.FormFieldChildElement;

/* JADX INFO: loaded from: classes10.dex */
public final class GeoLocation implements Serializable, ExtensionElement, FormFieldChildElement {
    public static final String NAMESPACE = "http://jabber.org/protocol/geoloc";
    private static final long serialVersionUID = 1;
    private final Double accuracy;
    private final Double alt;
    private final Double altAccuracy;
    private final String area;
    private final Double bearing;
    private final String building;
    private final String country;
    private final String countryCode;
    private final String datum;
    private final String description;
    private final Double error;
    private final String floor;
    private final HashCode.Cache hashCodeCache;
    private final Double lat;
    private final String locality;
    private final Double lon;
    private final String postalcode;
    private final String region;
    private final String room;
    private final Double speed;
    private final String street;
    private final String text;
    private final Date timestamp;
    private final String tzo;
    private final URI uri;
    public static final String ELEMENT = "geoloc";
    public static final QName QNAME = new QName("http://jabber.org/protocol/geoloc", ELEMENT);
    public static final GeoLocation EMPTY_GEO_LOCATION = builder().build();

    @Override // org.jivesoftware.smackx.xdata.FormFieldChildElement
    public boolean isExclusiveElement() {
        return true;
    }

    private GeoLocation(Builder builder) {
        this.hashCodeCache = new HashCode.Cache();
        this.accuracy = builder.accuracy;
        this.alt = builder.alt;
        this.altAccuracy = builder.altAccuracy;
        this.area = builder.area;
        this.bearing = builder.bearing;
        this.building = builder.building;
        this.country = builder.country;
        this.countryCode = builder.countryCode;
        this.datum = builder.datum;
        this.description = builder.description;
        this.error = builder.error;
        this.floor = builder.floor;
        this.lat = builder.lat;
        this.locality = builder.locality;
        this.lon = builder.lon;
        this.postalcode = builder.postalcode;
        this.region = builder.region;
        this.room = builder.room;
        this.speed = builder.speed;
        this.street = builder.street;
        this.text = builder.text;
        this.timestamp = builder.timestamp;
        this.tzo = builder.tzo;
        this.uri = builder.uri;
    }

    public Double getAccuracy() {
        return this.accuracy;
    }

    public Double getAlt() {
        return this.alt;
    }

    public Double getAltAccuracy() {
        return this.altAccuracy;
    }

    public String getArea() {
        return this.area;
    }

    public Double getBearing() {
        return this.bearing;
    }

    public String getBuilding() {
        return this.building;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDatum() {
        return this.datum;
    }

    public String getDescription() {
        return this.description;
    }

    @Deprecated
    public Double getError() {
        return this.error;
    }

    public String getFloor() {
        return this.floor;
    }

    public Double getLat() {
        return this.lat;
    }

    public String getLocality() {
        return this.locality;
    }

    public Double getLon() {
        return this.lon;
    }

    public String getPostalcode() {
        return this.postalcode;
    }

    public String getRegion() {
        return this.region;
    }

    public String getRoom() {
        return this.room;
    }

    public Double getSpeed() {
        return this.speed;
    }

    public String getStreet() {
        return this.street;
    }

    public String getText() {
        return this.text;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getTzo() {
        return this.tzo;
    }

    public URI getUri() {
        return this.uri;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public QName getQName() {
        return QNAME;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("accuracy", this.accuracy);
        xmlStringBuilder.optElement("alt", this.alt);
        xmlStringBuilder.optElement("altaccuracy", this.altAccuracy);
        xmlStringBuilder.optElement(Const.AREA, this.area);
        xmlStringBuilder.optElement("bearing", this.bearing);
        xmlStringBuilder.optElement("building", this.building);
        xmlStringBuilder.optElement(UserDataStore.COUNTRY, this.country);
        xmlStringBuilder.optElement("countrycode", this.countryCode);
        xmlStringBuilder.optElement("datum", this.datum);
        xmlStringBuilder.optElement("description", this.description);
        xmlStringBuilder.optElement("error", this.error);
        xmlStringBuilder.optElement("floor", this.floor);
        xmlStringBuilder.optElement(Const.LAT, this.lat);
        xmlStringBuilder.optElement("locality", this.locality);
        xmlStringBuilder.optElement(Const.LON, this.lon);
        xmlStringBuilder.optElement("postalcode", this.postalcode);
        xmlStringBuilder.optElement("region", this.region);
        xmlStringBuilder.optElement("room", this.room);
        xmlStringBuilder.optElement(TransferTable.COLUMN_SPEED, this.speed);
        xmlStringBuilder.optElement("street", this.street);
        xmlStringBuilder.optElement("text", this.text);
        xmlStringBuilder.optElement("timestamp", this.timestamp);
        xmlStringBuilder.optElement("tzo", this.tzo);
        xmlStringBuilder.optElement("uri", this.uri);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/geoloc";
    }

    public int hashCode() {
        return this.hashCodeCache.getHashCode(new HashCode.Calculator() { // from class: org.jivesoftware.smackx.geoloc.packet.GeoLocation$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.HashCode.Calculator
            public final void calculateHash(HashCode.Builder builder) {
                this.f$0.m14245x113cb42a(builder);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$hashCode$0$org-jivesoftware-smackx-geoloc-packet-GeoLocation, reason: not valid java name */
    /* synthetic */ void m14245x113cb42a(HashCode.Builder builder) {
        builder.append(this.accuracy).append(this.alt).append(this.altAccuracy).append(this.area).append(this.bearing).append(this.building).append(this.country).append(this.countryCode).append(this.datum).append(this.description).append(this.error).append(this.floor).append(this.lat).append(this.locality).append(this.lon).append(this.postalcode).append(this.region).append(this.room).append(this.speed).append(this.street).append(this.text).append(this.timestamp).append(this.tzo).append(this.uri);
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.geoloc.packet.GeoLocation$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14244x5498a6cf(builder, (GeoLocation) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$1$org-jivesoftware-smackx-geoloc-packet-GeoLocation, reason: not valid java name */
    /* synthetic */ void m14244x5498a6cf(EqualsUtil.Builder builder, GeoLocation geoLocation) {
        builder.append(this.accuracy, geoLocation.accuracy).append(this.altAccuracy, geoLocation.altAccuracy).append(this.area, geoLocation.area).append(this.bearing, geoLocation.bearing).append(this.building, geoLocation.building).append(this.country, geoLocation.country).append(this.countryCode, geoLocation.countryCode).append(this.datum, geoLocation.datum).append(this.description, geoLocation.description).append(this.error, geoLocation.error).append(this.floor, geoLocation.floor).append(this.lat, geoLocation.lat).append(this.locality, geoLocation.locality).append(this.lon, geoLocation.lon).append(this.postalcode, geoLocation.postalcode).append(this.region, geoLocation.region).append(this.room, geoLocation.room).append(this.speed, geoLocation.speed).append(this.street, geoLocation.street).append(this.text, geoLocation.text).append(this.timestamp, geoLocation.timestamp).append(this.tzo, geoLocation.tzo).append(this.uri, geoLocation.uri);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static GeoLocation from(Message message) {
        return (GeoLocation) message.getExtension(GeoLocation.class);
    }

    public static GeoLocation from(FormField formField) {
        return (GeoLocation) formField.getFormFieldChildElement(QNAME);
    }

    public static class Builder {
        private Double accuracy;
        private Double alt;
        private Double altAccuracy;
        private String area;
        private Double bearing;
        private String building;
        private String country;
        private String countryCode;
        private String datum = "WGS84";
        private String description;
        private Double error;
        private String floor;
        private Double lat;
        private String locality;
        private Double lon;
        private String postalcode;
        private String region;
        private String room;
        private Double speed;
        private String street;
        private String text;
        private Date timestamp;
        private String tzo;
        private URI uri;

        public Builder setAccuracy(Double d2) {
            this.accuracy = d2;
            return this;
        }

        public Builder setAlt(Double d2) {
            this.alt = d2;
            return this;
        }

        public Builder setAltAccuracy(Double d2) {
            this.altAccuracy = d2;
            return this;
        }

        public Builder setArea(String str) {
            this.area = str;
            return this;
        }

        public Builder setBearing(Double d2) {
            this.bearing = d2;
            return this;
        }

        public Builder setBuilding(String str) {
            this.building = str;
            return this;
        }

        public Builder setCountry(String str) {
            this.country = str;
            return this;
        }

        public Builder setCountryCode(String str) {
            this.countryCode = str;
            return this;
        }

        public Builder setDatum(String str) {
            this.datum = str;
            return this;
        }

        public Builder setDescription(String str) {
            this.description = str;
            return this;
        }

        @Deprecated
        public Builder setError(Double d2) {
            this.error = d2;
            return this;
        }

        public Builder setFloor(String str) {
            this.floor = str;
            return this;
        }

        public Builder setLat(Double d2) {
            this.lat = d2;
            return this;
        }

        public Builder setLocality(String str) {
            this.locality = str;
            return this;
        }

        public Builder setLon(Double d2) {
            this.lon = d2;
            return this;
        }

        public Builder setPostalcode(String str) {
            this.postalcode = str;
            return this;
        }

        public Builder setRegion(String str) {
            this.region = str;
            return this;
        }

        public Builder setRoom(String str) {
            this.room = str;
            return this;
        }

        public Builder setSpeed(Double d2) {
            this.speed = d2;
            return this;
        }

        public Builder setStreet(String str) {
            this.street = str;
            return this;
        }

        public Builder setText(String str) {
            this.text = str;
            return this;
        }

        public Builder setTimestamp(Date date) {
            this.timestamp = date;
            return this;
        }

        public Builder setTzo(String str) {
            this.tzo = str;
            return this;
        }

        public Builder setUri(URI uri) {
            this.uri = uri;
            return this;
        }

        public GeoLocation build() {
            return new GeoLocation(this);
        }
    }
}
