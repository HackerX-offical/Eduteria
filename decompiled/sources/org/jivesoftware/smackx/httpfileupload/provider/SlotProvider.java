package org.jivesoftware.smackx.httpfileupload.provider;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.httpfileupload.HttpFileUploadManager;
import org.jivesoftware.smackx.httpfileupload.UploadService;
import org.jivesoftware.smackx.httpfileupload.element.Slot;
import org.jivesoftware.smackx.httpfileupload.element.Slot_V0_2;

/* JADX INFO: loaded from: classes10.dex */
public class SlotProvider extends IQProvider<Slot> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.jivesoftware.smack.provider.IQProvider
    public Slot parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String strNextText;
        UploadService.Version versionNamespaceToVersion = HttpFileUploadManager.namespaceToVersion(xmlPullParser.getNamespace());
        URL url = null;
        URL url2 = null;
        PutElement_V0_4_Content putElement_V0_4 = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("get")) {
                    int i3 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[versionNamespaceToVersion.ordinal()];
                    if (i3 == 1) {
                        strNextText = xmlPullParser.nextText();
                    } else if (i3 == 2) {
                        strNextText = xmlPullParser.getAttributeValue(null, "url");
                    } else {
                        throw new AssertionError();
                    }
                    url2 = new URL(strNextText);
                } else if (name.equals("put")) {
                    int i4 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[versionNamespaceToVersion.ordinal()];
                    if (i4 == 1) {
                        url = new URL(xmlPullParser.nextText());
                    } else if (i4 == 2) {
                        putElement_V0_4 = parsePutElement_V0_4(xmlPullParser);
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    continue;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                int i5 = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[versionNamespaceToVersion.ordinal()];
                if (i5 == 1) {
                    return new Slot_V0_2(url, url2);
                }
                if (i5 == 2) {
                    return new Slot(putElement_V0_4.putUrl, url2, putElement_V0_4.headers);
                }
                throw new AssertionError();
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.httpfileupload.provider.SlotProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event;
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version;

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
            int[] iArr2 = new int[UploadService.Version.values().length];
            $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version = iArr2;
            try {
                iArr2[UploadService.Version.v0_2.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$httpfileupload$UploadService$Version[UploadService.Version.v0_3.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static PutElement_V0_4_Content parsePutElement_V0_4(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        AnonymousClass1 anonymousClass1 = null;
        URL url = new URL(xmlPullParser.getAttributeValue(null, "url"));
        HashMap map = null;
        while (true) {
            int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("header")) {
                    String requiredAttribute = ParserUtils.getRequiredAttribute(xmlPullParser, "name");
                    String requiredNextText = ParserUtils.getRequiredNextText(xmlPullParser);
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(requiredAttribute, requiredNextText);
                }
            } else if (i == 2 && xmlPullParser.getDepth() == depth) {
                return new PutElement_V0_4_Content(url, map, anonymousClass1);
            }
        }
    }

    public static final class PutElement_V0_4_Content {
        private final Map<String, String> headers;
        private final URL putUrl;

        /* synthetic */ PutElement_V0_4_Content(URL url, Map map, AnonymousClass1 anonymousClass1) {
            this(url, map);
        }

        private PutElement_V0_4_Content(URL url, Map<String, String> map) {
            this.putUrl = url;
            this.headers = map;
        }

        public URL getPutUrl() {
            return this.putUrl;
        }

        public Map<String, String> getHeaders() {
            return this.headers;
        }
    }
}
