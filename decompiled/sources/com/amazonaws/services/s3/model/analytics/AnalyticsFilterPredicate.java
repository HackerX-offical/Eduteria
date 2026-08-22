package com.amazonaws.services.s3.model.analytics;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AnalyticsFilterPredicate implements Serializable {
    public abstract void accept(AnalyticsPredicateVisitor analyticsPredicateVisitor);
}
