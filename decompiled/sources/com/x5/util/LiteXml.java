package com.x5.util;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* JADX INFO: loaded from: classes9.dex */
public class LiteXml {
    private static final int MAX_PARSE = 15;
    private Map<String, String> attrs = null;
    private String xml;
    private static final Pattern XML_ENTITY_REGEX = Pattern.compile("&(#?)([^;]+);");
    private static final Map<String, String> STD_ENTITIES = getStandardEntities();

    public LiteXml(String str) {
        this.xml = str;
    }

    public String getNodeType() {
        String str = this.xml;
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf("?>");
        int iIndexOf2 = this.xml.indexOf(60, iIndexOf > -1 ? iIndexOf + 2 : 0);
        if (iIndexOf2 < 0) {
            return null;
        }
        int iIndexOf3 = this.xml.indexOf(32, iIndexOf2);
        int iIndexOf4 = this.xml.indexOf(62, iIndexOf2);
        if (iIndexOf3 <= -1 || iIndexOf3 >= iIndexOf4) {
            iIndexOf3 = iIndexOf4;
        }
        int i = iIndexOf2 + 1;
        if (iIndexOf3 < i) {
            return null;
        }
        return this.xml.substring(i, iIndexOf3);
    }

    public Map<String, String> getAttributes() {
        int iIndexOf;
        String str = this.xml;
        if (str == null) {
            return null;
        }
        Map<String, String> map = this.attrs;
        if (map != null) {
            return map;
        }
        int iIndexOf2 = str.indexOf(62);
        if (iIndexOf2 < 0 || (iIndexOf = this.xml.indexOf(32)) < 0 || iIndexOf > iIndexOf2) {
            return null;
        }
        Map<String, String> attributes = parseAttributes(this.xml.substring(iIndexOf + 1, iIndexOf2));
        this.attrs = attributes;
        return attributes;
    }

