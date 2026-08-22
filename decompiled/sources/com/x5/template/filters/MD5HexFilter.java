package com.x5.template.filters;

import com.x5.template.Chunk;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class MD5HexFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return md5Hex(str);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return "md5";
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"md5hex"};
    }

    public static String md5Hex(String str) {
        return md5(str, false);
    }

    public static String md5Base64(String str) {
        return md5(str, true);
    }

    public static String md5(String str, boolean z) {
        return hashCrypt(StringUtils.MD5, str, z);
    }

    public static String hashCrypt(String str, String str2, boolean z) {
        byte[] bytes;
        try {
            bytes = str2.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = str2.getBytes();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bytes, 0, bytes.length);
            if (z) {
                return Base64EncodeFilter.base64(messageDigest.digest());
            }
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException unused2) {
            return str2;
        }
    }
}
