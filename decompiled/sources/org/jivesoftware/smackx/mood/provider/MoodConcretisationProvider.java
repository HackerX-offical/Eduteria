package org.jivesoftware.smackx.mood.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mood.element.MoodConcretisation;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MoodConcretisationProvider<C extends MoodConcretisation> extends ExtensionElementProvider<C> {
    @Override // org.jivesoftware.smack.provider.Provider
    public abstract C parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException;
}
