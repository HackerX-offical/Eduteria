package com.google.common.html;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes8.dex */
@ElementTypesAreNonnullByDefault
public final class HtmlEscapers {
    private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape('\"', StringUtils.QUOTE_ENCODE).addEscape('\'', "&#39;").addEscape(Typography.amp, StringUtils.AMP_ENCODE).addEscape(Typography.less, StringUtils.LT_ENCODE).addEscape(Typography.greater, StringUtils.GT_ENCODE).build();

    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }

    private HtmlEscapers() {
    }
}
