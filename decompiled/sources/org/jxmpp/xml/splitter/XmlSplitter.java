package org.jxmpp.xml.splitter;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class XmlSplitter extends Writer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String attributeName;
    private AttributeValueQuotes attributeValueQuotes;
    private final Map<String, String> attributes;
    protected final CompleteElementCallback completeElementCallback;
    private final DeclarationCallback declarationCallback;
    private int depth;
    private final ProcessingInstructionCallback processingInstructionCallback;
    private String qName;
    private final StringBuilder splittedPartBuffer;
    private State state;
    private final StringBuilder tokenBuffer;
    private final XmlPrinter xmlPrinter;

    enum State {
        START,
        TAG_LEFT_ANGLE_BRACKET,
        TAG_RIGHT_ANGLE_BRACKET,
        END_TAG_SOLIDUS,
        IN_TAG_NAME,
        IN_END_TAG,
        AFTER_START_NAME,
        IN_EMPTY_TAG,
        IN_ATTRIBUTE_NAME,
        AFTER_ATTRIBUTE_EQUALS,
        IN_ATTRIBUTE_VALUE,
        AFTER_COMMENT_BANG,
        AFTER_COMMENT_DASH1,
        AFTER_COMMENT_DASH2,
        AFTER_COMMENT,
        AFTER_COMMENT_CLOSING_DASH1,
        AFTER_COMMENT_CLOSING_DASH2,
        IN_PROCESSING_INSTRUCTION_OR_DECLARATION,
        IN_PROCESSING_INSTRUCTION_OR_DECLARATION_PSEUDO_ATTRIBUTE_VALUE,
        IN_PROCESSING_INSTRUCTION_OR_DECLARATION_QUESTION_MARK
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    protected void onEndTag(String str) {
    }

    protected void onNextChar() throws IOException {
    }

    protected void onStartTag(String str, String str2, Map<String, String> map) {
    }

    private enum AttributeValueQuotes {
        apos('\''),
        quot('\"');


        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final char f1504c;

        AttributeValueQuotes(char c2) {
            this.f1504c = c2;
        }
    }

    public XmlSplitter(int i, CompleteElementCallback completeElementCallback, DeclarationCallback declarationCallback, ProcessingInstructionCallback processingInstructionCallback) {
        this(i, completeElementCallback, declarationCallback, processingInstructionCallback, null);
    }

    public XmlSplitter(int i, CompleteElementCallback completeElementCallback, XmlPrinter xmlPrinter) {
        this(i, completeElementCallback, null, null, xmlPrinter);
    }

    public XmlSplitter(int i, CompleteElementCallback completeElementCallback) {
        this(i, completeElementCallback, null, null);
    }

    public XmlSplitter(int i, CompleteElementCallback completeElementCallback, DeclarationCallback declarationCallback, ProcessingInstructionCallback processingInstructionCallback, XmlPrinter xmlPrinter) {
        this.tokenBuffer = new StringBuilder(256);
        this.attributes = new HashMap();
        this.state = State.START;
        this.splittedPartBuffer = new StringBuilder(i < 0 ? 128 : i);
        this.completeElementCallback = completeElementCallback;
        this.declarationCallback = declarationCallback;
        this.processingInstructionCallback = processingInstructionCallback;
        this.xmlPrinter = xmlPrinter;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        XmlPrinter xmlPrinter = this.xmlPrinter;
        if (xmlPrinter != null) {
            xmlPrinter.onChunkStart();
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            processChar(cArr[i + i3]);
        }
        XmlPrinter xmlPrinter2 = this.xmlPrinter;
        if (xmlPrinter2 != null) {
            xmlPrinter2.onChunkEnd();
        }
    }

    public final int getCurrentSplittedPartSize() {
        return this.splittedPartBuffer.length();
    }

    protected final void newSplittedPart() {
        this.depth = 0;
        this.splittedPartBuffer.setLength(0);
        this.state = State.START;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void processChar(char r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jxmpp.xml.splitter.XmlSplitter.processChar(char):void");
    }

    /* JADX INFO: renamed from: org.jxmpp.xml.splitter.XmlSplitter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State = iArr;
            try {
                iArr[State.TAG_RIGHT_ANGLE_BRACKET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.TAG_LEFT_ANGLE_BRACKET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.END_TAG_SOLIDUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.IN_TAG_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.IN_END_TAG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.AFTER_START_NAME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.IN_ATTRIBUTE_NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.AFTER_ATTRIBUTE_EQUALS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.IN_ATTRIBUTE_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.IN_EMPTY_TAG.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION_PSEUDO_ATTRIBUTE_VALUE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.IN_PROCESSING_INSTRUCTION_OR_DECLARATION_QUESTION_MARK.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.AFTER_COMMENT_BANG.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.AFTER_COMMENT_DASH1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.AFTER_COMMENT_DASH2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.AFTER_COMMENT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.AFTER_COMMENT_CLOSING_DASH1.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$jxmpp$xml$splitter$XmlSplitter$State[State.AFTER_COMMENT_CLOSING_DASH2.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    private void onStartTagFinished() {
        this.depth++;
        onStartTag(extractPrefix(this.qName), extractLocalpart(this.qName), this.attributes);
        this.attributes.clear();
    }

    private void onEndTagFinished() {
        String token = getToken();
        if (token.length() == 0) {
            token = this.qName;
        }
        int i = this.depth - 1;
        this.depth = i;
        if (i == 0) {
            String string = this.splittedPartBuffer.toString();
            this.splittedPartBuffer.setLength(0);
            CompleteElementCallback completeElementCallback = this.completeElementCallback;
            if (completeElementCallback != null) {
                completeElementCallback.onCompleteElement(string);
            }
            XmlPrinter xmlPrinter = this.xmlPrinter;
            if (xmlPrinter != null) {
                xmlPrinter.onCompleteElement();
            }
        }
        onEndTag(token);
        this.state = State.START;
    }

    private String getToken() {
        String string = this.tokenBuffer.toString();
        this.tokenBuffer.setLength(0);
        return string;
    }

    private void onProcessingInstructionOrDeclaration(String str) {
        if (str.startsWith("<?xml ")) {
            DeclarationCallback declarationCallback = this.declarationCallback;
            if (declarationCallback != null) {
                declarationCallback.onDeclaration(str);
                return;
            }
            return;
        }
        ProcessingInstructionCallback processingInstructionCallback = this.processingInstructionCallback;
        if (processingInstructionCallback != null) {
            processingInstructionCallback.onProcessingInstruction(str);
        }
    }

    private static String extractPrefix(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf > -1 ? str.substring(0, iIndexOf) : str;
    }

    private static String extractLocalpart(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf > -1 ? str.substring(iIndexOf + 1) : str;
    }
}
