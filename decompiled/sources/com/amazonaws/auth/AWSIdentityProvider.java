package com.amazonaws.auth;

/* JADX INFO: loaded from: classes4.dex */
public interface AWSIdentityProvider {
    String getToken();

    String refresh();
}
