package com.appnew.android.PurchaseHistory.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.appnew.android.Model.Emi;
import com.appnew.android.Model.PostFile;
import com.appnew.android.Model.SubscriptionData;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Payment.IOnViewDetailsClick;
import com.appnew.android.PurchaseHistory.activity.InstallmentDetailActivity;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.home.Constants;
import com.eduteria.app.app.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class AdapterInstallmentDetailsq extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity context;
    IOnViewDetailsClick iOnViewDetailsClick;
    String is_subscription;
    List<Emi> modelEmis;
    List<SubscriptionData> subscriptionData;
    long time;
    String type;

    public AdapterInstallmentDetailsq(List<Emi> modelEmis, Activity context, IOnViewDetailsClick iOnViewDetailsClick, String is_subscription, long time) {
        this.modelEmis = modelEmis;
        this.context = context;
        this.iOnViewDetailsClick = iOnViewDetailsClick;
        this.is_subscription = is_subscription;
        this.time = time;
    }

    public AdapterInstallmentDetailsq(List<SubscriptionData> subscriptionData, Activity context, String is_subscription, long time, String type) {
        this.subscriptionData = subscriptionData;
        this.context = context;
        this.is_subscription = is_subscription;
        this.time = time;
        this.type = type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ExViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_installment_item, parent, false));
        }
        return new SubscriptionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_subscription_plan, parent, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        String str = this.type;
        return (str == null || !str.equalsIgnoreCase(Const.SUBSCRIPTION)) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            ExViewHolder exViewHolder = (ExViewHolder) holder;
            exViewHolder.setData(exViewHolder, position);
        } else {
            SubscriptionViewHolder subscriptionViewHolder = (SubscriptionViewHolder) holder;
            subscriptionViewHolder.setData(subscriptionViewHolder, position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadInvoice(String data) {
        final PostFile postFile = new PostFile();
        postFile.setLink(data);
        postFile.setFile_type(Const.COURSE_INVOICE);
        String str = data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1];
        if (!str.contains("")) {
            postFile.setFile_info(data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[data.split(MqttTopic.TOPIC_LEVEL_SEPARATOR).length - 1]);
        } else {
            postFile.setFile_info(str.replaceAll(" ", "_"));
        }
        try {
            Dexter.withContext(this.context).withPermissions("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").withListener(new MultiplePermissionsListener() { // from class: com.appnew.android.PurchaseHistory.adapter.AdapterInstallmentDetailsq.1
                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionsChecked(MultiplePermissionsReport report) {
                    if (Helper.getStorageInstance(AdapterInstallmentDetailsq.this.context).getRecordObject(Const.COURSE_INVOICE) != null) {
                        Helper.DownloadfilefromURL(AdapterInstallmentDetailsq.this.context, (PostFile) Helper.getStorageInstance(AdapterInstallmentDetailsq.this.context).getRecordObject(Const.COURSE_INVOICE));
                        Helper.getStorageInstance(AdapterInstallmentDetailsq.this.context).deleteRecord(Const.COURSE_INVOICE);
                        return;
                    }
                    Helper.DownloadfilefromURL(AdapterInstallmentDetailsq.this.context, postFile);
                }

                @Override // com.karumi.dexter.listener.multi.MultiplePermissionsListener
                public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                    token.continuePermissionRequest();
                }
            }).check();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getdate(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(14, TimeZone.getDefault().getOffset(calendar.getTimeInMillis()));
        return new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date(Long.parseLong(String.valueOf(timestamp))));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SubscriptionData> list = this.subscriptionData;
        if (list != null) {
            return list.size();
        }
        return this.modelEmis.size();
    }

    public class ExViewHolder extends RecyclerView.ViewHolder {
        TextView btnDownloadInvoice;
        TextView btnQRPay;
        LinearLayoutCompat cvrDueDate;
        CardView cvrShowHide;
        LinearLayoutCompat cvrTransaction;
        LinearLayoutCompat discountAmountLLC;
        TextView discountAmountTV;
        TextView txtDueDate;
        TextView txtEmiStatus;
        TextView txtInstallment;
        TextView txtMrp;
        TextView txtPaymentMode;
        TextView txtStatus;
        TextView txtTransactionDate;

        public ExViewHolder(View itemView) {
            super(itemView);
            this.txtInstallment = (TextView) itemView.findViewById(R.id.txtInstallment);
            this.cvrShowHide = (CardView) itemView.findViewById(R.id.cvrShowHide);
            this.txtMrp = (TextView) itemView.findViewById(R.id.txtMrp);
            this.txtDueDate = (TextView) itemView.findViewById(R.id.txtDueDate);
            this.txtTransactionDate = (TextView) itemView.findViewById(R.id.txtTransactionDate);
            this.txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
            this.txtPaymentMode = (TextView) itemView.findViewById(R.id.txtPaymentMode);
            this.btnQRPay = (TextView) itemView.findViewById(R.id.btnQRPay);
            this.btnDownloadInvoice = (TextView) itemView.findViewById(R.id.btnDownloadInvoice);
            this.cvrTransaction = (LinearLayoutCompat) itemView.findViewById(R.id.cvrTransaction);
            this.cvrDueDate = (LinearLayoutCompat) itemView.findViewById(R.id.cvrDueDate);
            this.txtEmiStatus = (TextView) itemView.findViewById(R.id.txtEmiStatus);
            this.discountAmountLLC = (LinearLayoutCompat) itemView.findViewById(R.id.discountAmountLLC);
            this.discountAmountTV = (TextView) itemView.findViewById(R.id.discountAmountTV);
        }

        public void setData(final ExViewHolder holder, final int position) {
            holder.txtInstallment.setText("Installment " + AdapterInstallmentDetailsq.this.modelEmis.get(position).getEmiNo());
            if (AdapterInstallmentDetailsq.this.modelEmis.get(position).getExpand()) {
                holder.cvrShowHide.setVisibility(0);
            } else {
                holder.cvrShowHide.setVisibility(8);
            }
            if (!TextUtils.isEmpty(AdapterInstallmentDetailsq.this.modelEmis.get(position).getDiscount_amount()) && !AdapterInstallmentDetailsq.this.modelEmis.get(position).getDiscount_amount().equalsIgnoreCase("0")) {
                holder.discountAmountLLC.setVisibility(0);
                holder.discountAmountTV.setText(AdapterInstallmentDetailsq.this.modelEmis.get(position).getDiscount_amount());
            } else {
                holder.discountAmountLLC.setVisibility(8);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.PurchaseHistory.adapter.AdapterInstallmentDetailsq$ExViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$setData$0(position, view);
                }
            });
            Double dValueOf = Double.valueOf(Double.parseDouble(AdapterInstallmentDetailsq.this.modelEmis.get(position).getTotalMrp()));
            holder.txtMrp.setText(Constants.currencyType + dValueOf);
            TextView textView = holder.txtDueDate;
            AdapterInstallmentDetailsq adapterInstallmentDetailsq = AdapterInstallmentDetailsq.this;
            textView.setText(adapterInstallmentDetailsq.getdate(Long.parseLong(String.valueOf(Long.parseLong(adapterInstallmentDetailsq.modelEmis.get(position).getCreation_date()) * 1000))));
            if (!TextUtils.isEmpty(AdapterInstallmentDetailsq.this.modelEmis.get(position).getCreated())) {
                holder.cvrTransaction.setVisibility(0);
                TextView textView2 = holder.txtTransactionDate;
                AdapterInstallmentDetailsq adapterInstallmentDetailsq2 = AdapterInstallmentDetailsq.this;
                textView2.setText(adapterInstallmentDetailsq2.getdate(Long.parseLong(String.valueOf(Long.parseLong(adapterInstallmentDetailsq2.modelEmis.get(position).getCreated()) * 1000))));
            } else {
                holder.cvrTransaction.setVisibility(8);
            }
            if (AdapterInstallmentDetailsq.this.modelEmis.get(position).getTxnStatus().equalsIgnoreCase("1")) {
                holder.txtStatus.setText(AdapterInstallmentDetailsq.this.modelEmis.get(position).getEmi_status());
                holder.txtEmiStatus.setText(AdapterInstallmentDetailsq.this.modelEmis.get(position).getEmi_status());
                holder.cvrDueDate.setVisibility(8);
                holder.btnDownloadInvoice.setText(AdapterInstallmentDetailsq.this.context.getResources().getString(R.string.download_invoice));
                if (dValueOf.doubleValue() == 0.0d) {
                    holder.btnDownloadInvoice.setVisibility(8);
                } else {
                    holder.btnDownloadInvoice.setVisibility(0);
                }
            } else if (InstallmentDetailActivity.countForCheck.equalsIgnoreCase(String.valueOf(position))) {
                if (dValueOf.doubleValue() <= 0.0d) {
                    holder.btnDownloadInvoice.setText("Add");
                } else {
                    holder.btnDownloadInvoice.setText(AdapterInstallmentDetailsq.this.context.getResources().getString(R.string.pay_now));
                }
                if (AdapterInstallmentDetailsq.this.is_subscription == null || !AdapterInstallmentDetailsq.this.is_subscription.equalsIgnoreCase("1") || AdapterInstallmentDetailsq.this.modelEmis.get(position).getAutopay_status().equalsIgnoreCase("1") || AdapterInstallmentDetailsq.this.time > Long.parseLong(AdapterInstallmentDetailsq.this.modelEmis.get(position).getCreation_date()) + 86400) {
                    holder.btnDownloadInvoice.setVisibility(0);
                } else {
                    holder.btnDownloadInvoice.setVisibility(8);
                }
                holder.btnDownloadInvoice.setText(AdapterInstallmentDetailsq.this.context.getResources().getString(R.string.pay_now));
                holder.cvrDueDate.setVisibility(0);
                holder.txtEmiStatus.setText(AdapterInstallmentDetailsq.this.modelEmis.get(position).getEmi_status());
                holder.txtStatus.setText(AdapterInstallmentDetailsq.this.modelEmis.get(position).getEmi_status());
            } else {
                holder.txtEmiStatus.setText(AdapterInstallmentDetailsq.this.modelEmis.get(position).getEmi_status());
                holder.txtStatus.setText(AdapterInstallmentDetailsq.this.modelEmis.get(position).getEmi_status());
                holder.cvrDueDate.setVisibility(0);
                holder.btnDownloadInvoice.setVisibility(8);
            }
            if (holder.txtEmiStatus.getText().toString().trim().equalsIgnoreCase("Paid")) {
                holder.txtEmiStatus.setTextColor(AdapterInstallmentDetailsq.this.context.getResources().getColor(R.color.green));
            } else if (holder.txtEmiStatus.getText().toString().trim().equalsIgnoreCase("Over Due")) {
                holder.txtEmiStatus.setTextColor(AdapterInstallmentDetailsq.this.context.getResources().getColor(R.color.colorOrange));
            } else {
                holder.txtEmiStatus.setTextColor(AdapterInstallmentDetailsq.this.context.getResources().getColor(R.color.red));
            }
            if (Helper.enableQRCode() && holder.btnDownloadInvoice.getVisibility() == 0 && holder.btnDownloadInvoice.getText().toString().trim().equalsIgnoreCase(AdapterInstallmentDetailsq.this.context.getResources().getString(R.string.pay_now))) {
                holder.btnQRPay.setVisibility(0);
            } else {
                holder.btnQRPay.setVisibility(8);
            }
            holder.btnQRPay.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.PurchaseHistory.adapter.AdapterInstallmentDetailsq$ExViewHolder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$setData$1(holder, position);
                }
            }));
            holder.btnDownloadInvoice.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.PurchaseHistory.adapter.AdapterInstallmentDetailsq$ExViewHolder$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$setData$2(holder, position);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setData$0(int i, View view) {
            if (AdapterInstallmentDetailsq.this.modelEmis.get(i).getExpand()) {
                AdapterInstallmentDetailsq.this.modelEmis.get(i).setExpand(false);
                AdapterInstallmentDetailsq.this.notifyDataSetChanged();
            } else {
                if (AdapterInstallmentDetailsq.this.modelEmis.get(i).getExpand()) {
                    return;
                }
                AdapterInstallmentDetailsq.this.modelEmis.get(i).setExpand(true);
                AdapterInstallmentDetailsq.this.notifyDataSetChanged();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$1(ExViewHolder exViewHolder, int i) {
            if (exViewHolder.btnDownloadInvoice.getText().toString().trim().equalsIgnoreCase(AdapterInstallmentDetailsq.this.context.getResources().getString(R.string.download_invoice))) {
                if (!AdapterInstallmentDetailsq.this.modelEmis.get(exViewHolder.getAbsoluteAdapterPosition()).getInvoiceUrl().isEmpty()) {
                    AdapterInstallmentDetailsq adapterInstallmentDetailsq = AdapterInstallmentDetailsq.this;
                    adapterInstallmentDetailsq.downloadInvoice(adapterInstallmentDetailsq.modelEmis.get(exViewHolder.getAbsoluteAdapterPosition()).getInvoiceUrl());
                    return null;
                }
                Helper.showToast(AdapterInstallmentDetailsq.this.context, "Invoice not found", 1);
                return null;
            }
            if (exViewHolder.btnDownloadInvoice.getText().toString().trim().equalsIgnoreCase("Add")) {
                AdapterInstallmentDetailsq.this.iOnViewDetailsClick.onViewDetailsClick(i, "Add", true);
                return null;
            }
            AdapterInstallmentDetailsq.this.iOnViewDetailsClick.onViewDetailsClick(i, "Do Payment", true);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$2(ExViewHolder exViewHolder, int i) {
            if (exViewHolder.btnDownloadInvoice.getText().toString().trim().equalsIgnoreCase(AdapterInstallmentDetailsq.this.context.getResources().getString(R.string.download_invoice))) {
                if (!AdapterInstallmentDetailsq.this.modelEmis.get(exViewHolder.getAbsoluteAdapterPosition()).getInvoiceUrl().isEmpty()) {
                    AdapterInstallmentDetailsq adapterInstallmentDetailsq = AdapterInstallmentDetailsq.this;
                    adapterInstallmentDetailsq.downloadInvoice(adapterInstallmentDetailsq.modelEmis.get(exViewHolder.getAbsoluteAdapterPosition()).getInvoiceUrl());
                    return null;
                }
                Helper.showToast(AdapterInstallmentDetailsq.this.context, "Invoice not found", 1);
                return null;
            }
            if (exViewHolder.btnDownloadInvoice.getText().toString().trim().equalsIgnoreCase("Add")) {
                AdapterInstallmentDetailsq.this.iOnViewDetailsClick.onViewDetailsClick(i, "Add", false);
                return null;
            }
            AdapterInstallmentDetailsq.this.iOnViewDetailsClick.onViewDetailsClick(i, "Do Payment", false);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SubscriptionViewHolder extends RecyclerView.ViewHolder {
        TextView btnDownloadInvoice;
        TextView btnQRPay;
        LinearLayoutCompat cvrDueDate;
        CardView cvrShowHide;
        LinearLayoutCompat cvrTransaction;
        LinearLayoutCompat discountAmountLLC;
        TextView discountAmountTV;
        TextView txtDueDate;
        TextView txtEmiStatus;
        TextView txtInstallment;
        TextView txtMrp;
        TextView txtPaymentMode;
        TextView txtStatus;
        TextView txtTransactionDate;

        public SubscriptionViewHolder(View itemView) {
            super(itemView);
            this.txtInstallment = (TextView) itemView.findViewById(R.id.txtInstallment);
            this.txtMrp = (TextView) itemView.findViewById(R.id.txtMrp);
            this.txtTransactionDate = (TextView) itemView.findViewById(R.id.txtTransactionDate);
            this.txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
            this.txtPaymentMode = (TextView) itemView.findViewById(R.id.txtPaymentMode);
            this.btnQRPay = (TextView) itemView.findViewById(R.id.btnQRPay);
            this.btnDownloadInvoice = (TextView) itemView.findViewById(R.id.btnDownloadInvoice);
            this.cvrTransaction = (LinearLayoutCompat) itemView.findViewById(R.id.cvrTransaction);
            this.cvrDueDate = (LinearLayoutCompat) itemView.findViewById(R.id.cvrDueDate);
            this.txtEmiStatus = (TextView) itemView.findViewById(R.id.txtEmiStatus);
            this.discountAmountLLC = (LinearLayoutCompat) itemView.findViewById(R.id.discountAmountLLC);
            this.discountAmountTV = (TextView) itemView.findViewById(R.id.discountAmountTV);
        }

        public void setData(final SubscriptionViewHolder holder, int position) {
            holder.txtMrp.setText(Constants.currencyType + Double.valueOf(Double.parseDouble(AdapterInstallmentDetailsq.this.subscriptionData.get(position).getMrp())) + "/-");
            TextView textView = holder.txtTransactionDate;
            AdapterInstallmentDetailsq adapterInstallmentDetailsq = AdapterInstallmentDetailsq.this;
            textView.setText(adapterInstallmentDetailsq.getdate(Long.parseLong(String.valueOf(Long.parseLong(adapterInstallmentDetailsq.subscriptionData.get(position).getPurchase_date()) * 1000))));
            if (!AdapterInstallmentDetailsq.this.subscriptionData.get(position).getInvoice_url().isEmpty()) {
                holder.btnDownloadInvoice.setVisibility(0);
            } else {
                holder.btnDownloadInvoice.setVisibility(8);
            }
            holder.btnQRPay.setVisibility(8);
            if (AdapterInstallmentDetailsq.this.subscriptionData.get(position).getExpand()) {
                holder.cvrShowHide.setVisibility(0);
            } else {
                holder.txtStatus.setText(AdapterInstallmentDetailsq.this.context.getResources().getString(R.string.failed));
                holder.txtStatus.setTextColor(AdapterInstallmentDetailsq.this.context.getResources().getColor(R.color.red));
            }
            holder.btnDownloadInvoice.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.PurchaseHistory.adapter.AdapterInstallmentDetailsq$SubscriptionViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$setData$0(holder);
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$setData$0(SubscriptionViewHolder subscriptionViewHolder) {
            if (!AdapterInstallmentDetailsq.this.subscriptionData.get(subscriptionViewHolder.getAbsoluteAdapterPosition()).getInvoice_url().isEmpty()) {
                AdapterInstallmentDetailsq adapterInstallmentDetailsq = AdapterInstallmentDetailsq.this;
                adapterInstallmentDetailsq.downloadInvoice(adapterInstallmentDetailsq.subscriptionData.get(subscriptionViewHolder.getAbsoluteAdapterPosition()).getInvoice_url());
                return null;
            }
            Helper.showToast(AdapterInstallmentDetailsq.this.context, "Invoice not found", 1);
            return null;
        }
    }
}
