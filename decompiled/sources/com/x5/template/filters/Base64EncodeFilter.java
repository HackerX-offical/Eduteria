package com.x5.template.filters;

import com.x5.template.Chunk;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import sun.misc.BASE64Encoder;

/* JADX INFO: loaded from: classes9.dex */
public class Base64EncodeFilter extends BasicFilter implements ChunkFilter {
    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        return base64(str);
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return AbstractHttpOverXmpp.Base64.ELEMENT;
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"base64encode"};
    }

    public static String base64(String str) {
        try {
            return base64(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return base64(str.getBytes());
        }
    }

    public static String base64(byte[] bArr) {
        try {
            try {
                try {
                    return ((BASE64Encoder) Class.forName("sun.misc.BASE64Encoder").newInstance()).encode(bArr);
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
                    return (String) Class.forName("com.x5.util.Base64").getMethod("encodeBytes", byte[].class).invoke(null, bArr);
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return new String(bArr, "UTF-8");
            }
        } catch (UnsupportedEncodingException unused3) {
            return new String(bArr);
        }
    }
}
