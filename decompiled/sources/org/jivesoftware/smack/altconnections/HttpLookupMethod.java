package org.jivesoftware.smack.altconnections;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jxmpp.jid.DomainBareJid;

/* JADX INFO: loaded from: classes10.dex */
public final class HttpLookupMethod {
    private static final String XRD_NAMESPACE = "http://docs.oasis-open.org/ns/xri/xrd-1.0";

    public enum LinkRelation {
        BOSH("urn:xmpp:alt-connections:xbosh"),
        WEBSOCKET("urn:xmpp:alt-connections:websocket");

        private final String attribute;

        LinkRelation(String str) {
            this.attribute = str;
        }
    }

    public static List<URI> lookup(DomainBareJid domainBareJid, String str) throws XmlPullParserException, URISyntaxException, IOException {
        InputStream xrdStream = getXrdStream(domainBareJid);
        try {
            List<URI> xrdLinkReferencesFor = parseXrdLinkReferencesFor(PacketParserUtils.getParserFor(xrdStream), str);
            if (xrdStream != null) {
                xrdStream.close();
            }
            return xrdLinkReferencesFor;
        } catch (Throwable th) {
            if (xrdStream != null) {
                try {
                    xrdStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static List<URI> lookup(DomainBareJid domainBareJid, LinkRelation linkRelation) throws XmlPullParserException, URISyntaxException, IOException {
        return lookup(domainBareJid, linkRelation.attribute);
    }

    public static InputStream getXrdStream(DomainBareJid domainBareJid) throws IOException {
        return new URL("https://" + ((Object) domainBareJid) + "/.well-known/host-meta").openConnection().getInputStream();
    }

    public static List<URI> parseXrdLinkReferencesFor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, URISyntaxException, IOException {
        ParserUtils.forwardToStartElement(xmlPullParser);
        ArrayList arrayList = new ArrayList();
        int depth = xmlPullParser.getDepth();
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[xmlPullParser.nextTag().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                String attributeValue = xmlPullParser.getAttributeValue("rel");
                if (namespace.equals(XRD_NAMESPACE) && name.equals(HttpHeaders.LINK) && attributeValue.equals(str)) {
                    arrayList.add(new URI(xmlPullParser.getAttributeValue("href")));
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return arrayList;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.altconnections.HttpLookupMethod$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent;

        static {
            int[] iArr = new int[XmlPullParser.TagEvent.values().length];
            $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent = iArr;
            try {
                iArr[XmlPullParser.TagEvent.START_ELEMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$TagEvent[XmlPullParser.TagEvent.END_ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static List<URI> parseXrdLinkReferencesFor(XmlPullParser xmlPullParser, LinkRelation linkRelation) throws XmlPullParserException, URISyntaxException, IOException {
        return parseXrdLinkReferencesFor(xmlPullParser, linkRelation.attribute);
    }
}
