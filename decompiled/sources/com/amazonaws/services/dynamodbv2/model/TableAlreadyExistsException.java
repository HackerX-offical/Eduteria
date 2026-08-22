package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

/* JADX INFO: loaded from: classes4.dex */
public class TableAlreadyExistsException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TableAlreadyExistsException(String str) {
        super(str);
    }
}
