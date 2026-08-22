package org.jivesoftware.smackx.geoloc.provider;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.UserDataStore;
import com.google.common.base.Ascii;
import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.geoloc.packet.GeoLocation;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider;

/* JADX INFO: loaded from: classes10.dex */
public class GeoLocationProvider extends ExtensionElementProvider<GeoLocation> {
    public static final GeoLocationProvider INSTANCE = new GeoLocationProvider();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // org.jivesoftware.smack.provider.Provider
    public GeoLocation parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws SmackParsingException.SmackTextParseException, XmlPullParserException, IOException, SmackParsingException.SmackUriSyntaxParsingException {
        GeoLocation.Builder builder = GeoLocation.builder();
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            byte b2 = 2;
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name.hashCode()) {
                    case -2131707655:
                        b2 = !name.equals("accuracy") ? (byte) -1 : (byte) 0;
                        break;
                    case -1724546052:
                        b2 = !name.equals("description") ? (byte) -1 : (byte) 1;
                        break;
                    case -1476113789:
                        if (!name.equals("countrycode")) {
                            b2 = -1;
                        }
                        break;
                    case -1430646092:
                        b2 = !name.equals("building") ? (byte) -1 : (byte) 3;
                        break;
                    case -934795532:
                        b2 = !name.equals("region") ? (byte) -1 : (byte) 4;
                        break;
                    case -891990013:
                        b2 = !name.equals("street") ? (byte) -1 : (byte) 5;
                        break;
                    case -234326098:
                        b2 = !name.equals("bearing") ? (byte) -1 : (byte) 6;
                        break;
                    case 96681:
                        b2 = !name.equals("alt") ? (byte) -1 : (byte) 7;
                        break;
                    case 106911:
                        b2 = !name.equals(Const.LAT) ? (byte) -1 : (byte) 8;
                        break;
                    case 107339:
                        b2 = !name.equals(Const.LON) ? (byte) -1 : (byte) 9;
                        break;
                    case 115369:
                        b2 = !name.equals("tzo") ? (byte) -1 : (byte) 10;
                        break;
                    case 116076:
                        b2 = !name.equals("uri") ? (byte) -1 : (byte) 11;
                        break;
                    case 3002509:
                        b2 = !name.equals(Const.AREA) ? (byte) -1 : (byte) 12;
                        break;
                    case 3506395:
                        b2 = !name.equals("room") ? (byte) -1 : (byte) 13;
                        break;
                    case 3556653:
                        b2 = !name.equals("text") ? (byte) -1 : (byte) 14;
                        break;
                    case 55126294:
                        b2 = !name.equals("timestamp") ? (byte) -1 : Ascii.SI;
                        break;
                    case 95357039:
                        b2 = !name.equals("datum") ? (byte) -1 : (byte) 16;
                        break;
                    case 96784904:
                        b2 = !name.equals("error") ? (byte) -1 : (byte) 17;
                        break;
                    case 97526796:
                        b2 = !name.equals("floor") ? (byte) -1 : Ascii.DC2;
                        break;
                    case 109641799:
                        b2 = !name.equals(TransferTable.COLUMN_SPEED) ? (byte) -1 : (byte) 19;
                        break;
                    case 697727394:
                        b2 = !name.equals("altaccuracy") ? (byte) -1 : Ascii.DC4;
                        break;
                    case 957831062:
                        b2 = !name.equals(UserDataStore.COUNTRY) ? (byte) -1 : Ascii.NAK;
                        break;
                    case 1900805475:
                        b2 = !name.equals("locality") ? (byte) -1 : Ascii.SYN;
                        break;
                    case 2012106040:
                        b2 = !name.equals("postalcode") ? (byte) -1 : Ascii.ETB;
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        builder.setAccuracy(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
                        break;
                    case 1:
                        builder.setDescription(xmlPullParser.nextText());
                        break;
                    case 2:
                        builder.setCountryCode(xmlPullParser.nextText());
                        break;
                    case 3:
                        builder.setBuilding(xmlPullParser.nextText());
                        break;
                    case 4:
                        builder.setRegion(xmlPullParser.nextText());
                        break;
                    case 5:
                        builder.setStreet(xmlPullParser.nextText());
                        break;
                    case 6:
                        builder.setBearing(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
                        break;
                    case 7:
                        builder.setAlt(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
                        break;
                    case 8:
                        builder.setLat(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
                        break;
                    case 9:
                        builder.setLon(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
                        break;
                    case 10:
                        builder.setTzo(xmlPullParser.nextText());
                        break;
                    case 11:
                        builder.setUri(ParserUtils.getUriFromNextText(xmlPullParser));
                        break;
                    case 12:
                        builder.setArea(xmlPullParser.nextText());
                        break;
                    case 13:
                        builder.setRoom(xmlPullParser.nextText());
                        break;
                    case 14:
                        builder.setText(xmlPullParser.nextText());
                        break;
                    case 15:
                        builder.setTimestamp(ParserUtils.getDateFromNextText(xmlPullParser));
                        break;
                    case 16:
                        builder.setDatum(xmlPullParser.nextText());
                        break;
                    case 17:
                        parseError(builder, xmlPullParser);
                        break;
                    case 18:
                        builder.setFloor(xmlPullParser.nextText());
                        break;
                    case 19:
                        builder.setSpeed(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
                        break;
                    case 20:
                        builder.setAltAccuracy(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
                        break;
                    case 21:
                        builder.setCountry(xmlPullParser.nextText());
                        break;
                    case 22:
                        builder.setLocality(xmlPullParser.nextText());
                        break;
                    case 23:
                        builder.setPostalcode(xmlPullParser.nextText());
                        break;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                return builder.build();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.geoloc.provider.GeoLocationProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;

        static {
            int[] iArr = new int[XmlPullParser.Event.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event = iArr;
            try {
                iArr[XmlPullParser.Event.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static void parseError(GeoLocation.Builder builder, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        builder.setError(Double.valueOf(ParserUtils.getDoubleFromNextText(xmlPullParser)));
    }

    public static class GeoLocationFormFieldChildElementProvider extends FormFieldChildElementProvider<GeoLocation> {
        public static final GeoLocationFormFieldChildElementProvider INSTANCE = new GeoLocationFormFieldChildElementProvider();

        @Override // org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider
        public QName getQName() {
            return GeoLocation.QNAME;
        }

        @Override // org.jivesoftware.smack.provider.Provider
        public GeoLocation parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
            return GeoLocationProvider.INSTANCE.parse(xmlPullParser, i, xmlEnvironment);
        }
    }
}
