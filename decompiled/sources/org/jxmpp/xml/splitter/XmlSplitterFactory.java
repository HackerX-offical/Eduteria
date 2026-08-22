package org.jxmpp.xml.splitter;

/* JADX INFO: loaded from: classes10.dex */
public interface XmlSplitterFactory {
    XmlSplitter createXmlSplitter(CompleteElementCallback completeElementCallback, DeclarationCallback declarationCallback, ProcessingInstructionCallback processingInstructionCallback);
}
