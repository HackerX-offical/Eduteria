package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class BubbleData extends BarLineScatterCandleBubbleData<IBubbleDataSet> {
    public BubbleData() {
    }

    public BubbleData(IBubbleDataSet... iBubbleDataSetArr) {
        super(iBubbleDataSetArr);
    }

    public BubbleData(List<IBubbleDataSet> list) {
        super(list);
    }

    public void setHighlightCircleWidth(float f2) {
        Iterator it = this.mDataSets.iterator();
        while (it.hasNext()) {
            ((IBubbleDataSet) it.next()).setHighlightCircleWidth(f2);
        }
    }
}
