package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new Parcelable.Creator<IcyHeaders>() { // from class: com.google.android.exoplayer2.metadata.icy.IcyHeaders.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IcyHeaders[] newArray(int i) {
            return new IcyHeaders[i];
        }
    };
    public static final String REQUEST_HEADER_ENABLE_METADATA_NAME = "Icy-MetaData";
    public static final String REQUEST_HEADER_ENABLE_METADATA_VALUE = "1";
    private static final String RESPONSE_HEADER_BITRATE = "icy-br";
    private static final String RESPONSE_HEADER_GENRE = "icy-genre";
    private static final String RESPONSE_HEADER_METADATA_INTERVAL = "icy-metaint";
    private static final String RESPONSE_HEADER_NAME = "icy-name";
    private static final String RESPONSE_HEADER_PUB = "icy-pub";
    private static final String RESPONSE_HEADER_URL = "icy-url";
    private static final String TAG = "IcyHeaders";
    public final int bitrate;
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;
    public final String name;
    public final String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static IcyHeaders parse(Map<String, List<String>> map) {
        boolean z;
        int i;
        IcyHeaders icyHeaders;
        String str;
        String str2;
        boolean zEquals;
        int i2;
        List<String> list = map.get(RESPONSE_HEADER_BITRATE);
        boolean z2 = true;
        int i3 = -1;
        if (list != null) {
            String str3 = list.get(0);
            try {
                i2 = Integer.parseInt(str3) * 1000;
                if (i2 > 0) {
                    z = true;
                } else {
                    try {
                        String strValueOf = String.valueOf(str3);
                        Log.w(TAG, strValueOf.length() != 0 ? "Invalid bitrate: ".concat(strValueOf) : new String("Invalid bitrate: "));
                        z = false;
                        i2 = -1;
                    } catch (NumberFormatException unused) {
                        String strValueOf2 = String.valueOf(str3);
                        Log.w(TAG, strValueOf2.length() != 0 ? "Invalid bitrate header: ".concat(strValueOf2) : new String("Invalid bitrate header: "));
                        z = false;
                    }
                }
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
            i = i2;
        } else {
            z = false;
            i = -1;
        }
        List<String> list2 = map.get(RESPONSE_HEADER_GENRE);
        String str4 = null;
        if (list2 != null) {
            String str5 = list2.get(0);
            icyHeaders = null;
            str4 = str5;
            z = true;
        } else {
            icyHeaders = null;
        }
        List<String> list3 = map.get(RESPONSE_HEADER_NAME);
        if (list3 != null) {
            str = list3.get(0);
            z = true;
        } else {
            str = icyHeaders;
        }
        List<String> list4 = map.get(RESPONSE_HEADER_URL);
        if (list4 != null) {
            str2 = list4.get(0);
            z = true;
        } else {
            str2 = icyHeaders;
        }
        List<String> list5 = map.get(RESPONSE_HEADER_PUB);
        if (list5 != null) {
            zEquals = list5.get(0).equals("1");
            z = true;
        } else {
            zEquals = false;
        }
        List<String> list6 = map.get(RESPONSE_HEADER_METADATA_INTERVAL);
        if (list6 != null) {
            String str6 = list6.get(0);
            try {
                int i4 = Integer.parseInt(str6);
                if (i4 > 0) {
                    i3 = i4;
                } else {
                    try {
                        String strValueOf3 = String.valueOf(str6);
                        Log.w(TAG, strValueOf3.length() != 0 ? "Invalid metadata interval: ".concat(strValueOf3) : new String("Invalid metadata interval: "));
                        z2 = z;
                    } catch (NumberFormatException unused3) {
                        i3 = i4;
                        String strValueOf4 = String.valueOf(str6);
                        Log.w(TAG, strValueOf4.length() != 0 ? "Invalid metadata interval: ".concat(strValueOf4) : new String("Invalid metadata interval: "));
                    }
                }
                z = z2;
            } catch (NumberFormatException unused4) {
            }
        }
        int i5 = i3;
        if (z) {
            icyHeaders = new IcyHeaders(i, str4, str, str2, zEquals, i5);
        }
        return icyHeaders;
    }

    public IcyHeaders(int i, String str, String str2, String str3, boolean z, int i2) {
        Assertions.checkArgument(i2 == -1 || i2 > 0);
        this.bitrate = i;
        this.genre = str;
        this.name = str2;
        this.url = str3;
        this.isPublic = z;
        this.metadataInterval = i2;
    }

    IcyHeaders(Parcel parcel) {
        this.bitrate = parcel.readInt();
        this.genre = parcel.readString();
        this.name = parcel.readString();
        this.url = parcel.readString();
        this.isPublic = Util.readBoolean(parcel);
        this.metadataInterval = parcel.readInt();
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.name;
        if (str != null) {
            builder.setStation(str);
        }
        String str2 = this.genre;
        if (str2 != null) {
            builder.setGenre(str2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            IcyHeaders icyHeaders = (IcyHeaders) obj;
            if (this.bitrate == icyHeaders.bitrate && Util.areEqual(this.genre, icyHeaders.genre) && Util.areEqual(this.name, icyHeaders.name) && Util.areEqual(this.url, icyHeaders.url) && this.isPublic == icyHeaders.isPublic && this.metadataInterval == icyHeaders.metadataInterval) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (527 + this.bitrate) * 31;
        String str = this.genre;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        return ((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.isPublic ? 1 : 0)) * 31) + this.metadataInterval;
    }

    public String toString() {
        String str = this.name;
        String str2 = this.genre;
        int i = this.bitrate;
        return new StringBuilder(String.valueOf(str).length() + 80 + String.valueOf(str2).length()).append("IcyHeaders: name=\"").append(str).append("\", genre=\"").append(str2).append("\", bitrate=").append(i).append(", metadataInterval=").append(this.metadataInterval).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.bitrate);
        parcel.writeString(this.genre);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        Util.writeBoolean(parcel, this.isPublic);
        parcel.writeInt(this.metadataInterval);
    }
}
