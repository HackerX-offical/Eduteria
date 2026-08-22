package org.jivesoftware.smackx.sid.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public abstract class StableAndUniqueIdElement implements ExtensionElement {
    public static final String ATTR_ID = "id";
    private final String id;

    public StableAndUniqueIdElement() {
        this.id = StringUtils.secureUniqueRandomString();
    }

    public String getId() {
        return this.id;
    }

    public StableAndUniqueIdElement(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            throw new IllegalArgumentException("Argument 'id' cannot be null or empty.");
        }
        this.id = str;
    }
}
