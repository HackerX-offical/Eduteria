package org.jivesoftware.smackx.jingle.transports.jingle_ibb.element;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;

/* JADX INFO: loaded from: classes10.dex */
public class JingleIBBTransport extends JingleContentTransport {
    public static final String ATTR_BLOCK_SIZE = "block-size";
    public static final String ATTR_SID = "sid";
    public static final short DEFAULT_BLOCK_SIZE = 4096;
    public static final String NAMESPACE_V1 = "urn:xmpp:jingle:transports:ibb:1";
    private final short blockSize;
    private final String sid;

    public JingleIBBTransport() {
        this(DEFAULT_BLOCK_SIZE);
    }

    public JingleIBBTransport(String str) {
        this(DEFAULT_BLOCK_SIZE, str);
    }

    public JingleIBBTransport(short s) {
        this(s, StringUtils.randomString(24));
    }

    public JingleIBBTransport(short s, String str) {
        super(null);
        if (s > 0) {
            this.blockSize = s;
        } else {
            this.blockSize = DEFAULT_BLOCK_SIZE;
        }
        this.sid = str;
    }

    public String getSessionId() {
        return this.sid;
    }

    public short getBlockSize() {
        return this.blockSize;
    }

    @Override // org.jivesoftware.smackx.jingle.element.JingleContentTransport
    protected void addExtraAttributes(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.attribute(ATTR_BLOCK_SIZE, (int) this.blockSize);
        xmlStringBuilder.attribute("sid", this.sid);
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE_V1;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof JingleIBBTransport)) {
            if (this == obj) {
                return true;
            }
            JingleIBBTransport jingleIBBTransport = (JingleIBBTransport) obj;
            if (getSessionId().equals(jingleIBBTransport.getSessionId()) && getBlockSize() == jingleIBBTransport.getBlockSize()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return toXML().toString().hashCode();
    }
}
