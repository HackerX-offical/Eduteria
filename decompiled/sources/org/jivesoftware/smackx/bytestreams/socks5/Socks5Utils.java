package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.SHA1;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class Socks5Utils {
    public static String createDigest(String str, Jid jid, Jid jid2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append((CharSequence) jid).append((CharSequence) jid2);
        return SHA1.hex(sb.toString());
    }

    public static byte[] receiveSocks5Message(DataInputStream dataInputStream) throws IOException, SmackException.SmackMessageException {
        byte[] bArr = new byte[5];
        dataInputStream.readFully(bArr, 0, 5);
        if (bArr[3] != 3) {
            throw new SmackException.SmackMessageException("Unsupported SOCKS5 address type: " + ((int) bArr[3]) + " (expected: 0x03)");
        }
        int i = bArr[4];
        byte[] bArr2 = new byte[i + 7];
        System.arraycopy(bArr, 0, bArr2, 0, 5);
        dataInputStream.readFully(bArr2, 5, i + 2);
        return bArr2;
    }
}
