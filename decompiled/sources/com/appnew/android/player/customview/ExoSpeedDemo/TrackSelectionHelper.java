package com.appnew.android.player.customview.ExoSpeedDemo;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class TrackSelectionHelper implements View.OnClickListener, DialogInterface.OnClickListener {
    private CheckedTextView defaultView;
    private CheckedTextView enableRandomAdaptationView;
    private boolean isDisabled;
    private DefaultTrackSelector.SelectionOverride override;
    private int rendererIndex;
    private TrackGroupArray trackGroups;
    private boolean[] trackGroupsAdaptive;
    private MappingTrackSelector.MappedTrackInfo trackInfo;
    private CheckedTextView[][] trackViews;

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private static int[] getTracksAdding(DefaultTrackSelector.SelectionOverride override, int addedTrack) {
        int[] iArr = override.tracks;
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArrCopyOf.length - 1] = addedTrack;
        return iArrCopyOf;
    }

    private static int[] getTracksRemoving(DefaultTrackSelector.SelectionOverride override, int removedTrack) {
        int i = override.length;
        int[] iArr = new int[i - 1];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = override.tracks[i3];
            if (i4 != removedTrack) {
                iArr[i2] = i4;
                i2++;
            }
        }
        return iArr;
    }
}
