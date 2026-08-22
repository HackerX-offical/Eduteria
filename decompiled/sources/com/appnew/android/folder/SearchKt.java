package com.appnew.android.folder;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Search.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¨\u0006\u0006"}, d2 = {"inputEventListener", "", "Landroid/widget/EditText;", "callBack", "Lkotlin/Function1;", "", "app_EDUTERIARelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SearchKt {
    public static final void inputEventListener(EditText editText, final Function1<? super String, Unit> callBack) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        editText.addTextChangedListener(new DebouncingTextWatcher(new Function1() { // from class: com.appnew.android.folder.SearchKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchKt.inputEventListener$lambda$0(callBack, (String) obj);
            }
        }, 0L, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit inputEventListener$lambda$0(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }
}
