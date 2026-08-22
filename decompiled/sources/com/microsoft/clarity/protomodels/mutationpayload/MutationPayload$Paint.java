package com.microsoft.clarity.protomodels.mutationpayload;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import com.microsoft.clarity.j.j;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes9.dex */
public final class MutationPayload$Paint extends GeneratedMessageLite<MutationPayload$Paint, a> implements j {
    public static final int ANTI_ALIAS_FIELD_NUMBER = 8;
    public static final int BLEND_MODE_FIELD_NUMBER = 3;
    public static final int COLOR_FIELD_NUMBER = 1;
    public static final int COLOR_FILTER_FIELD_NUMBER = 10;
    private static final MutationPayload$Paint DEFAULT_INSTANCE;
    public static final int DITHER_FIELD_NUMBER = 9;
    public static final int LOOPER_FIELD_NUMBER = 13;
    public static final int MASK_FILTER_FIELD_NUMBER = 11;
    private static volatile Parser<MutationPayload$Paint> PARSER = null;
    public static final int PATH_EFFECT_FIELD_NUMBER = 14;
    public static final int SHADER_FIELD_NUMBER = 12;
    public static final int STROKE_CAP_FIELD_NUMBER = 4;
    public static final int STROKE_JOIN_FIELD_NUMBER = 5;
    public static final int STROKE_MITER_FIELD_NUMBER = 7;
    public static final int STROKE_WIDTH_FIELD_NUMBER = 6;
    public static final int STYLE_FIELD_NUMBER = 2;
    private boolean antiAlias_;
    private int bitField0_;
    private double blendMode_;
    private MutationPayload$ColorFilter colorFilter_;
    private MutationPayload$Color4f color_;
    private boolean dither_;
    private MutationPayload$Looper looper_;
    private MutationPayload$MaskFilter maskFilter_;
    private MutationPayload$PathEffect pathEffect_;
    private MutationPayload$Shader shader_;
    private double strokeCap_;
    private double strokeJoin_;
    private float strokeMiter_;
    private float strokeWidth_;
    private double style_;

    public static final class a extends GeneratedMessageLite.Builder<MutationPayload$Paint, a> implements j {
        public a() {
            super(MutationPayload$Paint.DEFAULT_INSTANCE);
        }

        public /* synthetic */ a(int i) {
            this();
        }

        public final a a(double d2) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setBlendMode(d2);
            return this;
        }

