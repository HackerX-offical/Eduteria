package com.clevertap.android.sdk.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jsoup.nodes.DocumentType;

/* JADX INFO: compiled from: Clock.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/utils/Clock;", "", "currentTimeMillis", "", "currentTimeSeconds", "currentTimeSecondsInt", "", "newDate", "Ljava/util/Date;", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Clock {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final Clock SYSTEM = new Clock() { // from class: com.clevertap.android.sdk.utils.Clock$Companion$SYSTEM$1
        @Override // com.clevertap.android.sdk.utils.Clock
        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }

        @Override // com.clevertap.android.sdk.utils.Clock
        public Date newDate() {
            return new Date();
        }

        @Override // com.clevertap.android.sdk.utils.Clock
        public long currentTimeSeconds() {
            return TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis());
        }

        @Override // com.clevertap.android.sdk.utils.Clock
        public int currentTimeSecondsInt() {
            return (int) (currentTimeMillis() / ((long) 1000));
        }
    };

    long currentTimeMillis();

    long currentTimeSeconds();

    int currentTimeSecondsInt();

    Date newDate();

    /* JADX INFO: compiled from: Clock.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static long currentTimeSeconds(Clock clock) {
            return TimeUnit.MILLISECONDS.toSeconds(clock.currentTimeMillis());
        }

        public static int currentTimeSecondsInt(Clock clock) {
            return (int) (clock.currentTimeMillis() / ((long) 1000));
        }
    }

    /* JADX INFO: compiled from: Clock.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lcom/clevertap/android/sdk/utils/Clock$Companion;", "", "<init>", "()V", DocumentType.SYSTEM_KEY, "Lcom/clevertap/android/sdk/utils/Clock;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
