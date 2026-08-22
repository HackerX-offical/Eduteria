package com.appnew.android.feeds;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.ahmadnemati.clickablewebview.ClickableWebView;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.feeds.adapters.Banner_ViewPager;
import com.appnew.android.feeds.adapters.NewCourseAdapter;
import com.appnew.android.feeds.dataclass.BannerData;
import com.appnew.android.feeds.dataclass.NewCourseData;
import com.appnew.android.feeds.dataclass.comment.Data;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.makeramen.roundedimageview.RoundedImageView;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: ExtensionFucation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\b\u001a\u00020\u0001*\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007\u001a\u001a\u0010\r\u001a\u00020\u0001*\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0007\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0001*\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0016\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0014\u0010\u001e\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u0004H\u0007\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020\u00112\u0006\u0010!\u001a\u00020\u0004H\u0007¨\u0006\""}, d2 = {"showToast", "", "Landroid/content/Context;", "message", "", "showToastLong", "setwebview", "Lcom/ahmadnemati/clickablewebview/ClickableWebView;", "courseadapter", "Landroidx/recyclerview/widget/RecyclerView;", "data", "", "Lcom/appnew/android/feeds/dataclass/NewCourseData;", "load", "Landroidx/viewpager/widget/ViewPager;", "Lcom/appnew/android/feeds/dataclass/BannerData;", "date", "Landroid/widget/TextView;", "attempts", "attempt", "like", "formatNumber", "count", "", "viewVisible", "commentdata", "Lcom/appnew/android/feeds/dataclass/comment/Data;", "loadImage", "Lcom/makeramen/roundedimageview/RoundedImageView;", "url", "imageurl", "Landroid/widget/ImageView;", "transactionstatus", "status", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExtensionFucationKt {
    public static final void showToast(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast.makeText(context, message, 0).show();
    }

    public static final void showToastLong(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast.makeText(context, message, 1).show();
    }

    @BindingAdapter({"setwebview"})
    public static final void setwebview(ClickableWebView clickableWebView, String message) {
        Intrinsics.checkNotNullParameter(clickableWebView, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0) {
            clickableWebView.setBackgroundColor(0);
            clickableWebView.setLayerType(2, null);
            clickableWebView.getSettings().setJavaScriptEnabled(true);
            clickableWebView.getSettings().setGeolocationEnabled(true);
            Helper.TestWebHTMLLoad(clickableWebView, message);
        }
    }

    @BindingAdapter({"coursedata"})
    public static final void courseadapter(RecyclerView recyclerView, List<NewCourseData> list) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        if (list == null || list.size() <= 0) {
            return;
        }
        if (recyclerView.getAdapter() != null && (recyclerView.getAdapter() instanceof NewCourseAdapter)) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.appnew.android.feeds.adapters.NewCourseAdapter");
            Context context = recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ((NewCourseAdapter) adapter).updateItems(list, context);
            return;
        }
        recyclerView.setAdapter(new NewCourseAdapter());
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.appnew.android.feeds.adapters.NewCourseAdapter");
        Context context2 = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        ((NewCourseAdapter) adapter2).updateItems(list, context2);
    }

    @BindingAdapter({"viewpager"})
    public static final void load(ViewPager viewPager, List<BannerData> data) {
        Intrinsics.checkNotNullParameter(viewPager, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        if (viewPager.getAdapter() != null && (viewPager.getAdapter() instanceof Banner_ViewPager)) {
            PagerAdapter adapter = viewPager.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.appnew.android.feeds.adapters.Banner_ViewPager");
            ((Banner_ViewPager) adapter).updateItems(data, viewPager.getContext());
            return;
        }
        viewPager.setAdapter(new Banner_ViewPager(viewPager.getContext(), data));
    }

    @BindingAdapter({"datecomment"})
    public static final void date(TextView textView, String date) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(date, "date");
        textView.setText(new SimpleDateFormat("dd MMM, yyyy HH:mm ").format(new Date(Long.parseLong(date) * ((long) 1000))));
    }

    @BindingAdapter({"attempts"})
    public static final void attempts(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (str != null) {
            long j = Long.parseLong(str);
            if (j > 1) {
                textView.setText(formatNumber(j) + " attempts");
            } else {
                textView.setText(formatNumber(j) + " attempt");
            }
        }
    }

    @BindingAdapter({"like"})
    public static final void like(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (str != null) {
            long j = Long.parseLong(str);
            if (j > 1) {
                textView.setText(formatNumber(j) + " Likes");
            } else {
                textView.setText(formatNumber(j) + " Like");
            }
        }
    }

    public static final String formatNumber(long j) {
        if (j < 1000) {
            return new StringBuilder().append(j).toString();
        }
        double d2 = j;
        int iLog = (int) (Math.log(d2) / Math.log(1000.0d));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%.1f %c", Arrays.copyOf(new Object[]{Double.valueOf(d2 / Math.pow(1000.0d, iLog)), Character.valueOf("kMGTPE".charAt(iLog - 1))}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @BindingAdapter({"viewVisbile"})
    public static final void viewVisible(TextView textView, Data commentdata) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(commentdata, "commentdata");
        if (commentdata.getUser_id().equals(MakeMyExam.userId) && commentdata.getStatus().equals("0")) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    @BindingAdapter({"coruseimage"})
    public static final void loadImage(RoundedImageView roundedImageView, String str) {
        Intrinsics.checkNotNullParameter(roundedImageView, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        Glide.with(roundedImageView.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.drawable.square_thumbnail).error(R.drawable.square_thumbnail)).into(roundedImageView);
    }

    @BindingAdapter({"imageurl"})
    public static final void imageurl(ImageView imageView, String url) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() == 0) {
            return;
        }
        Glide.with(imageView.getContext()).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    @androidx.databinding.BindingAdapter({"transactionstatus"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void transactionstatus(android.widget.TextView r1, java.lang.String r2) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "status"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            int r0 = r2.hashCode()
            switch(r0) {
                case 48: goto L67;
                case 49: goto L5b;
                case 50: goto L4f;
                case 51: goto L43;
                case 52: goto L37;
                case 53: goto L2b;
                case 54: goto L1f;
                case 55: goto L13;
                default: goto L11;
            }
        L11:
            goto L73
        L13:
            java.lang.String r0 = "7"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L1c
            goto L73
        L1c:
            java.lang.String r2 = "Deleted"
            goto L75
        L1f:
            java.lang.String r0 = "6"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L28
            goto L73
        L28:
            java.lang.String r2 = "Transfered"
            goto L75
        L2b:
            java.lang.String r0 = "5"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L34
            goto L73
        L34:
            java.lang.String r2 = "Declined"
            goto L75
        L37:
            java.lang.String r0 = "4"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L40
            goto L73
        L40:
            java.lang.String r2 = "Refunded"
            goto L75
        L43:
            java.lang.String r0 = "3"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L4c
            goto L73
        L4c:
            java.lang.String r2 = "Refund Req."
            goto L75
        L4f:
            java.lang.String r0 = "2"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L58
            goto L73
        L58:
            java.lang.String r2 = "Cancel"
            goto L75
        L5b:
            java.lang.String r0 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L64
            goto L73
        L64:
            java.lang.String r2 = "Complete"
            goto L75
        L67:
            java.lang.String r0 = "0"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L70
            goto L73
        L70:
            java.lang.String r2 = "Pending"
            goto L75
        L73:
            java.lang.String r2 = "Processing"
        L75:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.feeds.ExtensionFucationKt.transactionstatus(android.widget.TextView, java.lang.String):void");
    }
}
