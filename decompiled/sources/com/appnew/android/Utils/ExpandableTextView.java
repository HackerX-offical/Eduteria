package com.appnew.android.Utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes6.dex */
public class ExpandableTextView extends AppCompatTextView {
    private static final int DEFAULT_TRIM_LENGTH = 200;
    private static final String ELLIPSIS = ".....";
    private TextView.BufferType bufferType;
    private CharSequence originalText;
    private boolean trim;
    private int trimLength;
    private CharSequence trimmedText;

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.trim = true;
        setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Utils.ExpandableTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ExpandableTextView.this.trim = !r2.trim;
                ExpandableTextView.this.setText();
                ExpandableTextView.this.requestFocusFromTouch();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setText() {
        super.setText(getDisplayableText(), this.bufferType);
    }

    private CharSequence getDisplayableText() {
        return this.trim ? this.trimmedText : this.originalText;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        this.originalText = text;
        this.trimmedText = getTrimmedText(text);
        this.bufferType = type;
        setText();
    }

    private CharSequence getTrimmedText(CharSequence text) {
        CharSequence charSequence = this.originalText;
        if (charSequence != null && charSequence.length() > this.trimLength) {
            return new SpannableStringBuilder(this.originalText, 0, this.trimLength + 1).append((CharSequence) ELLIPSIS);
        }
        return this.originalText;
    }

    public CharSequence getOriginalText() {
        return this.originalText;
    }

    public void setTrimLength(int trimLength) {
        this.trimLength = trimLength;
        this.trimmedText = getTrimmedText(this.originalText);
        setText();
    }

    public int getTrimLength() {
        return this.trimLength;
    }
}
