package com.microsoft.clarity.models.display.typefaces;

import com.microsoft.clarity.models.AssetType;
import com.microsoft.clarity.models.IProtoModel;
import com.microsoft.clarity.models.display.common.Asset;
import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$Typeface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0016\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u0089\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0018J\b\u0010+\u001a\u00020\u0003H\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b&\u0010\"R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b)\u0010\"R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010#\u001a\u0004\b*\u0010\"¨\u0006,"}, d2 = {"Lcom/microsoft/clarity/models/display/typefaces/Typeface;", "Lcom/microsoft/clarity/models/display/common/Asset;", "Lcom/microsoft/clarity/models/IProtoModel;", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$Typeface;", "familyName", "", "fullName", "postscriptName", "style", "Lcom/microsoft/clarity/models/display/typefaces/FontStyle;", "collectionIndex", "", "weightValue", "", "widthValue", "slantValue", "italicValue", "paletteIndex", "coordinates", "", "Lcom/microsoft/clarity/models/display/typefaces/FontCoordinate;", "data", "", "dataHash", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/clarity/models/display/typefaces/FontStyle;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;Ljava/util/List;[BLjava/lang/String;)V", "getCollectionIndex", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCoordinates", "()Ljava/util/List;", "getFamilyName", "()Ljava/lang/String;", "getFullName", "getItalicValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPaletteIndex", "getPostscriptName", "getSlantValue", "getStyle", "()Lcom/microsoft/clarity/models/display/typefaces/FontStyle;", "getWeightValue", "getWidthValue", "toProtobufInstance", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Typeface extends Asset implements IProtoModel<MutationPayload$Typeface> {
    private final Long collectionIndex;
    private final List<FontCoordinate> coordinates;
    private final String familyName;
    private final String fullName;
    private final Float italicValue;
    private final Long paletteIndex;
    private final String postscriptName;
    private final Float slantValue;
    private final FontStyle style;
    private final Float weightValue;
    private final Float widthValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Typeface(String familyName, String str, String str2, FontStyle style, Long l, Float f2, Float f3, Float f4, Float f5, Long l2, List<FontCoordinate> list, byte[] data, String str3) {
        super(AssetType.Typeface, data, str3);
        Intrinsics.checkNotNullParameter(familyName, "familyName");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(data, "data");
        this.familyName = familyName;
        this.fullName = str;
        this.postscriptName = str2;
        this.style = style;
        this.collectionIndex = l;
        this.weightValue = f2;
        this.widthValue = f3;
        this.slantValue = f4;
        this.italicValue = f5;
        this.paletteIndex = l2;
        this.coordinates = list;
    }

    public /* synthetic */ Typeface(String str, String str2, String str3, FontStyle fontStyle, Long l, Float f2, Float f3, Float f4, Float f5, Long l2, List list, byte[] bArr, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, fontStyle, l, f2, f3, f4, f5, l2, list, bArr, (i & 4096) != 0 ? null : str4);
    }

    public final Long getCollectionIndex() {
        return this.collectionIndex;
    }

    public final List<FontCoordinate> getCoordinates() {
        return this.coordinates;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final Float getItalicValue() {
        return this.italicValue;
    }

    public final Long getPaletteIndex() {
        return this.paletteIndex;
    }

    public final String getPostscriptName() {
        return this.postscriptName;
    }

    public final Float getSlantValue() {
        return this.slantValue;
    }

    public final FontStyle getStyle() {
        return this.style;
    }

    public final Float getWeightValue() {
        return this.weightValue;
    }

    public final Float getWidthValue() {
        return this.widthValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$Typeface toProtobufInstance() {
        MutationPayload$Typeface.a aVarA = MutationPayload$Typeface.newBuilder().b(this.familyName).a(this.style.toProtobufInstance());
        if (getDataHash() != null) {
            aVarA.a(getDataHash());
        }
        String str = this.fullName;
        if (str != null) {
            aVarA.c(str);
        }
        String str2 = this.postscriptName;
        if (str2 != null) {
            aVarA.d(str2);
        }
        if (this.collectionIndex != null) {
            aVarA.a(r1.longValue());
        }
        List<FontCoordinate> list = this.coordinates;
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((FontCoordinate) it.next()).toProtobufInstance());
            }
            aVarA.a(arrayList);
        }
        Float f2 = this.weightValue;
        if (f2 != null) {
            aVarA.c(f2.floatValue());
        }
        Float f3 = this.widthValue;
        if (f3 != null) {
            aVarA.d(f3.floatValue());
        }
        Float f4 = this.slantValue;
        if (f4 != null) {
            aVarA.b(f4.floatValue());
        }
        Float f5 = this.italicValue;
        if (f5 != null) {
            aVarA.a(f5.floatValue());
        }
        if (this.paletteIndex != null) {
            aVarA.b(r1.longValue());
        }
        MutationPayload$Typeface mutationPayload$TypefaceBuild = aVarA.build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$TypefaceBuild, "builder.build()");
        return mutationPayload$TypefaceBuild;
    }
}
