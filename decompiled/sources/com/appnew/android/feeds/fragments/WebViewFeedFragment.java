package com.appnew.android.feeds.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.appnew.android.Theme.DashboardActivityTheme1;
import com.appnew.android.databinding.FragmentWebViewFeedBinding;
import com.appnew.android.feeds.ExtensionFucationKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;

/* JADX INFO: compiled from: WebViewFeedFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/appnew/android/feeds/fragments/WebViewFeedFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/appnew/android/databinding/FragmentWebViewFeedBinding;", "getBinding", "()Lcom/appnew/android/databinding/FragmentWebViewFeedBinding;", "setBinding", "(Lcom/appnew/android/databinding/FragmentWebViewFeedBinding;)V", "htmlData", "", "getHtmlData", "()Ljava/lang/String;", "setHtmlData", "(Ljava/lang/String;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "", "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebViewFeedFragment extends Fragment {
    public FragmentWebViewFeedBinding binding;
    private String htmlData = "";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initViews$lambda$3$lambda$1(View view) {
        return true;
    }

    @JvmStatic
    public static final WebViewFeedFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public final FragmentWebViewFeedBinding getBinding() {
        FragmentWebViewFeedBinding fragmentWebViewFeedBinding = this.binding;
        if (fragmentWebViewFeedBinding != null) {
            return fragmentWebViewFeedBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentWebViewFeedBinding fragmentWebViewFeedBinding) {
        Intrinsics.checkNotNullParameter(fragmentWebViewFeedBinding, "<set-?>");
        this.binding = fragmentWebViewFeedBinding;
    }

    public final String getHtmlData() {
        return this.htmlData;
    }

    public final void setHtmlData(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.htmlData = str;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setBinding(FragmentWebViewFeedBinding.inflate(getLayoutInflater(), container, false));
        if (requireArguments().containsKey("data")) {
            String string = requireArguments().getString("data");
            Intrinsics.checkNotNull(string);
            this.htmlData = string;
            initViews();
        } else {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            ExtensionFucationKt.showToast(contextRequireContext, "No Data Found");
        }
        RelativeLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initViews() {
        String str;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        getBinding().backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.feeds.fragments.WebViewFeedFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewFeedFragment.initViews$lambda$0(this.f$0, view);
            }
        });
        WebView webView = getBinding().webView;
        webView.setHapticFeedbackEnabled(false);
        webView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.appnew.android.feeds.fragments.WebViewFeedFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return WebViewFeedFragment.initViews$lambda$3$lambda$1(view);
            }
        });
        webView.setLongClickable(false);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.setClickable(true);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setDefaultFontSize(40);
        settings.setAllowFileAccess(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(true);
        WebView.setWebContentsDebuggingEnabled(false);
        if (this.htmlData.length() > 400) {
            str = "20000";
        } else {
            str = "6000";
        }
        byte[] bytes = ("<html><head>\n        <style>\n            .test_container_div {\n                position: relative;\n                width: 100%;\n                height:" + str + "px;\n                overflow: scroll;\n            }\n\n\n        </style>\n    </head><body><div class='test_container_div'>" + this.htmlData + "</div></body></html>").getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        webView.loadData(Base64.encodeToString(bytes, 0), "text/html; charset=utf-8", AbstractHttpOverXmpp.Base64.ELEMENT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(WebViewFeedFragment webViewFeedFragment, View view) {
        FragmentActivity activity = webViewFeedFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.appnew.android.Theme.DashboardActivityTheme1");
        ((DashboardActivityTheme1) activity).addFragment(new FeedsFragment());
    }

    /* JADX INFO: compiled from: WebViewFeedFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/appnew/android/feeds/fragments/WebViewFeedFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/feeds/fragments/WebViewFeedFragment;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WebViewFeedFragment newInstance() {
            return new WebViewFeedFragment();
        }
    }
}
