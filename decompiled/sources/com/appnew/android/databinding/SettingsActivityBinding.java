package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SettingsActivityBinding implements ViewBinding {
    public final LinearLayout TermsLL;
    public final RelativeLayout cachedeletelayout;
    public final LinearLayout clearCacheLL;
    public final Button clearcachebtn;
    public final TextView copyrighttext;
    public final TextView enterreviewtext;
    public final ImageView ivBack;
    public final LinearLayout leaveReviewLL;
    public final RelativeLayout logoutRL;
    public final TextView logouttext;
    public final TextView makebetter;
    public final TextView makebettertext;
    public final SwitchCompat makebettertoggle;
    public final LinearLayout openSourceLibLL;
    public final TextView opensourcelicensetext;
    public final LinearLayout privacyPolicyLL;
    public final TextView privacypolicytext;
    private final RelativeLayout rootView;
    public final ImageButton screencast;
    public final Toolbar settingsactionbar;
    public final RelativeLayout settingsdatalayout;
    public final RelativeLayout settingsdatalayout2;
    public final TextView termsofservicetext;
    public final TextView toolbartitleTV;
    public final TextView versionTV;

    private SettingsActivityBinding(RelativeLayout rootView, LinearLayout TermsLL, RelativeLayout cachedeletelayout, LinearLayout clearCacheLL, Button clearcachebtn, TextView copyrighttext, TextView enterreviewtext, ImageView ivBack, LinearLayout leaveReviewLL, RelativeLayout logoutRL, TextView logouttext, TextView makebetter, TextView makebettertext, SwitchCompat makebettertoggle, LinearLayout openSourceLibLL, TextView opensourcelicensetext, LinearLayout privacyPolicyLL, TextView privacypolicytext, ImageButton screencast, Toolbar settingsactionbar, RelativeLayout settingsdatalayout, RelativeLayout settingsdatalayout2, TextView termsofservicetext, TextView toolbartitleTV, TextView versionTV) {
        this.rootView = rootView;
        this.TermsLL = TermsLL;
        this.cachedeletelayout = cachedeletelayout;
        this.clearCacheLL = clearCacheLL;
        this.clearcachebtn = clearcachebtn;
        this.copyrighttext = copyrighttext;
        this.enterreviewtext = enterreviewtext;
        this.ivBack = ivBack;
        this.leaveReviewLL = leaveReviewLL;
        this.logoutRL = logoutRL;
        this.logouttext = logouttext;
        this.makebetter = makebetter;
        this.makebettertext = makebettertext;
        this.makebettertoggle = makebettertoggle;
        this.openSourceLibLL = openSourceLibLL;
        this.opensourcelicensetext = opensourcelicensetext;
        this.privacyPolicyLL = privacyPolicyLL;
        this.privacypolicytext = privacypolicytext;
        this.screencast = screencast;
        this.settingsactionbar = settingsactionbar;
        this.settingsdatalayout = settingsdatalayout;
        this.settingsdatalayout2 = settingsdatalayout2;
        this.termsofservicetext = termsofservicetext;
        this.toolbartitleTV = toolbartitleTV;
        this.versionTV = versionTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SettingsActivityBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SettingsActivityBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.settings_activity, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SettingsActivityBinding bind(View rootView) {
        int i = R.id.TermsLL;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.TermsLL);
        if (linearLayout != null) {
            i = R.id.cachedeletelayout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.cachedeletelayout);
            if (relativeLayout != null) {
                i = R.id.clearCacheLL;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.clearCacheLL);
                if (linearLayout2 != null) {
                    i = R.id.clearcachebtn;
                    Button button = (Button) ViewBindings.findChildViewById(rootView, R.id.clearcachebtn);
                    if (button != null) {
                        i = R.id.copyrighttext;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.copyrighttext);
                        if (textView != null) {
                            i = R.id.enterreviewtext;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.enterreviewtext);
                            if (textView2 != null) {
                                i = R.id.iv_back;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, R.id.iv_back);
                                if (imageView != null) {
                                    i = R.id.leaveReviewLL;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.leaveReviewLL);
                                    if (linearLayout3 != null) {
                                        i = R.id.logoutRL;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.logoutRL);
                                        if (relativeLayout2 != null) {
                                            i = R.id.logouttext;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.logouttext);
                                            if (textView3 != null) {
                                                i = R.id.makebetter;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, R.id.makebetter);
                                                if (textView4 != null) {
                                                    i = R.id.makebettertext;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, R.id.makebettertext);
                                                    if (textView5 != null) {
                                                        i = R.id.makebettertoggle;
                                                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(rootView, R.id.makebettertoggle);
                                                        if (switchCompat != null) {
                                                            i = R.id.openSourceLibLL;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.openSourceLibLL);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.opensourcelicensetext;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, R.id.opensourcelicensetext);
                                                                if (textView6 != null) {
                                                                    i = R.id.privacyPolicyLL;
                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.privacyPolicyLL);
                                                                    if (linearLayout5 != null) {
                                                                        i = R.id.privacypolicytext;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, R.id.privacypolicytext);
                                                                        if (textView7 != null) {
                                                                            i = R.id.screencast;
                                                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(rootView, R.id.screencast);
                                                                            if (imageButton != null) {
                                                                                i = R.id.settingsactionbar;
                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(rootView, R.id.settingsactionbar);
                                                                                if (toolbar != null) {
                                                                                    i = R.id.settingsdatalayout;
                                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.settingsdatalayout);
                                                                                    if (relativeLayout3 != null) {
                                                                                        i = R.id.settingsdatalayout2;
                                                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, R.id.settingsdatalayout2);
                                                                                        if (relativeLayout4 != null) {
                                                                                            i = R.id.termsofservicetext;
                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, R.id.termsofservicetext);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.toolbartitleTV;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, R.id.toolbartitleTV);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.versionTV;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, R.id.versionTV);
                                                                                                    if (textView10 != null) {
                                                                                                        return new SettingsActivityBinding((RelativeLayout) rootView, linearLayout, relativeLayout, linearLayout2, button, textView, textView2, imageView, linearLayout3, relativeLayout2, textView3, textView4, textView5, switchCompat, linearLayout4, textView6, linearLayout5, textView7, imageButton, toolbar, relativeLayout3, relativeLayout4, textView8, textView9, textView10);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
