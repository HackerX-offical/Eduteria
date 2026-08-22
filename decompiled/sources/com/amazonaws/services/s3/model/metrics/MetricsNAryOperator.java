package com.amazonaws.services.s3.model.metrics;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class MetricsNAryOperator extends MetricsFilterPredicate {
    private final List<MetricsFilterPredicate> operands;

    public MetricsNAryOperator(List<MetricsFilterPredicate> list) {
        this.operands = list;
    }

    public List<MetricsFilterPredicate> getOperands() {
        return this.operands;
    }
}
