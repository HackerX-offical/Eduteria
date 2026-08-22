package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.Utility;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppEventDiskStore.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "kotlin.jvm.PlatformType", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "", "eventsToPersist", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppEventDiskStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    public static final AppEventDiskStore INSTANCE = new AppEventDiskStore();
    private static final String TAG = AppEventDiskStore.class.getName();

    private AppEventDiskStore() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #10 {, blocks: (B:4:0x0003, B:8:0x002f, B:9:0x0034, B:41:0x00a8, B:12:0x003f, B:21:0x005b, B:22:0x0060, B:25:0x006b, B:26:0x006f, B:28:0x0076, B:29:0x007b, B:33:0x008f, B:32:0x0086, B:35:0x0091, B:36:0x0096, B:39:0x00a1), top: B:59:0x0003, inners: #0, #4, #6, #8 }] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventDiskStore> r0 = com.facebook.appevents.AppEventDiskStore.class
            monitor-enter(r0)
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch: java.lang.Throwable -> Laf
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> Laf
            r2 = 0
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50 java.io.FileNotFoundException -> L90
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50 java.io.FileNotFoundException -> L90
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50 java.io.FileNotFoundException -> L90
            com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventDiskStore$MovedClassObjectInputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50 java.io.FileNotFoundException -> L90
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50 java.io.FileNotFoundException -> L90
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50 java.io.FileNotFoundException -> L90
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50 java.io.FileNotFoundException -> L90
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50 java.io.FileNotFoundException -> L90
            java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L75 java.io.FileNotFoundException -> L91
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L75 java.io.FileNotFoundException -> L91
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L75 java.io.FileNotFoundException -> L91
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch: java.lang.Throwable -> Laf
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r2 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r2)     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> Laf
            r1.delete()     // Catch: java.lang.Exception -> L3e java.lang.Throwable -> Laf
            goto L48
        L3e:
            r1 = move-exception
            java.lang.String r2 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch: java.lang.Throwable -> Laf
            android.util.Log.w(r2, r4, r1)     // Catch: java.lang.Throwable -> Laf
        L48:
            r2 = r3
            goto La6
        L4a:
            r3 = move-exception
            goto L52
        L4c:
            r3 = move-exception
            r4 = r2
            r2 = r3
            goto L76
        L50:
            r3 = move-exception
            r4 = r2
        L52:
            java.lang.String r5 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> L75
            java.lang.String r6 = "Got unexpected exception while reading events: "
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch: java.lang.Throwable -> L75
            android.util.Log.w(r5, r6, r3)     // Catch: java.lang.Throwable -> L75
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch: java.lang.Throwable -> Laf
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> Laf
            r1.delete()     // Catch: java.lang.Exception -> L6a java.lang.Throwable -> Laf
            goto La6
        L6a:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L6f:
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch: java.lang.Throwable -> Laf
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> Laf
            goto La6
        L75:
            r2 = move-exception
        L76:
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch: java.lang.Throwable -> Laf
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Laf
            r1.delete()     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> Laf
            goto L8f
        L85:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch: java.lang.Throwable -> Laf
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> Laf
        L8f:
            throw r2     // Catch: java.lang.Throwable -> Laf
        L90:
            r4 = r2
        L91:
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch: java.lang.Throwable -> Laf
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> La0 java.lang.Throwable -> Laf
            r1.delete()     // Catch: java.lang.Exception -> La0 java.lang.Throwable -> Laf
            goto La6
        La0:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.AppEventDiskStore.TAG     // Catch: java.lang.Throwable -> Laf
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L6f
        La6:
            if (r2 != 0) goto Lad
            com.facebook.appevents.PersistedEvents r2 = new com.facebook.appevents.PersistedEvents     // Catch: java.lang.Throwable -> Laf
            r2.<init>()     // Catch: java.lang.Throwable -> Laf
        Lad:
            monitor-exit(r0)
            return r2
        Laf:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Laf
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventDiskStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    @JvmStatic
    public static final void saveEventsToDisk$facebook_core_release(PersistedEvents eventsToPersist) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
            try {
                objectOutputStream2.writeObject(eventsToPersist);
                Utility.closeQuietly(objectOutputStream2);
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.w(TAG, "Got unexpected exception while persisting events: ", th);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception unused) {
                    }
                } finally {
                    Utility.closeQuietly(objectOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: compiled from: AppEventDiskStore.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
            ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual(resultClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual(resultClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(resultClassDescriptor, "resultClassDescriptor");
            return resultClassDescriptor;
        }
    }
}
