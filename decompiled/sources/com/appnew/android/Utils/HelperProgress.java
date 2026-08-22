package com.appnew.android.Utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;
import com.appnew.android.Login.Activity.SplashScreen;
import com.appnew.android.Utils.Helper;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

/* JADX INFO: loaded from: classes6.dex */
public class HelperProgress {
    public static boolean isEdit(EditText view) {
        return false;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static void buttonEffect(final Context context, final View button) {
        button.setOnTouchListener(new View.OnTouchListener() { // from class: com.appnew.android.Utils.HelperProgress.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
                button.setBackgroundResource(typedValue.resourceId);
                return false;
            }
        });
    }

    public static float dpFromPx(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public static String getDateUsingMillis(long milliSeconds, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getFormatDateMillis(Long milliSeconds) {
        String str;
        if (milliSeconds == null) {
            str = "";
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a");
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(milliSeconds.longValue());
            str = simpleDateFormat.format(calendar.getTime());
        }
        return Helper.changeAMPM(str);
    }

    public static String getVideoDurationFromUrl(String url) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(url, new HashMap());
        long j = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 1000;
        long j2 = j / 60;
        long j3 = j2 / 60;
        long j4 = j3 / 24;
        return (j3 % 24) + ":" + (j2 % 60) + ":" + (j % 60);
    }

    public static int getBarSize(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        return context.getResources().getDimensionPixelSize(typedValue.resourceId);
    }

    public static void restartsApp(Context context, boolean restartProcess) {
        context.startActivity(new Intent(context, (Class<?>) SplashScreen.class).addFlags(268468224));
        if (restartProcess) {
            System.exit(0);
        }
    }

    public static String getCamelCaseString(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static void setTextViewHtmlToString(Activity activity, TextView textView, String data) {
        textView.setText(Html.fromHtml(data, 0));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setLinkTextColor(activity.getResources().getColor(com.eduteria.app.app.R.color.blue));
    }

    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {
        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        tv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appnew.android.Utils.HelperProgress.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                tv.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                int i = maxLine;
                if (i == 0) {
                    tv.setText(((Object) tv.getText().subSequence(0, (tv.getLayout().getLineEnd(0) - expandText.length()) + 1)) + " " + expandText);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView textView = tv;
                    textView.setText(HelperProgress.addClickablePartTextViewResizable(Html.fromHtml(textView.getText().toString()), tv, maxLine, expandText, viewMore), TextView.BufferType.SPANNABLE);
                    return;
                }
                if (i > 0 && tv.getLineCount() >= maxLine) {
                    tv.setText(((Object) tv.getText().subSequence(0, (tv.getLayout().getLineEnd(maxLine - 1) - expandText.length()) + 1)) + " " + expandText);
                    tv.setMovementMethod(LinkMovementMethod.getInstance());
                    TextView textView2 = tv;
                    textView2.setText(HelperProgress.addClickablePartTextViewResizable(Html.fromHtml(textView2.getText().toString()), tv, maxLine, expandText, viewMore), TextView.BufferType.SPANNABLE);
                    return;
                }
                int lineEnd = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                tv.setText(((Object) tv.getText().subSequence(0, lineEnd)) + " " + expandText);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                TextView textView3 = tv;
                textView3.setText(HelperProgress.addClickablePartTextViewResizable(Html.fromHtml(textView3.getText().toString()), tv, lineEnd, expandText, viewMore), TextView.BufferType.SPANNABLE);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv, final int maxLine, final String spanableText, final boolean viewMore) {
        String string = strSpanned.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strSpanned);
        if (string.contains(spanableText)) {
            spannableStringBuilder.setSpan(new Helper.MySpannable(false) { // from class: com.appnew.android.Utils.HelperProgress.3
                @Override // com.appnew.android.Utils.Helper.MySpannable, android.text.style.ClickableSpan
                public void onClick(View widget) {
                    if (viewMore) {
                        TextView textView = tv;
                        textView.setLayoutParams(textView.getLayoutParams());
                        TextView textView2 = tv;
                        textView2.setText(textView2.getTag().toString(), TextView.BufferType.SPANNABLE);
                        tv.invalidate();
                        HelperProgress.makeTextViewResizable(tv, -1, "Read Less", false);
                        return;
                    }
                    TextView textView3 = tv;
                    textView3.setLayoutParams(textView3.getLayoutParams());
                    TextView textView4 = tv;
                    textView4.setText(textView4.getTag().toString(), TextView.BufferType.SPANNABLE);
                    tv.invalidate();
                    HelperProgress.makeTextViewResizable(tv, 4, "Read More", true);
                }
            }, string.indexOf(spanableText), string.indexOf(spanableText) + spanableText.length(), 0);
        }
        return spannableStringBuilder;
    }
}
