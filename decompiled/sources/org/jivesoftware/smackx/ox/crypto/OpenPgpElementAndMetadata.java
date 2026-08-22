package org.jivesoftware.smackx.ox.crypto;

import org.jivesoftware.smackx.ox.element.OpenPgpElement;
import org.pgpainless.decryption_verification.OpenPgpMetadata;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpElementAndMetadata {
    private final OpenPgpElement element;
    private final OpenPgpMetadata metadata;

    public OpenPgpElementAndMetadata(OpenPgpElement openPgpElement, OpenPgpMetadata openPgpMetadata) {
        this.element = openPgpElement;
        this.metadata = openPgpMetadata;
    }

    public OpenPgpElement getElement() {
        return this.element;
    }

    public OpenPgpMetadata getMetadata() {
        return this.metadata;
    }
}
