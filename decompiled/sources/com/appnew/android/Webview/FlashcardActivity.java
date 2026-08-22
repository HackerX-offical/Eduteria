package com.appnew.android.Webview;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.Model.FlashData;
import com.appnew.android.Utils.EdgeToEdgeHelperOld;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class FlashcardActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    ImageView back_view;
    private Banner_ViewPager bannerViewPager;
    ArrayList<FlashData> data = new ArrayList<>();
    ImageView image_back;
    ImageView move_view;
    ProgressBar progress_value;
    TextView setProgress;
    ViewPager viewPager_Banner;

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.flash_acivity);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
            this.viewPager_Banner = (ViewPager) findViewById(R.id.viewPager_Banner);
            this.back_view = (ImageView) findViewById(R.id.back_view);
            this.move_view = (ImageView) findViewById(R.id.move_view);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            this.setProgress = (TextView) findViewById(R.id.setProgress);
            this.progress_value = (ProgressBar) findViewById(R.id.progress_value);
            View viewFindViewById = findViewById(R.id.root);
            Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
            if (Build.VERSION.SDK_INT == 36) {
                EdgeToEdgeHelperOld.applyHeaderWithToolbar(this, getWindow(), viewFindViewById, toolbar);
            }
            final JSONArray jSONArray = new JSONArray(getIntent().getStringExtra("url"));
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    FlashData flashData = new FlashData();
                    flashData.setTerms(jSONObject.getString("terms"));
                    flashData.setDescription(jSONObject.getString("description"));
                    this.data.add(flashData);
                }
                Banner_ViewPager banner_ViewPager = new Banner_ViewPager(this, this.data);
                this.bannerViewPager = banner_ViewPager;
                this.viewPager_Banner.setAdapter(banner_ViewPager);
                this.viewPager_Banner.setOffscreenPageLimit(0);
            }
            this.viewPager_Banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.appnew.android.Webview.FlashcardActivity.1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    Banner_ViewPager.is_front = false;
                    FlashcardActivity.this.setProgress.setText((position + 1) + " of " + jSONArray.length());
                    FlashcardActivity.this.progress_value.setProgress((r2 * 100) / jSONArray.length());
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    Banner_ViewPager.is_front = false;
                }
            });
            this.back_view.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.FlashcardActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onCreate$0(view);
                }
            });
            this.move_view.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.FlashcardActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (FlashcardActivity.this.data.size() - 1 == FlashcardActivity.this.viewPager_Banner.getCurrentItem()) {
                        FlashcardActivity flashcardActivity = FlashcardActivity.this;
                        Toast.makeText(flashcardActivity, flashcardActivity.getResources().getString(R.string.last_item), 0).show();
                        return;
                    }
                    int currentItem = FlashcardActivity.this.viewPager_Banner.getCurrentItem();
                    if (Banner_ViewPager.is_front) {
                        FlashcardActivity.this.bannerViewPager = null;
                        FlashcardActivity flashcardActivity2 = FlashcardActivity.this;
                        FlashcardActivity flashcardActivity3 = FlashcardActivity.this;
                        flashcardActivity2.bannerViewPager = new Banner_ViewPager(flashcardActivity3, flashcardActivity3.data);
                        FlashcardActivity.this.viewPager_Banner.setAdapter(FlashcardActivity.this.bannerViewPager);
                    }
                    FlashcardActivity.this.viewPager_Banner.setCurrentItem(currentItem + 1);
                }
            });
            this.image_back.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Webview.FlashcardActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    FlashcardActivity.this.finish();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        if (this.viewPager_Banner.getCurrentItem() == 0) {
            Toast.makeText(this, getResources().getString(R.string.first_item), 0).show();
            return;
        }
        int currentItem = this.viewPager_Banner.getCurrentItem();
        if (Banner_ViewPager.is_front) {
            this.bannerViewPager = null;
            Banner_ViewPager banner_ViewPager = new Banner_ViewPager(this, this.data);
            this.bannerViewPager = banner_ViewPager;
            this.viewPager_Banner.setAdapter(banner_ViewPager);
        }
        this.viewPager_Banner.setCurrentItem(currentItem - 1);
    }
}
