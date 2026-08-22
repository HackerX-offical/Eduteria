package org.jivesoftware.smackx.iqprivate.packet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes10.dex */
public class DefaultPrivateData implements PrivateData {
    private final String elementName;
    private Map<String, String> map;
    private final String namespace;

    public DefaultPrivateData(String str, String str2) {
        this.elementName = str;
        this.namespace = str2;
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String getElementName() {
        return this.elementName;
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String getNamespace() {
        return this.namespace;
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String toXML() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(this.elementName).append(" xmlns=\"").append(this.namespace).append("\">");
        for (String str : getNames()) {
            String value = getValue(str);
            sb.append(Typography.less).append(str).append(Typography.greater);
            sb.append(value);
            sb.append("</").append(str).append(Typography.greater);
        }
        sb.append("</").append(this.elementName).append(Typography.greater);
        return sb.toString();
    }

    public synchronized Set<String> getNames() {
        Map<String, String> map = this.map;
        if (map == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(map.keySet());
    }

    public synchronized String getValue(String str) {
        Map<String, String> map = this.map;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized void setValue(String str, String str2) {
        if (this.map == null) {
            this.map = new HashMap();
        }
        this.map.put(str, str2);
    }
}
