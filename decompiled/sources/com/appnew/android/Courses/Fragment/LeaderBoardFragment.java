package com.appnew.android.Courses.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.amulyakhare.textdrawable.TextDrawable;
import com.appnew.android.Model.Courses.quiz.LeaderBoardUserModel;
import com.appnew.android.Model.Courses.quiz.ResultTestSeries;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.Network.retrofit.RetrofitResponse;
import com.eduteria.app.app.R;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class LeaderBoardFragment extends MainFragment {
    Activity activity;
    public String errorMessage;
    private TextView errorTV;
    public String frag_type = "";
    LeaderBoardAdapter leaderBoardAdapter;
    private RecyclerView leaderBoardRecyclerView;
    private TextView rankvalueTv;
    ResultTestSeries resultTestSeries;
    public String status;
    private TextView totalUserTV;

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        return null;
    }

    public static LeaderBoardFragment newInstance(String frag_type, String resultTestSeries) {
        LeaderBoardFragment leaderBoardFragment = new LeaderBoardFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Const.FRAG_TYPE, frag_type);
        bundle.putString(Const.RESULT_SCREEN, resultTestSeries);
        leaderBoardFragment.setArguments(bundle);
        return leaderBoardFragment;
    }

    @Override // com.appnew.android.Utils.Network.MainFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.frag_type = getArguments().getString(Const.FRAG_TYPE);
            this.status = getArguments().getString(Const.RESULT_SCREEN);
        }
        this.activity = getActivity();
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonobject, String apitype, String typeApi, boolean showprogress) throws JSONException {
        Gson gson = new Gson();
        apitype.hashCode();
        if (apitype.equals(API.API_GET_USER_RESULT)) {
            if (jsonobject.optString("status").equals("true")) {
                this.resultTestSeries = (ResultTestSeries) gson.fromJson(jsonobject.getJSONObject("data").toString(), ResultTestSeries.class);
                generateData();
            } else {
                RetrofitResponse.GetApiData(this.activity, jsonobject.optString("auth_code"), jsonobject.optString("message"), false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        NetworkAPICall(API.API_GET_USER_RESULT, "", true, false, false);
    }

    public void generateData() {
        this.totalUserTV.setText(this.resultTestSeries.getTotal_user_attempt());
        this.rankvalueTv.setText(this.resultTestSeries.getUser_rank());
        this.leaderBoardAdapter = new LeaderBoardAdapter(this.activity, this.resultTestSeries.getTop_list());
        this.leaderBoardRecyclerView.setLayoutManager(new LinearLayoutManager(this.activity, 1, false));
        this.leaderBoardRecyclerView.setAdapter(this.leaderBoardAdapter);
    }

    private void initViews(View view) {
        this.rankvalueTv = (TextView) view.findViewById(R.id.rankValueTV);
        this.totalUserTV = (TextView) view.findViewById(R.id.userValueTV);
        this.leaderBoardRecyclerView = (RecyclerView) view.findViewById(R.id.leaderListRV);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_leader_board, container, false);
    }

    public class LeaderBoardAdapter extends RecyclerView.Adapter<ViewHolder> {
        Context context;
        ArrayList<LeaderBoardUserModel> leaderBoardUserModelArrayList;

        public LeaderBoardAdapter(Context activity, ArrayList<LeaderBoardUserModel> top_ten_list) {
            this.context = activity;
            this.leaderBoardUserModelArrayList = top_ten_list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_people, parent, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.nameTV.setText(this.leaderBoardUserModelArrayList.get(position).getName());
            holder.specialisationTV.setText(String.format("%s %s", "Rank ", this.leaderBoardUserModelArrayList.get(position).getRank()));
            if (!TextUtils.isEmpty(this.leaderBoardUserModelArrayList.get(position).getProfile_picture())) {
                holder.userImageIV.setVisibility(0);
                holder.userImageIVText.setVisibility(8);
                Helper.setThumbnailImage(LeaderBoardFragment.this.activity, this.leaderBoardUserModelArrayList.get(position).getProfile_picture(), LeaderBoardFragment.this.activity.getResources().getDrawable(R.mipmap.default_pic), holder.userImageIV);
                return;
            }
            TextDrawable textDrawableGetDrawable = Helper.GetDrawable(this.leaderBoardUserModelArrayList.get(position).getName(), LeaderBoardFragment.this.activity, this.leaderBoardUserModelArrayList.get(position).getUser_id());
            if (textDrawableGetDrawable != null) {
                holder.userImageIV.setVisibility(8);
                holder.userImageIVText.setVisibility(0);
                holder.userImageIVText.setImageDrawable(textDrawableGetDrawable);
            } else {
                holder.userImageIV.setVisibility(0);
                holder.userImageIVText.setVisibility(8);
                holder.userImageIV.setImageResource(R.mipmap.default_pic);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.leaderBoardUserModelArrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private FrameLayout followButtonRl;
            private TextView nameTV;
            private TextView specialisationTV;
            private ImageView userImageIV;
            private ImageView userImageIVText;

            public ViewHolder(View itemView) {
                super(itemView);
                this.nameTV = (TextView) itemView.findViewById(R.id.nameTV);
                this.specialisationTV = (TextView) itemView.findViewById(R.id.specialisationTV);
                this.userImageIV = (ImageView) itemView.findViewById(R.id.imageIV);
                this.userImageIVText = (ImageView) itemView.findViewById(R.id.imageIVText);
                FrameLayout frameLayout = (FrameLayout) itemView.findViewById(R.id.followBtnRL);
                this.followButtonRl = frameLayout;
                if (frameLayout.getVisibility() == 0) {
                    this.followButtonRl.setVisibility(8);
                }
                if (this.specialisationTV.getVisibility() == 8) {
                    this.specialisationTV.setVisibility(0);
                }
            }
        }
    }
}
