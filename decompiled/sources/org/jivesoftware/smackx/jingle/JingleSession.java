package org.jivesoftware.smackx.jingle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;
import org.jivesoftware.smackx.jingle.element.Jingle;
import org.jivesoftware.smackx.jingle.element.JingleAction;
import org.jivesoftware.smackx.jingle.element.JingleContent;
import org.jivesoftware.smackx.jingle.transports.JingleTransportSession;
import org.jxmpp.jid.FullJid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleSession implements JingleSessionHandler {
    protected final List<JingleContent> contents;
    protected HashSet<String> failedTransportMethods;
    protected final FullJid local;
    protected ArrayList<Future<?>> queued;
    protected final FullJid remote;
    protected final Role role;
    protected final String sid;
    protected JingleTransportSession<?> transportSession;

    public abstract XMPPConnection getConnection();

    public abstract void onTransportMethodFailed(String str);

    public JingleSession(FullJid fullJid, FullJid fullJid2, Role role, String str) {
        this(fullJid, fullJid2, role, str, null);
    }

    public JingleSession(FullJid fullJid, FullJid fullJid2, Role role, String str, List<JingleContent> list) {
        this.failedTransportMethods = new HashSet<>();
        ArrayList arrayList = new ArrayList();
        this.contents = arrayList;
        this.queued = new ArrayList<>();
        if (role == Role.initiator) {
            this.local = fullJid;
            this.remote = fullJid2;
        } else {
            this.local = fullJid2;
            this.remote = fullJid;
        }
        this.sid = str;
        this.role = role;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public FullJid getInitiator() {
        return isInitiator() ? this.local : this.remote;
    }

    public boolean isInitiator() {
        return this.role == Role.initiator;
    }

    public FullJid getResponder() {
        return isResponder() ? this.local : this.remote;
    }

    public boolean isResponder() {
        return this.role == Role.responder;
    }

    public FullJid getRemote() {
        return this.remote;
    }

    public FullJid getLocal() {
        return this.local;
    }

    public String getSessionId() {
        return this.sid;
    }

    public FullJidAndSessionId getFullJidAndSessionId() {
        return new FullJidAndSessionId(this.remote, this.sid);
    }

    public List<JingleContent> getContents() {
        return this.contents;
    }

    public JingleTransportSession<?> getTransportSession() {
        return this.transportSession;
    }

    protected void setTransportSession(JingleTransportSession<?> jingleTransportSession) {
        this.transportSession = jingleTransportSession;
    }

    public int hashCode() {
        return HashCode.builder().append(getInitiator()).append(getResponder()).append(getSessionId()).build();
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.jingle.JingleSession$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14246lambda$equals$0$orgjivesoftwaresmackxjingleJingleSession(builder, (JingleSession) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-jingle-JingleSession, reason: not valid java name */
    /* synthetic */ void m14246lambda$equals$0$orgjivesoftwaresmackxjingleJingleSession(EqualsUtil.Builder builder, JingleSession jingleSession) {
        builder.append(getInitiator(), jingleSession.getInitiator()).append(getResponder(), jingleSession.getResponder()).append(this.sid, jingleSession.sid);
    }

    /* JADX INFO: renamed from: org.jivesoftware.smackx.jingle.JingleSession$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction;

        static {
            int[] iArr = new int[JingleAction.values().length];
            $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction = iArr;
            try {
                iArr[JingleAction.content_accept.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.content_add.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.content_modify.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.content_reject.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.content_remove.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.description_info.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.session_info.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.security_info.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.session_accept.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.transport_accept.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.transport_info.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.session_initiate.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.transport_reject.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.session_terminate.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[JingleAction.transport_replace.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    @Override // org.jivesoftware.smackx.jingle.JingleSessionHandler
    public IQ handleJingleSessionRequest(Jingle jingle) {
        switch (AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$jingle$element$JingleAction[jingle.getAction().ordinal()]) {
            case 1:
                return handleContentAccept(jingle);
            case 2:
                return handleContentAdd(jingle);
            case 3:
                return handleContentModify(jingle);
            case 4:
                return handleContentReject(jingle);
            case 5:
                return handleContentRemove(jingle);
            case 6:
                return handleDescriptionInfo(jingle);
            case 7:
                return handleSessionInfo(jingle);
            case 8:
                return handleSecurityInfo(jingle);
            case 9:
                return handleSessionAccept(jingle);
            case 10:
                return handleTransportAccept(jingle);
            case 11:
                return this.transportSession.handleTransportInfo(jingle);
            case 12:
                return handleSessionInitiate(jingle);
            case 13:
                return handleTransportReject(jingle);
            case 14:
                return handleSessionTerminate(jingle);
            case 15:
                return handleTransportReplace(jingle);
            default:
                return IQ.createResultIQ(jingle);
        }
    }

    protected IQ handleSessionInitiate(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleSessionTerminate(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleSessionInfo(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleSessionAccept(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleContentAdd(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleContentAccept(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleContentModify(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleContentReject(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleContentRemove(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleDescriptionInfo(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleSecurityInfo(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleTransportAccept(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleTransportReplace(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }

    protected IQ handleTransportReject(Jingle jingle) {
        return IQ.createResultIQ(jingle);
    }
}
