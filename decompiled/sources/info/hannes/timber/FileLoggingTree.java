package info.hannes.timber;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.amazonaws.services.s3.model.InstructionFileId;
import info.hannes.logcat.Event;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: FileLoggingTree.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0017\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0015J\u0006\u0010!\u001a\u00020\u0007R\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u000f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00100\u0014X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Linfo/hannes/timber/FileLoggingTree;", "Linfo/hannes/timber/DebugFormatTree;", "externalCacheDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "filename", "", "<init>", "(Ljava/io/File;Landroid/content/Context;Ljava/lang/String;)V", "value", "file", "getFile", "()Ljava/io/File;", "lastLogEntry", "Landroidx/lifecycle/LiveData;", "Linfo/hannes/logcat/Event;", "getLastLogEntry", "()Landroidx/lifecycle/LiveData;", "_lastLogEntry", "Landroidx/lifecycle/MutableLiveData;", "get_lastLogEntry", "()Landroidx/lifecycle/MutableLiveData;", "logImpossible", "", "log", "", "priority", "", "tag", "message", "t", "", "getFileName", "Companion", "LogcatCore_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class FileLoggingTree extends DebugFormatTree {
    private static final String LOG_TAG = "FileLoggingTree";
    private final MutableLiveData<Event<String>> _lastLogEntry;
    private File file;
    private boolean logImpossible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileLoggingTree(File externalCacheDir, Context context, String filename) {
        File file;
        super(false, 1, null);
        Intrinsics.checkNotNullParameter(externalCacheDir, "externalCacheDir");
        Intrinsics.checkNotNullParameter(filename, "filename");
        this._lastLogEntry = new MutableLiveData<>();
        if (!externalCacheDir.exists() && !externalCacheDir.mkdirs()) {
            Log.e(LOG_TAG, "couldn't create " + externalCacheDir.getAbsoluteFile());
        }
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        if (context != null) {
            file = new File(externalCacheDir, context.getPackageName() + InstructionFileId.DOT + str + ".log");
        } else {
            file = new File(externalCacheDir, filename + InstructionFileId.DOT + str + ".log");
        }
        this.file = file;
    }

    public /* synthetic */ FileLoggingTree(File file, Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : context, (i & 4) != 0 ? UUID.randomUUID().toString() : str);
    }

    public final File getFile() {
        return this.file;
    }

    public final LiveData<Event<String>> getLastLogEntry() {
        return this._lastLogEntry;
    }

    protected final MutableLiveData<Event<String>> get_lastLogEntry() {
        return this._lastLogEntry;
    }

    @Override // info.hannes.timber.DebugFormatTree, timber.log.Timber.DebugTree, timber.log.Timber.Tree
    protected void log(int priority, String tag, String message, Throwable t) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
            switch (priority) {
                case 2:
                    strValueOf = "V:";
                    break;
                case 3:
                    strValueOf = "D:";
                    break;
                case 4:
                    strValueOf = "I:";
                    break;
                case 5:
                    strValueOf = "W:";
                    break;
                case 6:
                    strValueOf = "E:";
                    break;
                case 7:
                    strValueOf = "A:";
                    break;
                default:
                    strValueOf = String.valueOf(priority);
                    break;
            }
            final String str2 = strValueOf + " " + str + tag + message + "\n";
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(str2, null), 3, null);
            if (Intrinsics.areEqual(Thread.currentThread().getName(), "main")) {
                this._lastLogEntry.setValue(new Event<>(str2));
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: info.hannes.timber.FileLoggingTree$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FileLoggingTree.log$lambda$1(this.f$0, str2);
                    }
                });
            }
        } catch (Exception e2) {
            if (this.logImpossible) {
                return;
            }
            Log.w(LOG_TAG, "Can't log into file : " + e2);
            this.logImpossible = true;
        }
    }

    /* JADX INFO: renamed from: info.hannes.timber.FileLoggingTree$log$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileLoggingTree.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "info.hannes.timber.FileLoggingTree$log$1", f = "FileLoggingTree.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $textLine;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$textLine = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = FileLoggingTree.this.new AnonymousClass1(this.$textLine, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FileLoggingTree fileLoggingTree = FileLoggingTree.this;
            String str = this.$textLine;
            try {
                Result.Companion companion = Result.INSTANCE;
                FileWriter fileWriter = new FileWriter(fileLoggingTree.getFile(), true);
                fileWriter.append((CharSequence) str);
                fileWriter.flush();
                fileWriter.close();
                Result.m12393constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m12393constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log$lambda$1(FileLoggingTree fileLoggingTree, String str) {
        fileLoggingTree._lastLogEntry.setValue(new Event<>(str));
    }

    public final String getFileName() {
        String absolutePath = this.file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return absolutePath;
    }
}
