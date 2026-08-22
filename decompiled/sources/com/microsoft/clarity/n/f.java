package com.microsoft.clarity.n;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public final class f {
    public static String a(String... paths) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        return ArraysKt.joinToString$default(paths, String.valueOf(File.separatorChar), (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static IntRange a(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) path, MqttTopic.TOPIC_LEVEL_SEPARATOR, 0, false, 6, (Object) null) + 1;
        int iLastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) path, InstructionFileId.DOT, 0, false, 6, (Object) null) - 1;
        if (iLastIndexOf$default2 < iLastIndexOf$default) {
            iLastIndexOf$default2 = path.length() - 1;
        }
        return new IntRange(iLastIndexOf$default, iLastIndexOf$default2);
    }
}
