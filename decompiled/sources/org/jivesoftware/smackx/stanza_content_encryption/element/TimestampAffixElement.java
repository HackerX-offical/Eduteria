package org.jivesoftware.smackx.stanza_content_encryption.element;

import java.util.Date;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class TimestampAffixElement implements NamedElement, AffixElement {
    public static final String ATTR_STAMP = "stamp";
    public static final String ELEMENT = "time";
    private final Date timestamp;

    public TimestampAffixElement(Date date) {
        this.timestamp = (Date) Objects.requireNonNull(date, "Date must not be null.");
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "time";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder(this).attribute("stamp", getTimestamp()).closeEmptyElement();
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.stanza_content_encryption.element.TimestampAffixElement$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14252xb27be0a6(builder, (TimestampAffixElement) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-stanza_content_encryption-element-TimestampAffixElement, reason: not valid java name */
    /* synthetic */ void m14252xb27be0a6(EqualsUtil.Builder builder, TimestampAffixElement timestampAffixElement) {
        builder.append(getTimestamp(), timestampAffixElement.getTimestamp());
    }

    public int hashCode() {
        return this.timestamp.hashCode();
    }
}
