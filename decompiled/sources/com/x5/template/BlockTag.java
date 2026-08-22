package com.x5.template;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BlockTag {
    public boolean doSmartTrimAroundBlock() {
        return false;
    }

    public abstract String getBlockEndMarker();

    public abstract String getBlockStartMarker();

    public boolean hasBody(String str) {
        return true;
    }

    public abstract void renderBlock(Writer writer, Chunk chunk, String str, int i) throws IOException;

    private static int locateTag(List<SnippetPart> list, String str, int i) {
        String tag;
        while (i < list.size()) {
            SnippetPart snippetPart = list.get(i);
            if (snippetPart.isTag() && (tag = ((SnippetTag) snippetPart).getTag()) != null && tag.startsWith(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int findMatchingBlockEnd(BlockTag blockTag, List<SnippetPart> list, int i) {
        String str = InstructionFileId.DOT + blockTag.getBlockEndMarker();
        String str2 = InstructionFileId.DOT + blockTag.getBlockStartMarker();
        int iLocateTag = locateTag(list, str2, i);
        int iLocateTag2 = locateTag(list, str, i);
        int i2 = (iLocateTag <= -1 || iLocateTag >= iLocateTag2) ? 0 : 1;
        while (i2 > 0 && iLocateTag2 > 0) {
            while (iLocateTag > -1 && iLocateTag < iLocateTag2) {
                iLocateTag = locateTag(list, str2, iLocateTag + 1);
                if (iLocateTag > -1 && iLocateTag < iLocateTag2) {
                    i2++;
                }
            }
            int i3 = i2 - 1;
            iLocateTag2 = locateTag(list, str, iLocateTag2 + 1);
            if (iLocateTag <= -1 || iLocateTag >= iLocateTag2) {
                i2 = i3;
            }
        }
        return iLocateTag2;
    }

    public static String qualifyTemplateRef(String str, String str2) {
        return (str == null || str2.charAt(0) != '#') ? str2 : str + str2;
    }
}
