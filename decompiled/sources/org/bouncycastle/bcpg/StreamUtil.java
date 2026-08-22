package org.bouncycastle.bcpg;

import androidx.collection.SieveCacheKt;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes10.dex */
class StreamUtil {
    private static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();

    StreamUtil() {
    }

    static int findLimit(InputStream inputStream) {
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                long size = channel != null ? channel.size() : 2147483647L;
                if (size < SieveCacheKt.NodeLinkMask) {
                    return (int) size;
                }
            } catch (IOException unused) {
            }
        }
        long j = MAX_MEMORY;
        if (j > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }
}
