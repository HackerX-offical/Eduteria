package info.hannes.timber;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import timber.log.Timber;

/* JADX INFO: compiled from: TimberExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001¨\u0006\u0002"}, d2 = {"fileLoggingTree", "Linfo/hannes/timber/FileLoggingTree;", "LogcatCore_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimberExtensionsKt {
    public static final FileLoggingTree fileLoggingTree() {
        List<Timber.Tree> listForest = Timber.INSTANCE.forest();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listForest) {
            if (obj instanceof FileLoggingTree) {
                arrayList.add(obj);
            }
        }
        return (FileLoggingTree) CollectionsKt.firstOrNull((List) arrayList);
    }
}
