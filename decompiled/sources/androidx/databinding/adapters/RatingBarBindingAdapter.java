package androidx.databinding.adapters;

import android.widget.RatingBar;
import androidx.databinding.InverseBindingListener;

/* JADX INFO: loaded from: classes3.dex */
public class RatingBarBindingAdapter {
    public static void setRating(RatingBar ratingBar, float f2) {
        if (ratingBar.getRating() != f2) {
            ratingBar.setRating(f2);
        }
    }

    public static void setListeners(RatingBar ratingBar, final RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
        } else {
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: androidx.databinding.adapters.RatingBarBindingAdapter.1
                @Override // android.widget.RatingBar.OnRatingBarChangeListener
                public void onRatingChanged(RatingBar ratingBar2, float f2, boolean z) {
                    RatingBar.OnRatingBarChangeListener onRatingBarChangeListener2 = onRatingBarChangeListener;
                    if (onRatingBarChangeListener2 != null) {
                        onRatingBarChangeListener2.onRatingChanged(ratingBar2, f2, z);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
