package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.appnew.android.feeds.dataclass.comment.Data;
import com.eduteria.app.app.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CommentAdapterBinding extends ViewDataBinding {
    public final TextView approval;
    public final RelativeLayout cvrRight;

    @Bindable
    protected Data mCommentdata;
    public final CircleImageView profileImage2;
    public final TextView rightmessage;
    public final TextView righttexttime;
    public final TextView userNameright;

    public abstract void setCommentdata(Data commentdata);

    protected CommentAdapterBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView approval, RelativeLayout cvrRight, CircleImageView profileImage2, TextView rightmessage, TextView righttexttime, TextView userNameright) {
        super(_bindingComponent, _root, _localFieldCount);
        this.approval = approval;
        this.cvrRight = cvrRight;
        this.profileImage2 = profileImage2;
        this.rightmessage = rightmessage;
        this.righttexttime = righttexttime;
        this.userNameright = userNameright;
    }

    public Data getCommentdata() {
        return this.mCommentdata;
    }

    public static CommentAdapterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentAdapterBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CommentAdapterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.comment_adapter, root, attachToRoot, component);
    }

    public static CommentAdapterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentAdapterBinding inflate(LayoutInflater inflater, Object component) {
        return (CommentAdapterBinding) ViewDataBinding.inflateInternal(inflater, R.layout.comment_adapter, null, false, component);
    }

    public static CommentAdapterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CommentAdapterBinding bind(View view, Object component) {
        return (CommentAdapterBinding) bind(component, view, R.layout.comment_adapter);
    }
}
