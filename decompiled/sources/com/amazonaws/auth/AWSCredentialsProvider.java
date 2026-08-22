package com.amazonaws.auth;

/* JADX INFO: loaded from: classes4.dex */
public interface AWSCredentialsProvider {
    AWSCredentials getCredentials();

    void refresh();
}
