package com.google.code.regexp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes8.dex */
public class Pattern implements Serializable {
    public static final int CANON_EQ = 128;
    public static final int CASE_INSENSITIVE = 2;
    public static final int COMMENTS = 4;
    public static final int DOTALL = 32;
    private static final int INDEX_GROUP_NAME = 1;
    public static final int LITERAL = 16;
    public static final int MULTILINE = 8;
    private static final String NAME_PATTERN = "[^!=].*?";
    public static final int UNICODE_CASE = 64;
    public static final int UNIX_LINES = 1;
    private static final long serialVersionUID = 1;
    private Map<String, List<GroupInfo>> groupInfo;
    private List<String> groupNames;
    private String namedPattern;
    private java.util.regex.Pattern pattern;
    private static final java.util.regex.Pattern NAMED_GROUP_PATTERN = java.util.regex.Pattern.compile("\\(\\?<([^!=].*?)>", 32);
    private static final java.util.regex.Pattern BACKREF_NAMED_GROUP_PATTERN = java.util.regex.Pattern.compile("\\\\k<([^!=].*?)>", 32);
    private static final java.util.regex.Pattern PROPERTY_PATTERN = java.util.regex.Pattern.compile("\\$\\{([^!=].*?)\\}", 32);

    protected Pattern(String str, int i) {
        this.namedPattern = str;
        this.groupInfo = extractGroupInfo(str);
        this.pattern = buildStandardPattern(str, Integer.valueOf(i));
    }

    private java.util.regex.Pattern buildStandardPattern(String str, Integer num) {
        return java.util.regex.Pattern.compile(replaceGroupNameWithIndex(replace(new StringBuilder(str), NAMED_GROUP_PATTERN, "("), BACKREF_NAMED_GROUP_PATTERN, "\\").toString(), num.intValue());
    }

    public static Pattern compile(String str) {
        return new Pattern(str, 0);
    }

    public static Pattern compile(String str, int i) {
        return new Pattern(str, i);
    }

    private static int countOpenParens(String str, int i) {
        int i2 = 0;
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\(").matcher(str.subSequence(0, i));
        while (matcher.find()) {
            if (!isInsideCharClass(str, matcher.start()) && !isEscapedChar(str, matcher.start()) && !isNoncapturingParen(str, matcher.start())) {
                i2++;
            }
        }
        return i2;
    }

    public static Map<String, List<GroupInfo>> extractGroupInfo(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        java.util.regex.Matcher matcher = NAMED_GROUP_PATTERN.matcher(str);
        while (matcher.find()) {
            int iStart = matcher.start();
            if (!isEscapedChar(str, iStart)) {
                String strGroup = matcher.group(1);
                int iCountOpenParens = countOpenParens(str, iStart);
                List arrayList = linkedHashMap.containsKey(strGroup) ? (List) linkedHashMap.get(strGroup) : new ArrayList();
                arrayList.add(new GroupInfo(iCountOpenParens, iStart));
                linkedHashMap.put(strGroup, arrayList);
            }
        }
        return linkedHashMap;
    }

    private boolean groupInfoMatches(Map<String, List<GroupInfo>> map, Map<String, List<GroupInfo>> map2) {
        if (map == null && map2 == null) {
            return true;
        }
        if (map != null && map2 != null) {
            if (map.isEmpty() && map2.isEmpty()) {
                return true;
            }
            if (map.size() == map2.size()) {
                boolean z = false;
                for (Map.Entry<String, List<GroupInfo>> entry : map.entrySet()) {
                    List list = map2.get(entry.getKey());
                    boolean z2 = list != null;
                    if (!z2) {
                        return z2;
                    }
                    List value = entry.getValue();
                    z = list.containsAll(value) && value.containsAll(list);
                    if (!z) {
                        break;
                    }
                }
                return z;
            }
        }
        return false;
    }

    private static boolean isEscapedChar(String str, int i) {
        return isSlashEscapedChar(str, i) || isQuoteEscapedChar(str, i);
    }

    private static boolean isInsideCharClass(String str, int i) {
        boolean z;
        boolean z2;
        String strSubstring = str.substring(0, i);
        int iLastIndexOf = i;
        while (true) {
            iLastIndexOf = strSubstring.lastIndexOf(91, iLastIndexOf - 1);
            if (iLastIndexOf == -1) {
                z = false;
                break;
            }
            if (!isEscapedChar(strSubstring, iLastIndexOf)) {
                z = true;
                break;
            }
        }
        if (!z) {
            z2 = false;
            break;
        }
        String strSubstring2 = str.substring(iLastIndexOf, i);
        int iIndexOf = -1;
        do {
            iIndexOf = strSubstring2.indexOf(93, iIndexOf + 1);
            if (iIndexOf == -1) {
                z2 = false;
                break;
            }
        } while (isEscapedChar(strSubstring2, iIndexOf));
        z2 = true;
        return z && !z2;
    }

    private static boolean isNoncapturingParen(String str, int i) {
        String strSubstring = str.substring(i, i + 4);
        return str.charAt(i + 1) == '?' && ((strSubstring.equals("(?<=") || strSubstring.equals("(?<!")) || str.charAt(i + 2) != '<');
    }

    private static boolean isQuoteEscapedChar(String str, int i) {
        boolean z;
        String strSubstring = str.substring(0, i);
        while (true) {
            i = strSubstring.lastIndexOf("\\Q", i - 1);
            if (i == -1) {
                z = false;
                break;
            }
            if (!isSlashEscapedChar(strSubstring, i)) {
                z = true;
                break;
            }
        }
        return z && !(z && strSubstring.indexOf("\\E", i) != -1);
    }

    private static boolean isSlashEscapedChar(String str, int i) {
        int i2 = 0;
        while (i > 0 && str.charAt(i - 1) == '\\') {
            i--;
            i2++;
        }
        return i2 % 2 != 0;
    }

    private static StringBuilder replace(StringBuilder sb, java.util.regex.Pattern pattern, String str) {
        java.util.regex.Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            if (!isEscapedChar(sb.toString(), matcher.start())) {
                sb.replace(matcher.start(), matcher.end(), str);
                matcher.reset(sb);
            }
        }
        return sb;
    }

