package org.jivesoftware.smackx.ox;

import java.io.IOException;
import java.nio.charset.Charset;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.element.OpenPgpContentElement;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider;
import org.pgpainless.decryption_verification.OpenPgpMetadata;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpMessage {
    private final String element;
    private final OpenPgpMetadata metadata;
    private OpenPgpContentElement openPgpContentElement;
    private final State state;

    public enum State {
        signcrypt,
        sign,
        crypt
    }

    public OpenPgpMessage(String str, State state, OpenPgpMetadata openPgpMetadata) {
        this.metadata = (OpenPgpMetadata) Objects.requireNonNull(openPgpMetadata);
        this.state = (State) Objects.requireNonNull(state);
        this.element = (String) Objects.requireNonNull(str);
    }

    public OpenPgpMessage(byte[] bArr, State state, OpenPgpMetadata openPgpMetadata) {
        this(new String((byte[]) Objects.requireNonNull(bArr), Charset.forName("UTF-8")), state, openPgpMetadata);
    }

    public OpenPgpContentElement getOpenPgpContentElement() throws XmlPullParserException, IOException {
        ensureOpenPgpContentElementSet();
        return this.openPgpContentElement;
    }

    private void ensureOpenPgpContentElementSet() throws XmlPullParserException, IOException {
        if (this.openPgpContentElement != null) {
            return;
        }
        OpenPgpContentElement openPgpContentElement = OpenPgpContentElementProvider.parseOpenPgpContentElement(this.element);
        this.openPgpContentElement = openPgpContentElement;
        if (openPgpContentElement == null) {
            return;
        }
        if (openPgpContentElement instanceof SigncryptElement) {
            if (this.state != State.signcrypt) {
                throw new IllegalStateException("OpenPgpContentElement was signed and encrypted, but is not a SigncryptElement.");
            }
        } else if (openPgpContentElement instanceof SignElement) {
            if (this.state != State.sign) {
                throw new IllegalStateException("OpenPgpContentElement was signed and unencrypted, but is not a SignElement.");
            }
        } else if ((openPgpContentElement instanceof CryptElement) && this.state != State.crypt) {
            throw new IllegalStateException("OpenPgpContentElement was unsigned and encrypted, but is not a CryptElement.");
        }
    }

    public State getState() throws XmlPullParserException, IOException {
        ensureOpenPgpContentElementSet();
        return this.state;
    }

    public OpenPgpMetadata getMetadata() {
        return this.metadata;
    }
}
