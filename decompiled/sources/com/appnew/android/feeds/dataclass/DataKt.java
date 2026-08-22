package com.appnew.android.feeds.dataclass;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.feeds.adapters.NewLiveClass;
import com.appnew.android.feeds.adapters.NewLivetest;
import com.appnew.android.feeds.adapters.NewTestResultAdapter;
import com.appnew.android.feeds.adapters.OptionAdapter;
import com.appnew.android.feeds.adapters.OptionWebAdapter;
import com.appnew.android.home.livetest.LiveTestData;
import com.appnew.android.table.PostDataTable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Data.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u001a\u001e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007\u001a\u001e\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0007\u001a\u001e\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000eH\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u001a\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u001a\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u001a\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007\u001a\u001a\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010 H\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0007¨\u0006\""}, d2 = {"loadImage", "", ViewHierarchyConstants.VIEW_KEY, "Lde/hdodenhof/circleimageview/CircleImageView;", "url", "", "setAdapter", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "optionAdapter", "Lcom/appnew/android/feeds/adapters/OptionAdapter;", "optionWebAdapter", "Lcom/appnew/android/feeds/adapters/OptionWebAdapter;", "testResult", "", "Lcom/appnew/android/feeds/dataclass/TestResult;", "setlivetestadapter", "liveTest", "Lcom/appnew/android/home/livetest/LiveTestData;", "setliveclassadapter", "liveclasslist", "Lcom/appnew/android/feeds/dataclass/Datum;", "Lcom/makeramen/roundedimageview/RoundedImageView;", "viewlike", "Landroid/widget/TextView;", "mylike", "imagepost", "Landroid/widget/ImageView;", "imagefeedPost", "data", "Lcom/appnew/android/feeds/dataclass/Data;", "imagedetailsfeedPost", "Lcom/appnew/android/table/PostDataTable;", "date", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DataKt {
    @BindingAdapter({"imageUrl"})
    public static final void loadImage(CircleImageView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            Intrinsics.checkNotNull(Glide.with(view.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).error(R.mipmap.square_placeholder)).into(view));
        } else {
            view.setImageResource(R.mipmap.square_placeholder);
        }
    }

    @BindingAdapter({"optionadapter"})
    public static final void setAdapter(RecyclerView recyclerView, OptionAdapter optionAdapter) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (optionAdapter != null) {
            recyclerView.setAdapter(optionAdapter);
        }
    }

    @BindingAdapter({"optionwebadapter"})
    public static final void setAdapter(RecyclerView recyclerView, OptionWebAdapter optionWebAdapter) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (optionWebAdapter != null) {
            recyclerView.setAdapter(optionWebAdapter);
        }
    }

    @BindingAdapter({"livetestresult"})
    public static final void setAdapter(RecyclerView recyclerView, List<TestResult> testResult) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(testResult, "testResult");
        if (recyclerView.getAdapter() != null && (recyclerView.getAdapter() instanceof NewTestResultAdapter)) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.appnew.android.feeds.adapters.NewTestResultAdapter");
            ((NewTestResultAdapter) adapter).updateItems(testResult, recyclerView.getContext());
        } else {
            NewTestResultAdapter newTestResultAdapter = new NewTestResultAdapter();
            recyclerView.setAdapter(newTestResultAdapter);
            newTestResultAdapter.updateItems(testResult, recyclerView.getContext());
        }
    }

    @BindingAdapter({"livetest"})
    public static final void setlivetestadapter(RecyclerView recyclerView, List<? extends LiveTestData> liveTest) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(liveTest, "liveTest");
        if (recyclerView.getAdapter() != null && (recyclerView.getAdapter() instanceof NewLivetest)) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.appnew.android.feeds.adapters.NewLivetest");
            ((NewLivetest) adapter).updateItems(liveTest, recyclerView.getContext());
        } else {
            NewLivetest newLivetest = new NewLivetest();
            recyclerView.setAdapter(newLivetest);
            newLivetest.updateItems(liveTest, recyclerView.getContext());
        }
    }

    @BindingAdapter({"liveclass"})
    public static final void setliveclassadapter(RecyclerView recyclerView, List<? extends Datum> liveclasslist) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(liveclasslist, "liveclasslist");
        if (recyclerView.getAdapter() != null && (recyclerView.getAdapter() instanceof NewLiveClass)) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.appnew.android.feeds.adapters.NewLiveClass");
            ((NewLiveClass) adapter).updateItems(liveclasslist, recyclerView.getContext());
        } else {
            NewLiveClass newLiveClass = new NewLiveClass();
            recyclerView.setAdapter(newLiveClass);
            newLiveClass.updateItems(liveclasslist, recyclerView.getContext());
        }
    }

    @BindingAdapter({"linkimage"})
    public static final void loadImage(RoundedImageView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        Glide.with(view.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).error(R.mipmap.square_placeholder)).into(view);
    }

    @BindingAdapter({"likeview"})
    public static final void viewlike(TextView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (StringsKt.equals$default(str, "1", false, 2, null)) {
            view.setCompoundDrawablesWithIntrinsicBounds(com.appnew.android.R.drawable.like_active, 0, 0, 0);
        } else {
            view.setCompoundDrawablesWithIntrinsicBounds(com.appnew.android.R.drawable.like, 0, 0, 0);
        }
    }

    @BindingAdapter({"imageposturl"})
    public static final void imagepost(ImageView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            Intrinsics.checkNotNull(Glide.with(view.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).error(R.mipmap.square_placeholder)).into(view));
        } else {
            view.setImageResource(R.mipmap.square_placeholder);
        }
    }

    @BindingAdapter({"imagefeedPost"})
    public static final void imagefeedPost(ImageView view, Data data) {
        Intrinsics.checkNotNullParameter(view, "view");
        String meta_url = data != null ? data.getMeta_url() : null;
        Intrinsics.checkNotNull(meta_url);
        if (meta_url.length() > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = "16:9";
            String view_type = data.getJson().getView_type();
            if (view_type != null && Intrinsics.areEqual(view_type, "2")) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams2).dimensionRatio = "9:9";
            }
            Glide.with(view.getContext()).load(data.getMeta_url()).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).error(R.mipmap.square_placeholder)).into(view);
        }
    }

    @BindingAdapter({"imagedetailsfeedPost"})
    public static final void imagedetailsfeedPost(ImageView view, PostDataTable postDataTable) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (postDataTable == null || postDataTable.getMeta_url().length() <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = "16:9";
        String view_type = ((Json) new Gson().fromJson(postDataTable.getJson(), Json.class)).getView_type();
        if (view_type != null && Intrinsics.areEqual(view_type, "2")) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((ConstraintLayout.LayoutParams) layoutParams2).dimensionRatio = "9:16";
        }
        Glide.with(view.getContext()).load(postDataTable.getMeta_url()).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) new RequestOptions().placeholder(R.mipmap.square_placeholder).error(R.mipmap.square_placeholder)).into(view);
    }

    @BindingAdapter({"date"})
    public static final void loadImage(TextView view, String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        view.setText(new SimpleDateFormat("dd MMM, yyyy hh:mm a").format(new Date(Long.parseLong(str) * ((long) 1000))));
    }
}
