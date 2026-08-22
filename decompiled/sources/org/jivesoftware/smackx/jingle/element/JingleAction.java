package org.jivesoftware.smackx.jingle.element;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public enum JingleAction {
    content_accept,
    content_add,
    content_modify,
    content_reject,
    content_remove,
    description_info,
    security_info,
    session_accept,
    session_info,
    session_initiate,
    session_terminate,
    transport_accept,
    transport_info,
    transport_reject,
    transport_replace;

    private static final Map<String, JingleAction> map = new HashMap(values().length);
    private final String asString = name().replace('_', '-');

    static {
        for (JingleAction jingleAction : values()) {
            map.put(jingleAction.toString(), jingleAction);
        }
    }

    JingleAction() {
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.asString;
    }

    public static JingleAction fromString(String str) {
        JingleAction jingleAction = map.get(str);
        if (jingleAction != null) {
            return jingleAction;
        }
        throw new IllegalArgumentException("Unknown jingle action: " + str);
    }
}
