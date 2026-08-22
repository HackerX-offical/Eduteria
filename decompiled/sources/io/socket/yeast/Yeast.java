package io.socket.yeast;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class Yeast {
    private static char[] alphabet;
    private static int length;
    private static Map<Character, Integer> map;
    private static String prev;
    private static int seed;

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        alphabet = charArray;
        length = charArray.length;
        seed = 0;
        map = new HashMap(length);
        for (int i = 0; i < length; i++) {
            map.put(Character.valueOf(alphabet[i]), Integer.valueOf(i));
        }
    }

    private Yeast() {
    }

    public static String encode(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, alphabet[(int) (j % ((long) length))]);
            j /= (long) length;
        } while (j > 0);
        return sb.toString();
    }

    public static long decode(String str) {
        long jIntValue = 0;
        for (char c2 : str.toCharArray()) {
            jIntValue = (jIntValue * ((long) length)) + ((long) map.get(Character.valueOf(c2)).intValue());
        }
        return jIntValue;
    }

    public static String yeast() {
        String strEncode = encode(new Date().getTime());
        if (!strEncode.equals(prev)) {
            seed = 0;
            prev = strEncode;
            return strEncode;
        }
        StringBuilder sbAppend = new StringBuilder().append(strEncode).append(InstructionFileId.DOT);
        int i = seed;
        seed = i + 1;
        return sbAppend.append(encode(i)).toString();
    }
}
