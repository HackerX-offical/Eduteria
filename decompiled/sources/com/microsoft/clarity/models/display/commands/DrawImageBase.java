package com.microsoft.clarity.models.display.commands;

import com.microsoft.clarity.models.display.paints.Color4f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b \u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/DrawImageBase;", "Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "imageIndex", "", "paintIndex", "(Ljava/lang/Integer;I)V", "getImageIndex", "()Ljava/lang/Integer;", "setImageIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maskedColor", "Lcom/microsoft/clarity/models/display/paints/Color4f;", "getMaskedColor", "()Lcom/microsoft/clarity/models/display/paints/Color4f;", "setMaskedColor", "(Lcom/microsoft/clarity/models/display/paints/Color4f;)V", "maskedHeight", "getMaskedHeight", "setMaskedHeight", "maskedWidth", "getMaskedWidth", "setMaskedWidth", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DrawImageBase extends PaintableCommand {
    private Integer imageIndex;
    private Color4f maskedColor;
    private Integer maskedHeight;
    private Integer maskedWidth;

    public DrawImageBase(Integer num, int i) {
        super(i);
        this.imageIndex = num;
    }

    public final Integer getImageIndex() {
        return this.imageIndex;
    }

    public final Color4f getMaskedColor() {
        return this.maskedColor;
    }

    public final Integer getMaskedHeight() {
        return this.maskedHeight;
    }

    public final Integer getMaskedWidth() {
        return this.maskedWidth;
    }

    public final void setImageIndex(Integer num) {
        this.imageIndex = num;
    }

    public final void setMaskedColor(Color4f color4f) {
        this.maskedColor = color4f;
    }

    public final void setMaskedHeight(Integer num) {
        this.maskedHeight = num;
    }

    public final void setMaskedWidth(Integer num) {
        this.maskedWidth = num;
    }
}
