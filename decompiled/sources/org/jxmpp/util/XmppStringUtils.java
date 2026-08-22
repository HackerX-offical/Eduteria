package org.jxmpp.util;

import org.jxmpp.util.cache.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public class XmppStringUtils {
    private static final LruCache<String, String> LOCALPART_ESCAPE_CACHE = new LruCache<>(100);
    private static final LruCache<String, String> LOCALPART_UNESCAPE_CACHE = new LruCache<>(100);

    public static String parseLocalpart(String str) {
        int iIndexOf = str.indexOf(64);
        if (iIndexOf < 0) {
            return null;
        }
        if (iIndexOf == 0) {
            return "";
        }
        int iIndexOf2 = str.indexOf(47);
        if (iIndexOf2 < 0 || iIndexOf2 >= iIndexOf) {
            return str.substring(0, iIndexOf);
        }
        return null;
    }

    public static String parseDomain(String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(64);
        int iIndexOf2 = str.indexOf(47);
        if (iIndexOf2 < 0) {
            return str.substring(iIndexOf + 1);
        }
        if (iIndexOf2 > iIndexOf) {
            return str.substring(iIndexOf + 1, iIndexOf2);
        }
        return str.substring(0, iIndexOf2);
    }

    public static String parseResource(String str) {
        int iIndexOf = str.indexOf(47);
        if (iIndexOf < 0) {
            return null;
        }
        int i = iIndexOf + 1;
        if (i > str.length()) {
            return "";
        }
        return str.substring(i);
    }

    public static String parseBareJid(String str) {
        int iIndexOf = str.indexOf(47);
        if (iIndexOf < 0) {
            return str;
        }
        if (iIndexOf == 0) {
            return "";
        }
        return str.substring(0, iIndexOf);
    }

    public static boolean isFullJID(String str) {
        String domain = parseDomain(str);
        String resource = parseResource(str);
        return domain != null && domain.length() > 0 && resource != null && resource.length() > 0;
    }

    public static boolean isBareJid(String str) {
        String domain = parseDomain(str);
        String resource = parseResource(str);
        if (domain == null || domain.length() <= 0) {
            return false;
        }
        return resource == null || resource.length() == 0;
    }

    public static String escapeLocalpart(String str) {
        if (str == null) {
            return null;
        }
        String strLookup = LOCALPART_ESCAPE_CACHE.lookup(str);
        if (strLookup != null) {
            return strLookup;
        }
        StringBuilder sb = new StringBuilder(str.length() + 8);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                sb.append("\\22");
            } else if (cCharAt == '/') {
                sb.append("\\2f");
            } else if (cCharAt == ':') {
                sb.append("\\3a");
            } else if (cCharAt == '<') {
                sb.append("\\3c");
            } else if (cCharAt == '>') {
                sb.append("\\3e");
            } else if (cCharAt == '@') {
                sb.append("\\40");
            } else if (cCharAt == '\\') {
                sb.append("\\5c");
            } else if (cCharAt == '&') {
                sb.append("\\26");
            } else if (cCharAt == '\'') {
                sb.append("\\27");
            } else if (Character.isWhitespace(cCharAt)) {
                sb.append("\\20");
            } else {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        LOCALPART_ESCAPE_CACHE.put(str, string);
        return string;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String unescapeLocalpart(java.lang.String r10) {
        /*
            if (r10 != 0) goto L4
            r10 = 0
            return r10
        L4:
            org.jxmpp.util.cache.LruCache<java.lang.String, java.lang.String> r0 = org.jxmpp.util.XmppStringUtils.LOCALPART_UNESCAPE_CACHE
            java.lang.Object r0 = r0.lookup(r10)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto Lf
            return r0
        Lf:
            char[] r0 = r10.toCharArray()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r2 = r0.length
            r1.<init>(r2)
            int r2 = r0.length
            r3 = 0
        L1b:
            if (r3 >= r2) goto L9e
            char r4 = r10.charAt(r3)
            r5 = 92
            if (r4 != r5) goto L97
            int r5 = r3 + 2
            if (r5 >= r2) goto L97
            int r6 = r3 + 1
            char r6 = r0[r6]
            char r7 = r0[r5]
            r8 = 99
            r9 = 48
            switch(r6) {
                case 50: goto L65;
                case 51: goto L48;
                case 52: goto L40;
                case 53: goto L38;
                default: goto L36;
            }
        L36:
            goto L97
        L38:
            if (r7 != r8) goto L97
            java.lang.String r3 = "\\"
            r1.append(r3)
            goto L95
        L40:
            if (r7 != r9) goto L97
            java.lang.String r3 = "@"
            r1.append(r3)
            goto L95
        L48:
            r6 = 97
            if (r7 == r6) goto L5f
            if (r7 == r8) goto L59
            r6 = 101(0x65, float:1.42E-43)
            if (r7 == r6) goto L53
            goto L97
        L53:
            r3 = 62
            r1.append(r3)
            goto L95
        L59:
            r3 = 60
            r1.append(r3)
            goto L95
        L5f:
            r3 = 58
            r1.append(r3)
            goto L95
        L65:
            if (r7 == r9) goto L90
            r6 = 50
            if (r7 == r6) goto L8a
            r6 = 102(0x66, float:1.43E-43)
            if (r7 == r6) goto L84
            r6 = 54
            if (r7 == r6) goto L7e
            r6 = 55
            if (r7 == r6) goto L78
            goto L97
        L78:
            r3 = 39
            r1.append(r3)
            goto L95
        L7e:
            r3 = 38
            r1.append(r3)
            goto L95
        L84:
            r3 = 47
            r1.append(r3)
            goto L95
        L8a:
            r3 = 34
            r1.append(r3)
            goto L95
        L90:
            r3 = 32
            r1.append(r3)
        L95:
            r3 = r5
            goto L9a
        L97:
            r1.append(r4)
        L9a:
            int r3 = r3 + 1
            goto L1b
        L9e:
            java.lang.String r0 = r1.toString()
            org.jxmpp.util.cache.LruCache<java.lang.String, java.lang.String> r1 = org.jxmpp.util.XmppStringUtils.LOCALPART_UNESCAPE_CACHE
            r1.put(r10, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jxmpp.util.XmppStringUtils.unescapeLocalpart(java.lang.String):java.lang.String");
    }

    public static String completeJidFrom(CharSequence charSequence, CharSequence charSequence2) {
        return completeJidFrom(charSequence != null ? charSequence.toString() : null, charSequence2.toString());
    }

    public static String completeJidFrom(String str, String str2) {
        return completeJidFrom(str, str2, (String) null);
    }

    public static String completeJidFrom(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return completeJidFrom(charSequence != null ? charSequence.toString() : null, charSequence2.toString(), charSequence3 != null ? charSequence3.toString() : null);
    }

    public static String completeJidFrom(String str, String str2, String str3) {
        if (str2 == null) {
            throw new IllegalArgumentException("domainpart must not be null");
        }
        int length = str != null ? str.length() : 0;
        int length2 = str2.length();
        int length3 = str3 != null ? str3.length() : 0;
        StringBuilder sb = new StringBuilder(length2 + length + length3 + 2);
        if (length > 0) {
            sb.append(str).append('@');
        }
        sb.append(str2);
        if (length3 > 0) {
            sb.append('/').append(str3);
        }
        return sb.toString();
    }

    public static String generateKey(String str, String str2) {
        return str + '\t' + str2;
    }
}
