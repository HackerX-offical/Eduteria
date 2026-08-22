package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {
    private float[] _hsvBuffer;
    protected BubbleDataProvider mChart;
    private float[] pointBuffer;
    private float[] sizeBuffer;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.sizeBuffer = new float[4];
        this.pointBuffer = new float[2];
        this._hsvBuffer = new float[3];
        this.mChart = bubbleDataProvider;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setStrokeWidth(Utils.convertDpToPixel(1.5f));
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        for (T t : this.mChart.getBubbleData().getDataSets()) {
            if (t.isVisible()) {
                drawDataSet(canvas, t);
            }
        }
    }

    protected float getShapeSize(float f2, float f3, float f4, boolean z) {
        if (z) {
            f2 = f3 == 0.0f ? 1.0f : (float) Math.sqrt(f2 / f3);
        }
        return f4 * f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas canvas, IBubbleDataSet iBubbleDataSet) {
        if (iBubbleDataSet.getEntryCount() < 1) {
            return;
        }
        Transformer transformer = this.mChart.getTransformer(iBubbleDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        this.mXBounds.set(this.mChart, iBubbleDataSet);
        float[] fArr = this.sizeBuffer;
        fArr[0] = 0.0f;
        fArr[2] = 1.0f;
        transformer.pointValuesToPixel(fArr);
        boolean zIsNormalizeSizeEnabled = iBubbleDataSet.isNormalizeSizeEnabled();
        float[] fArr2 = this.sizeBuffer;
        float fMin = Math.min(Math.abs(this.mViewPortHandler.contentBottom() - this.mViewPortHandler.contentTop()), Math.abs(fArr2[2] - fArr2[0]));
        for (int i = this.mXBounds.min; i <= this.mXBounds.range + this.mXBounds.min; i++) {
            BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.getEntryForIndex(i);
            this.pointBuffer[0] = bubbleEntry.getX();
            this.pointBuffer[1] = bubbleEntry.getY() * phaseY;
            transformer.pointValuesToPixel(this.pointBuffer);
            float shapeSize = getShapeSize(bubbleEntry.getSize(), iBubbleDataSet.getMaxSize(), fMin, zIsNormalizeSizeEnabled) / 2.0f;
            if (this.mViewPortHandler.isInBoundsTop(this.pointBuffer[1] + shapeSize) && this.mViewPortHandler.isInBoundsBottom(this.pointBuffer[1] - shapeSize) && this.mViewPortHandler.isInBoundsLeft(this.pointBuffer[0] + shapeSize)) {
                if (!this.mViewPortHandler.isInBoundsRight(this.pointBuffer[0] - shapeSize)) {
                    return;
                }
                this.mRenderPaint.setColor(iBubbleDataSet.getColor((int) bubbleEntry.getX()));
                float[] fArr3 = this.pointBuffer;
                canvas.drawCircle(fArr3[0], fArr3[1], shapeSize, this.mRenderPaint);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas canvas) {
        BubbleEntry bubbleEntry;
        float f2;
        BubbleChartRenderer bubbleChartRenderer = this;
        BubbleData bubbleData = bubbleChartRenderer.mChart.getBubbleData();
        if (bubbleData != null && bubbleChartRenderer.isDrawingValuesAllowed(bubbleChartRenderer.mChart)) {
            List<T> dataSets = bubbleData.getDataSets();
            float fCalcTextHeight = Utils.calcTextHeight(bubbleChartRenderer.mValuePaint, "1");
            int i = 0;
            while (i < dataSets.size()) {
                IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) dataSets.get(i);
                if (bubbleChartRenderer.shouldDrawValues(iBubbleDataSet) && iBubbleDataSet.getEntryCount() >= 1) {
                    bubbleChartRenderer.applyValueTextStyle(iBubbleDataSet);
                    float fMax = Math.max(0.0f, Math.min(1.0f, bubbleChartRenderer.mAnimator.getPhaseX()));
                    float phaseY = bubbleChartRenderer.mAnimator.getPhaseY();
                    bubbleChartRenderer.mXBounds.set(bubbleChartRenderer.mChart, iBubbleDataSet);
                    float[] fArrGenerateTransformedValuesBubble = bubbleChartRenderer.mChart.getTransformer(iBubbleDataSet.getAxisDependency()).generateTransformedValuesBubble(iBubbleDataSet, phaseY, bubbleChartRenderer.mXBounds.min, bubbleChartRenderer.mXBounds.max);
                    float f3 = fMax == 1.0f ? phaseY : fMax;
                    ValueFormatter valueFormatter = iBubbleDataSet.getValueFormatter();
                    MPPointF mPPointF = MPPointF.getInstance(iBubbleDataSet.getIconsOffset());
                    mPPointF.x = Utils.convertDpToPixel(mPPointF.x);
                    mPPointF.y = Utils.convertDpToPixel(mPPointF.y);
                    int i2 = 0;
                    while (i2 < fArrGenerateTransformedValuesBubble.length) {
                        int i3 = i2 / 2;
                        int valueTextColor = iBubbleDataSet.getValueTextColor(bubbleChartRenderer.mXBounds.min + i3);
                        int iArgb = Color.argb(Math.round(255.0f * f3), Color.red(valueTextColor), Color.green(valueTextColor), Color.blue(valueTextColor));
                        float f4 = fArrGenerateTransformedValuesBubble[i2];
                        float f5 = fArrGenerateTransformedValuesBubble[i2 + 1];
                        if (!bubbleChartRenderer.mViewPortHandler.isInBoundsRight(f4)) {
                            break;
                        }
                        if (bubbleChartRenderer.mViewPortHandler.isInBoundsLeft(f4) && bubbleChartRenderer.mViewPortHandler.isInBoundsY(f5)) {
                            BubbleEntry bubbleEntry2 = (BubbleEntry) iBubbleDataSet.getEntryForIndex(i3 + bubbleChartRenderer.mXBounds.min);
                            if (iBubbleDataSet.isDrawValuesEnabled()) {
                                f2 = f5;
                                bubbleEntry = bubbleEntry2;
                                bubbleChartRenderer.drawValue(canvas, valueFormatter.getBubbleLabel(bubbleEntry2), f4, f5 + (0.5f * fCalcTextHeight), iArgb);
                            } else {
                                bubbleEntry = bubbleEntry2;
                                f2 = f5;
                            }
                            if (bubbleEntry.getIcon() != null && iBubbleDataSet.isDrawIconsEnabled()) {
                                Drawable icon = bubbleEntry.getIcon();
                                Utils.drawImage(canvas, icon, (int) (f4 + mPPointF.x), (int) (f2 + mPPointF.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        }
                        i2 += 2;
                        bubbleChartRenderer = this;
                    }
                    MPPointF.recycleInstance(mPPointF);
                }
                i++;
                bubbleChartRenderer = this;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013a  */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawHighlighted(android.graphics.Canvas r18, com.github.mikephil.charting.highlight.Highlight[] r19) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.BubbleChartRenderer.drawHighlighted(android.graphics.Canvas, com.github.mikephil.charting.highlight.Highlight[]):void");
    }
}
