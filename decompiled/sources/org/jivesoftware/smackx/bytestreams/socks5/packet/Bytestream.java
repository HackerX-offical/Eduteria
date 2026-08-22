package org.jivesoftware.smackx.bytestreams.socks5.packet;

import com.clevertap.android.sdk.Constants;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.InternetAddress;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class Bytestream extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/bytestreams";
    private Mode mode;
    private String sessionID;
    private final List<StreamHost> streamHosts;
    private Activate toActivate;
    private StreamHostUsed usedHost;

    public Bytestream() {
        super("query", NAMESPACE);
        this.mode = Mode.tcp;
        this.streamHosts = new ArrayList();
    }

    public Bytestream(String str) {
        this();
        setSessionID(str);
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode() {
        return this.mode;
    }

    public StreamHost addStreamHost(Jid jid, String str) {
        return addStreamHost(jid, str, 0);
    }

    public StreamHost addStreamHost(Jid jid, String str, int i) {
        StreamHost streamHost = new StreamHost(jid, str, i);
        addStreamHost(streamHost);
        return streamHost;
    }

    public void addStreamHost(StreamHost streamHost) {
        this.streamHosts.add(streamHost);
    }

    public List<StreamHost> getStreamHosts() {
        return Collections.unmodifiableList(this.streamHosts);
    }

    public StreamHost getStreamHost(Jid jid) {
        if (jid == null) {
            return null;
        }
        for (StreamHost streamHost : this.streamHosts) {
            if (streamHost.getJID().equals((CharSequence) jid)) {
                return streamHost;
            }
        }
        return null;
    }

    public int countStreamHosts() {
        return this.streamHosts.size();
    }

    public void setUsedHost(Jid jid) {
        this.usedHost = new StreamHostUsed(jid);
    }

    public StreamHostUsed getUsedHost() {
        return this.usedHost;
    }

    public Activate getToActivate() {
        return this.toActivate;
    }

    public void setToActivate(Jid jid) {
        this.toActivate = new Activate(jid);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            int[] iArr = new int[IQ.Type.values().length];
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = iArr;
            try {
                iArr[IQ.Type.set.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.result.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[IQ.Type.get.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[getType().ordinal()];
        if (i == 1) {
            iQChildElementXmlStringBuilder.optAttribute("sid", getSessionID());
            iQChildElementXmlStringBuilder.optAttribute("mode", getMode());
            iQChildElementXmlStringBuilder.rightAngleBracket();
            if (getToActivate() == null) {
                Iterator<StreamHost> it = getStreamHosts().iterator();
                while (it.hasNext()) {
                    iQChildElementXmlStringBuilder.append(it.next().toXML());
                }
            } else {
                iQChildElementXmlStringBuilder.append(getToActivate().toXML());
                return iQChildElementXmlStringBuilder;
            }
        } else {
            if (i != 2) {
                if (i == 3) {
                    iQChildElementXmlStringBuilder.setEmptyElement();
                    return iQChildElementXmlStringBuilder;
                }
                throw new IllegalStateException();
            }
            iQChildElementXmlStringBuilder.rightAngleBracket();
            iQChildElementXmlStringBuilder.optAppend(getUsedHost());
            Iterator<StreamHost> it2 = this.streamHosts.iterator();
            while (it2.hasNext()) {
                iQChildElementXmlStringBuilder.append(it2.next().toXML());
            }
        }
        return iQChildElementXmlStringBuilder;
    }

    private static abstract class BytestreamExtensionElement implements ExtensionElement {
        private BytestreamExtensionElement() {
        }

        /* synthetic */ BytestreamExtensionElement(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public final String getNamespace() {
            return Bytestream.NAMESPACE;
        }
    }

    public static class StreamHost extends BytestreamExtensionElement {
        public static String ELEMENTNAME = "streamhost";
        private final InternetAddress address;
        private final Jid jid;
        private final int port;

        public StreamHost(Jid jid, String str) {
            this(jid, str, 0);
        }

        public StreamHost(Jid jid, String str, int i) {
            this(jid, InternetAddress.from(str), i);
        }

        public StreamHost(Jid jid, InetAddress inetAddress, int i) {
            this(jid, InternetAddress.from(inetAddress), i);
        }

        public StreamHost(Jid jid, InternetAddress internetAddress, int i) {
            super(null);
            this.jid = (Jid) Objects.requireNonNull(jid, "StreamHost JID must not be null");
            this.address = (InternetAddress) Objects.requireNonNull(internetAddress);
            this.port = i;
        }

        public Jid getJID() {
            return this.jid;
        }

        public InternetAddress getAddress() {
            return this.address;
        }

        public int getPort() {
            return this.port;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENTNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("jid", getJID());
            xmlStringBuilder.attribute(JingleS5BTransportCandidate.ATTR_HOST, this.address);
            if (getPort() != 0) {
                xmlStringBuilder.attribute("port", Integer.toString(getPort()));
            } else {
                xmlStringBuilder.attribute("zeroconf", "_jabber.bytestreams");
            }
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public String toString() {
            return "SOCKS5 Stream Host: " + ((Object) this.jid) + Constants.AES_PREFIX + ((Object) this.address) + ":" + this.port + Constants.AES_SUFFIX;
        }
    }

    public static class StreamHostUsed extends BytestreamExtensionElement {
        public static String ELEMENTNAME = "streamhost-used";
        private final Jid jid;

        public StreamHostUsed(Jid jid) {
            super(null);
            this.jid = jid;
        }

        public Jid getJID() {
            return this.jid;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENTNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("jid", getJID());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public static class Activate extends BytestreamExtensionElement {
        public static String ELEMENTNAME = "activate";
        private final Jid target;

        public Activate(Jid jid) {
            super(null);
            this.target = jid;
        }

        public Jid getTarget() {
            return this.target;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENTNAME;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(getTarget());
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
    }

    public enum Mode {
        tcp,
        udp;

        public static Mode fromName(String str) {
            try {
                return valueOf(str);
            } catch (Exception unused) {
                return tcp;
            }
        }
    }
}
