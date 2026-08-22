package com.appnew.android.NewResult.Activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.data.Set;
import com.anychart.enums.HoverMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.enums.TooltipPositionMode;
import com.appnew.android.OnSingleClickListener;
import com.appnew.android.databinding.ActivityToperListBinding;
import com.appnew.android.testmodule.model.ResultTestSeries_Report;
import com.eduteria.app.app.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopperListActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/appnew/android/NewResult/Activity/TopperListActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "_binding", "Lcom/appnew/android/databinding/ActivityToperListBinding;", "get_binding", "()Lcom/appnew/android/databinding/ActivityToperListBinding;", "set_binding", "(Lcom/appnew/android/databinding/ActivityToperListBinding;)V", "binding", "getBinding", "resultTestSeries2", "Lcom/appnew/android/testmodule/model/ResultTestSeries_Report;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "CustomDataEntry", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TopperListActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public ActivityToperListBinding _binding;
    private ResultTestSeries_Report resultTestSeries2;

    public final ActivityToperListBinding get_binding() {
        ActivityToperListBinding activityToperListBinding = this._binding;
        if (activityToperListBinding != null) {
            return activityToperListBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_binding");
        return null;
    }

    public final void set_binding(ActivityToperListBinding activityToperListBinding) {
        Intrinsics.checkNotNullParameter(activityToperListBinding, "<set-?>");
        this._binding = activityToperListBinding;
    }

    public final ActivityToperListBinding getBinding() {
        ActivityToperListBinding activityToperListBinding = get_binding();
        Intrinsics.checkNotNull(activityToperListBinding);
        return activityToperListBinding;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        set_binding(ActivityToperListBinding.inflate(getLayoutInflater()));
        setContentView(get_binding().getRoot());
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            this.resultTestSeries2 = (ResultTestSeries_Report) extras.getSerializable("top_ten");
        } else {
            finish();
        }
        getBinding().graphImageBack.setOnClickListener(new OnSingleClickListener(new Function0() { // from class: com.appnew.android.NewResult.Activity.TopperListActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TopperListActivity.onCreate$lambda$0(this.f$0);
            }
        }));
        AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));
        Cartesian cartesianVertical = AnyChart.vertical();
        Intrinsics.checkNotNullExpressionValue(cartesianVertical, "vertical(...)");
        cartesianVertical.animation((Boolean) true).title("Topper List");
        ArrayList arrayList = new ArrayList();
        ResultTestSeries_Report resultTestSeries_Report = this.resultTestSeries2;
        Intrinsics.checkNotNull(resultTestSeries_Report);
        int size = resultTestSeries_Report.getData().getTop_ten_list().size();
        for (int i = 0; i < size; i++) {
            ResultTestSeries_Report resultTestSeries_Report2 = this.resultTestSeries2;
            Intrinsics.checkNotNull(resultTestSeries_Report2);
            if (resultTestSeries_Report2.getData().getTop_ten_list().get(i).getName().length() >= 7) {
                ResultTestSeries_Report resultTestSeries_Report3 = this.resultTestSeries2;
                Intrinsics.checkNotNull(resultTestSeries_Report3);
                String name = resultTestSeries_Report3.getData().getTop_ten_list().get(i).getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String strSubstring = name.substring(0, 7);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                ResultTestSeries_Report resultTestSeries_Report4 = this.resultTestSeries2;
                Intrinsics.checkNotNull(resultTestSeries_Report4);
                String result = resultTestSeries_Report4.getData().getTop_ten_list().get(i).getResult();
                Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                arrayList.add(new CustomDataEntry(strSubstring, Float.valueOf(Float.parseFloat(result))));
            } else {
                ResultTestSeries_Report resultTestSeries_Report5 = this.resultTestSeries2;
                Intrinsics.checkNotNull(resultTestSeries_Report5);
                String name2 = resultTestSeries_Report5.getData().getTop_ten_list().get(i).getName();
                ResultTestSeries_Report resultTestSeries_Report6 = this.resultTestSeries2;
                Intrinsics.checkNotNull(resultTestSeries_Report6);
                String result2 = resultTestSeries_Report6.getData().getTop_ten_list().get(i).getResult();
                Intrinsics.checkNotNullExpressionValue(result2, "getResult(...)");
                arrayList.add(new CustomDataEntry(name2, Float.valueOf(Float.parseFloat(result2))));
            }
        }
        Set setInstantiate = Set.instantiate();
        setInstantiate.data(arrayList);
        Bar bar = cartesianVertical.bar(setInstantiate.mapAs("{ x: 'x', value: 'value' }"));
        Intrinsics.checkNotNullExpressionValue(bar, "bar(...)");
        bar.labels().format("{%Value} %");
        cartesianVertical.yScale().minimum((Number) Double.valueOf(0.0d));
        cartesianVertical.labels((Boolean) true);
        cartesianVertical.tooltip().displayMode(TooltipDisplayMode.UNION).positionMode(TooltipPositionMode.POINT).unionFormat("function() {\n      return 'Plain:' + this.points[1].value + ' %' +\n        '\\n' + 'Fact:' + this.points[0].value + ' %';\n    }");
        cartesianVertical.interactivity().hoverMode(HoverMode.BY_X);
        cartesianVertical.xAxis((Boolean) true);
        cartesianVertical.yAxis((Boolean) true);
        cartesianVertical.yAxis((Number) 0).labels().format("{%Value} %");
        anyChartView.setChart(cartesianVertical);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(TopperListActivity topperListActivity) {
        topperListActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: TopperListActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/appnew/android/NewResult/Activity/TopperListActivity$CustomDataEntry;", "Lcom/anychart/chart/common/dataentry/ValueDataEntry;", "x", "", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/Number;)V", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class CustomDataEntry extends ValueDataEntry {
        public CustomDataEntry(String str, Number number) {
            super(str, number);
        }
    }
}
