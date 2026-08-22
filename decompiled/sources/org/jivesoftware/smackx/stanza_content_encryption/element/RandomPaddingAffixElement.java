package org.jivesoftware.smackx.stanza_content_encryption.element;

import java.security.SecureRandom;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.RandomUtil;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: loaded from: classes10.dex */
public class RandomPaddingAffixElement implements NamedElement, AffixElement {
    public static final String ELEMENT = "rpad";
    private static final int maxPaddingLength = 200;
    private static final int minPaddingLength = 1;
    private final String padding;

    public RandomPaddingAffixElement(String str) {
        this.padding = StringUtils.escapeForXmlText(StringUtils.requireNotNullNorEmpty(str, "Value of 'rpad' MUST NOT be null nor empty.")).toString();
    }

    public RandomPaddingAffixElement() {
        this(StringUtils.randomString(randomPaddingLength(), new SecureRandom()));
    }

    private static int randomPaddingLength() {
        return RandomUtil.nextSecureRandomInt(ByteCode.IFNONNULL) + 1;
    }

    public String getPadding() {
        return this.padding;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "rpad";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder(this).rightAngleBracket().append((CharSequence) getPadding()).closeElement(this);
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new EqualsUtil.EqualsComperator() { // from class: org.jivesoftware.smackx.stanza_content_encryption.element.RandomPaddingAffixElement$$ExternalSyntheticLambda0
            @Override // org.jivesoftware.smack.util.EqualsUtil.EqualsComperator
            public final void compare(EqualsUtil.Builder builder, Object obj2) {
                this.f$0.m14251x14f0af5e(builder, (RandomPaddingAffixElement) obj2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$equals$0$org-jivesoftware-smackx-stanza_content_encryption-element-RandomPaddingAffixElement, reason: not valid java name */
    /* synthetic */ void m14251x14f0af5e(EqualsUtil.Builder builder, RandomPaddingAffixElement randomPaddingAffixElement) {
        builder.append(getPadding(), randomPaddingAffixElement.getPadding());
    }

    public int hashCode() {
        return getPadding().hashCode();
    }
}
