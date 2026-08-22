package com.appnew.android.home.Activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.Courses.Activity.CourseActivity;
import com.appnew.android.Courses.Fragment.DirectLayer3;
import com.appnew.android.Courses.Fragment.ExamPrepLayer1;
import com.appnew.android.Courses.Fragment.ExamPrepLayer2;
import com.appnew.android.Courses.Fragment.SingleStudy;
import com.appnew.android.Courses.Fragment.SingleStudy2;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Login.Fragment.SignupForm;
import com.appnew.android.Login.Fragment.changepassword;
import com.appnew.android.Login.Fragment.otpverification;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.Theme.DashboardActivityTheme2;
import com.appnew.android.Theme.DashboardActivityTheme3;
import com.appnew.android.Utils.BackHandlerHelper;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.CustomContextWrapper;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BaseABNoNavActivity extends AppCompatActivity {
    public Activity activity;
    public String apiType;
    public ImageView attemptedIV;
    ImageView back;
    public TextView cart_count;
    public RecyclerView controllerRV;
    public DrawerLayout drawer;
    public LinearLayout errorLayout;
    public ImageView filterIV;
    Fragment fragment;
    FragmentManager fragmentManager;
    public ImageView gotoCart;
    public ImageView iv_whatsapp;
    public RelativeLayout layout;
    public LinearLayout linear_gotoCart;
    public Fragment mFragment;
    public RelativeLayout mFragmentLayout;
    public NavigationView navigationView2;
    public ImageView notAttemptedIV;
    public RelativeLayout notificationLL;
    public ImageView rate;
    public RelativeLayout relative_gotoCart;
    public ImageView searchIV;
    public SearchView searchView;
    public ImageView shareIV;
    public Toolbar toolbar;
    public TextView toolbarTitleTV;
    public Button tryAgainBtn;
    public TextView tv_notification;
    public String type = "";
    boolean isBack = false;
    boolean isMoved = false;
    protected BackHandlerHelper backHandlerHelper = new BackHandlerHelper();

    static /* synthetic */ void lambda$onCreate$1(View view) {
    }

    protected abstract boolean addBackButton();

    protected abstract Fragment getFragment();

    protected abstract void initViews();

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.quiz_question_control);
        this.mFragmentLayout = (RelativeLayout) findViewById(R.id.fragment_container);
        this.layout = (RelativeLayout) findViewById(R.id.layout);
        this.errorLayout = (LinearLayout) findViewById(R.id.errorLL);
        this.searchIV = (ImageView) findViewById(R.id.searchIV);
        this.toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        TextView textView = (TextView) findViewById(R.id.toolbarTitleTV);
        this.toolbarTitleTV = textView;
        textView.setSelected(true);
        this.back = (ImageView) findViewById(R.id.image_back);
        this.tryAgainBtn = (Button) findViewById(R.id.tryAgainBtn);
        this.filterIV = (ImageView) findViewById(R.id.filterIV);
        this.shareIV = (ImageView) findViewById(R.id.shareIV);
        this.rate = (ImageView) findViewById(R.id.rate);
        this.gotoCart = (ImageView) findViewById(R.id.gotoCart);
        this.linear_gotoCart = (LinearLayout) findViewById(R.id.linear_gotoCart);
        this.relative_gotoCart = (RelativeLayout) findViewById(R.id.relative_gotoCart);
        this.cart_count = (TextView) findViewById(R.id.cart_count);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navigationView2 = (NavigationView) findViewById(R.id.nav_view2);
        this.controllerRV = (RecyclerView) findViewById(R.id.controllerRV);
        this.attemptedIV = (ImageView) findViewById(R.id.attemptedIV);
        this.notAttemptedIV = (ImageView) findViewById(R.id.notattemptedIV);
        this.tv_notification = (TextView) findViewById(R.id.tv_notification);
        this.iv_whatsapp = (ImageView) findViewById(R.id.iv_whatsapp);
        this.notificationLL = (RelativeLayout) findViewById(R.id.notificationLL);
        this.drawer.setDrawerLockMode(1);
        setSupportActionBar(this.toolbar);
        Helper.logUser(this);
        InitSearchView();
        InitFilterView();
        initViews();
        this.backHandlerHelper.setup(this, new Runnable() { // from class: com.appnew.android.home.Activity.BaseABNoNavActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onCustomBackPress();
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.BaseABNoNavActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.mFragment = getFragment();
        this.activity = CourseActivity.getInstance();
        this.tryAgainBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.BaseABNoNavActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseABNoNavActivity.lambda$onCreate$1(view);
            }
        });
        this.iv_whatsapp.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.BaseABNoNavActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Helper.openWhatsapp(BaseABNoNavActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        onCustomBackPress();
    }

    private void InitFilterView() {
        this.filterIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.BaseABNoNavActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
            }
        });
    }

    public void setToolbarTitle(String str) {
        this.toolbarTitleTV.setText(str);
    }

    public void moveFromPayment() {
        this.isMoved = true;
    }

    public void InitSearchView() {
        this.searchView = (SearchView) findViewById(R.id.sv_search);
        this.searchIV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.BaseABNoNavActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$InitSearchView$3(view);
            }
        });
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.appnew.android.home.Activity.BaseABNoNavActivity.3
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String query) {
                SharedPreference.getInstance().putString(Const.COURSE_SEARCHED_QUERY, query);
                BaseABNoNavActivity baseABNoNavActivity = BaseABNoNavActivity.this;
                baseABNoNavActivity.RefreshFragmentList(baseABNoNavActivity.getSupportFragmentManager().findFragmentById(R.id.fragment_container), true, query, false);
                Helper.closeKeyboard(BaseABNoNavActivity.this);
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String newText) {
                if (!newText.isEmpty()) {
                    return false;
                }
                BaseABNoNavActivity baseABNoNavActivity = BaseABNoNavActivity.this;
                baseABNoNavActivity.RefreshFragmentList(baseABNoNavActivity.getSupportFragmentManager().findFragmentById(R.id.fragment_container), true, "", true);
                return false;
            }
        });
        this.searchView.setSearchableInfo(((SearchManager) getSystemService(FirebaseAnalytics.Event.SEARCH)).getSearchableInfo(getComponentName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$InitSearchView$3(View view) {
        this.searchIV.setVisibility(8);
        this.shareIV.setVisibility(8);
        this.layout.setVisibility(0);
        this.toolbarTitleTV.setVisibility(8);
        final EditText editText = (EditText) this.searchView.findViewById(R.id.search_src_text);
        editText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin));
        editText.setTextColor(getResources().getColor(R.color.country_code_text_color));
        editText.setHintTextColor(getResources().getColor(R.color.black_lite));
        editText.setCursorVisible(true);
        editText.setVisibility(0);
        this.searchView.setActivated(true);
        this.searchView.setIconified(false);
        this.searchView.setIconifiedByDefault(false);
        this.searchView.setQueryHint(getResources().getString(R.string.search__));
        this.searchView.onActionViewExpanded();
        this.searchView.clearFocus();
        ImageView imageView = (ImageView) this.searchView.findViewById(R.id.search_mag_icon);
        ImageView imageView2 = (ImageView) this.searchView.findViewById(R.id.search_close_btn);
        imageView2.setColorFilter(ContextCompat.getColor(this, R.color.country_code_text_color), PorterDuff.Mode.MULTIPLY);
        imageView2.setImageResource(R.drawable.white_cross);
        imageView.setVisibility(8);
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.home.Activity.BaseABNoNavActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$InitSearchView$2(editText, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$InitSearchView$2(EditText editText, View view) {
        editText.setText("");
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        this.searchIV.setVisibility(0);
        this.layout.setVisibility(8);
        this.toolbarTitleTV.setVisibility(0);
        SharedPreference.getInstance().putString(Const.COURSE_SEARCHED_QUERY, "");
        RefreshFragmentList(getSupportFragmentManager().findFragmentById(R.id.fragment_container), true, "", true);
    }

    @Override // androidx.fragment.app.FragmentActivity
    protected void onResumeFragments() {
        super.onResumeFragments();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fragmentManager = supportFragmentManager;
        Fragment fragmentFindFragmentById = supportFragmentManager.findFragmentById(R.id.fragment_container);
        this.fragment = fragmentFindFragmentById;
        if (fragmentFindFragmentById != null) {
            this.fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            this.fragmentManager.beginTransaction().replace(R.id.fragment_container, this.fragment).addToBackStack(this.fragment.getClass().getSimpleName()).commit();
        } else if (this.mFragment != null) {
            this.fragmentManager.beginTransaction().setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            this.fragmentManager.beginTransaction().replace(R.id.fragment_container, this.mFragment).addToBackStack(this.mFragment.getClass().getSimpleName()).commit();
        }
    }

    public void changeThemeColor(String color) {
        if (!color.contains(":") || color.split(":").length <= 1) {
            return;
        }
        SharedPreference.getInstance().putString("theme_color_hai_bhai", color);
        this.toolbar.setBackgroundColor(Color.parseColor(color.split(":")[0]));
        this.searchIV.setColorFilter(Color.parseColor(color.split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.back.setColorFilter(Color.parseColor(color.split(":")[1]), PorterDuff.Mode.SRC_IN);
        this.toolbarTitleTV.setTextColor(Color.parseColor(color.split(":")[1]));
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(Color.parseColor(color.split(":")[0]));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        String simpleName = getClass().getSimpleName();
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, simpleName);
        FacebookEventLogger.logEvent(this, "Screen_Viewed", bundle);
        if (SharedPreference.getInstance().getString("theme_color_hai_bhai") == null || TextUtils.isEmpty(SharedPreference.getInstance().getString("theme_color_hai_bhai"))) {
            return;
        }
        changeThemeColor(SharedPreference.getInstance().getString("theme_color_hai_bhai"));
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != 16908332) {
            return true;
        }
        onCustomBackPress();
        return true;
    }

    public void onCustomBackPress() {
        Intent intent;
        Helper.closeKeyboard(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fragmentManager = supportFragmentManager;
        this.fragment = supportFragmentManager.findFragmentById(R.id.fragment_container);
        if (!this.searchView.isIconified()) {
            this.toolbarTitleTV.setVisibility(0);
            this.searchView.setIconified(true);
            this.searchView.onActionViewCollapsed();
            this.searchIV.setVisibility(0);
            this.layout.setVisibility(8);
            this.toolbarTitleTV.setVisibility(0);
            SharedPreference.getInstance().putString(Const.COURSE_SEARCHED_QUERY, "");
            RefreshFragmentList(this.fragment, false, "", false);
            return;
        }
        Fragment fragment = this.fragment;
        if ((fragment instanceof changepassword) || (fragment instanceof otpverification)) {
            finish();
            return;
        }
        if (fragment instanceof SingleStudy) {
            if (this.isMoved) {
                if (!"1".equalsIgnoreCase("1")) {
                    if ("1".equalsIgnoreCase("2")) {
                        intent = new Intent(this, (Class<?>) DashboardActivityTheme2.class);
                    } else {
                        intent = "1".equalsIgnoreCase("3") ? new Intent(this, (Class<?>) DashboardActivityTheme3.class) : null;
                    }
                } else if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                    intent = new Intent(this, (Class<?>) HomeActivity.class);
                } else {
                    intent = new Intent(this, (Class<?>) DashboardActivityTheme1.class);
                }
                intent.setFlags(268468224);
                startActivity(intent);
                finish();
                return;
            }
            if (((CourseActivity) this).content_master.equalsIgnoreCase("content_master002")) {
                if (this.fragmentManager.getBackStackEntryCount() > 0) {
                    this.fragmentManager.popBackStack();
                    this.isBack = true;
                    ((SingleStudy) this.fragment).reloadData();
                    if (((CourseActivity) this.activity).stopAnimationOnBackPress) {
                        overridePendingTransition(0, 0);
                        return;
                    } else {
                        finish();
                        return;
                    }
                }
                finish();
                return;
            }
            finish();
            return;
        }
        finish();
    }

    public void RefreshFragmentList(Fragment fragment, boolean isSearch, String query, boolean isCross) {
        if ((fragment instanceof ExamPrepLayer2) && isSearch) {
            ((ExamPrepLayer2) fragment).searchContent(query, isCross);
        }
        if ((fragment instanceof DirectLayer3) && isSearch) {
            ((DirectLayer3) fragment).searchContent(query);
        }
        if ((fragment instanceof SingleStudy2) && isSearch) {
            ((SingleStudy2) fragment).searchContent(query);
        }
        if ((fragment instanceof ExamPrepLayer1) && isSearch) {
            ((ExamPrepLayer1) fragment).searchContent(query);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragmentFindFragmentById instanceof SignupForm) {
            fragmentFindFragmentById.onActivityResult(requestCode, resultCode, data);
        }
    }

    protected void changeStatusBarColor(String colorName) {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        if (colorName.equalsIgnoreCase(Const.RED)) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        } else {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark4));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CustomContextWrapper.wrap(newBase, SharedPreference.getInstance().getString(Const.APP_LANGUAGE)));
    }
}
