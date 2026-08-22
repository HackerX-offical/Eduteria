package org.jivesoftware.smackx.xdata.provider;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xdata.FormField;

/* JADX INFO: loaded from: classes10.dex */
public class DescriptionProvider extends FormFieldChildElementProvider<FormField.Description> {
    @Override // org.jivesoftware.smack.provider.Provider
    public FormField.Description parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new FormField.Description(xmlPullParser.nextText());
    }

    @Override // org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider
    public QName getQName() {
        return FormField.Description.QNAME;
    }
}
