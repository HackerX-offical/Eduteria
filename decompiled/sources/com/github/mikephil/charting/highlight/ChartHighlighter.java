package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {
    protected T mChart;
    protected List<Highlight> mHighlightBuffer = new ArrayList();

    public ChartHighlighter(T t) {
        this.mChart = t;
    }

    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight getHighlight(float f2, float f3) {
        MPPointD valsForTouch = getValsForTouch(f2, f3);
        float f4 = (float) valsForTouch.x;
        MPPointD.recycleInstance(valsForTouch);
        return getHighlightForX(f4, f2, f3);
    }

    protected MPPointD getValsForTouch(float f2, float f3) {
        return this.mChart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(f2, f3);
    }

    protected Highlight getHighlightForX(float f2, float f3, float f4) {
        List<Highlight> highlightsAtXValue = getHighlightsAtXValue(f2, f3, f4);
        if (highlightsAtXValue.isEmpty()) {
            return null;
        }
        return getClosestHighlightByPixel(highlightsAtXValue, f3, f4, getMinimumDistance(highlightsAtXValue, f4, YAxis.AxisDependency.LEFT) < getMinimumDistance(highlightsAtXValue, f4, YAxis.AxisDependency.RIGHT) ? YAxis.AxisDependency.LEFT : YAxis.AxisDependency.RIGHT, this.mChart.getMaxHighlightDistance());
    }

    protected float getMinimumDistance(List<Highlight> list, float f2, YAxis.AxisDependency axisDependency) {
        float f3 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Highlight highlight = list.get(i);
            if (highlight.getAxis() == axisDependency) {
                float fAbs = Math.abs(getHighlightPos(highlight) - f2);
                if (fAbs < f3) {
                    f3 = fAbs;
                }
            }
        }
        return f3;
    }

    protected float getHighlightPos(Highlight highlight) {
        return highlight.getYPx();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    protected List<Highlight> getHighlightsAtXValue(float f2, float f3, float f4) {
        this.mHighlightBuffer.clear();
        BarLineScatterCandleBubbleData data = getData();
        if (data == null) {
            return this.mHighlightBuffer;
        }
        int dataSetCount = data.getDataSetCount();
        for (int i = 0; i < dataSetCount; i++) {
            ?? dataSetByIndex = data.getDataSetByIndex(i);
            if (dataSetByIndex.isHighlightEnabled()) {
                this.mHighlightBuffer.addAll(buildHighlights(dataSetByIndex, i, f2, DataSet.Rounding.CLOSEST));
            }
        }
        return this.mHighlightBuffer;
    }

    protected List<Highlight> buildHighlights(IDataSet iDataSet, int i, float f2, DataSet.Rounding rounding) {
        Entry entryForXValue;
        ArrayList arrayList = new ArrayList();
        List<Entry> entriesForXValue = iDataSet.getEntriesForXValue(f2);
        if (entriesForXValue.size() == 0 && (entryForXValue = iDataSet.getEntryForXValue(f2, Float.NaN, rounding)) != null) {
            entriesForXValue = iDataSet.getEntriesForXValue(entryForXValue.getX());
        }
        if (entriesForXValue.size() != 0) {
            for (Entry entry : entriesForXValue) {
                MPPointD pixelForValues = this.mChart.getTransformer(iDataSet.getAxisDependency()).getPixelForValues(entry.getX(), entry.getY());
                arrayList.add(new Highlight(entry.getX(), entry.getY(), (float) pixelForValues.x, (float) pixelForValues.y, i, iDataSet.getAxisDependency()));
            }
        }
        return arrayList;
    }

    public Highlight getClosestHighlightByPixel(List<Highlight> list, float f2, float f3, YAxis.AxisDependency axisDependency, float f4) {
        Highlight highlight = null;
        for (int i = 0; i < list.size(); i++) {
            Highlight highlight2 = list.get(i);
            if (axisDependency == null || highlight2.getAxis() == axisDependency) {
                float distance = getDistance(f2, f3, highlight2.getXPx(), highlight2.getYPx());
                if (distance < f4) {
                    highlight = highlight2;
                    f4 = distance;
                }
            }
        }
        return highlight;
    }

    protected float getDistance(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot(f2 - f4, f3 - f5);
    }

    protected BarLineScatterCandleBubbleData getData() {
        return this.mChart.getData();
    }
}
