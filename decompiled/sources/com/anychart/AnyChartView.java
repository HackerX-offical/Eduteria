package com.anychart;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.amazonaws.services.s3.util.Mimetypes;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.core.Chart;

/* JADX INFO: loaded from: classes4.dex */
public final class AnyChartView extends FrameLayout {
    private String backgroundColor;
    private Chart chart;
    private StringBuilder fonts;
    private boolean isDebug;
    private boolean isRendered;
    private boolean isRestored;
    protected StringBuilder js;
    private JsListener jsListener;
    private String licenceKey;
    private OnRenderedListener onRenderedListener;
    private View progressBar;
    private StringBuilder scripts;
    private WebView webView;

    public interface JsListener {
        void onJsLineAdd(String str);
    }

    public interface OnRenderedListener {
        void onRendered();
    }

    public AnyChartView(Context context) {
        super(context);
        this.scripts = new StringBuilder();
        this.fonts = new StringBuilder();
        this.js = new StringBuilder();
        this.licenceKey = "";
        init();
    }

    public AnyChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scripts = new StringBuilder();
        this.fonts = new StringBuilder();
        this.js = new StringBuilder();
        this.licenceKey = "";
        init();
    }

    public AnyChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scripts = new StringBuilder();
        this.fonts = new StringBuilder();
        this.js = new StringBuilder();
        this.licenceKey = "";
        init();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putString("js", this.js.toString());
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.js.append(bundle.getString("js"));
            parcelable = bundle.getParcelable("superState");
        }
        this.isRestored = true;
        super.onRestoreInstanceState(parcelable);
    }

    private void init() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.view_anychart, (ViewGroup) this, true);
        APIlib.getInstance().setActiveAnyChartView(this);
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(0);
        }
        WebView webView = (WebView) viewInflate.findViewById(R.id.web_view);
        this.webView = webView;
        WebSettings settings = webView.getSettings();
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        this.webView.setLongClickable(true);
        this.webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.anychart.AnyChartView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return true;
            }
        });
        this.webView.setWebChromeClient(new WebChromeClient() { // from class: com.anychart.AnyChartView.2
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (AnyChartView.this.isDebug) {
                    Log.e("AnyChart", consoleMessage.message());
                }
                AnyChartView.this.webView.setEnabled(false);
                return true;
            }
        });
        this.isRendered = false;
        JsObject.variableIndex = 0;
        setJsListener(new JsListener() { // from class: com.anychart.AnyChartView.3
            @Override // com.anychart.AnyChartView.JsListener
            public void onJsLineAdd(final String str) {
                AnyChartView.this.webView.post(new Runnable() { // from class: com.anychart.AnyChartView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AnyChartView.this.isRestored) {
                            return;
                        }
                        if (AnyChartView.this.isRendered) {
                            AnyChartView.this.webView.evaluateJavascript(str, null);
                        } else {
                            AnyChartView.this.js.append(str);
                        }
                    }
                });
            }
        });
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.anychart.AnyChartView.4
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                String string;
                if (AnyChartView.this.isRestored) {
                    string = AnyChartView.this.js.toString();
                } else {
                    string = AnyChartView.this.js.append(AnyChartView.this.chart.getJsBase()).append(".container(\"container\");").append(AnyChartView.this.chart.getJsBase()).append(".draw();").toString();
                }
                AnyChartView.this.webView.evaluateJavascript("anychart.licenseKey(\"" + AnyChartView.this.licenceKey + "\");anychart.onDocumentReady(function () {\n" + string + "});", new ValueCallback<String>() { // from class: com.anychart.AnyChartView.4.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(String str2) {
                        if (AnyChartView.this.onRenderedListener != null) {
                            AnyChartView.this.onRenderedListener.onRendered();
                        }
                        if (AnyChartView.this.progressBar != null) {
                            AnyChartView.this.progressBar.setVisibility(8);
                        }
                    }
                });
                AnyChartView.this.isRestored = false;
                AnyChartView.this.isRendered = true;
            }
        });
        this.webView.addJavascriptInterface(ListenersInterface.getInstance(), "android");
    }

    private void loadHtml() {
        this.webView.loadDataWithBaseURL("", "<html>\n<head>\n    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">\n    <style type=\"text/css\">\n        html, body, #container {\n            width: 100%;\n            height: 100%;\n            margin: 0;\n            padding: 0;\n" + (this.backgroundColor != null ? "background-color: " + this.backgroundColor + ";" : "") + "        }\n" + this.fonts.toString() + "    </style>\n</head>\n<body>\n<script src=\"file:///android_asset/anychart-bundle.min.js\"></script>" + this.scripts.toString() + "<link rel=\"stylesheet\" href=\"file:///android_asset/anychart-ui.min.css\"/>\n<div id=\"container\"></div>\n</body>\n</html>", Mimetypes.MIMETYPE_HTML, "UTF-8", null);
    }

    public void addScript(String str) {
        this.scripts.append("<script src=\"").append(str).append("\"></script>\n");
    }

    public void addCss(String str) {
        this.scripts.append("<link rel=\"stylesheet\" href=\"").append(str).append("\"/>\n");
    }

    public void addFont(String str, String str2) {
        this.fonts.append("@font-face {\n").append("font-family: ").append(str).append(";\n").append("src: url(").append(str2).append(");\n").append("}\n");
    }

    public void setLicenceKey(String str) {
        this.licenceKey = str;
    }

    public void setZoomEnabled(Boolean bool) {
        this.webView.getSettings().setBuiltInZoomControls(bool.booleanValue());
        this.webView.getSettings().setDisplayZoomControls(!bool.booleanValue());
    }

    public void clear() {
        this.webView.loadUrl("about:blank");
        this.isRendered = false;
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void setChart(Chart chart) {
        this.isRestored = false;
        this.chart = chart;
        loadHtml();
    }

    public void setProgressBar(View view) {
        this.progressBar = view;
        view.setVisibility(0);
    }

    public void setBackgroundColor(String str) {
        this.backgroundColor = str;
        this.webView.setBackgroundColor(Color.parseColor(str));
    }

    public void setJsListener(JsListener jsListener) {
        this.jsListener = jsListener;
    }

    public JsListener getJsListener() {
        return this.jsListener;
    }

    public OnRenderedListener getOnRenderedListener() {
        return this.onRenderedListener;
    }

    public void setOnRenderedListener(OnRenderedListener onRenderedListener) {
        this.onRenderedListener = onRenderedListener;
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
    }
}
