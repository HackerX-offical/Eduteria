package org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportCandidate;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportInfo;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportInfo;

/* JADX INFO: loaded from: classes10.dex */
public class JingleS5BTransport extends JingleContentTransport {
    public static final String ATTR_DSTADDR = "dstaddr";
    public static final String ATTR_MODE = "mode";
    public static final String ATTR_SID = "sid";
    public static final String NAMESPACE_V1 = "urn:xmpp:jingle:transports:s5b:1";
    private final String dstAddr;
    private final Bytestream.Mode mode;
    private final String streamId;

    protected JingleS5BTransport(List<JingleContentTransportCandidate> list, JingleContentTransportInfo jingleContentTransportInfo, String str, String str2, Bytestream.Mode mode) {
        super(list, jingleContentTransportInfo);
        StringUtils.requireNotNullNorEmpty(str, "sid MUST be neither null, nor empty.");
        this.streamId = str;
        this.dstAddr = str2;
        this.mode = mode;
    }

    public String getStreamId() {
        return this.streamId;
    }

    public String getDestinationAddress() {
        return this.dstAddr;
    }

    public Bytestream.Mode getMode() {
        Bytestream.Mode mode = this.mode;
        return mode == null ? Bytestream.Mode.tcp : mode;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }

    @Override // org.jivesoftware.smackx.jingle.element.JingleContentTransport
    protected void addExtraAttributes(XmlStringBuilder xmlStringBuilder) {
        xmlStringBuilder.optAttribute(ATTR_DSTADDR, this.dstAddr);
        xmlStringBuilder.optAttribute("mode", this.mode);
        xmlStringBuilder.attribute("sid", this.streamId);
    }

    public boolean hasCandidate(String str) {
        return getCandidate(str) != null;
    }

    public JingleS5BTransportCandidate getCandidate(String str) {
        Iterator<JingleContentTransportCandidate> it = this.candidates.iterator();
        while (it.hasNext()) {
            JingleS5BTransportCandidate jingleS5BTransportCandidate = (JingleS5BTransportCandidate) it.next();
            if (jingleS5BTransportCandidate.getCandidateId().equals(str)) {
                return jingleS5BTransportCandidate;
            }
        }
        return null;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final ArrayList<JingleContentTransportCandidate> candidates = new ArrayList<>();
        private String dstAddr;

        /* JADX INFO: renamed from: info, reason: collision with root package name */
        private JingleContentTransportInfo f1500info;
        private Bytestream.Mode mode;
        private String streamId;

        public Builder setStreamId(String str) {
            this.streamId = str;
            return this;
        }

        public Builder setDestinationAddress(String str) {
            this.dstAddr = str;
            return this;
        }

        public Builder setMode(Bytestream.Mode mode) {
            this.mode = mode;
            return this;
        }

        public Builder addTransportCandidate(JingleS5BTransportCandidate jingleS5BTransportCandidate) {
            if (this.f1500info != null) {
                throw new IllegalStateException("Builder has already an info set. The transport can only have either an info or transport candidates, not both.");
            }
            this.candidates.add(jingleS5BTransportCandidate);
            return this;
        }

        public Builder setTransportInfo(JingleContentTransportInfo jingleContentTransportInfo) {
            if (!this.candidates.isEmpty()) {
                throw new IllegalStateException("Builder has already at least one candidate set. The transport can only have either an info or transport candidates, not both.");
            }
            if (this.f1500info != null) {
                throw new IllegalStateException("Builder has already an info set.");
            }
            this.f1500info = jingleContentTransportInfo;
            return this;
        }

        public Builder setCandidateUsed(String str) {
            return setTransportInfo(new JingleS5BTransportInfo.CandidateUsed(str));
        }

        public Builder setCandidateActivated(String str) {
            return setTransportInfo(new JingleS5BTransportInfo.CandidateActivated(str));
        }

        public Builder setCandidateError() {
            return setTransportInfo(JingleS5BTransportInfo.CandidateError.INSTANCE);
        }

        public Builder setProxyError() {
            return setTransportInfo(JingleS5BTransportInfo.ProxyError.INSTANCE);
        }

        public JingleS5BTransport build() {
            return new JingleS5BTransport(this.candidates, this.f1500info, this.streamId, this.dstAddr, this.mode);
        }
    }
}
