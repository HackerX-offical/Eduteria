package org.jivesoftware.smackx.mam.element;

import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.mam.element.MamElements;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class MamPrefsIQ extends IQ {
    public static final String ELEMENT = "prefs";
    public static final String NAMESPACE = "urn:xmpp:mam:2";
    private final List<Jid> alwaysJids;
    private final DefaultBehavior defaultBehavior;
    private final List<Jid> neverJids;

    public enum DefaultBehavior {
        always,
        never,
        roster
    }

    public MamPrefsIQ() {
        super(ELEMENT, "urn:xmpp:mam:2");
        this.alwaysJids = null;
        this.neverJids = null;
        this.defaultBehavior = null;
    }

    public MamPrefsIQ(List<Jid> list, List<Jid> list2, DefaultBehavior defaultBehavior) {
        super(ELEMENT, "urn:xmpp:mam:2");
        setType(IQ.Type.set);
        this.alwaysJids = list;
        this.neverJids = list2;
        this.defaultBehavior = defaultBehavior;
    }

    public List<Jid> getAlwaysJids() {
        return this.alwaysJids;
    }

    public List<Jid> getNeverJids() {
        return this.neverJids;
    }

    public DefaultBehavior getDefault() {
        return this.defaultBehavior;
    }

    @Override // org.jivesoftware.smack.packet.IQ
    protected IQ.IQChildElementXmlStringBuilder getIQChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        if (getType().equals(IQ.Type.set) || getType().equals(IQ.Type.result)) {
            iQChildElementXmlStringBuilder.attribute(CookieSpecs.DEFAULT, this.defaultBehavior);
        }
        if (this.alwaysJids == null && this.neverJids == null) {
            iQChildElementXmlStringBuilder.setEmptyElement();
            return iQChildElementXmlStringBuilder;
        }
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (this.alwaysJids != null) {
            iQChildElementXmlStringBuilder.append(new MamElements.AlwaysJidListElement(this.alwaysJids));
        }
        if (this.neverJids != null) {
            iQChildElementXmlStringBuilder.append(new MamElements.NeverJidListElement(this.neverJids));
        }
        return iQChildElementXmlStringBuilder;
    }
}
