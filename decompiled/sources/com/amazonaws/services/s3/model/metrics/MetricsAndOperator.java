package com.amazonaws.services.s3.model.metrics;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MetricsAndOperator extends MetricsNAryOperator {
    @Override // com.amazonaws.services.s3.model.metrics.MetricsNAryOperator
    public /* bridge */ /* synthetic */ List getOperands() {
        return super.getOperands();
    }

    public MetricsAndOperator(List<MetricsFilterPredicate> list) {
        super(list);
    }

    @Override // com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate
    public void accept(MetricsPredicateVisitor metricsPredicateVisitor) {
        metricsPredicateVisitor.visit(this);
    }
}
