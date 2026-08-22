package easypay.appinvoke.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import easypay.appinvoke.manager.Constants;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes9.dex */
public class RoboTextView extends AppCompatTextView {
    public RoboTextView(Context context) {
        super(context);
    }

    public RoboTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            return;
        }
        setAttribute(context, attributeSet);
    }

    public RoboTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            return;
        }
        setAttribute(context, attributeSet);
    }

    private void setAttribute(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoboTextView);
        try {
            int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.RoboTextView_fontType, 0);
            if (integer != 0) {
                if (integer == 1) {
                    setTypeface(Typeface.create(Constants.FONT_FAMILY_SANS_SERIF_LIGHT, 0));
                    return;
                }
                if (integer == 2) {
                    setTypeface(Typeface.create("sans-serif", 0));
                    return;
                }
                if (integer == 3) {
                    setTypeface(Typeface.create(Constants.FONT_FAMILY_SANS_SERIF_MEDIUM, 0));
                } else if (integer == 4) {
                    setTypeface(Typeface.create("sans-serif", 1));
                } else {
                    if (integer != 5) {
                        return;
                    }
                    setTypeface(Typeface.create("sans-serif", 2));
                }
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
