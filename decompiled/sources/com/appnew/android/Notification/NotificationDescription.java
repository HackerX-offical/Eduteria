package com.appnew.android.Notification;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.Courses.Activity.WebFragActivity;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.GenericUtils;
import com.appnew.android.Utils.Helper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.eduteria.app.app.R;
import com.razorpay.CheckoutConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
public class NotificationDescription extends AppCompatActivity {
    private Context context;
    TextView date_time;
    String description;
    ImageView description_imageView;
    TextView description_textView;
    TextView description_urlTV;
    String imageUrl;
    ImageView image_back;
    ConstraintLayout layout;
    TextView markasread;
    String time;
    String title;
    TextView toolbarTitleTV;
    String url;
    String urlType;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper.setSystemBarLight(this);
        Helper.enableScreenShot(this);
        setContentView(R.layout.activity_notification_description);
        this.context = this;
        if (getIntent() != null) {
            this.title = getIntent().getStringExtra("title");
            this.url = getIntent().getStringExtra("url");
            this.imageUrl = getIntent().getStringExtra("imageUrl");
            this.description = getIntent().getStringExtra("description");
            this.urlType = getIntent().getStringExtra("urlType");
            this.time = getIntent().getStringExtra("time");
        }
        this.description_textView = (TextView) findViewById(R.id.description_textView);
        this.description_urlTV = (TextView) findViewById(R.id.description_urlTV);
        TextView textView = (TextView) findViewById(R.id.toolbarTitleTV);
        this.toolbarTitleTV = textView;
        textView.setSelected(true);
        TextView textView2 = (TextView) findViewById(R.id.markasread);
        this.markasread = textView2;
        textView2.setVisibility(8);
        this.image_back = (ImageView) findViewById(R.id.image_back);
        this.description_imageView = (ImageView) findViewById(R.id.description_imageView);
        this.layout = (ConstraintLayout) findViewById(R.id.layout);
        this.date_time = (TextView) findViewById(R.id.date_time);
        if (this.urlType.equalsIgnoreCase(CheckoutConstants.URL)) {
            this.description_urlTV.setText(this.url);
            this.description_textView.setText(this.description);
            this.date_time.setText(this.time);
            if (this.description != null) {
                this.description_textView.setText(Html.fromHtml(this.description, 63));
            }
            this.layout.setVisibility(8);
        } else if (this.urlType.equalsIgnoreCase("IMAGE")) {
            this.description_textView.setText(this.description);
            if (GenericUtils.isEmpty(this.time)) {
                this.date_time.setVisibility(8);
            } else {
                this.date_time.setVisibility(0);
                this.date_time.setText(this.time);
            }
            if (this.description != null) {
                this.description_textView.setText(Html.fromHtml(this.description, 63));
            }
            this.layout.setVisibility(0);
            this.description_urlTV.setVisibility(8);
            if (!TextUtils.isEmpty(this.imageUrl)) {
                Glide.with((FragmentActivity) this).load(this.imageUrl).apply((BaseRequestOptions<?>) new RequestOptions().centerCrop().placeholder(R.mipmap.ic_launcher_round).error(R.mipmap.ic_launcher_round)).into(this.description_imageView);
            }
        } else if (this.urlType.equalsIgnoreCase("GENERAL")) {
            this.description_urlTV.setVisibility(8);
            this.description_urlTV.setText(this.url);
            this.description_textView.setText(this.description);
            this.date_time.setText(this.time);
            if (this.description != null) {
                this.description_textView.setText(Html.fromHtml(this.description, 63));
            }
            this.layout.setVisibility(8);
        }
        this.description_urlTV.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.Notification.NotificationDescription.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent intent = new Intent(NotificationDescription.this.context, (Class<?>) WebFragActivity.class);
                intent.putExtra("title", NotificationDescription.this.title);
                intent.putExtra("url", NotificationDescription.this.url);
                NotificationDescription.this.startActivity(intent);
            }
        });
        this.image_back.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.Notification.NotificationDescription$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$onCreate$0();
            }
        }));
        setToolBarTitle(this.title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0() {
        finish();
        return null;
    }

    public void setToolBarTitle(String title) {
        this.toolbarTitleTV.setText(title);
    }
}
