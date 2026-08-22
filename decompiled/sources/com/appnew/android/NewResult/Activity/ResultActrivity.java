package com.appnew.android.NewResult.Activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.EncryptionModel.EncryptionData;
import com.appnew.android.ExtensionFunctions.XtensionFunctionKt;
import com.appnew.android.NewResult.Fragment.DemoBase;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.AES;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Helper;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.Network.APIInterface;
import com.appnew.android.Utils.Network.NetworkCall;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.Zoom.Activity.AllDoubtsFragmentKt;
import com.appnew.android.Zoom.Adapter.DoubtsViewPagerAdapter;
import com.appnew.android.databinding.ActivityResultActrivityBinding;
import com.appnew.android.testmodule.activity.ViewSolutionActivity;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.clevertap.android.sdk.Constants;
import com.eduteria.app.app.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smackx.iot.control.element.IoTSetResponse;
import org.json.JSONObject;
import retrofit2.Call;

/* JADX INFO: compiled from: ResultActrivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0015J&\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NJ\"\u0010Q\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u00010B2\u0006\u0010S\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020HH\u0014J\u0012\u0010W\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010X\u001a\u00020H2\b\u0010R\u001a\u0004\u0018\u00010BH\u0016J\u0018\u0010Y\u001a\u00020H2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020HH\u0016J,\u0010_\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010\"2\b\u0010b\u001a\u0004\u0018\u00010\"2\u0006\u0010c\u001a\u00020dH\u0016J,\u0010e\u001a\u00020H2\u0006\u0010f\u001a\u00020g2\b\u0010a\u001a\u0004\u0018\u00010\"2\b\u0010b\u001a\u0004\u0018\u00010\"2\u0006\u0010h\u001a\u00020UH\u0017J&\u0010i\u001a\u00020H2\b\u0010j\u001a\u0004\u0018\u00010\"2\b\u0010a\u001a\u0004\u0018\u00010\"2\b\u0010b\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010k\u001a\u00020HH\u0003R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001c\u0010*\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001c\u0010-\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\u001c\u00100\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001c\u00103\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\u001c\u00106\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020BX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/appnew/android/NewResult/Activity/ResultActrivity;", "Lcom/appnew/android/NewResult/Fragment/DemoBase;", "Lcom/appnew/android/Utils/Network/NetworkCall$MyNetworkCallBack;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/ActivityResultActrivityBinding;", "getBinding", "()Lcom/appnew/android/databinding/ActivityResultActrivityBinding;", "setBinding", "(Lcom/appnew/android/databinding/ActivityResultActrivityBinding;)V", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "view_pager", "Landroidx/viewpager/widget/ViewPager;", "adapter", "Lcom/appnew/android/Zoom/Adapter/DoubtsViewPagerAdapter;", "image_back", "Landroid/widget/ImageView;", "getImage_back", "()Landroid/widget/ImageView;", "setImage_back", "(Landroid/widget/ImageView;)V", "lang", "", "getLang", "()I", "setLang", "(I)V", "resultTestSeries2", "Lcom/appnew/android/testmodule/model/ResultTestSeries_Report;", Const.FRAG_TYPE, "", "getFrag_type", "()Ljava/lang/String;", "setFrag_type", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "testSeriesName", "getTestSeriesName", "setTestSeriesName", "testName", "getTestName", "setTestName", "first_attempt", "getFirst_attempt", "setFirst_attempt", "show_leader", "getShow_leader", "setShow_leader", SaslNonza.Response.ELEMENT, "getResponse", IoTSetResponse.ELEMENT, "networkCall", "Lcom/appnew/android/Utils/Network/NetworkCall;", "getNetworkCall", "()Lcom/appnew/android/Utils/Network/NetworkCall;", "setNetworkCall", "(Lcom/appnew/android/Utils/Network/NetworkCall;)V", "chart", "Lcom/github/mikephil/charting/charts/BarChart;", "seekBarX", "Landroid/widget/SeekBar;", "seekBarY", "tvX", "Landroid/widget/TextView;", "tvY", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setGraphData", "size", Const.correct, "", Const.incorrect, Const.unattempted, "onProgressChanged", "seekBar", "progress", "fromUser", "", "saveToGallery", "onStartTrackingTouch", "onStopTrackingTouch", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "onNothingSelected", "getAPIB", "Lretrofit2/Call;", "apitype", "typeApi", NotificationCompat.CATEGORY_SERVICE, "Lcom/appnew/android/Utils/Network/APIInterface;", "SuccessCallBack", "jsonResponse", "Lorg/json/JSONObject;", "showprogress", "ErrorCallBack", "jsonstring", "setData", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultActrivity extends DemoBase implements NetworkCall.MyNetworkCallBack, SeekBar.OnSeekBarChangeListener, OnChartValueSelectedListener {
    public static final int $stable = 8;
    private DoubtsViewPagerAdapter adapter;
    public ActivityResultActrivityBinding binding;
    private BarChart chart;
    private ImageView image_back;
    private int lang;
    private NetworkCall networkCall;
    private ResultTestSeries_Report resultTestSeries2;
    private SeekBar seekBarX;
    private SeekBar seekBarY;
    private TabLayout tabLayout;
    private TextView tvX;
    private TextView tvY;
    private ViewPager view_pager;
    private String frag_type = "";
    private String status = "";
    private String testSeriesName = "";
    private String testName = "";
    private String first_attempt = "";
    private String show_leader = "";
    private String response = "";

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onNothingSelected() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onValueSelected(Entry e2, Highlight h2) {
        Intrinsics.checkNotNullParameter(e2, "e");
        Intrinsics.checkNotNullParameter(h2, "h");
    }

    public final ActivityResultActrivityBinding getBinding() {
        ActivityResultActrivityBinding activityResultActrivityBinding = this.binding;
        if (activityResultActrivityBinding != null) {
            return activityResultActrivityBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(ActivityResultActrivityBinding activityResultActrivityBinding) {
        Intrinsics.checkNotNullParameter(activityResultActrivityBinding, "<set-?>");
        this.binding = activityResultActrivityBinding;
    }

    public final ImageView getImage_back() {
        return this.image_back;
    }

    public final void setImage_back(ImageView imageView) {
        this.image_back = imageView;
    }

    public final int getLang() {
        return this.lang;
    }

    public final void setLang(int i) {
        this.lang = i;
    }

    public final String getFrag_type() {
        return this.frag_type;
    }

    public final void setFrag_type(String str) {
        this.frag_type = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getTestSeriesName() {
        return this.testSeriesName;
    }

    public final void setTestSeriesName(String str) {
        this.testSeriesName = str;
    }

    public final String getTestName() {
        return this.testName;
    }

    public final void setTestName(String str) {
        this.testName = str;
    }

    public final String getFirst_attempt() {
        return this.first_attempt;
    }

    public final void setFirst_attempt(String str) {
        this.first_attempt = str;
    }

    public final String getShow_leader() {
        return this.show_leader;
    }

    public final void setShow_leader(String str) {
        this.show_leader = str;
    }

    public final String getResponse() {
        return this.response;
    }

    public final void setResponse(String str) {
        this.response = str;
    }

    public final NetworkCall getNetworkCall() {
        return this.networkCall;
    }

    public final void setNetworkCall(NetworkCall networkCall) {
        this.networkCall = networkCall;
    }

    @Override // com.appnew.android.NewResult.Fragment.DemoBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResultActrivity resultActrivity = this;
        Helper.setSystemBarLight(resultActrivity);
        setBinding(ActivityResultActrivityBinding.inflate(getLayoutInflater()));
        setContentView(getBinding().getRoot());
        Helper.setSystemBarLight(resultActrivity);
        Helper.enableScreenShot(resultActrivity);
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            this.frag_type = extras.getString(Const.FRAG_TYPE);
            Bundle extras2 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras2);
            this.status = extras2.getString("status");
            Bundle extras3 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras3);
            this.testName = extras3.getString("testName");
            Bundle extras4 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras4);
            this.show_leader = extras4.getString("show_leader");
            Bundle extras5 = getIntent().getExtras();
            Intrinsics.checkNotNull(extras5);
            this.first_attempt = extras5.getString("first_attempt");
        }
        NetworkCall networkCall = new NetworkCall(this, this);
        this.networkCall = networkCall;
        Intrinsics.checkNotNull(networkCall);
        networkCall.NetworkAPICall(API.API_TEST_RESULT, "", false, false);
        Button button = getBinding().overallBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.NewResult.Activity.ResultActrivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultActrivity.onCreate$lambda$0(this.f$0, view);
                }
            });
        }
        LinearLayout linearLayout = getBinding().resultUserLinear;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.NewResult.Activity.ResultActrivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultActrivity.onCreate$lambda$1(this.f$0, view);
                }
            });
        }
        LinearLayout linearLayout2 = getBinding().resultTopperLinear;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.NewResult.Activity.ResultActrivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultActrivity.onCreate$lambda$2(this.f$0, view);
                }
            });
        }
        ImageView imageView = getBinding().doubtImageBack;
        if (imageView != null) {
            imageView.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.NewResult.Activity.ResultActrivity$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ResultActrivity.onCreate$lambda$3(this.f$0);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ResultActrivity resultActrivity, View view) {
        if (resultActrivity.resultTestSeries2 != null) {
            resultActrivity.startActivity(new Intent(resultActrivity, (Class<?>) TopperListActivity.class).putExtra("top_ten", resultActrivity.resultTestSeries2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ResultActrivity resultActrivity, View view) {
        LinearLayout linearLayout = resultActrivity.getBinding().resultUserLinear;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setBackgroundResource(R.drawable.round_corner_border_login_signup);
        resultActrivity.getBinding().simpleProgressBar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#372870")));
        ProgressBar progressBar = resultActrivity.getBinding().simpleProgressBar;
        if (progressBar != null) {
            ResultTestSeries_Report resultTestSeries_Report = resultActrivity.resultTestSeries2;
            Intrinsics.checkNotNull(resultTestSeries_Report);
            String percentage = resultTestSeries_Report.getData().getPercentage();
            Intrinsics.checkNotNullExpressionValue(percentage, "getPercentage(...)");
            progressBar.setProgress(MathKt.roundToInt(Float.parseFloat(percentage)));
        }
        TextView textView = resultActrivity.getBinding().startPercentage;
        if (textView != null) {
            ResultTestSeries_Report resultTestSeries_Report2 = resultActrivity.resultTestSeries2;
            Intrinsics.checkNotNull(resultTestSeries_Report2);
            String percentage2 = resultTestSeries_Report2.getData().getPercentage();
            Intrinsics.checkNotNullExpressionValue(percentage2, "getPercentage(...)");
            textView.setText(MathKt.roundToInt(Float.parseFloat(percentage2)) + "%");
        }
        LinearLayout linearLayout2 = resultActrivity.getBinding().resultTopperLinear;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setBackgroundResource(R.color.white);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ResultActrivity resultActrivity, View view) {
        LinearLayout linearLayout = resultActrivity.getBinding().resultTopperLinear;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setBackgroundResource(R.drawable.round_corner_border_login_signup);
        resultActrivity.getBinding().simpleProgressBar.setProgressTintList(ColorStateList.valueOf(Color.parseColor("#FF7F50")));
        ProgressBar progressBar = resultActrivity.getBinding().simpleProgressBar;
        if (progressBar != null) {
            ResultTestSeries_Report resultTestSeries_Report = resultActrivity.resultTestSeries2;
            Intrinsics.checkNotNull(resultTestSeries_Report);
            String result = resultTestSeries_Report.getData().getTop_ten_list().get(0).getResult();
            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
            progressBar.setProgress(MathKt.roundToInt(Float.parseFloat(result)));
        }
        TextView textView = resultActrivity.getBinding().startPercentage;
        if (textView != null) {
            ResultTestSeries_Report resultTestSeries_Report2 = resultActrivity.resultTestSeries2;
            Intrinsics.checkNotNull(resultTestSeries_Report2);
            String result2 = resultTestSeries_Report2.getData().getTop_ten_list().get(0).getResult();
            Intrinsics.checkNotNullExpressionValue(result2, "getResult(...)");
            textView.setText(MathKt.roundToInt(Float.parseFloat(result2)) + "%");
        }
        LinearLayout linearLayout2 = resultActrivity.getBinding().resultUserLinear;
        Intrinsics.checkNotNull(linearLayout2);
        linearLayout2.setBackgroundResource(R.color.white);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3(ResultActrivity resultActrivity) {
        resultActrivity.finish();
        return Unit.INSTANCE;
    }

    public final void setGraphData(int size, float correct, float incorrect, float unattempted) {
        TextView textView = (TextView) findViewById(R.id.tvXMax);
        this.tvX = textView;
        BarChart barChart = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvX");
            textView = null;
        }
        textView.setTextSize(10.0f);
        this.tvY = (TextView) findViewById(R.id.tvYMax);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar1);
        this.seekBarX = seekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarX");
            seekBar = null;
        }
        seekBar.setMax(50);
        SeekBar seekBar2 = this.seekBarX;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarX");
            seekBar2 = null;
        }
        ResultActrivity resultActrivity = this;
        seekBar2.setOnSeekBarChangeListener(resultActrivity);
        SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar2);
        this.seekBarY = seekBar3;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarY");
            seekBar3 = null;
        }
        seekBar3.setOnSeekBarChangeListener(resultActrivity);
        BarChart barChart2 = (BarChart) findViewById(R.id.resultRank);
        this.chart = barChart2;
        if (barChart2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart2 = null;
        }
        barChart2.setOnChartValueSelectedListener(this);
        BarChart barChart3 = this.chart;
        if (barChart3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart3 = null;
        }
        barChart3.getDescription().setEnabled(false);
        BarChart barChart4 = this.chart;
        if (barChart4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart4 = null;
        }
        barChart4.setTouchEnabled(false);
        BarChart barChart5 = this.chart;
        if (barChart5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart5 = null;
        }
        barChart5.setPinchZoom(false);
        BarChart barChart6 = this.chart;
        if (barChart6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart6 = null;
        }
        barChart6.setDrawBarShadow(false);
        BarChart barChart7 = this.chart;
        if (barChart7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart7 = null;
        }
        barChart7.setDrawGridBackground(false);
        SeekBar seekBar4 = this.seekBarX;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarX");
            seekBar4 = null;
        }
        seekBar4.setProgress(size);
        SeekBar seekBar5 = this.seekBarY;
        if (seekBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seekBarY");
            seekBar5 = null;
        }
        seekBar5.setProgress(100);
        BarChart barChart8 = this.chart;
        if (barChart8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart8 = null;
        }
        Legend legend = barChart8.getLegend();
        Intrinsics.checkNotNullExpressionValue(legend, "getLegend(...)");
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setDrawInside(true);
        legend.setTypeface(getTfLight());
        legend.setYOffset(0.0f);
        legend.setXOffset(10.0f);
        legend.setYEntrySpace(0.0f);
        legend.setTextSize(8.0f);
        BarChart barChart9 = this.chart;
        if (barChart9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart9 = null;
        }
        XAxis xAxis = barChart9.getXAxis();
        Intrinsics.checkNotNullExpressionValue(xAxis, "getXAxis(...)");
        xAxis.setTypeface(getTfLight());
        xAxis.setGranularity(1.0f);
        xAxis.setCenterAxisLabels(false);
        BarChart barChart10 = this.chart;
        if (barChart10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart10 = null;
        }
        YAxis axisLeft = barChart10.getAxisLeft();
        Intrinsics.checkNotNullExpressionValue(axisLeft, "getAxisLeft(...)");
        axisLeft.setTypeface(getTfLight());
        axisLeft.setValueFormatter(new LargeValueFormatter());
        axisLeft.setDrawGridLines(false);
        axisLeft.setSpaceTop(35.0f);
        axisLeft.setAxisMinimum(0.0f);
        BarChart barChart11 = this.chart;
        if (barChart11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
        } else {
            barChart = barChart11;
        }
        barChart.getAxisRight().setEnabled(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01cb  */
    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onProgressChanged(android.widget.SeekBar r12, int r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.NewResult.Activity.ResultActrivity.onProgressChanged(android.widget.SeekBar, int, boolean):void");
    }

    @Override // com.appnew.android.NewResult.Fragment.DemoBase
    protected void saveToGallery() {
        BarChart barChart = this.chart;
        if (barChart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chart");
            barChart = null;
        }
        saveToGallery(barChart, "BarChartActivityMultiDataset");
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public Call<String> getAPIB(String apitype, String typeApi, APIInterface service) {
        Intrinsics.checkNotNullParameter(service, "service");
        if (Intrinsics.areEqual(apitype, API.API_TEST_RESULT)) {
            EncryptionData encryptionData = new EncryptionData();
            encryptionData.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
            encryptionData.setTest_id(this.status);
            encryptionData.setCourse_id(SharedPreference.getInstance().getString("id"));
            encryptionData.setFirst_attempt(this.first_attempt);
            return service.getTestResult(AES.encrypt(new Gson().toJson(encryptionData)));
        }
        if (!Intrinsics.areEqual(apitype, API.API_TEST_REPORT)) {
            return null;
        }
        EncryptionData encryptionData2 = new EncryptionData();
        encryptionData2.setUser_id(SharedPreference.getInstance().getLoggedInUser().getId());
        encryptionData2.setTest_series_id(this.status);
        return service.getTestResult(AES.encrypt(new Gson().toJson(encryptionData2)));
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void SuccessCallBack(JSONObject jsonResponse, String apitype, String typeApi, boolean showprogress) {
        Intrinsics.checkNotNullParameter(jsonResponse, "jsonResponse");
        if (Intrinsics.areEqual(apitype, API.API_TEST_RESULT)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonResponse.getString("status").equals("true")) {
                    ResultTestSeries_Report resultTestSeries_Report = (ResultTestSeries_Report) new Gson().fromJson(jsonResponse.toString(), ResultTestSeries_Report.class);
                    this.resultTestSeries2 = resultTestSeries_Report;
                    Intrinsics.checkNotNull(resultTestSeries_Report);
                    int size = resultTestSeries_Report.getData().getTest_sections().size();
                    ResultTestSeries_Report resultTestSeries_Report2 = this.resultTestSeries2;
                    Intrinsics.checkNotNull(resultTestSeries_Report2);
                    String correct_count = resultTestSeries_Report2.getData().getCorrect_count();
                    Intrinsics.checkNotNullExpressionValue(correct_count, "getCorrect_count(...)");
                    float f2 = Float.parseFloat(correct_count);
                    ResultTestSeries_Report resultTestSeries_Report3 = this.resultTestSeries2;
                    Intrinsics.checkNotNull(resultTestSeries_Report3);
                    String incorrect_count = resultTestSeries_Report3.getData().getIncorrect_count();
                    Intrinsics.checkNotNullExpressionValue(incorrect_count, "getIncorrect_count(...)");
                    float f3 = Float.parseFloat(incorrect_count);
                    ResultTestSeries_Report resultTestSeries_Report4 = this.resultTestSeries2;
                    Intrinsics.checkNotNull(resultTestSeries_Report4);
                    String non_attempt = resultTestSeries_Report4.getData().getNon_attempt();
                    Intrinsics.checkNotNullExpressionValue(non_attempt, "getNon_attempt(...)");
                    setGraphData(size, f2, f3, Float.parseFloat(non_attempt));
                    setData();
                    return;
                }
                String string = jsonResponse.getString("message");
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (Intrinsics.areEqual(apitype, API.API_TEST_REPORT)) {
            try {
                Helper.dismissProgressDialog();
                if (jsonResponse.getString("status").equals("true")) {
                    return;
                }
                String string2 = jsonResponse.getString("message");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                XtensionFunctionKt.showSmallLengthToast(this, string2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // com.appnew.android.Utils.Network.NetworkCall.MyNetworkCallBack
    public void ErrorCallBack(String jsonstring, String apitype, String typeApi) {
        if (!Intrinsics.areEqual(apitype, API.API_TEST_RESULT) || AllDoubtsFragmentKt.getPaginationLoader() == null) {
            return;
        }
        ProgressBar paginationLoader = AllDoubtsFragmentKt.getPaginationLoader();
        Intrinsics.checkNotNull(paginationLoader);
        if (paginationLoader.isShown()) {
            ProgressBar paginationLoader2 = AllDoubtsFragmentKt.getPaginationLoader();
            Intrinsics.checkNotNull(paginationLoader2);
            paginationLoader2.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x027c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setData() {
        /*
            Method dump skipped, instruction units count: 1304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.NewResult.Activity.ResultActrivity.setData():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$4(ResultActrivity resultActrivity, View view) {
        ResultTestSeries_Report resultTestSeries_Report = resultActrivity.resultTestSeries2;
        if (resultTestSeries_Report != null) {
            Intrinsics.checkNotNull(resultTestSeries_Report);
            if (resultTestSeries_Report.getData() != null) {
                ResultTestSeries_Report resultTestSeries_Report2 = resultActrivity.resultTestSeries2;
                Intrinsics.checkNotNull(resultTestSeries_Report2);
                if (resultTestSeries_Report2.getData().getQuestion_dump() != null) {
                    ResultTestSeries_Report resultTestSeries_Report3 = resultActrivity.resultTestSeries2;
                    Intrinsics.checkNotNull(resultTestSeries_Report3);
                    if (resultTestSeries_Report3.getData().getQuestion_dump().size() > 0) {
                        SharedPreference.getInstance().putString("testresult", new Gson().toJson(resultActrivity.resultTestSeries2));
                        Intent intent = new Intent(resultActrivity, (Class<?>) ViewSolutionActivity.class);
                        intent.putExtra(Const.TESTSEGMENT_ID, resultActrivity.status);
                        intent.putExtra("name", resultActrivity.testSeriesName);
                        ResultTestSeries_Report resultTestSeries_Report4 = resultActrivity.resultTestSeries2;
                        Intrinsics.checkNotNull(resultTestSeries_Report4);
                        String lang_id = resultTestSeries_Report4.getData().getLang_id();
                        Intrinsics.checkNotNullExpressionValue(lang_id, "getLang_id(...)");
                        if (Intrinsics.areEqual(((String[]) StringsKt.split$default((CharSequence) lang_id, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null).toArray(new String[0]))[0], "1")) {
                            ResultTestSeries_Report resultTestSeries_Report5 = resultActrivity.resultTestSeries2;
                            Intrinsics.checkNotNull(resultTestSeries_Report5);
                            String lang_id2 = resultTestSeries_Report5.getData().getLang_id();
                            Intrinsics.checkNotNullExpressionValue(lang_id2, "getLang_id(...)");
                            resultActrivity.lang = Integer.parseInt(((String[]) StringsKt.split$default((CharSequence) lang_id2, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null).toArray(new String[0]))[0]);
                        } else {
                            ResultTestSeries_Report resultTestSeries_Report6 = resultActrivity.resultTestSeries2;
                            Intrinsics.checkNotNull(resultTestSeries_Report6);
                            String lang_id3 = resultTestSeries_Report6.getData().getLang_id();
                            Intrinsics.checkNotNullExpressionValue(lang_id3, "getLang_id(...)");
                            if (Intrinsics.areEqual(((String[]) StringsKt.split$default((CharSequence) lang_id3, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null).toArray(new String[0]))[0], "2")) {
                                ResultTestSeries_Report resultTestSeries_Report7 = resultActrivity.resultTestSeries2;
                                Intrinsics.checkNotNull(resultTestSeries_Report7);
                                String lang_id4 = resultTestSeries_Report7.getData().getLang_id();
                                Intrinsics.checkNotNullExpressionValue(lang_id4, "getLang_id(...)");
                                resultActrivity.lang = Integer.parseInt(((String[]) StringsKt.split$default((CharSequence) lang_id4, new String[]{Constants.SEPARATOR_COMMA}, false, 0, 6, (Object) null).toArray(new String[0]))[0]);
                            }
                        }
                        intent.putExtra(Const.LANG, resultActrivity.lang);
                        Helper.gotoActivity(intent, resultActrivity);
                        return;
                    }
                }
            }
        }
        Toast.makeText(resultActrivity, resultActrivity.getResources().getString(R.string.no_view_solution_found_please_try_again), 0).show();
    }
}
