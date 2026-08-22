package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

/* JADX INFO: loaded from: classes4.dex */
public class BackupInUseException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public BackupInUseException(String str) {
        super(str);
    }
}
