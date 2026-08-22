package com.easebuzz.payment.kit;

import adapters.PWECancellationReasonAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import datamodels.CancellationReasonModel;
import java.util.ArrayList;
import listeners.CancelReasonListener;

/* JADX INFO: loaded from: classes7.dex */
public class PWECancellationReasonFragment extends Fragment {
    private Button buttonAbortTrxn;
    private Button buttonContinueTrxn;
    private ArrayList<CancellationReasonModel> cancellationReasoArrayList;
    private PWECancellationReasonAdapter cancellationReasonAdapter;
    private PWECouponsActivity couponsActivity;
    private View crView;
    private EditText editOtherCancelReason;
    private PWEGeneralHelper generalHelper;
    private LinearLayout linearOtherReasonHolder;
    private ListView lvCancellationResoans;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private String cancellation_reason = "";
    private boolean is_other_reason_flag = false;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.crView = layoutInflater.inflate(R.layout.fragment_pwe_cancellation_reason, viewGroup, false);
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        FragmentActivity activity = getActivity();
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.paymentInfoHandler.setIsCancelTransactionFragmentOpen(true);
        initViews();
        return this.crView;
    }

    private void initViews() {
        this.buttonContinueTrxn = (Button) this.crView.findViewById(R.id.button_continue_transaction);
        this.buttonAbortTrxn = (Button) this.crView.findViewById(R.id.button_abort_transaction);
        this.lvCancellationResoans = (ListView) this.crView.findViewById(R.id.listview_cancellation_reasons);
        EditText editText = (EditText) this.crView.findViewById(R.id.edit_other_reason);
        this.editOtherCancelReason = editText;
        this.generalHelper.pweDisableCopyAndPaste(editText);
        this.editOtherCancelReason.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWECancellationReasonFragment.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWECancellationReasonFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWECancellationReasonFragment.this.editOtherCancelReason.setBackground(PWECancellationReasonFragment.this.getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWECancellationReasonFragment.this.editOtherCancelReason.setBackground(PWECancellationReasonFragment.this.getActivity().getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        LinearLayout linearLayout = (LinearLayout) this.crView.findViewById(R.id.linear_other_reason_text_holder);
        this.linearOtherReasonHolder = linearLayout;
        linearLayout.setVisibility(8);
        this.buttonContinueTrxn.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECancellationReasonFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWECancellationReasonFragment.this.couponsActivity.onBackPressed();
            }
        });
        this.buttonAbortTrxn.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWECancellationReasonFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PWECancellationReasonFragment.this.validateCancellation()) {
                    PWECancellationReasonFragment.this.couponsActivity.showUserConfirmationDialog("Cancel Transaction", "Do you really want to cancel transaction ? ", PWECancellationReasonFragment.this.cancellation_reason, 1, "CANCEL_TRANSACTION", "", -1);
                }
            }
        });
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonContinueTrxn.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
            this.buttonAbortTrxn.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_text_button));
        }
        this.cancellationReasoArrayList = new ArrayList<>();
        initCancelReasonAdapter();
    }

    private void initCancelReasonAdapter() {
        this.cancellationReasoArrayList = this.generalHelper.getCancellationsReasonList();
        PWECancellationReasonAdapter pWECancellationReasonAdapter = new PWECancellationReasonAdapter(getActivity(), this.cancellationReasoArrayList);
        this.cancellationReasonAdapter = pWECancellationReasonAdapter;
        this.lvCancellationResoans.setAdapter((ListAdapter) pWECancellationReasonAdapter);
        this.generalHelper.setListViewHeightBasedOnChildren(this.lvCancellationResoans);
        this.cancellationReasonAdapter.setCancelReasonListener(new CancelReasonListener() { // from class: com.easebuzz.payment.kit.PWECancellationReasonFragment.4
            @Override // listeners.CancelReasonListener
            public void selectReason(CancellationReasonModel cancellationReasonModel, boolean z, int i) {
                for (int i2 = 0; i2 < PWECancellationReasonFragment.this.cancellationReasoArrayList.size(); i2++) {
                    if (i2 == i) {
                        ((CancellationReasonModel) PWECancellationReasonFragment.this.cancellationReasoArrayList.get(i2)).setSelected_flag(true);
                    } else {
                        ((CancellationReasonModel) PWECancellationReasonFragment.this.cancellationReasoArrayList.get(i2)).setSelected_flag(false);
                    }
                }
                PWECancellationReasonFragment.this.cancellationReasonAdapter.notifyDataSetChanged();
                if (i == PWECancellationReasonFragment.this.cancellationReasoArrayList.size() - 1) {
                    PWECancellationReasonFragment.this.linearOtherReasonHolder.setVisibility(0);
                    PWECancellationReasonFragment.this.is_other_reason_flag = true;
                    PWECancellationReasonFragment.this.cancellation_reason = "";
                } else {
                    PWECancellationReasonFragment.this.linearOtherReasonHolder.setVisibility(8);
                    PWECancellationReasonFragment.this.is_other_reason_flag = false;
                    PWECancellationReasonFragment.this.cancellation_reason = cancellationReasonModel.getReason();
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    public boolean validateCancellation() {
        if (this.is_other_reason_flag) {
            String strTrim = this.editOtherCancelReason.getText().toString().trim();
            this.cancellation_reason = strTrim;
            if (strTrim != null && !strTrim.equals("") && !this.cancellation_reason.isEmpty()) {
                return true;
            }
            this.editOtherCancelReason.setError("Please enter reason.");
            return false;
        }
        String str = this.cancellation_reason;
        if (str != null && !str.equals("") && !this.cancellation_reason.isEmpty()) {
            return true;
        }
        this.generalHelper.showPweToast("Please select cancellation reason.");
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
