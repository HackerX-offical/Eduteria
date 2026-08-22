package com.github.kotvertolet.youtubejextractor.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.kotvertolet.youtubejextractor.models.newModels.AdaptiveFormatsItem;

/* JADX INFO: loaded from: classes7.dex */
public class AdaptiveAudioStream extends StreamItem {
    public static final Parcelable.Creator<AdaptiveAudioStream> CREATOR = new Parcelable.Creator<AdaptiveAudioStream>() { // from class: com.github.kotvertolet.youtubejextractor.models.AdaptiveAudioStream.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdaptiveAudioStream createFromParcel(Parcel parcel) {
            return new AdaptiveAudioStream(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AdaptiveAudioStream[] newArray(int i) {
            return new AdaptiveAudioStream[i];
        }
    };
    private int audioChannels;
    private int audioSampleRate;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AdaptiveAudioStream(String str, String str2, int i, int i2, String str3, int i3, int i4, int i5, int i6) {
        super(str, str2, i, i2, str3, i5, i6);
        this.audioChannels = i3;
        this.audioSampleRate = i4;
    }

    public AdaptiveAudioStream(AdaptiveFormatsItem adaptiveFormatsItem) {
        super(adaptiveFormatsItem);
        this.audioChannels = adaptiveFormatsItem.getAudioChannels();
        this.audioSampleRate = Integer.valueOf(adaptiveFormatsItem.getAudioSampleRate()).intValue();
    }

    public int getAudioChannels() {
        return this.audioChannels;
    }

    public void setAudioChannels(int i) {
        this.audioChannels = i;
    }

    public int getAudioSampleRate() {
        return this.audioSampleRate;
    }

    public void setAudioSampleRate(int i) {
        this.audioSampleRate = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.extension);
        parcel.writeString(this.codec);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.iTag);
        parcel.writeString(this.url);
        parcel.writeInt(this.audioChannels);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeInt(this.averageBitrate);
        parcel.writeInt(this.approxDurationMs.intValue());
    }

    @Override // com.github.kotvertolet.youtubejextractor.models.StreamItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        AdaptiveAudioStream adaptiveAudioStream = (AdaptiveAudioStream) obj;
        return this.audioChannels == adaptiveAudioStream.audioChannels && this.audioSampleRate == adaptiveAudioStream.audioSampleRate;
    }

    @Override // com.github.kotvertolet.youtubejextractor.models.StreamItem
    public int hashCode() {
        return (((super.hashCode() * 31) + this.audioChannels) * 31) + this.audioSampleRate;
    }
}
