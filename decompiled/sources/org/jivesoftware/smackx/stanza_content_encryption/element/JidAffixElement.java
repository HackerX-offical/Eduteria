package org.jivesoftware.smackx.stanza_content_encryption.element;

import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JidAffixElement implements NamedElement, AffixElement {
    public static final String ATTR_JID = "jid";
    private final Jid jid;

    public JidAffixElement(Jid jid) {
        this.jid = (Jid) Objects.requireNonNull(jid, "Value of 'jid' MUST NOT be null.");
    }

    public Jid getJid() {
        return this.jid;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder(this).attribute("jid", getJid()).closeEmptyElement();
    }

    public final boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.stanza_content_encryption.element.JidAffixElement$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14250xfabdbf15(builder, (JidAffixElement) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-stanza_content_encryption-element-JidAffixElement, reason: not valid java name */
    /* synthetic */ void m14250xfabdbf15(EqualsUtil.Builder builder, JidAffixElement jidAffixElement) {
        builder.append(getJid(), jidAffixElement.getJid()).append(getElementName(), jidAffixElement.getElementName());
    }

    public final int hashCode() {
        return (getElementName() + getJid().toString()).hashCode();
    }
}
