package com.easebuzz.payment.kit;

import adapters.PWENetbankingAdapterNew;
import adapters.SearchableSpinnerAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.Utils.Const;
import datamodels.NetBankingChild;
import datamodels.PWEStaticDataModel;
import java.util.ArrayList;
import listeners.ConnectionDetector;
import listfilter.SearchableSpinner;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PWENetbankingFragment extends Fragment {
    private Activity activity;
    private ArrayList<NetBankingChild> allBanksList;
    private Button buttonPayNetBanking;
    private PWECouponsActivity couponsActivity;
    private PWEDiscountHelper discountCodeHelper;
    private PWEGeneralHelper generalHelper;
    private ArrayList<NetBankingChild> gridNetBankingList;
    private ExpandableHeightGridView gridViewNetbanking;
    private ConnectionDetector internetDetecter;
    private LinearLayout linearSearchableSpinnerHolder;
    private PWENetbankingAdapterNew netBankingGridAdapter;
    private View netBankingView;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private SearchableSpinner searchableSpinner;
    private SearchableSpinnerAdapter searchableSpinnerAdapter;
    private TextView txtNetBankNoteMessage;
    private boolean open_payment_option = true;
    private String gridBankCode = "";
    private String otherBankCode = "";
    private String bankname = "";
    private String otherbankname = "";
    private String SelectedBankCode = "";
    private String SelectedBankId = "";
    private int selectedGridItemPosition = -1;
    private int selectedSpinnerItemPosition = -1;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.netBankingView = layoutInflater.inflate(R.layout.fragment_pwe_netbanking, viewGroup, false);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(getActivity());
        this.generalHelper = new PWEGeneralHelper(getActivity());
        this.internetDetecter = new ConnectionDetector(getActivity());
        this.open_payment_option = true;
        FragmentActivity activity = getActivity();
        this.activity = activity;
        if (activity instanceof PWECouponsActivity) {
            this.couponsActivity = (PWECouponsActivity) activity;
        }
        this.discountCodeHelper = this.couponsActivity.getDiscountHelper();
        initViews();
        setNetBankGroups();
        return this.netBankingView;
    }

    private void initViews() {
        this.gridNetBankingList = new ArrayList<>();
        this.allBanksList = new ArrayList<>();
        this.gridViewNetbanking = (ExpandableHeightGridView) this.netBankingView.findViewById(R.id.popular_banks_grid);
        this.searchableSpinner = (SearchableSpinner) this.netBankingView.findViewById(R.id.search_spinner);
        LinearLayout linearLayout = (LinearLayout) this.netBankingView.findViewById(R.id.linear_netb_searchable_spinner_holder);
        this.linearSearchableSpinnerHolder = linearLayout;
        linearLayout.setVisibility(8);
        this.searchableSpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.easebuzz.payment.kit.PWENetbankingFragment.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (PWENetbankingFragment.this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
                    if (z) {
                        PWENetbankingFragment.this.linearSearchableSpinnerHolder.setBackground(PWENetbankingFragment.this.getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_image_edit_text));
                    } else {
                        PWENetbankingFragment.this.linearSearchableSpinnerHolder.setBackground(PWENetbankingFragment.this.getActivity().getResources().getDrawable(R.drawable.custom_background_white));
                    }
                }
            }
        });
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.gridViewNetbanking.setSelector(getResources().getDrawable(R.drawable.pwe_gridview_item_selector));
        }
        PWENetbankingAdapterNew pWENetbankingAdapterNew = new PWENetbankingAdapterNew(getActivity(), this.gridNetBankingList);
        this.netBankingGridAdapter = pWENetbankingAdapterNew;
        this.gridViewNetbanking.setAdapter((ListAdapter) pWENetbankingAdapterNew);
        this.gridViewNetbanking.setNumColumns(3);
        this.gridViewNetbanking.setExpanded(true);
        SearchableSpinnerAdapter searchableSpinnerAdapter = new SearchableSpinnerAdapter(getActivity(), R.layout.item_netbanking_child, this.allBanksList);
        this.searchableSpinnerAdapter = searchableSpinnerAdapter;
        this.searchableSpinner.setAdapter((SpinnerAdapter) searchableSpinnerAdapter);
        this.gridViewNetbanking.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.easebuzz.payment.kit.PWENetbankingFragment.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                PWENetbankingFragment.this.netBankingGridAdapter.setSelectedPosition(i);
                PWENetbankingFragment.this.searchableSpinner.setSelection(0);
                NetBankingChild netBankingChild = (NetBankingChild) adapterView.getItemAtPosition(i);
                PWENetbankingFragment.this.gridBankCode = netBankingChild.getBankCode();
                PWENetbankingFragment.this.otherBankCode = "";
                PWENetbankingFragment.this.bankname = netBankingChild.getBankId();
                PWENetbankingFragment.this.otherbankname = "";
                PWENetbankingFragment.this.selectedGridItemPosition = i;
                if (PWENetbankingFragment.this.paymentInfoHandler.getIsDiscountCouponApplied() && PWENetbankingFragment.this.selectedGridItemPosition != -1 && PWENetbankingFragment.this.searchableSpinner.getSelectedItemPosition() == 0) {
                    PWENetbankingFragment.this.couponsActivity.resetDiscountCode();
                }
                PWENetbankingFragment.this.selectedSpinnerItemPosition = -1;
            }
        });
        this.searchableSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.easebuzz.payment.kit.PWENetbankingFragment.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                PWENetbankingFragment.this.generalHelper.hideKeyboard(PWENetbankingFragment.this.getContext(), view);
                if (i != 0) {
                    PWENetbankingFragment.this.netBankingGridAdapter.setSelectedPosition(-1);
                    PWENetbankingFragment.this.selectedGridItemPosition = -1;
                    PWENetbankingFragment.this.bankname = "otherbank";
                    PWENetbankingFragment pWENetbankingFragment = PWENetbankingFragment.this;
                    pWENetbankingFragment.otherbankname = ((NetBankingChild) pWENetbankingFragment.allBanksList.get(i)).getBankId();
                    PWENetbankingFragment.this.gridBankCode = "";
                    PWENetbankingFragment pWENetbankingFragment2 = PWENetbankingFragment.this;
                    pWENetbankingFragment2.otherBankCode = ((NetBankingChild) pWENetbankingFragment2.allBanksList.get(i)).getBankCode();
                    if (PWENetbankingFragment.this.paymentInfoHandler.getIsDiscountCouponApplied() && PWENetbankingFragment.this.selectedGridItemPosition == -1 && i != 0 && PWENetbankingFragment.this.selectedSpinnerItemPosition != i) {
                        PWENetbankingFragment.this.couponsActivity.resetDiscountCode();
                    }
                    PWENetbankingFragment.this.selectedSpinnerItemPosition = i;
                    return;
                }
                PWENetbankingFragment.this.otherbankname = "";
                PWENetbankingFragment.this.otherBankCode = "";
                if (PWENetbankingFragment.this.paymentInfoHandler.getIsDiscountCouponApplied() && PWENetbankingFragment.this.selectedGridItemPosition == -1 && i == 0) {
                    PWENetbankingFragment.this.couponsActivity.resetDiscountCode();
                }
            }
        });
        this.buttonPayNetBanking = (Button) this.netBankingView.findViewById(R.id.button_proceed_for_payment);
        this.txtNetBankNoteMessage = (TextView) this.netBankingView.findViewById(R.id.text_note_message);
        if (this.paymentInfoHandler.getNetBankingNoteMessage().equals(Constants.NULL_VERSION_ID) || this.paymentInfoHandler.getNetBankingNoteMessage().equals("")) {
            this.txtNetBankNoteMessage.setVisibility(8);
        } else {
            this.txtNetBankNoteMessage.setVisibility(0);
            this.txtNetBankNoteMessage.setText(Html.fromHtml(this.paymentInfoHandler.getNetBankingNoteMessage()));
        }
        if (this.paymentInfoHandler.getPWEDeviceType().equals("TV")) {
            this.buttonPayNetBanking.setBackground(getActivity().getResources().getDrawable(R.drawable.pwe_android_tv_button));
            this.generalHelper.changeButtonWidth(this.buttonPayNetBanking);
        }
        this.buttonPayNetBanking.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWENetbankingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PWENetbankingFragment.this.generalHelper.hideKeyboard(PWENetbankingFragment.this.getContext(), view);
                if (!PWENetbankingFragment.this.internetDetecter.isConnectingToInternet()) {
                    PWENetbankingFragment.this.open_payment_option = true;
                    PWENetbankingFragment.this.generalHelper.showPweToast(PWEStaticDataModel.NO_INTERNET_CONNECTION_TEXT);
                    return;
                }
                PWENetbankingFragment.this.setBankCode();
                if (PWENetbankingFragment.this.validateAllFields() && PWENetbankingFragment.this.open_payment_option) {
                    PWENetbankingFragment.this.open_payment_option = false;
                    PWENetbankingFragment.this.couponsActivity.submitPayment(PWENetbankingFragment.this.bankname, PWENetbankingFragment.this.otherbankname, PWENetbankingFragment.this.SelectedBankCode, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
                }
            }
        });
    }

    boolean validateAllFields() {
        String str = this.SelectedBankId;
        if (str != null && !str.equals("")) {
            return true;
        }
        this.generalHelper.showPweToast("Please select bank.");
        return false;
    }

    public void setBankCode() {
        String str;
        if (!this.gridBankCode.equals("")) {
            try {
                this.discountCodeHelper.setBankCode(this.gridBankCode);
            } catch (Error | Exception unused) {
            }
            this.SelectedBankCode = this.gridBankCode;
        } else if (!this.otherBankCode.equals("")) {
            try {
                this.discountCodeHelper.setBankCode(this.otherBankCode);
            } catch (Error | Exception unused2) {
            }
            this.SelectedBankCode = this.otherBankCode;
        } else {
            this.SelectedBankCode = "";
        }
        if (this.bankname == null) {
            this.bankname = "";
        }
        if (this.otherbankname == null) {
            this.otherbankname = "";
        }
        if (!this.bankname.equals("") && (str = this.bankname) != null && !str.equals("otherbank")) {
            this.SelectedBankId = this.bankname;
        } else if (!this.otherbankname.equals("") && this.otherbankname != null && this.bankname.equals("otherbank")) {
            this.SelectedBankId = this.otherbankname;
        } else {
            this.SelectedBankId = "";
        }
    }

    private void setNetBankGroups() {
        try {
            JSONArray jSONArray = new JSONArray(this.paymentInfoHandler.getBankCodeString());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getString(Const.CATEGORY).equals(PWEStaticDataModel.PAYOPT_NETBANK_DISPLAY_NAME)) {
                    if (jSONObject.getString("eb_category").equals("major")) {
                        NetBankingChild netBankingChild = new NetBankingChild();
                        netBankingChild.setName(jSONObject.getString("bank_name"));
                        netBankingChild.setBankId(jSONObject.getString("bank_id"));
                        netBankingChild.setImage_Path(jSONObject.getString("image"));
                        netBankingChild.setBankCode(jSONObject.optString("bank_code"));
                        netBankingChild.setImageName(jSONObject.getString("image").split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r3.length - 1]);
                        this.gridNetBankingList.add(netBankingChild);
                    } else {
                        NetBankingChild netBankingChild2 = new NetBankingChild();
                        netBankingChild2.setName(jSONObject.getString("bank_name"));
                        netBankingChild2.setBankId(jSONObject.getString("bank_id"));
                        netBankingChild2.setImage_Path(jSONObject.getString("image"));
                        netBankingChild2.setBankCode(jSONObject.optString("bank_code"));
                        netBankingChild2.setImageName(jSONObject.getString("image").split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[r3.length - 1]);
                        this.allBanksList.add(netBankingChild2);
                    }
                }
            }
            if (this.allBanksList.size() > 0) {
                this.linearSearchableSpinnerHolder.setVisibility(0);
                this.netBankingGridAdapter.notifyDataSetChanged();
                NetBankingChild netBankingChild3 = new NetBankingChild();
                netBankingChild3.setName("Try Other Bank");
                netBankingChild3.setImage(R.drawable.search_icon_grey);
                this.allBanksList.add(0, netBankingChild3);
                this.searchableSpinnerAdapter.notifyDataSetChanged();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject validateDiscountCodeOuter(java.util.ArrayList<datamodels.DiscountCodeDataModel> r4, com.easebuzz.payment.kit.PWEDiscountHelper r5) {
        /*
            r3 = this;
            r3.discountCodeHelper = r5
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r0 = r3.SelectedBankCode
            r1 = 0
            if (r0 == 0) goto L21
            java.lang.String r2 = ""
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L15
            goto L21
        L15:
            int r4 = r4.size()
            r0 = 1
            if (r4 >= r0) goto L1f
            java.lang.String r2 = "Discount codes are not available for this payment mode"
            goto L23
        L1f:
            r1 = r0
            goto L23
        L21:
            java.lang.String r2 = "Please select bank before applying discount code"
        L23:
            java.lang.String r4 = "status"
            r5.put(r4, r1)     // Catch: org.json.JSONException -> L30
            java.lang.String r4 = "toast_error_message"
            r5.put(r4, r2)     // Catch: org.json.JSONException -> L30
            return r5
        L30:
            r4 = move-exception
            r4.printStackTrace()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easebuzz.payment.kit.PWENetbankingFragment.validateDiscountCodeOuter(java.util.ArrayList, com.easebuzz.payment.kit.PWEDiscountHelper):org.json.JSONObject");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        int i;
        this.open_payment_option = true;
        if (this.netBankingGridAdapter != null && this.gridNetBankingList.size() > 0 && (i = this.selectedGridItemPosition) != -1 && i < this.gridNetBankingList.size()) {
            this.netBankingGridAdapter.setSelectedPosition(this.selectedGridItemPosition);
        }
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
        super.onDestroy();
    }
}
