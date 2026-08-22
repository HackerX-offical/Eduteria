package com.appnew.android.Zoom.Activity;

import Zoom.Fragment.PdfBookMark;
import Zoom.Fragment.QuestionBookMark;
import Zoom.Fragment.VideoBookMark;
import android.app.SearchManager;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.databinding.ActivityBookMarkListBinding;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BookMarkList.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/Zoom/Activity/BookMarkList;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityBookMarkListBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityBookMarkListBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityBookMarkListBinding;)V", "pdfBookMark", "LZoom/Fragment/PdfBookMark;", "VideoBookMark", "LZoom/Fragment/VideoBookMark;", "questionBookMark", "LZoom/Fragment/QuestionBookMark;", "adapter", "Lcom/appnew/android/Zoom/Activity/BookMarkList$BookMarkViewPagerAdapter;", "page", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupViewPager", "initSearchView", "onSearchCancel", "v1", "Landroid/view/View;", "onBackPressed", "BookMarkViewPagerAdapter", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BookMarkList extends AppCompatActivity {
    public static final int $stable = 8;
    private VideoBookMark VideoBookMark;
    private BookMarkViewPagerAdapter adapter;
    public ActivityBookMarkListBinding binding;
    private int page;
    private PdfBookMark pdfBookMark;
    private QuestionBookMark questionBookMark;

    public final ActivityBookMarkListBinding getBinding() {
        ActivityBookMarkListBinding activityBookMarkListBinding = this.binding;
        if (activityBookMarkListBinding != null) {
            return activityBookMarkListBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityBookMarkListBinding activityBookMarkListBinding) {
        Intrinsics.checkNotNullParameter(activityBookMarkListBinding, "<set-?>");
        this.binding = activityBookMarkListBinding;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BookMarkList bookMarkList = this;
        Helper.setSystemBarLight(bookMarkList);
        setBinding(ActivityBookMarkListBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.enableScreenShot(bookMarkList);
        initSearchView();
        if (Build.VERSION.SDK_INT == 36) {
            Window window = getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            ConstraintLayout root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            Toolbar mainToolbar = getBinding().mainToolbar;
            Intrinsics.checkNotNullExpressionValue(mainToolbar, "mainToolbar");
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, window, root, mainToolbar);
        }
        getBinding().bookMarkViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.Zoom.Activity.BookMarkList.onCreate.1
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
        getBinding().bookMarkBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Zoom.Activity.BookMarkList$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BookMarkList.onCreate$lambda$0(this.f$0);
            }
        }));
        getBinding().bookMarkTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.appnew.android.Zoom.Activity.BookMarkList.onCreate.3
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                Intrinsics.checkNotNullParameter(tab, "tab");
                BookMarkList.this.page = tab.getPosition();
                int i = BookMarkList.this.page;
                if (i == 0) {
                    QuestionBookMark questionBookMark = BookMarkList.this.questionBookMark;
                    if (questionBookMark != null) {
                        questionBookMark.refreshPage();
                    }
                    BookMarkList bookMarkList2 = BookMarkList.this;
                    View rootView = bookMarkList2.getWindow().getDecorView().getRootView();
                    Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
                    bookMarkList2.onSearchCancel(rootView);
                    return;
                }
                if (i != 1) {
                    VideoBookMark videoBookMark = BookMarkList.this.VideoBookMark;
                    if (videoBookMark != null) {
                        videoBookMark.refreshPage();
                    }
                    BookMarkList bookMarkList3 = BookMarkList.this;
                    View rootView2 = bookMarkList3.getWindow().getDecorView().getRootView();
                    Intrinsics.checkNotNullExpressionValue(rootView2, "getRootView(...)");
                    bookMarkList3.onSearchCancel(rootView2);
                    return;
                }
                PdfBookMark pdfBookMark = BookMarkList.this.pdfBookMark;
                if (pdfBookMark != null) {
                    pdfBookMark.refreshPage();
                }
                BookMarkList bookMarkList4 = BookMarkList.this;
                View rootView3 = bookMarkList4.getWindow().getDecorView().getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView3, "getRootView(...)");
                bookMarkList4.onSearchCancel(rootView3);
            }
        });
        setupViewPager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(BookMarkList bookMarkList) {
        bookMarkList.finish();
        return Unit.INSTANCE;
    }

    private final void setupViewPager() {
        try {
            this.adapter = new BookMarkViewPagerAdapter(getSupportFragmentManager());
            this.questionBookMark = new QuestionBookMark();
            BookMarkViewPagerAdapter bookMarkViewPagerAdapter = this.adapter;
            Intrinsics.checkNotNull(bookMarkViewPagerAdapter);
            QuestionBookMark questionBookMark = this.questionBookMark;
            Intrinsics.checkNotNull(questionBookMark);
            String string = getResources().getString(R.string.question);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            bookMarkViewPagerAdapter.addFragment(questionBookMark, string);
            this.pdfBookMark = new PdfBookMark();
            BookMarkViewPagerAdapter bookMarkViewPagerAdapter2 = this.adapter;
            Intrinsics.checkNotNull(bookMarkViewPagerAdapter2);
            PdfBookMark pdfBookMark = this.pdfBookMark;
            Intrinsics.checkNotNull(pdfBookMark);
            String string2 = getResources().getString(R.string.pdf);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            bookMarkViewPagerAdapter2.addFragment(pdfBookMark, string2);
            this.VideoBookMark = new VideoBookMark();
            BookMarkViewPagerAdapter bookMarkViewPagerAdapter3 = this.adapter;
            Intrinsics.checkNotNull(bookMarkViewPagerAdapter3);
            VideoBookMark videoBookMark = this.VideoBookMark;
            Intrinsics.checkNotNull(videoBookMark);
            String string3 = getResources().getString(R.string.video_);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            bookMarkViewPagerAdapter3.addFragment(videoBookMark, string3);
            getBinding().bookMarkViewPager.setAdapter(this.adapter);
            getBinding().bookMarkTabs.setupWithViewPager(getBinding().bookMarkViewPager);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: compiled from: BookMarkList.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/appnew/android/Zoom/Activity/BookMarkList$BookMarkViewPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "mFragmentList", "", "Landroidx/fragment/app/Fragment;", "mFragmentTitleList", "", "getItem", Const.POSITION, "", "getCount", "addFragment", "", "fragment", "title", "getPageTitle", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BookMarkViewPagerAdapter extends FragmentPagerAdapter {
        public static final int $stable = 8;
        private final List<Fragment> mFragmentList;
        private final List<String> mFragmentTitleList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BookMarkViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            Intrinsics.checkNotNull(fragmentManager);
            this.mFragmentList = new ArrayList();
            this.mFragmentTitleList = new ArrayList();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return this.mFragmentList.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* JADX INFO: renamed from: getCount */
        public int getTotalTabs() {
            return this.mFragmentList.size();
        }

        public final void addFragment(Fragment fragment, String title) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(title, "title");
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(title);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return this.mFragmentTitleList.get(position);
        }
    }

    private final void initSearchView() {
        getBinding().searchIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.BookMarkList$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookMarkList.initSearchView$lambda$2(this.f$0, view);
            }
        });
        getBinding().svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.appnew.android.Zoom.Activity.BookMarkList.initSearchView.2
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                SharedPreference.getInstance().putString(Const.COURSE_SEARCHED_QUERY, query);
                int i = BookMarkList.this.page;
                if (i == 0) {
                    QuestionBookMark questionBookMark = BookMarkList.this.questionBookMark;
                    if (questionBookMark != null) {
                        questionBookMark.searchQuery(query);
                    }
                } else if (i != 1) {
                    VideoBookMark videoBookMark = BookMarkList.this.VideoBookMark;
                    if (videoBookMark != null) {
                        videoBookMark.searchQuery(query);
                    }
                } else {
                    PdfBookMark pdfBookMark = BookMarkList.this.pdfBookMark;
                    if (pdfBookMark != null) {
                        pdfBookMark.searchQuery(query);
                    }
                }
                Helper.closeKeyboard(BookMarkList.this);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                int i = BookMarkList.this.page;
                if (i == 0) {
                    QuestionBookMark questionBookMark = BookMarkList.this.questionBookMark;
                    if (questionBookMark == null) {
                        return false;
                    }
                    questionBookMark.searchQuery(query);
                    return false;
                }
                if (i != 1) {
                    VideoBookMark videoBookMark = BookMarkList.this.VideoBookMark;
                    if (videoBookMark == null) {
                        return false;
                    }
                    videoBookMark.searchQuery(query);
                    return false;
                }
                PdfBookMark pdfBookMark = BookMarkList.this.pdfBookMark;
                if (pdfBookMark == null) {
                    return false;
                }
                pdfBookMark.searchQuery(query);
                return false;
            }
        });
        Object systemService = getSystemService(FirebaseAnalytics.Event.SEARCH);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.SearchManager");
        getBinding().svSearch.setSearchableInfo(((SearchManager) systemService).getSearchableInfo(getComponentName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSearchView$lambda$2(final BookMarkList bookMarkList, View view) {
        bookMarkList.getBinding().searchIV.setVisibility(8);
        bookMarkList.getBinding().layout.setVisibility(0);
        bookMarkList.getBinding().toolbarTitleTV.setVisibility(8);
        View viewFindViewById = bookMarkList.getBinding().svSearch.findViewById(R.id.search_src_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        EditText editText = (EditText) viewFindViewById;
        editText.setTextSize(0, bookMarkList.getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin));
        editText.setTextColor(bookMarkList.getResources().getColor(R.color.country_code_text_color));
        editText.setHintTextColor(bookMarkList.getResources().getColor(R.color.black_lite));
        editText.setCursorVisible(true);
        bookMarkList.getBinding().svSearch.setActivated(true);
        bookMarkList.getBinding().svSearch.setIconified(false);
        bookMarkList.getBinding().svSearch.setIconifiedByDefault(false);
        bookMarkList.getBinding().svSearch.setQueryHint(bookMarkList.getResources().getString(R.string.search__));
        bookMarkList.getBinding().svSearch.onActionViewExpanded();
        bookMarkList.getBinding().svSearch.clearFocus();
        View viewFindViewById2 = bookMarkList.getBinding().svSearch.findViewById(R.id.search_mag_icon);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        View viewFindViewById3 = bookMarkList.getBinding().svSearch.findViewById(R.id.search_close_btn);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) viewFindViewById3;
        imageView.setColorFilter(ContextCompat.getColor(bookMarkList, R.color.country_code_text_color), PorterDuff.Mode.MULTIPLY);
        imageView.setImageResource(R.drawable.white_cross);
        ((ImageView) viewFindViewById2).setVisibility(8);
        Object systemService = bookMarkList.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).toggleSoftInput(2, 0);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Zoom.Activity.BookMarkList$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BookMarkList.initSearchView$lambda$2$lambda$1(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSearchView$lambda$2$lambda$1(BookMarkList bookMarkList, View v1) {
        Intrinsics.checkNotNullParameter(v1, "v1");
        bookMarkList.onSearchCancel(v1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSearchCancel(View v1) {
        getBinding().searchIV.setVisibility(0);
        getBinding().layout.setVisibility(8);
        getBinding().toolbarTitleTV.setVisibility(0);
        View viewFindViewById = getBinding().svSearch.findViewById(R.id.search_src_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ((EditText) viewFindViewById).setText("");
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(v1.getWindowToken(), 0);
        int i = this.page;
        if (i == 0) {
            QuestionBookMark questionBookMark = this.questionBookMark;
            if (questionBookMark != null) {
                questionBookMark.searchQuery("");
            }
        } else if (i == 1) {
            PdfBookMark pdfBookMark = this.pdfBookMark;
            if (pdfBookMark != null) {
                pdfBookMark.searchQuery("");
            }
        } else {
            VideoBookMark videoBookMark = this.VideoBookMark;
            if (videoBookMark != null) {
                videoBookMark.searchQuery("");
            }
        }
        Helper.closeKeyboard(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!getBinding().svSearch.isIconified()) {
            getBinding().toolbarTitleTV.setVisibility(0);
            getBinding().svSearch.setIconified(true);
            getBinding().svSearch.onActionViewCollapsed();
            getBinding().searchIV.setVisibility(0);
            getBinding().layout.setVisibility(8);
            return;
        }
        super.onBackPressed();
    }
}
