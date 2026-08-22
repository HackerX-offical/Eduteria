package org.jivesoftware.smackx.delay.provider;

import java.util.Date;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.ParserUtils;

/* JADX INFO: loaded from: classes10.dex */
public class DelayInformationProvider extends AbstractDelayInformationProvider {
    public static final DelayInformationProvider INSTANCE = new DelayInformationProvider();

    @Override // org.jivesoftware.smackx.delay.provider.AbstractDelayInformationProvider
    protected Date parseDate(String str) throws SmackParsingException.SmackTextParseException {
        return ParserUtils.getDateFromXep82String(str);
    }
}
