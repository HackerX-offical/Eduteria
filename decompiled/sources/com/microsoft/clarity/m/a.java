package com.microsoft.clarity.m;

import android.content.Context;
import com.microsoft.clarity.n.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1071a;

    /* JADX INFO: renamed from: com.microsoft.clarity.m.a$a, reason: collision with other inner class name */
    public static final class C0191a extends Lambda implements Function1<File, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0191a f1072a = new C0191a();

        public C0191a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(File file) {
            File f2 = file;
            Intrinsics.checkNotNullParameter(f2, "f");
            return Boolean.valueOf(f2.isDirectory() && !Files.list(f2.toPath()).findFirst().isPresent());
        }
    }

    public a(Context context, String directory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(directory, "directory");
        String strA = f.a("microsoft_clarity", directory);
        String string = context.getCacheDir().toString();
        Intrinsics.checkNotNullExpressionValue(string, "context.cacheDir.toString()");
        this.f1071a = f.a(string, strA);
    }

    public final void a() {
        Iterator it = SequencesKt.filter(FilesKt.walkTopDown(new File(f.a(this.f1071a))), C0191a.f1072a).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public final void a(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        new File(f.a(this.f1071a, filename)).delete();
    }

    public final boolean b(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        return new File(f.a(this.f1071a, filename)).exists();
    }

    public final byte[] c(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        FileInputStream fileInputStream = new FileInputStream(new File(f.a(this.f1071a, filename)));
        try {
            byte[] bytes = ByteStreamsKt.readBytes(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            return bytes;
        } finally {
        }
    }

    public final String d(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        byte[] bArrC = c(filename);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return new String(bArrC, UTF_8);
    }

    public static List a(a aVar, String prefix, boolean z, int i) {
        if ((i & 1) != 0) {
            prefix = "";
        }
        if ((i & 2) != 0) {
            z = false;
        }
        aVar.getClass();
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return SequencesKt.toList(SequencesKt.filter(FilesKt.walkTopDown(new File(f.a(aVar.f1071a, prefix))), new b(z)));
    }

    public final void a(String filename, String content, c mode) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        File file = new File(f.a(this.f1071a, filename));
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, mode == c.APPEND);
        try {
            fileOutputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public final void a(String filename, byte[] content) {
        c mode = c.OVERWRITE;
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mode, "mode");
        File file = new File(f.a(this.f1071a, filename));
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            fileOutputStream.write(content);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }
}
