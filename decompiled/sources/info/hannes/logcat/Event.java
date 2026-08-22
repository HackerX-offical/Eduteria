package info.hannes.logcat;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: Event.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u000e\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Linfo/hannes/logcat/Event;", ExifInterface.GPS_DIRECTION_TRUE, "", "content", "<init>", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "value", "", "hasBeenHandled", "getHasBeenHandled$annotations", "()V", "getHasBeenHandled", "()Z", "getContentIfNotHandled", "()Ljava/lang/Object;", "peekContent", "LogcatCore_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Event<T> {
    private final T content;
    private boolean hasBeenHandled;

    public static /* synthetic */ void getHasBeenHandled$annotations() {
    }

    public Event(T t) {
        this.content = t;
    }

    public final boolean getHasBeenHandled() {
        return this.hasBeenHandled;
    }

    public final T getContentIfNotHandled() {
        if (this.hasBeenHandled) {
            return null;
        }
        this.hasBeenHandled = true;
        return this.content;
    }

    public final T peekContent() {
        return this.content;
    }
}
