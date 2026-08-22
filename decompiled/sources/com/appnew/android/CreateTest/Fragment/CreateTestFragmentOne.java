package com.appnew.android.CreateTest.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.BuildConfig;
import com.appnew.android.CreateTest.Activity.CreateTestActivity;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.HelperProgress;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.appnew.android.home.model.MyCourse;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class CreateTestFragmentOne extends MainFragment {
    Activity activity;
    Button backBtn;
    RelativeLayout btnpcd;
    Button buttonProceed;
    RecyclerView createTestRV;
    String frag_type;
    LinearLayout llnote;
    TextView maxCount;
    RelativeLayout no_data_found_RL;
    RelativeLayout parentLL;
    TileDataAdapter tileDataAdapter;
    TextView topText;
    private int pagecount = 1;
    ArrayList<Courselist> courselists = new ArrayList<>();

    public static CreateTestFragmentOne newInstance(String frag_type) {
        CreateTestFragmentOne createTestFragmentOne = new CreateTestFragmentOne();
        Bundle bundle = new Bundle();
        bundle.putString(Const.FRAG_TYPE, frag_type);
        createTestFragmentOne.setArguments(bundle);
        return createTestFragmentOne;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        this.buttonProceed.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentOne.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ArrayList arrayList = new ArrayList();
                for (Courselist courselist : CreateTestFragmentOne.this.courselists) {
                    if (courselist.isSelect()) {
                        arrayList.add(courselist);
                    }
                }
                if (arrayList.size() > 0) {
                    Intent intent = new Intent(CreateTestFragmentOne.this.activity, (Class<?>) CreateTestActivity.class);
                    intent.putExtra(Const.FRAG_TYPE, Const.CREATE_TEST_FRAG_TWO);
                    intent.putExtra(Const.CREATE_COURSE_DATA, arrayList);
                    CreateTestFragmentOne.this.startActivity(intent);
                    return;
                }
                if (CreateTestFragmentOne.this.courselists.size() == 0) {
                    Snackbar.make(view, CreateTestFragmentOne.this.activity.getResources().getString(R.string.no_course_found), -1).show();
                } else {
                    Snackbar.make(view, CreateTestFragmentOne.this.activity.getResources().getString(R.string.please_select_atleast_one_course), -1).show();
                }
            }
        });
    }

    private void initView(View view) {
        this.parentLL = (RelativeLayout) view.findViewById(R.id.parentLL);
        this.maxCount = (TextView) view.findViewById(R.id.maxCount);
        this.topText = (TextView) view.findViewById(R.id.topText);
        this.createTestRV = (RecyclerView) view.findViewById(R.id.createTestRV);
        this.buttonProceed = (Button) view.findViewById(R.id.buttonProceed);
        this.no_data_found_RL = (RelativeLayout) view.findViewById(R.id.no_data_found_RL);
        this.backBtn = (Button) view.findViewById(R.id.backBtn);
        this.llnote = (LinearLayout) view.findViewById(R.id.llnote);
        this.btnpcd = (RelativeLayout) view.findViewById(R.id.btnpcd);
        this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentOne.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CreateTestFragmentOne.this.activity.finish();
            }
        });
        RefreshDataList();
    }

    private void RefreshDataList() {
        Helper.showProgressDialog(getActivity());
        NetworkAPICall(API.API_CREATE_TEST_RETRIVE_COURSE, "", false, false, false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_test_one, container, false);
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        apitype.hashCode();
        if (!apitype.equals(API.API_CREATE_TEST_RETRIVE_COURSE)) {
            return null;
        }
        return service.API_CREATE_TEST_RETRIVE_COURSE(AES.encrypt(new Gson().toJson(new EncryptionData())));
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        int size;
        apitype.hashCode();
        if (apitype.equals(API.API_CREATE_TEST_RETRIVE_COURSE)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonobject.optString("status").equals("true")) {
                    MyCourse myCourse = (MyCourse) new Gson().fromJson(jsonobject.toString(), MyCourse.class);
                    if (myCourse.getData().size() > 0) {
                        ArrayList<Courselist> arrayList = new ArrayList<>();
                        this.courselists = arrayList;
                        arrayList.clear();
                        this.createTestRV.setVisibility(0);
                        this.no_data_found_RL.setVisibility(8);
                        this.btnpcd.setVisibility(0);
                        this.llnote.setVisibility(0);
                        if (myCourse.getData().size() > 0) {
                            if (this.pagecount == 1) {
                                this.courselists.clear();
                                this.courselists.addAll(myCourse.getData());
                                size = 0;
                            } else {
                                size = this.courselists.size();
                                this.courselists.addAll(myCourse.getData());
                            }
                            if (this.pagecount == 1) {
                                this.tileDataAdapter = new TileDataAdapter(getActivity(), this.courselists);
                                if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
                                    this.createTestRV.setLayoutManager(new GridLayoutManager((Context) getActivity(), 2, 1, false));
                                } else {
                                    this.createTestRV.setLayoutManager(new LinearLayoutManager(getActivity()));
                                }
                                this.createTestRV.setAdapter(this.tileDataAdapter);
                                this.createTestRV.setNestedScrollingEnabled(false);
                                return;
                            }
                            this.tileDataAdapter.notifyItemRangeInserted(size, this.courselists.size() - size);
                            return;
                        }
                        return;
                    }
                    ArrayList<Courselist> arrayList2 = this.courselists;
                    if (arrayList2 == null || this.pagecount != 1) {
                        return;
                    }
                    arrayList2.clear();
                    this.createTestRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    this.btnpcd.setVisibility(8);
                    this.llnote.setVisibility(8);
                    return;
                }
                ArrayList<Courselist> arrayList3 = this.courselists;
                if (arrayList3 != null && this.pagecount == 1) {
                    arrayList3.clear();
                    this.createTestRV.setVisibility(8);
                    this.no_data_found_RL.setVisibility(0);
                    this.btnpcd.setVisibility(8);
                    this.llnote.setVisibility(8);
                }
                if (jsonobject.has("auth_code")) {
                    RetrofitResponse.GetApiData(getActivity(), jsonobject.has("auth_code") ? jsonobject.getString("auth_code") : "", jsonobject.getString("message"), false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        Helper.dismissProgressDialog();
        RecyclerView recyclerView = this.createTestRV;
        if (recyclerView == null || this.no_data_found_RL == null) {
            return;
        }
        recyclerView.setVisibility(8);
        this.no_data_found_RL.setVisibility(0);
        this.btnpcd.setVisibility(8);
        this.llnote.setVisibility(8);
    }

    public class TileDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Activity activity;
        ArrayList<Courselist> courseDataArrayList;

        public TileDataAdapter(Activity activity, ArrayList<Courselist> courseDataArrayList) {
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
            boolean z;
            Iterator<Courselist> it = CreateTestFragmentOne.this.courselists.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().isSelect()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Courselist courselist : CreateTestFragmentOne.this.courselists) {
                if (courselist.isSelect()) {
                    arrayList.add(courselist);
                }
            }
            if (arrayList.size() > 0) {
                CreateTestFragmentOne.this.topText.setText(arrayList.size() + this.activity.getResources().getString(R.string.courses_selected));
            } else {
                CreateTestFragmentOne.this.topText.setText(this.activity.getResources().getString(R.string.select_single_or_multiple_courses_s));
            }
            if (z) {
                buttonProceed.setBackground(this.activity.getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
                buttonProceed.setTextColor(ContextCompat.getColor(this.activity, R.color.whiteApp));
            } else {
                buttonProceed.setBackground(this.activity.getResources().getDrawable(R.drawable.common_round_corners_button_drawable));
                buttonProceed.setTextColor(ContextCompat.getColor(this.activity, R.color.country_code_text_color));
            }
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

            public void setData(final Courselist course, int position) {
                int screenWidth;
                if (BuildConfig.FLAVOR.equalsIgnoreCase("utkarsh")) {
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
                }
                CreateTestFragmentOne.this.maxCount.setText(TileDataAdapter.this.activity.getResources().getString(R.string.max) + TileDataAdapter.this.courseDataArrayList.size() + ")");
                if (course.isSelect()) {
                    this.checkIV.setVisibility(0);
                    this.tileRL.setBackground(TileDataAdapter.this.activity.getResources().getDrawable(R.drawable.border_select_course));
                    this.checkIV.setImageResource(R.mipmap.check_act);
                } else {
                    this.tileRL.setBackground(null);
                    this.checkIV.setVisibility(4);
                    this.checkIV.setImageResource(R.mipmap.check_def);
                }
                if (!TextUtils.isEmpty(course.getColorCode())) {
                    this.videoplayerRL.setBackgroundColor(Color.parseColor(course.getColorCode()));
                }
                if (!TextUtils.isEmpty(course.getDescHeaderImage())) {
                    Helper.setThumbnailImage(TileDataAdapter.this.activity, course.getDescHeaderImage(), TileDataAdapter.this.activity.getResources().getDrawable(R.mipmap.placeholder), this.videoImage);
                } else {
                    this.videoImage.setImageResource(R.mipmap.placeholder);
                }
                this.titleTV.setText(course.getTitle());
                this.tileRL.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.CreateTest.Fragment.CreateTestFragmentOne.TileDataAdapter.MyViewHodler.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (course.isSelect()) {
                            course.setSelect(false);
                            MyViewHodler.this.checkIV.setVisibility(0);
                            MyViewHodler.this.tileRL.setBackground(TileDataAdapter.this.activity.getResources().getDrawable(R.drawable.border_select_course));
                            MyViewHodler.this.checkIV.setImageResource(R.mipmap.check_act);
                        } else {
                            course.setSelect(true);
                            MyViewHodler.this.tileRL.setBackground(null);
                            MyViewHodler.this.checkIV.setVisibility(4);
                            MyViewHodler.this.checkIV.setImageResource(R.mipmap.check_def);
                        }
                        TileDataAdapter.this.notifyDataSetChanged();
                        TileDataAdapter.this.checkProceedButton(CreateTestFragmentOne.this.buttonProceed);
                    }
                });
            }
        }
    }
}
