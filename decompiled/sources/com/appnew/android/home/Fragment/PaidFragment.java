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
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Courses.Interfaces.OnSuccessListner;
import com.appnew.android.Model.Courselist;
import com.appnew.android.Payment.PaymentViewModel;
import com.appnew.android.home.Activity.MyLibraryActivty;
import com.appnew.android.home.adapters.PaidCourseAdapter;
import com.appnew.android.home.interfaces.sortClickListner;
import com.appnew.android.home.model.MyCourse;
import com.eduteria.app.app.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class PaidFragment extends Fragment implements OnSuccessListner {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Activity activity;
    Button backBtn;
    private String mParam1;
    private String mParam2;
    MyCourse myCourse;
    RelativeLayout no_data_found_RL;
    public PaidCourseAdapter paidCourseAdapter;
    private RecyclerView paid_recyclerview;
    PaymentViewModel paymentViewModel;
    private String showViewType = "";
    private View view;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    public static PaidFragment newInstance(String param1, String param2) {
        PaidFragment paidFragment = new PaidFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, param1);
        bundle.putString(ARG_PARAM2, param2);
        bundle.putString(ARG_PARAM2, param2);
        bundle.putString(ARG_PARAM2, param2);
        paidFragment.setArguments(bundle);
        return paidFragment;
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
        ((MyLibraryActivty) activity).onSuccessListner = this;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_paid, container, false);
        this.showViewType = getArguments().getString("showViewType");
        this.paid_recyclerview = (RecyclerView) this.view.findViewById(R.id.paid_course_recycler);
        this.no_data_found_RL = (RelativeLayout) this.view.findViewById(R.id.no_data_found_RL);
        Button button = (Button) this.view.findViewById(R.id.backBtn);
        this.backBtn = button;
        button.setVisibility(8);
        this.myCourse = ((MyLibraryActivty) requireActivity()).myCourse;
        if (isAdded()) {
            this.paymentViewModel = ((MyLibraryActivty) requireActivity()).paymentViewModel;
        }
        ((MyLibraryActivty) requireActivity()).updatesortlistner(new sortClickListner() { // from class: com.appnew.android.home.Fragment.PaidFragment$$ExternalSyntheticLambda0
            @Override // com.appnew.android.home.interfaces.sortClickListner
            public final void onTitleClicked(List list, String str) {
                this.f$0.lambda$onCreateView$0(list, str);
            }
        });
        MyCourse myCourse = this.myCourse;
        if (myCourse != null && myCourse.getPaid_course() != null && this.myCourse.getPaid_course().size() > 0) {
            this.no_data_found_RL.setVisibility(8);
            this.paid_recyclerview.setVisibility(0);
            setFinalPaidCourseAdapter(getActivity(), this.myCourse.getPaid_course(), this.myCourse.getTime());
        } else {
            this.no_data_found_RL.setVisibility(0);
            this.paid_recyclerview.setVisibility(8);
        }
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(List list, String str) {
        this.myCourse.setPaid_course(list);
        notifyFinalRecordsPaidCourseAdapterWithTitle(list, str);
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onSuccess(String pot_txt_id) {
        try {
            this.paidCourseAdapter.update_payment(pot_txt_id);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onFailure(String pot_txt_id) {
        this.paidCourseAdapter.update_payment(pot_txt_id);
    }

    @Override // com.appnew.android.Courses.Interfaces.OnSuccessListner
    public void onSuccessEsewa(String productId, String amt, String rid, String scd) {
        this.paidCourseAdapter.update_payment_esewa(productId, amt, rid, scd);
    }

    public void beginSearch(String text) {
        ArrayList<Courselist> arrayList = new ArrayList<>();
        for (Courselist courselist : this.myCourse.getPaid_course()) {
            if (courselist.getTitle().toLowerCase().contains(text.toLowerCase()) || courselist.getTitle().toUpperCase().contains(text.toUpperCase())) {
                arrayList.add(courselist);
            }
        }
        if (arrayList.isEmpty()) {
            if (!text.isEmpty()) {
                Snackbar.make(this.view, this.activity.getResources().getString(R.string.no_course_found), -1).show();
            }
            this.no_data_found_RL.setVisibility(0);
            this.paid_recyclerview.setVisibility(8);
        } else {
            this.no_data_found_RL.setVisibility(8);
            this.paid_recyclerview.setVisibility(0);
        }
        PaidCourseAdapter paidCourseAdapter = this.paidCourseAdapter;
        if (paidCourseAdapter != null) {
            paidCourseAdapter.filterList(arrayList);
        }
    }

    public void updatedata(final List<Courselist> paid_course) {
        try {
            if (isAdded()) {
                requireActivity().runOnUiThread(new Runnable() { // from class: com.appnew.android.home.Fragment.PaidFragment$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updatedata$1(paid_course);
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updatedata$1(List list) {
        if (this.paidCourseAdapter != null) {
            notifyFinalRecordsPaidCourseAdapterWithoutTitle(list);
        } else {
            setFinalPaidCourseAdapter(requireActivity(), list, this.myCourse.getTime());
        }
    }

    private void notifyFinalRecordsPaidCourseAdapterWithoutTitle(List<Courselist> paid_course) {
        if ("1".equalsIgnoreCase("6")) {
            ArrayList arrayList = new ArrayList();
            for (Courselist courselist : paid_course) {
                if (courselist.getViewType().equalsIgnoreCase(this.showViewType)) {
                    arrayList.add(courselist);
                }
            }
            if (arrayList.size() > 0) {
                this.no_data_found_RL.setVisibility(8);
                this.paid_recyclerview.setVisibility(0);
            } else {
                this.no_data_found_RL.setVisibility(0);
                this.paid_recyclerview.setVisibility(8);
            }
            this.paidCourseAdapter.notifidata(arrayList);
            return;
        }
        this.paidCourseAdapter.notifidata(paid_course);
    }

    private void notifyFinalRecordsPaidCourseAdapterWithTitle(List<Courselist> courselists, String tiitle) {
        if ("1".equalsIgnoreCase("6")) {
            ArrayList arrayList = new ArrayList();
            for (Courselist courselist : courselists) {
                if (courselist.getViewType().equalsIgnoreCase(this.showViewType)) {
                    arrayList.add(courselist);
                }
            }
            if (arrayList.size() > 0) {
                this.no_data_found_RL.setVisibility(8);
                this.paid_recyclerview.setVisibility(0);
            } else {
                this.no_data_found_RL.setVisibility(0);
                this.paid_recyclerview.setVisibility(8);
            }
            this.paidCourseAdapter.notifidata(arrayList, tiitle);
            return;
        }
        this.paidCourseAdapter.notifidata(courselists, tiitle);
    }

    private void setFinalPaidCourseAdapter(FragmentActivity activity, List<Courselist> myCourse, int time) {
        if ("1".equalsIgnoreCase("6")) {
            ArrayList arrayList = new ArrayList();
            for (Courselist courselist : myCourse) {
                if (courselist.getViewType().equalsIgnoreCase(this.showViewType)) {
                    arrayList.add(courselist);
                }
            }
            if (arrayList.size() > 0) {
                this.no_data_found_RL.setVisibility(8);
                this.paid_recyclerview.setVisibility(0);
            } else {
                this.no_data_found_RL.setVisibility(0);
                this.paid_recyclerview.setVisibility(8);
            }
            PaidCourseAdapter paidCourseAdapter = new PaidCourseAdapter(activity, arrayList, time, this.paymentViewModel);
            this.paidCourseAdapter = paidCourseAdapter;
            this.paid_recyclerview.setAdapter(paidCourseAdapter);
            return;
        }
        PaidCourseAdapter paidCourseAdapter2 = new PaidCourseAdapter(activity, myCourse, time, this.paymentViewModel);
        this.paidCourseAdapter = paidCourseAdapter2;
        this.paid_recyclerview.setAdapter(paidCourseAdapter2);
    }

    public void setPaidCourseAdapter(FragmentActivity activity, List<Courselist> myCourse, int time) {
        this.paidCourseAdapter = new PaidCourseAdapter(activity, myCourse, time, this.paymentViewModel);
    }
}
