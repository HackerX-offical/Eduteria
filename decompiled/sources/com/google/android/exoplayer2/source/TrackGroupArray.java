package com.google.android.exoplayer2.source;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;

/* JADX INFO: loaded from: classes7.dex */
public final class TrackGroupArray implements Bundleable {
    private static final int FIELD_TRACK_GROUPS = 0;
    private static final String TAG = "TrackGroupArray";
    private int hashCode;
    public final int length;
    private final ImmutableList<TrackGroup> trackGroups;
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
    public static final Bundleable.Creator<TrackGroupArray> CREATOR = new Bundleable.Creator() { // from class: com.google.android.exoplayer2.source.TrackGroupArray$$ExternalSyntheticLambda0
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return TrackGroupArray.lambda$static$0(bundle);
        }
    };

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.trackGroups = ImmutableList.copyOf(trackGroupArr);
        this.length = trackGroupArr.length;
        verifyCorrectness();
    }

    public TrackGroup get(int i) {
        return this.trackGroups.get(i);
    }

    public int indexOf(TrackGroup trackGroup) {
        int iIndexOf = this.trackGroups.indexOf(trackGroup);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.trackGroups.hashCode();
        }
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
            if (this.length == trackGroupArray.length && this.trackGroups.equals(trackGroupArray.trackGroups)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(keyForField(0), BundleableUtil.toBundleArrayList(this.trackGroups));
        return bundle;
    }

    static /* synthetic */ TrackGroupArray lambda$static$0(Bundle bundle) {
        return new TrackGroupArray((TrackGroup[]) BundleableUtil.fromBundleNullableList(TrackGroup.CREATOR, bundle.getParcelableArrayList(keyForField(0)), ImmutableList.of()).toArray(new TrackGroup[0]));
    }

    private void verifyCorrectness() {
        int i = 0;
        while (i < this.trackGroups.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.trackGroups.size(); i3++) {
                if (this.trackGroups.get(i).equals(this.trackGroups.get(i3))) {
                    Log.e(TAG, "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
