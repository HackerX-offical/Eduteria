package org.jivesoftware.smackx.commands.provider;

import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.Constants;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.AdHocCommandNote;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jivesoftware.smackx.xdata.provider.DataFormProvider;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class AdHocCommandDataProvider extends IQProvider<AdHocCommandData> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jivesoftware.smack.provider.IQProvider
    public AdHocCommandData parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        AdHocCommandNote.Type typeValueOf;
        AdHocCommandData adHocCommandData = new AdHocCommandData();
        DataFormProvider dataFormProvider = new DataFormProvider();
        adHocCommandData.setSessionID(xmlPullParser.getAttributeValue("", "sessionid"));
        adHocCommandData.setNode(xmlPullParser.getAttributeValue("", NodeElement.ELEMENT));
        String attributeValue = xmlPullParser.getAttributeValue("", "status");
        if (AdHocCommand.Status.executing.toString().equalsIgnoreCase(attributeValue)) {
            adHocCommandData.setStatus(AdHocCommand.Status.executing);
        } else if (AdHocCommand.Status.completed.toString().equalsIgnoreCase(attributeValue)) {
            adHocCommandData.setStatus(AdHocCommand.Status.completed);
        } else if (AdHocCommand.Status.canceled.toString().equalsIgnoreCase(attributeValue)) {
            adHocCommandData.setStatus(AdHocCommand.Status.canceled);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue("", "action");
        if (attributeValue2 != null) {
            AdHocCommand.Action actionValueOf = AdHocCommand.Action.valueOf(attributeValue2);
            if (actionValueOf == null || actionValueOf.equals(AdHocCommand.Action.unknown)) {
                adHocCommandData.setAction(AdHocCommand.Action.unknown);
            } else {
                adHocCommandData.setAction(actionValueOf);
            }
        }
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            String namespace = xmlPullParser.getNamespace();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                if (xmlPullParser.getName().equals(Constants.KEY_ACTIONS)) {
                    String attributeValue3 = xmlPullParser.getAttributeValue("", "execute");
                    if (attributeValue3 != null) {
                        adHocCommandData.setExecuteAction(AdHocCommand.Action.valueOf(attributeValue3));
                    }
                } else if (xmlPullParser.getName().equals(ES6Iterator.NEXT_METHOD)) {
                    adHocCommandData.addAction(AdHocCommand.Action.next);
                } else if (xmlPullParser.getName().equals("complete")) {
                    adHocCommandData.addAction(AdHocCommand.Action.complete);
                } else if (xmlPullParser.getName().equals("prev")) {
                    adHocCommandData.addAction(AdHocCommand.Action.prev);
                } else if (name.equals("x") && namespace.equals("jabber:x:data")) {
                    adHocCommandData.setForm((DataForm) dataFormProvider.parse(xmlPullParser));
                } else if (xmlPullParser.getName().equals(Const.NOTE)) {
                    String attributeValue4 = xmlPullParser.getAttributeValue("", "type");
                    if (attributeValue4 != null) {
                        typeValueOf = AdHocCommandNote.Type.valueOf(attributeValue4);
                    } else {
                        typeValueOf = AdHocCommandNote.Type.info;
                    }
                    adHocCommandData.addNote(new AdHocCommandNote(typeValueOf, xmlPullParser.nextText()));
                } else if (xmlPullParser.getName().equals("error")) {
                    adHocCommandData.setError(PacketParserUtils.parseError(xmlPullParser));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(AdHocCommandData.ELEMENT)) {
                z = true;
            }
        }
        return adHocCommandData;
    }

    public static class BadActionError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badAction);
        }
    }

    public static class MalformedActionError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.malformedAction);
        }
    }

    public static class BadLocaleError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badLocale);
        }
    }

    public static class BadPayloadError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badPayload);
        }
    }

    public static class BadSessionIDError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.badSessionid);
        }
    }

    public static class SessionExpiredError extends ExtensionElementProvider<AdHocCommandData.SpecificError> {
        @Override // org.jivesoftware.smack.provider.Provider
        public AdHocCommandData.SpecificError parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
            return new AdHocCommandData.SpecificError(AdHocCommand.SpecificErrorCondition.sessionExpired);
        }
    }
}
