package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.Utils.NonScrollRecyclerView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LeaderBoardBinding implements ViewBinding {
    public final NonScrollRecyclerView leaderBoardRV;
    public final NestedScrollView mainLL;
    public final LinearLayout resultDeclaredLL;
    private final RelativeLayout rootView;

    private LeaderBoardBinding(RelativeLayout rootView, NonScrollRecyclerView leaderBoardRV, NestedScrollView mainLL, LinearLayout resultDeclaredLL) {
        this.rootView = rootView;
        this.leaderBoardRV = leaderBoardRV;
        this.mainLL = mainLL;
        this.resultDeclaredLL = resultDeclaredLL;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LeaderBoardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LeaderBoardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.leader_board, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LeaderBoardBinding bind(View rootView) {
        int i = R.id.leaderBoardRV;
        NonScrollRecyclerView nonScrollRecyclerView = (NonScrollRecyclerView) ViewBindings.findChildViewById(rootView, R.id.leaderBoardRV);
        if (nonScrollRecyclerView != null) {
            i = R.id.mainLL;
            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, R.id.mainLL);
            if (nestedScrollView != null) {
                i = R.id.resultDeclaredLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.resultDeclaredLL);
                if (linearLayout != null) {
                    return new LeaderBoardBinding((RelativeLayout) rootView, nonScrollRecyclerView, nestedScrollView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