    private StringBuilder replaceGroupNameWithIndex(StringBuilder sb, java.util.regex.Pattern pattern, String str) {
        java.util.regex.Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            if (!isEscapedChar(sb.toString(), matcher.start())) {
                int iIndexOf = indexOf(matcher.group(1));
                if (iIndexOf < 0) {
                    throw new PatternSyntaxException("unknown group name", sb.toString(), matcher.start(1));
                }
                sb.replace(matcher.start(), matcher.end(), str + (iIndexOf + 1));
                matcher.reset(sb);
            }
        }
        return sb;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Pattern)) {
            return false;
        }
        Pattern pattern = (Pattern) obj;
        List<String> list = this.groupNames;
        boolean z = (list == null && pattern.groupNames == null) || !(list == null || Collections.disjoint(list, pattern.groupNames));
        return z && (z && groupInfoMatches(this.groupInfo, pattern.groupInfo)) && this.namedPattern.equals(pattern.namedPattern) && this.pattern.flags() == pattern.pattern.flags();
    }

    public int flags() {
        return this.pattern.flags();
    }

    public Map<String, List<GroupInfo>> groupInfo() {
        return Collections.unmodifiableMap(this.groupInfo);
    }

    public List<String> groupNames() {
        if (this.groupNames == null) {
            this.groupNames = new ArrayList(this.groupInfo.keySet());
        }
        return Collections.unmodifiableList(this.groupNames);
    }

    public int hashCode() {
        int iHashCode = this.namedPattern.hashCode() ^ this.pattern.hashCode();
        Map<String, List<GroupInfo>> map = this.groupInfo;
        if (map != null) {
            iHashCode ^= map.hashCode();
        }
        List<String> list = this.groupNames;
        return list != null ? iHashCode ^ list.hashCode() : iHashCode;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public int indexOf(String str, int i) {
        if (this.groupInfo.containsKey(str)) {
            return this.groupInfo.get(str).get(i).groupIndex();
        }
        return -1;
    }

    public Matcher matcher(CharSequence charSequence) {
        return new Matcher(this, charSequence);
    }

    public String namedPattern() {
        return this.namedPattern;
    }

    public java.util.regex.Pattern pattern() {
        return this.pattern;
    }

    public String replaceProperties(String str) {
        return replaceGroupNameWithIndex(new StringBuilder(str), PROPERTY_PATTERN, "$").toString();
    }

    public String[] split(CharSequence charSequence) {
        return this.pattern.split(charSequence);
    }

    public String[] split(CharSequence charSequence, int i) {
        return this.pattern.split(charSequence, i);
    }

    public String standardPattern() {
        return this.pattern.pattern();
    }

    public String toString() {
        return this.namedPattern;
    }
}
