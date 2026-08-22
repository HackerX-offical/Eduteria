package org.jivesoftware.smackx.jiveproperties.packet;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.stringencoder.Base64;

/* JADX INFO: loaded from: classes10.dex */
public class JivePropertiesExtension implements ExtensionElement {
    private final Map<String, Object> properties;
    public static final String NAMESPACE = "http://www.jivesoftware.com/xmlns/xmpp/properties";
    public static final String ELEMENT = "properties";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);
    private static final Logger LOGGER = Logger.getLogger(JivePropertiesExtension.class.getName());

    public JivePropertiesExtension() {
        this.properties = new HashMap();
    }

    public JivePropertiesExtension(Map<String, Object> map) {
        this.properties = map;
    }

    public synchronized Object getProperty(String str) {
        Map<String, Object> map = this.properties;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized void setProperty(String str, Object obj) {
        if (!(obj instanceof Serializable)) {
            throw new IllegalArgumentException("Value must be serializable");
        }
        this.properties.put(str, obj);
    }

    public synchronized void deleteProperty(String str) {
        Map<String, Object> map = this.properties;
        if (map == null) {
            return;
        }
        map.remove(str);
    }

    public synchronized Collection<String> getPropertyNames() {
        if (this.properties == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.properties.keySet()));
    }

    public synchronized Map<String, Object> getProperties() {
        if (this.properties == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new HashMap(this.properties));
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        String strEncodeToString;
        String str;
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        for (String str2 : getPropertyNames()) {
            Object property = getProperty(str2);
            xmlStringBuilder.openElement("property");
            xmlStringBuilder.element("name", str2);
            xmlStringBuilder.halfOpenElement("value");
            if (property instanceof Integer) {
                strEncodeToString = Integer.toString(((Integer) property).intValue());
                str = TypedValues.Custom.S_INT;
            } else if (property instanceof Long) {
                strEncodeToString = Long.toString(((Long) property).longValue());
                str = "long";
            } else if (property instanceof Float) {
                strEncodeToString = Float.toString(((Float) property).floatValue());
                str = TypedValues.Custom.S_FLOAT;
            } else if (property instanceof Double) {
                strEncodeToString = Double.toString(((Double) property).doubleValue());
                str = "double";
            } else if (property instanceof Boolean) {
                strEncodeToString = Boolean.toString(((Boolean) property).booleanValue());
                str = "boolean";
            } else if (property instanceof String) {
                strEncodeToString = (String) property;
                str = "string";
            } else {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        try {
                            objectOutputStream.writeObject(property);
                            strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray());
                            objectOutputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Throwable th) {
                            try {
                                objectOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Exception e2) {
                    LOGGER.log(Level.SEVERE, "Error encoding java object", (Throwable) e2);
                    strEncodeToString = "Serializing error: " + e2.getMessage();
                }
                str = "java-object";
            }
            xmlStringBuilder.attribute("type", str);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(strEncodeToString);
            xmlStringBuilder.closeElement("value");
            xmlStringBuilder.closeElement("property");
        }
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static JivePropertiesExtension from(Message message) {
        return (JivePropertiesExtension) message.getExtension(JivePropertiesExtension.class);
    }
}
