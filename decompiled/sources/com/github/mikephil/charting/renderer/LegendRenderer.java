package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries;
    protected Paint.FontMetrics legendFontMetrics;
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath;

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.computedEntries = new ArrayList(16);
        this.legendFontMetrics = new Paint.FontMetrics();
        this.mLineFormPath = new Path();
        this.mLegend = legend;
        Paint paint = new Paint(1);
        this.mLegendLabelPaint = paint;
        paint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.mLegendFormPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void computeLegend(com.github.mikephil.charting.data.ChartData<?> r18) {
        /*
            Method dump skipped, instruction units count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.computeLegend(com.github.mikephil.charting.data.ChartData):void");
    }

    public void renderLegend(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i;
        List<Boolean> list;
        int i2;
        List<FSize> list2;
        Canvas canvas2;
        List<FSize> list3;
        float f6;
        float fContentTop;
        int i3;
        float f7;
        Canvas canvas3;
        float fCalcTextWidth;
        float fContentBottom;
        float fContentRight;
        float fContentLeft;
        double d2;
        if (this.mLegend.isEnabled()) {
            Typeface typeface = this.mLegend.getTypeface();
            if (typeface != null) {
                this.mLegendLabelPaint.setTypeface(typeface);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float lineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float lineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float fCalcTextHeight = lineHeight - (Utils.calcTextHeight(this.mLegendLabelPaint, "ABC") / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float fConvertDpToPixel = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float fConvertDpToPixel2 = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float fConvertDpToPixel3 = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float fConvertDpToPixel4 = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yOffset = this.mLegend.getYOffset();
            float xOffset = this.mLegend.getXOffset();
            int i4 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[horizontalAlignment.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    f2 = fConvertDpToPixel4;
                    f3 = lineSpacing;
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        fContentRight = this.mViewPortHandler.getChartWidth();
                    } else {
                        fContentRight = this.mViewPortHandler.contentRight();
                    }
                    f5 = fContentRight - xOffset;
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f5 -= this.mLegend.mNeededWidth;
                    }
                } else if (i4 != 3) {
                    f2 = fConvertDpToPixel4;
                    f3 = lineSpacing;
                    f4 = 0.0f;
                } else {
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        fContentLeft = this.mViewPortHandler.getChartWidth() / 2.0f;
                    } else {
                        fContentLeft = this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                    }
                    f5 = fContentLeft + (direction == Legend.LegendDirection.LEFT_TO_RIGHT ? xOffset : -xOffset);
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        f3 = lineSpacing;
                        double d3 = f5;
                        if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            f2 = fConvertDpToPixel4;
                            d2 = (((double) (-this.mLegend.mNeededWidth)) / 2.0d) + ((double) xOffset);
                        } else {
                            f2 = fConvertDpToPixel4;
                            d2 = (((double) this.mLegend.mNeededWidth) / 2.0d) - ((double) xOffset);
                        }
                        f5 = (float) (d3 + d2);
                    } else {
                        f2 = fConvertDpToPixel4;
                        f3 = lineSpacing;
                    }
                }
                f4 = f5;
            } else {
                f2 = fConvertDpToPixel4;
                f3 = lineSpacing;
                if (orientation != Legend.LegendOrientation.VERTICAL) {
                    xOffset += this.mViewPortHandler.contentLeft();
                }
                if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                    f5 = this.mLegend.mNeededWidth + xOffset;
                    f4 = f5;
                } else {
                    f4 = xOffset;
                }
            }
            int i5 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[orientation.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    return;
                }
                int i6 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
                if (i6 == 1) {
                    fContentTop = (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.mViewPortHandler.contentTop()) + yOffset;
                } else if (i6 == 2) {
                    if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                        fContentBottom = this.mViewPortHandler.getChartHeight();
                    } else {
                        fContentBottom = this.mViewPortHandler.contentBottom();
                    }
                    fContentTop = fContentBottom - (this.mLegend.mNeededHeight + yOffset);
                } else {
                    fContentTop = i6 != 3 ? 0.0f : ((this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f)) + this.mLegend.getYOffset();
                }
                float f8 = fContentTop;
                float f9 = 0.0f;
                int i7 = 0;
                boolean z = false;
                while (i7 < entries.length) {
                    LegendEntry legendEntry = entries[i7];
                    boolean z2 = legendEntry.form != Legend.LegendForm.NONE;
                    float fConvertDpToPixel5 = Float.isNaN(legendEntry.formSize) ? fConvertDpToPixel3 : Utils.convertDpToPixel(legendEntry.formSize);
                    if (z2) {
                        fCalcTextWidth = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f4 + f9 : f4 - (fConvertDpToPixel5 - f9);
                        i3 = i7;
                        f7 = f2;
                        canvas3 = canvas;
                        drawForm(canvas3, fCalcTextWidth, f8 + fCalcTextHeight, legendEntry, this.mLegend);
                        if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            fCalcTextWidth += fConvertDpToPixel5;
                        }
                    } else {
                        i3 = i7;
                        f7 = f2;
                        canvas3 = canvas;
                        fCalcTextWidth = f4;
                    }
                    if (legendEntry.label != null) {
                        if (z2 && !z) {
                            fCalcTextWidth += direction == Legend.LegendDirection.LEFT_TO_RIGHT ? fConvertDpToPixel : -fConvertDpToPixel;
                        } else if (z) {
                            fCalcTextWidth = f4;
                        }
                        if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            fCalcTextWidth -= Utils.calcTextWidth(this.mLegendLabelPaint, legendEntry.label);
                        }
                        if (!z) {
                            drawLabel(canvas3, fCalcTextWidth, f8 + lineHeight, legendEntry.label);
                        } else {
                            f8 += lineHeight + f3;
                            drawLabel(canvas3, fCalcTextWidth, f8 + lineHeight, legendEntry.label);
                        }
                        f8 += lineHeight + f3;
                        f9 = 0.0f;
                    } else {
                        f9 += fConvertDpToPixel5 + f7;
                        z = true;
                    }
                    i7 = i3 + 1;
                    f2 = f7;
                }
                return;
            }
            float f10 = f2;
            List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
            List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
            List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
            int i8 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[verticalAlignment.ordinal()];
            float f11 = f4;
            if (i8 != 1) {
                if (i8 == 2) {
                    yOffset = (this.mViewPortHandler.getChartHeight() - yOffset) - this.mLegend.mNeededHeight;
                } else {
                    yOffset = i8 != 3 ? 0.0f : yOffset + ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f);
                }
            }
            int length = entries.length;
            List<FSize> list4 = calculatedLabelSizes;
            float f12 = f11;
            int i9 = 0;
            int i10 = 0;
            while (i9 < length) {
                float f13 = yOffset;
                LegendEntry legendEntry2 = entries[i9];
                int i11 = length;
                float f14 = f3;
                boolean z3 = legendEntry2.form != Legend.LegendForm.NONE;
                float fConvertDpToPixel6 = Float.isNaN(legendEntry2.formSize) ? fConvertDpToPixel3 : Utils.convertDpToPixel(legendEntry2.formSize);
                boolean z4 = z3;
                if (i9 < calculatedLabelBreakPoints.size() && calculatedLabelBreakPoints.get(i9).booleanValue()) {
                    f13 += lineHeight + f14;
                    f12 = f11;
                }
                if (f12 == f11 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && i10 < calculatedLineSizes.size()) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f6 = calculatedLineSizes.get(i10).width;
                    } else {
                        f6 = -calculatedLineSizes.get(i10).width;
                    }
                    f12 += f6 / 2.0f;
                    i10++;
                }
                int i12 = i10;
                boolean z5 = legendEntry2.label == null;
                if (z4) {
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f12 -= fConvertDpToPixel6;
                    }
                    float f15 = fConvertDpToPixel6;
                    list = calculatedLabelBreakPoints;
                    i = i9;
                    i2 = i12;
                    list2 = list4;
                    canvas2 = canvas;
                    list3 = calculatedLineSizes;
                    float f16 = f12;
                    drawForm(canvas2, f16, f13 + fCalcTextHeight, legendEntry2, this.mLegend);
                    f12 = direction == Legend.LegendDirection.LEFT_TO_RIGHT ? f16 + f15 : f16;
                } else {
                    i = i9;
                    list = calculatedLabelBreakPoints;
                    i2 = i12;
                    list2 = list4;
                    canvas2 = canvas;
                    list3 = calculatedLineSizes;
                }
                if (!z5) {
                    if (z4) {
                        f12 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -fConvertDpToPixel : fConvertDpToPixel;
                    }
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        f12 -= list2.get(i).width;
                    }
                    float f17 = f12;
                    drawLabel(canvas2, f17, f13 + lineHeight, legendEntry2.label);
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        f17 += list2.get(i).width;
                    }
                    f12 = f17 + (direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -fConvertDpToPixel2 : fConvertDpToPixel2);
                } else {
                    f12 += direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -f10 : f10;
                }
                i9 = i + 1;
                calculatedLineSizes = list3;
                yOffset = f13;
                f3 = f14;
                i10 = i2;
                calculatedLabelBreakPoints = list;
                list4 = list2;
                length = i11;
            }
        }
    }

    protected void drawForm(Canvas canvas, float f2, float f3, LegendEntry legendEntry, Legend legend) {
        Canvas canvas2;
        if (legendEntry.formColor == 1122868 || legendEntry.formColor == 1122867 || legendEntry.formColor == 0) {
            return;
        }
        int iSave = canvas.save();
        Legend.LegendForm form = legendEntry.form;
        if (form == Legend.LegendForm.DEFAULT) {
            form = legend.getForm();
        }
        this.mLegendFormPaint.setColor(legendEntry.formColor);
        float fConvertDpToPixel = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? legend.getFormSize() : legendEntry.formSize);
        float f4 = fConvertDpToPixel / 2.0f;
        int i = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[form.ordinal()];
        if (i == 3 || i == 4) {
            canvas2 = canvas;
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas2.drawCircle(f2 + f4, f3, f4, this.mLegendFormPaint);
        } else if (i != 5) {
            if (i == 6) {
                float fConvertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formLineWidth) ? legend.getFormLineWidth() : legendEntry.formLineWidth);
                DashPathEffect formLineDashEffect = legendEntry.formLineDashEffect == null ? legend.getFormLineDashEffect() : legendEntry.formLineDashEffect;
                this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
                this.mLegendFormPaint.setStrokeWidth(fConvertDpToPixel2);
                this.mLegendFormPaint.setPathEffect(formLineDashEffect);
                this.mLineFormPath.reset();
                this.mLineFormPath.moveTo(f2, f3);
                this.mLineFormPath.lineTo(f2 + fConvertDpToPixel, f3);
                canvas.drawPath(this.mLineFormPath, this.mLegendFormPaint);
            }
            canvas2 = canvas;
        } else {
            this.mLegendFormPaint.setStyle(Paint.Style.FILL);
            canvas2 = canvas;
            canvas2.drawRect(f2, f3 - f4, f2 + fConvertDpToPixel, f3 + f4, this.mLegendFormPaint);
        }
        canvas2.restoreToCount(iSave);
    }

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment;

        static {
            int[] iArr = new int[Legend.LegendForm.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm = iArr;
            try {
                iArr[Legend.LegendForm.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendForm[Legend.LegendForm.LINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = iArr2;
            try {
                iArr2[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr4 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = iArr4;
            try {
                iArr4[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    protected void drawLabel(Canvas canvas, float f2, float f3, String str) {
        canvas.drawText(str, f2, f3, this.mLegendLabelPaint);
    }
}
