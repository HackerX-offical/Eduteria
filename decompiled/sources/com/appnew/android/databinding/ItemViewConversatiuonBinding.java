package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ItemViewConversatiuonBinding extends ViewDataBinding {
    public final TextView dateLeftMessage;
    public final TextView dateRightMessage;
    public final TextView email;
    public final TextView email1;
    public final TextView issue;
    public final TextView issue1;
    public final CardView leftMessageCard;
    public final RelativeLayout leftMessageRelative;
    public final ConstraintLayout mainLLConversation;
    public final TextView message;
    public final TextView message1;
    public final TextView mobile;
    public final TextView mobile1;
    public final CardView rightMessageCard;
    public final RelativeLayout rightMessageRelative;

    protected ItemViewConversatiuonBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView dateLeftMessage, TextView dateRightMessage, TextView email, TextView email1, TextView issue, TextView issue1, CardView leftMessageCard, RelativeLayout leftMessageRelative, ConstraintLayout mainLLConversation, TextView message, TextView message1, TextView mobile, TextView mobile1, CardView rightMessageCard, RelativeLayout rightMessageRelative) {
        super(_bindingComponent, _root, _localFieldCount);
        this.dateLeftMessage = dateLeftMessage;
        this.dateRightMessage = dateRightMessage;
        this.email = email;
        this.email1 = email1;
        this.issue = issue;
        this.issue1 = issue1;
        this.leftMessageCard = leftMessageCard;
        this.leftMessageRelative = leftMessageRelative;
        this.mainLLConversation = mainLLConversation;
        this.message = message;
        this.message1 = message1;
        this.mobile = mobile;
        this.mobile1 = mobile1;
        this.rightMessageCard = rightMessageCard;
        this.rightMessageRelative = rightMessageRelative;
    }

    public static ItemViewConversatiuonBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemViewConversatiuonBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ItemViewConversatiuonBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_view_conversatiuon, root, attachToRoot, component);
    }

    public static ItemViewConversatiuonBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemViewConversatiuonBinding inflate(LayoutInflater inflater, Object component) {
        return (ItemViewConversatiuonBinding) ViewDataBinding.inflateInternal(inflater, R.layout.item_view_conversatiuon, null, false, component);
    }

    public static ItemViewConversatiuonBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemViewConversatiuonBinding bind(View view, Object component) {
        return (ItemViewConversatiuonBinding) bind(component, view, R.layout.item_view_conversatiuon);
    }
}
