package com.x5.template.filters;

import com.x5.template.Chunk;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;

/* JADX INFO: loaded from: classes9.dex */
public class EscapeXMLFilter extends BasicFilter implements ChunkFilter {
    private static final String findMe = "&<>\"'";
    private static final String[] replaceWith = {StringUtils.AMP_ENCODE, StringUtils.LT_ENCODE, StringUtils.GT_ENCODE, StringUtils.QUOTE_ENCODE, StringUtils.APOS_ENCODE};

    @Override // com.x5.template.filters.BasicFilter
    public String transformText(Chunk chunk, String str, FilterArgs filterArgs) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            int iIndexOf = findMe.indexOf(cCharAt);
            if (iIndexOf > -1) {
                sb.append(replaceWith[iIndexOf]);
            } else if (cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r' || (cCharAt >= ' ' && cCharAt < 256)) {
                sb.append(cCharAt);
            } else if (cCharAt > 255 && (cCharAt <= 55295 || ((cCharAt >= 57344 && cCharAt <= 65533) || (cCharAt >= 0 && cCharAt <= 65535)))) {
                sb.append("&#x");
                sb.append(Integer.toHexString(cCharAt));
                sb.append(';');
            }
            z = true;
        }
        return z ? sb.toString() : str;
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String getFilterName() {
        return AbstractHttpOverXmpp.Xml.ELEMENT;
    }

    @Override // com.x5.template.filters.BasicFilter, com.x5.template.filters.ChunkFilter
    public String[] getFilterAliases() {
        return new String[]{"html", "xmlescape", "htmlescape", "escapexml", "escapehtml", "xmlesc", "htmlesc"};
    }
}
