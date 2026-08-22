package org.jivesoftware.smackx.message_markup.element;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.message_markup.element.MarkupElement;

/* JADX INFO: loaded from: classes10.dex */
public class SpanElement extends MarkupElement.NonEmptyChildElement {
    public static final String ELEMENT = "span";
    public static final String code = "code";
    public static final String deleted = "deleted";
    public static final String emphasis = "emphasis";
    private final Set<SpanStyle> styles;

    public enum SpanStyle {
        emphasis,
        code,
        deleted
    }

    public SpanElement(int i, int i2, Set<SpanStyle> set) {
        super(i, i2);
        this.styles = Collections.unmodifiableSet(set);
    }

    public Set<SpanStyle> getStyles() {
        return this.styles;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "span";
    }

    @Override // org.jivesoftware.smackx.message_markup.element.MarkupElement.NonEmptyChildElement
    protected void appendInnerXml(XmlStringBuilder xmlStringBuilder) {
        Iterator<SpanStyle> it = getStyles().iterator();
        while (it.hasNext()) {
            xmlStringBuilder.emptyElement(it.next());
        }
    }
}
