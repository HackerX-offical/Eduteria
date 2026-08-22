package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.data.CombinedData;

/* JADX INFO: loaded from: classes7.dex */
public interface CombinedDataProvider extends LineDataProvider, BarDataProvider, BubbleDataProvider, CandleDataProvider, ScatterDataProvider {
    CombinedData getCombinedData();
}
