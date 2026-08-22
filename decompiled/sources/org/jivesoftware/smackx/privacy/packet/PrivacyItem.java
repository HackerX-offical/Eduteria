package org.jivesoftware.smackx.privacy.packet;

import java.util.Objects;
import kotlin.text.Typography;
import org.jivesoftware.smack.datatypes.UInt32;

/* JADX INFO: loaded from: classes10.dex */
public class PrivacyItem {
    public static final String SUBSCRIPTION_BOTH = "both";
    public static final String SUBSCRIPTION_FROM = "from";
    public static final String SUBSCRIPTION_NONE = "none";
    public static final String SUBSCRIPTION_TO = "to";
    private final boolean allow;
    private boolean filterIQ;
    private boolean filterMessage;
    private boolean filterPresenceIn;
    private boolean filterPresenceOut;
    private final UInt32 order;
    private final Type type;
    private final String value;

    public enum Type {
        group,
        jid,
        subscription
    }

    public PrivacyItem(boolean z, long j) {
        this((Type) null, (String) null, z, UInt32.from(j));
    }

    public PrivacyItem(boolean z, UInt32 uInt32) {
        this((Type) null, (String) null, z, uInt32);
    }

    public PrivacyItem(Type type, String str, boolean z, long j) {
        this(type, str, z, UInt32.from(j));
    }

    public PrivacyItem(Type type, String str, boolean z, UInt32 uInt32) {
        this.filterIQ = false;
        this.filterMessage = false;
        this.filterPresenceIn = false;
        this.filterPresenceOut = false;
        this.type = type;
        this.value = str;
        this.allow = z;
        this.order = (UInt32) Objects.requireNonNull(uInt32);
    }

    public PrivacyItem(Type type, CharSequence charSequence, boolean z, long j) {
        this(type, charSequence != null ? charSequence.toString() : null, z, j);
    }

    public boolean isAllow() {
        return this.allow;
    }

    public boolean isFilterIQ() {
        return this.filterIQ;
    }

    public void setFilterIQ(boolean z) {
        this.filterIQ = z;
    }

    public boolean isFilterMessage() {
        return this.filterMessage;
    }

    public void setFilterMessage(boolean z) {
        this.filterMessage = z;
    }

    public boolean isFilterPresenceIn() {
        return this.filterPresenceIn;
    }

    public void setFilterPresenceIn(boolean z) {
        this.filterPresenceIn = z;
    }

    public boolean isFilterPresenceOut() {
        return this.filterPresenceOut;
    }

    public void setFilterPresenceOut(boolean z) {
        this.filterPresenceOut = z;
    }

    public UInt32 getOrder() {
        return this.order;
    }

    public Type getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isFilterEverything() {
        return (isFilterIQ() || isFilterMessage() || isFilterPresenceIn() || isFilterPresenceOut()) ? false : true;
    }

    public String toXML() {
        StringBuilder sb = new StringBuilder("<item");
        if (isAllow()) {
            sb.append(" action=\"allow\"");
        } else {
            sb.append(" action=\"deny\"");
        }
        sb.append(" order=\"").append((CharSequence) getOrder()).append('\"');
        if (getType() != null) {
            sb.append(" type=\"").append(getType()).append('\"');
        }
        if (getValue() != null) {
            sb.append(" value=\"").append(getValue()).append('\"');
        }
        if (isFilterEverything()) {
            sb.append("/>");
        } else {
            sb.append(Typography.greater);
            if (isFilterIQ()) {
                sb.append("<iq/>");
            }
            if (isFilterMessage()) {
                sb.append("<message/>");
            }
            if (isFilterPresenceIn()) {
                sb.append("<presence-in/>");
            }
            if (isFilterPresenceOut()) {
                sb.append("<presence-out/>");
            }
            sb.append("</item>");
        }
        return sb.toString();
    }
}
