package com.appnew.android.customview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.viewpager.widget.ViewPager;
import com.appnew.android.customview.TrackSelectionView;
import com.eduteria.app.app.R;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TrackSelectionDialog extends DialogFragment {
    private DialogInterface.OnClickListener onClickListener;
    private DialogInterface.OnDismissListener onDismissListener;
    View rootView;
    private int titleId;
    private int defaultSelectionPosition = -1;
    private String resolution = "";
    private final SparseArray<TrackSelectionViewFragment> tabFragments = new SparseArray<>();
    private final ArrayList<Integer> tabTrackTypes = new ArrayList<>();

    private static boolean isSupportedTrackType(int trackType) {
        return trackType == 2;
    }

    public static boolean willHaveContent(DefaultTrackSelector trackSelector) {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = trackSelector.getCurrentMappedTrackInfo();
        return currentMappedTrackInfo != null && willHaveContent(currentMappedTrackInfo);
    }

    public static boolean willHaveContent(MappingTrackSelector.MappedTrackInfo mappedTrackInfo) {
        for (int i = 0; i < mappedTrackInfo.getRendererCount(); i++) {
            if (showTabForRenderer(mappedTrackInfo, i)) {
                return true;
            }
        }
        return false;
    }

    public static TrackSelectionDialog createForTrackSelector(final DefaultTrackSelector trackSelector, DialogInterface.OnDismissListener onDismissListener, int defaultSelectionPosition, String resolution) {
        final TrackSelectionDialog trackSelectionDialog = new TrackSelectionDialog();
        trackSelectionDialog.defaultSelectionPosition = defaultSelectionPosition;
        trackSelectionDialog.resolution = resolution;
        if (trackSelector.getCurrentMappedTrackInfo() != null) {
            final MappingTrackSelector.MappedTrackInfo mappedTrackInfo = (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(trackSelector.getCurrentMappedTrackInfo());
            final DefaultTrackSelector.Parameters parameters = trackSelector.getParameters();
            trackSelectionDialog.init(R.string.track_selection_title, mappedTrackInfo, parameters, false, false, new DialogInterface.OnClickListener() { // from class: com.appnew.android.customview.TrackSelectionDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TrackSelectionDialog.lambda$createForTrackSelector$0(parameters, mappedTrackInfo, trackSelectionDialog, trackSelector, dialogInterface, i);
                }
            }, onDismissListener);
        }
        return trackSelectionDialog;
    }

    static /* synthetic */ void lambda$createForTrackSelector$0(DefaultTrackSelector.Parameters parameters, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelectionDialog trackSelectionDialog, DefaultTrackSelector defaultTrackSelector, DialogInterface dialogInterface, int i) {
        DefaultTrackSelector.Parameters.Builder builderBuildUpon = parameters.buildUpon();
        for (int i2 = 0; i2 < mappedTrackInfo.getRendererCount(); i2++) {
            builderBuildUpon.clearSelectionOverrides(i2).setRendererDisabled(i2, trackSelectionDialog.getIsDisabled(i2));
            List<DefaultTrackSelector.SelectionOverride> overrides = trackSelectionDialog.getOverrides(i2);
            if (!overrides.isEmpty()) {
                builderBuildUpon.setSelectionOverride(i2, mappedTrackInfo.getTrackGroups(i2), overrides.get(0));
            }
        }
        defaultTrackSelector.setParameters(builderBuildUpon);
    }

    public static TrackSelectionDialog createForMappedTrackInfoAndParameters(int titleId, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, DefaultTrackSelector.Parameters initialParameters, boolean allowAdaptiveSelections, boolean allowMultipleOverrides, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        TrackSelectionDialog trackSelectionDialog = new TrackSelectionDialog();
        trackSelectionDialog.init(titleId, mappedTrackInfo, initialParameters, allowAdaptiveSelections, allowMultipleOverrides, onClickListener, onDismissListener);
        return trackSelectionDialog;
    }

    private void init(int titleId, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, DefaultTrackSelector.Parameters initialParameters, boolean allowAdaptiveSelections, boolean allowMultipleOverrides, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        this.titleId = titleId;
        this.onClickListener = onClickListener;
        this.onDismissListener = onDismissListener;
        for (int i = 0; i < mappedTrackInfo.getRendererCount(); i++) {
            if (showTabForRenderer(mappedTrackInfo, i)) {
                int rendererType = mappedTrackInfo.getRendererType(i);
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
                TrackSelectionViewFragment trackSelectionViewFragment = new TrackSelectionViewFragment();
                trackSelectionViewFragment.init(mappedTrackInfo, i, initialParameters.getRendererDisabled(i), initialParameters.getSelectionOverride(i, trackGroups), allowAdaptiveSelections, allowMultipleOverrides, this.defaultSelectionPosition, this.resolution);
                this.tabFragments.put(i, trackSelectionViewFragment);
                this.tabTrackTypes.add(Integer.valueOf(rendererType));
            }
        }
    }

    public boolean getIsDisabled(int rendererIndex) {
        TrackSelectionViewFragment trackSelectionViewFragment = this.tabFragments.get(rendererIndex);
        return trackSelectionViewFragment != null && trackSelectionViewFragment.isDisabled;
    }

    public List<DefaultTrackSelector.SelectionOverride> getOverrides(int rendererIndex) {
        TrackSelectionViewFragment trackSelectionViewFragment = this.tabFragments.get(rendererIndex);
        return trackSelectionViewFragment == null ? Collections.emptyList() : trackSelectionViewFragment.overrides;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (this.titleId <= 0) {
            return null;
        }
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.CustomAlertDialog);
        appCompatDialog.setTitle(this.titleId);
        return appCompatDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        this.onDismissListener.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.track_selection_dialog, container, false);
        this.rootView = viewInflate.findViewById(R.id.root_new);
        TabLayout tabLayout = (TabLayout) viewInflate.findViewById(R.id.track_selection_dialog_tab_layout);
        ViewPager viewPager = (ViewPager) viewInflate.findViewById(R.id.track_selection_dialog_view_pager);
        Button button = (Button) viewInflate.findViewById(R.id.track_selection_dialog_cancel_button);
        Button button2 = (Button) viewInflate.findViewById(R.id.track_selection_dialog_ok_button);
        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setVisibility(this.tabFragments.size() <= 1 ? 8 : 0);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.customview.TrackSelectionDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.customview.TrackSelectionDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$2(view);
            }
        });
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$1(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$2(View view) {
        this.onClickListener.onClick(getDialog(), -1);
        dismiss();
    }

    private static boolean showTabForRenderer(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int rendererIndex) {
        if (mappedTrackInfo.getTrackGroups(rendererIndex).length == 0) {
            return false;
        }
        return isSupportedTrackType(mappedTrackInfo.getRendererType(rendererIndex));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getTrackTypeString(Resources resources, int trackType) {
        if (trackType == 1) {
            return resources.getString(R.string.exo_track_selection_title_audio);
        }
        if (trackType == 2) {
            return resources.getString(R.string.exo_track_selection_title_video);
        }
        if (trackType == 3) {
            return resources.getString(R.string.exo_track_selection_title_text);
        }
        throw new IllegalArgumentException();
    }

    private final class FragmentAdapter extends FragmentPagerAdapter {
        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) TrackSelectionDialog.this.tabFragments.valueAt(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* JADX INFO: renamed from: getCount */
        public int getTotalTabs() {
            return TrackSelectionDialog.this.tabFragments.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int position) {
            return TrackSelectionDialog.getTrackTypeString(TrackSelectionDialog.this.getResources(), ((Integer) TrackSelectionDialog.this.tabTrackTypes.get(position)).intValue());
        }
    }

    public static final class TrackSelectionViewFragment extends Fragment implements TrackSelectionView.TrackSelectionListener {
        private boolean allowAdaptiveSelections;
        private boolean allowMultipleOverrides;
        private int defaultSelectionPosition;
        boolean isDisabled;
        private MappingTrackSelector.MappedTrackInfo mappedTrackInfo;
        List<DefaultTrackSelector.SelectionOverride> overrides;
        private int rendererIndex;
        private String resolution;

        public TrackSelectionViewFragment() {
            setRetainInstance(true);
        }

        public void init(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int rendererIndex, boolean initialIsDisabled, DefaultTrackSelector.SelectionOverride initialOverride, boolean allowAdaptiveSelections, boolean allowMultipleOverrides, int defaultSelectionPosition, String resolution) {
            List<DefaultTrackSelector.SelectionOverride> listSingletonList;
            this.mappedTrackInfo = mappedTrackInfo;
            this.rendererIndex = rendererIndex;
            this.isDisabled = initialIsDisabled;
            if (initialOverride == null) {
                listSingletonList = Collections.emptyList();
            } else {
                listSingletonList = Collections.singletonList(initialOverride);
            }
            this.overrides = listSingletonList;
            this.allowAdaptiveSelections = allowAdaptiveSelections;
            this.allowMultipleOverrides = allowMultipleOverrides;
            this.defaultSelectionPosition = defaultSelectionPosition;
            this.resolution = resolution;
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View viewInflate = inflater.inflate(R.layout.exo_track_selection_dialog, container, false);
            TrackSelectionView trackSelectionView = (TrackSelectionView) viewInflate.findViewById(R.id.exo_track_selection_view);
            trackSelectionView.setShowDisableOption(true);
            trackSelectionView.setAllowMultipleOverrides(this.allowMultipleOverrides);
            trackSelectionView.setAllowAdaptiveSelections(this.allowAdaptiveSelections);
            trackSelectionView.init(this.mappedTrackInfo, this.rendererIndex, this.isDisabled, this.overrides, this, this.defaultSelectionPosition, this.resolution);
            return viewInflate;
        }

        @Override // com.appnew.android.customview.TrackSelectionView.TrackSelectionListener
        public void onTrackSelectionChanged(boolean isDisabled, List<DefaultTrackSelector.SelectionOverride> overrides) {
            this.isDisabled = isDisabled;
            this.overrides = overrides;
            if (overrides.isEmpty()) {
                return;
            }
            DefaultTrackSelector.SelectionOverride selectionOverride = overrides.get(0);
            if (selectionOverride.length > 0) {
                this.defaultSelectionPosition = selectionOverride.tracks[0];
            }
        }
    }
}
