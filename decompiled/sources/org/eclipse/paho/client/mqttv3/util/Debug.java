package org.eclipse.paho.client.mqttv3.util;

import java.util.Enumeration;
import java.util.Properties;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* JADX INFO: loaded from: classes10.dex */
public class Debug {
    private static final String CLASS_NAME = ClientComms.class.getName();
    private static final String lineSep = System.getProperty("line.separator", "\n");
    private static final String separator = "==============";
    private String clientID;
    private ClientComms comms;
    private Logger log;

    public Debug(String str, ClientComms clientComms) {
        Logger logger = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
        this.log = logger;
        this.clientID = str;
        this.comms = clientComms;
        logger.setResourceName(str);
    }

    public void dumpClientDebug() {
        dumpClientComms();
        dumpConOptions();
        dumpClientState();
        dumpBaseDebug();
    }

    public void dumpBaseDebug() {
        dumpVersion();
        dumpSystemProperties();
        dumpMemoryTrace();
    }

    protected void dumpMemoryTrace() {
        this.log.dumpTrace();
    }

    protected void dumpVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = lineSep;
        stringBuffer.append(String.valueOf(str) + "============== Version Info ==============" + str);
        stringBuffer.append(String.valueOf(left("Version", 20, ' ')) + ":  " + ClientComms.VERSION + str);
        stringBuffer.append(String.valueOf(left("Build Level", 20, ' ')) + ":  " + ClientComms.BUILD_LEVEL + str);
        stringBuffer.append("==========================================" + str);
        this.log.fine(CLASS_NAME, "dumpVersion", stringBuffer.toString());
    }

    public void dumpSystemProperties() {
        this.log.fine(CLASS_NAME, "dumpSystemProperties", dumpProperties(System.getProperties(), "SystemProperties").toString());
    }

    public void dumpClientState() {
        ClientComms clientComms = this.comms;
        if (clientComms == null || clientComms.getClientState() == null) {
            return;
        }
        this.log.fine(CLASS_NAME, "dumpClientState", dumpProperties(this.comms.getClientState().getDebug(), String.valueOf(this.clientID) + " : ClientState").toString());
    }

    public void dumpClientComms() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            this.log.fine(CLASS_NAME, "dumpClientComms", dumpProperties(clientComms.getDebug(), String.valueOf(this.clientID) + " : ClientComms").toString());
        }
    }

    public void dumpConOptions() {
        ClientComms clientComms = this.comms;
        if (clientComms != null) {
            this.log.fine(CLASS_NAME, "dumpConOptions", dumpProperties(clientComms.getConOptions().getDebug(), String.valueOf(this.clientID) + " : Connect Options").toString());
        }
    }

    public static String dumpProperties(Properties properties, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        String str2 = lineSep;
        stringBuffer.append(String.valueOf(str2) + "============== " + str + " ==============" + str2);
        while (enumerationPropertyNames.hasMoreElements()) {
            String str3 = (String) enumerationPropertyNames.nextElement();
            stringBuffer.append(String.valueOf(left(str3, 28, ' ')) + ":  " + properties.get(str3) + lineSep);
        }
        stringBuffer.append("==========================================" + lineSep);
        return stringBuffer.toString();
    }

    public static String left(String str, int i, char c2) {
        if (str.length() >= i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(str);
        int length = i - str.length();
        while (true) {
            length--;
            if (length >= 0) {
                stringBuffer.append(c2);
            } else {
                return stringBuffer.toString();
            }
        }
    }
}
