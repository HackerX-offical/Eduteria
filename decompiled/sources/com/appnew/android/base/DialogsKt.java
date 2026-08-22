package com.appnew.android.base;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.appnew.android.Model.subscription.SubscriptionMetaItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Dialogs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u000b\u001a6\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\n\u001a\u00020\u000b\u001a.\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¨\u0006\u000f"}, d2 = {"showSubscriptionDialogDeliveryMethod", "", "context", "Landroid/content/Context;", "title", "", "array", "Ljava/util/ArrayList;", "Lcom/appnew/android/Model/subscription/SubscriptionMetaItem;", "Lkotlin/collections/ArrayList;", "subscriptionCallback", "Lcom/appnew/android/base/SubscriptionCallback;", "showSubscriptionDialogValidity", "removeDuplicates", "list", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DialogsKt {
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object] */
    public static final void showSubscriptionDialogDeliveryMethod(Context context, String title, ArrayList<SubscriptionMetaItem> array, final SubscriptionCallback subscriptionCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(subscriptionCallback, "subscriptionCallback");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        arrayList.clear();
        if (!array.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.clear();
            int i = 0;
            for (Object obj : array) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList3.add(String.valueOf(((SubscriptionMetaItem) obj).getPlateformsName()));
                i = i2;
            }
            arrayList.addAll(CollectionsKt.distinct(arrayList3));
            arrayList2.addAll(removeDuplicates(array));
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r1 = arrayList2.get(0);
        Intrinsics.checkNotNullExpressionValue(r1, "get(...)");
        objectRef.element = r1;
        builder.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), 0, new DialogInterface.OnClickListener() { // from class: com.appnew.android.base.DialogsKt$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogsKt.showSubscriptionDialogDeliveryMethod$lambda$1(objectRef, arrayList2, dialogInterface, i3);
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.appnew.android.base.DialogsKt$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogsKt.showSubscriptionDialogDeliveryMethod$lambda$2(subscriptionCallback, objectRef, dialogInterface, i3);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.appnew.android.base.DialogsKt$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogsKt.showSubscriptionDialogDeliveryMethod$lambda$3(subscriptionCallback, objectRef, dialogInterface, i3);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public static final void showSubscriptionDialogDeliveryMethod$lambda$1(Ref.ObjectRef objectRef, ArrayList arrayList, DialogInterface dialogInterface, int i) {
        objectRef.element = arrayList.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSubscriptionDialogDeliveryMethod$lambda$2(SubscriptionCallback subscriptionCallback, Ref.ObjectRef objectRef, DialogInterface dialogInterface, int i) {
        subscriptionCallback.okClick(i, (SubscriptionMetaItem) objectRef.element);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSubscriptionDialogDeliveryMethod$lambda$3(SubscriptionCallback subscriptionCallback, Ref.ObjectRef objectRef, DialogInterface dialogInterface, int i) {
        subscriptionCallback.cancelClick(i, (SubscriptionMetaItem) objectRef.element);
        dialogInterface.dismiss();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Object] */
    public static final void showSubscriptionDialogValidity(Context context, String title, final ArrayList<SubscriptionMetaItem> array, final SubscriptionCallback subscriptionCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(subscriptionCallback, "subscriptionCallback");
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (!array.isEmpty()) {
            int i = 0;
            for (Object obj : array) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(String.valueOf(((SubscriptionMetaItem) obj).getPlanTitle()));
                i = i2;
            }
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r2 = array.get(0);
        Intrinsics.checkNotNullExpressionValue(r2, "get(...)");
        objectRef.element = r2;
        builder.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), 0, new DialogInterface.OnClickListener() { // from class: com.appnew.android.base.DialogsKt$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogsKt.showSubscriptionDialogValidity$lambda$5(objectRef, array, dialogInterface, i3);
            }
        });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.appnew.android.base.DialogsKt$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogsKt.showSubscriptionDialogValidity$lambda$6(subscriptionCallback, objectRef, dialogInterface, i3);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.appnew.android.base.DialogsKt$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogsKt.showSubscriptionDialogValidity$lambda$7(subscriptionCallback, objectRef, dialogInterface, i3);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public static final void showSubscriptionDialogValidity$lambda$5(Ref.ObjectRef objectRef, ArrayList arrayList, DialogInterface dialogInterface, int i) {
        objectRef.element = arrayList.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSubscriptionDialogValidity$lambda$6(SubscriptionCallback subscriptionCallback, Ref.ObjectRef objectRef, DialogInterface dialogInterface, int i) {
        subscriptionCallback.okClick(i, (SubscriptionMetaItem) objectRef.element);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSubscriptionDialogValidity$lambda$7(SubscriptionCallback subscriptionCallback, Ref.ObjectRef objectRef, DialogInterface dialogInterface, int i) {
        subscriptionCallback.cancelClick(i, (SubscriptionMetaItem) objectRef.element);
        dialogInterface.dismiss();
    }

    public static final ArrayList<SubscriptionMetaItem> removeDuplicates(ArrayList<SubscriptionMetaItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList<SubscriptionMetaItem> arrayList = new ArrayList<>();
        Iterator<SubscriptionMetaItem> it = list.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SubscriptionMetaItem next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            SubscriptionMetaItem subscriptionMetaItem = next;
            Iterator<SubscriptionMetaItem> it2 = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
            while (true) {
                if (it2.hasNext()) {
                    SubscriptionMetaItem next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    if (StringsKt.equals$default(next2.getPlateforms(), subscriptionMetaItem.getPlateforms(), false, 2, null)) {
                        break;
                    }
                } else {
                    arrayList.add(subscriptionMetaItem);
                    break;
                }
            }
        }
        return arrayList;
    }
}
