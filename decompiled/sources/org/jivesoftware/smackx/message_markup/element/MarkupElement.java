package org.jivesoftware.smackx.message_markup.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.message_markup.element.ListElement;
import org.jivesoftware.smackx.message_markup.element.SpanElement;

/* JADX INFO: loaded from: classes10.dex */
public class MarkupElement implements ExtensionElement {
    public static final String ELEMENT = "markup";
    public static final String NAMESPACE = "urn:xmpp:markup:0";
    private final List<MarkupChildElement> childElements;

    public MarkupElement(List<MarkupChildElement> list) {
        this.childElements = Collections.unmodifiableList(list);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public List<MarkupChildElement> getChildElements() {
        return this.childElements;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilderRightAngleBracket = new XmlStringBuilder((ExtensionElement) this).rightAngleBracket();
        Iterator<MarkupChildElement> it = getChildElements().iterator();
        while (it.hasNext()) {
            xmlStringBuilderRightAngleBracket.append(it.next().toXML());
        }
        xmlStringBuilderRightAngleBracket.closeElement(this);
        return xmlStringBuilderRightAngleBracket;
    }

    public static final class Builder {
        private final List<CodeBlockElement> codes;
        private final List<ListElement> lists;
        private final List<BlockQuoteElement> quotes;
        private final List<SpanElement> spans;

        private Builder() {
            this.spans = new ArrayList();
            this.quotes = new ArrayList();
            this.codes = new ArrayList();
            this.lists = new ArrayList();
        }

        public Builder setDeleted(int i, int i2) {
            return addSpan(i, i2, Collections.singleton(SpanElement.SpanStyle.deleted));
        }

        public Builder setEmphasis(int i, int i2) {
            return addSpan(i, i2, Collections.singleton(SpanElement.SpanStyle.emphasis));
        }

        public Builder setCode(int i, int i2) {
            return addSpan(i, i2, Collections.singleton(SpanElement.SpanStyle.code));
        }

        public Builder addSpan(int i, int i2, Set<SpanElement.SpanStyle> set) {
            verifyStartEnd(i, i2);
            for (SpanElement spanElement : this.spans) {
                if ((i >= spanElement.getStart() && i <= spanElement.getEnd()) || (i2 >= spanElement.getStart() && i2 <= spanElement.getEnd())) {
                    throw new IllegalArgumentException("Spans MUST NOT overlap each other.");
                }
            }
            this.spans.add(new SpanElement(i, i2, set));
            return this;
        }

        public Builder setBlockQuote(int i, int i2) {
            verifyStartEnd(i, i2);
            for (BlockQuoteElement blockQuoteElement : this.quotes) {
                Integer numValueOf = Integer.valueOf(i);
                Integer numValueOf2 = Integer.valueOf(i2);
                if (numValueOf.compareTo(Integer.valueOf(blockQuoteElement.getStart())) * numValueOf.compareTo(Integer.valueOf(blockQuoteElement.getEnd())) * numValueOf2.compareTo(Integer.valueOf(blockQuoteElement.getStart())) * numValueOf2.compareTo(Integer.valueOf(blockQuoteElement.getEnd())) < 1) {
                    throw new IllegalArgumentException("BlockQuotes MUST NOT overlap each others boundaries");
                }
            }
            this.quotes.add(new BlockQuoteElement(i, i2));
            return this;
        }

        public Builder setCodeBlock(int i, int i2) {
            verifyStartEnd(i, i2);
            this.codes.add(new CodeBlockElement(i, i2));
            return this;
        }

        public ListBuilder beginList() {
            return new ListBuilder();
        }

        public static final class ListBuilder {
            private int end;
            private final ArrayList<ListElement.ListEntryElement> entries;
            private final Builder markup;

            private ListBuilder(Builder builder) {
                this.entries = new ArrayList<>();
                this.end = -1;
                this.markup = builder;
            }

            public ListBuilder addEntry(int i, int i2) {
                ListElement.ListEntryElement listEntryElement;
                Builder.verifyStartEnd(i, i2);
                if (this.entries.size() == 0) {
                    listEntryElement = null;
                } else {
                    listEntryElement = this.entries.get(r0.size() - 1);
                }
                if (listEntryElement != null && i != this.end) {
                    throw new IllegalArgumentException("Next entries start must be equal to last entries end (" + this.end + ").");
                }
                this.entries.add(new ListElement.ListEntryElement(i));
                this.end = i2;
                return this;
            }

            public Builder endList() {
                if (this.entries.size() > 0) {
                    this.markup.lists.add(new ListElement(this.entries.get(0).getStart(), this.end, this.entries));
                }
                return this.markup;
            }
        }

        public MarkupElement build() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.spans);
            arrayList.addAll(this.quotes);
            arrayList.addAll(this.codes);
            arrayList.addAll(this.lists);
            return new MarkupElement(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void verifyStartEnd(int i, int i2) {
            if (i >= i2 || i < 0) {
                throw new IllegalArgumentException("Start value (" + i + ") MUST be greater equal than 0 and MUST be smaller than end value (" + i2 + ").");
            }
        }
    }

    public static abstract class MarkupChildElement implements ExtensionElement {
        public static final String ATTR_END = "end";
        public static final String ATTR_START = "start";
        private final int end;
        private final int start;

        protected abstract void afterXmlPrelude(XmlStringBuilder xmlStringBuilder);

        protected MarkupChildElement(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public final int getStart() {
            return this.start;
        }

        public final int getEnd() {
            return this.end;
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public final String getNamespace() {
            return MarkupElement.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("start", getStart());
            xmlStringBuilder.attribute("end", getEnd());
            afterXmlPrelude(xmlStringBuilder);
            return xmlStringBuilder;
        }
    }

    public static abstract class NonEmptyChildElement extends MarkupChildElement {
        protected abstract void appendInnerXml(XmlStringBuilder xmlStringBuilder);

        protected NonEmptyChildElement(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jivesoftware.smackx.message_markup.element.MarkupElement.MarkupChildElement
        protected final void afterXmlPrelude(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.rightAngleBracket();
            appendInnerXml(xmlStringBuilder);
            xmlStringBuilder.closeElement(this);
        }
    }

    public static abstract class BlockLevelMarkupElement extends MarkupChildElement {
        protected BlockLevelMarkupElement(int i, int i2) {
            super(i, i2);
        }

        @Override // org.jivesoftware.smackx.message_markup.element.MarkupElement.MarkupChildElement
        protected final void afterXmlPrelude(XmlStringBuilder xmlStringBuilder) {
            xmlStringBuilder.closeEmptyElement();
        }
    }
}
