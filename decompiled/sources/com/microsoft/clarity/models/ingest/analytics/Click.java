package com.microsoft.clarity.models.ingest.analytics;

import com.clevertap.android.sdk.Constants;
import com.microsoft.clarity.models.ingest.EventType;
import com.microsoft.clarity.n.b;

/* JADX INFO: loaded from: classes9.dex */
public final class Click extends AnalyticsEvent {
    private final float absX;
    private final float absY;
    private String nodeSelector;
    private boolean reaction;
    private int relativeX;
    private int relativeY;
    private String text;
    private final EventType type;
    private int viewId;

    public Click(long j, String str, int i, float f2, float f3) {
        super(j, str, i);
        this.absX = f2;
        this.absY = f3;
        this.type = EventType.Click;
        this.relativeX = 0;
        this.relativeY = 0;
        this.reaction = false;
        this.viewId = 0;
        this.text = null;
    }

    private String getNodeHashSelector() {
        String str = this.nodeSelector;
        if (str == null) {
            return null;
        }
        return b.b(str);
    }

    public float getAbsX() {
        return this.absX;
    }

    public float getAbsY() {
        return this.absY;
    }

    public String getNodeSelector() {
        return this.nodeSelector;
    }

    public boolean getReaction() {
        return this.reaction;
    }

    public int getRelativeX() {
        return this.relativeX;
    }

    public int getRelativeY() {
        return this.relativeY;
    }

    public String getText() {
        return this.text;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public EventType getType() {
        return this.type;
    }

    public int getViewId() {
        return this.viewId;
    }

    @Override // com.microsoft.clarity.models.ingest.SessionEvent
    public String serialize() {
        int i = this.viewId;
        if (i == -1) {
            i = 0;
        }
        return com.microsoft.clarity.a.b.a(Constants.AES_PREFIX).append(getTimestamp()).append(Constants.SEPARATOR_COMMA).append(getType().getCustomOrdinal()).append(Constants.SEPARATOR_COMMA).append(i).append(Constants.SEPARATOR_COMMA).append(StrictMath.round(this.absX)).append(Constants.SEPARATOR_COMMA).append(StrictMath.round(this.absY)).append(Constants.SEPARATOR_COMMA).append(this.relativeX).append(Constants.SEPARATOR_COMMA).append(this.relativeY).append(Constants.SEPARATOR_COMMA).append(0).append(Constants.SEPARATOR_COMMA).append(this.reaction ? 1 : 0).append(Constants.SEPARATOR_COMMA).append(0).append(",\"").append(this.text).append("\",").append((Object) null).append(",\"").append(Integer.toString(i, 36)).append('.').append(getNodeHashSelector()).append("\"]").toString();
    }

    public void setNodeSelector(String str) {
        this.nodeSelector = str;
    }

    public boolean setReaction(boolean z) {
        this.reaction = z;
        return z;
    }

    public void setRelativeX(int i) {
        this.relativeX = i;
    }

    public void setRelativeY(int i) {
        this.relativeY = i;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setViewId(int i) {
        this.viewId = i;
    }
}
