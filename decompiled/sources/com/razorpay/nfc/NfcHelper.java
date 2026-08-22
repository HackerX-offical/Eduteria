package com.razorpay.nfc;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.util.Log;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.common.base.Ascii;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smackx.jingle_filetransfer.element.Range;

/* JADX INFO: compiled from: NfcHelper.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J$\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00180\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u001a\u001a\u0004\u0018\u00010\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0004J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J&\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00182\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000eH\u0002J,\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010%2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u001e2\b\u0010\n\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\n\u0010+\u001a\u00020\u0004*\u00020\u000bJ\n\u0010,\u001a\u00020\u000b*\u00020\u0004¨\u0006."}, d2 = {"Lcom/razorpay/nfc/NfcHelper;", "", "()V", "buildPdolData", "", "pdolTemplate", "amexAlt", "", "containsTag", "tlv", "tag", "", "currentDateYYMMDD", "expectedLen", "", "currentTimeHHMMSS", "extractAfl", "tlvs", "", "Lcom/razorpay/nfc/NfcHelper$Tlv;", "extractAidFromPpse", SaslNonza.Response.ELEMENT, "extractPdolFromSelectResponse", "extractRecordsFromAfl", "Lkotlin/Pair;", DynamicLink.AndroidParameters.KEY_ANDROID_FALLBACK_LINK, "findFirstTagValue", "is6985", "isSuccess", "parseTlv", "Lcom/razorpay/nfc/CardData;", "data", "parseTlvList", "readLength", "bytes", "offset", "readTag", "Lkotlin/Triple;", "splitTrack2", "track2", "startCardScanner", "Landroid/nfc/Tag;", "stripStatusWord", "hexToByteArray", "toHexString", "Tlv", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NfcHelper {

    /* JADX INFO: compiled from: NfcHelper.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/razorpay/nfc/NfcHelper$Tlv;", "", "tag", "", Range.ATTR_LENGTH, "", "value", "", "constructed", "", "(Ljava/lang/String;I[BZ)V", "getConstructed", "()Z", "getLength", "()I", "getTag", "()Ljava/lang/String;", "getValue", "()[B", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final /* data */ class Tlv {
        private final boolean constructed;
        private final int length;
        private final String tag;
        private final byte[] value;

        public static /* synthetic */ Tlv copy$default(Tlv tlv, String str, int i, byte[] bArr, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = tlv.tag;
            }
            if ((i2 & 2) != 0) {
                i = tlv.length;
            }
            if ((i2 & 4) != 0) {
                bArr = tlv.value;
            }
            if ((i2 & 8) != 0) {
                z = tlv.constructed;
            }
            return tlv.copy(str, i, bArr, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getLength() {
            return this.length;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final byte[] getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getConstructed() {
            return this.constructed;
        }

        public final Tlv copy(String tag, int length, byte[] value, boolean constructed) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(value, "value");
            return new Tlv(tag, length, value, constructed);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tlv)) {
                return false;
            }
            Tlv tlv = (Tlv) other;
            return Intrinsics.areEqual(this.tag, tlv.tag) && this.length == tlv.length && Intrinsics.areEqual(this.value, tlv.value) && this.constructed == tlv.constructed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            int iHashCode = ((((this.tag.hashCode() * 31) + Integer.hashCode(this.length)) * 31) + Arrays.hashCode(this.value)) * 31;
            boolean z = this.constructed;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final String toString() {
            return "Tlv(tag=" + this.tag + ", length=" + this.length + ", value=" + Arrays.toString(this.value) + ", constructed=" + this.constructed + ')';
        }

        public Tlv(String tag, int i, byte[] value, boolean z) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(value, "value");
            this.tag = tag;
            this.length = i;
            this.value = value;
            this.constructed = z;
        }

        public final boolean getConstructed() {
            return this.constructed;
        }

        public final int getLength() {
            return this.length;
        }

        public final String getTag() {
            return this.tag;
        }

        public final byte[] getValue() {
            return this.value;
        }
    }

    public final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.razorpay.nfc.NfcHelper.toHexString.1
            public final CharSequence invoke(byte b2) {
                String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                return str;
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ CharSequence invoke(Byte b2) {
                return invoke(b2.byteValue());
            }
        }, 30, (Object) null);
    }

    private final boolean containsTag(byte[] tlv, String tag) {
        Triple<String, Integer, Boolean> tag2;
        int iIntValue = 0;
        while (iIntValue < tlv.length && (tag2 = readTag(tlv, iIntValue)) != null) {
            String strComponent1 = tag2.component1();
            int iIntValue2 = tag2.component2().intValue();
            if (StringsKt.equals(strComponent1, tag, true)) {
                return true;
            }
            Pair<Integer, Integer> length = readLength(tlv, iIntValue + iIntValue2);
            if (length == null) {
                return false;
            }
            iIntValue += iIntValue2 + length.component2().intValue();
        }
        return false;
    }

    public final byte[] hexToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        List<String> listChunked = StringsKt.chunked(str, 2);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listChunked, 10));
        Iterator<T> it = listChunked.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) Integer.parseInt((String) it.next(), CharsKt.checkRadix(16))));
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    public final CardData startCardScanner(Tag tag) throws IOException {
        byte[] next;
        byte[] selectResp;
        IsoDep isoDep = IsoDep.get(tag);
        if (isoDep == null) {
            return null;
        }
        try {
            try {
                isoDep.connect();
                isoDep.setTimeout(5000);
                byte[] ppseResponse = isoDep.transceive(EmvCommands.INSTANCE.getSELECT_PPSE());
                Intrinsics.checkNotNullExpressionValue(ppseResponse, "ppseResponse");
                byte[] bArrExtractAidFromPpse = extractAidFromPpse(ppseResponse);
                Iterator<byte[]> it = (bArrExtractAidFromPpse != null ? CollectionsKt.listOf(bArrExtractAidFromPpse) : EmvCommands.INSTANCE.getKNOWN_AIDS()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        selectResp = null;
                        break;
                    }
                    next = it.next();
                    selectResp = isoDep.transceive(EmvCommands.INSTANCE.selectAid(next));
                    Intrinsics.checkNotNullExpressionValue(selectResp, "selectResp");
                    if (isSuccess(selectResp)) {
                        break;
                    }
                }
                if (next == null) {
                    return null;
                }
                byte[] bArrExtractPdolFromSelectResponse = selectResp != null ? extractPdolFromSelectResponse(selectResp) : null;
                byte[] gpoResp = isoDep.transceive(EmvCommands.INSTANCE.getProcessingOptions(buildPdolData(bArrExtractPdolFromSelectResponse, false)));
                if (bArrExtractPdolFromSelectResponse != null ? containsTag(bArrExtractPdolFromSelectResponse, "9F6E") : false) {
                    Intrinsics.checkNotNullExpressionValue(gpoResp, "gpoResp");
                    if (is6985(gpoResp)) {
                        gpoResp = isoDep.transceive(EmvCommands.INSTANCE.getProcessingOptions(buildPdolData(bArrExtractPdolFromSelectResponse, true)));
                    }
                }
                Intrinsics.checkNotNullExpressionValue(gpoResp, "gpoResp");
                ArrayList arrayListExtractRecordsFromAfl = extractRecordsFromAfl(extractAfl(parseTlvList(gpoResp)));
                if (arrayListExtractRecordsFromAfl.isEmpty()) {
                    IntRange intRange = new IntRange(1, 3);
                    ArrayList arrayList = new ArrayList();
                    Iterator<Integer> it2 = intRange.iterator();
                    while (it2.hasNext()) {
                        int iNextInt = ((IntIterator) it2).nextInt();
                        IntRange intRange2 = new IntRange(1, 3);
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
                        Iterator<Integer> it3 = intRange2.iterator();
                        while (it3.hasNext()) {
                            arrayList2.add(TuplesKt.to(Integer.valueOf(iNextInt), Integer.valueOf(((IntIterator) it3).nextInt())));
                        }
                        CollectionsKt.addAll(arrayList, arrayList2);
                    }
                    arrayListExtractRecordsFromAfl = arrayList;
                }
                for (Pair<Integer, Integer> pair : arrayListExtractRecordsFromAfl) {
                    byte[] response = isoDep.transceive(EmvCommands.INSTANCE.readRecord(pair.component2().intValue(), pair.component1().intValue()));
                    if (response.length > 2 && response[response.length - 2] == -112) {
                        Intrinsics.checkNotNullExpressionValue(response, "response");
                        CardData tlv = parseTlv(response);
                        if (tlv != null) {
                            return tlv;
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e("NfcSdk", "Error reading card", e2);
            }
            return null;
        } finally {
            isoDep.close();
        }
    }

    public final CardData parseTlv(byte[] data) {
        String hexString;
        Intrinsics.checkNotNullParameter(data, "data");
        List<Tlv> tlvList = parseTlvList(data);
        byte[] bArrFindFirstTagValue = findFirstTagValue(tlvList, "57");
        if (bArrFindFirstTagValue != null) {
            return splitTrack2(toHexString(bArrFindFirstTagValue));
        }
        byte[] bArrFindFirstTagValue2 = findFirstTagValue(tlvList, "5A");
        String strSubstring = null;
        if (bArrFindFirstTagValue2 == null) {
            return null;
        }
        byte[] bArrFindFirstTagValue3 = findFirstTagValue(tlvList, "5F24");
        if (bArrFindFirstTagValue3 != null && (hexString = toHexString(bArrFindFirstTagValue3)) != null) {
            if (hexString.length() < 4) {
                hexString = null;
            }
            if (hexString != null) {
                strSubstring = hexString.substring(0, 4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
        }
        return new CardData(StringsKt.trimEnd(toHexString(bArrFindFirstTagValue2), 'F'), strSubstring);
    }

    private final CardData splitTrack2(String track2) {
        String strSubstring;
        List listSplit$default = StringsKt.split$default((CharSequence) track2, new String[]{"D"}, false, 0, 6, (Object) null);
        String strTrimEnd = StringsKt.trimEnd((String) listSplit$default.get(0), 'F');
        if (listSplit$default.size() <= 1 || ((String) listSplit$default.get(1)).length() < 4) {
            strSubstring = null;
        } else {
            strSubstring = ((String) listSplit$default.get(1)).substring(0, 4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        return new CardData(strTrimEnd, strSubstring);
    }

    private final byte[] findFirstTagValue(List<Tlv> tlvs, String tag) {
        Object next;
        Iterator<T> it = tlvs.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (StringsKt.equals(((Tlv) next).getTag(), tag, true)) {
                break;
            }
        }
        Tlv tlv = (Tlv) next;
        if (tlv != null) {
            return tlv.getValue();
        }
        return null;
    }

    private final List<Tlv> parseTlvList(byte[] data) {
        ArrayList arrayList = new ArrayList();
        parseTlvList$walk(this, arrayList, stripStatusWord(data));
        return arrayList;
    }

    private static final void parseTlvList$walk(NfcHelper nfcHelper, List<Tlv> list, byte[] bArr) {
        Triple<String, Integer, Boolean> tag;
        int i = 0;
        while (i < bArr.length && (tag = nfcHelper.readTag(bArr, i)) != null) {
            String strComponent1 = tag.component1();
            int iIntValue = tag.component2().intValue();
            boolean zBooleanValue = tag.component3().booleanValue();
            int i2 = i + iIntValue;
            Pair<Integer, Integer> length = nfcHelper.readLength(bArr, i2);
            if (length == null) {
                return;
            }
            int iIntValue2 = length.component1().intValue();
            int iIntValue3 = i2 + length.component2().intValue();
            int i3 = iIntValue3 + iIntValue2;
            if (iIntValue2 < 0 || i3 > bArr.length) {
                return;
            }
            byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArr, iIntValue3, i3);
            list.add(new Tlv(strComponent1, iIntValue2, bArrCopyOfRange, zBooleanValue));
            if (zBooleanValue) {
                parseTlvList$walk(nfcHelper, list, bArrCopyOfRange);
            }
            i = i3;
        }
    }

    private final byte[] extractPdolFromSelectResponse(byte[] response) {
        return findFirstTagValue(parseTlvList(response), "9F38");
    }

    private final Triple<String, Integer, Boolean> readTag(byte[] bytes, int offset) {
        if (offset >= bytes.length) {
            return null;
        }
        byte b2 = bytes[offset];
        int i = 1;
        boolean z = (b2 & 32) == 32;
        byte[] bArrPlus = {b2};
        if ((b2 & Ascii.US) == 31) {
            int i2 = offset + 1;
            while (i2 < bytes.length) {
                bArrPlus = ArraysKt.plus(bArrPlus, bytes[i2]);
                i++;
                byte b3 = bytes[i2];
                i2++;
                if ((b3 & 128) == 0) {
                    break;
                }
            }
        }
        return new Triple<>(toHexString(bArrPlus), Integer.valueOf(i), Boolean.valueOf(z));
    }

    private final Pair<Integer, Integer> readLength(byte[] bytes, int offset) {
        if (offset >= bytes.length) {
            return null;
        }
        int i = bytes[offset];
        int i2 = i & 255;
        if ((i & 128) == 0) {
            return TuplesKt.to(Integer.valueOf(i2), 1);
        }
        int i3 = i & 127;
        if (offset + i3 >= bytes.length) {
            return null;
        }
        int i4 = 0;
        if (i3 > 0) {
            int i5 = 1;
            while (true) {
                i4 = (i4 << 8) | (bytes[offset + i5] & 255);
                if (i5 == i3) {
                    break;
                }
                i5++;
            }
        }
        return TuplesKt.to(Integer.valueOf(i4), Integer.valueOf(i3 + 1));
    }

    private final byte[] stripStatusWord(byte[] data) {
        return (data.length >= 2 && data[data.length - 2] == -112 && data[data.length + (-1)] == 0) ? ArraysKt.copyOfRange(data, 0, data.length - 2) : data;
    }

    private final boolean isSuccess(byte[] response) {
        return response.length >= 2 && response[response.length - 2] == -112 && response[response.length - 1] == 0;
    }

    private final boolean is6985(byte[] response) {
        return response.length >= 2 && response[response.length - 2] == 105 && response[response.length - 1] == -123;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0217  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final byte[] buildPdolData(byte[] r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 672
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.nfc.NfcHelper.buildPdolData(byte[], boolean):byte[]");
    }

    private final byte[] currentTimeHHMMSS(int expectedLen) {
        try {
            String str = new SimpleDateFormat("HHmmss", Locale.US).format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "sdf.format(Date())");
            List<String> listChunked = StringsKt.chunked(str, 2);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listChunked, 10));
            Iterator<T> it = listChunked.iterator();
            while (it.hasNext()) {
                arrayList.add(Byte.valueOf((byte) Integer.parseInt((String) it.next(), CharsKt.checkRadix(16))));
            }
            byte[] byteArray = CollectionsKt.toByteArray(arrayList);
            if (byteArray.length >= expectedLen) {
                return CollectionsKt.toByteArray(ArraysKt.take(byteArray, expectedLen));
            }
            int length = expectedLen - byteArray.length;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = 0;
            }
            return ArraysKt.plus(byteArray, bArr);
        } catch (Exception unused) {
            byte[] bArr2 = new byte[expectedLen];
            for (int i2 = 0; i2 < expectedLen; i2++) {
                bArr2[i2] = 0;
            }
            return bArr2;
        }
    }

    private final byte[] currentDateYYMMDD(int expectedLen) {
        try {
            String str = new SimpleDateFormat("yyMMdd", Locale.US).format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "sdf.format(Date())");
            List<String> listChunked = StringsKt.chunked(str, 2);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listChunked, 10));
            Iterator<T> it = listChunked.iterator();
            while (it.hasNext()) {
                arrayList.add(Byte.valueOf((byte) Integer.parseInt((String) it.next(), CharsKt.checkRadix(16))));
            }
            byte[] byteArray = CollectionsKt.toByteArray(arrayList);
            if (byteArray.length >= expectedLen) {
                return CollectionsKt.toByteArray(ArraysKt.take(byteArray, expectedLen));
            }
            int length = expectedLen - byteArray.length;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = 0;
            }
            return ArraysKt.plus(byteArray, bArr);
        } catch (Exception unused) {
            byte[] bArr2 = new byte[expectedLen];
            for (int i2 = 0; i2 < expectedLen; i2++) {
                bArr2[i2] = 0;
            }
            return bArr2;
        }
    }

    private final List<Pair<Integer, Integer>> extractRecordsFromAfl(byte[] afl) {
        if (afl == null || afl.length % 4 != 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < afl.length; i += 4) {
            int i2 = (afl[i] & 255) >> 3;
            int i3 = afl[i + 1] & 255;
            int i4 = afl[i + 2] & 255;
            if (i2 > 0 && i4 >= i3 && i4 <= 16 && i3 <= i4) {
                while (true) {
                    arrayList.add(TuplesKt.to(Integer.valueOf(i2), Integer.valueOf(i3)));
                    if (i3 != i4) {
                        i3++;
                    }
                }
            }
        }
        return arrayList;
    }

    private final byte[] extractAfl(List<Tlv> tlvs) {
        byte[] bArrFindFirstTagValue = findFirstTagValue(tlvs, "94");
        if (bArrFindFirstTagValue != null) {
            return bArrFindFirstTagValue;
        }
        byte[] bArrFindFirstTagValue2 = findFirstTagValue(tlvs, "80");
        if (bArrFindFirstTagValue2 == null || bArrFindFirstTagValue2.length <= 2) {
            return null;
        }
        return ArraysKt.copyOfRange(bArrFindFirstTagValue2, 2, bArrFindFirstTagValue2.length);
    }

    public final byte[] extractAidFromPpse(byte[] response) {
        Intrinsics.checkNotNullParameter(response, "response");
        byte[] bArrFindFirstTagValue = findFirstTagValue(parseTlvList(response), "4F");
        if (bArrFindFirstTagValue == null) {
            return null;
        }
        return bArrFindFirstTagValue;
    }
}
