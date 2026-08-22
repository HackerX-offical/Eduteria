package info.hannes.logcat;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Linfo/hannes/logcat/EventObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/Observer;", "Linfo/hannes/logcat/Event;", "onEventUnhandledContent", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onChanged", "event", "LogcatCore_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EventObserver<T> implements Observer<Event<? extends T>> {
    private final Function1<T, Unit> onEventUnhandledContent;

    /* JADX WARN: Multi-variable type inference failed */
    public EventObserver(Function1<? super T, Unit> onEventUnhandledContent) {
        Intrinsics.checkNotNullParameter(onEventUnhandledContent, "onEventUnhandledContent");
        this.onEventUnhandledContent = onEventUnhandledContent;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(Event<? extends T> event) {
        Intrinsics.checkNotNullParameter(event, "event");
        T contentIfNotHandled = event.getContentIfNotHandled();
        if (contentIfNotHandled != null) {
            this.onEventUnhandledContent.invoke(contentIfNotHandled);
        }
    }
}
