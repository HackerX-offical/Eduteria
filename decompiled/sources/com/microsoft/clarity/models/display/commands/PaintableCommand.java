package com.microsoft.clarity.models.display.commands;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/clarity/models/display/commands/PaintableCommand;", "Lcom/microsoft/clarity/models/display/commands/DisplayCommand;", "paintIndex", "", "(I)V", "getPaintIndex", "()I", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PaintableCommand extends DisplayCommand {
    private final int paintIndex;

    public PaintableCommand(int i) {
        this.paintIndex = i;
    }

    public final int getPaintIndex() {
        return this.paintIndex;
    }
}
