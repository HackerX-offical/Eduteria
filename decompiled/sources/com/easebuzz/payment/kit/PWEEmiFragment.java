package com.easebuzz.payment.kit;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.amazonaws.services.s3.internal.Constants;
import datamodels.EmiBanksModel;
import datamodels.EmiPlansModel;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PWEEmiFragment extends Fragment {
    private static PWEEmiFragment instance;
    private Button buttonChangeBankLayout;
    private Button buttonChangePlanLayout;
    private PWECouponsActivity couponsActivity;
    private ArrayList<EmiPlansModel> emiPlansList;
    private View emiView;
    private FragmentManager fManager;
    private LinearLayout linearChangeBankLayout;
    private LinearLayout linearChangePlanLayout;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private EmiPlansModel selectedEmiPlan;
    private JSONObject selectedPlanObj;
    public TextView tvChangeBank;
    public TextView tvChangePlan;
    private TextView tvEmiNoteMessage;
    private String selectedBankName = "";
    private String selectedBankCode = "";

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PWEPaymentInfoHandler pWEPaymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.paymentInfoHandler = pWEPaymentInfoHandler;
        pWEPaymentInfoHandler.setPWEEmiBanksPlansData("");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.emiView = layoutInflater.inflate(R.layout.fragment_pwe_emi, viewGroup, false);
        this.fManager = getActivity().getSupportFragmentManager();
        instance = this;
        this.emiPlansList = new ArrayList<>();
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        initViews();
        return this.emiView;
    }

    private void initViews() {
        this.linearChangePlanLayout = (LinearLayout) this.emiView.findViewById(R.id.linear_change_plan_holder);
        this.tvEmiNoteMessage = (TextView) this.emiView.findViewById(R.id.text_note_msg);
        if (this.paymentInfoHandler.getEmiNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getEmiNoteMessage().equals("")) {
            this.tvEmiNoteMessage.setVisibility(8);
        } else {
            this.tvEmiNoteMessage.setVisibility(0);
            this.tvEmiNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getEmiNoteMessage()));
        }
        this.linearChangePlanLayout.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEEmiFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEEmiFragment.this.loadEmiPlanFragment();
            }
        });
        Button button = (Button) this.emiView.findViewById(R.id.button_change_plan);
        this.buttonChangePlanLayout = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEEmiFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEEmiFragment.this.loadEmiPlanFragment();
            }
        });
        LinearLayout linearLayout = (LinearLayout) this.emiView.findViewById(R.id.linear_change_bank_holder);
        this.linearChangeBankLayout = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEEmiFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEEmiFragment.this.loadFragment(new PWEBankListFragment(), "emibank", new Bundle());
                PWEEmiFragment.this.hideChangePlanButton();
                PWEEmiFragment.this.hideChangeBankButton();
            }
        });
        Button button2 = (Button) this.emiView.findViewById(R.id.button_change_bank);
        this.buttonChangeBankLayout = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEEmiFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWEEmiFragment.this.loadFragment(new PWEBankListFragment(), "emibank", new Bundle());
                PWEEmiFragment.this.hideChangePlanButton();
                PWEEmiFragment.this.hideChangeBankButton();
            }
        });
        this.tvChangeBank = (TextView) this.emiView.findViewById(R.id.text_change_bank);
        this.tvChangePlan = (TextView) this.emiView.findViewById(R.id.text_change_plan);
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonChangeBankLayout.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
            this.buttonChangePlanLayout.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
        }
        hideChangePlanButton();
        hideChangeBankButton();
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.tvChangeBank.setVisibility(8);
            this.tvChangePlan.setVisibility(8);
        } else {
            this.tvChangeBank.setVisibility(0);
            this.tvChangePlan.setVisibility(0);
        }
        loadFragment(new PWEBankListFragment(), "emaibank", new Bundle());
    }

    private void showChangePlanButton() {
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonChangePlanLayout.setVisibility(0);
        } else {
            this.linearChangePlanLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideChangePlanButton() {
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonChangePlanLayout.setVisibility(8);
        } else {
            this.linearChangePlanLayout.setVisibility(8);
        }
    }

    private void showChangeBankButton() {
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonChangeBankLayout.setVisibility(0);
        } else {
            this.linearChangeBankLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideChangeBankButton() {
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonChangeBankLayout.setVisibility(8);
        } else {
            this.linearChangeBankLayout.setVisibility(8);
        }
    }

    void loadFragment(Fragment fragment, String str, Bundle bundle) {
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransactionBeginTransaction = this.fManager.beginTransaction();
        fragmentTransactionBeginTransaction.addToBackStack(str);
        fragmentTransactionBeginTransaction.replace(R.id.emi_frame_container, fragment);
        fragmentTransactionBeginTransaction.commit();
    }

    public void selectEMIBank(EmiBanksModel emiBanksModel) {
        this.selectedBankName = this.paymentInfoHandler.getSelectedEMIBank();
        this.selectedBankCode = this.paymentInfoHandler.getSelectedEMIbankCode();
        this.emiPlansList = new ArrayList<>();
        this.emiPlansList = emiBanksModel.getEmi_list();
        loadEmiPlanFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadEmiPlanFragment() {
        hideChangePlanButton();
        showChangeBankButton();
        this.tvChangeBank.setText(this.selectedBankName);
        Bundle bundle = new Bundle();
        bundle.putSerializable("emi_plan_list", this.emiPlansList);
        loadFragment(new PWEEmiPlanFragment(), "emiplan", bundle);
        this.tvEmiNoteMessage.setVisibility(8);
    }

    public void selectEMIPlan(EmiPlansModel emiPlansModel) {
        this.selectedEmiPlan = emiPlansModel;
        JSONObject jSONObject = new JSONObject();
        this.selectedPlanObj = jSONObject;
        try {
            EmiPlansModel emiPlansModel2 = this.selectedEmiPlan;
            if (emiPlansModel2 != null) {
                jSONObject.put("rate_of_interest", emiPlansModel2.getEmi_roi());
                this.selectedPlanObj.put("emi_amount", this.selectedEmiPlan.getEmi_amount());
                this.selectedPlanObj.put("is_flat_rate", this.selectedEmiPlan.getEmi_process_flat());
                this.selectedPlanObj.put("emi_id", this.selectedEmiPlan.getEmi_plan_id());
                this.selectedPlanObj.put("discount", this.selectedEmiPlan.getEmi_discount());
                this.selectedPlanObj.put("principal_amount", this.selectedEmiPlan.getPrincipal_amount());
                this.selectedPlanObj.put("emi_tenure", this.selectedEmiPlan.getEmi_tenure());
                this.selectedPlanObj.put("total_interest", this.selectedEmiPlan.getEmi_interest());
                this.selectedPlanObj.put("description", this.selectedEmiPlan.getEmi_desc());
                this.selectedPlanObj.put("bank_code", this.selectedBankCode);
            }
        } catch (JSONException unused) {
        }
        this.paymentInfoHandler.setSelectedEMIDict(this.selectedPlanObj.toString());
        loadCreditCardFragment();
    }

    private void loadCreditCardFragment() {
        Bundle bundle = new Bundle();
        bundle.putString("emi_pan", this.selectedPlanObj.toString());
        showChangePlanButton();
        this.tvChangePlan.setText(this.paymentInfoHandler.getSelectedEMIPlanDesc());
        loadFragment(new PWEDebitCreditFragment(), "emicard", bundle);
        this.tvEmiNoteMessage.setVisibility(8);
    }

    public static PWEEmiFragment getInstance() {
        return instance;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
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
}
