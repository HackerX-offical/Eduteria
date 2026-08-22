package com.microsoft.clarity.e;

import androidx.media3.common.PlaybackException;
import com.microsoft.clarity.d.i;
import com.microsoft.clarity.d.j;
import com.microsoft.clarity.models.display.DisplayFrame;
import com.microsoft.clarity.models.display.blobs.TextBlob;
import com.microsoft.clarity.models.display.blobs.TextBlobRun;
import com.microsoft.clarity.models.display.typefaces.Typeface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Byte> f781c = CollectionsKt.listOf((Object[]) new Byte[]{(byte) 0, (byte) 1, (byte) 0, (byte) 0});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Byte> f782d = CollectionsKt.listOf((Object[]) new Byte[]{(byte) 79, (byte) 84, (byte) 84, (byte) 79});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<Byte> f783e = CollectionsKt.listOf((Object[]) new Byte[]{(byte) 116, (byte) 116, (byte) 99, (byte) 102});

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<IntRange> f784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<Integer> f785g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.microsoft.clarity.d.g f786a = new com.microsoft.clarity.d.g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f787b = new LinkedHashMap();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<Long> f788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Set<Long> f789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set<Long> f790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f791d;

        public a(LinkedHashSet digitGlyphIds, LinkedHashSet spaceGlyphId, LinkedHashSet atSignGlyphId, long j) {
            Intrinsics.checkNotNullParameter(digitGlyphIds, "digitGlyphIds");
            Intrinsics.checkNotNullParameter(spaceGlyphId, "spaceGlyphId");
            Intrinsics.checkNotNullParameter(atSignGlyphId, "atSignGlyphId");
            this.f788a = digitGlyphIds;
            this.f789b = spaceGlyphId;
            this.f790c = atSignGlyphId;
            this.f791d = j;
        }

        public final Set<Long> a() {
            return this.f790c;
        }

        public final Set<Long> b() {
            return this.f788a;
        }

        public final long c() {
            return this.f791d;
        }

        public final Set<Long> d() {
            return this.f789b;
        }
    }

    static {
        List<IntRange> listListOf = CollectionsKt.listOf((Object[]) new IntRange[]{new IntRange(48, 57), new IntRange(1632, 1641), new IntRange(1776, 1785), new IntRange(1984, 1993), new IntRange(2406, 2415), new IntRange(2534, 2543), new IntRange(2662, 2671), new IntRange(2790, 2799), new IntRange(2918, 2927), new IntRange(3046, 3055), new IntRange(3174, 3183), new IntRange(3302, 3311), new IntRange(3430, 3439), new IntRange(3558, 3567), new IntRange(3664, 3673), new IntRange(3792, 3801), new IntRange(3872, 3881), new IntRange(4160, 4169), new IntRange(4240, 4249), new IntRange(6112, 6121), new IntRange(6160, 6169), new IntRange(6470, 6479), new IntRange(6608, 6617), new IntRange(6784, 6793), new IntRange(6800, 6809), new IntRange(6992, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED), new IntRange(7088, 7097), new IntRange(7232, 7241), new IntRange(7248, 7257), new IntRange(42528, 42537), new IntRange(43216, 43225), new IntRange(43264, 43273), new IntRange(43472, 43481), new IntRange(43504, 43513), new IntRange(43600, 43609), new IntRange(44016, 44025), new IntRange(65296, 65305), new IntRange(66720, 66729), new IntRange(68912, 68921), new IntRange(69734, 69743), new IntRange(69872, 69881), new IntRange(69942, 69951), new IntRange(70096, 70105), new IntRange(70384, 70393), new IntRange(70736, 70745), new IntRange(70864, 70873), new IntRange(71248, 71257), new IntRange(71360, 71369), new IntRange(71472, 71481), new IntRange(71904, 71913), new IntRange(72016, 72025), new IntRange(72784, 72793), new IntRange(73040, 73049), new IntRange(73120, 73129), new IntRange(73552, 73561), new IntRange(92768, 92777), new IntRange(92864, 92873), new IntRange(93008, 93017), new IntRange(120782, 120791), new IntRange(120792, 120801), new IntRange(120802, 120811), new IntRange(120812, 120821), new IntRange(120822, 120831), new IntRange(123200, 123209), new IntRange(123632, 123641), new IntRange(124144, 124153), new IntRange(125264, 125273), new IntRange(130032, 130041)});
        f784f = listListOf;
        f785g = CollectionsKt.toSet(CollectionsKt.plus((Collection<? extends int>) CollectionsKt.plus((Collection<? extends int>) CollectionsKt.plus((Collection<? extends int>) CollectionsKt.flatten(listListOf), 32), 64), 8226));
    }

    public static final void a(Set<Long> set, Set<Long> set2, Set<Long> set3, Ref.LongRef longRef, com.microsoft.clarity.d.b bVar) {
        com.microsoft.clarity.d.a[] aVarArrA = bVar.a();
        Intrinsics.checkNotNullExpressionValue(aVarArrA, "cmap.cmaps");
        ArrayList<com.microsoft.clarity.d.a> arrayList = new ArrayList();
        for (com.microsoft.clarity.d.a aVar : aVarArrA) {
            if (aVar.a() == 0 || aVar.a() == 3) {
                arrayList.add(aVar);
            }
        }
        for (com.microsoft.clarity.d.a aVar2 : arrayList) {
            for (IntRange intRange : f784f) {
                int first = intRange.getFirst();
                int last = intRange.getLast();
                if (first <= last) {
                    while (true) {
                        set.add(Long.valueOf(aVar2.a(first)));
                        if (first != last) {
                            first++;
                        }
                    }
                }
            }
            set2.add(Long.valueOf(aVar2.a(32)));
            set3.add(Long.valueOf(aVar2.a(64)));
            if (longRef.element == 0) {
                longRef.element = aVar2.a(8226);
            }
        }
    }

    public static final void a(Set digitGlyphIds, Set spaceGlyphIds, Set atSignGlyphIds, Ref.LongRef piiPlaceholderGlyphId, j jVar) {
        Intrinsics.checkNotNullParameter(digitGlyphIds, "$digitGlyphIds");
        Intrinsics.checkNotNullParameter(spaceGlyphIds, "$spaceGlyphIds");
        Intrinsics.checkNotNullParameter(atSignGlyphIds, "$atSignGlyphIds");
        Intrinsics.checkNotNullParameter(piiPlaceholderGlyphId, "$piiPlaceholderGlyphId");
        com.microsoft.clarity.d.b bVarA = jVar.a();
        Intrinsics.checkNotNullExpressionValue(bVarA, "it.cmap");
        a((Set<Long>) digitGlyphIds, (Set<Long>) spaceGlyphIds, (Set<Long>) atSignGlyphIds, piiPlaceholderGlyphId, bVarA);
    }

    public static boolean a(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!Intrinsics.areEqual(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final a a(Typeface typeface) {
        int i;
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        final LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        final LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        final Ref.LongRef longRef = new Ref.LongRef();
        byte[] data = typeface.getData();
        Intrinsics.checkNotNullExpressionValue(data, "typeface.data");
        List<Byte> listTake = ArraysKt.take(data, 4);
        if (a(listTake, f781c)) {
            i = 1;
        } else if (a(listTake, f782d)) {
            i = 2;
        } else {
            if (!a(listTake, f783e)) {
                StringBuilder sbA = com.microsoft.clarity.a.b.a("Cannot parse this typeface file with header ");
                String string = Arrays.toString(CollectionsKt.toByteArray(listTake));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this)");
                throw new UnsupportedOperationException(sbA.append(string).append('!').toString());
            }
            i = 3;
        }
        int iA = g.a(i);
        if (iA == 0 || iA == 1) {
            com.microsoft.clarity.d.g gVar = this.f786a;
            byte[] data2 = typeface.getData();
            Set<Integer> set = f785g;
            gVar.getClass();
            com.microsoft.clarity.d.b bVarA = com.microsoft.clarity.d.g.a(data2, set).a();
            Intrinsics.checkNotNullExpressionValue(bVarA, "ttfParser.parse(typeface…edCharacterUnicodes).cmap");
            a(linkedHashSet, linkedHashSet2, linkedHashSet3, longRef, bVarA);
        } else if (iA == 2) {
            new com.microsoft.clarity.d.i(typeface.getData(), f785g).a(new i.a() { // from class: com.microsoft.clarity.e.f$$ExternalSyntheticLambda0
                @Override // com.microsoft.clarity.d.i.a
                public final void a(j jVar) {
                    f.a(linkedHashSet, linkedHashSet2, linkedHashSet3, longRef, jVar);
                }
            });
        }
        linkedHashSet.remove(0L);
        return new a(linkedHashSet, linkedHashSet2, linkedHashSet3, longRef.element);
    }

    public static final void a(f fVar, TextBlobRun textBlobRun, a aVar, int i, int i2) {
        fVar.getClass();
        IntProgression intProgressionFromClosedRange = IntProgression.INSTANCE.fromClosedRange(i, i2, i > i2 ? -1 : 1);
        int first = intProgressionFromClosedRange.getFirst();
        int last = intProgressionFromClosedRange.getLast();
        int step = intProgressionFromClosedRange.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return;
        }
        while (true) {
            if (first >= 0) {
                List<Long> glyphs = textBlobRun.getGlyphs();
                Intrinsics.checkNotNull(glyphs);
                if (first < glyphs.size()) {
                    List<Long> glyphs2 = textBlobRun.getGlyphs();
                    Intrinsics.checkNotNull(glyphs2);
                    if (aVar.d().contains(Long.valueOf(glyphs2.get(first).longValue()))) {
                        return;
                    }
                    List<Long> glyphs3 = textBlobRun.getGlyphs();
                    Intrinsics.checkNotNull(glyphs3);
                    glyphs3.set(first, Long.valueOf(aVar.c()));
                }
            }
            if (first == last) {
                return;
            } else {
                first += step;
            }
        }
    }

    public final void a(int i, DisplayFrame frame) {
        long j;
        Intrinsics.checkNotNullParameter(frame, "frame");
        TextBlob textBlob = frame.getTextBlobs().get(i);
        if (textBlob.getSanitized() || textBlob.getRuns() == null) {
            return;
        }
        List<TextBlobRun> runs = textBlob.getRuns();
        Intrinsics.checkNotNull(runs);
        for (TextBlobRun textBlobRun : runs) {
            if (textBlobRun.getGlyphs() != null) {
                Integer typefaceIndex = textBlobRun.getTypefaceIndex();
                int i2 = 0;
                if (typefaceIndex != null && CollectionsKt.getIndices(frame.getTypefaces()).contains(typefaceIndex.intValue())) {
                    Typeface typeface = frame.getTypefaces().get(typefaceIndex.intValue());
                    try {
                        String dataHash = typeface.getDataHash();
                        Intrinsics.checkNotNull(dataHash);
                        if (!this.f787b.containsKey(dataHash)) {
                            this.f787b.put(dataHash, a(typeface));
                        }
                        Object obj = this.f787b.get(dataHash);
                        Intrinsics.checkNotNull(obj);
                        a aVar = (a) obj;
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        List<Long> glyphs = textBlobRun.getGlyphs();
                        Intrinsics.checkNotNull(glyphs);
                        Iterator<Long> it = glyphs.iterator();
                        int i3 = 0;
                        while (it.hasNext()) {
                            int i4 = i3 + 1;
                            long jLongValue = it.next().longValue();
                            j = 0;
                            try {
                                if (aVar.b().contains(Long.valueOf(jLongValue))) {
                                    List<Long> glyphs2 = textBlobRun.getGlyphs();
                                    Intrinsics.checkNotNull(glyphs2);
                                    glyphs2.set(i3, Long.valueOf(aVar.c()));
                                } else if (aVar.a().contains(Long.valueOf(jLongValue))) {
                                    linkedHashSet.add(Integer.valueOf(i3));
                                }
                                i3 = i4;
                            } catch (Exception e2) {
                                e = e2;
                                List<Long> glyphs3 = textBlobRun.getGlyphs();
                                Intrinsics.checkNotNull(glyphs3);
                                int size = glyphs3.size();
                                while (i2 < size) {
                                    List<Long> glyphs4 = textBlobRun.getGlyphs();
                                    Intrinsics.checkNotNull(glyphs4);
                                    glyphs4.set(i2, Long.valueOf(j));
                                    i2++;
                                }
                                com.microsoft.clarity.n.i.c(com.microsoft.clarity.a.b.a("Sanitizing blob run failed (typeface: '").append(typeface.getFamilyName()).append("'). Error: '").append(e).append("'.").toString());
                            }
                        }
                        Iterator it2 = linkedHashSet.iterator();
                        while (it2.hasNext()) {
                            int iIntValue = ((Number) it2.next()).intValue();
                            a(this, textBlobRun, aVar, iIntValue, 0);
                            List<Long> glyphs5 = textBlobRun.getGlyphs();
                            Intrinsics.checkNotNull(glyphs5);
                            a(this, textBlobRun, aVar, iIntValue + 1, glyphs5.size() - 1);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        j = 0;
                    }
                } else {
                    List<Long> glyphs6 = textBlobRun.getGlyphs();
                    Intrinsics.checkNotNull(glyphs6);
                    int size2 = glyphs6.size();
                    while (i2 < size2) {
                        List<Long> glyphs7 = textBlobRun.getGlyphs();
                        Intrinsics.checkNotNull(glyphs7);
                        glyphs7.set(i2, 0L);
                        i2++;
                    }
                    com.microsoft.clarity.n.i.c("Typeface is missing (typefaceIdx: '" + typefaceIndex + "').");
                }
            }
        }
        textBlob.setSanitized(true);
    }
}
