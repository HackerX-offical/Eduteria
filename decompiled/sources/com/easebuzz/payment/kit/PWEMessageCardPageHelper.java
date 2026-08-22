package com.easebuzz.payment.kit;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.amazonaws.services.s3.util.Mimetypes;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import datamodels.PWEStaticDataModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PWEMessageCardPageHelper {
    private LinearLayout activityLinearOpenMessage;
    private TextView activityTvShortMessage;
    private Context context;
    private PWEGeneralHelper generalHelper;
    boolean isSlideUp = false;
    private ImageView ivCloseMessage;
    private View messageBottomSheet;
    private BottomSheetBehavior msgBottomSheetBehaviour;
    private CoordinatorLayout msgContainerLayout;
    private PWEPaymentInfoHandler paymentInfoHandler;
    private WebView wvMessageDescription;

    public PWEMessageCardPageHelper(Context context) {
        this.context = context;
        this.generalHelper = new PWEGeneralHelper(this.context);
        this.paymentInfoHandler = new PWEPaymentInfoHandler(this.context);
    }

    public void initializeMessageLayoutNew(LinearLayout linearLayout, TextView textView, View view, CoordinatorLayout coordinatorLayout, ImageView imageView, WebView webView) {
        this.activityLinearOpenMessage = linearLayout;
        this.activityTvShortMessage = textView;
        this.messageBottomSheet = view;
        this.msgBottomSheetBehaviour = BottomSheetBehavior.from(view);
        this.msgContainerLayout = coordinatorLayout;
        this.ivCloseMessage = imageView;
        this.wvMessageDescription = webView;
        imageView.animate().scaleX(0.0f).scaleY(0.0f).setDuration(0L).start();
        this.msgBottomSheetBehaviour.setState(5);
        this.ivCloseMessage.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEMessageCardPageHelper.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PWEMessageCardPageHelper.this.closeMessage();
            }
        });
        this.msgBottomSheetBehaviour.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.easebuzz.payment.kit.PWEMessageCardPageHelper.2
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view2, float f2) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view2, int i) {
                if (i == 1) {
                    PWEMessageCardPageHelper.this.msgBottomSheetBehaviour.setState(3);
                }
            }
        });
        this.activityLinearOpenMessage.setOnClickListener(new View.OnClickListener() { // from class: com.easebuzz.payment.kit.PWEMessageCardPageHelper.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PWEMessageCardPageHelper.this.showMessageView();
                PWEMessageCardPageHelper.this.activityLinearOpenMessage.setVisibility(8);
            }
        });
    }

    public void updateMessageLayoutHeight() {
        int measuredHeight = this.wvMessageDescription.getMeasuredHeight();
        if (measuredHeight != 0 && measuredHeight >= 500) {
            this.wvMessageDescription.setLayoutParams(new LinearLayout.LayoutParams(-1, 500));
        } else {
            this.wvMessageDescription.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void showMessageView() {
        updateMessageLayoutHeight();
        this.msgBottomSheetBehaviour.setState(3);
        this.ivCloseMessage.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300L).start();
        this.isSlideUp = true;
    }

    public void showMessage(String str) {
        try {
            JSONObject cardPageMessage = this.generalHelper.getCardPageMessage(str);
            if (!cardPageMessage.toString().isEmpty() && cardPageMessage.optBoolean("status", false)) {
                String strOptString = cardPageMessage.optString("short_message", "");
                String strOptString2 = cardPageMessage.optString("description", "");
                this.paymentInfoHandler.setShowMessageFlag(true);
                this.activityLinearOpenMessage.setVisibility(0);
                this.msgContainerLayout.setVisibility(0);
                this.activityTvShortMessage.setVisibility(0);
                this.activityTvShortMessage.setText(Html.fromHtml(strOptString));
                this.wvMessageDescription.loadData(strOptString2, Mimetypes.MIMETYPE_HTML, "UTF-8");
                this.wvMessageDescription.setWebViewClient(new WebViewClient());
                this.wvMessageDescription.getSettings().setJavaScriptEnabled(true);
                this.wvMessageDescription.setBackgroundColor(this.context.getResources().getColor(R.color.pwe_note_background_color));
                return;
            }
            this.paymentInfoHandler.setShowMessageFlag(false);
            this.activityLinearOpenMessage.setVisibility(8);
            this.activityTvShortMessage.setVisibility(8);
            this.msgContainerLayout.setVisibility(8);
        } catch (Error unused) {
            this.paymentInfoHandler.setShowMessageFlag(false);
        } catch (Exception unused2) {
            this.paymentInfoHandler.setShowMessageFlag(false);
        }
    }

    public void closeMessage() {
        if (this.isSlideUp) {
            this.activityLinearOpenMessage.setVisibility(0);
            this.ivCloseMessage.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300L).start();
            this.msgBottomSheetBehaviour.setState(5);
            this.isSlideUp = false;
            if (PWEStaticDataModel.PWE_MODE_SELECTED.equals("paymentoption") || PWEStaticDataModel.PWE_MODE_SELECTED.equals("cashbackcoupons")) {
                showMessage("global");
            } else {
                showMessage(this.paymentInfoHandler.getSelectedPaymentOption());
            }
        }
    }
}
