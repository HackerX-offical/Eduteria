package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonServiceException;

/* JADX INFO: loaded from: classes4.dex */
public class ProvisionedThroughputExceededException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public ProvisionedThroughputExceededException(String str) {
        super(str);
    }
}
