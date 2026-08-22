package com.appnew.android.ExtraClass.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Adapter.ExamPrepLayer3Adapter;
import com.appnew.android.ExtraClass.adapters.ExtraClassRVAdapter;
import com.appnew.android.databinding.FragmentExtraBinding;
import com.appnew.android.home.model.ExtraVideoType;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtraLiveFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/appnew/android/ExtraClass/Fragment/ExtraLiveFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentExtraBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentExtraBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentExtraBinding;)V", "videoTypeArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/home/model/ExtraVideoType;", "Lkotlin/collections/ArrayList;", "getVideoTypeArrayList", "()Ljava/util/ArrayList;", "setVideoTypeArrayList", "(Ljava/util/ArrayList;)V", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "adapter", "Lcom/appnew/android/Courses/Adapter/ExamPrepLayer3Adapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraLiveFragment extends Fragment {
    private ExamPrepLayer3Adapter adapter;
    public FragmentExtraBinding binding;
    private RecyclerView.LayoutManager layoutManager;
    public ArrayList<ExtraVideoType> videoTypeArrayList;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final ExtraLiveFragment newInstance(ArrayList<ExtraVideoType> arrayList) {
        return INSTANCE.newInstance(arrayList);
    }

    public final FragmentExtraBinding getBinding() {
        FragmentExtraBinding fragmentExtraBinding = this.binding;
        if (fragmentExtraBinding != null) {
            return fragmentExtraBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentExtraBinding fragmentExtraBinding) {
        Intrinsics.checkNotNullParameter(fragmentExtraBinding, "<set-?>");
        this.binding = fragmentExtraBinding;
    }

    public final ArrayList<ExtraVideoType> getVideoTypeArrayList() {
        ArrayList<ExtraVideoType> arrayList = this.videoTypeArrayList;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("videoTypeArrayList");
        return null;
    }

    public final void setVideoTypeArrayList(ArrayList<ExtraVideoType> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.videoTypeArrayList = arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Serializable serializable = requireArguments().getSerializable("video");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type java.util.ArrayList<com.appnew.android.home.model.ExtraVideoType>");
            setVideoTypeArrayList((ArrayList) serializable);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentExtraBinding.inflate(getLayoutInflater(), container, false));
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().extraFragRV.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        getBinding().extraFragRV.setAdapter(new ExtraClassRVAdapter(getContext(), getVideoTypeArrayList(), true));
    }

    /* JADX INFO: compiled from: ExtraLiveFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0007¨\u0006\n"}, d2 = {"Lcom/appnew/android/ExtraClass/Fragment/ExtraLiveFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/ExtraClass/Fragment/ExtraLiveFragment;", "videoTypeArrayList", "Ljava/util/ArrayList;", "Lcom/appnew/android/home/model/ExtraVideoType;", "Lkotlin/collections/ArrayList;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ExtraLiveFragment newInstance(ArrayList<ExtraVideoType> videoTypeArrayList) {
            Intrinsics.checkNotNullParameter(videoTypeArrayList, "videoTypeArrayList");
            new ExtraLiveFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("video", videoTypeArrayList);
            ExtraLiveFragment extraLiveFragment = new ExtraLiveFragment();
            extraLiveFragment.setArguments(bundle);
            return extraLiveFragment;
        }
    }
}
