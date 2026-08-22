package com.anychart;

/* JADX INFO: loaded from: classes4.dex */
public class APIlib {
    private static volatile APIlib instance;
    private AnyChartView anyChartView;

    public static APIlib getInstance() {
        APIlib aPIlib;
        APIlib aPIlib2 = instance;
        if (aPIlib2 != null) {
            return aPIlib2;
        }
        synchronized (APIlib.class) {
            aPIlib = instance;
            if (aPIlib == null) {
                aPIlib = new APIlib();
                instance = aPIlib;
            }
        }
        return aPIlib;
    }

    public void setActiveAnyChartView(AnyChartView anyChartView) {
        this.anyChartView = anyChartView;
    }

    public void addJSLine(String str) {
        this.anyChartView.getJsListener().onJsLineAdd(str);
    }
}
