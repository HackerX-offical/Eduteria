package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentLeaderBoardBinding implements ViewBinding {
    public final TextView errorTV;
    public final RecyclerView leaderListRV;
    public final LinearLayout rankLL;
    public final TextView rankValueTV;
    private final RelativeLayout rootView;
    public final TextView userValueTV;

    private FragmentLeaderBoardBinding(RelativeLayout rootView, TextView errorTV, RecyclerView leaderListRV, LinearLayout rankLL, TextView rankValueTV, TextView userValueTV) {
        this.rootView = rootView;
        this.errorTV = errorTV;
        this.leaderListRV = leaderListRV;
        this.rankLL = rankLL;
        this.rankValueTV = rankValueTV;
        this.userValueTV = userValueTV;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLeaderBoardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentLeaderBoardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_leader_board, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLeaderBoardBinding bind(View rootView) {
        int i = R.id.errorTV;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, R.id.errorTV);
        if (textView != null) {
            i = R.id.leaderListRV;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, R.id.leaderListRV);
            if (recyclerView != null) {
                i = R.id.rankLL;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, R.id.rankLL);
                if (linearLayout != null) {
                    i = R.id.rankValueTV;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, R.id.rankValueTV);
                    if (textView2 != null) {
                        i = R.id.userValueTV;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, R.id.userValueTV);
                        if (textView3 != null) {
                            return new FragmentLeaderBoardBinding((RelativeLayout) rootView, textView, recyclerView, linearLayout, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
