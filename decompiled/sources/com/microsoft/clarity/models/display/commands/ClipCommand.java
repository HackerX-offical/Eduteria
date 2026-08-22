package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.protomodels.mutationpayload.MutationPayload$DisplayCommand;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/ClipCommand;", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "op", "", "antiAlias", "", "(IZ)V", "getAntiAlias", "()Z", "getOp", "()I", "toProtobufInstance", "Lcom/microsoft/clarity/protomodels/mutationpayload/MutationPayload$DisplayCommand;", "Companion", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ClipCommand extends DisplayCommand {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean antiAlias;
    private final int op;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/ClipCommand$Companion;", "", "()V", "extractAntiAliasFromFlags", "", "flags", "Lkotlin/UInt;", "extractAntiAliasFromFlags-WZ4Q5Ns$sdk_prodRelease", "(I)Z", "extractClipOpFromFlags", "", "extractClipOpFromFlags-WZ4Q5Ns$sdk_prodRelease", "(I)I", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: extractAntiAliasFromFlags-WZ4Q5Ns$sdk_prodRelease, reason: not valid java name */
        public final boolean m12303extractAntiAliasFromFlagsWZ4Q5Ns$sdk_prodRelease(int flags) {
            return UInt.m12488constructorimpl(UInt.m12488constructorimpl(flags >>> 4) & 1) != 0;
        }

        /* JADX INFO: renamed from: extractClipOpFromFlags-WZ4Q5Ns$sdk_prodRelease, reason: not valid java name */
        public final int m12304extractClipOpFromFlagsWZ4Q5Ns$sdk_prodRelease(int flags) {
            return UInt.m12488constructorimpl(flags & 15);
        }
    }

    public ClipCommand(int i, boolean z) {
        this.op = i;
        this.antiAlias = z;
    }

    public final boolean getAntiAlias() {
        return this.antiAlias;
    }

    public final int getOp() {
        return this.op;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.microsoft.clarity.models.IProtoModel
    public MutationPayload$DisplayCommand toProtobufInstance() {
        MutationPayload$DisplayCommand mutationPayload$DisplayCommandBuild = MutationPayload$DisplayCommand.newBuilder().b(getType().name()).i(this.op).a(this.antiAlias).build();
        Intrinsics.checkNotNullExpressionValue(mutationPayload$DisplayCommandBuild, "newBuilder()\n           …ias)\n            .build()");
        return mutationPayload$DisplayCommandBuild;
    }
}
