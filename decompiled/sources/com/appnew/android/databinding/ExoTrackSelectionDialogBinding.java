package com.appnew.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.appnew.android.customview.TrackSelectionView;
import com.eduteria.app.app.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ExoTrackSelectionDialogBinding implements ViewBinding {
    public final TrackSelectionView exoTrackSelectionView;
    private final ScrollView rootView;

    private ExoTrackSelectionDialogBinding(ScrollView rootView, TrackSelectionView exoTrackSelectionView) {
        this.rootView = rootView;
        this.exoTrackSelectionView = exoTrackSelectionView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static ExoTrackSelectionDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ExoTrackSelectionDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.exo_track_selection_dialog, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExoTrackSelectionDialogBinding bind(View rootView) {
        TrackSelectionView trackSelectionView = (TrackSelectionView) ViewBindings.findChildViewById(rootView, R.id.exo_track_selection_view);
        if (trackSelectionView != null) {
            return new ExoTrackSelectionDialogBinding((ScrollView) rootView, trackSelectionView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.exo_track_selection_view)));
    }
}