        public final a a(float f2) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setStrokeMiter(f2);
            return this;
        }

        public final a a(MutationPayload$Color4f mutationPayload$Color4f) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setColor(mutationPayload$Color4f);
            return this;
        }

        public final a a(boolean z) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setAntiAlias(z);
            return this;
        }

        public final void a(MutationPayload$ColorFilter mutationPayload$ColorFilter) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setColorFilter(mutationPayload$ColorFilter);
        }

        public final void a(MutationPayload$Looper mutationPayload$Looper) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setLooper(mutationPayload$Looper);
        }

        public final void a(MutationPayload$MaskFilter mutationPayload$MaskFilter) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setMaskFilter(mutationPayload$MaskFilter);
        }

        public final void a(MutationPayload$PathEffect mutationPayload$PathEffect) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setPathEffect(mutationPayload$PathEffect);
        }

        public final void a(MutationPayload$Shader mutationPayload$Shader) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setShader(mutationPayload$Shader);
        }

        public final a b(double d2) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setStrokeCap(d2);
            return this;
        }

        public final a b(float f2) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setStrokeWidth(f2);
            return this;
        }

        public final a b(boolean z) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setDither(z);
            return this;
        }

        public final a c(double d2) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setStrokeJoin(d2);
            return this;
        }

        public final a d(double d2) {
            copyOnWrite();
            ((MutationPayload$Paint) this.instance).setStyle(d2);
            return this;
        }
    }

    static {
        MutationPayload$Paint mutationPayload$Paint = new MutationPayload$Paint();
        DEFAULT_INSTANCE = mutationPayload$Paint;
        GeneratedMessageLite.registerDefaultInstance(MutationPayload$Paint.class, mutationPayload$Paint);
    }

    private MutationPayload$Paint() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAntiAlias() {
        this.bitField0_ &= -129;
        this.antiAlias_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBlendMode() {
        this.bitField0_ &= -5;
        this.blendMode_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearColor() {
        this.color_ = null;
        this.bitField0_ &= -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearColorFilter() {
        this.colorFilter_ = null;
        this.bitField0_ &= -513;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDither() {
        this.bitField0_ &= -257;
        this.dither_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLooper() {
        this.looper_ = null;
        this.bitField0_ &= -4097;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMaskFilter() {
        this.maskFilter_ = null;
        this.bitField0_ &= -1025;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPathEffect() {
        this.pathEffect_ = null;
        this.bitField0_ &= -8193;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearShader() {
        this.shader_ = null;
        this.bitField0_ &= -2049;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStrokeCap() {
        this.bitField0_ &= -9;
        this.strokeCap_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStrokeJoin() {
        this.bitField0_ &= -17;
        this.strokeJoin_ = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStrokeMiter() {
        this.bitField0_ &= -65;
        this.strokeMiter_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStrokeWidth() {
        this.bitField0_ &= -33;
        this.strokeWidth_ = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStyle() {
        this.bitField0_ &= -3;
        this.style_ = 0.0d;
    }

    public static MutationPayload$Paint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeColor(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        MutationPayload$Color4f mutationPayload$Color4f2 = this.color_;
        if (mutationPayload$Color4f2 != null && mutationPayload$Color4f2 != MutationPayload$Color4f.getDefaultInstance()) {
            mutationPayload$Color4f = MutationPayload$Color4f.newBuilder(this.color_).mergeFrom(mutationPayload$Color4f).buildPartial();
        }
        this.color_ = mutationPayload$Color4f;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeColorFilter(MutationPayload$ColorFilter mutationPayload$ColorFilter) {
        mutationPayload$ColorFilter.getClass();
        MutationPayload$ColorFilter mutationPayload$ColorFilter2 = this.colorFilter_;
        if (mutationPayload$ColorFilter2 != null && mutationPayload$ColorFilter2 != MutationPayload$ColorFilter.getDefaultInstance()) {
            mutationPayload$ColorFilter = MutationPayload$ColorFilter.newBuilder(this.colorFilter_).mergeFrom(mutationPayload$ColorFilter).buildPartial();
        }
        this.colorFilter_ = mutationPayload$ColorFilter;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLooper(MutationPayload$Looper mutationPayload$Looper) {
        mutationPayload$Looper.getClass();
        MutationPayload$Looper mutationPayload$Looper2 = this.looper_;
        if (mutationPayload$Looper2 != null && mutationPayload$Looper2 != MutationPayload$Looper.getDefaultInstance()) {
            mutationPayload$Looper = MutationPayload$Looper.newBuilder(this.looper_).mergeFrom(mutationPayload$Looper).buildPartial();
        }
        this.looper_ = mutationPayload$Looper;
        this.bitField0_ |= 4096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMaskFilter(MutationPayload$MaskFilter mutationPayload$MaskFilter) {
        mutationPayload$MaskFilter.getClass();
        MutationPayload$MaskFilter mutationPayload$MaskFilter2 = this.maskFilter_;
        if (mutationPayload$MaskFilter2 != null && mutationPayload$MaskFilter2 != MutationPayload$MaskFilter.getDefaultInstance()) {
            mutationPayload$MaskFilter = MutationPayload$MaskFilter.newBuilder(this.maskFilter_).mergeFrom(mutationPayload$MaskFilter).buildPartial();
        }
        this.maskFilter_ = mutationPayload$MaskFilter;
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePathEffect(MutationPayload$PathEffect mutationPayload$PathEffect) {
        mutationPayload$PathEffect.getClass();
        MutationPayload$PathEffect mutationPayload$PathEffect2 = this.pathEffect_;
        if (mutationPayload$PathEffect2 != null && mutationPayload$PathEffect2 != MutationPayload$PathEffect.getDefaultInstance()) {
            mutationPayload$PathEffect = MutationPayload$PathEffect.newBuilder(this.pathEffect_).mergeFrom(mutationPayload$PathEffect).buildPartial();
        }
        this.pathEffect_ = mutationPayload$PathEffect;
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeShader(MutationPayload$Shader mutationPayload$Shader) {
        mutationPayload$Shader.getClass();
        MutationPayload$Shader mutationPayload$Shader2 = this.shader_;
        if (mutationPayload$Shader2 != null && mutationPayload$Shader2 != MutationPayload$Shader.getDefaultInstance()) {
            mutationPayload$Shader = MutationPayload$Shader.newBuilder(this.shader_).mergeFrom(mutationPayload$Shader).buildPartial();
        }
        this.shader_ = mutationPayload$Shader;
        this.bitField0_ |= 2048;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static a newBuilder(MutationPayload$Paint mutationPayload$Paint) {
        return DEFAULT_INSTANCE.createBuilder(mutationPayload$Paint);
    }

    public static MutationPayload$Paint parseDelimitedFrom(InputStream inputStream) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Paint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Paint parseFrom(ByteString byteString) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MutationPayload$Paint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MutationPayload$Paint parseFrom(CodedInputStream codedInputStream) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MutationPayload$Paint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static MutationPayload$Paint parseFrom(InputStream inputStream) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MutationPayload$Paint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MutationPayload$Paint parseFrom(ByteBuffer byteBuffer) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MutationPayload$Paint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MutationPayload$Paint parseFrom(byte[] bArr) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MutationPayload$Paint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (MutationPayload$Paint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Parser<MutationPayload$Paint> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAntiAlias(boolean z) {
        this.bitField0_ |= 128;
        this.antiAlias_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBlendMode(double d2) {
        this.bitField0_ |= 4;
        this.blendMode_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColor(MutationPayload$Color4f mutationPayload$Color4f) {
        mutationPayload$Color4f.getClass();
        this.color_ = mutationPayload$Color4f;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorFilter(MutationPayload$ColorFilter mutationPayload$ColorFilter) {
        mutationPayload$ColorFilter.getClass();
        this.colorFilter_ = mutationPayload$ColorFilter;
        this.bitField0_ |= 512;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDither(boolean z) {
        this.bitField0_ |= 256;
        this.dither_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLooper(MutationPayload$Looper mutationPayload$Looper) {
        mutationPayload$Looper.getClass();
        this.looper_ = mutationPayload$Looper;
        this.bitField0_ |= 4096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaskFilter(MutationPayload$MaskFilter mutationPayload$MaskFilter) {
        mutationPayload$MaskFilter.getClass();
        this.maskFilter_ = mutationPayload$MaskFilter;
        this.bitField0_ |= 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathEffect(MutationPayload$PathEffect mutationPayload$PathEffect) {
        mutationPayload$PathEffect.getClass();
        this.pathEffect_ = mutationPayload$PathEffect;
        this.bitField0_ |= 8192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShader(MutationPayload$Shader mutationPayload$Shader) {
        mutationPayload$Shader.getClass();
        this.shader_ = mutationPayload$Shader;
        this.bitField0_ |= 2048;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStrokeCap(double d2) {
        this.bitField0_ |= 8;
        this.strokeCap_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStrokeJoin(double d2) {
        this.bitField0_ |= 16;
        this.strokeJoin_ = d2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStrokeMiter(float f2) {
        this.bitField0_ |= 64;
        this.strokeMiter_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStrokeWidth(float f2) {
        this.bitField0_ |= 32;
        this.strokeWidth_ = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStyle(double d2) {
        this.bitField0_ |= 2;
        this.style_ = d2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (com.microsoft.clarity.j.a.f1050a[methodToInvoke.ordinal()]) {
            case 1:
                return new MutationPayload$Paint();
            case 2:
                return new a(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ဉ\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004\u0006ခ\u0005\u0007ခ\u0006\bဇ\u0007\tဇ\b\nဉ\t\u000bဉ\n\fဉ\u000b\rဉ\f\u000eဉ\r", new Object[]{"bitField0_", "color_", "style_", "blendMode_", "strokeCap_", "strokeJoin_", "strokeWidth_", "strokeMiter_", "antiAlias_", "dither_", "colorFilter_", "maskFilter_", "shader_", "looper_", "pathEffect_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MutationPayload$Paint> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (MutationPayload$Paint.class) {
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

    public boolean getAntiAlias() {
        return this.antiAlias_;
    }

    public double getBlendMode() {
        return this.blendMode_;
    }

    public MutationPayload$Color4f getColor() {
        MutationPayload$Color4f mutationPayload$Color4f = this.color_;
        return mutationPayload$Color4f == null ? MutationPayload$Color4f.getDefaultInstance() : mutationPayload$Color4f;
    }

    public MutationPayload$ColorFilter getColorFilter() {
        MutationPayload$ColorFilter mutationPayload$ColorFilter = this.colorFilter_;
        return mutationPayload$ColorFilter == null ? MutationPayload$ColorFilter.getDefaultInstance() : mutationPayload$ColorFilter;
    }

    public boolean getDither() {
        return this.dither_;
    }

    public MutationPayload$Looper getLooper() {
        MutationPayload$Looper mutationPayload$Looper = this.looper_;
        return mutationPayload$Looper == null ? MutationPayload$Looper.getDefaultInstance() : mutationPayload$Looper;
    }

    public MutationPayload$MaskFilter getMaskFilter() {
        MutationPayload$MaskFilter mutationPayload$MaskFilter = this.maskFilter_;
        return mutationPayload$MaskFilter == null ? MutationPayload$MaskFilter.getDefaultInstance() : mutationPayload$MaskFilter;
    }

    public MutationPayload$PathEffect getPathEffect() {
        MutationPayload$PathEffect mutationPayload$PathEffect = this.pathEffect_;
        return mutationPayload$PathEffect == null ? MutationPayload$PathEffect.getDefaultInstance() : mutationPayload$PathEffect;
    }

    public MutationPayload$Shader getShader() {
        MutationPayload$Shader mutationPayload$Shader = this.shader_;
        return mutationPayload$Shader == null ? MutationPayload$Shader.getDefaultInstance() : mutationPayload$Shader;
    }

    public double getStrokeCap() {
        return this.strokeCap_;
    }

    public double getStrokeJoin() {
        return this.strokeJoin_;
    }

    public float getStrokeMiter() {
        return this.strokeMiter_;
    }

    public float getStrokeWidth() {
        return this.strokeWidth_;
    }

    public double getStyle() {
        return this.style_;
    }

    public boolean hasAntiAlias() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasBlendMode() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasColor() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasColorFilter() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasDither() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasLooper() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasMaskFilter() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasPathEffect() {
        return (this.bitField0_ & 8192) != 0;
    }

    public boolean hasShader() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasStrokeCap() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasStrokeJoin() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasStrokeMiter() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasStrokeWidth() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasStyle() {
        return (this.bitField0_ & 2) != 0;
    }
}
