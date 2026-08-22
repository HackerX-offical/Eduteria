package com.appnew.android.loginRevamp.Fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.appnew.android.Utils.Const;
import com.eduteria.app.app.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommonWebViewFragmentNew.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/appnew/android/loginRevamp/Fragment/CommonWebViewFragmentNew;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "strUrl", "", "showToolbar", "", "webview", "Landroid/webkit/WebView;", "cancelBox", "Landroid/widget/ImageView;", "progressBar", "Landroid/widget/ProgressBar;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonWebViewFragmentNew extends BottomSheetDialogFragment {
    private ImageView cancelBox;
    private ProgressBar progressBar;
    private boolean showToolbar;
    private String strUrl = "";
    private WebView webview;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final CommonWebViewFragmentNew newInstance(String str, boolean z) {
        return INSTANCE.newInstance(str, z);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.BottomSheetDialogStyle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(Const.PRIVACYURL);
            if (string == null) {
                string = "";
            }
            this.strUrl = string;
            this.showToolbar = arguments.getBoolean("show_toolbar");
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        dialogOnCreateDialog.setCanceledOnTouchOutside(false);
        dialogOnCreateDialog.setCancelable(false);
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_common_web_view_new, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        WebSettings settings;
        WebSettings settings2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        try {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.appnew.android.loginRevamp.Fragment.CommonWebViewFragmentNew$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        CommonWebViewFragmentNew.onViewCreated$lambda$3(view, dialogInterface);
                    }
                });
            }
            this.cancelBox = (ImageView) view.findViewById(R.id.cancelBox);
            this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            WebView webView = (WebView) view.findViewById(R.id.web_view);
            this.webview = webView;
            if (webView != null && (settings2 = webView.getSettings()) != null) {
                settings2.setJavaScriptEnabled(true);
            }
            WebView webView2 = this.webview;
            if (webView2 != null && (settings = webView2.getSettings()) != null) {
                settings.setLoadsImagesAutomatically(true);
            }
            WebView webView3 = this.webview;
            if (webView3 != null) {
                webView3.setHorizontalScrollBarEnabled(true);
            }
            WebView webView4 = this.webview;
            if (webView4 != null) {
                webView4.setVerticalScrollBarEnabled(true);
            }
            WebView webView5 = this.webview;
            if (webView5 != null) {
                webView5.setScrollBarStyle(0);
            }
            WebView webView6 = this.webview;
            if (webView6 != null) {
                webView6.setWebChromeClient(new WebChromeClient());
            }
            WebView webView7 = this.webview;
            if (webView7 != null) {
                webView7.setWebViewClient(new WebViewClient() { // from class: com.appnew.android.loginRevamp.Fragment.CommonWebViewFragmentNew.onViewCreated.2
                    @Override // android.webkit.WebViewClient
                    public void onPageStarted(WebView view2, String url, Bitmap favicon) {
                        super.onPageStarted(view2, url, favicon);
                        WebView webView8 = CommonWebViewFragmentNew.this.webview;
                        if (webView8 != null) {
                            webView8.setVisibility(8);
                        }
                        ProgressBar progressBar = CommonWebViewFragmentNew.this.progressBar;
                        if (progressBar != null) {
                            progressBar.setVisibility(0);
                        }
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView view2, String url) {
                        super.onPageFinished(view2, url);
                        Handler handler = new Handler(Looper.getMainLooper());
                        final CommonWebViewFragmentNew commonWebViewFragmentNew = CommonWebViewFragmentNew.this;
                        handler.postDelayed(new Runnable() { // from class: com.appnew.android.loginRevamp.Fragment.CommonWebViewFragmentNew$onViewCreated$2$onPageFinished$1
                            @Override // java.lang.Runnable
                            public void run() {
                                WebView webView8 = commonWebViewFragmentNew.webview;
                                if (webView8 != null) {
                                    webView8.setVisibility(0);
                                }
                                ProgressBar progressBar = commonWebViewFragmentNew.progressBar;
                                if (progressBar != null) {
                                    progressBar.setVisibility(8);
                                }
                            }
                        }, 500L);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onReceivedError(WebView view2, int errorCode, String description, String failingUrl) {
                        super.onReceivedError(view2, errorCode, description, failingUrl);
                        WebView webView8 = CommonWebViewFragmentNew.this.webview;
                        if (webView8 != null) {
                            webView8.setVisibility(0);
                        }
                        ProgressBar progressBar = CommonWebViewFragmentNew.this.progressBar;
                        if (progressBar != null) {
                            progressBar.setVisibility(8);
                        }
                    }
                });
            }
            WebView webView8 = this.webview;
            if (webView8 != null) {
                webView8.loadUrl(this.strUrl);
            }
            ImageView imageView = this.cancelBox;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.loginRevamp.Fragment.CommonWebViewFragmentNew$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CommonWebViewFragmentNew.onViewCreated$lambda$5(this.f$0, view2);
                    }
                });
            }
        } catch (Exception e2) {
            Log.d("TAG", "onCreate: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(View view, DialogInterface dialogInterface) {
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        if (((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet) != null) {
            Object parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) parent);
            Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(...)");
            bottomSheetBehaviorFrom.setPeekHeight(view.getHeight());
            bottomSheetBehaviorFrom.setState(3);
            bottomSheetBehaviorFrom.setDraggable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(CommonWebViewFragmentNew commonWebViewFragmentNew, View view) {
        ProgressBar progressBar = commonWebViewFragmentNew.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        commonWebViewFragmentNew.dismiss();
    }

    /* JADX INFO: compiled from: CommonWebViewFragmentNew.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/appnew/android/loginRevamp/Fragment/CommonWebViewFragmentNew$Companion;", "", "<init>", "()V", "newInstance", "Lcom/appnew/android/loginRevamp/Fragment/CommonWebViewFragmentNew;", "url", "", "showToolbar", "", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommonWebViewFragmentNew newInstance(String url, boolean showToolbar) {
            Intrinsics.checkNotNullParameter(url, "url");
            CommonWebViewFragmentNew commonWebViewFragmentNew = new CommonWebViewFragmentNew();
            Bundle bundle = new Bundle();
            bundle.putString(Const.PRIVACYURL, url);
            bundle.putBoolean("show_toolbar", showToolbar);
            commonWebViewFragmentNew.setArguments(bundle);
            return commonWebViewFragmentNew;
        }
    }
}
