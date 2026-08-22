package com.appnew.android.Zoom.Activity;

import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Zoom.Adapter.DoubtsViewPagerAdapter;
import com.appnew.android.Zoom.Fragment.AskDoubtFragment;
import com.appnew.android.Zoom.Fragment.MyDoubtFragment;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;

/* JADX INFO: compiled from: DoubtsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "view_pager", "Landroidx/viewpager/widget/ViewPager;", "askDoubtFragment", "Lcom/appnew/android/Zoom/Fragment/AskDoubtFragment;", "alldoubtsFragment", "Lcom/appnew/android/Zoom/Activity/AllDoubtsFragment;", "myDoubtFragment", "Lcom/appnew/android/Zoom/Fragment/MyDoubtFragment;", "adapter", "Lcom/appnew/android/Zoom/Adapter/DoubtsViewPagerAdapter;", "myDBClass", "Lcom/appnew/android/Room/UtkashRoom;", "getMyDBClass", "()Lcom/appnew/android/Room/UtkashRoom;", "setMyDBClass", "(Lcom/appnew/android/Room/UtkashRoom;)V", "image_back", "Landroid/widget/ImageView;", "getImage_back", "()Landroid/widget/ImageView;", "setImage_back", "(Landroid/widget/ImageView;)V", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DoubtsActivityKt {
    private static DoubtsViewPagerAdapter adapter;
    private static AllDoubtsFragment alldoubtsFragment;
    private static AskDoubtFragment askDoubtFragment;
    private static ImageView image_back;
    private static UtkashRoom myDBClass;
    private static MyDoubtFragment myDoubtFragment;
    private static TabLayout tabLayout;
    private static ViewPager view_pager;

    public static final UtkashRoom getMyDBClass() {
        return myDBClass;
    }

    public static final void setMyDBClass(UtkashRoom utkashRoom) {
        myDBClass = utkashRoom;
    }

    public static final ImageView getImage_back() {
        return image_back;
    }

    public static final void setImage_back(ImageView imageView) {
        image_back = imageView;
    }
}
