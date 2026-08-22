package com.appnew.android.home.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Interfaces.OnSuccessListner;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.adapters.PaidCourseAdapter;
import com.appnew.android.home.interfaces.freesortClickListner;
import com.appnew.android.home.model.MyCourse;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class FreeFragment extends Fragment implements OnSuccessListner {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Activity activity;
    Button backBtn;
    private RecyclerView free_recyclerview;
    private String mParam1;
    private String mParam2;
    private MyCourse myCourse;
    RelativeLayout no_data_found_RL;
    public PaidCourseAdapter paidCourseAdapter;
    PaymentViewModel paymentViewModel;
    private String showViewType = "";
    private View view;

    public static FreeFragment newInstance(String param1, String param2) {
        FreeFragment freeFragment = new FreeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, param1);
        bundle.putString(ARG_PARAM2, param2);
        freeFragment.setArguments(bundle);
        return freeFragment;
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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_free, container, false);
        this.showViewType = getArguments().getString("showViewType");
        this.free_recyclerview = (RecyclerView) this.view.findViewById(R.id.free_course_recycler);
        this.no_data_found_RL = (RelativeLayout) this.view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) this.view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
        this.myCourse = ((MyLibraryActivty) requireActivity()).myCourse;
        if (isAdded()) {
            this.paymentViewModel = ((MyLibraryActivty) requireActivity()).paymentViewModel;
        }
        ((MyLibraryActivty) requireActivity()).updatesortlistner_free(new freesortClickListner() { // from class: com.appnew.android.home.Fragment.FreeFragment$$ExternalSyntheticLambda0
            @Override // com.appnew.android.home.interfaces.freesortClickListner
            public final void onTitleClicked(List list, String str) {
                this.f$0.lambda$onCreateView$0(list, str);
            }
        });
        MyCourse myCourse = this.myCourse;
        if (myCourse != null && myCourse.getFreecourse() != null && this.myCourse.getFreecourse().size() > 0) {
            this.no_data_found_RL.setVisibility(8);
            this.free_recyclerview.setVisibility(0);
            setFinalRecords(getActivity(), this.myCourse.getFreecourse(), this.myCourse.getTime());
        } else {
            this.no_data_found_RL.setVisibility(0);
            this.free_recyclerview.setVisibility(8);
        }
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(List list, String str) {
        this.myCourse.setFreecourse(list);
        setRecordsWithTtl(list, str);
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onSuccess(String pot_txt_id) {
        this.paidCourseAdapter.update_payment(pot_txt_id);
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onFailure(String pot_txt_id) {
        this.paidCourseAdapter.update_payment(pot_txt_id);
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onSuccessEsewa(String productId, String amt, String rid, String scd) {
        this.paidCourseAdapter.update_payment_esewa(productId, amt, rid, scd);
    }

    public void updatedata(List<Courselist> freecourse) {
        requireFragmentManager().beginTransaction().detach(this).attach(this).commit();
        setRecordsWithoutTtl(freecourse);
    }

    public void beginSearch(String newText) {
        ArrayList<Courselist> arrayList = new ArrayList<>();
        for (Courselist courselist : this.myCourse.getFreecourse()) {
            if (courselist.getTitle().toLowerCase().contains(newText.toLowerCase()) || courselist.getTitle().toUpperCase().contains(newText.toUpperCase())) {
                arrayList.add(courselist);
            }
        }
        if (arrayList.isEmpty()) {
            if (!newText.isEmpty()) {
                Snackbar.make(this.view, requireActivity().getResources().getString(R.string.no_course_found), -1).show();
            }
            this.no_data_found_RL.setVisibility(0);
            this.free_recyclerview.setVisibility(8);
        } else {
            this.no_data_found_RL.setVisibility(8);
            this.free_recyclerview.setVisibility(0);
        }
        PaidCourseAdapter paidCourseAdapter = this.paidCourseAdapter;
        if (paidCourseAdapter != null) {
            paidCourseAdapter.filterList(arrayList);
        }
    }

    private void setRecordsWithTtl(List<Courselist> courselists, String tiitle) {
        if ("1".equalsIgnoreCase("6")) {
            ArrayList arrayList = new ArrayList();
            for (Courselist courselist : courselists) {
                if (courselist.getViewType().equalsIgnoreCase(this.showViewType)) {
                    arrayList.add(courselist);
                }
            }
            if (arrayList.size() > 0) {
                this.no_data_found_RL.setVisibility(8);
                this.free_recyclerview.setVisibility(0);
            } else {
                this.no_data_found_RL.setVisibility(0);
                this.free_recyclerview.setVisibility(8);
            }
            this.paidCourseAdapter.notifidata(arrayList, tiitle);
            return;
        }
        this.paidCourseAdapter.notifidata(courselists, tiitle);
    }

    private void setFinalRecords(FragmentActivity activity, List<Courselist> freecourse, int time) {
        if ("1".equalsIgnoreCase("6")) {
            ArrayList arrayList = new ArrayList();
            for (Courselist courselist : freecourse) {
                if (courselist.getViewType().equalsIgnoreCase(this.showViewType)) {
                    arrayList.add(courselist);
                }
            }
            if (arrayList.size() > 0) {
                this.no_data_found_RL.setVisibility(8);
                this.free_recyclerview.setVisibility(0);
            } else {
                this.no_data_found_RL.setVisibility(0);
                this.free_recyclerview.setVisibility(8);
            }
            PaidCourseAdapter paidCourseAdapter = new PaidCourseAdapter(activity, arrayList, time, this.paymentViewModel);
            this.paidCourseAdapter = paidCourseAdapter;
            this.free_recyclerview.setAdapter(paidCourseAdapter);
            return;
        }
        PaidCourseAdapter paidCourseAdapter2 = new PaidCourseAdapter(activity, freecourse, time, this.paymentViewModel);
        this.paidCourseAdapter = paidCourseAdapter2;
        this.free_recyclerview.setAdapter(paidCourseAdapter2);
    }

    private void setRecordsWithoutTtl(List<Courselist> freecourse) {
        if ("1".equalsIgnoreCase("6")) {
            ArrayList arrayList = new ArrayList();
            for (Courselist courselist : freecourse) {
                if (courselist.getViewType().equalsIgnoreCase(this.showViewType)) {
                    arrayList.add(courselist);
                }
            }
            if (arrayList.size() > 0) {
                this.no_data_found_RL.setVisibility(8);
                this.free_recyclerview.setVisibility(0);
            } else {
                this.no_data_found_RL.setVisibility(0);
                this.free_recyclerview.setVisibility(8);
            }
            this.paidCourseAdapter.notifidata(arrayList);
            return;
        }
        this.paidCourseAdapter.notifidata(freecourse);
    }
}
