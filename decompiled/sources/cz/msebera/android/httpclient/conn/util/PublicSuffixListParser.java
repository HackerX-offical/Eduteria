package cz.msebera.android.httpclient.conn.util;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class PublicSuffixListParser {
    private static final int MAX_LINE_LEN = 256;

    public PublicSuffixList parse(Reader reader) throws IOException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder(256);
        boolean line = true;
        while (line) {
            line = readLine(bufferedReader, sb);
            String string = sb.toString();
            if (!string.isEmpty() && !string.startsWith("//")) {
                if (string.startsWith(InstructionFileId.DOT)) {
                    string = string.substring(1);
                }
                boolean zStartsWith = string.startsWith("!");
                if (zStartsWith) {
                    string = string.substring(1);
                }
                if (zStartsWith) {
                    arrayList2.add(string);
                } else {
                    arrayList.add(string);
                }
            }
        }
        return new PublicSuffixList(arrayList, arrayList2);
    }

    private boolean readLine(Reader reader, StringBuilder sb) throws IOException {
        char c2;
        sb.setLength(0);
        boolean z = false;
        do {
            int i = reader.read();
            if (i == -1 || (c2 = (char) i) == '\n') {
                return i != -1;
            }
            if (Character.isWhitespace(c2)) {
                z = true;
            }
            if (!z) {
                sb.append(c2);
            }
        } while (sb.length() <= 256);
        return false;
    }
}
