package androidx.media3.exoplayer.hls;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(String str) {
        super("Unable to bind a sample queue to TrackGroup with MIME type " + str + InstructionFileId.DOT);
    }
}
