package org.jivesoftware.smackx.delay.provider;

import java.util.Date;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;

/* JADX INFO: loaded from: classes10.dex */
public class LegacyDelayInformationProvider extends AbstractDelayInformationProvider {
    @Override // org.jivesoftware.smackx.delay.provider.AbstractDelayInformationProvider
    protected Date parseDate(String str) throws SmackParsingException.SmackTextParseException {
        return ParserUtils.getDateFromString(str);
    }
}
