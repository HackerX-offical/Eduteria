package com.appnew.android.Utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.appnew.android.R;

/* JADX INFO: loaded from: classes6.dex */
public class LabeledEditText extends AppCompatEditText {
    private final Paint backgroundPaint;
    private final Paint borderPaint;
    private final Paint labelPaint;
    private String labelText;

    public LabeledEditText(Context context) {
        super(context);
        this.labelText = "";
        this.labelPaint = new Paint(1);
        this.borderPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        init(null);
    }

    public LabeledEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.labelText = "";
        this.labelPaint = new Paint(1);
        this.borderPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        init(attrs);
    }

    public LabeledEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.labelText = "";
        this.labelPaint = new Paint(1);
        this.borderPaint = new Paint(1);
        this.backgroundPaint = new Paint(1);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        this.labelPaint.setColor(-12763843);
        this.labelPaint.setTextSize(spToPx(getContext(), 12.0f));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setStrokeWidth(dpToPx(getContext(), 1.0f));
        this.borderPaint.setColor(-3355444);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        this.backgroundPaint.setColor(-1);
        if (attrs != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.LabeledEditText);
                this.labelText = typedArrayObtainStyledAttributes.getString(0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e2) {
                e2.printStackTrace();
                this.labelText = "";
            }
        }
        try {
            setBackground(null);
        } catch (Exception unused) {
        }
        setPadding(dpToPx(getContext(), 12.0f), dpToPx(getContext(), 22.0f), dpToPx(getContext(), 12.0f), dpToPx(getContext(), 18.0f));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Canvas canvas2;
        float fDpToPx;
        float strokeWidth;
        float fDpToPx2;
        String str;
        try {
            fDpToPx = dpToPx(getContext(), 8.0f);
            strokeWidth = this.borderPaint.getStrokeWidth();
            fDpToPx2 = dpToPx(getContext(), 8.0f);
            str = this.labelText;
        } catch (Exception e2) {
            e = e2;
            canvas2 = canvas;
        }
        try {
            if (str != null && !str.isEmpty()) {
                float textSize = this.labelPaint.getTextSize();
                float fMeasureText = this.labelPaint.measureText(this.labelText);
                canvas.drawRoundRect(new RectF(strokeWidth, (textSize - 12.0f) + strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth), fDpToPx, fDpToPx, this.borderPaint);
                float paddingLeft = getPaddingLeft() + 12;
                canvas2 = canvas;
                canvas2.drawRect(paddingLeft, 0.0f, fMeasureText + paddingLeft + (2.0f * fDpToPx2), textSize + fDpToPx2, this.backgroundPaint);
                canvas2.drawText(this.labelText, paddingLeft + fDpToPx2, textSize, this.labelPaint);
            } else {
                canvas2 = canvas;
                canvas2.drawRoundRect(new RectF(strokeWidth, 16.0f + strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth), fDpToPx, fDpToPx, this.borderPaint);
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
        }
        super.onDraw(canvas2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        try {
            final int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            final TextPaint paint = getPaint();
            InputFilter inputFilter = new InputFilter() { // from class: com.appnew.android.Utils.LabeledEditText.1
                @Override // android.text.InputFilter
                public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                    try {
                        if (paint.measureText(((Object) dest.subSequence(0, dstart)) + source.subSequence(start, end).toString() + ((Object) dest.subSequence(dend, dest.length()))) <= width) {
                            return null;
                        }
                        return "";
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
            };
            InputFilter[] filters = getFilters();
            InputFilter[] inputFilterArr = new InputFilter[filters.length + 1];
            System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
            inputFilterArr[filters.length] = inputFilter;
            setFilters(inputFilterArr);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setLabel(String text) {
        if (text == null) {
            text = "";
        }
        this.labelText = text;
        invalidate();
    }

    public String getLabel() {
        return this.labelText;
    }

    private float spToPx(Context context, float sp) {
        return sp * context.getResources().getDisplayMetrics().scaledDensity;
    }

    private int dpToPx(Context context, float dp) {
        return Math.round(dp * context.getResources().getDisplayMetrics().density);
    }
}
