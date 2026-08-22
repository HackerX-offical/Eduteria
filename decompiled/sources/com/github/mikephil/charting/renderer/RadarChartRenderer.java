package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import org.mozilla.classfile.ByteCode;

/* JADX INFO: loaded from: classes7.dex */
public class RadarChartRenderer extends LineRadarRenderer {
    protected RadarChart mChart;
    protected Path mDrawDataSetSurfacePathBuffer;
    protected Path mDrawHighlightCirclePathBuffer;
    protected Paint mHighlightCirclePaint;
    protected Paint mWebPaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mDrawDataSetSurfacePathBuffer = new Path();
        this.mDrawHighlightCirclePathBuffer = new Path();
        this.mChart = radarChart;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(2.0f);
        this.mHighlightPaint.setColor(Color.rgb(255, ByteCode.NEW, 115));
        Paint paint = new Paint(1);
        this.mWebPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mHighlightCirclePaint = new Paint(1);
    }

    public Paint getWebPaint() {
        return this.mWebPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        RadarData radarData = (RadarData) this.mChart.getData();
        int entryCount = radarData.getMaxEntryCountSet().getEntryCount();
        for (IRadarDataSet iRadarDataSet : radarData.getDataSets()) {
            if (iRadarDataSet.isVisible()) {
                drawDataSet(canvas, iRadarDataSet, entryCount);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, IRadarDataSet iRadarDataSet, int i) {
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        Path path = this.mDrawDataSetSurfacePathBuffer;
        path.reset();
        boolean z = false;
        for (int i2 = 0; i2 < iRadarDataSet.getEntryCount(); i2++) {
            this.mRenderPaint.setColor(iRadarDataSet.getColor(i2));
            Utils.getPosition(centerOffsets, (((RadarEntry) iRadarDataSet.getEntryForIndex(i2)).getY() - this.mChart.getYChartMin()) * factor * phaseY, (i2 * sliceAngle * phaseX) + this.mChart.getRotationAngle(), mPPointF);
            if (!Float.isNaN(mPPointF.x)) {
                if (!z) {
                    path.moveTo(mPPointF.x, mPPointF.y);
                    z = true;
                } else {
                    path.lineTo(mPPointF.x, mPPointF.y);
                }
            }
        }
        if (iRadarDataSet.getEntryCount() > i) {
            path.lineTo(centerOffsets.x, centerOffsets.y);
        }
        path.close();
        if (iRadarDataSet.isDrawFilledEnabled()) {
            Drawable fillDrawable = iRadarDataSet.getFillDrawable();
            if (fillDrawable != null) {
                drawFilledPath(canvas, path, fillDrawable);
            } else {
                drawFilledPath(canvas, path, iRadarDataSet.getFillColor(), iRadarDataSet.getFillAlpha());
            }
        }
        this.mRenderPaint.setStrokeWidth(iRadarDataSet.getLineWidth());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        if (!iRadarDataSet.isDrawFilledEnabled() || iRadarDataSet.getFillAlpha() < 255) {
            canvas.drawPath(path, this.mRenderPaint);
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        float f2;
        IRadarDataSet iRadarDataSet;
        int i;
        RadarEntry radarEntry;
        float f3;
        MPPointF mPPointF;
        ValueFormatter valueFormatter;
        RadarChartRenderer radarChartRenderer = this;
        float phaseX = radarChartRenderer.mAnimator.getPhaseX();
        float phaseY = radarChartRenderer.mAnimator.getPhaseY();
        float sliceAngle = radarChartRenderer.mChart.getSliceAngle();
        float factor = radarChartRenderer.mChart.getFactor();
        MPPointF centerOffsets = radarChartRenderer.mChart.getCenterOffsets();
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        MPPointF mPPointF3 = MPPointF.getInstance(0.0f, 0.0f);
        float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
        int i2 = 0;
        while (i2 < ((RadarData) radarChartRenderer.mChart.getData()).getDataSetCount()) {
            IRadarDataSet dataSetByIndex = ((RadarData) radarChartRenderer.mChart.getData()).getDataSetByIndex(i2);
            if (radarChartRenderer.shouldDrawValues(dataSetByIndex)) {
                radarChartRenderer.applyValueTextStyle(dataSetByIndex);
                ValueFormatter valueFormatter2 = dataSetByIndex.getValueFormatter();
                MPPointF mPPointF4 = MPPointF.getInstance(dataSetByIndex.getIconsOffset());
                mPPointF4.x = Utils.convertDpToPixel(mPPointF4.x);
                mPPointF4.y = Utils.convertDpToPixel(mPPointF4.y);
                int i3 = 0;
                while (i3 < dataSetByIndex.getEntryCount()) {
                    RadarEntry radarEntry2 = (RadarEntry) dataSetByIndex.getEntryForIndex(i3);
                    MPPointF mPPointF5 = mPPointF4;
                    float f4 = i3 * sliceAngle * phaseX;
                    Utils.getPosition(centerOffsets, (radarEntry2.getY() - radarChartRenderer.mChart.getYChartMin()) * factor * phaseY, f4 + radarChartRenderer.mChart.getRotationAngle(), mPPointF2);
                    if (dataSetByIndex.isDrawValuesEnabled()) {
                        ValueFormatter valueFormatter3 = valueFormatter2;
                        i = i3;
                        radarEntry = radarEntry2;
                        f3 = phaseX;
                        mPPointF = mPPointF5;
                        radarChartRenderer = this;
                        valueFormatter = valueFormatter3;
                        iRadarDataSet = dataSetByIndex;
                        radarChartRenderer.drawValue(canvas, valueFormatter3.getRadarLabel(radarEntry2), mPPointF2.x, mPPointF2.y - fConvertDpToPixel, dataSetByIndex.getValueTextColor(i3));
                    } else {
                        iRadarDataSet = dataSetByIndex;
                        i = i3;
                        radarEntry = radarEntry2;
                        f3 = phaseX;
                        mPPointF = mPPointF5;
                        valueFormatter = valueFormatter2;
                    }
                    if (radarEntry.getIcon() != null && iRadarDataSet.isDrawIconsEnabled()) {
                        Drawable icon = radarEntry.getIcon();
                        Utils.getPosition(centerOffsets, (radarEntry.getY() * factor * phaseY) + mPPointF.y, f4 + radarChartRenderer.mChart.getRotationAngle(), mPPointF3);
                        mPPointF3.y += mPPointF.x;
                        Utils.drawImage(canvas, icon, (int) mPPointF3.x, (int) mPPointF3.y, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i3 = i + 1;
                    mPPointF4 = mPPointF;
                    dataSetByIndex = iRadarDataSet;
                    valueFormatter2 = valueFormatter;
                    phaseX = f3;
                }
                f2 = phaseX;
                MPPointF.recycleInstance(mPPointF4);
            } else {
                f2 = phaseX;
            }
            i2++;
            phaseX = f2;
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF2);
        MPPointF.recycleInstance(mPPointF3);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawWeb(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawWeb(Canvas canvas) {
        float sliceAngle = this.mChart.getSliceAngle();
        float factor = this.mChart.getFactor();
        float rotationAngle = this.mChart.getRotationAngle();
        MPPointF centerOffsets = this.mChart.getCenterOffsets();
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidth());
        this.mWebPaint.setColor(this.mChart.getWebColor());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int skipWebLineCount = this.mChart.getSkipWebLineCount() + 1;
        int entryCount = ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        for (int i = 0; i < entryCount; i += skipWebLineCount) {
            Utils.getPosition(centerOffsets, this.mChart.getYRange() * factor, (i * sliceAngle) + rotationAngle, mPPointF);
            canvas.drawLine(centerOffsets.x, centerOffsets.y, mPPointF.x, mPPointF.y, this.mWebPaint);
        }
        MPPointF.recycleInstance(mPPointF);
        this.mWebPaint.setStrokeWidth(this.mChart.getWebLineWidthInner());
        this.mWebPaint.setColor(this.mChart.getWebColorInner());
        this.mWebPaint.setAlpha(this.mChart.getWebAlpha());
        int i2 = this.mChart.getYAxis().mEntryCount;
        MPPointF mPPointF2 = MPPointF.getInstance(0.0f, 0.0f);
        MPPointF mPPointF3 = MPPointF.getInstance(0.0f, 0.0f);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (i4 < ((RadarData) this.mChart.getData()).getEntryCount()) {
                float yChartMin = (this.mChart.getYAxis().mEntries[i3] - this.mChart.getYChartMin()) * factor;
                Utils.getPosition(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle, mPPointF2);
                i4++;
                Utils.getPosition(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle, mPPointF3);
                canvas.drawLine(mPPointF2.x, mPPointF2.y, mPPointF3.x, mPPointF3.y, this.mWebPaint);
            }
        }
        MPPointF.recycleInstance(mPPointF2);
        MPPointF.recycleInstance(mPPointF3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        RadarChartRenderer radarChartRenderer = this;
        float sliceAngle = radarChartRenderer.mChart.getSliceAngle();
        float factor = radarChartRenderer.mChart.getFactor();
        MPPointF centerOffsets = radarChartRenderer.mChart.getCenterOffsets();
        MPPointF mPPointF = MPPointF.getInstance(0.0f, 0.0f);
        RadarData radarData = (RadarData) radarChartRenderer.mChart.getData();
        int length = highlightArr.length;
        int i = 0;
        while (i < length) {
            Highlight highlight = highlightArr[i];
            IRadarDataSet dataSetByIndex = radarData.getDataSetByIndex(highlight.getDataSetIndex());
            if (dataSetByIndex != null && dataSetByIndex.isHighlightEnabled()) {
                RadarEntry radarEntry = (RadarEntry) dataSetByIndex.getEntryForIndex((int) highlight.getX());
                if (radarChartRenderer.isInBoundsX(radarEntry, dataSetByIndex)) {
                    Utils.getPosition(centerOffsets, (radarEntry.getY() - radarChartRenderer.mChart.getYChartMin()) * factor * radarChartRenderer.mAnimator.getPhaseY(), (highlight.getX() * sliceAngle * radarChartRenderer.mAnimator.getPhaseX()) + radarChartRenderer.mChart.getRotationAngle(), mPPointF);
                    highlight.setDraw(mPPointF.x, mPPointF.y);
                    radarChartRenderer.drawHighlightLines(canvas, mPPointF.x, mPPointF.y, dataSetByIndex);
                    if (dataSetByIndex.isDrawHighlightCircleEnabled() && !Float.isNaN(mPPointF.x) && !Float.isNaN(mPPointF.y)) {
                        int highlightCircleStrokeColor = dataSetByIndex.getHighlightCircleStrokeColor();
                        if (highlightCircleStrokeColor == 1122867) {
                            highlightCircleStrokeColor = dataSetByIndex.getColor(0);
                        }
                        if (dataSetByIndex.getHighlightCircleStrokeAlpha() < 255) {
                            highlightCircleStrokeColor = ColorTemplate.colorWithAlpha(highlightCircleStrokeColor, dataSetByIndex.getHighlightCircleStrokeAlpha());
                        }
                        radarChartRenderer.drawHighlightCircle(canvas, mPPointF, dataSetByIndex.getHighlightCircleInnerRadius(), dataSetByIndex.getHighlightCircleOuterRadius(), dataSetByIndex.getHighlightCircleFillColor(), highlightCircleStrokeColor, dataSetByIndex.getHighlightCircleStrokeWidth());
                    }
                }
            }
            i++;
            radarChartRenderer = this;
        }
        MPPointF.recycleInstance(centerOffsets);
        MPPointF.recycleInstance(mPPointF);
    }

    public void drawHighlightCircle(Canvas canvas, MPPointF mPPointF, float f2, float f3, int i, int i2, float f4) {
        canvas.save();
        float fConvertDpToPixel = Utils.convertDpToPixel(f3);
        float fConvertDpToPixel2 = Utils.convertDpToPixel(f2);
        if (i != 1122867) {
            Path path = this.mDrawHighlightCirclePathBuffer;
            path.reset();
            path.addCircle(mPPointF.x, mPPointF.y, fConvertDpToPixel, Path.Direction.CW);
            if (fConvertDpToPixel2 > 0.0f) {
                path.addCircle(mPPointF.x, mPPointF.y, fConvertDpToPixel2, Path.Direction.CCW);
            }
            this.mHighlightCirclePaint.setColor(i);
            this.mHighlightCirclePaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.mHighlightCirclePaint);
        }
        if (i2 != 1122867) {
            this.mHighlightCirclePaint.setColor(i2);
            this.mHighlightCirclePaint.setStyle(Paint.Style.STROKE);
            this.mHighlightCirclePaint.setStrokeWidth(Utils.convertDpToPixel(f4));
            canvas.drawCircle(mPPointF.x, mPPointF.y, fConvertDpToPixel, this.mHighlightCirclePaint);
        }
        canvas.restore();
    }
}
