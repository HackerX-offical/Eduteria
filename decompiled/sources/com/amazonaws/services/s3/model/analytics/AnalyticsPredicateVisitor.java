package com.amazonaws.services.s3.model.analytics;

/* JADX INFO: loaded from: classes4.dex */
public interface AnalyticsPredicateVisitor {
    void visit(AnalyticsAndOperator analyticsAndOperator);

    void visit(AnalyticsPrefixPredicate analyticsPrefixPredicate);

    void visit(AnalyticsTagPredicate analyticsTagPredicate);
}
