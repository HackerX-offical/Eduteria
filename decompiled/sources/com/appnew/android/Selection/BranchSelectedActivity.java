package com.appnew.android.Selection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.HelperProgress;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.pojo.Userinfo.IntitutePojo.IntituteData;
import com.appnew.android.pojo.Userinfo.IntitutePojo.IntituteDataInfo;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class BranchSelectedActivity extends AppCompatActivity implements NetworkCall.MyNetworkCallBack {
    IntituteData SelectedIntituteData;
    Button backBtn;
    Button buttonProceed;
    RecyclerView createTestRV;
    String frag_type;
    ImageView image_back;
    NetworkCall networkCall;
    RelativeLayout no_data_found_RL;
    boolean selected = false;
    ArrayList<IntituteData> intituteDataArrayList = new ArrayList<>();

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_branch_selected);
        try {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            this.createTestRV = (RecyclerView) findViewById(R.id.createTestRV);
            this.buttonProceed = (Button) findViewById(R.id.buttonProceed);
            this.image_back = (ImageView) findViewById(R.id.image_back);
            this.no_data_found_RL = (RelativeLayout) findViewById(R.id.no_data_found_RL);
            this.backBtn = (Button) findViewById(R.id.backBtn);
            this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Selection.BranchSelectedActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$0();
                }
            }));
            this.backBtn.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Selection.BranchSelectedActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onCreate$1();
                }
            }));
            this.buttonProceed.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Selection.BranchSelectedActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    Iterator<IntituteData> it = BranchSelectedActivity.this.intituteDataArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        IntituteData next = it.next();
                        if (next.isExpand()) {
                            BranchSelectedActivity.this.selected = true;
                            SharedPreference.getInstance().setIntitute(next);
                            SharedPreference.getInstance().putString(Const.APP_ID, next.getId());
                            break;
                        }
                    }
                    if (BranchSelectedActivity.this.selected) {
                        Intent intent = new Intent(BranchSelectedActivity.this, Helper.setSignInActivity());
                        intent.putExtra("type", Const.SIGNIN);
                        intent.putExtra(Const.OPEN_WITH, "user");
                        intent.putExtra(Const.SOCIAL_TYPE, "1");
                        intent.putExtra(Const.SHARE_TYPE, Const.FEEDS);
                        intent.setFlags(335544320);
                        BranchSelectedActivity.this.startActivity(intent);
                        BranchSelectedActivity.this.finish();
                        return;
                    }
                    BranchSelectedActivity branchSelectedActivity = BranchSelectedActivity.this;
                    Toast.makeText(branchSelectedActivity, branchSelectedActivity.getResources().getString(R.string.please_select_atleast_one_institute), 0).show();
                }
            });
            NetworkCall networkCall = new NetworkCall(this, this);
            this.networkCall = networkCall;
            networkCall.NetworkAPICall(API.get_child_app_details, "", true, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        Helper.backButtonClick(this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$1() {
        Helper.backButtonClick(this);
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (apitype.equals(API.get_child_app_details)) {
            return service.get_child_app_details();
        }
        return null;
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
        apitype.hashCode();
        if (apitype.equals(API.get_child_app_details)) {
            try {
                if (jsonstring.optString("status").equals("true")) {
                    IntituteDataInfo intituteDataInfo = (IntituteDataInfo) new Gson().fromJson(jsonstring.toString(), IntituteDataInfo.class);
                    if (intituteDataInfo.getData().size() > 0) {
                        this.intituteDataArrayList = new ArrayList<>();
                        this.createTestRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                        this.intituteDataArrayList.addAll(intituteDataInfo.getData());
                        TileDataAdapter tileDataAdapter = new TileDataAdapter(this, this.intituteDataArrayList);
                        this.createTestRV.setLayoutManager(new GridLayoutManager((Context) this, 2, 1, false));
                        this.createTestRV.setAdapter(tileDataAdapter);
                        this.createTestRV.setNestedScrollingEnabled(false);
                        return;
                    }
                    this.createTestRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    return;
                }
                this.no_data_found_RL.setVisibility(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class TileDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Activity activity;
        ArrayList<IntituteData> courseDataArrayList;

        public TileDataAdapter(Activity activity, ArrayList<IntituteData> courseDataArrayList) {
            this.activity = activity;
            this.courseDataArrayList = courseDataArrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHodler(LayoutInflater.from(this.activity).inflate(R.layout.create_test_course_item_adapter, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHodler) holder).setData(this.courseDataArrayList.get(position), position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.courseDataArrayList.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkProceedButton(Button buttonProceed) {
            Iterator<IntituteData> it = BranchSelectedActivity.this.intituteDataArrayList.iterator();
            while (it.hasNext()) {
                if (it.next().isExpand()) {
                    buttonProceed.setBackground(this.activity.getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
                    buttonProceed.setTextColor(ContextCompat.getColor(this.activity, R.color.whiteApp));
                    return;
                }
            }
            buttonProceed.setBackground(this.activity.getResources().getDrawable(R.drawable.bg_round_corners_button_fade));
            buttonProceed.setTextColor(ContextCompat.getColor(this.activity, R.color.country_code_text_color));
        }

        public class MyViewHodler extends RecyclerView.ViewHolder {
            ImageView checkIV;
            LinearLayout tileRL;
            TextView titleTV;
            ImageView videoImage;
            RelativeLayout videoplayerRL;

            public MyViewHodler(View itemView) {
                super(itemView);
                this.videoImage = (ImageView) itemView.findViewById(R.id.ibt_single_vd_iv);
                this.checkIV = (ImageView) itemView.findViewById(R.id.checkIV);
                this.titleTV = (TextView) itemView.findViewById(R.id.title);
                this.videoplayerRL = (RelativeLayout) itemView.findViewById(R.id.videoplayerRL);
                this.tileRL = (LinearLayout) itemView.findViewById(R.id.tileRL);
            }

            public void collapseunitList(int position) {
                for (int i = 0; i < BranchSelectedActivity.this.intituteDataArrayList.size(); i++) {
                    if (i != position) {
                        BranchSelectedActivity.this.intituteDataArrayList.get(i).setExpand(false);
                    }
                }
                TileDataAdapter.this.notifyDataSetChanged();
            }

            public void setData(final IntituteData course, final int position) {
                int screenWidth;
                int screenWidth2 = HelperProgress.getScreenWidth() / 2;
                boolean z = (TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 4;
                if ((TileDataAdapter.this.activity.getResources().getConfiguration().screenLayout & 15) == 3) {
                    screenWidth = HelperProgress.getScreenWidth() / 2;
                } else if (z) {
                    screenWidth = (HelperProgress.getScreenWidth() / 2) + 300;
                } else {
                    screenWidth = (HelperProgress.getScreenWidth() / 2) + 100;
                }
                this.videoImage.setLayoutParams(new RelativeLayout.LayoutParams(screenWidth2, screenWidth));
                this.videoImage.setClipToOutline(true);
                if (BranchSelectedActivity.this.intituteDataArrayList.get(position).isExpand()) {
                    this.checkIV.setVisibility(0);
                    this.tileRL.setBackground(TileDataAdapter.this.activity.getResources().getDrawable(R.drawable.border_select_course));
                    this.checkIV.setImageResource(R.mipmap.check_act);
                } else {
                    this.tileRL.setBackground(null);
                    this.checkIV.setVisibility(4);
                    this.checkIV.setImageResource(R.mipmap.check_def);
                }
                if (!TextUtils.isEmpty(course.getLogo())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getLogo(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.book_placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.book_placeholder);
                }
                this.titleTV.setText(course.getTitle());
                this.tileRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Selection.BranchSelectedActivity.TileDataAdapter.MyViewHodler.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (BranchSelectedActivity.this.intituteDataArrayList.get(position).isExpand()) {
                            BranchSelectedActivity.this.intituteDataArrayList.get(position).setExpand(false);
                            MyViewHodler.this.checkIV.setVisibility(0);
                            MyViewHodler.this.tileRL.setBackground(TileDataAdapter.this.activity.getResources().getDrawable(R.drawable.border_select_course));
                            MyViewHodler.this.checkIV.setImageResource(R.mipmap.check_act);
                        } else {
                            BranchSelectedActivity.this.intituteDataArrayList.get(position).setExpand(true);
                            MyViewHodler.this.tileRL.setBackground(null);
                            MyViewHodler.this.checkIV.setVisibility(4);
                            MyViewHodler.this.checkIV.setImageResource(R.mipmap.check_def);
                        }
                        MyViewHodler.this.collapseunitList(position);
                        TileDataAdapter.this.checkProceedButton(BranchSelectedActivity.this.buttonProceed);
                    }
                });
            }
        }
    }
}
