package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {
    protected ScatterDataProvider mChart;
    float[] mPixelBuffer;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mPixelBuffer = new float[2];
        this.mChart = scatterDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t : this.mChart.getScatterData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.github.mikephil.charting.data.Entry] */
    protected void drawDataSet(Canvas canvas, IScatterDataSet iScatterDataSet) {
        IScatterDataSet iScatterDataSet2 = iScatterDataSet;
        if (iScatterDataSet2.getEntryCount() < 1) {
            return;
        }
        ViewPortHandler viewPortHandler = this.mViewPortHandler;
        Transformer transformer = this.mChart.getTransformer(iScatterDataSet2.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        IShapeRenderer shapeRenderer = iScatterDataSet2.getShapeRenderer();
        if (shapeRenderer == null) {
            Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
            return;
        }
        int iMin = (int) Math.min(Math.ceil(iScatterDataSet2.getEntryCount() * this.mAnimator.getPhaseX()), iScatterDataSet2.getEntryCount());
        int i = 0;
        while (i < iMin) {
            ?? entryForIndex = iScatterDataSet2.getEntryForIndex(i);
            this.mPixelBuffer[0] = entryForIndex.getX();
            this.mPixelBuffer[1] = entryForIndex.getY() * phaseY;
            transformer.pointValuesToPixel(this.mPixelBuffer);
            if (!viewPortHandler.isInBoundsRight(this.mPixelBuffer[0])) {
                return;
            }
            if (viewPortHandler.isInBoundsLeft(this.mPixelBuffer[0]) && viewPortHandler.isInBoundsY(this.mPixelBuffer[1])) {
                this.mRenderPaint.setColor(iScatterDataSet2.getColor(i / 2));
                ViewPortHandler viewPortHandler2 = this.mViewPortHandler;
                float[] fArr = this.mPixelBuffer;
                shapeRenderer.renderShape(canvas, iScatterDataSet2, viewPortHandler2, fArr[0], fArr[1], this.mRenderPaint);
            }
            i++;
            iScatterDataSet2 = iScatterDataSet;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        Entry entry;
        ScatterChartRenderer scatterChartRenderer = this;
        if (scatterChartRenderer.isDrawingValuesAllowed(scatterChartRenderer.mChart)) {
            List<T> dataSets = scatterChartRenderer.mChart.getScatterData().getDataSets();
            int i = 0;
            while (i < scatterChartRenderer.mChart.getScatterData().getDataSetCount()) {
                IScatterDataSet iScatterDataSet = (IScatterDataSet) dataSets.get(i);
                if (scatterChartRenderer.shouldDrawValues(iScatterDataSet) && iScatterDataSet.getEntryCount() >= 1) {
                    scatterChartRenderer.applyValueTextStyle(iScatterDataSet);
                    scatterChartRenderer.mXBounds.set(scatterChartRenderer.mChart, iScatterDataSet);
                    float[] fArrGenerateTransformedValuesScatter = scatterChartRenderer.mChart.getTransformer(iScatterDataSet.getAxisDependency()).generateTransformedValuesScatter(iScatterDataSet, scatterChartRenderer.mAnimator.getPhaseX(), scatterChartRenderer.mAnimator.getPhaseY(), scatterChartRenderer.mXBounds.min, scatterChartRenderer.mXBounds.max);
                    float fConvertDpToPixel = Utils.convertDpToPixel(iScatterDataSet.getScatterShapeSize());
                    ValueFormatter valueFormatter = iScatterDataSet.getValueFormatter();
                    MPPointF mPPointF = MPPointF.getInstance(iScatterDataSet.getIconsOffset());
                    mPPointF.x = Utils.convertDpToPixel(mPPointF.x);
                    mPPointF.y = Utils.convertDpToPixel(mPPointF.y);
                    int i2 = 0;
                    while (i2 < fArrGenerateTransformedValuesScatter.length && scatterChartRenderer.mViewPortHandler.isInBoundsRight(fArrGenerateTransformedValuesScatter[i2])) {
                        if (scatterChartRenderer.mViewPortHandler.isInBoundsLeft(fArrGenerateTransformedValuesScatter[i2])) {
                            int i3 = i2 + 1;
                            if (scatterChartRenderer.mViewPortHandler.isInBoundsY(fArrGenerateTransformedValuesScatter[i3])) {
                                int i4 = i2 / 2;
                                Entry entryForIndex = iScatterDataSet.getEntryForIndex(scatterChartRenderer.mXBounds.min + i4);
                                if (iScatterDataSet.isDrawValuesEnabled()) {
                                    entry = entryForIndex;
                                    scatterChartRenderer.drawValue(canvas, valueFormatter.getPointLabel(entryForIndex), fArrGenerateTransformedValuesScatter[i2], fArrGenerateTransformedValuesScatter[i3] - fConvertDpToPixel, iScatterDataSet.getValueTextColor(i4 + scatterChartRenderer.mXBounds.min));
                                } else {
                                    entry = entryForIndex;
                                }
                                if (entry.getIcon() != null && iScatterDataSet.isDrawIconsEnabled()) {
                                    Drawable icon = entry.getIcon();
                                    Utils.drawImage(canvas, icon, (int) (fArrGenerateTransformedValuesScatter[i2] + mPPointF.x), (int) (fArrGenerateTransformedValuesScatter[i3] + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                }
                            }
                        }
                        i2 += 2;
                        scatterChartRenderer = this;
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
                i++;
                scatterChartRenderer = this;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.mChart.getScatterData();
        for (Highlight highlight : highlightArr) {
            IScatterDataSet iScatterDataSet = (IScatterDataSet) scatterData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iScatterDataSet != null && iScatterDataSet.isHighlightEnabled()) {
                ?? entryForXValue = iScatterDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(entryForXValue, iScatterDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iScatterDataSet.getAxisDependency()).getPixelForValues(entryForXValue.getX(), entryForXValue.getY() * this.mAnimator.getPhaseY());
                    highlight.setDraw((float) pixelForValues.x, (float) pixelForValues.y);
                    drawHighlightLines(canvas, (float) pixelForValues.x, (float) pixelForValues.y, iScatterDataSet);
                }
            }
        }
    }
}
