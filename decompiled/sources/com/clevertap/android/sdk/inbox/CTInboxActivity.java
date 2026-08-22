package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.DidClickForHardPermissionListener;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.PushPermissionHandler;
import com.clevertap.android.sdk.R;
import com.clevertap.android.sdk.inbox.CTInboxListViewFragment;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class CTInboxActivity extends FragmentActivity implements CTInboxListViewFragment.InboxListener, DidClickForHardPermissionListener {
    public static int orientation;
    private CleverTapAPI cleverTapAPI;
    private CleverTapInstanceConfig config;
    private CTInboxListener inboxContentUpdatedListener = null;
    CTInboxTabAdapter inboxTabAdapter;
    private WeakReference<InboxActivityListener> listenerWeakReference;
    private PushPermissionHandler pushPermissionHandler;
    CTInboxStyleConfig styleConfig;
    TabLayout tabLayout;
    ViewPager viewPager;

    public interface InboxActivityListener {
        void messageDidClick(CTInboxActivity cTInboxActivity, int i, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> map, int i2);

        void messageDidShow(CTInboxActivity cTInboxActivity, CTInboxMessage cTInboxMessage, Bundle bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                throw new IllegalArgumentException();
            }
            this.styleConfig = (CTInboxStyleConfig) extras.getParcelable("styleConfig");
            Bundle bundle2 = extras.getBundle("configBundle");
            if (bundle2 != null) {
                this.config = (CleverTapInstanceConfig) bundle2.getParcelable("config");
            }
            CleverTapAPI cleverTapAPIInstanceWithConfig = CleverTapAPI.instanceWithConfig(getApplicationContext(), this.config);
            this.cleverTapAPI = cleverTapAPIInstanceWithConfig;
            if (cleverTapAPIInstanceWithConfig != null) {
                setListener(cleverTapAPIInstanceWithConfig);
                this.pushPermissionHandler = new PushPermissionHandler(this.config, this.cleverTapAPI.getCoreState().getCallbackManager().getPushPermissionResponseListenerList());
            }
            orientation = getResources().getConfiguration().orientation;
            setContentView(R.layout.inbox_activity);
            this.cleverTapAPI.getCoreState().getCoreMetaData().setAppInboxActivity(this);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle(this.styleConfig.getNavBarTitle());
            toolbar.setTitleTextColor(Color.parseColor(this.styleConfig.getNavBarTitleColor()));
            toolbar.setBackgroundColor(Color.parseColor(this.styleConfig.getNavBarColor()));
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ct_ic_arrow_back_white_24dp, null);
            if (drawable != null) {
                drawable.setColorFilter(Color.parseColor(this.styleConfig.getBackButtonColor()), PorterDuff.Mode.SRC_IN);
            }
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(getString(R.string.ct_inbox_back_button_content_description));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.clevertap.android.sdk.inbox.CTInboxActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CTInboxActivity.this.finish();
                }
            });
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.inbox_linear_layout);
            linearLayout.setBackgroundColor(Color.parseColor(this.styleConfig.getInboxBackgroundColor()));
            this.tabLayout = (TabLayout) linearLayout.findViewById(R.id.tab_layout);
            this.viewPager = (ViewPager) linearLayout.findViewById(R.id.view_pager);
            TextView textView = (TextView) findViewById(R.id.no_message_view);
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable("config", this.config);
            bundle3.putParcelable("styleConfig", this.styleConfig);
            int i = 0;
            if (!this.styleConfig.isUsingTabs()) {
                this.viewPager.setVisibility(8);
                this.tabLayout.setVisibility(8);
                CleverTapAPI cleverTapAPI = this.cleverTapAPI;
                if (cleverTapAPI != null && cleverTapAPI.getInboxMessageCount() == 0) {
                    textView.setBackgroundColor(Color.parseColor(this.styleConfig.getInboxBackgroundColor()));
                    textView.setVisibility(0);
                    textView.setText(this.styleConfig.getNoMessageViewText());
                    textView.setTextColor(Color.parseColor(this.styleConfig.getNoMessageViewTextColor()));
                    return;
                }
                ((FrameLayout) findViewById(R.id.list_view_fragment)).setVisibility(0);
                textView.setVisibility(8);
                for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                    if (fragment.getTag() != null && !fragment.getTag().equalsIgnoreCase(getFragmentTag())) {
                        i = 1;
                    }
                }
                if (i == 0) {
                    Fragment cTInboxListViewFragment = new CTInboxListViewFragment();
                    cTInboxListViewFragment.setArguments(bundle3);
                    getSupportFragmentManager().beginTransaction().add(R.id.list_view_fragment, cTInboxListViewFragment, getFragmentTag()).commit();
                    return;
                }
                return;
            }
            this.viewPager.setVisibility(0);
            ArrayList<String> tabs = this.styleConfig.getTabs();
            this.inboxTabAdapter = new CTInboxTabAdapter(getSupportFragmentManager(), tabs.size() + 1);
            this.tabLayout.setVisibility(0);
            this.tabLayout.setTabGravity(0);
            this.tabLayout.setTabMode(1);
            this.tabLayout.setSelectedTabIndicatorColor(Color.parseColor(this.styleConfig.getSelectedTabIndicatorColor()));
            this.tabLayout.setTabTextColors(Color.parseColor(this.styleConfig.getUnselectedTabColor()), Color.parseColor(this.styleConfig.getSelectedTabColor()));
            this.tabLayout.setBackgroundColor(Color.parseColor(this.styleConfig.getTabBackgroundColor()));
            Bundle bundle4 = (Bundle) bundle3.clone();
            bundle4.putInt(Const.POSITION, 0);
            CTInboxListViewFragment cTInboxListViewFragment2 = new CTInboxListViewFragment();
            cTInboxListViewFragment2.setArguments(bundle4);
            this.inboxTabAdapter.addFragment(cTInboxListViewFragment2, this.styleConfig.getFirstTabTitle(), 0);
            while (i < tabs.size()) {
                String str = tabs.get(i);
                i++;
                Bundle bundle5 = (Bundle) bundle3.clone();
                bundle5.putInt(Const.POSITION, i);
                bundle5.putString("filter", str);
                CTInboxListViewFragment cTInboxListViewFragment3 = new CTInboxListViewFragment();
                cTInboxListViewFragment3.setArguments(bundle5);
                this.inboxTabAdapter.addFragment(cTInboxListViewFragment3, str, i);
                this.viewPager.setOffscreenPageLimit(i);
            }
            this.viewPager.setAdapter(this.inboxTabAdapter);
            this.inboxTabAdapter.notifyDataSetChanged();
            this.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.tabLayout));
            this.tabLayout.setupWithViewPager(this.viewPager);
        } catch (Throwable th) {
            Logger.v("Cannot find a valid notification inbox bundle to show!", th);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PushPermissionHandler pushPermissionHandler = this.pushPermissionHandler;
        if (pushPermissionHandler != null) {
            pushPermissionHandler.onActivityResume(this);
        }
    }

    @Override // com.clevertap.android.sdk.DidClickForHardPermissionListener
    public void didClickForHardPermissionWithFallbackSettings(boolean z) {
        PushPermissionHandler pushPermissionHandler = this.pushPermissionHandler;
        if (pushPermissionHandler != null) {
            pushPermissionHandler.requestPermission(this, z);
        }
    }

    @Override // com.clevertap.android.sdk.DidClickForHardPermissionListener
    public void didCancelPermissionRequest() {
        PushPermissionHandler pushPermissionHandler = this.pushPermissionHandler;
        if (pushPermissionHandler != null) {
            pushPermissionHandler.notifyPushPermissionExternalListeners(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        PushPermissionHandler pushPermissionHandler = this.pushPermissionHandler;
        if (pushPermissionHandler != null) {
            pushPermissionHandler.onRequestPermissionsResult(this, i, iArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.cleverTapAPI.getCoreState().getCoreMetaData().setAppInboxActivity(null);
        if (this.styleConfig.isUsingTabs()) {
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment instanceof CTInboxListViewFragment) {
                    Logger.v("Removing fragment - " + fragment.toString());
                    getSupportFragmentManager().getFragments().remove(fragment);
                }
            }
        }
        super.onDestroy();
    }

    @Override // com.clevertap.android.sdk.inbox.CTInboxListViewFragment.InboxListener
    public void messageDidClick(Context context, int i, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> map, int i2) {
        didClick(bundle, i, cTInboxMessage, map, i2);
    }

    @Override // com.clevertap.android.sdk.inbox.CTInboxListViewFragment.InboxListener
    public void messageDidShow(Context context, CTInboxMessage cTInboxMessage, Bundle bundle) {
        Logger.v("CTInboxActivity:messageDidShow() called with: data = [" + bundle + "], inboxMessage = [" + cTInboxMessage.getMessageId() + Constants.AES_SUFFIX);
        didShow(bundle, cTInboxMessage);
    }

    void didClick(Bundle bundle, int i, CTInboxMessage cTInboxMessage, HashMap<String, String> map, int i2) {
        InboxActivityListener listener = getListener();
        if (listener != null) {
            listener.messageDidClick(this, i, cTInboxMessage, bundle, map, i2);
        }
    }

    void didShow(Bundle bundle, CTInboxMessage cTInboxMessage) {
        Logger.v("CTInboxActivity:didShow() called with: data = [" + bundle + "], inboxMessage = [" + cTInboxMessage.getMessageId() + Constants.AES_SUFFIX);
        InboxActivityListener listener = getListener();
        if (listener != null) {
            listener.messageDidShow(this, cTInboxMessage, bundle);
        }
    }

    InboxActivityListener getListener() {
        InboxActivityListener inboxActivityListener;
        try {
            inboxActivityListener = this.listenerWeakReference.get();
        } catch (Throwable unused) {
            inboxActivityListener = null;
        }
        if (inboxActivityListener == null) {
            this.config.getLogger().verbose(this.config.getAccountId(), "InboxActivityListener is null for notification inbox ");
        }
        return inboxActivityListener;
    }

    void setListener(InboxActivityListener inboxActivityListener) {
        this.listenerWeakReference = new WeakReference<>(inboxActivityListener);
    }

    private String getFragmentTag() {
        return this.config.getAccountId() + ":CT_INBOX_LIST_VIEW_FRAGMENT";
    }
}
