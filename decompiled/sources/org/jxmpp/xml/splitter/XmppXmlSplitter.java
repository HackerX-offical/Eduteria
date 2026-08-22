package org.jxmpp.xml.splitter;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class XmppXmlSplitter extends XmlSplitter {
    private final int maxElementSize;
    private String streamPrefix;
    private final XmppElementCallback xmppElementCallback;

    public XmppXmlSplitter(XmppElementCallback xmppElementCallback) {
        this(10000, xmppElementCallback);
    }

    public XmppXmlSplitter(XmppElementCallback xmppElementCallback, DeclarationCallback declarationCallback, ProcessingInstructionCallback processingInstructionCallback) {
        this(10000, xmppElementCallback, declarationCallback, processingInstructionCallback);
    }

    public XmppXmlSplitter(int i, XmppElementCallback xmppElementCallback) {
        this(i, xmppElementCallback, null, null);
    }

    public XmppXmlSplitter(int i, XmppElementCallback xmppElementCallback, DeclarationCallback declarationCallback, ProcessingInstructionCallback processingInstructionCallback) {
        this(i, xmppElementCallback, declarationCallback, processingInstructionCallback, null);
    }

    public XmppXmlSplitter(XmlPrinter xmlPrinter) {
        this(-1, (XmppElementCallback) null, xmlPrinter);
    }

    public XmppXmlSplitter(int i, XmppElementCallback xmppElementCallback, XmlPrinter xmlPrinter) {
        this(i, xmppElementCallback, null, null, xmlPrinter);
    }

    public XmppXmlSplitter(int i, XmppElementCallback xmppElementCallback, DeclarationCallback declarationCallback, ProcessingInstructionCallback processingInstructionCallback, XmlPrinter xmlPrinter) {
        super(i, xmppElementCallback, declarationCallback, processingInstructionCallback, xmlPrinter);
        this.maxElementSize = i;
        this.xmppElementCallback = xmppElementCallback;
    }

    @Override // org.jxmpp.xml.splitter.XmlSplitter
    protected void onNextChar() throws IOException {
        if (this.maxElementSize > 0 && getCurrentSplittedPartSize() >= this.maxElementSize) {
            throw new IOException("Max element size exceeded");
        }
    }

    @Override // org.jxmpp.xml.splitter.XmlSplitter
    protected void onStartTag(String str, String str2, Map<String, String> map) {
        if ("stream".equals(str2) && "http://etherx.jabber.org/streams".equals(map.get("xmlns:" + str))) {
            this.streamPrefix = str;
            newSplittedPart();
            XmppElementCallback xmppElementCallback = this.xmppElementCallback;
            if (xmppElementCallback != null) {
                xmppElementCallback.streamOpened(str, Collections.unmodifiableMap(map));
            }
        }
    }

    @Override // org.jxmpp.xml.splitter.XmlSplitter
    protected void onEndTag(String str) {
        XmppElementCallback xmppElementCallback;
        String str2 = this.streamPrefix;
        if (str2 == null || !str.startsWith(str2) || !(this.streamPrefix + ":stream").equals(str) || (xmppElementCallback = this.xmppElementCallback) == null) {
            return;
        }
        xmppElementCallback.streamClosed();
    }
}
