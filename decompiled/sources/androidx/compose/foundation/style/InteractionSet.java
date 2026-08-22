package androidx.compose.foundation.style;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StyleState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u0013\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/style/InteractionSet;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/interaction/Interaction;", "", "<init>", "()V", "setOrValue", "isNotEmpty", "", "add", "", "interaction", "(Landroidx/compose/foundation/interaction/Interaction;)V", "remove", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class InteractionSet<T extends Interaction> {
    private Object setOrValue;

    public final boolean isNotEmpty() {
        return this.setOrValue != null;
    }

    public final void add(T interaction) {
        Object obj = this.setOrValue;
        if (obj == null) {
            this.setOrValue = interaction;
        } else if (obj instanceof MutableScatterSet) {
            ((MutableScatterSet) obj).add(interaction);
        } else {
            if (Intrinsics.areEqual(obj, interaction)) {
                return;
            }
            this.setOrValue = ScatterSetKt.mutableScatterSetOf((Interaction) obj, interaction);
        }
    }

    public final void remove(T interaction) {
        Object obj = this.setOrValue;
        if (Intrinsics.areEqual(obj, interaction)) {
            this.setOrValue = null;
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            mutableScatterSet.remove(interaction);
            int size = mutableScatterSet.get_size();
            if (size == 0) {
                this.setOrValue = null;
            } else {
                if (size != 1) {
                    return;
                }
                this.setOrValue = mutableScatterSet.first();
            }
        }
    }
}
