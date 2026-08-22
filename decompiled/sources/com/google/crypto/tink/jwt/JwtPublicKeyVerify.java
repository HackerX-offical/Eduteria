package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes7.dex */
@Immutable
public interface JwtPublicKeyVerify {
    VerifiedJwt verifyAndDecode(String compact, JwtValidator validator) throws GeneralSecurityException;
}
