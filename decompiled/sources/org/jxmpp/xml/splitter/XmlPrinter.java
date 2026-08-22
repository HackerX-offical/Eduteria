package org.jxmpp.xml.splitter;

import java.io.IOException;
import org.jxmpp.xml.splitter.XmlSplitter;

/* JADX INFO: loaded from: classes10.dex */
public abstract class XmlPrinter {
    abstract void onChunkEnd();

    abstract void onChunkStart();

    abstract void onCompleteElement();

    abstract void onNextChar(char c2, int i, XmlSplitter.State state, XmlSplitter.State state2) throws IOException;
}
