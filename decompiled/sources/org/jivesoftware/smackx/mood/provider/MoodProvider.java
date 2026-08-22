package org.jivesoftware.smackx.mood.provider;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mood.Mood;
import org.jivesoftware.smackx.mood.element.MoodConcretisation;
import org.jivesoftware.smackx.mood.element.MoodElement;

/* JADX INFO: loaded from: classes10.dex */
public class MoodProvider extends ExtensionElementProvider<MoodElement> {
    private static final Logger LOGGER = Logger.getLogger(MoodProvider.class.getName());
    public static final MoodProvider INSTANCE = new MoodProvider();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.Provider
    public MoodElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        Mood moodValueOf = null;
        MoodConcretisation moodConcretisation = null;
        String strNextText = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if ("text".equals(name)) {
                    strNextText = xmlPullParser.nextText();
                } else if (!"http://jabber.org/protocol/mood".equals(namespace)) {
                    Logger logger = LOGGER;
                    logger.log(Level.FINE, "Foreign namespace " + namespace + " detected. Try to find suitable MoodConcretisationProvider.");
                    MoodConcretisationProvider moodConcretisationProvider = (MoodConcretisationProvider) ProviderManager.getExtensionProvider(name, namespace);
                    if (moodConcretisationProvider != null) {
                        moodConcretisation = (MoodConcretisation) moodConcretisationProvider.parse(xmlPullParser);
                    } else {
                        logger.log(Level.FINE, "No provider for <" + name + " xmlns:'" + namespace + "'/> found. Ignore.");
                    }
                } else {
                    try {
                        moodValueOf = Mood.valueOf(name);
                    } catch (IllegalArgumentException unused) {
                        throw new XmlPullParserException("Unknown mood value: " + name + " encountered.");
                    }
                }
            } else if (i2 == 2 && MoodElement.ELEMENT.equals(xmlPullParser.getName())) {
                break;
            }
        }
        return new MoodElement((moodValueOf == null && moodConcretisation == null) ? null : new MoodElement.MoodSubjectElement(moodValueOf, moodConcretisation), strNextText);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.mood.provider.MoodProvider$1, reason: invalid class name */
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
}
