package custom_animations;

import android.util.Property;

/* JADX INFO: loaded from: classes9.dex */
public abstract class FloatProperty<T> extends Property<T, Float> {
    public abstract void setValue(T t, float f2);

    public FloatProperty(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    public final void set(T t, Float f2) {
        setValue(t, f2.floatValue());
    }
}
