package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityInstallmentDetailBinding implements ViewBinding {
    public final LinearLayout BlockHideLL;
    public final TextView GSTStatus;
    public final TextView Note;
    public final TextView PaymentType;
    public final TextView ProductName;
    public final LinearLayout SwitchPlan;
    public final TextView addressHint;
    public final TextView addressText;
    public final TextView admitCardDownload;
    public final LinearLayout bookAddressLL;
    public final TextView bookAddressTV;
    public final ImageView btnDownloadInvoice;
    public final TextView coursenameTV;
    public final LinearLayout cvrCourseDetails;
    public final LinearLayoutCompat cvrInstallment;
    public final TextView delete;
    public final TextView downloadInvoice;
    public final Button downloadInvoice2Btn;
    public final Button downloadInvoiceBtn;
    public final TextView duePayment;
    public final LinearLayout duePaymentLL;
    public final TextView expiresOnTxt;
    public final TextView expiresOnValueTxt;
    public final Button extendValidy;
    public final ImageView imageBack;
    public final ImageView imageEmiOrOneTime;
    public final ShapeableImageView imageIV;
    public final TextView lateFeePanalty;
    public final LinearLayout llAddress;
    public final LinearLayoutCompat llCenterDetail;
    public final LinearLayoutCompat llFullPayment;
    public final LinearLayout llMap;
    public final Toolbar mainToolbar;
    public final TextView mrpCutTV;
    public final TextView nameHint;
    public final TextView nameText;
    public final LinearLayout onetimeHideLL;
    public final LinearLayout openLayoutLL;
    public final TextView orderId;
    public final TextView orderIdTxt;
    public final TextView orderStatusText;
    public final TextView orderTrackStatus;
    public final TextView paymentCode;
    public final TextView paymentStatus;
    public final TextView paymentType;
    public final TextView price;
    public final TextView priceTxt;
    public final TextView priceValueTxt;
    public final LinearLayout purchaseDetails;
    public final TextView purchasedOnTxt;
    public final TextView purchasedOnValueTxt;
    public final RecyclerView recyclerInstallmentList;
    public final RelativeLayout relativeDownloadInvoice;
    public final LinearLayout rlCenterAddress;
    public final RelativeLayout rlExpire;
    public final RelativeLayout rlOrderStatus;
    private final RelativeLayout rootView;
    public final CheckBox selectAllDelete;
    public final TextView slotHint;
    public final TextView slotText;
    public final TextView status;
    public final TextView subscriptionActive;
    public final TextView subscriptionDate;
    public final TextView subscriptionDescription;
    public final RelativeLayout subscriptionPlanDetail;
    public final RelativeLayout subscriptionPlanRL;
    public final TextView subscriptionPrice;
    public final TextView subscriptionTitle;
    public final TextView titleTV;
    public final TextView toolbarTitleTV;
    public final TextView totalPaymentDue;
    public final LinearLayout totalPaymentDueLL;
    public final Button trackUrlBtn;
    public final RelativeLayout transactionListRl;
    public final LinearLayout transactionStatement;
    public final TextView tvPaymentStatus;
    public final TextView txtDueDate;
    public final TextView txtPaymentMode;
    public final TextView txtTransactionDate;
    public final TextView upcomingInstallmentAmount;
    public final TextView validityTV;
    public final ImageView videoImage;

    private ActivityInstallmentDetailBinding(RelativeLayout rootView, LinearLayout BlockHideLL, TextView GSTStatus, TextView Note, TextView PaymentType, TextView ProductName, LinearLayout SwitchPlan, TextView addressHint, TextView addressText, TextView admitCardDownload, LinearLayout bookAddressLL, TextView bookAddressTV, ImageView btnDownloadInvoice, TextView coursenameTV, LinearLayout cvrCourseDetails, LinearLayoutCompat cvrInstallment, TextView delete, TextView downloadInvoice, Button downloadInvoice2Btn, Button downloadInvoiceBtn, TextView duePayment, LinearLayout duePaymentLL, TextView expiresOnTxt, TextView expiresOnValueTxt, Button extendValidy, ImageView imageBack, ImageView imageEmiOrOneTime, ShapeableImageView imageIV, TextView lateFeePanalty, LinearLayout llAddress, LinearLayoutCompat llCenterDetail, LinearLayoutCompat llFullPayment, LinearLayout llMap, Toolbar mainToolbar, TextView mrpCutTV, TextView nameHint, TextView nameText, LinearLayout onetimeHideLL, LinearLayout openLayoutLL, TextView orderId, TextView orderIdTxt, TextView orderStatusText, TextView orderTrackStatus, TextView paymentCode, TextView paymentStatus, TextView paymentType, TextView price, TextView priceTxt, TextView priceValueTxt, LinearLayout purchaseDetails, TextView purchasedOnTxt, TextView purchasedOnValueTxt, RecyclerView recyclerInstallmentList, RelativeLayout relativeDownloadInvoice, LinearLayout rlCenterAddress, RelativeLayout rlExpire, RelativeLayout rlOrderStatus, CheckBox selectAllDelete, TextView slotHint, TextView slotText, TextView status, TextView subscriptionActive, TextView subscriptionDate, TextView subscriptionDescription, RelativeLayout subscriptionPlanDetail, RelativeLayout subscriptionPlanRL, TextView subscriptionPrice, TextView subscriptionTitle, TextView titleTV, TextView toolbarTitleTV, TextView totalPaymentDue, LinearLayout totalPaymentDueLL, Button trackUrlBtn, RelativeLayout transactionListRl, LinearLayout transactionStatement, TextView tvPaymentStatus, TextView txtDueDate, TextView txtPaymentMode, TextView txtTransactionDate, TextView upcomingInstallmentAmount, TextView validityTV, ImageView videoImage) {
        this.rootView = rootView;
        this.BlockHideLL = BlockHideLL;
        this.GSTStatus = GSTStatus;
        this.Note = Note;
        this.PaymentType = PaymentType;
        this.ProductName = ProductName;
        this.SwitchPlan = SwitchPlan;
        this.addressHint = addressHint;
        this.addressText = addressText;
        this.admitCardDownload = admitCardDownload;
        this.bookAddressLL = bookAddressLL;
        this.bookAddressTV = bookAddressTV;
        this.btnDownloadInvoice = btnDownloadInvoice;
        this.coursenameTV = coursenameTV;
        this.cvrCourseDetails = cvrCourseDetails;
        this.cvrInstallment = cvrInstallment;
        this.delete = delete;
        this.downloadInvoice = downloadInvoice;
        this.downloadInvoice2Btn = downloadInvoice2Btn;
        this.downloadInvoiceBtn = downloadInvoiceBtn;
        this.duePayment = duePayment;
        this.duePaymentLL = duePaymentLL;
        this.expiresOnTxt = expiresOnTxt;
        this.expiresOnValueTxt = expiresOnValueTxt;
        this.extendValidy = extendValidy;
        this.imageBack = imageBack;
        this.imageEmiOrOneTime = imageEmiOrOneTime;
        this.imageIV = imageIV;
        this.lateFeePanalty = lateFeePanalty;
        this.llAddress = llAddress;
        this.llCenterDetail = llCenterDetail;
        this.llFullPayment = llFullPayment;
        this.llMap = llMap;
        this.mainToolbar = mainToolbar;
        this.mrpCutTV = mrpCutTV;
        this.nameHint = nameHint;
        this.nameText = nameText;
        this.onetimeHideLL = onetimeHideLL;
        this.openLayoutLL = openLayoutLL;
        this.orderId = orderId;
        this.orderIdTxt = orderIdTxt;
        this.orderStatusText = orderStatusText;
        this.orderTrackStatus = orderTrackStatus;
        this.paymentCode = paymentCode;
        this.paymentStatus = paymentStatus;
        this.paymentType = paymentType;
        this.price = price;
        this.priceTxt = priceTxt;
        this.priceValueTxt = priceValueTxt;
        this.purchaseDetails = purchaseDetails;
        this.purchasedOnTxt = purchasedOnTxt;
        this.purchasedOnValueTxt = purchasedOnValueTxt;
        this.recyclerInstallmentList = recyclerInstallmentList;
        this.relativeDownloadInvoice = relativeDownloadInvoice;
        this.rlCenterAddress = rlCenterAddress;
        this.rlExpire = rlExpire;
        this.rlOrderStatus = rlOrderStatus;
        this.selectAllDelete = selectAllDelete;
        this.slotHint = slotHint;
        this.slotText = slotText;
        this.status = status;
        this.subscriptionActive = subscriptionActive;
        this.subscriptionDate = subscriptionDate;
        this.subscriptionDescription = subscriptionDescription;
        this.subscriptionPlanDetail = subscriptionPlanDetail;
        this.subscriptionPlanRL = subscriptionPlanRL;
        this.subscriptionPrice = subscriptionPrice;
        this.subscriptionTitle = subscriptionTitle;
        this.titleTV = titleTV;
        this.toolbarTitleTV = toolbarTitleTV;
        this.totalPaymentDue = totalPaymentDue;
        this.totalPaymentDueLL = totalPaymentDueLL;
        this.trackUrlBtn = trackUrlBtn;
        this.transactionListRl = transactionListRl;
        this.transactionStatement = transactionStatement;
        this.tvPaymentStatus = tvPaymentStatus;
        this.txtDueDate = txtDueDate;
        this.txtPaymentMode = txtPaymentMode;
        this.txtTransactionDate = txtTransactionDate;
        this.upcomingInstallmentAmount = upcomingInstallmentAmount;
        this.validityTV = validityTV;
        this.videoImage = videoImage;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityInstallmentDetailBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityInstallmentDetailBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.activity_installment_detail, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityInstallmentDetailBinding bind(View rootView) {
        int i = R.id.Block_hideLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Block_hideLL);
        if (linearLayout != null) {
            i = R.id.GST_status;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.GST_status);
            if (textView != null) {
                i = R.id.Note;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Note);
                if (textView2 != null) {
                    i = R.id.PaymentType;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.PaymentType);
                    if (textView3 != null) {
                        i = R.id.Product_Name;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.Product_Name);
                        if (textView4 != null) {
                            i = R.id.Switch_Plan;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.Switch_Plan);
                            if (linearLayout2 != null) {
                                i = R.id.address_hint;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_hint);
                                if (textView5 != null) {
                                    i = R.id.address_text;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.address_text);
                                    if (textView6 != null) {
                                        i = R.id.admit_card_download;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.admit_card_download);
                                        if (textView7 != null) {
                                            i = R.id.bookAddressLL;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.bookAddressLL);
                                            if (linearLayout3 != null) {
                                                i = R.id.bookAddressTV;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.bookAddressTV);
                                                if (textView8 != null) {
                                                    i = R.id.btnDownloadInvoice;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.btnDownloadInvoice);
                                                    if (imageView != null) {
                                                        i = R.id.coursenameTV;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.coursenameTV);
                                                        if (textView9 != null) {
                                                            i = R.id.cvrCourseDetails;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.cvrCourseDetails);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.cvrInstallment;
                                                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.cvrInstallment);
                                                                if (linearLayoutCompat != null) {
                                                                    i = R.id.delete;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.delete);
                                                                    if (textView10 != null) {
                                                                        i = R.id.download_Invoice;
                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, R.id.download_Invoice);
                                                                        if (textView11 != null) {
                                                                            i = R.id.downloadInvoice2Btn;
                                                                            Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.downloadInvoice2Btn);
                                                                            if (button != null) {
                                                                                i = R.id.downloadInvoiceBtn;
                                                                                Button button2 = (Button) ViewBindings.findChildViewById(rootView, R.id.downloadInvoiceBtn);
                                                                                if (button2 != null) {
                                                                                    i = R.id.due_payment;
                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, R.id.due_payment);
                                                                                    if (textView12 != null) {
                                                                                        i = R.id.duePaymentLL;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.duePaymentLL);
                                                                                        if (linearLayout5 != null) {
                                                                                            i = R.id.expiresOnTxt;
                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, R.id.expiresOnTxt);
                                                                                            if (textView13 != null) {
                                                                                                i = R.id.expiresOnValueTxt;
                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, R.id.expiresOnValueTxt);
                                                                                                if (textView14 != null) {
                                                                                                    i = R.id.extend_validy;
                                                                                                    Button button3 = (Button) ViewBindings.findChildViewById(rootView, R.id.extend_validy);
                                                                                                    if (button3 != null) {
                                                                                                        i = R.id.image_back;
                                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.image_back);
                                                                                                        if (imageView2 != null) {
                                                                                                            i = R.id.imageEmiOrOneTime;
                                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.imageEmiOrOneTime);
                                                                                                            if (imageView3 != null) {
                                                                                                                i = R.id.imageIV;
                                                                                                                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(rootView, R.id.imageIV);
                                                                                                                if (shapeableImageView != null) {
                                                                                                                    i = R.id.late_fee_panalty;
                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, R.id.late_fee_panalty);
                                                                                                                    if (textView15 != null) {
                                                                                                                        i = R.id.ll_address;
                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_address);
                                                                                                                        if (linearLayout6 != null) {
                                                                                                                            i = R.id.ll_center_detail;
                                                                                                                            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.ll_center_detail);
                                                                                                                            if (linearLayoutCompat2 != null) {
                                                                                                                                i = R.id.ll_full_payment;
                                                                                                                                LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) ViewBindings.findChildViewById(rootView, R.id.ll_full_payment);
                                                                                                                                if (linearLayoutCompat3 != null) {
                                                                                                                                    i = R.id.ll_map;
                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.ll_map);
                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                        i = R.id.main_toolbar;
                                                                                                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.main_toolbar);
                                                                                                                                        if (toolbar != null) {
                                                                                                                                            i = R.id.mrpCutTV;
                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, R.id.mrpCutTV);
                                                                                                                                            if (textView16 != null) {
                                                                                                                                                i = R.id.name_hint;
                                                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_hint);
                                                                                                                                                if (textView17 != null) {
                                                                                                                                                    i = R.id.name_text;
                                                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(rootView, R.id.name_text);
                                                                                                                                                    if (textView18 != null) {
                                                                                                                                                        i = R.id.onetime_hideLL;
                                                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.onetime_hideLL);
                                                                                                                                                        if (linearLayout8 != null) {
                                                                                                                                                            i = R.id.openLayoutLL;
                                                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.openLayoutLL);
                                                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                                                i = R.id.order_id;
                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(rootView, R.id.order_id);
                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                    i = R.id.orderIdTxt;
                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orderIdTxt);
                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                        i = R.id.orderStatus_text;
                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orderStatus_text);
                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                            i = R.id.orderTrackStatus;
                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(rootView, R.id.orderTrackStatus);
                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                i = R.id.payment_code;
                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(rootView, R.id.payment_code);
                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                    i = R.id.payment_status;
                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(rootView, R.id.payment_status);
                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                        i = R.id.paymentType;
                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(rootView, R.id.paymentType);
                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                            i = R.id.price;
                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(rootView, R.id.price);
                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                i = R.id.priceTxt;
                                                                                                                                                                                                TextView textView27 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceTxt);
                                                                                                                                                                                                if (textView27 != null) {
                                                                                                                                                                                                    i = R.id.priceValueTxt;
                                                                                                                                                                                                    TextView textView28 = (TextView) ViewBindings.findChildViewById(rootView, R.id.priceValueTxt);
                                                                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                                                                        i = R.id.purchaseDetails;
                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.purchaseDetails);
                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                            i = R.id.purchasedOnTxt;
                                                                                                                                                                                                            TextView textView29 = (TextView) ViewBindings.findChildViewById(rootView, R.id.purchasedOnTxt);
                                                                                                                                                                                                            if (textView29 != null) {
                                                                                                                                                                                                                i = R.id.purchasedOnValueTxt;
                                                                                                                                                                                                                TextView textView30 = (TextView) ViewBindings.findChildViewById(rootView, R.id.purchasedOnValueTxt);
                                                                                                                                                                                                                if (textView30 != null) {
                                                                                                                                                                                                                    i = R.id.recyclerInstallmentList;
                                                                                                                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.recyclerInstallmentList);
                                                                                                                                                                                                                    if (recyclerView != null) {
                                                                                                                                                                                                                        i = R.id.relativeDownload_Invoice;
                                                                                                                                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.relativeDownload_Invoice);
                                                                                                                                                                                                                        if (relativeLayout != null) {
                                                                                                                                                                                                                            i = R.id.rl_center_address;
                                                                                                                                                                                                                            LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rl_center_address);
                                                                                                                                                                                                                            if (linearLayout11 != null) {
                                                                                                                                                                                                                                i = R.id.rl_expire;
                                                                                                                                                                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_expire);
                                                                                                                                                                                                                                if (relativeLayout2 != null) {
                                                                                                                                                                                                                                    i = R.id.rl_orderStatus;
                                                                                                                                                                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.rl_orderStatus);
                                                                                                                                                                                                                                    if (relativeLayout3 != null) {
                                                                                                                                                                                                                                        i = R.id.select_all_delete;
                                                                                                                                                                                                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, R.id.select_all_delete);
                                                                                                                                                                                                                                        if (checkBox != null) {
                                                                                                                                                                                                                                            i = R.id.slot_hint;
                                                                                                                                                                                                                                            TextView textView31 = (TextView) ViewBindings.findChildViewById(rootView, R.id.slot_hint);
                                                                                                                                                                                                                                            if (textView31 != null) {
                                                                                                                                                                                                                                                i = R.id.slot_text;
                                                                                                                                                                                                                                                TextView textView32 = (TextView) ViewBindings.findChildViewById(rootView, R.id.slot_text);
                                                                                                                                                                                                                                                if (textView32 != null) {
                                                                                                                                                                                                                                                    i = R.id.status;
                                                                                                                                                                                                                                                    TextView textView33 = (TextView) ViewBindings.findChildViewById(rootView, R.id.status);
                                                                                                                                                                                                                                                    if (textView33 != null) {
                                                                                                                                                                                                                                                        i = R.id.subscription_active;
                                                                                                                                                                                                                                                        TextView textView34 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subscription_active);
                                                                                                                                                                                                                                                        if (textView34 != null) {
                                                                                                                                                                                                                                                            i = R.id.subscriptionDate;
                                                                                                                                                                                                                                                            TextView textView35 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subscriptionDate);
                                                                                                                                                                                                                                                            if (textView35 != null) {
                                                                                                                                                                                                                                                                i = R.id.subscription_description;
                                                                                                                                                                                                                                                                TextView textView36 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subscription_description);
                                                                                                                                                                                                                                                                if (textView36 != null) {
                                                                                                                                                                                                                                                                    i = R.id.subscriptionPlan_detail;
                                                                                                                                                                                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subscriptionPlan_detail);
                                                                                                                                                                                                                                                                    if (relativeLayout4 != null) {
                                                                                                                                                                                                                                                                        i = R.id.subscription_plan_RL;
                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.subscription_plan_RL);
                                                                                                                                                                                                                                                                        if (relativeLayout5 != null) {
                                                                                                                                                                                                                                                                            i = R.id.subscription_price;
                                                                                                                                                                                                                                                                            TextView textView37 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subscription_price);
                                                                                                                                                                                                                                                                            if (textView37 != null) {
                                                                                                                                                                                                                                                                                i = R.id.subscription_title;
                                                                                                                                                                                                                                                                                TextView textView38 = (TextView) ViewBindings.findChildViewById(rootView, R.id.subscription_title);
                                                                                                                                                                                                                                                                                if (textView38 != null) {
                                                                                                                                                                                                                                                                                    i = R.id.titleTV;
                                                                                                                                                                                                                                                                                    TextView textView39 = (TextView) ViewBindings.findChildViewById(rootView, R.id.titleTV);
                                                                                                                                                                                                                                                                                    if (textView39 != null) {
                                                                                                                                                                                                                                                                                        i = R.id.toolbarTitleTV;
                                                                                                                                                                                                                                                                                        TextView textView40 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbarTitleTV);
                                                                                                                                                                                                                                                                                        if (textView40 != null) {
                                                                                                                                                                                                                                                                                            i = R.id.total_payment_due;
                                                                                                                                                                                                                                                                                            TextView textView41 = (TextView) ViewBindings.findChildViewById(rootView, R.id.total_payment_due);
                                                                                                                                                                                                                                                                                            if (textView41 != null) {
                                                                                                                                                                                                                                                                                                i = R.id.totalPaymentDueLL;
                                                                                                                                                                                                                                                                                                LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.totalPaymentDueLL);
                                                                                                                                                                                                                                                                                                if (linearLayout12 != null) {
                                                                                                                                                                                                                                                                                                    i = R.id.trackUrlBtn;
                                                                                                                                                                                                                                                                                                    Button button4 = (Button) ViewBindings.findChildViewById(rootView, R.id.trackUrlBtn);
                                                                                                                                                                                                                                                                                                    if (button4 != null) {
                                                                                                                                                                                                                                                                                                        i = R.id.transactionListRl;
                                                                                                                                                                                                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.transactionListRl);
                                                                                                                                                                                                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                                                                                                                                                                                                            i = R.id.transaction_statement;
                                                                                                                                                                                                                                                                                                            LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.transaction_statement);
                                                                                                                                                                                                                                                                                                            if (linearLayout13 != null) {
                                                                                                                                                                                                                                                                                                                i = R.id.tv_payment_status;
                                                                                                                                                                                                                                                                                                                TextView textView42 = (TextView) ViewBindings.findChildViewById(rootView, R.id.tv_payment_status);
                                                                                                                                                                                                                                                                                                                if (textView42 != null) {
                                                                                                                                                                                                                                                                                                                    i = R.id.txtDueDate;
                                                                                                                                                                                                                                                                                                                    TextView textView43 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtDueDate);
                                                                                                                                                                                                                                                                                                                    if (textView43 != null) {
                                                                                                                                                                                                                                                                                                                        i = R.id.txtPaymentMode;
                                                                                                                                                                                                                                                                                                                        TextView textView44 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtPaymentMode);
                                                                                                                                                                                                                                                                                                                        if (textView44 != null) {
                                                                                                                                                                                                                                                                                                                            i = R.id.txtTransactionDate;
                                                                                                                                                                                                                                                                                                                            TextView textView45 = (TextView) ViewBindings.findChildViewById(rootView, R.id.txtTransactionDate);
                                                                                                                                                                                                                                                                                                                            if (textView45 != null) {
                                                                                                                                                                                                                                                                                                                                i = R.id.upcoming_installment_amount;
                                                                                                                                                                                                                                                                                                                                TextView textView46 = (TextView) ViewBindings.findChildViewById(rootView, R.id.upcoming_installment_amount);
                                                                                                                                                                                                                                                                                                                                if (textView46 != null) {
                                                                                                                                                                                                                                                                                                                                    i = R.id.validityTV;
                                                                                                                                                                                                                                                                                                                                    TextView textView47 = (TextView) ViewBindings.findChildViewById(rootView, R.id.validityTV);
                                                                                                                                                                                                                                                                                                                                    if (textView47 != null) {
                                                                                                                                                                                                                                                                                                                                        i = R.id.videoImage;
                                                                                                                                                                                                                                                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, R.id.videoImage);
                                                                                                                                                                                                                                                                                                                                        if (imageView4 != null) {
                                                                                                                                                                                                                                                                                                                                            return new ActivityInstallmentDetailBinding((RelativeLayout) rootView, linearLayout, textView, textView2, textView3, textView4, linearLayout2, textView5, textView6, textView7, linearLayout3, textView8, imageView, textView9, linearLayout4, linearLayoutCompat, textView10, textView11, button, button2, textView12, linearLayout5, textView13, textView14, button3, imageView2, imageView3, shapeableImageView, textView15, linearLayout6, linearLayoutCompat2, linearLayoutCompat3, linearLayout7, toolbar, textView16, textView17, textView18, linearLayout8, linearLayout9, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, linearLayout10, textView29, textView30, recyclerView, relativeLayout, linearLayout11, relativeLayout2, relativeLayout3, checkBox, textView31, textView32, textView33, textView34, textView35, textView36, relativeLayout4, relativeLayout5, textView37, textView38, textView39, textView40, textView41, linearLayout12, button4, relativeLayout6, linearLayout13, textView42, textView43, textView44, textView45, textView46, textView47, imageView4);
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
