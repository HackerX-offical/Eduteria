package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes7.dex */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() { // from class: com.github.mikephil.charting.data.Entry.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Entry[] newArray(int i) {
            return new Entry[i];
        }
    };
    private float x;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Entry() {
        this.x = 0.0f;
    }

    public Entry(float f2, float f3) {
        super(f3);
        this.x = f2;
    }

    public Entry(float f2, float f3, Object obj) {
        super(f3, obj);
        this.x = f2;
    }

    public Entry(float f2, float f3, Drawable drawable) {
        super(f3, drawable);
        this.x = f2;
    }

    public Entry(float f2, float f3, Drawable drawable, Object obj) {
        super(f3, drawable, obj);
        this.x = f2;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float f2) {
        this.x = f2;
    }

    public Entry copy() {
        return new Entry(this.x, getY(), getData());
    }

    public boolean equalTo(Entry entry) {
        return entry != null && entry.getData() == getData() && Math.abs(entry.x - this.x) <= Utils.FLOAT_EPSILON && Math.abs(entry.getY() - getY()) <= Utils.FLOAT_EPSILON;
    }

    public String toString() {
        return "Entry, x: " + this.x + " y: " + getY();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.x);
        parcel.writeFloat(getY());
        if (getData() != null) {
            if (getData() instanceof Parcelable) {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) getData(), i);
                return;
            }
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
        parcel.writeInt(0);
    }

    protected Entry(Parcel parcel) {
        this.x = 0.0f;
        this.x = parcel.readFloat();
        setY(parcel.readFloat());
        if (parcel.readInt() == 1) {
            setData(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
