package fr.maxcom.http;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes9.dex */
public interface CipherFactory {
    Cipher getCipher() throws GeneralSecurityException;

    Cipher rebaseCipher(byte[] bArr) throws GeneralSecurityException;
}
