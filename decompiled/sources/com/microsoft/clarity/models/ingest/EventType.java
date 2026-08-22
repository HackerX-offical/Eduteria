package com.microsoft.clarity.models.ingest;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b3\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5¨\u00066"}, d2 = {"Lcom/microsoft/clarity/models/ingest/EventType;", "", "customOrdinal", "", "(Ljava/lang/String;II)V", "getCustomOrdinal", "()I", "Metric", "Dimension", "Upload", "Upgrade", "Baseline", "Discover", "Mutation", "Region", "Document", "Click", "Scroll", "Resize", "MouseMove", "MouseDown", "MouseUp", "MouseWheel", "DoubleClick", "TouchStart", "TouchEnd", "TouchMove", "TouchCancel", "Selection", "Timeline", "Page", TypedValues.Custom.NAME, "Ping", "Unload", "Input", "Visibility", "Navigation", "Connection", "ScriptError", "ImageError", "Log", "Variable", "Limit", "Summary", "Box", "Clipboard", "Submit", "Extract", "Fraud", "Change", "WebViewDiscover", "WebViewMutation", "MutationError", "FragmentVisibility", "sdk_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum EventType {
    Metric(0),
    Dimension(1),
    Upload(2),
    Upgrade(3),
    Baseline(4),
    Discover(5),
    Mutation(6),
    Region(7),
    Document(8),
    Click(9),
    Scroll(10),
    Resize(11),
    MouseMove(12),
    MouseDown(13),
    MouseUp(14),
    MouseWheel(15),
    DoubleClick(16),
    TouchStart(17),
    TouchEnd(18),
    TouchMove(19),
    TouchCancel(20),
    Selection(21),
    Timeline(22),
    Page(23),
    Custom(24),
    Ping(25),
    Unload(26),
    Input(27),
    Visibility(28),
    Navigation(29),
    Connection(30),
    ScriptError(31),
    ImageError(32),
    Log(33),
    Variable(34),
    Limit(35),
    Summary(36),
    Box(37),
    Clipboard(38),
    Submit(39),
    Extract(40),
    Fraud(41),
    Change(42),
    WebViewDiscover(100),
    WebViewMutation(101),
    MutationError(102),
    FragmentVisibility(103);

    private final int customOrdinal;

    EventType(int i) {
        this.customOrdinal = i;
    }

    /* synthetic */ EventType(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getCustomOrdinal() {
        return this.customOrdinal;
    }
}
