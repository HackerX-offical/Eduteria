package org.jxmpp.stringprep.simple;

import java.util.Arrays;
import java.util.Locale;
import kotlin.text.Typography;
import org.jxmpp.JxmppContext;
import org.jxmpp.XmppAddressParttype;
import org.jxmpp.stringprep.XmppStringprep;
import org.jxmpp.stringprep.XmppStringprepException;
import org.jxmpp.util.ArraysUtil;

/* JADX INFO: loaded from: classes10.dex */
public final class SimpleXmppStringprep implements XmppStringprep {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char[] LOCALPART_EXCLUDED_CHARACTERS;
    private static final char[] LOCALPART_FURTHER_EXCLUDED_CHARACTERS;
    public static final String NAME = "simple";
    private static final char[] USERNAME_CASE_MAPPED_EXCLUDED_CHARACTERS;
    private static SimpleXmppStringprep instance;

    @Override // org.jxmpp.stringprep.XmppStringprep
    public String resourceprep(String str) throws XmppStringprepException {
        return str;
    }

    public static void setup() {
        JxmppContext.setDefaultXmppStringprep(getInstance());
    }

    public static SimpleXmppStringprep getInstance() {
        if (instance == null) {
            instance = new SimpleXmppStringprep();
        }
        return instance;
    }

    private SimpleXmppStringprep() {
    }

    static {
        char[] cArr = {'\"', Typography.amp, '\'', '/', ':', Typography.less, Typography.greater, '@'};
        LOCALPART_FURTHER_EXCLUDED_CHARACTERS = cArr;
        char[] cArr2 = {' '};
        USERNAME_CASE_MAPPED_EXCLUDED_CHARACTERS = cArr2;
        Arrays.sort(cArr);
        char[] cArr3 = (char[]) ArraysUtil.concatenate(cArr, cArr2);
        LOCALPART_EXCLUDED_CHARACTERS = cArr3;
        Arrays.sort(cArr3);
    }

    @Override // org.jxmpp.stringprep.XmppStringprep
    public String localprep(String str) throws XmppStringprepException {
        String strSimpleStringprep = simpleStringprep(str);
        ensurePartDoesNotContain(XmppAddressParttype.localpart, strSimpleStringprep, LOCALPART_EXCLUDED_CHARACTERS);
        return strSimpleStringprep;
    }

    private static void ensurePartDoesNotContain(XmppAddressParttype xmppAddressParttype, String str, char[] cArr) throws XmppStringprepException {
        for (char c2 : str.toCharArray()) {
            int iBinarySearch = Arrays.binarySearch(cArr, c2);
            if (iBinarySearch >= 0) {
                throw new XmppStringprepException(str, xmppAddressParttype.getCapitalizedName() + " must not contain '" + cArr[iBinarySearch] + "'");
            }
        }
    }

    public static void ensureLocalpartDoesNotIncludeFurtherExcludedCharacters(String str) throws XmppStringprepException {
        ensurePartDoesNotContain(XmppAddressParttype.localpart, str, LOCALPART_FURTHER_EXCLUDED_CHARACTERS);
    }

    @Override // org.jxmpp.stringprep.XmppStringprep
    public String domainprep(String str) throws XmppStringprepException {
        return simpleStringprep(str);
    }

    private static String simpleStringprep(String str) {
        return str.toLowerCase(Locale.US);
    }

    private static boolean isSorted(char[] cArr) {
        for (int i = 1; i < cArr.length; i++) {
            if (cArr[i - 1] > cArr[i]) {
                return false;
            }
        }
        return true;
    }
}
