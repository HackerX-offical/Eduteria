package com.appnew.android.Notification.readMoreTV;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.appnew.android.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReadMoreTextView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002<=B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001fJ\u000e\u0010\u000e\u001a\u00020!2\u0006\u0010#\u001a\u00020\rJ\b\u0010$\u001a\u00020!H\u0002J\u0018\u0010$\u001a\u00020!2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0014\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\n\u0010+\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\tH\u0002J\u000e\u00100\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u00101\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u000e\u00102\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0010J\u000e\u00103\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0010J\u000e\u00104\u001a\u00020!2\u0006\u0010#\u001a\u00020\tJ\u000e\u00105\u001a\u00020!2\u0006\u0010#\u001a\u00020\tJ\u000e\u00106\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u0010J\u000e\u00107\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0010J\b\u00108\u001a\u00020\rH\u0016J\b\u00109\u001a\u00020!H\u0002J\b\u0010:\u001a\u00020!H\u0002J\b\u0010;\u001a\u00020!H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006>"}, d2 = {"Lcom/appnew/android/Notification/readMoreTV/ReadMoreTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "text", "", "bufferType", "Landroid/widget/TextView$BufferType;", "readMore", "", "wantExpend", "trimLength", "", "trimCollapsedText", "trimExpandedText", "viewMoreSpan", "Lcom/appnew/android/Notification/readMoreTV/ReadMoreTextView$ReadMoreClickableSpan;", "colorClickableText", "lessTextColor", "Ljava/lang/Integer;", "moreTextColor", "showTrimExpandedText", "trimMode", "lineEndIndex", "trimLines", "canExpand", "textViewClickListener", "Lcom/appnew/android/Notification/readMoreTV/TextViewClickListener;", "setOnTextViewClickListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "value", "setText", "displayableText", "getDisplayableText", "()Ljava/lang/CharSequence;", "type", "getTrimmedText", "updateCollapsedText", "updateExpandedText", "addClickableSpan", CmcdData.Factory.STREAMING_FORMAT_SS, "Landroid/text/SpannableStringBuilder;", "trimText", "setTrimLength", "setColorClickableText", "setExpandedTextColor", "setCollapsedTextColor", "setCollapsedText", "setExpandedText", "setTrimMode", "setTrimLines", "performClick", "toggleExpansion", "onGlobalLayoutLineEndIndex", "refreshLineEndIndex", "ReadMoreClickableSpan", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadMoreTextView extends AppCompatTextView {
    private static final boolean DEFAULT_SHOW_TRIM_EXPANDED_TEXT = true;
    private static final String ELLIPSIZE = "... ";
    private static final int INVALID_END_INDEX = -1;
    private static final int TRIM_MODE_LENGTH = 1;
    private static final int TRIM_MODE_LINES = 0;
    private TextView.BufferType bufferType;
    private boolean canExpand;
    private int colorClickableText;
    private Integer lessTextColor;
    private int lineEndIndex;
    private Integer moreTextColor;
    private boolean readMore;
    private final boolean showTrimExpandedText;
    private CharSequence text;
    private TextViewClickListener textViewClickListener;
    private CharSequence trimCollapsedText;
    private CharSequence trimExpandedText;
    private int trimLength;
    private int trimLines;
    private int trimMode;
    private final ReadMoreClickableSpan viewMoreSpan;
    private boolean wantExpend;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static int DEFAULT_TRIM_LENGTH = 240;
    private static int DEFAULT_TRIM_LINES = 3;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReadMoreTextView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ReadMoreTextView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadMoreTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.readMore = true;
        this.wantExpend = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReadMoreTextView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.trimLength = typedArrayObtainStyledAttributes.getInt(4, DEFAULT_TRIM_LENGTH);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, com.eduteria.app.app.R.string.resizable_text_read_more);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(3, com.eduteria.app.app.R.string.resizable_text_read_less);
        setClickable(true);
        setFocusable(true);
        this.trimCollapsedText = getResources().getString(resourceId);
        this.trimExpandedText = getResources().getString(resourceId2);
        this.trimLines = typedArrayObtainStyledAttributes.getInt(5, DEFAULT_TRIM_LINES);
        this.colorClickableText = typedArrayObtainStyledAttributes.getColor(0, ContextCompat.getColor(context, com.eduteria.app.app.R.color.C3f51b5));
        this.showTrimExpandedText = typedArrayObtainStyledAttributes.getBoolean(1, true);
        this.trimMode = typedArrayObtainStyledAttributes.getInt(6, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.viewMoreSpan = new ReadMoreClickableSpan();
        onGlobalLayoutLineEndIndex();
        setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.readMoreTV.ReadMoreTextView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.toggleExpansion();
            }
        });
        setText();
    }

    public final void setOnTextViewClickListener(TextViewClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.textViewClickListener = listener;
    }

    public final void wantExpend(boolean value) {
        this.wantExpend = value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setText() {
        super.setText(getDisplayableText(), this.bufferType);
    }

    private final CharSequence getDisplayableText() {
        return getTrimmedText(this.text);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(type, "type");
        this.text = text;
        this.bufferType = type;
        setText();
    }

    private final CharSequence getTrimmedText(CharSequence text) {
        if (this.trimMode == 1 && text != null && text.length() > this.trimLength) {
            if (this.readMore) {
                return updateCollapsedText();
            }
            return updateExpandedText();
        }
        if (this.trimMode != 0 || text == null || this.lineEndIndex <= 0) {
            return text;
        }
        if (this.readMore) {
            if (getLayout().getLineCount() <= this.trimLines) {
                return text;
            }
            Integer num = this.lessTextColor;
            if (num != null) {
                setColorClickableText(num.intValue());
            }
            return updateCollapsedText();
        }
        Integer num2 = this.moreTextColor;
        if (num2 != null) {
            setColorClickableText(num2.intValue());
        }
        return updateExpandedText();
    }

    private final CharSequence updateCollapsedText() {
        int i;
        CharSequence charSequence = this.text;
        Intrinsics.checkNotNull(charSequence);
        int length = charSequence.length();
        int i2 = this.trimMode;
        if (i2 == 0) {
            length = this.lineEndIndex - (this.trimCollapsedText.length() + 5);
            if (length < 0) {
                i = this.trimLength;
                length = i + 1;
            }
        } else if (i2 == 1) {
            i = this.trimLength;
            length = i + 1;
        }
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(this.text, 0, Math.min(length, String.valueOf(this.text).length())).append((CharSequence) ELLIPSIZE).append(this.trimCollapsedText);
        Intrinsics.checkNotNull(spannableStringBuilderAppend);
        return addClickableSpan(spannableStringBuilderAppend, this.trimCollapsedText);
    }

    private final CharSequence updateExpandedText() {
        if (this.showTrimExpandedText) {
            CharSequence charSequence = this.text;
            Intrinsics.checkNotNull(charSequence);
            SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(charSequence, 0, charSequence.length()).append((CharSequence) getContext().getString(com.eduteria.app.app.R.string.space)).append(this.trimExpandedText);
            Intrinsics.checkNotNull(spannableStringBuilderAppend);
            return addClickableSpan(spannableStringBuilderAppend, this.trimExpandedText);
        }
        return this.text;
    }

    private final CharSequence addClickableSpan(SpannableStringBuilder s, CharSequence trimText) {
        s.setSpan(this.viewMoreSpan, s.length() - trimText.length(), s.length(), 33);
        return s;
    }

    public final void setTrimLength(int trimLength) {
        this.trimLength = trimLength;
        setText();
    }

    private final void setColorClickableText(int colorClickableText) {
        try {
            this.colorClickableText = ContextCompat.getColor(getContext(), colorClickableText);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void setExpandedTextColor(int value) {
        this.lessTextColor = Integer.valueOf(value);
    }

    public final void setCollapsedTextColor(int value) {
        this.moreTextColor = Integer.valueOf(value);
    }

    public final void setCollapsedText(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.trimExpandedText = value;
    }

    public final void setExpandedText(CharSequence value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.trimCollapsedText = value;
    }

    public final void setTrimMode(int trimMode) {
        this.trimMode = trimMode;
    }

    public final void setTrimLines(int trimLines) {
        this.trimLines = trimLines;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleExpansion() {
        if (this.wantExpend && this.canExpand) {
            if (this.readMore) {
                TextViewClickListener textViewClickListener = this.textViewClickListener;
                if (textViewClickListener != null) {
                    textViewClickListener.onReadMoreClick();
                }
            } else {
                TextViewClickListener textViewClickListener2 = this.textViewClickListener;
                if (textViewClickListener2 != null) {
                    textViewClickListener2.onReadLessClick();
                }
            }
            this.readMore = !this.readMore;
            setText();
        }
    }

    /* JADX INFO: compiled from: ReadMoreTextView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/appnew/android/Notification/readMoreTV/ReadMoreTextView$ReadMoreClickableSpan;", "Landroid/text/style/ClickableSpan;", "<init>", "(Lcom/appnew/android/Notification/readMoreTV/ReadMoreTextView;)V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class ReadMoreClickableSpan extends ClickableSpan {
        public ReadMoreClickableSpan() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            ReadMoreTextView.this.toggleExpansion();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setColor(ReadMoreTextView.this.colorClickableText);
            ds.setFakeBoldText(true);
        }
    }

    private final void onGlobalLayoutLineEndIndex() {
        if (this.trimMode == 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appnew.android.Notification.readMoreTV.ReadMoreTextView.onGlobalLayoutLineEndIndex.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ReadMoreTextView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    ReadMoreTextView.this.refreshLineEndIndex();
                    ReadMoreTextView.this.setText();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshLineEndIndex() {
        int lineEnd;
        try {
            int lineCount = getLayout().getLineCount();
            int i = this.trimLines;
            this.canExpand = lineCount > i;
            if (i == 0) {
                lineEnd = getLayout().getLineEnd(0);
            } else {
                lineEnd = (1 > i || i > getLineCount()) ? -1 : getLayout().getLineEnd(this.trimLines - 1);
            }
            this.lineEndIndex = lineEnd;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: ReadMoreTextView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/appnew/android/Notification/readMoreTV/ReadMoreTextView$Companion;", "", "<init>", "()V", "TRIM_MODE_LINES", "", "TRIM_MODE_LENGTH", "DEFAULT_TRIM_LENGTH", "getDEFAULT_TRIM_LENGTH", "()I", "setDEFAULT_TRIM_LENGTH", "(I)V", "DEFAULT_TRIM_LINES", "getDEFAULT_TRIM_LINES", "setDEFAULT_TRIM_LINES", "INVALID_END_INDEX", "DEFAULT_SHOW_TRIM_EXPANDED_TEXT", "", "ELLIPSIZE", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getDEFAULT_TRIM_LENGTH() {
            return ReadMoreTextView.DEFAULT_TRIM_LENGTH;
        }

        public final void setDEFAULT_TRIM_LENGTH(int i) {
            ReadMoreTextView.DEFAULT_TRIM_LENGTH = i;
        }

        public final int getDEFAULT_TRIM_LINES() {
            return ReadMoreTextView.DEFAULT_TRIM_LINES;
        }

        public final void setDEFAULT_TRIM_LINES(int i) {
            ReadMoreTextView.DEFAULT_TRIM_LINES = i;
        }
    }
}
