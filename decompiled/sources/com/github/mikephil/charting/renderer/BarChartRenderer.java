package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect;
    private RectF mBarShadowRectBuffer;
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mBarRect = new RectF();
        this.mBarShadowRectBuffer = new RectF();
        this.mChart = barDataProvider;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint paint = new Paint(1);
        this.mShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mBarBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new BarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        BarData barData = this.mChart.getBarData();
        for (int i = 0; i < barData.getDataSetCount(); i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            if (iBarDataSet.isVisible()) {
                drawDataSet(canvas, iBarDataSet, i);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, IBarDataSet iBarDataSet, int i) {
        Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
        this.mBarBorderPaint.setColor(iBarDataSet.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(iBarDataSet.getBarBorderWidth()));
        int i2 = 0;
        boolean z = iBarDataSet.getBarBorderWidth() > 0.0f;
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled()) {
            this.mShadowPaint.setColor(iBarDataSet.getBarShadowColor());
            float barWidth = this.mChart.getBarData().getBarWidth() / 2.0f;
            int iMin = Math.min((int) Math.ceil(iBarDataSet.getEntryCount() * phaseX), iBarDataSet.getEntryCount());
            for (int i3 = 0; i3 < iMin; i3++) {
                float x = ((BarEntry) iBarDataSet.getEntryForIndex(i3)).getX();
                this.mBarShadowRectBuffer.left = x - barWidth;
                this.mBarShadowRectBuffer.right = x + barWidth;
                transformer.rectValueToPixel(this.mBarShadowRectBuffer);
                if (this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right)) {
                    if (!this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
                    this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
                    canvas.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
                }
            }
        }
        Canvas canvas2 = canvas;
        BarBuffer barBuffer = this.mBarBuffers[i];
        barBuffer.setPhases(phaseX, phaseY);
        barBuffer.setDataSet(i);
        barBuffer.setInverted(this.mChart.isInverted(iBarDataSet.getAxisDependency()));
        barBuffer.setBarWidth(this.mChart.getBarData().getBarWidth());
        barBuffer.feed(iBarDataSet);
        transformer.pointValuesToPixel(barBuffer.buffer);
        boolean z2 = iBarDataSet.getColors().size() == 1;
        if (z2) {
            this.mRenderPaint.setColor(iBarDataSet.getColor());
        }
        while (i2 < barBuffer.size()) {
            int i4 = i2 + 2;
            if (this.mViewPortHandler.isInBoundsLeft(barBuffer.buffer[i4])) {
                if (!this.mViewPortHandler.isInBoundsRight(barBuffer.buffer[i2])) {
                    return;
                }
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i2 / 4));
                }
                if (iBarDataSet.getGradientColor() != null) {
                    GradientColor gradientColor = iBarDataSet.getGradientColor();
                    this.mRenderPaint.setShader(new LinearGradient(barBuffer.buffer[i2], barBuffer.buffer[i2 + 3], barBuffer.buffer[i2], barBuffer.buffer[i2 + 1], gradientColor.getStartColor(), gradientColor.getEndColor(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.getGradientColors() != null) {
                    int i5 = i2 / 4;
                    this.mRenderPaint.setShader(new LinearGradient(barBuffer.buffer[i2], barBuffer.buffer[i2 + 3], barBuffer.buffer[i2], barBuffer.buffer[i2 + 1], iBarDataSet.getGradientColor(i5).getStartColor(), iBarDataSet.getGradientColor(i5).getEndColor(), Shader.TileMode.MIRROR));
                }
                int i6 = i2 + 1;
                int i7 = i2 + 3;
                canvas2.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i6], barBuffer.buffer[i4], barBuffer.buffer[i7], this.mRenderPaint);
                if (z) {
                    canvas.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i6], barBuffer.buffer[i4], barBuffer.buffer[i7], this.mBarBorderPaint);
                }
            }
            i2 += 4;
            canvas2 = canvas;
        }
    }

    protected void prepareBarHighlight(float f2, float f3, float f4, float f5, Transformer transformer) {
        this.mBarRect.set(f2 - f5, f3, f2 + f5, f4);
        transformer.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        MPPointF mPPointF;
        float f2;
        Transformer transformer;
        int i;
        boolean z;
        int i2;
        float[] fArr;
        int i3;
        float f3;
        int i4;
        float f4;
        float f5;
        BarEntry barEntry;
        float f6;
        float f7;
        boolean z2;
        int i5;
        ValueFormatter valueFormatter;
        List list2;
        MPPointF mPPointF2;
        BarEntry barEntry2;
        BarChartRenderer barChartRenderer = this;
        if (barChartRenderer.isDrawingValuesAllowed(barChartRenderer.mChart)) {
            List dataSets = barChartRenderer.mChart.getBarData().getDataSets();
            float fConvertDpToPixel = Utils.convertDpToPixel(4.5f);
            boolean zIsDrawValueAboveBarEnabled = barChartRenderer.mChart.isDrawValueAboveBarEnabled();
            int i6 = 0;
            while (i6 < barChartRenderer.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i6);
                if (barChartRenderer.shouldDrawValues(iBarDataSet)) {
                    barChartRenderer.applyValueTextStyle(iBarDataSet);
                    boolean zIsInverted = barChartRenderer.mChart.isInverted(iBarDataSet.getAxisDependency());
                    float fCalcTextHeight = Utils.calcTextHeight(barChartRenderer.mValuePaint, "8");
                    float f8 = zIsDrawValueAboveBarEnabled ? -fConvertDpToPixel : fCalcTextHeight + fConvertDpToPixel;
                    float f9 = zIsDrawValueAboveBarEnabled ? fCalcTextHeight + fConvertDpToPixel : -fConvertDpToPixel;
                    if (zIsInverted) {
                        f8 = (-f8) - fCalcTextHeight;
                        f9 = (-f9) - fCalcTextHeight;
                    }
                    float f10 = f8;
                    float f11 = f9;
                    BarBuffer barBuffer = barChartRenderer.mBarBuffers[i6];
                    float phaseY = barChartRenderer.mAnimator.getPhaseY();
                    ValueFormatter valueFormatter2 = iBarDataSet.getValueFormatter();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.x = Utils.convertDpToPixel(mPPointF3.x);
                    mPPointF3.y = Utils.convertDpToPixel(mPPointF3.y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        mPPointF = mPPointF3;
                        Transformer transformer2 = barChartRenderer.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i7 = 0;
                        int length = 0;
                        while (i7 < iBarDataSet.getEntryCount() * barChartRenderer.mAnimator.getPhaseX()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.getEntryForIndex(i7);
                            float[] yVals = barEntry3.getYVals();
                            Transformer transformer3 = transformer2;
                            float f12 = (barBuffer.buffer[length] + barBuffer.buffer[length + 2]) / 2.0f;
                            int valueTextColor = iBarDataSet.getValueTextColor(i7);
                            if (yVals == null) {
                                if (!barChartRenderer.mViewPortHandler.isInBoundsRight(f12)) {
                                    break;
                                }
                                i = i7;
                                int i8 = length + 1;
                                if (barChartRenderer.mViewPortHandler.isInBoundsY(barBuffer.buffer[i8]) && barChartRenderer.mViewPortHandler.isInBoundsLeft(f12)) {
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        String barLabel = valueFormatter2.getBarLabel(barEntry3);
                                        float f13 = barBuffer.buffer[i8] + (barEntry3.getY() >= 0.0f ? f10 : f11);
                                        barEntry = barEntry3;
                                        f6 = f12;
                                        f2 = fConvertDpToPixel;
                                        transformer = transformer3;
                                        z = zIsDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        barChartRenderer.drawValue(canvas, barLabel, f6, f13, valueTextColor);
                                    } else {
                                        f2 = fConvertDpToPixel;
                                        transformer = transformer3;
                                        barEntry = barEntry3;
                                        f6 = f12;
                                        z = zIsDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() == null || !iBarDataSet.isDrawIconsEnabled()) {
                                        i2 = i6;
                                    } else {
                                        Drawable icon = barEntry.getIcon();
                                        float f14 = barBuffer.buffer[i8] + (barEntry.getY() >= 0.0f ? f10 : f11);
                                        i2 = i6;
                                        Utils.drawImage(canvas, icon, (int) (f6 + mPPointF.x), (int) (f14 + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                } else {
                                    z = zIsDrawValueAboveBarEnabled;
                                    i2 = i6;
                                    transformer2 = transformer3;
                                    barChartRenderer = barChartRenderer;
                                    fConvertDpToPixel = fConvertDpToPixel;
                                    i7 = i;
                                    i6 = i2;
                                    zIsDrawValueAboveBarEnabled = z;
                                }
                            } else {
                                f2 = fConvertDpToPixel;
                                transformer = transformer3;
                                i = i7;
                                BarEntry barEntry4 = barEntry3;
                                float f15 = f12;
                                z = zIsDrawValueAboveBarEnabled;
                                i2 = i6;
                                BarChartRenderer barChartRenderer2 = barChartRenderer;
                                int i9 = valueTextColor;
                                fArr = yVals;
                                int length2 = fArr.length * 2;
                                float[] fArr2 = new float[length2];
                                float f16 = -barEntry4.getNegativeSum();
                                float f17 = 0.0f;
                                int i10 = 0;
                                int i11 = 0;
                                while (i10 < length2) {
                                    float f18 = fArr[i11];
                                    if (f18 == 0.0f && (f17 == 0.0f || f16 == 0.0f)) {
                                        f5 = f16;
                                        f16 = f18;
                                    } else if (f18 >= 0.0f) {
                                        f17 += f18;
                                        f5 = f16;
                                        f16 = f17;
                                    } else {
                                        f5 = f16 - f18;
                                    }
                                    fArr2[i10 + 1] = f16 * phaseY;
                                    i10 += 2;
                                    i11++;
                                    f16 = f5;
                                }
                                transformer.pointValuesToPixel(fArr2);
                                int i12 = 0;
                                while (i12 < length2) {
                                    float f19 = fArr[i12 / 2];
                                    int i13 = length2;
                                    float f20 = fArr2[i12 + 1] + (((f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) == 0 && (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1)) == 0 && (f17 > 0.0f ? 1 : (f17 == 0.0f ? 0 : -1)) > 0) || (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) < 0 ? f11 : f10);
                                    float[] fArr3 = fArr2;
                                    if (!barChartRenderer2.mViewPortHandler.isInBoundsRight(f15)) {
                                        break;
                                    }
                                    if (barChartRenderer2.mViewPortHandler.isInBoundsY(f20) && barChartRenderer2.mViewPortHandler.isInBoundsLeft(f15)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            BarEntry barEntry5 = barEntry4;
                                            String barStackedLabel = valueFormatter2.getBarStackedLabel(f19, barEntry5);
                                            f4 = f20;
                                            BarChartRenderer barChartRenderer3 = barChartRenderer2;
                                            i3 = i12;
                                            barEntry4 = barEntry5;
                                            barChartRenderer3.drawValue(canvas, barStackedLabel, f15, f4, i9);
                                        } else {
                                            f4 = f20;
                                            i3 = i12;
                                        }
                                        f3 = f15;
                                        i4 = i9;
                                        if (barEntry4.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry4.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f3 + mPPointF.x), (int) (mPPointF.y + f4), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i3 = i12;
                                        f3 = f15;
                                        i4 = i9;
                                    }
                                    i12 = i3 + 2;
                                    barChartRenderer2 = this;
                                    fArr2 = fArr3;
                                    f15 = f3;
                                    length2 = i13;
                                    i9 = i4;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i7 = i + 1;
                            barChartRenderer = this;
                            transformer2 = transformer;
                            fConvertDpToPixel = f2;
                            i6 = i2;
                            zIsDrawValueAboveBarEnabled = z;
                        }
                    } else {
                        int i14 = 0;
                        while (i14 < barBuffer.buffer.length * barChartRenderer.mAnimator.getPhaseX()) {
                            float f21 = (barBuffer.buffer[i14] + barBuffer.buffer[i14 + 2]) / 2.0f;
                            if (!barChartRenderer.mViewPortHandler.isInBoundsRight(f21)) {
                                break;
                            }
                            int i15 = i14 + 1;
                            if (barChartRenderer.mViewPortHandler.isInBoundsY(barBuffer.buffer[i15]) && barChartRenderer.mViewPortHandler.isInBoundsLeft(f21)) {
                                int i16 = i14 / 4;
                                BarEntry barEntry6 = (BarEntry) iBarDataSet.getEntryForIndex(i16);
                                float y = barEntry6.getY();
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    MPPointF mPPointF4 = mPPointF3;
                                    String barLabel2 = valueFormatter2.getBarLabel(barEntry6);
                                    float[] fArr4 = barBuffer.buffer;
                                    float f22 = y >= 0.0f ? fArr4[i15] + f10 : fArr4[i14 + 3] + f11;
                                    int valueTextColor2 = iBarDataSet.getValueTextColor(i16);
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF4;
                                    barEntry2 = barEntry6;
                                    float f23 = f22;
                                    valueFormatter = valueFormatter2;
                                    barChartRenderer.drawValue(canvas, barLabel2, f21, f23, valueTextColor2);
                                } else {
                                    valueFormatter = valueFormatter2;
                                    barEntry2 = barEntry6;
                                    list2 = dataSets;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry2.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry2.getIcon();
                                    Utils.drawImage(canvas, icon3, (int) (f21 + mPPointF2.x), (int) ((y >= 0.0f ? barBuffer.buffer[i15] + f10 : barBuffer.buffer[i14 + 3] + f11) + mPPointF2.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                valueFormatter = valueFormatter2;
                                list2 = dataSets;
                                mPPointF2 = mPPointF3;
                            }
                            i14 += 4;
                            mPPointF3 = mPPointF2;
                            valueFormatter2 = valueFormatter;
                            dataSets = list2;
                        }
                        list = dataSets;
                        mPPointF = mPPointF3;
                    }
                    f7 = fConvertDpToPixel;
                    z2 = zIsDrawValueAboveBarEnabled;
                    i5 = i6;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f7 = fConvertDpToPixel;
                    z2 = zIsDrawValueAboveBarEnabled;
                    i5 = i6;
                }
                i6 = i5 + 1;
                barChartRenderer = this;
                fConvertDpToPixel = f7;
                dataSets = list;
                zIsDrawValueAboveBarEnabled = z2;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float y;
        float f2;
        BarData barData = this.mChart.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iBarDataSet != null && iBarDataSet.isHighlightEnabled()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(barEntry, iBarDataSet)) {
                    Transformer transformer = this.mChart.getTransformer(iBarDataSet.getAxisDependency());
                    this.mHighlightPaint.setColor(iBarDataSet.getHighLightColor());
                    this.mHighlightPaint.setAlpha(iBarDataSet.getHighLightAlpha());
                    if (highlight.getStackIndex() >= 0 && barEntry.isStacked()) {
                        if (this.mChart.isHighlightFullBarEnabled()) {
                            y = barEntry.getPositiveSum();
                            f2 = -barEntry.getNegativeSum();
                        } else {
                            Range range = barEntry.getRanges()[highlight.getStackIndex()];
                            float f3 = range.from;
                            f2 = range.to;
                            y = f3;
                        }
                    } else {
                        y = barEntry.getY();
                        f2 = 0.0f;
                    }
                    prepareBarHighlight(barEntry.getX(), y, f2, barData.getBarWidth() / 2.0f, transformer);
                    setHighlightDrawPos(highlight, this.mBarRect);
                    canvas.drawRect(this.mBarRect, this.mHighlightPaint);
                }
            }
        }
    }

    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerX(), rectF.top);
    }
}
