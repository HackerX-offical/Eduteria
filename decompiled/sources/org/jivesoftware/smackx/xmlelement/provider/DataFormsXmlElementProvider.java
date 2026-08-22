package org.jivesoftware.smackx.xmlelement.provider;

import java.io.IOException;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.StandardExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.parsing.StandardExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider;
import org.jivesoftware.smackx.xmlelement.element.DataFormsXmlElement;

/* JADX INFO: loaded from: classes10.dex */
public class DataFormsXmlElementProvider extends FormFieldChildElementProvider<DataFormsXmlElement> {
    @Override // org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider
    public QName getQName() {
        return DataFormsXmlElement.QNAME;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.Provider
    public DataFormsXmlElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return new DataFormsXmlElement(xmlPullParser.nextTag() == XmlPullParser.TagEvent.START_ELEMENT ? (StandardExtensionElement) StandardExtensionElementProvider.INSTANCE.parse(xmlPullParser) : null);
    }
}
