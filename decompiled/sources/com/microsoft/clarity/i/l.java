package com.microsoft.clarity.i;

import com.microsoft.clarity.models.display.commands.DisplayCommand;
import com.microsoft.clarity.models.display.commands.DrawVertices;
import com.microsoft.clarity.models.display.common.IRect;
import com.microsoft.clarity.models.display.images.Lattice;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes9.dex */
public abstract class l implements b<DisplayCommand> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f1030a = CollectionsKt.arrayListOf("UNUSED", "CLIP_PATH", "CLIP_REGION", "CLIP_RECT", "CLIP_RRECT", "CONCAT", "DRAW_BITMAP_RETIRED_2016_REMOVED_2018", "DRAW_BITMAP_MATRIX_RETIRED_2016_REMOVED_2018", "DRAW_BITMAP_NINE_RETIRED_2016_REMOVED_2018", "DRAW_BITMAP_RECT_RETIRED_2016_REMOVED_2018", "DRAW_CLEAR", "DRAW_DATA", "DRAW_OVAL", "DRAW_PAINT", "DRAW_PATH", "DRAW_PICTURE", "DRAW_POINTS", "DRAW_POS_TEXT_REMOVED_1_2019", "DRAW_POS_TEXT_TOP_BOTTOM_REMOVED_1_2019", "DRAW_POS_TEXT_H_REMOVED_1_2019", "DRAW_POS_TEXT_H_TOP_BOTTOM_REMOVED_1_2019", "DRAW_RECT", "DRAW_RRECT", "DRAW_SPRITE_RETIRED_2015_REMOVED_2018", "DRAW_TEXT_REMOVED_1_2019", "DRAW_TEXT_ON_PATH_RETIRED_08_2018_REMOVED_10_2018", "DRAW_TEXT_TOP_BOTTOM_REMOVED_1_2019", "DRAW_VERTICES_RETIRED_03_2017_REMOVED_01_2018", "RESTORE", "ROTATE", "SAVE", "SAVE_LAYER_SAVEFLAGS_DEPRECATED_2015_REMOVED_12_2020", "SCALE", "SET_MATRIX", "SKEW", "TRANSLATE", "NOOP", "BEGIN_COMMENT_GROUP_obsolete", "COMMENT_obsolete", "END_COMMENT_GROUP_obsolete", "DRAW_DRRECT", "PUSH_CULL", "POP_CULL", "DRAW_PATCH", "DRAW_PICTURE_MATRIX_PAINT", "DRAW_TEXT_BLOB", "DRAW_IMAGE", "DRAW_IMAGE_RECT_STRICT_obsolete", "DRAW_ATLAS", "DRAW_IMAGE_NINE", "DRAW_IMAGE_RECT", "SAVE_LAYER_SAVELAYERFLAGS_DEPRECATED_JAN_2016_REMOVED_01_2018", "SAVE_LAYER_SAVELAYERREC", "DRAW_ANNOTATION", "DRAW_DRAWABLE", "DRAW_DRAWABLE_MATRIX", "DRAW_TEXT_RSXFORM_DEPRECATED_DEC_2018", "TRANSLATE_Z", "DRAW_SHADOW_REC", "DRAW_IMAGE_LATTICE", "DRAW_ARC", "DRAW_REGION", "DRAW_VERTICES_OBJECT", "FLUSH", "DRAW_EDGEAA_IMAGE_SET", "SAVE_BEHIND", "DRAW_EDGEAA_QUAD", "DRAW_BEHIND_PAINT", "CONCAT44", "CLIP_SHADER_IN_PAINT", "MARK_CTM", "SET_M44", "DRAW_IMAGE2", "DRAW_IMAGE_RECT2", "DRAW_IMAGE_LATTICE2", "DRAW_EDGEAA_IMAGE_SET2");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f1031b = new Regex("id=([0-9]+),");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f1032c = new Regex("name='([^']+)'");

    public static ArrayList d(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            arrayList.add(Float.valueOf(buffer.f()));
        }
        return arrayList;
    }

    public static Lattice f(g gVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int iG = gVar.g();
        for (int i = 0; i < iG; i++) {
            arrayList.add(Integer.valueOf(gVar.g()));
        }
        int iG2 = gVar.g();
        for (int i2 = 0; i2 < iG2; i2++) {
            arrayList2.add(Integer.valueOf(gVar.g()));
        }
        int iG3 = gVar.g();
        int iA = f.a(UInt.m12488constructorimpl(iG3));
        for (int i3 = 0; i3 < iG3; i3++) {
            arrayList3.add(Integer.valueOf(gVar.e()));
        }
        gVar.d(iA - iG3);
        for (int i4 = 0; i4 < iG3; i4++) {
            arrayList4.add(UInt.m12482boximpl(gVar.i()));
        }
        IRect iRectL = gVar.l();
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            arrayList5.add(Long.valueOf(((long) ((UInt) it.next()).getData()) & 4294967295L));
        }
        return new Lattice(arrayList, arrayList2, arrayList3, iRectL, arrayList5);
    }

    public final ArrayList b(g buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ArrayList arrayList = new ArrayList();
        while (buffer.a()) {
            DisplayCommand displayCommandA = a(buffer);
            if (displayCommandA != null) {
                arrayList.add(displayCommandA);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:225:0x04db  */
    @Override // com.microsoft.clarity.i.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.microsoft.clarity.models.display.commands.DisplayCommand a(com.microsoft.clarity.i.g r17) {
        /*
            Method dump skipped, instruction units count: 1438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.clarity.i.l.a(com.microsoft.clarity.i.g):com.microsoft.clarity.models.display.commands.DisplayCommand");
    }

    public abstract DrawVertices e(g gVar);
}
