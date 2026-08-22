package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemWebviewBinding implements ViewBinding {
    public final CardView parentCard;
    private final RelativeLayout rootView;
    public final ImageButton shareImage;
    public final WebView webView;

    private ItemWebviewBinding(RelativeLayout rootView, CardView parentCard, ImageButton shareImage, WebView webView) {
        this.rootView = rootView;
        this.parentCard = parentCard;
        this.shareImage = shareImage;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemWebviewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemWebviewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.item_webview, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemWebviewBinding bind(View rootView) {
        int i = R.id.parentCard;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, R.id.parentCard);
        if (cardView != null) {
            i = R.id.share_image;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.share_image);
            if (imageButton != null) {
                i = R.id.webView;
                WebView webView = (WebView) ViewBindings.findChildViewById(rootView, R.id.webView);
                if (webView != null) {
                    return new ItemWebviewBinding((RelativeLayout) rootView, cardView, imageButton, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
