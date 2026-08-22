package com.hannesdorfmann.parcelableplease;

import android.os.Parcel;

/* JADX INFO: loaded from: classes9.dex */
public interface ParcelBagger<T> {
    T read(Parcel parcel);

    void write(T t, Parcel parcel, int i);
}
