package org.jivesoftware.smackx.xdatavalidation.provider;

import com.clevertap.android.sdk.Constants;
import java.io.IOException;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.datatypes.UInt32;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;

/* JADX INFO: loaded from: classes10.dex */
public class DataValidationProvider extends FormFieldChildElementProvider<ValidateElement> {
    private static final Logger LOGGER = Logger.getLogger(DataValidationProvider.class.getName());

    @Override // org.jivesoftware.smack.provider.Provider
    public ValidateElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "datatype");
        ValidateElement basicValidateElement = null;
        ValidateElement.ListRange listRange = null;
        while (true) {
            int i2 = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$xml$XmlPullParser$Event[xmlPullParser.next().ordinal()];
            if (i2 == 1) {
                String name = xmlPullParser.getName();
                name.hashCode();
                switch (name) {
                    case "list-range":
                        UInt32 uInt32Attribute = ParserUtils.getUInt32Attribute(xmlPullParser, "min");
                        UInt32 uInt32Attribute2 = ParserUtils.getUInt32Attribute(xmlPullParser, Constants.PRIORITY_MAX);
                        if (uInt32Attribute != null || uInt32Attribute2 != null) {
                            listRange = new ValidateElement.ListRange(uInt32Attribute, uInt32Attribute2);
                            break;
                        } else {
                            LOGGER.fine("Ignoring list-range element without min or max attribute");
                            break;
                        }
                        break;
                    case "open":
                        basicValidateElement = new ValidateElement.OpenValidateElement(attributeValue);
                        break;
                    case "basic":
                        basicValidateElement = new ValidateElement.BasicValidateElement(attributeValue);
                        break;
                    case "range":
                        basicValidateElement = new ValidateElement.RangeValidateElement(attributeValue, xmlPullParser.getAttributeValue("", "min"), xmlPullParser.getAttributeValue("", Constants.PRIORITY_MAX));
                        break;
                    case "regex":
                        basicValidateElement = new ValidateElement.RegexValidateElement(attributeValue, xmlPullParser.nextText());
                        break;
                }
            } else if (i2 == 2 && xmlPullParser.getDepth() == i) {
                if (basicValidateElement == null) {
                    basicValidateElement = new ValidateElement.BasicValidateElement(attributeValue);
                }
                basicValidateElement.setListRange(listRange);
                return basicValidateElement;
            }
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.xdatavalidation.provider.DataValidationProvider$1, reason: invalid class name */
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

    @Override // org.jivesoftware.smackx.xdata.provider.FormFieldChildElementProvider
    public QName getQName() {
        return ValidateElement.QNAME;
    }
}
