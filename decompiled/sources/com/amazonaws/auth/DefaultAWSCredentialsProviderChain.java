package com.amazonaws.auth;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class DefaultAWSCredentialsProviderChain extends AWSCredentialsProviderChain {
    public DefaultAWSCredentialsProviderChain() {
        super(new SystemPropertiesCredentialsProvider(), new ClasspathPropertiesFileCredentialsProvider());
    }
}
