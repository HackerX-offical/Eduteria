package com.easebuzz.payment.kit;

import adapters.PWEEmiPlansAdapter;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.internal.Constants;
import datamodels.EmiPlansModel;
import datamodels.PWEStaticDataModel;
import java.util.List;
import listeners.ConnectionDetector;
import listeners.PWEEMIPlanListener;

/* JADX INFO: loaded from: classes7.dex */
public class PWEEmiPlanFragment extends Fragment {
    private static PWEEmiPlanFragment instance;
    private Button btnNext;
    private PWECouponsActivity couponsActivity;
    private View emiPlanView;
    private PWEEmiPlansAdapter emiPlansAdapter;
    private List<EmiPlansModel> emiPlansList;
    private PWEGeneralHelper generalHelper;
    private ConnectionDetector internetDetecter;
    private ListView lvBankPlan;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private TextView tvEmiNoteMessage;
    private EmiPlansModel selectedEmiPlan = null;
    public boolean open_payment_option = true;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.emiPlanView = layoutInflater.inflate(R.layout.fragment_pwe_emi_plan, viewGroup, false);
        instance = this;
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        this.open_payment_option = true;
        this.selectedEmiPlan = null;
        this.emiPlansList = (List) getArguments().getSerializable("emi_plan_list");
        initViews();
        return this.emiPlanView;
    }

    private void initViews() {
        this.lvBankPlan = (ListView) this.emiPlanView.findViewById(R.id.list_emi_banks_plan);
        this.btnNext = (Button) this.emiPlanView.findViewById(R.id.btn_next_emi);
        this.tvEmiNoteMessage = (TextView) this.emiPlanView.findViewById(R.id.text_note_msg);
        if (this.paymentInfoHandler.getEmiNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getEmiNoteMessage().equals("")) {
            this.tvEmiNoteMessage.setVisibility(8);
        } else {
            this.tvEmiNoteMessage.setVisibility(0);
            this.tvEmiNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getEmiNoteMessage()));
        }
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.btnNext.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.lvBankPlan.setSelector(getResources().getDrawable(R.drawable.pwe_listview_item_selector));
            this.generalHelper.changeButtonWidth(this.btnNext);
        }
        this.btnNext.setVisibility(8);
        this.btnNext.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEEmiPlanFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWEEmiPlanFragment.this.internetDetecter.isConnectingToInternet()) {
                    if (PWEEmiPlanFragment.this.selectedEmiPlan != null) {
                        if (PWEEmiPlanFragment.this.open_payment_option) {
                            PWEEmiPlanFragment.this.open_payment_option = false;
                            PWEEmiFragment.getInstance().selectEMIPlan(PWEEmiPlanFragment.this.selectedEmiPlan);
                            return;
                        }
                        return;
                    }
                    PWEEmiPlanFragment.this.open_payment_option = true;
                    PWEEmiPlanFragment.this.generalHelper.showPweToast("Please select plan");
                    return;
                }
                PWEEmiPlanFragment.this.open_payment_option = true;
                PWEEmiPlanFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
            }
        });
        initializeEMIPlansAdapter();
    }

    PWEEmiPlanFragment getInstance() {
        return instance;
    }

    public void initializeEMIPlansAdapter() {
        List<EmiPlansModel> list = this.emiPlansList;
        if (list == null || list.size() <= 0) {
            return;
        }
        PWEEmiPlansAdapter pWEEmiPlansAdapter = new PWEEmiPlansAdapter(this.emiPlansList, getActivity(), this.paymentInfoHandler);
        this.emiPlansAdapter = pWEEmiPlansAdapter;
        this.lvBankPlan.setAdapter((ListAdapter) pWEEmiPlansAdapter);
        this.lvBankPlan.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWEEmiPlanFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (PWEEmiPlanFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    PWEEmiPlanFragment.this.emiPlansAdapter.selectEMIPlan(view, i);
                }
            }
        });
        this.generalHelper.setListViewHeightBasedOnChildren(this.lvBankPlan);
        this.emiPlansAdapter.setEmiPlanListener(new PWEEMIPlanListener() { // from class: com.easebuzz.payment.kit.PWEEmiPlanFragment.3
            @Override // listeners.PWEEMIPlanListener
            public void selectPlan(EmiPlansModel emiPlansModel, int i) {
                PWEEmiPlanFragment.this.selectedEmiPlan = emiPlansModel;
                PWEEmiPlanFragment.this.paymentInfoHandler.setSelectedEMIPlanDesc(PWEEmiPlanFragment.this.selectedEmiPlan.getEmi_desc());
                PWEEmiPlanFragment.this.btnNext.setVisibility(0);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.open_payment_option = true;
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.paymentInfoHandler.setSelectedEMIPlanDesc("");
        super.onDestroy();
    }
}
