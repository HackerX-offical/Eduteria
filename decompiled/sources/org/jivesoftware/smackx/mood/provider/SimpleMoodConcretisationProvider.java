package org.jivesoftware.smackx.mood.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.mood.element.MoodConcretisation;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SimpleMoodConcretisationProvider<C extends MoodConcretisation> extends MoodConcretisationProvider<C> {
    protected abstract C simpleExtension();

    @Override // org.jivesoftware.smackx.mood.provider.MoodConcretisationProvider, org.jivesoftware.smack.provider.Provider
    public C parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return (C) simpleExtension();
    }
}
