package com.appnew.android.player.customview.ExoSpeedDemo;

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
import com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionView;
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
    private final SparseArray<TrackSelectionViewFragment> tabFragments = new SparseArray<>();
    private final ArrayList<Integer> tabTrackTypes = new ArrayList<>();
    private int titleId;

    private static boolean isSupportedTrackType(int trackType) {
        return trackType == 2;
    }

    static /* synthetic */ void lambda$createForTrackSelector$0(DialogInterface dialogInterface, int i) {
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

    public static TrackSelectionDialog createForTrackSelector(DefaultTrackSelector trackSelector, DialogInterface.OnDismissListener onDismissListener) {
        TrackSelectionDialog trackSelectionDialog = new TrackSelectionDialog();
        if (trackSelector.getCurrentMappedTrackInfo() != null) {
            trackSelectionDialog.init(R.string.track_selection_title, (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(trackSelector.getCurrentMappedTrackInfo()), trackSelector.getParameters(), false, false, new DialogInterface.OnClickListener() { // from class: com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionDialog$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TrackSelectionDialog.lambda$createForTrackSelector$0(dialogInterface, i);
                }
            }, onDismissListener);
        }
        return trackSelectionDialog;
    }

    public static TrackSelectionDialog createForMappedTrackInfoAndParameters(int titleId, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, DefaultTrackSelector.Parameters initialParameters, boolean allowAdaptiveSelections, boolean allowMultipleOverrides, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        TrackSelectionDialog trackSelectionDialog = new TrackSelectionDialog();
        trackSelectionDialog.init(titleId, mappedTrackInfo, initialParameters, allowAdaptiveSelections, allowMultipleOverrides, onClickListener, onDismissListener);
        return trackSelectionDialog;
    }

    private void init(int titleId, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, DefaultTrackSelector.Parameters initialParameters, boolean allowAdaptiveSelections, boolean allowMultipleOverrides, DialogInterface.OnClickListener onClickListener, DialogInterface.OnDismissListener onDismissListener) {
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2;
        boolean z;
        boolean z2;
        this.titleId = titleId;
        this.onClickListener = onClickListener;
        this.onDismissListener = onDismissListener;
        int i = 0;
        while (i < mappedTrackInfo.getRendererCount()) {
            if (showTabForRenderer(mappedTrackInfo, i)) {
                int rendererType = mappedTrackInfo.getRendererType(i);
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
                TrackSelectionViewFragment trackSelectionViewFragment = new TrackSelectionViewFragment();
                mappedTrackInfo2 = mappedTrackInfo;
                z = allowAdaptiveSelections;
                z2 = allowMultipleOverrides;
                trackSelectionViewFragment.init(mappedTrackInfo2, i, initialParameters.getRendererDisabled(i), initialParameters.getSelectionOverride(i, trackGroups), z, z2);
                this.tabFragments.put(i, trackSelectionViewFragment);
                this.tabTrackTypes.add(Integer.valueOf(rendererType));
            } else {
                mappedTrackInfo2 = mappedTrackInfo;
                z = allowAdaptiveSelections;
                z2 = allowMultipleOverrides;
            }
            i++;
            mappedTrackInfo = mappedTrackInfo2;
            allowAdaptiveSelections = z;
            allowMultipleOverrides = z2;
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
        button.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$1(view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionDialog$$ExternalSyntheticLambda1
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
        boolean isDisabled;
        private MappingTrackSelector.MappedTrackInfo mappedTrackInfo;
        List<DefaultTrackSelector.SelectionOverride> overrides;
        private int rendererIndex;

        public TrackSelectionViewFragment() {
            setRetainInstance(true);
        }

        public void init(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int rendererIndex, boolean initialIsDisabled, DefaultTrackSelector.SelectionOverride initialOverride, boolean allowAdaptiveSelections, boolean allowMultipleOverrides) {
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
        }

        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View viewInflate = inflater.inflate(R.layout.custom_exo_track_selection_dialog, container, false);
            TrackSelectionView trackSelectionView = (TrackSelectionView) viewInflate.findViewById(R.id.exo_track_selection_view);
            trackSelectionView.setShowDisableOption(true);
            trackSelectionView.setAllowMultipleOverrides(this.allowMultipleOverrides);
            trackSelectionView.setAllowAdaptiveSelections(this.allowAdaptiveSelections);
            trackSelectionView.init(this.mappedTrackInfo, this.rendererIndex, this.isDisabled, this.overrides, this);
            return viewInflate;
        }

        @Override // com.appnew.android.player.customview.ExoSpeedDemo.TrackSelectionView.TrackSelectionListener
        public void onTrackSelectionChanged(boolean isDisabled, List<DefaultTrackSelector.SelectionOverride> overrides) {
            this.isDisabled = isDisabled;
            this.overrides = overrides;
        }
    }
}
