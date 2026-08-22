package qr_core.client.result;

import qr_core.Result;

/* JADX INFO: loaded from: classes2.dex */
public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
    @Override // qr_core.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        String text = result.getText();
        if (!text.startsWith("MEBKM:")) {
            return null;
        }
        String strMatchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("TITLE:", text, true);
        String[] strArrMatchDoCoMoPrefixedField = matchDoCoMoPrefixedField("URL:", text);
        if (strArrMatchDoCoMoPrefixedField == null) {
            return null;
        }
        String str = strArrMatchDoCoMoPrefixedField[0];
        if (URIResultParser.isBasicallyValidURI(str)) {
            return new URIParsedResult(str, strMatchSingleDoCoMoPrefixedField);
        }
        return null;
    }
}
