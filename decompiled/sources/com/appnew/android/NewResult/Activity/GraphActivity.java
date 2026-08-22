package com.appnew.android.NewResult.Activity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import com.appnew.android.NewResult.Fragment.DemoBase;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.Utils.Helper;
import com.appnew.android.databinding.ActivityGraphBinding;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.eduteria.app.app.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GraphActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0015J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\"\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010!\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0011H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/appnew/android/NewResult/Activity/GraphActivity;", "Lcom/appnew/android/NewResult/Fragment/DemoBase;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "<init>", "()V", "_binding", "Lcom/appnew/android/databinding/ActivityGraphBinding;", "get_binding", "()Lcom/appnew/android/databinding/ActivityGraphBinding;", "set_binding", "(Lcom/appnew/android/databinding/ActivityGraphBinding;)V", "binding", "getBinding", "resultTestSeries2", "Lcom/appnew/android/testmodule/model/ResultTestSeries_Report;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveToGallery", "onProgressChanged", "p0", "Landroid/widget/SeekBar;", "p1", "", "p2", "", "setData", "count", "range", "", "onStartTrackingTouch", "onStopTrackingTouch", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "onNothingSelected", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphActivity extends DemoBase implements SeekBar.OnSeekBarChangeListener, OnChartValueSelectedListener {
    public static final int $stable = 8;
    public ActivityGraphBinding _binding;
    private ResultTestSeries_Report resultTestSeries2;

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onNothingSelected() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar p0) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar p0) {
    }

    public final ActivityGraphBinding get_binding() {
        ActivityGraphBinding activityGraphBinding = this._binding;
        if (activityGraphBinding != null) {
            return activityGraphBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_binding");
        return null;
    }

    public final void set_binding(ActivityGraphBinding activityGraphBinding) {
        Intrinsics.checkNotNullParameter(activityGraphBinding, "<set-?>");
        this._binding = activityGraphBinding;
    }

    public final ActivityGraphBinding getBinding() {
        ActivityGraphBinding activityGraphBinding = get_binding();
        Intrinsics.checkNotNull(activityGraphBinding);
        return activityGraphBinding;
    }

    @Override // com.appnew.android.NewResult.Fragment.DemoBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        set_binding(ActivityGraphBinding.inflate(getLayoutInflater()));
        ActivityGraphBinding activityGraphBinding = get_binding();
        Intrinsics.checkNotNull(activityGraphBinding);
        setContentView(activityGraphBinding.getRoot());
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            this.resultTestSeries2 = (ResultTestSeries_Report) extras.getSerializable("top_ten");
            TextView textView = getBinding().topperCount;
            if (textView != null) {
                String string = getResources().getString(R.string.top);
                ResultTestSeries_Report resultTestSeries_Report = this.resultTestSeries2;
                Intrinsics.checkNotNull(resultTestSeries_Report);
                textView.setText(string + resultTestSeries_Report.getData().getTop_ten_list().size());
            }
        } else {
            finish();
        }
        getBinding().graphImageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.NewResult.Activity.GraphActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GraphActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        GraphActivity graphActivity = this;
        getBinding().seekBar1.setOnSeekBarChangeListener(graphActivity);
        getBinding().seekBar2.setOnSeekBarChangeListener(graphActivity);
        getBinding().chart1.setOnChartValueSelectedListener(this);
        HorizontalBarChart chart1 = getBinding().chart1;
        Intrinsics.checkNotNullExpressionValue(chart1, "chart1");
        chart1.setDrawBarShadow(false);
        chart1.setDrawValueAboveBar(true);
        chart1.getDescription().setEnabled(false);
        chart1.setMaxVisibleValueCount(60);
        chart1.setTouchEnabled(false);
        chart1.setPinchZoom(false);
        chart1.setDrawGridBackground(false);
        XAxis xAxis = chart1.getXAxis();
        Intrinsics.checkNotNullExpressionValue(xAxis, "getXAxis(...)");
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTypeface(getTfLight());
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        YAxis axisLeft = chart1.getAxisLeft();
        Intrinsics.checkNotNullExpressionValue(axisLeft, "getAxisLeft(...)");
        axisLeft.setTypeface(getTfLight());
        axisLeft.setDrawAxisLine(true);
        axisLeft.setDrawGridLines(true);
        axisLeft.setAxisMinimum(0.0f);
        YAxis axisRight = chart1.getAxisRight();
        Intrinsics.checkNotNullExpressionValue(axisRight, "getAxisRight(...)");
        axisRight.setTypeface(getTfLight());
        axisRight.setDrawAxisLine(true);
        axisRight.setDrawGridLines(false);
        axisRight.setAxisMinimum(0.0f);
        chart1.setFitBars(true);
        chart1.animateY(2500);
        getBinding().seekBar1.setProgress(50);
        getBinding().seekBar2.setProgress(12);
        Legend legend = chart1.getLegend();
        Intrinsics.checkNotNullExpressionValue(legend, "getLegend(...)");
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setFormSize(8.0f);
        legend.setXEntrySpace(4.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(GraphActivity graphActivity) {
        graphActivity.finish();
        return Unit.INSTANCE;
    }

    @Override // com.appnew.android.NewResult.Fragment.DemoBase
    protected void saveToGallery() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar p0, int p1, boolean p2) {
        ResultTestSeries_Report resultTestSeries_Report = this.resultTestSeries2;
        Intrinsics.checkNotNull(resultTestSeries_Report);
        setData(resultTestSeries_Report.getData().getTop_ten_list().size(), getBinding().seekBar2.getProgress());
        getBinding().chart1.setFitBars(true);
        getBinding().chart1.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setData(int count, float range) {
        HorizontalBarChart chart1 = getBinding().chart1;
        Intrinsics.checkNotNullExpressionValue(chart1, "chart1");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            ResultTestSeries_Report resultTestSeries_Report = this.resultTestSeries2;
            Intrinsics.checkNotNull(resultTestSeries_Report);
            String result = resultTestSeries_Report.getData().getTop_ten_list().get(i).getResult();
            Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
            arrayList.add(new BarEntry(i * 100.0f, Float.parseFloat(result), getResources().getDrawable(R.drawable.arrow_down)));
        }
        if (chart1.getData() != null && ((BarData) chart1.getData()).getDataSetCount() > 0) {
            T dataSetByIndex = ((BarData) chart1.getData()).getDataSetByIndex(0);
            Intrinsics.checkNotNull(dataSetByIndex, "null cannot be cast to non-null type com.github.mikephil.charting.data.BarDataSet");
            ((BarDataSet) dataSetByIndex).setValues(arrayList);
            ((BarData) chart1.getData()).notifyDataChanged();
            chart1.notifyDataSetChanged();
            return;
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, "Topper List");
        barDataSet.setDrawIcons(false);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(barDataSet);
        BarData barData = new BarData(arrayList2);
        barData.setValueTextSize(10.0f);
        barData.setValueTypeface(getTfLight());
        barData.setBarWidth(90.0f);
        chart1.setData(barData);
    }

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onValueSelected(Entry e2, Highlight h2) {
        Helper.showToast(this, String.valueOf(e2 != null ? e2.getData() : null), 0);
    }
}
