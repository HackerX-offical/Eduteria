package org.jivesoftware.smackx.jingle_filetransfer.element;

import java.util.List;
import org.jivesoftware.smackx.jingle.element.JingleContentDescription;
import org.jivesoftware.smackx.jingle.element.JingleContentDescriptionChildElement;

/* JADX INFO: loaded from: classes10.dex */
public class JingleFileTransfer extends JingleContentDescription {
    public static final String NAMESPACE_V5 = "urn:xmpp:jingle:apps:file-transfer:5";

    public JingleFileTransfer(List<JingleContentDescriptionChildElement> list) {
        super(list);
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:jingle:apps:file-transfer:5";
    }
}
