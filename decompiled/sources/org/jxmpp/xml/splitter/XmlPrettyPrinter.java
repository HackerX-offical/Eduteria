package org.jxmpp.xml.splitter;

import java.io.IOException;
import kotlin.text.Typography;
import org.jxmpp.xml.splitter.XmlSplitter;

/* JADX INFO: loaded from: classes10.dex */
public class XmlPrettyPrinter extends XmlPrinter {
    private final int attributeIndent;
    private StringBuilder currentChunk;
    private StringBuilder currentChunkWithCurrentPart;
    private StringBuilder currentPart;
    private final int indent;
    private final PrettyPrintedXmlChunkWithCurrentPartCallback newChunkCallback;
    private final PrettyPrintedXmlPartCallback newPartCallback;
    private final PrettyPrintedXmlChunkSink prettyWriter;
    private final int tabWidth;

    public interface PrettyPrintedXmlChunkSink {
        void sink(StringBuilder sb);
    }

    public interface PrettyPrintedXmlChunkWithCurrentPartCallback {
        void onPrettyPrintedXmlChunk(StringBuilder sb);
    }

    public interface PrettyPrintedXmlPartCallback {
        void onPrettyPrintedXmlPart(StringBuilder sb);
    }

    /* synthetic */ XmlPrettyPrinter(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public XmlPrettyPrinter(PrettyPrintedXmlPartCallback prettyPrintedXmlPartCallback) {
        this(builder().setPartCallback(prettyPrintedXmlPartCallback));
    }

    public XmlPrettyPrinter(PrettyPrintedXmlChunkSink prettyPrintedXmlChunkSink) {
        this(builder().setPrettyWriter(prettyPrintedXmlChunkSink));
    }

    private XmlPrettyPrinter(Builder builder) {
        this.indent = builder.indent;
        this.attributeIndent = builder.attributeIndent;
        this.tabWidth = builder.tabWidth;
        this.newChunkCallback = builder.newChunkCallback;
        this.newPartCallback = builder.newPartCallback;
        this.prettyWriter = builder.prettyWriter;
    }

    @Override // org.jxmpp.xml.splitter.XmlPrinter
    void onChunkStart() {
        if (this.newChunkCallback != null) {
            StringBuilder sb = new StringBuilder(this.currentPart.length() + 1024);
            this.currentChunkWithCurrentPart = sb;
            sb.append((CharSequence) this.currentPart);
            this.currentChunkWithCurrentPart.append('[');
        }
        if (this.prettyWriter != null) {
            this.currentChunk = new StringBuilder(1024);
        }
    }

    @Override // org.jxmpp.xml.splitter.XmlPrinter
    void onChunkEnd() {
        if (this.newChunkCallback != null) {
            this.currentChunkWithCurrentPart.append(']');
            this.newChunkCallback.onPrettyPrintedXmlChunk(this.currentChunkWithCurrentPart);
            this.currentChunkWithCurrentPart = null;
        }
        PrettyPrintedXmlChunkSink prettyPrintedXmlChunkSink = this.prettyWriter;
        if (prettyPrintedXmlChunkSink != null) {
            prettyPrintedXmlChunkSink.sink(this.currentChunk);
            this.currentChunk = null;
        }
    }

    @Override // org.jxmpp.xml.splitter.XmlPrinter
    void onNextChar(char c2, int i, XmlSplitter.State state, XmlSplitter.State state2) throws IOException {
        int attributeIndent;
        int elementIndent = 0;
        boolean z = true;
        boolean z2 = state != state2;
        StringBuilder sb = new StringBuilder(z2 ? 16 : 1);
        if (z2) {
            int i2 = AnonymousClass1.$SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[state2.ordinal()];
            if (i2 == 1) {
                return;
            }
            if (i2 == 2) {
                elementIndent = getElementIndent(i - 1);
            } else if (i2 == 3) {
                elementIndent = getElementIndent(i);
            } else if (i2 != 4) {
                if (i2 == 5) {
                    attributeIndent = getElementIndent(i);
                    z = false;
                    elementIndent = attributeIndent;
                }
                z = false;
            } else {
                if (this.attributeIndent > 0) {
                    attributeIndent = getAttributeIndent(i);
                    z = false;
                    elementIndent = attributeIndent;
                }
                z = false;
            }
            if (elementIndent > 0 || z) {
                sb.append('\n');
            }
            appendIndent(sb, elementIndent);
            if (z) {
                sb.append(Typography.less);
            }
        }
        sb.append(c2);
        StringBuilder sb2 = this.currentChunkWithCurrentPart;
        if (sb2 != null) {
            sb2.append((CharSequence) sb);
        }
        if (this.newPartCallback != null) {
            if (this.currentPart == null) {
                this.currentPart = new StringBuilder(1024);
            }
            this.currentPart.append((CharSequence) sb);
        }
        if (this.prettyWriter != null) {
            this.currentChunk.append((CharSequence) sb);
        }
    }

    /* JADX INFO: renamed from: org.jxmpp.xml.splitter.XmlPrettyPrinter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State;

        static {
            int[] iArr = new int[XmlSplitter.State.values().length];
            $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State = iArr;
            try {
                iArr[XmlSplitter.State.TAG_LEFT_ANGLE_BRACKET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[XmlSplitter.State.END_TAG_SOLIDUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[XmlSplitter.State.IN_TAG_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[XmlSplitter.State.IN_ATTRIBUTE_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[XmlSplitter.State.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // org.jxmpp.xml.splitter.XmlPrinter
    void onCompleteElement() {
        if (this.newPartCallback == null) {
            return;
        }
        if (this.currentPart.charAt(0) == '\n') {
            this.currentPart.deleteCharAt(0);
        }
        this.newPartCallback.onPrettyPrintedXmlPart(this.currentPart);
        this.currentPart = null;
    }

    private int getElementIndent(int i) {
        return this.indent * i;
    }

    private int getAttributeIndent(int i) {
        return getElementIndent(i) + this.attributeIndent;
    }

    private void appendIndent(StringBuilder sb, int i) {
        int i2 = this.tabWidth;
        if (i2 > 0) {
            int i3 = i % i2;
            int i4 = i / i2;
            for (int i5 = 0; i5 < i4; i5++) {
                sb.append('\t');
            }
            i = i3;
        }
        for (int i6 = 0; i6 < i; i6++) {
            sb.append(' ');
        }
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static final class Builder {
        private int attributeIndent;
        private int indent;
        private PrettyPrintedXmlChunkWithCurrentPartCallback newChunkCallback;
        private PrettyPrintedXmlPartCallback newPartCallback;
        private PrettyPrintedXmlChunkSink prettyWriter;
        private int tabWidth;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            this.indent = 2;
        }

        public Builder setIndent(int i) {
            ensureNotNegative(i);
            this.indent = i;
            return this;
        }

        public Builder setAttributeIndent(int i) {
            ensureNotNegative(i);
            this.attributeIndent = i;
            return this;
        }

        public Builder setTabWidth(int i) {
            ensureNotNegative(i);
            this.tabWidth = i;
            return this;
        }

        public Builder setChunkCallback(PrettyPrintedXmlChunkWithCurrentPartCallback prettyPrintedXmlChunkWithCurrentPartCallback) {
            this.newChunkCallback = prettyPrintedXmlChunkWithCurrentPartCallback;
            return this;
        }

        public Builder setPartCallback(PrettyPrintedXmlPartCallback prettyPrintedXmlPartCallback) {
            this.newPartCallback = prettyPrintedXmlPartCallback;
            return this;
        }

        public Builder setPrettyWriter(PrettyPrintedXmlChunkSink prettyPrintedXmlChunkSink) {
            this.prettyWriter = prettyPrintedXmlChunkSink;
            return this;
        }

        public XmlPrettyPrinter build() {
            return new XmlPrettyPrinter(this, null);
        }

        private static void ensureNotNegative(int i) {
            if (i < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
