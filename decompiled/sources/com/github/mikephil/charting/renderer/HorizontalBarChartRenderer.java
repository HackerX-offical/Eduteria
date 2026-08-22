package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.mBarShadowRectBuffer = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData barData = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[barData.getDataSetCount()];
        for (int i = 0; i < this.mBarBuffers.length; i++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.getDataSetByIndex(i);
            this.mBarBuffers[i] = new HorizontalBarBuffer(iBarDataSet.getEntryCount() * 4 * (iBarDataSet.isStacked() ? iBarDataSet.getStackSize() : 1), barData.getDataSetCount(), iBarDataSet.isStacked());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
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
                this.mBarShadowRectBuffer.top = x - barWidth;
                this.mBarShadowRectBuffer.bottom = x + barWidth;
                transformer.rectValueToPixel(this.mBarShadowRectBuffer);
                if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom)) {
                    if (!this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top)) {
                        break;
                    }
                    this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
                    this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
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
            int i4 = i2 + 3;
            if (!this.mViewPortHandler.isInBoundsTop(barBuffer.buffer[i4])) {
                return;
            }
            int i5 = i2 + 1;
            if (this.mViewPortHandler.isInBoundsBottom(barBuffer.buffer[i5])) {
                if (!z2) {
                    this.mRenderPaint.setColor(iBarDataSet.getColor(i2 / 4));
                }
                int i6 = i2 + 2;
                canvas2.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i5], barBuffer.buffer[i6], barBuffer.buffer[i4], this.mRenderPaint);
                if (z) {
                    canvas.drawRect(barBuffer.buffer[i2], barBuffer.buffer[i5], barBuffer.buffer[i6], barBuffer.buffer[i4], this.mBarBorderPaint);
                }
            }
            i2 += 4;
            canvas2 = canvas;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        List list;
        float f2;
        MPPointF mPPointF;
        boolean z;
        int i;
        float[] fArr;
        float f3;
        int i2;
        int i3;
        float f4;
        BarEntry barEntry;
        boolean z2;
        int i4;
        int i5;
        List list2;
        float f5;
        BarBuffer barBuffer;
        MPPointF mPPointF2;
        HorizontalBarChartRenderer horizontalBarChartRenderer = this;
        if (horizontalBarChartRenderer.isDrawingValuesAllowed(horizontalBarChartRenderer.mChart)) {
            List dataSets = horizontalBarChartRenderer.mChart.getBarData().getDataSets();
            float fConvertDpToPixel = Utils.convertDpToPixel(5.0f);
            boolean zIsDrawValueAboveBarEnabled = horizontalBarChartRenderer.mChart.isDrawValueAboveBarEnabled();
            int i6 = 0;
            while (i6 < horizontalBarChartRenderer.mChart.getBarData().getDataSetCount()) {
                IBarDataSet iBarDataSet = (IBarDataSet) dataSets.get(i6);
                if (horizontalBarChartRenderer.shouldDrawValues(iBarDataSet)) {
                    boolean zIsInverted = horizontalBarChartRenderer.mChart.isInverted(iBarDataSet.getAxisDependency());
                    horizontalBarChartRenderer.applyValueTextStyle(iBarDataSet);
                    float f6 = 2.0f;
                    float fCalcTextHeight = Utils.calcTextHeight(horizontalBarChartRenderer.mValuePaint, "10") / 2.0f;
                    ValueFormatter valueFormatter = iBarDataSet.getValueFormatter();
                    BarBuffer barBuffer2 = horizontalBarChartRenderer.mBarBuffers[i6];
                    float phaseY = horizontalBarChartRenderer.mAnimator.getPhaseY();
                    MPPointF mPPointF3 = MPPointF.getInstance(iBarDataSet.getIconsOffset());
                    mPPointF3.x = Utils.convertDpToPixel(mPPointF3.x);
                    mPPointF3.y = Utils.convertDpToPixel(mPPointF3.y);
                    if (iBarDataSet.isStacked()) {
                        list = dataSets;
                        f2 = fConvertDpToPixel;
                        mPPointF = mPPointF3;
                        Transformer transformer = horizontalBarChartRenderer.mChart.getTransformer(iBarDataSet.getAxisDependency());
                        int i7 = 0;
                        int length = 0;
                        while (i7 < iBarDataSet.getEntryCount() * horizontalBarChartRenderer.mAnimator.getPhaseX()) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.getEntryForIndex(i7);
                            int valueTextColor = iBarDataSet.getValueTextColor(i7);
                            float[] yVals = barEntry2.getYVals();
                            if (yVals == null) {
                                int i8 = length + 1;
                                if (!horizontalBarChartRenderer.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i8])) {
                                    break;
                                }
                                if (horizontalBarChartRenderer.mViewPortHandler.isInBoundsX(barBuffer2.buffer[length]) && horizontalBarChartRenderer.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i8])) {
                                    String barLabel = valueFormatter.getBarLabel(barEntry2);
                                    float fCalcTextWidth = Utils.calcTextWidth(horizontalBarChartRenderer.mValuePaint, barLabel);
                                    float f7 = zIsDrawValueAboveBarEnabled ? f2 : -(fCalcTextWidth + f2);
                                    float f8 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth + f2) : f2;
                                    if (zIsInverted) {
                                        f7 = (-f7) - fCalcTextWidth;
                                        f8 = (-f8) - fCalcTextWidth;
                                    }
                                    float f9 = f7;
                                    float f10 = f8;
                                    if (iBarDataSet.isDrawValuesEnabled()) {
                                        barEntry = barEntry2;
                                        z = zIsDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                        drawValue(canvas, barLabel, barBuffer2.buffer[length + 2] + (barEntry2.getY() >= 0.0f ? f9 : f10), barBuffer2.buffer[i8] + fCalcTextHeight, valueTextColor);
                                    } else {
                                        barEntry = barEntry2;
                                        z = zIsDrawValueAboveBarEnabled;
                                        fArr = yVals;
                                    }
                                    if (barEntry.getIcon() == null || !iBarDataSet.isDrawIconsEnabled()) {
                                        i = i6;
                                    } else {
                                        Drawable icon = barEntry.getIcon();
                                        float f11 = barBuffer2.buffer[length + 2];
                                        if (barEntry.getY() < 0.0f) {
                                            f9 = f10;
                                        }
                                        float f12 = barBuffer2.buffer[i8];
                                        i = i6;
                                        Utils.drawImage(canvas, icon, (int) (f11 + f9 + mPPointF.x), (int) (f12 + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                BarEntry barEntry3 = barEntry2;
                                z = zIsDrawValueAboveBarEnabled;
                                i = i6;
                                HorizontalBarChartRenderer horizontalBarChartRenderer2 = horizontalBarChartRenderer;
                                fArr = yVals;
                                int length2 = fArr.length * 2;
                                float[] fArr2 = new float[length2];
                                float f13 = -barEntry3.getNegativeSum();
                                float f14 = 0.0f;
                                int i9 = 0;
                                int i10 = 0;
                                while (i9 < length2) {
                                    float f15 = fArr[i10];
                                    if (f15 == 0.0f && (f14 == 0.0f || f13 == 0.0f)) {
                                        float f16 = f13;
                                        f13 = f15;
                                        f4 = f16;
                                    } else if (f15 >= 0.0f) {
                                        f14 += f15;
                                        f4 = f13;
                                        f13 = f14;
                                    } else {
                                        f4 = f13 - f15;
                                    }
                                    fArr2[i9] = f13 * phaseY;
                                    i9 += 2;
                                    i10++;
                                    f13 = f4;
                                }
                                transformer.pointValuesToPixel(fArr2);
                                int i11 = 0;
                                while (i11 < length2) {
                                    float f17 = fArr[i11 / 2];
                                    BarEntry barEntry4 = barEntry3;
                                    int i12 = i11;
                                    String barStackedLabel = valueFormatter.getBarStackedLabel(f17, barEntry4);
                                    int i13 = length2;
                                    float fCalcTextWidth2 = Utils.calcTextWidth(horizontalBarChartRenderer2.mValuePaint, barStackedLabel);
                                    float f18 = z ? f2 : -(fCalcTextWidth2 + f2);
                                    float[] fArr3 = fArr2;
                                    float f19 = z ? -(fCalcTextWidth2 + f2) : f2;
                                    if (zIsInverted) {
                                        f18 = (-f18) - fCalcTextWidth2;
                                        f19 = (-f19) - fCalcTextWidth2;
                                    }
                                    boolean z3 = (f17 == 0.0f && f13 == 0.0f && f14 > 0.0f) || f17 < 0.0f;
                                    float f20 = fArr3[i12];
                                    if (z3) {
                                        f18 = f19;
                                    }
                                    float f21 = f20 + f18;
                                    float f22 = (barBuffer2.buffer[length + 1] + barBuffer2.buffer[length + 3]) / 2.0f;
                                    if (!horizontalBarChartRenderer2.mViewPortHandler.isInBoundsTop(f22)) {
                                        break;
                                    }
                                    if (horizontalBarChartRenderer2.mViewPortHandler.isInBoundsX(f21) && horizontalBarChartRenderer2.mViewPortHandler.isInBoundsBottom(f22)) {
                                        if (iBarDataSet.isDrawValuesEnabled()) {
                                            float f23 = f22 + fCalcTextHeight;
                                            f3 = f22;
                                            HorizontalBarChartRenderer horizontalBarChartRenderer3 = horizontalBarChartRenderer2;
                                            i2 = i12;
                                            barEntry3 = barEntry4;
                                            horizontalBarChartRenderer3.drawValue(canvas, barStackedLabel, f21, f23, valueTextColor);
                                        } else {
                                            f3 = f22;
                                            i2 = i12;
                                            barEntry3 = barEntry4;
                                        }
                                        i3 = valueTextColor;
                                        if (barEntry3.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                            Drawable icon2 = barEntry3.getIcon();
                                            Utils.drawImage(canvas, icon2, (int) (f21 + mPPointF.x), (int) (f3 + mPPointF.y), icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i3 = valueTextColor;
                                        i2 = i12;
                                        barEntry3 = barEntry4;
                                    }
                                    i11 = i2 + 2;
                                    horizontalBarChartRenderer2 = this;
                                    length2 = i13;
                                    fArr2 = fArr3;
                                    valueTextColor = i3;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i7++;
                            horizontalBarChartRenderer = this;
                            i6 = i;
                            zIsDrawValueAboveBarEnabled = z;
                        }
                    } else {
                        int i14 = 0;
                        while (i14 < barBuffer2.buffer.length * horizontalBarChartRenderer.mAnimator.getPhaseX()) {
                            int i15 = i14 + 1;
                            float f24 = (barBuffer2.buffer[i15] + barBuffer2.buffer[i14 + 3]) / f6;
                            float f25 = f6;
                            if (!horizontalBarChartRenderer.mViewPortHandler.isInBoundsTop(barBuffer2.buffer[i15])) {
                                break;
                            }
                            if (horizontalBarChartRenderer.mViewPortHandler.isInBoundsX(barBuffer2.buffer[i14]) && horizontalBarChartRenderer.mViewPortHandler.isInBoundsBottom(barBuffer2.buffer[i15])) {
                                BarEntry barEntry5 = (BarEntry) iBarDataSet.getEntryForIndex(i14 / 4);
                                float y = barEntry5.getY();
                                MPPointF mPPointF4 = mPPointF3;
                                String barLabel2 = valueFormatter.getBarLabel(barEntry5);
                                float fCalcTextWidth3 = Utils.calcTextWidth(horizontalBarChartRenderer.mValuePaint, barLabel2);
                                float f26 = zIsDrawValueAboveBarEnabled ? fConvertDpToPixel : -(fCalcTextWidth3 + fConvertDpToPixel);
                                float f27 = zIsDrawValueAboveBarEnabled ? -(fCalcTextWidth3 + fConvertDpToPixel) : fConvertDpToPixel;
                                if (zIsInverted) {
                                    f26 = (-f26) - fCalcTextWidth3;
                                    f27 = (-f27) - fCalcTextWidth3;
                                }
                                float f28 = f26;
                                float f29 = f27;
                                if (iBarDataSet.isDrawValuesEnabled()) {
                                    float f30 = fConvertDpToPixel;
                                    mPPointF2 = mPPointF4;
                                    f5 = f30;
                                    i5 = i14;
                                    list2 = dataSets;
                                    barBuffer = barBuffer2;
                                    horizontalBarChartRenderer = this;
                                    horizontalBarChartRenderer.drawValue(canvas, barLabel2, barBuffer2.buffer[i14 + 2] + (y >= 0.0f ? f28 : f29), f24 + fCalcTextHeight, iBarDataSet.getValueTextColor(i14 / 2));
                                } else {
                                    horizontalBarChartRenderer = this;
                                    i5 = i14;
                                    list2 = dataSets;
                                    f5 = fConvertDpToPixel;
                                    barBuffer = barBuffer2;
                                    mPPointF2 = mPPointF4;
                                }
                                if (barEntry5.getIcon() != null && iBarDataSet.isDrawIconsEnabled()) {
                                    Drawable icon3 = barEntry5.getIcon();
                                    float f31 = barBuffer.buffer[i5 + 2];
                                    if (y < 0.0f) {
                                        f28 = f29;
                                    }
                                    Utils.drawImage(canvas, icon3, (int) (f31 + f28 + mPPointF2.x), (int) (f24 + mPPointF2.y), icon3.getIntrinsicWidth(), icon3.getIntrinsicHeight());
                                }
                            } else {
                                i5 = i14;
                                list2 = dataSets;
                                f5 = fConvertDpToPixel;
                                barBuffer = barBuffer2;
                                mPPointF2 = mPPointF3;
                            }
                            i14 = i5 + 4;
                            barBuffer2 = barBuffer;
                            mPPointF3 = mPPointF2;
                            f6 = f25;
                            fConvertDpToPixel = f5;
                            dataSets = list2;
                        }
                        list = dataSets;
                        f2 = fConvertDpToPixel;
                        mPPointF = mPPointF3;
                    }
                    z2 = zIsDrawValueAboveBarEnabled;
                    i4 = i6;
                    MPPointF.recycleInstance(mPPointF);
                } else {
                    list = dataSets;
                    f2 = fConvertDpToPixel;
                    z2 = zIsDrawValueAboveBarEnabled;
                    i4 = i6;
                }
                i6 = i4 + 1;
                horizontalBarChartRenderer = this;
                fConvertDpToPixel = f2;
                dataSets = list;
                zIsDrawValueAboveBarEnabled = z2;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float f2, float f3, float f4, float f5, Transformer transformer) {
        this.mBarRect.set(f3, f2 - f5, f4, f2 + f5);
        transformer.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void setHighlightDrawPos(Highlight highlight, RectF rectF) {
        highlight.setDraw(rectF.centerY(), rectF.right);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    protected boolean isDrawingValuesAllowed(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().getEntryCount()) < ((float) chartInterface.getMaxVisibleCount()) * this.mViewPortHandler.getScaleY();
    }
}
