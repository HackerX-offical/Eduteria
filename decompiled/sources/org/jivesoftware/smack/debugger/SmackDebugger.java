package org.jivesoftware.smack.debugger;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.util.ObservableReader;
import org.jivesoftware.smack.util.ObservableWriter;
import org.jivesoftware.smack.util.ReaderListener;
import org.jivesoftware.smack.util.WriterListener;
import org.jxmpp.jid.EntityFullJid;
import org.jxmpp.xml.splitter.XmlPrettyPrinter;
import org.jxmpp.xml.splitter.XmppXmlSplitter;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SmackDebugger {
    protected final XMPPConnection connection;
    private XmppXmlSplitter incomingStreamSplitterForPrettyPrinting;
    private XmppXmlSplitter outgoingStreamSplitterForPrettyPrinting;

    /* JADX INFO: renamed from: incomingStreamSink, reason: merged with bridge method [inline-methods] */
    public abstract void m14195x4a9ebbdd(CharSequence charSequence);

    public void onIncomingElementCompleted() {
    }

    public abstract void onIncomingStreamElement(TopLevelStreamElement topLevelStreamElement);

    public void onOutgoingElementCompleted() {
    }

    public abstract void onOutgoingStreamElement(TopLevelStreamElement topLevelStreamElement);

    /* JADX INFO: renamed from: outgoingStreamSink, reason: merged with bridge method [inline-methods] */
    public abstract void m14197x8b8e340f(CharSequence charSequence);

    public abstract void userHasLogged(EntityFullJid entityFullJid);

    protected SmackDebugger(XMPPConnection xMPPConnection) {
        this.connection = xMPPConnection;
    }

    public final Reader newConnectionReader(Reader reader) {
        this.incomingStreamSplitterForPrettyPrinting = new XmppXmlSplitter(XmlPrettyPrinter.builder().setPrettyWriter(new XmlPrettyPrinter.PrettyPrintedXmlChunkSink() { // from class: org.jivesoftware.smack.debugger.SmackDebugger$$ExternalSyntheticLambda0
            @Override // org.jxmpp.xml.splitter.XmlPrettyPrinter.PrettyPrintedXmlChunkSink
            public final void sink(StringBuilder sb) {
                this.f$0.m14195x4a9ebbdd(sb);
            }
        }).build());
        ObservableReader observableReader = new ObservableReader(reader);
        observableReader.addReaderListener(new ReaderListener() { // from class: org.jivesoftware.smack.debugger.SmackDebugger$$ExternalSyntheticLambda1
            @Override // org.jivesoftware.smack.util.ReaderListener
            public final void read(String str) {
                this.f$0.m14196xc018e21e(str);
            }
        });
        return observableReader;
    }

    /* JADX INFO: renamed from: lambda$newConnectionReader$1$org-jivesoftware-smack-debugger-SmackDebugger, reason: not valid java name */
    /* synthetic */ void m14196xc018e21e(String str) {
        try {
            this.incomingStreamSplitterForPrettyPrinting.append((CharSequence) str);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final Writer newConnectionWriter(Writer writer) {
        this.outgoingStreamSplitterForPrettyPrinting = new XmppXmlSplitter(XmlPrettyPrinter.builder().setPrettyWriter(new XmlPrettyPrinter.PrettyPrintedXmlChunkSink() { // from class: org.jivesoftware.smack.debugger.SmackDebugger$$ExternalSyntheticLambda2
            @Override // org.jxmpp.xml.splitter.XmlPrettyPrinter.PrettyPrintedXmlChunkSink
            public final void sink(StringBuilder sb) {
                this.f$0.m14197x8b8e340f(sb);
            }
        }).build());
        ObservableWriter observableWriter = new ObservableWriter(writer);
        observableWriter.addWriterListener(new WriterListener() { // from class: org.jivesoftware.smack.debugger.SmackDebugger$$ExternalSyntheticLambda3
            @Override // org.jivesoftware.smack.util.WriterListener
            public final void write(String str) {
                this.f$0.m14198x1085a50(str);
            }
        });
        return observableWriter;
    }

    /* JADX INFO: renamed from: lambda$newConnectionWriter$3$org-jivesoftware-smack-debugger-SmackDebugger, reason: not valid java name */
    /* synthetic */ void m14198x1085a50(String str) {
        try {
            this.outgoingStreamSplitterForPrettyPrinting.append((CharSequence) str);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
