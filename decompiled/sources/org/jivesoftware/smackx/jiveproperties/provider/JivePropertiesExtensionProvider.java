package org.jivesoftware.smackx.jiveproperties.provider;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jiveproperties.JivePropertiesManager;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* JADX INFO: loaded from: classes10.dex */
public class JivePropertiesExtensionProvider extends ExtensionElementProvider<JivePropertiesExtension> {
    private static final Logger LOGGER = Logger.getLogger(JivePropertiesExtensionProvider.class.getName());

    @Override // org.jivesoftware.smack.provider.Provider
    public JivePropertiesExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals("property")) {
                String attributeValue = null;
                String strNextText = null;
                Object object = null;
                boolean z = false;
                String strNextText2 = null;
                while (!z) {
                    XmlPullParser.Event next2 = xmlPullParser.next();
                    if (next2 == XmlPullParser.Event.START_ELEMENT) {
                        String name = xmlPullParser.getName();
                        if (name.equals("name")) {
                            strNextText = xmlPullParser.nextText();
                        } else if (name.equals("value")) {
                            attributeValue = xmlPullParser.getAttributeValue("", "type");
                            strNextText2 = xmlPullParser.nextText();
                        }
                    } else if (next2 == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("property")) {
                        if (TypedValues.Custom.S_INT.equals(attributeValue)) {
                            object = Integer.valueOf(strNextText2);
                        } else if ("long".equals(attributeValue)) {
                            object = Long.valueOf(strNextText2);
                        } else if (TypedValues.Custom.S_FLOAT.equals(attributeValue)) {
                            object = Float.valueOf(strNextText2);
                        } else if ("double".equals(attributeValue)) {
                            object = Double.valueOf(strNextText2);
                        } else if ("boolean".equals(attributeValue)) {
                            object = Boolean.valueOf(strNextText2);
                        } else if ("string".equals(attributeValue)) {
                            object = strNextText2;
                        } else if ("java-object".equals(attributeValue)) {
                            if (JivePropertiesManager.isJavaObjectEnabled()) {
                                try {
                                    object = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(strNextText2))).readObject();
                                } catch (Exception e2) {
                                    LOGGER.log(Level.SEVERE, "Error parsing java object", (Throwable) e2);
                                }
                            } else {
                                LOGGER.severe("JavaObject is not enabled. Enable with JivePropertiesManager.setJavaObjectEnabled(true)");
                            }
                        }
                        if (strNextText != null && object != null) {
                            map.put(strNextText, object);
                        }
                        z = true;
                    }
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(JivePropertiesExtension.ELEMENT)) {
                return new JivePropertiesExtension(map);
            }
        }
    }
}
