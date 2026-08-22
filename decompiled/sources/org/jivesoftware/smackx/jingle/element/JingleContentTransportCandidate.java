package org.jivesoftware.smackx.jingle.element;

import org.jivesoftware.smack.packet.FullyQualifiedElement;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleContentTransportCandidate implements FullyQualifiedElement {
    public static final String ELEMENT = "candidate";

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }
}
