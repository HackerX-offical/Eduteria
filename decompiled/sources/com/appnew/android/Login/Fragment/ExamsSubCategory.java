package com.appnew.android.Login.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Login.Adapter.SubCategoryExamsAdapter;
import com.appnew.android.Model.Registration;
import com.appnew.android.Model.User;
import com.appnew.android.Response.Registration.SubStreamResponse;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.SharedPreference;
import com.eduteria.app.app.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ExamsSubCategory extends Fragment {
    Activity activity;
    GridLayoutManager gridLayoutManager;
    Registration registration;
    ArrayList<SubStreamResponse> specializationResponseArrayList;
    String subCat;
    SubCategoryExamsAdapter subCategoryExamsAdapter;
    RecyclerView subcategoryExamsRV;
    String type;
    User user;

    public static ExamsSubCategory newInstance(int type, String subcat) {
        ExamsSubCategory examsSubCategory = new ExamsSubCategory();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        bundle.putString(Const.EXAM_CATEGORY, subcat);
        examsSubCategory.setArguments(bundle);
        return examsSubCategory;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.subCat = getArguments().getString(Const.EXAM_CATEGORY);
        }
        this.user = User.getInstance();
        this.activity = getActivity();
        this.registration = this.user.getUser_registration_info();
        this.specializationResponseArrayList = new ArrayList<>();
        this.specializationResponseArrayList = getSpecializationList(SharedPreference.getInstance().getRegistrationResponse().getMain_sub_category());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.activity, 2);
        this.gridLayoutManager = gridLayoutManager;
        this.subcategoryExamsRV.setLayoutManager(gridLayoutManager);
        SubCategoryExamsAdapter subCategoryExamsAdapter = new SubCategoryExamsAdapter(this.activity, this.specializationResponseArrayList);
        this.subCategoryExamsAdapter = subCategoryExamsAdapter;
        this.subcategoryExamsRV.setAdapter(subCategoryExamsAdapter);
    }

    private void initViews(View view) {
        this.subcategoryExamsRV = (RecyclerView) view.findViewById(R.id.subcategoryExamsRV);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exams_subcategory, container, false);
    }

    public ArrayList<SubStreamResponse> getSpecializationList(ArrayList<SubStreamResponse> list) {
        ArrayList<SubStreamResponse> arrayList = new ArrayList<>();
        for (SubStreamResponse subStreamResponse : list) {
            if (subStreamResponse.getParent_id().equalsIgnoreCase(this.subCat)) {
                arrayList.add(subStreamResponse);
            }
        }
        return arrayList;
    }
}
