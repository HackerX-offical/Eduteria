package com.pallycon.exoplayersample.simple;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import java.util.Arrays;

/* JADX INFO: loaded from: classes9.dex */
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

    private static int[] getTracksAdding(DefaultTrackSelector.SelectionOverride selectionOverride, int i) {
        int[] iArr = selectionOverride.tracks;
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArrCopyOf.length - 1] = i;
        return iArrCopyOf;
    }

    private static int[] getTracksRemoving(DefaultTrackSelector.SelectionOverride selectionOverride, int i) {
        int i2 = selectionOverride.length;
        int[] iArr = new int[i2 - 1];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = selectionOverride.tracks[i4];
            if (i5 != i) {
                iArr[i3] = i5;
                i3++;
            }
        }
        return iArr;
    }
}
