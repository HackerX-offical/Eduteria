package org.jivesoftware.smackx.jiveproperties;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaBuilder;
import org.jivesoftware.smack.packet.StanzaView;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* JADX INFO: loaded from: classes10.dex */
public class JivePropertiesManager {
    private static boolean javaObjectEnabled = false;

    public static void setJavaObjectEnabled(boolean z) {
        javaObjectEnabled = z;
    }

    public static boolean isJavaObjectEnabled() {
        return javaObjectEnabled;
    }

    @Deprecated
    public static void addProperty(Stanza stanza, String str, Object obj) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanza.getExtension(JivePropertiesExtension.NAMESPACE);
        if (jivePropertiesExtension == null) {
            jivePropertiesExtension = new JivePropertiesExtension();
            stanza.addExtension(jivePropertiesExtension);
        }
        jivePropertiesExtension.setProperty(str, obj);
    }

    public static void addProperty(StanzaBuilder<?> stanzaBuilder, String str, Object obj) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanzaBuilder.getExtension(JivePropertiesExtension.QNAME);
        if (jivePropertiesExtension == null) {
            jivePropertiesExtension = new JivePropertiesExtension();
            stanzaBuilder.addExtension(jivePropertiesExtension);
        }
        jivePropertiesExtension.setProperty(str, obj);
    }

    public static Object getProperty(StanzaView stanzaView, String str) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanzaView.getExtension(JivePropertiesExtension.class);
        if (jivePropertiesExtension != null) {
            return jivePropertiesExtension.getProperty(str);
        }
        return null;
    }

    public static Collection<String> getPropertiesNames(Stanza stanza) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanza.getExtension(JivePropertiesExtension.NAMESPACE);
        if (jivePropertiesExtension == null) {
            return Collections.emptyList();
        }
        return jivePropertiesExtension.getPropertyNames();
    }

    public static Map<String, Object> getProperties(Stanza stanza) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanza.getExtension(JivePropertiesExtension.NAMESPACE);
        if (jivePropertiesExtension == null) {
            return Collections.emptyMap();
        }
        return jivePropertiesExtension.getProperties();
    }
}
