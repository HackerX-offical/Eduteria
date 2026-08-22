package com.appnew.android.home.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Interfaces.OnSuccessListner;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.adapters.PaidCourseAdapter;
import com.appnew.android.home.interfaces.batchsortClickListner;
import com.appnew.android.home.model.MyCourse;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class BatchFragment extends Fragment implements OnSuccessListner {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Activity activity;
    Button backBtn;
    private RecyclerView batch_recyclerview;
    private String mParam1;
    private String mParam2;
    private MyCourse myCourse;
    RelativeLayout no_data_found_RL;
    public PaidCourseAdapter paidCourseAdapter;
    PaymentViewModel paymentViewModel;
    private View view;

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onSuccessEsewa(String productId, String amt, String rid, String scd) {
    }

    public static BatchFragment newInstance(String param1, String param2) {
        BatchFragment batchFragment = new BatchFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, param1);
        bundle.putString(ARG_PARAM2, param2);
        batchFragment.setArguments(bundle);
        return batchFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.fragment_batch, container, false);
        this.view = viewInflate;
        this.batch_recyclerview = (RecyclerView) viewInflate.findViewById(R.id.batch_course_recycler);
        this.no_data_found_RL = (RelativeLayout) this.view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) this.view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
        this.myCourse = ((MyLibraryActivty) requireActivity()).myCourse;
        if (isAdded()) {
            this.paymentViewModel = ((MyLibraryActivty) requireActivity()).paymentViewModel;
        }
        ((MyLibraryActivty) requireActivity()).updatesortlistner_batch(new batchsortClickListner() { // from class: com.appnew.android.home.Fragment.BatchFragment$$ExternalSyntheticLambda0
            @Override // com.appnew.android.home.interfaces.batchsortClickListner
            public final void onTitleClicked(ArrayList arrayList) {
                this.f$0.lambda$onCreateView$0(arrayList);
            }
        });
        MyCourse myCourse = this.myCourse;
        if (myCourse != null && myCourse.getBatchcourse() != null && this.myCourse.getBatchcourse().size() > 0) {
            this.no_data_found_RL.setVisibility(8);
            this.batch_recyclerview.setVisibility(0);
            PaidCourseAdapter paidCourseAdapter = new PaidCourseAdapter(getActivity(), this.myCourse.getBatchcourse(), this.myCourse.getTime(), this.paymentViewModel);
            this.paidCourseAdapter = paidCourseAdapter;
            this.batch_recyclerview.setAdapter(paidCourseAdapter);
        } else {
            this.no_data_found_RL.setVisibility(0);
            this.batch_recyclerview.setVisibility(8);
        }
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(ArrayList arrayList) {
        this.myCourse.setBatchcourse(arrayList);
        this.paidCourseAdapter.notifidata(arrayList);
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onSuccess(String pot_txt_id) {
        this.paidCourseAdapter.update_payment(pot_txt_id);
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onFailure(String pot_txt_id) {
        this.paidCourseAdapter.update_payment(pot_txt_id);
    }

    public void updatedata(ArrayList<Courselist> batccourse) {
        requireFragmentManager().beginTransaction().detach(this).attach(this).commit();
        this.paidCourseAdapter.notifidata(batccourse);
    }

    public void beginSearch(String newText) {
        ArrayList<Courselist> arrayList = new ArrayList<>();
        for (Courselist courselist : this.myCourse.getBatchcourse()) {
            if (courselist.getTitle().toLowerCase().contains(newText.toLowerCase()) || courselist.getTitle().toUpperCase().contains(newText.toUpperCase())) {
                arrayList.add(courselist);
            }
        }
        if (arrayList.isEmpty()) {
            if (!newText.isEmpty()) {
                Snackbar.make(this.view, requireActivity().getResources().getString(R.string.no_course_found), -1).show();
            }
            this.no_data_found_RL.setVisibility(0);
            this.batch_recyclerview.setVisibility(8);
        } else {
            this.no_data_found_RL.setVisibility(8);
            this.batch_recyclerview.setVisibility(0);
        }
        PaidCourseAdapter paidCourseAdapter = this.paidCourseAdapter;
        if (paidCourseAdapter != null) {
            paidCourseAdapter.filterList(arrayList);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }
}
