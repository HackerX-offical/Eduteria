package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer;
    protected RectF mDrawHighlightedRectF;
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath;
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer;
    private Path mPathBuffer;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mPathBuffer = new Path();
        this.mInnerRectBuffer = new RectF();
        this.mHoleCirclePath = new Path();
        this.mDrawCenterTextPathBuffer = new Path();
        this.mDrawHighlightedRectF = new RectF();
        this.mChart = pieChart;
        Paint paint = new Paint(1);
        this.mHolePaint = paint;
        paint.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.mTransparentCirclePaint = paint2;
        paint2.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.mCenterTextPaint = textPaint;
        textPaint.setColor(-16777216);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.mEntryLabelsPaint = paint3;
        paint3.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint paint4 = new Paint(1);
        this.mValueLinePaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != chartWidth || bitmapCreateBitmap.getHeight() != chartHeight) {
            if (chartWidth <= 0 || chartHeight <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(chartWidth, chartHeight, Bitmap.Config.ARGB_4444);
            this.mDrawBitmap = new WeakReference<>(bitmapCreateBitmap);
            this.mBitmapCanvas = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.mChart.getData()).getDataSets()) {
            if (iPieDataSet.isVisible() && iPieDataSet.getEntryCount() > 0) {
                drawDataSet(canvas, iPieDataSet);
            }
        }
    }

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF mPPointF, float f2, float f3, float f4, float f5, float f6, float f7) {
        double d2 = (f6 + f7) * 0.017453292f;
        float fCos = mPPointF.x + (((float) Math.cos(d2)) * f2);
        float fSin = mPPointF.y + (((float) Math.sin(d2)) * f2);
        double d3 = (f6 + (f7 / 2.0f)) * 0.017453292f;
        return (float) (((double) (f2 - ((float) ((Math.sqrt(Math.pow(fCos - f4, 2.0d) + Math.pow(fSin - f5, 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f3)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((mPPointF.x + (((float) Math.cos(d3)) * f2)) - ((fCos + f4) / 2.0f), 2.0d) + Math.pow((mPPointF.y + (((float) Math.sin(d3)) * f2)) - ((fSin + f5) / 2.0f), 2.0d)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected float getSliceSpace(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.isAutomaticallyDisableSliceSpacingEnabled()) {
            return iPieDataSet.getSliceSpace();
        }
        if (iPieDataSet.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension() > (iPieDataSet.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.getSliceSpace();
    }

    protected void drawDataSet(Canvas canvas, IPieDataSet iPieDataSet) {
        float f2;
        int i;
        int i2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i3;
        RectF rectF;
        float f7;
        float f8;
        int i4;
        float f9;
        float f10;
        int i5;
        int i6;
        float fMax;
        PieChartRenderer pieChartRenderer = this;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = pieChartRenderer.mChart.getRotationAngle();
        float phaseX = pieChartRenderer.mAnimator.getPhaseX();
        float phaseY = pieChartRenderer.mAnimator.getPhaseY();
        RectF circleBox = pieChartRenderer.mChart.getCircleBox();
        int entryCount = iPieDataSet2.getEntryCount();
        float[] drawAngles = pieChartRenderer.mChart.getDrawAngles();
        MPPointF centerCircleBox = pieChartRenderer.mChart.getCenterCircleBox();
        float radius = pieChartRenderer.mChart.getRadius();
        boolean z = pieChartRenderer.mChart.isDrawHoleEnabled() && !pieChartRenderer.mChart.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (pieChartRenderer.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((pieChartRenderer.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF2 = new RectF();
        boolean z2 = z && pieChartRenderer.mChart.isDrawRoundedSlicesEnabled();
        int i7 = 0;
        for (int i8 = 0; i8 < entryCount; i8++) {
            if (Math.abs(iPieDataSet2.getEntryForIndex(i8).getY()) > Utils.FLOAT_EPSILON) {
                i7++;
            }
        }
        float sliceSpace = i7 <= 1 ? 0.0f : pieChartRenderer.getSliceSpace(iPieDataSet2);
        float f11 = 0.0f;
        int i9 = 0;
        while (i9 < entryCount) {
            float f12 = drawAngles[i9];
            if (Math.abs(iPieDataSet2.getEntryForIndex(i9).getY()) > Utils.FLOAT_EPSILON && (!pieChartRenderer.mChart.needsHighlight(i9) || z2)) {
                boolean z3 = sliceSpace > 0.0f && f12 <= 180.0f;
                f2 = holeRadius;
                pieChartRenderer.mRenderPaint.setColor(iPieDataSet2.getColor(i9));
                float f13 = i7 == 1 ? 0.0f : sliceSpace / (radius * 0.017453292f);
                float f14 = rotationAngle + ((f11 + (f13 / 2.0f)) * phaseY);
                float f15 = (f12 - f13) * phaseY;
                if (f15 < 0.0f) {
                    f15 = 0.0f;
                }
                i = i9;
                pieChartRenderer.mPathBuffer.reset();
                if (z2) {
                    float f16 = radius - holeRadius2;
                    i2 = i7;
                    double d2 = f14 * 0.017453292f;
                    float fCos = centerCircleBox.x + (((float) Math.cos(d2)) * f16);
                    float fSin = centerCircleBox.y + (f16 * ((float) Math.sin(d2)));
                    f3 = rotationAngle;
                    rectF2.set(fCos - holeRadius2, fSin - holeRadius2, fCos + holeRadius2, fSin + holeRadius2);
                } else {
                    i2 = i7;
                    f3 = rotationAngle;
                }
                double d3 = f14 * 0.017453292f;
                float fCos2 = (((float) Math.cos(d3)) * radius) + centerCircleBox.x;
                float fSin2 = centerCircleBox.y + (((float) Math.sin(d3)) * radius);
                int i10 = (f15 > 360.0f ? 1 : (f15 == 360.0f ? 0 : -1));
                if (i10 >= 0 && f15 % 360.0f <= Utils.FLOAT_EPSILON) {
                    f6 = 360.0f;
                    f4 = fCos2;
                    f5 = fSin2;
                    i3 = i10;
                    pieChartRenderer.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, radius, Path.Direction.CW);
                } else {
                    f4 = fCos2;
                    f5 = fSin2;
                    f6 = 360.0f;
                    i3 = i10;
                    if (z2) {
                        pieChartRenderer.mPathBuffer.arcTo(rectF2, f14 + 180.0f, -180.0f);
                    }
                    pieChartRenderer.mPathBuffer.arcTo(circleBox, f14, f15);
                }
                pieChartRenderer.mInnerRectBuffer.set(centerCircleBox.x - f2, centerCircleBox.y - f2, centerCircleBox.x + f2, centerCircleBox.y + f2);
                if (!z || (f2 <= 0.0f && !z3)) {
                    pieChartRenderer = this;
                    rectF = rectF2;
                    float f17 = f15;
                    f7 = phaseX;
                    f8 = phaseY;
                    i4 = i2;
                    float f18 = f4;
                    float f19 = f5;
                    if (f17 % f6 > Utils.FLOAT_EPSILON) {
                        if (z3) {
                            float fCalculateMinimumRadiusForSpacedSlice = pieChartRenderer.calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f12 * f8, f18, f19, f14, f17);
                            double d4 = (f14 + (f17 / 2.0f)) * 0.017453292f;
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d4)) * fCalculateMinimumRadiusForSpacedSlice), centerCircleBox.y + (fCalculateMinimumRadiusForSpacedSlice * ((float) Math.sin(d4))));
                        } else {
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.x, centerCircleBox.y);
                        }
                    }
                } else {
                    if (z3) {
                        rectF = rectF2;
                        f9 = f15;
                        f7 = phaseX;
                        f10 = f2;
                        i5 = i2;
                        i6 = 1;
                        pieChartRenderer = this;
                        float fCalculateMinimumRadiusForSpacedSlice2 = pieChartRenderer.calculateMinimumRadiusForSpacedSlice(centerCircleBox, radius, f12 * phaseY, f4, f5, f14, f9);
                        if (fCalculateMinimumRadiusForSpacedSlice2 < 0.0f) {
                            fCalculateMinimumRadiusForSpacedSlice2 = -fCalculateMinimumRadiusForSpacedSlice2;
                        }
                        fMax = Math.max(f10, fCalculateMinimumRadiusForSpacedSlice2);
                    } else {
                        pieChartRenderer = this;
                        rectF = rectF2;
                        f9 = f15;
                        f7 = phaseX;
                        f10 = f2;
                        i5 = i2;
                        i6 = 1;
                        fMax = f10;
                    }
                    float f20 = (i5 == i6 || fMax == 0.0f) ? 0.0f : sliceSpace / (fMax * 0.017453292f);
                    float f21 = f3 + ((f11 + (f20 / 2.0f)) * phaseY);
                    float f22 = (f12 - f20) * phaseY;
                    if (f22 < 0.0f) {
                        f22 = 0.0f;
                    }
                    float f23 = f21 + f22;
                    if (i3 >= 0 && f9 % f6 <= Utils.FLOAT_EPSILON) {
                        pieChartRenderer.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, fMax, Path.Direction.CCW);
                        f2 = f10;
                        f8 = phaseY;
                    } else {
                        if (z2) {
                            float f24 = radius - holeRadius2;
                            f8 = phaseY;
                            double d5 = f23 * 0.017453292f;
                            float fCos3 = centerCircleBox.x + (f24 * ((float) Math.cos(d5)));
                            float fSin3 = centerCircleBox.y + (((float) Math.sin(d5)) * f24);
                            rectF.set(fCos3 - holeRadius2, fSin3 - holeRadius2, fCos3 + holeRadius2, fSin3 + holeRadius2);
                            pieChartRenderer.mPathBuffer.arcTo(rectF, f23, 180.0f);
                            f2 = f10;
                        } else {
                            f8 = phaseY;
                            double d6 = f23 * 0.017453292f;
                            f2 = f10;
                            pieChartRenderer.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d6)) * fMax), centerCircleBox.y + (fMax * ((float) Math.sin(d6))));
                        }
                        pieChartRenderer.mPathBuffer.arcTo(pieChartRenderer.mInnerRectBuffer, f23, -f22);
                    }
                    i4 = i5;
                }
                pieChartRenderer.mPathBuffer.close();
                pieChartRenderer.mBitmapCanvas.drawPath(pieChartRenderer.mPathBuffer, pieChartRenderer.mRenderPaint);
                f11 += f12 * f7;
            } else {
                f11 += f12 * phaseX;
                f2 = holeRadius;
                i = i9;
                i4 = i7;
                f3 = rotationAngle;
                f7 = phaseX;
                f8 = phaseY;
                rectF = rectF2;
            }
            i9 = i + 1;
            i7 = i4;
            rectF2 = rectF;
            phaseX = f7;
            holeRadius = f2;
            phaseY = f8;
            rotationAngle = f3;
            iPieDataSet2 = iPieDataSet;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x007d A[PHI: r3
      0x007d: PHI (r3v5 float) = (r3v4 float), (r3v37 float), (r3v37 float) binds: [B:3:0x0051, B:5:0x005e, B:7:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawValues(android.graphics.Canvas r50) {
        /*
            Method dump skipped, instruction units count: 959
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.PieChartRenderer.drawValues(android.graphics.Canvas):void");
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas canvas, String str, float f2, float f3, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f2, f3, this.mValuePaint);
    }

    protected void drawEntryLabel(Canvas canvas, String str, float f2, float f3) {
        canvas.drawText(str, f2, f3, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas canvas) {
        drawHole(canvas);
        canvas.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, (Paint) null);
        drawCenterText(canvas);
    }

    protected void drawHole(Canvas canvas) {
        if (!this.mChart.isDrawHoleEnabled() || this.mBitmapCanvas == null) {
            return;
        }
        float radius = this.mChart.getRadius();
        float holeRadius = (this.mChart.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        if (Color.alpha(this.mHolePaint.getColor()) > 0) {
            this.mBitmapCanvas.drawCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, this.mHolePaint);
        }
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0 && this.mChart.getTransparentCircleRadius() > this.mChart.getHoleRadius()) {
            int alpha = this.mTransparentCirclePaint.getAlpha();
            float transparentCircleRadius = radius * (this.mChart.getTransparentCircleRadius() / 100.0f);
            this.mTransparentCirclePaint.setAlpha((int) (alpha * this.mAnimator.getPhaseX() * this.mAnimator.getPhaseY()));
            this.mHoleCirclePath.reset();
            this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, transparentCircleRadius, Path.Direction.CW);
            this.mHoleCirclePath.addCircle(centerCircleBox.x, centerCircleBox.y, holeRadius, Path.Direction.CCW);
            this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
            this.mTransparentCirclePaint.setAlpha(alpha);
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    protected void drawCenterText(Canvas canvas) {
        float radius;
        CharSequence centerText = this.mChart.getCenterText();
        if (!this.mChart.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        MPPointF centerTextOffset = this.mChart.getCenterTextOffset();
        float f2 = centerCircleBox.x + centerTextOffset.x;
        float f3 = centerCircleBox.y + centerTextOffset.y;
        if (this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled()) {
            radius = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        } else {
            radius = this.mChart.getRadius();
        }
        RectF rectF = this.mRectBuffer[0];
        rectF.left = f2 - radius;
        rectF.top = f3 - radius;
        rectF.right = f2 + radius;
        rectF.bottom = f3 + radius;
        RectF rectF2 = this.mRectBuffer[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (!centerText.equals(this.mCenterTextLastValue) || !rectF2.equals(this.mCenterTextLastBounds)) {
            this.mCenterTextLastBounds.set(rectF2);
            this.mCenterTextLastValue = centerText;
            this.mCenterTextLayout = new StaticLayout(centerText, 0, centerText.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.mCenterTextLayout.getHeight();
        canvas.save();
        Path path = this.mDrawCenterTextPathBuffer;
        path.reset();
        path.addOval(rectF, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.mCenterTextLayout.draw(canvas);
        canvas.restore();
        MPPointF.recycleInstance(centerCircleBox);
        MPPointF.recycleInstance(centerTextOffset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        float f2;
        float f3;
        RectF rectF;
        int i;
        IPieDataSet dataSetByIndex;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float fCalculateMinimumRadiusForSpacedSlice;
        float fMax;
        Highlight[] highlightArr2 = highlightArr;
        boolean z = this.mChart.isDrawHoleEnabled() && !this.mChart.isDrawSlicesUnderHoleEnabled();
        if (z && this.mChart.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float phaseX = this.mAnimator.getPhaseX();
        float phaseY = this.mAnimator.getPhaseY();
        float rotationAngle = this.mChart.getRotationAngle();
        float[] drawAngles = this.mChart.getDrawAngles();
        float[] absoluteAngles = this.mChart.getAbsoluteAngles();
        MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
        float radius = this.mChart.getRadius();
        float f10 = 0.0f;
        float holeRadius = z ? (this.mChart.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.mDrawHighlightedRectF;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i2 = 0;
        while (i2 < highlightArr2.length) {
            int x = (int) highlightArr2[i2].getX();
            float f11 = f10;
            if (x < drawAngles.length && (dataSetByIndex = ((PieData) this.mChart.getData()).getDataSetByIndex(highlightArr2[i2].getDataSetIndex())) != null && dataSetByIndex.isHighlightEnabled()) {
                int entryCount = dataSetByIndex.getEntryCount();
                int i3 = 0;
                for (int i4 = 0; i4 < entryCount; i4++) {
                    if (Math.abs(dataSetByIndex.getEntryForIndex(i4).getY()) > Utils.FLOAT_EPSILON) {
                        i3++;
                    }
                }
                float f12 = x == 0 ? f11 : absoluteAngles[x - 1] * phaseX;
                float sliceSpace = i3 <= 1 ? f11 : dataSetByIndex.getSliceSpace();
                float f13 = drawAngles[x];
                float f14 = radius;
                float selectionShift = dataSetByIndex.getSelectionShift();
                float f15 = holeRadius;
                float f16 = f14 + selectionShift;
                i = i2;
                rectF2.set(this.mChart.getCircleBox());
                float f17 = -selectionShift;
                rectF2.inset(f17, f17);
                boolean z2 = sliceSpace > f11 && f13 <= 180.0f;
                this.mRenderPaint.setColor(dataSetByIndex.getColor(x));
                float f18 = i3 == 1 ? f11 : sliceSpace / (f14 * 0.017453292f);
                float f19 = i3 == 1 ? f11 : sliceSpace / (f16 * 0.017453292f);
                float f20 = (((f18 / 2.0f) + f12) * phaseY) + rotationAngle;
                float f21 = (f13 - f18) * phaseY;
                float f22 = f21 < f11 ? f11 : f21;
                float f23 = (((f19 / 2.0f) + f12) * phaseY) + rotationAngle;
                float f24 = (f13 - f19) * phaseY;
                if (f24 < f11) {
                    f24 = f11;
                }
                this.mPathBuffer.reset();
                if (f22 >= 360.0f && f22 % 360.0f <= Utils.FLOAT_EPSILON) {
                    f4 = f22;
                    this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, f16, Path.Direction.CW);
                    f5 = f12;
                    f6 = sliceSpace;
                } else {
                    f4 = f22;
                    f5 = f12;
                    f6 = sliceSpace;
                    double d2 = f23 * 0.017453292f;
                    this.mPathBuffer.moveTo(centerCircleBox.x + (((float) Math.cos(d2)) * f16), centerCircleBox.y + (((float) Math.sin(d2)) * f16));
                    this.mPathBuffer.arcTo(rectF2, f23, f24);
                }
                if (z2) {
                    double d3 = f20 * 0.017453292f;
                    float fCos = (((float) Math.cos(d3)) * f14) + centerCircleBox.x;
                    float fSin = centerCircleBox.y + (((float) Math.sin(d3)) * f14);
                    f8 = f14;
                    rectF = rectF2;
                    f7 = f11;
                    f3 = f15;
                    f9 = f20;
                    fCalculateMinimumRadiusForSpacedSlice = calculateMinimumRadiusForSpacedSlice(centerCircleBox, f8, f13 * phaseY, fCos, fSin, f9, f4);
                } else {
                    f7 = f11;
                    f8 = f14;
                    f3 = f15;
                    f9 = f20;
                    rectF = rectF2;
                    fCalculateMinimumRadiusForSpacedSlice = f7;
                }
                f11 = f7;
                f2 = f8;
                this.mInnerRectBuffer.set(centerCircleBox.x - f3, centerCircleBox.y - f3, centerCircleBox.x + f3, centerCircleBox.y + f3);
                if (z && (f3 > f11 || z2)) {
                    if (z2) {
                        if (fCalculateMinimumRadiusForSpacedSlice < f11) {
                            fCalculateMinimumRadiusForSpacedSlice = -fCalculateMinimumRadiusForSpacedSlice;
                        }
                        fMax = Math.max(f3, fCalculateMinimumRadiusForSpacedSlice);
                    } else {
                        fMax = f3;
                    }
                    float f25 = (i3 == 1 || fMax == f11) ? f11 : f6 / (fMax * 0.017453292f);
                    float f26 = ((f5 + (f25 / 2.0f)) * phaseY) + rotationAngle;
                    float f27 = (f13 - f25) * phaseY;
                    if (f27 < f11) {
                        f27 = f11;
                    }
                    float f28 = f26 + f27;
                    if (f22 >= 360.0f && f4 % 360.0f <= Utils.FLOAT_EPSILON) {
                        this.mPathBuffer.addCircle(centerCircleBox.x, centerCircleBox.y, fMax, Path.Direction.CCW);
                    } else {
                        double d4 = f28 * 0.017453292f;
                        this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d4)) * fMax), centerCircleBox.y + (fMax * ((float) Math.sin(d4))));
                        this.mPathBuffer.arcTo(this.mInnerRectBuffer, f28, -f27);
                    }
                } else if (f4 % 360.0f > Utils.FLOAT_EPSILON) {
                    if (z2) {
                        double d5 = (f9 + (f4 / 2.0f)) * 0.017453292f;
                        this.mPathBuffer.lineTo(centerCircleBox.x + (((float) Math.cos(d5)) * fCalculateMinimumRadiusForSpacedSlice), centerCircleBox.y + (fCalculateMinimumRadiusForSpacedSlice * ((float) Math.sin(d5))));
                    } else {
                        this.mPathBuffer.lineTo(centerCircleBox.x, centerCircleBox.y);
                    }
                }
                this.mPathBuffer.close();
                this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
            } else {
                f2 = radius;
                f3 = holeRadius;
                rectF = rectF2;
                i = i2;
            }
            i2 = i + 1;
            f10 = f11;
            highlightArr2 = highlightArr;
            holeRadius = f3;
            rectF2 = rectF;
            radius = f2;
        }
        MPPointF.recycleInstance(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawRoundedSlices(Canvas canvas) {
        float f2;
        float f3;
        if (this.mChart.isDrawRoundedSlicesEnabled()) {
            IPieDataSet dataSet = ((PieData) this.mChart.getData()).getDataSet();
            if (dataSet.isVisible()) {
                float phaseX = this.mAnimator.getPhaseX();
                float phaseY = this.mAnimator.getPhaseY();
                MPPointF centerCircleBox = this.mChart.getCenterCircleBox();
                float radius = this.mChart.getRadius();
                float holeRadius = (radius - ((this.mChart.getHoleRadius() * radius) / 100.0f)) / 2.0f;
                float[] drawAngles = this.mChart.getDrawAngles();
                float rotationAngle = this.mChart.getRotationAngle();
                int i = 0;
                while (i < dataSet.getEntryCount()) {
                    float f4 = drawAngles[i];
                    if (Math.abs(dataSet.getEntryForIndex(i).getY()) > Utils.FLOAT_EPSILON) {
                        double d2 = radius - holeRadius;
                        double d3 = (rotationAngle + f4) * phaseY;
                        f2 = phaseX;
                        f3 = phaseY;
                        float fCos = (float) (((double) centerCircleBox.x) + (Math.cos(Math.toRadians(d3)) * d2));
                        float fSin = (float) ((d2 * Math.sin(Math.toRadians(d3))) + ((double) centerCircleBox.y));
                        this.mRenderPaint.setColor(dataSet.getColor(i));
                        this.mBitmapCanvas.drawCircle(fCos, fSin, holeRadius, this.mRenderPaint);
                    } else {
                        f2 = phaseX;
                        f3 = phaseY;
                    }
                    rotationAngle += f4 * f2;
                    i++;
                    phaseX = f2;
                    phaseY = f3;
                }
                MPPointF.recycleInstance(centerCircleBox);
            }
        }
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }
}
