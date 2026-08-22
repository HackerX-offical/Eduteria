package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.r;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$ViewNode extends GeneratedMessageLite<MutationPayload$ViewNode, a> implements r {
    public static final int BACKGROUNDCOLOR_FIELD_NUMBER = 16;
    public static final int CHILDREN_FIELD_NUMBER = 17;
    public static final int CLICKABLE_FIELD_NUMBER = 13;
    private static final MutationPayload$ViewNode DEFAULT_INSTANCE;
    public static final int HEIGHT_FIELD_NUMBER = 7;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int IGNORE_CLICKS_FIELD_NUMBER = 14;
    public static final int IS_MASKED_FIELD_NUMBER = 18;
    public static final int IS_WEB_VIEW_FIELD_NUMBER = 15;
    private static volatile Parser<MutationPayload$ViewNode> PARSER = null;
    public static final int RENDER_NODE_ID_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 2;
    public static final int VIEW_HEIGHT_FIELD_NUMBER = 11;
    public static final int VIEW_WIDTH_FIELD_NUMBER = 10;
    public static final int VIEW_X_FIELD_NUMBER = 8;
    public static final int VIEW_Y_FIELD_NUMBER = 9;
    public static final int VISIBLE_FIELD_NUMBER = 12;
    public static final int WIDTH_FIELD_NUMBER = 6;
    public static final int X_FIELD_NUMBER = 4;
    public static final int Y_FIELD_NUMBER = 5;
    private int backgroundColor_;
    private int bitField0_;
    private boolean clickable_;
    private int height_;
    private int id_;
    private boolean ignoreClicks_;
    private boolean isMasked_;
    private boolean isWebView_;
    private double renderNodeId_;
    private int viewHeight_;
    private int viewWidth_;
    private int viewX_;
    private int viewY_;
    private boolean visible_;
    private int width_;
    private int x_;
    private int y_;
    private String type_ = "";
    private Internal.ProtobufList<MutationPayload$ViewNode> children_ = GeneratedMessageLite.emptyProtobufList();

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$ViewNode, a> implements r {
        public a() {
            super(MutationPayload$ViewNode.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(double d2) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setRenderNodeId(d2);
            return this;
        }

        public final a a(String str) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setType(str);
            return this;
        }

        public final a a(ArrayList arrayList) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).addAllChildren(arrayList);
            return this;
        }

        public final a a(boolean z) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setClickable(z);
            return this;
        }

        public final void a(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setBackgroundColor(i);
        }

        public final a b(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setHeight(i);
            return this;
        }

        public final a b(boolean z) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setIgnoreClicks(z);
            return this;
        }

        public final a c(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setId(i);
            return this;
        }

        public final a c(boolean z) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setIsMasked(z);
            return this;
        }

        public final a d(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setViewHeight(i);
            return this;
        }

        public final a d(boolean z) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setIsWebView(z);
            return this;
        }

        public final a e(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setViewWidth(i);
            return this;
        }

        public final a e(boolean z) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setVisible(z);
            return this;
        }

        public final a f(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setViewX(i);
            return this;
        }

        public final a g(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setViewY(i);
            return this;
        }

        public final a h(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setWidth(i);
            return this;
        }

        public final a i(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setX(i);
            return this;
        }

        public final a j(int i) {
            copyOnWrite();
            ((MutationPayload$ViewNode) this.instance).setY(i);
            return this;
        }
    }

    static {
        MutationPayload$ViewNode mutationPayload$ViewNode = new MutationPayload$ViewNode();
        DEFAULT_INSTANCE = mutationPayload$ViewNode;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$ViewNode.class, mutationPayload$ViewNode);
    }

    private MutationPayload$ViewNode() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllChildren(Iterable<? extends MutationPayload$ViewNode> iterable) {
        ensureChildrenIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.children_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChildren(int i, MutationPayload$ViewNode mutationPayload$ViewNode) {
        mutationPayload$ViewNode.getClass();
        ensureChildrenIsMutable();
        this.children_.add(i, mutationPayload$ViewNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addChildren(MutationPayload$ViewNode mutationPayload$ViewNode) {
        mutationPayload$ViewNode.getClass();
        ensureChildrenIsMutable();
        this.children_.add(mutationPayload$ViewNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackgroundColor() {
        this.bitField0_ &= -32769;
        this.backgroundColor_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChildren() {
        this.children_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClickable() {
        this.bitField0_ &= -4097;
        this.clickable_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeight() {
        this.bitField0_ &= -65;
        this.height_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.bitField0_ &= -2;
        this.id_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIgnoreClicks() {
        this.bitField0_ &= -8193;
        this.ignoreClicks_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsMasked() {
        this.bitField0_ &= -65537;
        this.isMasked_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsWebView() {
        this.bitField0_ &= -16385;
        this.isWebView_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRenderNodeId() {
        this.bitField0_ &= -5;
        this.renderNodeId_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.bitField0_ &= -3;
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearViewHeight() {
        this.bitField0_ &= -1025;
        this.viewHeight_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearViewWidth() {
        this.bitField0_ &= -513;
        this.viewWidth_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearViewX() {
        this.bitField0_ &= -129;
        this.viewX_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearViewY() {
        this.bitField0_ &= -257;
        this.viewY_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVisible() {
        this.bitField0_ &= -2049;
        this.visible_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWidth() {
        this.bitField0_ &= -33;
        this.width_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearX() {
        this.bitField0_ &= -9;
        this.x_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearY() {
        this.bitField0_ &= -17;
        this.y_ = 0;
    }

    private void ensureChildrenIsMutable() {
        Internal.ProtobufList<MutationPayload$ViewNode> protobufList = this.children_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.children_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static MutationPayload$ViewNode getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$ViewNode mutationPayload$ViewNode) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$ViewNode);
    }

    public static MutationPayload$ViewNode parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ViewNode parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ViewNode parseFrom(ByteString byteString) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$ViewNode parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$ViewNode parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$ViewNode parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$ViewNode parseFrom(InputStream inputStream) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$ViewNode parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$ViewNode parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$ViewNode parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$ViewNode parseFrom(byte[] bArr) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$ViewNode parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$ViewNode) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$ViewNode> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeChildren(int i) {
        ensureChildrenIsMutable();
        this.children_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackgroundColor(int i) {
        this.bitField0_ |= 32768;
        this.backgroundColor_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildren(int i, MutationPayload$ViewNode mutationPayload$ViewNode) {
        mutationPayload$ViewNode.getClass();
        ensureChildrenIsMutable();
        this.children_.set(i, mutationPayload$ViewNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClickable(boolean z) {
        this.bitField0_ |= 4096;
        this.clickable_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeight(int i) {
        this.bitField0_ |= 64;
        this.height_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(int i) {
        this.bitField0_ |= 1;
        this.id_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIgnoreClicks(boolean z) {
        this.bitField0_ |= 8192;
        this.ignoreClicks_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsMasked(boolean z) {
        this.bitField0_ |= 65536;
        this.isMasked_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsWebView(boolean z) {
        this.bitField0_ |= 16384;
        this.isWebView_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRenderNodeId(double d2) {
        this.bitField0_ |= 4;
        this.renderNodeId_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) {
        GeneratedMessageLite.checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewHeight(int i) {
        this.bitField0_ |= 1024;
        this.viewHeight_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewWidth(int i) {
        this.bitField0_ |= 512;
        this.viewWidth_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewX(int i) {
        this.bitField0_ |= 128;
        this.viewX_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewY(int i) {
        this.bitField0_ |= 256;
        this.viewY_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisible(boolean z) {
        this.bitField0_ |= 2048;
        this.visible_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidth(int i) {
        this.bitField0_ |= 32;
        this.width_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setX(int i) {
        this.bitField0_ |= 8;
        this.x_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setY(int i) {
        this.bitField0_ |= 16;
        this.y_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$ViewNode();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0012\u0000\u0001\u0001\u0012\u0012\u0000\u0001\u0000\u0001င\u0000\u0002ለ\u0001\u0003က\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007င\u0006\bင\u0007\tင\b\nင\t\u000bင\n\fဇ\u000b\rဇ\f\u000eဇ\r\u000fဇ\u000e\u0010င\u000f\u0011\u001b\u0012ဇ\u0010", new Object[]{"bitField0_", "id_", "type_", "renderNodeId_", "x_", "y_", "width_", "height_", "viewX_", "viewY_", "viewWidth_", "viewHeight_", "visible_", "clickable_", "ignoreClicks_", "isWebView_", "backgroundColor_", "children_", MutationPayload$ViewNode.class, "isMasked_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$ViewNode> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$ViewNode.class) {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int getBackgroundColor() {
        return this.backgroundColor_;
    }

    public MutationPayload$ViewNode getChildren(int i) {
        return this.children_.get(i);
    }

    public int getChildrenCount() {
        return this.children_.size();
    }

    public List<MutationPayload$ViewNode> getChildrenList() {
        return this.children_;
    }

    public r getChildrenOrBuilder(int i) {
        return this.children_.get(i);
    }

    public List<? extends r> getChildrenOrBuilderList() {
        return this.children_;
    }

    public boolean getClickable() {
        return this.clickable_;
    }

    public int getHeight() {
        return this.height_;
    }

    public int getId() {
        return this.id_;
    }

    public boolean getIgnoreClicks() {
        return this.ignoreClicks_;
    }

    public boolean getIsMasked() {
        return this.isMasked_;
    }

    public boolean getIsWebView() {
        return this.isWebView_;
    }

    public double getRenderNodeId() {
        return this.renderNodeId_;
    }

    public String getType() {
        return this.type_;
    }

    public ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    public int getViewHeight() {
        return this.viewHeight_;
    }

    public int getViewWidth() {
        return this.viewWidth_;
    }

    public int getViewX() {
        return this.viewX_;
    }

    public int getViewY() {
        return this.viewY_;
    }

    public boolean getVisible() {
        return this.visible_;
    }

    public int getWidth() {
        return this.width_;
    }

    public int getX() {
        return this.x_;
    }

    public int getY() {
        return this.y_;
    }

    public boolean hasBackgroundColor() {
        return (this.bitField0_ & 32768) != 0;
    }

    public boolean hasClickable() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasHeight() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIgnoreClicks() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasIsMasked() {
        return (this.bitField0_ & 65536) != 0;
    }

    public boolean hasIsWebView() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasRenderNodeId() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasViewHeight() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasViewWidth() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasViewX() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasViewY() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasVisible() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasWidth() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasX() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasY() {
        return (this.bitField0_ & 16) != 0;
    }
}
