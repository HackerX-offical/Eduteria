package com.appnew.android.Zoom.Activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.BuildConfig;
import com.appnew.android.Model.BottomSetting;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.MakeMyExam;
import com.appnew.android.Zoom.Adapter.DoubtsViewPagerAdapter;
import com.appnew.android.Zoom.Fragment.AskDoubtFragment;
import com.appnew.android.Zoom.Fragment.MyDoubtFragment;
import com.appnew.android.home.model.Menu;
import com.appnew.android.table.BottomMenuTable;
import com.appnew.android.table.ThemeSettings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DoubtsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u0010?\u001a\u000203H\u0016J\u001a\u0010@\u001a\u0004\u0018\u00010\u00112\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DJ\b\u0010K\u001a\u000203H\u0002J\u0006\u0010L\u001a\u000203R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00020*0#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R\u001a\u00106\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010/\"\u0004\b>\u00101R\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006M"}, d2 = {"Lcom/appnew/android/Zoom/Activity/DoubtsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "root_view", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRoot_view", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRoot_view", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "utkashRoom", "Lcom/appnew/android/Room/UtkashRoom;", "getUtkashRoom", "()Lcom/appnew/android/Room/UtkashRoom;", "setUtkashRoom", "(Lcom/appnew/android/Room/UtkashRoom;)V", "bottomLL", "Landroid/widget/LinearLayout;", "getBottomLL", "()Landroid/widget/LinearLayout;", "setBottomLL", "(Landroid/widget/LinearLayout;)V", "bottomSetting", "Lcom/appnew/android/Model/BottomSetting;", "getBottomSetting", "()Lcom/appnew/android/Model/BottomSetting;", "setBottomSetting", "(Lcom/appnew/android/Model/BottomSetting;)V", "main_toolbar", "Landroidx/appcompat/widget/Toolbar;", "getMain_toolbar", "()Landroidx/appcompat/widget/Toolbar;", "setMain_toolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "viewArrayList", "", "Landroid/view/View;", "getViewArrayList", "()Ljava/util/List;", "setViewArrayList", "(Ljava/util/List;)V", "bottomMenuTables", "Lcom/appnew/android/table/BottomMenuTable;", "getBottomMenuTables", "setBottomMenuTables", "isDialogShown", "", "()Z", "setDialogShown", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "backPressed", "", "getBackPressed", "()J", "setBackPressed", "(J)V", "backstatus", "getBackstatus", "setBackstatus", "onBackPressed", "initBottomView", Const.MENU, "Lcom/appnew/android/home/model/Menu;", "menuId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "setupViewPager", "goToAskDoubt", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubtsActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private long backPressed;
    private boolean backstatus;
    public LinearLayout bottomLL;
    public BottomSetting bottomSetting;
    private boolean isDialogShown;
    public Toolbar main_toolbar;
    public ConstraintLayout root_view;
    public UtkashRoom utkashRoom;
    private List<View> viewArrayList = new ArrayList();
    private List<BottomMenuTable> bottomMenuTables = new ArrayList();
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.DoubtsActivity$$ExternalSyntheticLambda1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DoubtsActivity.onClickListener$lambda$1(this.f$0, view);
        }
    };

    public final ConstraintLayout getRoot_view() {
        ConstraintLayout constraintLayout = this.root_view;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root_view");
        return null;
    }

    public final void setRoot_view(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.root_view = constraintLayout;
    }

    public final UtkashRoom getUtkashRoom() {
        UtkashRoom utkashRoom = this.utkashRoom;
        if (utkashRoom != null) {
            return utkashRoom;
        }
        Intrinsics.throwUninitializedPropertyAccessException("utkashRoom");
        return null;
    }

    public final void setUtkashRoom(UtkashRoom utkashRoom) {
        Intrinsics.checkNotNullParameter(utkashRoom, "<set-?>");
        this.utkashRoom = utkashRoom;
    }

    public final LinearLayout getBottomLL() {
        LinearLayout linearLayout = this.bottomLL;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomLL");
        return null;
    }

    public final void setBottomLL(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.bottomLL = linearLayout;
    }

    public final BottomSetting getBottomSetting() {
        BottomSetting bottomSetting = this.bottomSetting;
        if (bottomSetting != null) {
            return bottomSetting;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bottomSetting");
        return null;
    }

    public final void setBottomSetting(BottomSetting bottomSetting) {
        Intrinsics.checkNotNullParameter(bottomSetting, "<set-?>");
        this.bottomSetting = bottomSetting;
    }

    public final Toolbar getMain_toolbar() {
        Toolbar toolbar = this.main_toolbar;
        if (toolbar != null) {
            return toolbar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("main_toolbar");
        return null;
    }

    public final void setMain_toolbar(Toolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "<set-?>");
        this.main_toolbar = toolbar;
    }

    public final List<View> getViewArrayList() {
        return this.viewArrayList;
    }

    public final void setViewArrayList(List<View> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.viewArrayList = list;
    }

    public final List<BottomMenuTable> getBottomMenuTables() {
        return this.bottomMenuTables;
    }

    public final void setBottomMenuTables(List<BottomMenuTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bottomMenuTables = list;
    }

    /* JADX INFO: renamed from: isDialogShown, reason: from getter */
    public final boolean getIsDialogShown() {
        return this.isDialogShown;
    }

    public final void setDialogShown(boolean z) {
        this.isDialogShown = z;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DoubtsActivity doubtsActivity = this;
        Helper.setSystemBarLight(doubtsActivity);
        setContentView(R.layout.activity_doubts);
        Helper.enableScreenShot(doubtsActivity);
        DoubtsActivity doubtsActivity2 = this;
        setUtkashRoom(UtkashRoom.getAppDatabase(doubtsActivity2));
        DoubtsActivityKt.tabLayout = (TabLayout) findViewById(R.id.doubt_tabs);
        DoubtsActivityKt.view_pager = (ViewPager) findViewById(R.id.doubt_view_pager);
        DoubtsActivityKt.setImage_back((ImageView) findViewById(R.id.doubt_image_back));
        setRoot_view((ConstraintLayout) findViewById(R.id.root_view));
        setBottomLL((LinearLayout) findViewById(R.id.bottomLL));
        setBottomLL((LinearLayout) findViewById(R.id.bottomLL));
        setMain_toolbar((Toolbar) findViewById(R.id.main_toolbar));
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(doubtsActivity2, window, getRoot_view(), getMain_toolbar());
        }
        ViewPager viewPager = DoubtsActivityKt.view_pager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.Zoom.Activity.DoubtsActivity.onCreate.1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                }
            });
        }
        if (StringsKt.equals(BuildConfig.FLAVOR, "NavinClasses", true)) {
            ImageView image_back = DoubtsActivityKt.getImage_back();
            Intrinsics.checkNotNull(image_back);
            image_back.setVisibility(8);
        } else {
            ImageView image_back2 = DoubtsActivityKt.getImage_back();
            Intrinsics.checkNotNull(image_back2);
            image_back2.setVisibility(0);
        }
        ImageView image_back3 = DoubtsActivityKt.getImage_back();
        if (image_back3 != null) {
            image_back3.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.DoubtsActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DoubtsActivity.onCreate$lambda$0(this.f$0);
                }
            }));
        }
        TabLayout tabLayout = DoubtsActivityKt.tabLayout;
        if (tabLayout != null) {
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.appnew.android.Zoom.Activity.DoubtsActivity.onCreate.3
                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabReselected(TabLayout.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabSelected(TabLayout.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public void onTabUnselected(TabLayout.Tab tab) {
                    Intrinsics.checkNotNullParameter(tab, "tab");
                }
            });
        }
        if (StringsKt.equals("1", "7", true) && StringsKt.equals(BuildConfig.FLAVOR, "NavinClasses", true) && getUtkashRoom().getthemeSettingdao().is_setting_exit()) {
            getBottomLL().setVisibility(0);
            ThemeSettings themeSettingsData = getUtkashRoom().getthemeSettingdao().data();
            Intrinsics.checkNotNullExpressionValue(themeSettingsData, "data(...)");
            setBottomSetting((BottomSetting) new Gson().fromJson(themeSettingsData.getBottom(), BottomSetting.class));
            getBottomLL().removeAllViews();
            List<View> list = this.viewArrayList;
            if (list != null) {
                list.clear();
            }
            this.bottomMenuTables.clear();
            List<BottomMenuTable> bottomMenu = getUtkashRoom().getBottomMenuTableDao().getBottomMenu(MakeMyExam.userId);
            this.bottomMenuTables = bottomMenu;
            int size = Helper.getBottomMenu(bottomMenu).size();
            for (int i = 0; i < size; i++) {
                LinearLayout bottomLL = getBottomLL();
                Menu menu = Helper.getBottomMenu(this.bottomMenuTables).get(i);
                Intrinsics.checkNotNullExpressionValue(menu, "get(...)");
                bottomLL.addView(initBottomView(menu, "16"));
            }
        }
        setupViewPager();
        ViewPager viewPager2 = DoubtsActivityKt.view_pager;
        if (viewPager2 != null) {
            viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.Zoom.Activity.DoubtsActivity.onCreate.4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float offset, int offsetPixels) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    DoubtsViewPagerAdapter doubtsViewPagerAdapter = DoubtsActivityKt.adapter;
                    Fragment fragment = doubtsViewPagerAdapter != null ? doubtsViewPagerAdapter.getFragment(position) : null;
                    if (fragment instanceof AllDoubtsFragment) {
                        ((AllDoubtsFragment) fragment).refreshData();
                    } else if (fragment instanceof MyDoubtFragment) {
                        ((MyDoubtFragment) fragment).refreshData();
                    } else if (fragment instanceof AskDoubtFragment) {
                        ((AskDoubtFragment) fragment).refreshData();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(DoubtsActivity doubtsActivity) {
        doubtsActivity.finish();
        return Unit.INSTANCE;
    }

    public final long getBackPressed() {
        return this.backPressed;
    }

    public final void setBackPressed(long j) {
        this.backPressed = j;
    }

    public final boolean getBackstatus() {
        return this.backstatus;
    }

    public final void setBackstatus(boolean z) {
        this.backstatus = z;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.getOnBackPressedDispatcher().onBackPressed();
    }

    public final LinearLayout initBottomView(Menu menu, String menuId) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        View viewInflate = View.inflate(this, R.layout.bottom_item, null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        View viewFindViewById = linearLayout.findViewById(R.id.title);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        final ImageView imageView = (ImageView) linearLayout.findViewById(R.id.icon);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.viewUnderLine);
        textView.setText(menu.getName());
        Glide.with((FragmentActivity) this).asBitmap().load(menu.getImageUrl()).into(new CustomTarget<Bitmap>() { // from class: com.appnew.android.Zoom.Activity.DoubtsActivity.initBottomView.1
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                imageView.setImageBitmap(resource);
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 1.0f);
        layoutParams.setMargins(0, 10, 0, 0);
        layoutParams.setLayoutDirection(0);
        linearLayout.setLayoutParams(layoutParams);
        textView.setGravity(17);
        linearLayout.setTag(menu);
        this.viewArrayList.add(linearLayout);
        if (StringsKt.equals(menu.getId(), menuId, true)) {
            relativeLayout.setVisibility(0);
        }
        linearLayout.setOnClickListener(this.onClickListener);
        return linearLayout;
    }

    public final View.OnClickListener getOnClickListener() {
        return this.onClickListener;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
        this.onClickListener = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void onClickListener$lambda$1(com.appnew.android.Zoom.Activity.DoubtsActivity r17, android.view.View r18) {
        /*
            Method dump skipped, instruction units count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Zoom.Activity.DoubtsActivity.onClickListener$lambda$1(com.appnew.android.Zoom.Activity.DoubtsActivity, android.view.View):void");
    }

    private final void setupViewPager() {
        try {
            DoubtsActivityKt.adapter = new DoubtsViewPagerAdapter(getSupportFragmentManager());
            DoubtsActivityKt.alldoubtsFragment = new AllDoubtsFragment();
            DoubtsViewPagerAdapter doubtsViewPagerAdapter = DoubtsActivityKt.adapter;
            Intrinsics.checkNotNull(doubtsViewPagerAdapter);
            AllDoubtsFragment allDoubtsFragment = DoubtsActivityKt.alldoubtsFragment;
            Intrinsics.checkNotNull(allDoubtsFragment);
            String string = getResources().getString(R.string.all_doubt);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            doubtsViewPagerAdapter.addFragment(allDoubtsFragment, string);
            DoubtsActivityKt.myDoubtFragment = new MyDoubtFragment();
            DoubtsViewPagerAdapter doubtsViewPagerAdapter2 = DoubtsActivityKt.adapter;
            Intrinsics.checkNotNull(doubtsViewPagerAdapter2);
            MyDoubtFragment myDoubtFragment = DoubtsActivityKt.myDoubtFragment;
            Intrinsics.checkNotNull(myDoubtFragment);
            String string2 = getResources().getString(R.string.my_doubt);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            doubtsViewPagerAdapter2.addFragment(myDoubtFragment, string2);
            DoubtsActivityKt.askDoubtFragment = new AskDoubtFragment();
            DoubtsViewPagerAdapter doubtsViewPagerAdapter3 = DoubtsActivityKt.adapter;
            Intrinsics.checkNotNull(doubtsViewPagerAdapter3);
            AskDoubtFragment askDoubtFragment = DoubtsActivityKt.askDoubtFragment;
            Intrinsics.checkNotNull(askDoubtFragment);
            String string3 = getResources().getString(R.string.ask_doubt);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            doubtsViewPagerAdapter3.addFragment(askDoubtFragment, string3);
            ViewPager viewPager = DoubtsActivityKt.view_pager;
            Intrinsics.checkNotNull(viewPager);
            viewPager.setAdapter(DoubtsActivityKt.adapter);
            TabLayout tabLayout = DoubtsActivityKt.tabLayout;
            Intrinsics.checkNotNull(tabLayout);
            tabLayout.setupWithViewPager(DoubtsActivityKt.view_pager);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void goToAskDoubt() {
        ViewPager viewPager = DoubtsActivityKt.view_pager;
        if (viewPager != null) {
            viewPager.setCurrentItem(2);
        }
    }
}
