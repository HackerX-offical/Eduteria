package com.x5.template.filters;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.clevertap.android.sdk.Constants;
import com.x5.template.Chunk;
import com.x5.template.TemplateSet;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class FilterArgs {
    private String[] filterArgs;
    private String filterName;
    private String rawArgs;
    private String rawInvocation;

    public FilterArgs(String str) {
        this.rawInvocation = str;
        init();
    }

    public String getFilterName() {
        return this.filterName;
    }

    public String[] getFilterArgs() {
        return this.filterArgs;
    }

    public String getUnparsedFilter() {
        return this.rawInvocation;
    }

    public String getUnparsedArgs() {
        return this.rawArgs;
    }

    private void init() {
        String str = this.rawInvocation;
        this.filterName = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = this.rawInvocation.indexOf(47);
        if (iIndexOf2 > -1 && (iIndexOf < 0 || iIndexOf > iIndexOf2)) {
            this.filterName = this.rawInvocation.substring(0, iIndexOf2);
            String strSubstring = this.rawInvocation.substring(iIndexOf2);
            this.rawArgs = strSubstring;
            this.filterArgs = new String[]{strSubstring};
            return;
        }
        if (iIndexOf > -1) {
            this.filterName = this.rawInvocation.substring(0, iIndexOf);
            int iLastIndexOf = this.rawInvocation.lastIndexOf(")");
            if (iLastIndexOf > iIndexOf) {
                String strSubstring2 = this.rawInvocation.substring(iIndexOf + 1, iLastIndexOf);
                this.rawArgs = strSubstring2;
                this.filterArgs = parseArgs(strSubstring2);
            }
        }
    }

    private static String[] parseArgs(String str) {
        return parseArgs(str, true);
    }

    private static String[] parseArgs(String str, boolean z) {
        int length;
        boolean z2;
        int iIndexOf;
        int i;
        int iIndexOf2;
        int iIndexOf3 = str.indexOf("\"");
        if (iIndexOf3 < 0 || str.substring(0, iIndexOf3).trim().length() > 0) {
            length = str.length();
            iIndexOf3 = -1;
            z2 = false;
        } else {
            length = str.indexOf("\"", iIndexOf3 + 1);
            if (length < 0) {
                length = str.length();
            }
            z2 = true;
        }
        String strSubstring = str.substring(iIndexOf3 + 1, length);
        String strSubstring2 = (!z2 || (iIndexOf = str.indexOf("\"", length + 1)) <= 0 || (iIndexOf2 = str.indexOf("\"", (i = iIndexOf + 1))) <= 0) ? null : str.substring(i, iIndexOf2);
        if (strSubstring2 != null) {
            return new String[]{strSubstring, strSubstring2};
        }
        if (z2 || !z || strSubstring.indexOf(Constants.SEPARATOR_COMMA) < 0) {
            return new String[]{strSubstring};
        }
        return parseCommaDelimitedArgs(strSubstring);
    }

    private static String[] parseCommaDelimitedArgs(String str) {
        int i;
        int iIndexOf;
        int iNextRegexDelim;
        int i2;
        int i3;
        int iNextUnescapedDelim;
        String[] strArr = new String[15];
        int i4 = 0;
        int length = 0;
        while (i4 < 15) {
            int iNextArgDelim = nextArgDelim(str, length);
            if (iNextArgDelim < 0) {
                break;
            }
            int iNextUnescapedDelim2 = nextUnescapedDelim("\"", str, length);
            if (iNextUnescapedDelim2 > -1 && iNextUnescapedDelim2 < iNextArgDelim && str.substring(length, iNextUnescapedDelim2).trim().length() == 0 && (iNextUnescapedDelim = nextUnescapedDelim("\"", str, (i3 = iNextUnescapedDelim2 + 1))) > 0) {
                strArr[i4] = str.substring(i3, iNextUnescapedDelim);
                i4++;
                int iNextArgDelim2 = nextArgDelim(str, iNextUnescapedDelim + 1);
                length = iNextArgDelim2 > 0 ? iNextArgDelim2 + 1 : str.length();
            } else {
                int iNextRegexDelim2 = RegexFilter.nextRegexDelim(str, length);
                if (iNextRegexDelim2 > -1 && iNextRegexDelim2 < iNextArgDelim) {
                    String strTrim = str.substring(length, iNextRegexDelim2).trim();
                    if ((strTrim.length() == 0 || strTrim.equals("m")) && (iNextRegexDelim = RegexFilter.nextRegexDelim(str, iNextRegexDelim2 + 1)) > 0) {
                        int iNextArgDelim3 = nextArgDelim(str, iNextRegexDelim + 1);
                        if (iNextArgDelim3 < 0) {
                            iNextArgDelim3 = str.length();
                            i2 = iNextArgDelim3;
                        } else {
                            i2 = iNextArgDelim3 + 1;
                        }
                        strArr[i4] = str.substring(iNextRegexDelim2, iNextArgDelim3);
                        i4++;
                        length = i2;
                    }
                }
                strArr[i4] = str.substring(length, iNextArgDelim);
                i4++;
                length = iNextArgDelim + 1;
                nextArgDelim(str, length);
            }
        }
        if (i4 == 15) {
            return strArr;
        }
        int iNextUnescapedDelim3 = nextUnescapedDelim(")", str, length);
        int length2 = str.length();
        if (iNextUnescapedDelim3 > 0) {
            length2 = iNextUnescapedDelim3;
        }
        strArr[i4] = str.substring(length, length2);
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        if (i6 < 15 && iNextUnescapedDelim3 > 0 && (i = iNextUnescapedDelim3 + 1) < str.length() && (iIndexOf = str.indexOf(40, i)) > 0) {
            strArr[i5] = "|" + str.substring(i, iIndexOf) + "|";
            int length3 = str.length();
            if (str.endsWith(")")) {
                length3--;
            }
            strArr[i6] = str.substring(iIndexOf + 1, length3);
            i5 = i4 + 3;
        }
        String[] strArr2 = new String[i5];
        System.arraycopy(strArr, 0, strArr2, 0, i5);
        return strArr2;
    }

    public static String magicBraces(Chunk chunk, String str) {
        if (str != null && str.length() != 0) {
            char cCharAt = str.charAt(0);
            if (cCharAt == '~' || cCharAt == '$') {
                if (chunk == null) {
                    return "{" + str + "}";
                }
                return chunk.makeTag(str);
            }
            if (cCharAt == '^' || cCharAt == '.') {
                if (chunk == null) {
                    return TemplateSet.PROTOCOL_SHORTHAND + str.substring(1) + TemplateSet.DEFAULT_TAG_END;
                }
                return chunk.makeTag(InstructionFileId.DOT + str.substring(1));
            }
            if (cCharAt == '+') {
                return "{" + str + "}";
            }
        }
        return str;
    }

    public static int nextArgDelim(String str, int i) {
        return nextUnescapedDelim(Constants.SEPARATOR_COMMA, str, i);
    }

    public static int nextUnescapedDelim(String str, String str2, int i) {
        int iIndexOf = str2.indexOf(str, i);
        boolean z = false;
        while (!z) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                int i4 = iIndexOf - i3;
                if (i4 < i || str2.charAt(i4) != '\\') {
                    break;
                }
                i2 = i3;
            }
            if (i2 % 2 == 0) {
                z = true;
            } else {
                iIndexOf = str2.indexOf(str, iIndexOf + 1);
                if (iIndexOf < 0) {
                    return -1;
                }
            }
        }
        return iIndexOf;
    }

    public static int grokValidColonScanPoint(String str, int i) {
        int iNextUnescapedDelim;
        int iNextRegexDelim;
        int iNextUnescapedDelim2;
        if (str.charAt(i) == 's' && str.charAt(i + 1) == '/') {
            return RegexFilter.nextRegexDelim(str, RegexFilter.nextRegexDelim(str, i + 2) + 1) + 1;
        }
        int i2 = i + 7;
        if (str.length() > i2 && str.substring(i, i2).equals("onmatch")) {
            i += 8;
            boolean z = false;
            while (!z) {
                int iIndexOf = str.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR, i);
                if (iIndexOf < 0 || (iNextRegexDelim = RegexFilter.nextRegexDelim(str, iIndexOf + 1)) < 0 || (iNextUnescapedDelim2 = nextUnescapedDelim(Constants.SEPARATOR_COMMA, str, iNextRegexDelim + 1)) < 0) {
                    break;
                }
                int i3 = iNextUnescapedDelim2 + 1;
                int iNextUnescapedDelim3 = nextUnescapedDelim(Constants.SEPARATOR_COMMA, str, i3);
                if (iNextUnescapedDelim3 < 0) {
                    int iNextUnescapedDelim4 = nextUnescapedDelim(")", str, i3);
                    if (iNextUnescapedDelim4 < 0) {
                        break;
                    }
                    int i4 = iNextUnescapedDelim4 + 8;
                    if (str.length() > i4) {
                        i = iNextUnescapedDelim4 + 1;
                        if (str.substring(i, i4).equals("nomatch")) {
                            z = true;
                        }
                    }
                    return iNextUnescapedDelim4 + 1;
                }
                i = iNextUnescapedDelim3 + 1;
            }
        }
        int iIndexOf2 = str.indexOf("(", i);
        return (iIndexOf2 >= 0 && (iNextUnescapedDelim = nextUnescapedDelim(")", str, iIndexOf2 + 1)) >= 0) ? iNextUnescapedDelim + 1 : i;
    }
}
