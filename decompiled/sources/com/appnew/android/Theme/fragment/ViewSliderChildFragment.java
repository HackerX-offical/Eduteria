package com.appnew.android.Theme.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Response.Registration.StreamResponse;
import com.appnew.android.Theme.Adapter.IBTPracticeRV2Adapter;
import com.appnew.android.Theme.DashboardActivityTheme8;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.MainFragment;
import com.appnew.android.Utils.SpacingItemDecoration;
import com.appnew.android.home.interfaces.IOnCourseClickListener;
import com.appnew.android.table.CourseTypeMasterTable;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: loaded from: classes6.dex */
public class ViewSliderChildFragment extends MainFragment implements IOnCourseClickListener {
    private static IOnCourseClickListener iOnCourseClickListener1;
    Activity activity;
    IBTPracticeRV2Adapter adapter2;
    CardView cardView;
    String cat;
    private ArrayList<CourseTypeMasterTable> coursesDataArrayList;
    String id;
    boolean isProgress;
    RelativeLayout mainParentLL;
    private int position;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    private StreamResponse streamResponse;
    String subCat;
    String title;
    View view;

    public void ErrorCallBack(String jsonstring, String apitype) {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
    }

    public void RVscrollTo(int pos, ArrayList<CourseTypeMasterTable> courselists, String cat_id, String course_type) {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public void SuccessCallBack(JSONObject jsonstring, String apitype, String typeApi, boolean showprogress) throws JSONException {
    }

    @Override // com.appnew.android.Utils.Network.MainFragment
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        return null;
    }

    @Override // com.appnew.android.home.interfaces.IOnCourseClickListener
    public void onCourseItemClick(CourseTypeMasterTable courseTypeMasterTable, int position) {
    }

    public static ViewSliderChildFragment newInstance(ArrayList<CourseTypeMasterTable> coursesDataArrayList, IOnCourseClickListener iOnCourseClickListener) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("coursesDataArrayList", coursesDataArrayList);
        ViewSliderChildFragment viewSliderChildFragment = new ViewSliderChildFragment();
        iOnCourseClickListener1 = iOnCourseClickListener;
        viewSliderChildFragment.setArguments(bundle);
        return viewSliderChildFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.ibt_fragment_practice_child, (ViewGroup) null);
        this.activity = getActivity();
        getBundleData();
        initView(this.view);
        return this.view;
    }

    private void getBundleData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.coursesDataArrayList = (ArrayList) arguments.getSerializable("coursesDataArrayList");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public int dpToPx(Context c2, int dp) {
        return Math.round(TypedValue.applyDimension(1, dp, c2.getResources().getDisplayMetrics()));
    }

    private void initView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_practice_child_RV1);
        this.recyclerView1 = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this.activity, 3));
        this.recyclerView1.addItemDecoration(new SpacingItemDecoration(3, dpToPx(this.activity, 2), true));
        this.recyclerView1.setHasFixedSize(true);
        IBTPracticeRV2Adapter iBTPracticeRV2Adapter = new IBTPracticeRV2Adapter(this.activity, this.coursesDataArrayList, this, iOnCourseClickListener1);
        this.adapter2 = iBTPracticeRV2Adapter;
        this.recyclerView1.setAdapter(iBTPracticeRV2Adapter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.cat = DashboardActivityTheme8.mainCatId;
    }
}
