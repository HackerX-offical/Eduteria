package com.appnew.android.Coupon.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.Coupon.Fragments.AvailableCouponFragment;
import com.appnew.android.Coupon.Fragments.ExpiredCouponFragment;
import com.appnew.android.Coupon.Fragments.RedeemedCouponFragment;
import com.appnew.android.Coupon.Models.CouponPojo;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Room.UtkashRoom;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CouponActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    private CouponViewPagerAdapter adapter;
    private AvailableCouponFragment availableCouponFragment;
    public CouponPojo couponPojo;
    private ExpiredCouponFragment expiredCouponFragment;
    ImageView image_back;
    public UtkashRoom myDBClass;
    NetworkCall networkCall;
    private RedeemedCouponFragment redeemedCouponFragment;
    public int stackPlace = -1;
    private TabLayout tabLayout;
    private ViewPager view_pager;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_coupon);
        Helper.enableScreenShot(this);
        fetchData();
        this.tabLayout = (TabLayout) findViewById(R.id.tabs);
        this.view_pager = (ViewPager) findViewById(R.id.view_pager);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        View viewFindViewById = findViewById(R.id.root);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        if (Build.VERSION.SDK_INT == 36) {
            EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
        }
        this.view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.Coupon.Activity.CouponActivity.1
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
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Coupon.Activity.CouponActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        this.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.appnew.android.Coupon.Activity.CouponActivity.2
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    public void fetchData() {
        NetworkCall networkCall = new NetworkCall(this, this);
        this.networkCall = networkCall;
        networkCall.NetworkAPICall(API.API_GET_COUPON, "", true, false);
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        if (apitype.equalsIgnoreCase(API.API_GET_COUPON)) {
            return service.API_GET_COUPON("");
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        if (jsonstring.getString("status").equalsIgnoreCase("true")) {
            JSONObject jSONObjectOptJSONObject = jsonstring.optJSONObject("data");
            if (jSONObjectOptJSONObject != null) {
                this.couponPojo = (CouponPojo) new Gson().fromJson(jSONObjectOptJSONObject.toString(), CouponPojo.class);
            }
            setupViewPager();
            return;
        }
        RetrofitResponse.GetApiData(this, jsonstring.has("auth_code") ? jsonstring.getString("auth_code") : "", jsonstring.getString("message"), false);
    }

    public class CouponViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList;
        private final List<String> mFragmentTitleList;

        public CouponViewPagerAdapter(FragmentManager fm) {
            super(fm);
            this.mFragmentList = new ArrayList();
            this.mFragmentTitleList = new ArrayList();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return this.mFragmentList.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            this.mFragmentList.add(fragment);
            this.mFragmentTitleList.add(title);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return this.mFragmentTitleList.get(position);
        }
    }

    private void setupViewPager() {
        try {
            Bundle bundle = new Bundle();
            bundle.putSerializable(Const.COUPON_DATA, this.couponPojo);
            this.adapter = new CouponViewPagerAdapter(getSupportFragmentManager());
            AvailableCouponFragment availableCouponFragment = new AvailableCouponFragment();
            this.availableCouponFragment = availableCouponFragment;
            availableCouponFragment.setArguments(bundle);
            this.adapter.addFragment(this.availableCouponFragment, getResources().getString(R.string.available));
            RedeemedCouponFragment redeemedCouponFragment = new RedeemedCouponFragment();
            this.redeemedCouponFragment = redeemedCouponFragment;
            redeemedCouponFragment.setArguments(bundle);
            this.adapter.addFragment(this.redeemedCouponFragment, getResources().getString(R.string.redeemed));
            ExpiredCouponFragment expiredCouponFragment = new ExpiredCouponFragment();
            this.expiredCouponFragment = expiredCouponFragment;
            expiredCouponFragment.setArguments(bundle);
            this.adapter.addFragment(this.expiredCouponFragment, getResources().getString(R.string.expired_));
            this.view_pager.setAdapter(this.adapter);
            this.tabLayout.setupWithViewPager(this.view_pager);
            int i = this.stackPlace;
            if (i != -1) {
                this.view_pager.setCurrentItem(i);
                this.stackPlace = -1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.myDBClass == null) {
            UtkashRoom appDatabase = UtkashRoom.getAppDatabase(this);
            this.myDBClass = appDatabase;
            appDatabase.getOpenHelper().getWritableDatabase().enableWriteAheadLogging();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.myDBClass = null;
    }
}
