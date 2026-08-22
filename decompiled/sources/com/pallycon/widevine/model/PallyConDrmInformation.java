package com.pallycon.widevine.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/pallycon/widevine/model/PallyConDrmInformation;", "Landroid/os/Parcelable;", "licenseDuration", "", "playbackDuration", "(JJ)V", "getLicenseDuration", "()J", "getPlaybackDuration", "component1", "component2", Constants.COPY_TYPE, "describeContents", "", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "widevine_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class PallyConDrmInformation implements Parcelable {
    public static final Parcelable.Creator<PallyConDrmInformation> CREATOR = new Creator();
    private final long licenseDuration;
    private final long playbackDuration;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PallyConDrmInformation> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PallyConDrmInformation createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PallyConDrmInformation(parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PallyConDrmInformation[] newArray(int i) {
            return new PallyConDrmInformation[i];
        }
    }

    public PallyConDrmInformation(long j, long j2) {
        this.licenseDuration = j;
        this.playbackDuration = j2;
    }

    public static /* synthetic */ PallyConDrmInformation copy$default(PallyConDrmInformation pallyConDrmInformation, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pallyConDrmInformation.licenseDuration;
        }
        if ((i & 2) != 0) {
            j2 = pallyConDrmInformation.playbackDuration;
        }
        return pallyConDrmInformation.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getLicenseDuration() {
        return this.licenseDuration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getPlaybackDuration() {
        return this.playbackDuration;
    }

    public final PallyConDrmInformation copy(long licenseDuration, long playbackDuration) {
        return new PallyConDrmInformation(licenseDuration, playbackDuration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PallyConDrmInformation)) {
            return false;
        }
        PallyConDrmInformation pallyConDrmInformation = (PallyConDrmInformation) other;
        return this.licenseDuration == pallyConDrmInformation.licenseDuration && this.playbackDuration == pallyConDrmInformation.playbackDuration;
    }

    public final long getLicenseDuration() {
        return this.licenseDuration;
    }

    public final long getPlaybackDuration() {
        return this.playbackDuration;
    }

    public int hashCode() {
        return (Long.hashCode(this.licenseDuration) * 31) + Long.hashCode(this.playbackDuration);
    }

    public String toString() {
        return "PallyConDrmInformation(licenseDuration=" + this.licenseDuration + ", playbackDuration=" + this.playbackDuration + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.licenseDuration);
        parcel.writeLong(this.playbackDuration);
    }
}