    private Map<String, String> parseAttributes(String str) {
        int iIndexOf;
        int i;
        int iNextUnescapedDelim;
        HashMap map = new HashMap();
        int i2 = 0;
        while (i2 < str.length() && (iIndexOf = str.indexOf(61, i2)) >= 0) {
            String strSubstring = str.substring(i2, iIndexOf);
            int iIndexOf2 = str.indexOf(34, iIndexOf + 1);
            if (iIndexOf2 < 0 || (iNextUnescapedDelim = nextUnescapedDelim("\"", str, (i = iIndexOf2 + 1))) < 0) {
                break;
            }
            map.put(strSubstring.trim(), unescapeXML(str.substring(i, iNextUnescapedDelim).replaceAll("\\\\\"", "\"").replaceAll("\\\\\\\\", "\\\\")));
            int iIndexOf3 = str.indexOf(32, iNextUnescapedDelim + 1);
            if (iIndexOf3 < 0) {
                break;
            }
            i2 = iIndexOf3 + 1;
        }
        return map;
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

    public String getAttribute(String str) {
        Map<String, String> attributes = getAttributes();
        if (attributes == null || attributes.size() < 1) {
            return null;
        }
        return attributes.get(str);
    }

    private String getRawNodeValue() {
        String nodeType;
        if (this.xml == null || (nodeType = getNodeType()) == null) {
            return null;
        }
        int iIndexOf = this.xml.indexOf(62, this.xml.indexOf(nodeType) + nodeType.length());
        int iLastIndexOf = this.xml.lastIndexOf(60);
        if (iIndexOf < 0 || iLastIndexOf < iIndexOf) {
            return null;
        }
        if (this.xml.indexOf(nodeType, iLastIndexOf) < 0) {
            return this.xml;
        }
        return this.xml.substring(iIndexOf + 1, iLastIndexOf);
    }

    private boolean isCDATA(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        return strTrim.startsWith("<![CDATA[") && strTrim.endsWith("]]>");
    }

    public String getNodeValue() {
        String rawNodeValue = getRawNodeValue();
        if (rawNodeValue == null) {
            return null;
        }
        if (isCDATA(rawNodeValue)) {
            return rawNodeValue.trim().substring(9, rawNodeValue.length() - 3);
        }
        return unescapeXML(rawNodeValue);
    }

    public LiteXml[] getChildNodes(String str) {
        LiteXml[] childNodes;
        if (str == null || (childNodes = getChildNodes()) == null) {
            return null;
        }
        int length = childNodes.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < childNodes.length; i2++) {
            if (childNodes[i2].getNodeType().equals(str)) {
                i++;
                zArr[i2] = true;
            }
        }
        if (i == 0) {
            return null;
        }
        if (i == childNodes.length) {
            return childNodes;
        }
        LiteXml[] liteXmlArr = new LiteXml[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                liteXmlArr[i3] = childNodes[i4];
                i3++;
            }
        }
        return liteXmlArr;
    }

    public LiteXml[] getChildNodes() {
        int iIndexOf;
        LiteXml[] liteXmlArr = null;
        if (this.xml == null) {
            return null;
        }
        String rawNodeValue = getRawNodeValue();
        if (rawNodeValue != null && !isCDATA(rawNodeValue)) {
            int[] iArrExtendArray = new int[30];
            int length = rawNodeValue.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 * 2;
                if (i3 >= iArrExtendArray.length) {
                    iArrExtendArray = extendArray(iArrExtendArray);
                }
                int iIndexOf2 = rawNodeValue.indexOf(60, i);
                if (iIndexOf2 < 0) {
                    break;
                }
                int i4 = iIndexOf2 + 1;
                if (rawNodeValue.charAt(i4) == '/' || (iIndexOf = rawNodeValue.indexOf(62, i4)) < 0) {
                    return null;
                }
                if (rawNodeValue.charAt(iIndexOf - 1) == '/') {
                    iArrExtendArray[i3] = iIndexOf2;
                    i = iIndexOf + 1;
                    iArrExtendArray[i3 + 1] = i;
                } else {
                    int iIndexOf3 = rawNodeValue.indexOf(32, i4);
                    int iIndexOf4 = rawNodeValue.indexOf(62, i4);
                    if (iIndexOf3 < 0 && iIndexOf4 < 0) {
                        return null;
                    }
                    if (iIndexOf3 < 0 || iIndexOf3 > iIndexOf4) {
                        iIndexOf3 = iIndexOf4;
                    }
                    String strSubstring = rawNodeValue.substring(i4, iIndexOf3);
                    String str = "</" + strSubstring;
                    int i5 = iIndexOf + 1;
                    int iIndexOf5 = rawNodeValue.indexOf(str, i5);
                    String str2 = "<" + strSubstring;
                    for (int iIndexOf6 = rawNodeValue.indexOf(str2, i5); iIndexOf6 > -1 && iIndexOf6 < iIndexOf5; iIndexOf6 = rawNodeValue.indexOf(str2, iIndexOf6 + 3)) {
                        iIndexOf5 = rawNodeValue.indexOf(str, iIndexOf5 + 3);
                        if (iIndexOf5 < 0) {
                            return null;
                        }
                    }
                    int iIndexOf7 = rawNodeValue.indexOf(62, iIndexOf5 + 2);
                    if (iIndexOf7 < 0) {
                        return null;
                    }
                    iArrExtendArray[i3] = iIndexOf2;
                    i = iIndexOf7 + 1;
                    iArrExtendArray[i3 + 1] = i;
                }
                i2++;
            }
            if (i2 < 1) {
                return null;
            }
            liteXmlArr = new LiteXml[i2];
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i6 * 2;
                liteXmlArr[i6] = new LiteXml(rawNodeValue.substring(iArrExtendArray[i7], iArrExtendArray[i7 + 1]));
            }
        }
        return liteXmlArr;
    }

    private int[] extendArray(int[] iArr) {
        int[] iArr2 = new int[iArr.length + 30];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public LiteXml getFirstChild() {
        LiteXml[] childNodes = getChildNodes();
        if (childNodes == null) {
            return null;
        }
        return childNodes[0];
    }

    public String getPathValue(String str) {
        LiteXml liteXmlFindNode = findNode(str);
        if (liteXmlFindNode == null) {
            return null;
        }
        return liteXmlFindNode.getNodeValue();
    }

    public String getNodeValue(String str) {
        if (str == null) {
            return null;
        }
        return getPathValue(normalizeBranchPath(str));
    }

    private String normalizeBranchPath(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            return "*" + str;
        }
        return "*/" + str;
    }

    public LiteXml findChildNode(String str) {
        return findNode(normalizeBranchPath(str));
    }

    public LiteXml findNode(String str) {
        if (str == null) {
            return null;
        }
        if (str.charAt(0) == '/') {
            if (str.charAt(1) == '/') {
                return null;
            }
            str = str.substring(1);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, MqttTopic.TOPIC_LEVEL_SEPARATOR);
        int iCountTokens = stringTokenizer.countTokens();
        String[] strArr = new String[iCountTokens];
        for (int i = 0; i < iCountTokens; i++) {
            strArr[i] = stringTokenizer.nextToken();
        }
        return findNode(strArr);
    }

    public LiteXml findNode(String[] strArr) {
        return findNodeX(strArr, 0);
    }

    private static boolean isMatch(String str, String str2) {
        return (str == null || str2 == null || (!str.equals(str2) && !str2.equals("*"))) ? false : true;
    }

    private LiteXml findNodeX(String[] strArr, int i) {
        LiteXml[] childNodes;
        if (!isMatch(getNodeType(), strArr[i]) || (childNodes = getChildNodes()) == null) {
            return null;
        }
        for (LiteXml liteXml : childNodes) {
            int i2 = i + 1;
            if (isMatch(liteXml.getNodeType(), strArr[i2])) {
                if (strArr.length == i + 2) {
                    return liteXml;
                }
                LiteXml liteXmlFindNodeX = liteXml.findNodeX(strArr, i2);
                if (liteXmlFindNodeX != null) {
                    return liteXmlFindNodeX;
                }
            }
        }
        return null;
    }

    public static String unescapeXML(String str) {
        String string;
        int i;
        StringBuffer stringBuffer = new StringBuffer(str.length());
        Matcher matcher = XML_ENTITY_REGEX.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(2);
            String strGroup2 = matcher.group(1);
            if (strGroup2 != null && strGroup2.length() > 0) {
                if (strGroup.substring(0, 1).toLowerCase().equals("x")) {
                    i = Integer.parseInt(strGroup.substring(1), 16);
                } else {
                    i = Integer.parseInt(strGroup);
                }
                string = Character.toString((char) i);
            } else {
                String str2 = STD_ENTITIES.get(strGroup);
                string = str2 == null ? "&" + strGroup + ';' : str2;
            }
            matcher.appendReplacement(stringBuffer, string);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static Map<String, String> getStandardEntities() {
        HashMap map = new HashMap(10);
        map.put("lt", "<");
        map.put("gt", ">");
        map.put(AMPExtension.ELEMENT, "&");
        map.put("apos", "'");
        map.put("quot", "\"");
        return map;
    }

    public String toString() {
        return this.xml;
    }
}
