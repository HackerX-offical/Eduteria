package com.appnew.android.ExtensionFunctions;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.media3.exoplayer.source.MergingMediaSource;
import com.bumptech.glide.Glide;
import com.eduteria.app.app.R;
import com.github.kotvertolet.youtubejextractor.models.youtube.playerResponse.MuxedStream;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: XtensionFunction.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0007\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r\u001a.\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u001a0\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0010j\b\u0012\u0004\u0012\u00020\u0015`\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0010j\b\u0012\u0004\u0012\u00020\u0015`\u0012H\u0007\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0017\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0007¨\u0006\u001c"}, d2 = {"textColour", "", "Landroid/widget/TextView;", "color", "", "setTheme", "visible", "Landroid/view/View;", "gone", "invisible", "showSmallLengthToast", "Landroid/content/Context;", "text", "", "showLongLengthToast", "removeDuplicates", "Ljava/util/ArrayList;", "Lcom/github/kotvertolet/youtubejextractor/models/youtube/playerResponse/MuxedStream;", "Lkotlin/collections/ArrayList;", "list", "removeDuplicatesMerged", "Landroidx/media3/exoplayer/source/MergingMediaSource;", "allowOnlyAlphaNumericCharacters", "Landroid/widget/EditText;", "Lcom/google/android/material/textfield/TextInputEditText;", "loadImage", "Landroid/widget/ImageView;", "image", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class XtensionFunctionKt {
    public static final void setTheme() {
    }

    public static final void textColour(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), i));
    }

    public static final void visible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }

    public static final void gone(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public static final void invisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(4);
    }

    public static final void showSmallLengthToast(Context context, String text) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Toast.makeText(context, text, 0).show();
    }

    public static final void showLongLengthToast(Context context, String text) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Toast.makeText(context, text, 1).show();
    }

    public static final ArrayList<MuxedStream> removeDuplicates(ArrayList<MuxedStream> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList<MuxedStream> arrayList = new ArrayList<>();
        Iterator<MuxedStream> it = list.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            MuxedStream next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            MuxedStream muxedStream = next;
            Iterator<MuxedStream> it2 = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (true) {
                if (it2.hasNext()) {
                    MuxedStream next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    if (next2.getQualityLabel().equals(muxedStream.getQualityLabel())) {
                        break;
                    }
                } else {
                    arrayList.add(muxedStream);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static final ArrayList<MergingMediaSource> removeDuplicatesMerged(ArrayList<MergingMediaSource> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new ArrayList<>();
    }

    public static final void allowOnlyAlphaNumericCharacters(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        InputFilter[] filters = editText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        editText.setFilters((InputFilter[]) ArraysKt.plus((Object[]) filters, (Collection) CollectionsKt.listOf((Object[]) new InputFilter[]{new InputFilter() { // from class: com.appnew.android.ExtensionFunctions.XtensionFunctionKt$$ExternalSyntheticLambda1
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return XtensionFunctionKt.allowOnlyAlphaNumericCharacters$lambda$0(charSequence, i, i2, spanned, i3, i4);
            }
        }, new InputFilter.AllCaps()})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence allowOnlyAlphaNumericCharacters$lambda$0(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        Intrinsics.checkNotNull(charSequence);
        return new Regex("[^A-Za-z0-9]").replace(charSequence, "");
    }

    public static final void allowOnlyAlphaNumericCharacters(TextInputEditText textInputEditText) {
        Intrinsics.checkNotNullParameter(textInputEditText, "<this>");
        InputFilter[] filters = textInputEditText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
        textInputEditText.setFilters((InputFilter[]) ArraysKt.plus((Object[]) filters, (Collection) CollectionsKt.listOf((Object[]) new InputFilter[]{new InputFilter() { // from class: com.appnew.android.ExtensionFunctions.XtensionFunctionKt$$ExternalSyntheticLambda0
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return XtensionFunctionKt.allowOnlyAlphaNumericCharacters$lambda$1(charSequence, i, i2, spanned, i3, i4);
            }
        }, new InputFilter.AllCaps()})));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence allowOnlyAlphaNumericCharacters$lambda$1(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        Intrinsics.checkNotNull(charSequence);
        return new Regex("[^A-Za-z0-9]").replace(charSequence, "");
    }

    @BindingAdapter({"app:loadImage"})
    public static final void loadImage(ImageView imageView, String image) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(image, "image");
        Glide.with(imageView).load(image).centerCrop().placeholder(R.mipmap.square_placeholder).thumbnail(0.5f).into(imageView);
    }
}
