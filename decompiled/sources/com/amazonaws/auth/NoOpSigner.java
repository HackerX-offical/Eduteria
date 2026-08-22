package com.amazonaws.auth;

import com.amazonaws.Request;

/* JADX INFO: loaded from: classes4.dex */
public class NoOpSigner implements Signer {
    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) {
    }
}
