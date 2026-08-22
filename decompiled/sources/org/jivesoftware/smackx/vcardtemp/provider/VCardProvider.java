package org.jivesoftware.smackx.vcardtemp.provider;

import com.facebook.share.internal.ShareConstants;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.vcardtemp.packet.VCard;

/* JADX INFO: loaded from: classes10.dex */
public class VCardProvider extends IQProvider<VCard> {
    private static final String[] ADR = {"POSTAL", "PARCEL", "DOM", "INTL", "PREF", "POBOX", "EXTADR", "STREET", "LOCALITY", "REGION", "PCODE", "CTRY", "FF"};
    private static final String[] TEL = {"VOICE", "FAX", "PAGER", "MSG", "CELL", ShareConstants.VIDEO_URL, "BBS", "MODEM", "ISDN", "PCS", "PREF"};

    @Override // org.jivesoftware.smack.provider.IQProvider
    public VCard parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        VCard vCard = new VCard();
        String name = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "JABBERID":
                        vCard.setJabberId(xmlPullParser.nextText());
                        break;
                    case "N":
                        parseName(xmlPullParser, vCard);
                        break;
                    case "ADR":
                        parseAddress(xmlPullParser, vCard);
                        break;
                    case "ORG":
                        parseOrg(xmlPullParser, vCard);
                        break;
                    case "TEL":
                        parseTel(xmlPullParser, vCard);
                        break;
                    case "EMAIL":
                        parseEmail(xmlPullParser, vCard);
                        break;
                    case "PHOTO":
                        parsePhoto(xmlPullParser, vCard);
                        break;
                    case "NICKNAME":
                        vCard.setNickName(xmlPullParser.nextText());
                        break;
                }
            } else if (i2 == 2) {
                if (i + 1 == xmlPullParser.getDepth()) {
                    vCard.setField(name, xmlPullParser.getText());
                }
            } else if (i2 == 3 && xmlPullParser.getDepth() == i) {
                return vCard;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.vcardtemp.provider.VCardProvider$1, reason: invalid class name */
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
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.TEXT_CHARACTERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[XmlPullParser.Event.END_ELEMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void parseAddress(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        boolean z = true;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                if ("HOME".equals(name)) {
                    z = false;
                } else {
                    for (String str : ADR) {
                        if (str.equals(name)) {
                            if (z) {
                                vCard.setAddressFieldWork(name, xmlPullParser.nextText());
                            } else {
                                vCard.setAddressFieldHome(name, xmlPullParser.nextText());
                            }
                        }
                    }
                }
            } else if (i == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parseTel(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        String str = null;
        boolean z = true;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                if ("HOME".equals(name)) {
                    z = false;
                } else if ("NUMBER".equals(name)) {
                    if (StringUtils.isNullOrEmpty(str)) {
                        str = "VOICE";
                    }
                    if (z) {
                        vCard.setPhoneWork(str, xmlPullParser.nextText());
                    } else {
                        vCard.setPhoneHome(str, xmlPullParser.nextText());
                    }
                } else {
                    for (String str2 : TEL) {
                        if (str2.equals(name)) {
                            str = name;
                        }
                    }
                }
            } else if (i == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parseOrg(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ORGNAME")) {
                    vCard.setOrganization(xmlPullParser.nextText());
                } else if (name.equals("ORGUNIT")) {
                    vCard.setOrganizationUnit(xmlPullParser.nextText());
                }
            } else if (i == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parseEmail(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        boolean z = false;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("USERID")) {
                    if (z) {
                        vCard.setEmailWork(xmlPullParser.nextText());
                    } else {
                        vCard.setEmailHome(xmlPullParser.nextText());
                    }
                } else if (name.equals("WORK")) {
                    z = true;
                }
            } else if (i == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parseName(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "MIDDLE":
                        vCard.setMiddleName(xmlPullParser.nextText());
                        break;
                    case "PREFIX":
                        vCard.setPrefix(xmlPullParser.nextText());
                        break;
                    case "SUFFIX":
                        vCard.setSuffix(xmlPullParser.nextText());
                        break;
                    case "GIVEN":
                        vCard.setFirstName(xmlPullParser.nextText());
                        break;
                    case "FAMILY":
                        vCard.setLastName(xmlPullParser.nextText());
                        break;
                }
            } else if (i == 3 && xmlPullParser.getDepth() == depth) {
                return;
            }
        }
    }

    private static void parsePhoto(XmlPullParser xmlPullParser, VCard vCard) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        String strNextText = null;
        String strNextText2 = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("TYPE")) {
                    strNextText2 = xmlPullParser.nextText();
                } else if (name.equals("BINVAL")) {
                    strNextText = xmlPullParser.nextText();
                }
            } else if (i == 3 && xmlPullParser.getDepth() == depth) {
                break;
            }
        }
        if (strNextText == null || strNextText2 == null) {
            return;
        }
        vCard.setAvatar(strNextText, strNextText2);
    }
}
