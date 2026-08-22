package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.TypefaceResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018J7\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a2\u0006\u0010#\u001a\u00020\u0012H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "<init>", "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "getPlatformFontLoader$ui_text", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "", "preload", "", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/ui/text/font/FontFamily;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolve", "Landroidx/compose/runtime/State;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "typefaceRequest", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    public static final int $stable = 8;
    private final Function1<TypefaceRequest, Object> createDefaultTypeface;
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    private final PlatformFontLoader platformFontLoader;
    private final PlatformResolveInterceptor platformResolveInterceptor;
    private final TypefaceRequestCache typefaceRequestCache;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1, reason: invalid class name */
    /* JADX INFO: compiled from: FontFamilyResolver.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.text.font.FontFamilyResolverImpl", f = "FontFamilyResolver.kt", i = {0}, l = {43}, m = "preload", n = {"fontFamily"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FontFamilyResolverImpl.this.preload(null, this);
        }
    }

    public FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter) {
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter;
        this.createDefaultTypeface = new Function1() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FontFamilyResolverImpl.createDefaultTypeface$lambda$0(this.f$0, (TypefaceRequest) obj);
            }
        };
    }

    /* JADX INFO: renamed from: getPlatformFontLoader$ui_text, reason: from getter */
    public final PlatformFontLoader getPlatformFontLoader() {
        return this.platformFontLoader;
    }

    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(platformFontLoader, (i & 2) != 0 ? PlatformResolveInterceptor.INSTANCE.getDefault$ui_text() : platformResolveInterceptor, (i & 4) != 0 ? FontFamilyResolverKt.getGlobalTypefaceRequestCache() : typefaceRequestCache, (i & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), null, 2, null) : fontListFontFamilyTypefaceAdapter, (i & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createDefaultTypeface$lambda$0(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        return fontFamilyResolverImpl.resolve(TypefaceRequest.m8430copye1PVR60$default(typefaceRequest, null, null, 0, 0, null, 30, null)).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object preload(androidx.compose.ui.text.font.FontFamily r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof androidx.compose.ui.text.font.FontFamilyResolverImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r14
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = (androidx.compose.ui.text.font.FontFamilyResolverImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r13 = r0.L$0
            androidx.compose.ui.text.font.FontFamily r13 = (androidx.compose.ui.text.font.FontFamily) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L4f
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            kotlin.ResultKt.throwOnFailure(r14)
            boolean r14 = r13 instanceof androidx.compose.ui.text.font.FontListFontFamily
            if (r14 != 0) goto L40
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L40:
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r14 = r12.fontListFontFamilyTypefaceAdapter
            androidx.compose.ui.text.font.PlatformFontLoader r2 = r12.platformFontLoader
            r0.L$0 = r13
            r0.label = r3
            java.lang.Object r14 = r14.preload(r13, r2, r0)
            if (r14 != r1) goto L4f
            return r1
        L4f:
            r14 = r13
            androidx.compose.ui.text.font.FontListFontFamily r14 = (androidx.compose.ui.text.font.FontListFontFamily) r14
            java.util.List r14 = r14.getFonts()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r14.size()
            r0.<init>(r1)
            r1 = r14
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            r2 = 0
        L67:
            if (r2 >= r1) goto La4
            java.lang.Object r3 = r14.get(r2)
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            androidx.compose.ui.text.font.Font r3 = (androidx.compose.ui.text.font.Font) r3
            androidx.compose.ui.text.font.TypefaceRequest r5 = new androidx.compose.ui.text.font.TypefaceRequest
            androidx.compose.ui.text.font.PlatformResolveInterceptor r6 = r12.platformResolveInterceptor
            androidx.compose.ui.text.font.FontFamily r6 = r6.interceptFontFamily(r13)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r7 = r12.platformResolveInterceptor
            androidx.compose.ui.text.font.FontWeight r8 = r3.getWeight()
            androidx.compose.ui.text.font.FontWeight r7 = r7.interceptFontWeight(r8)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r8 = r12.platformResolveInterceptor
            int r3 = r3.getStyle()
            int r8 = r8.m8414interceptFontStyleT2F_aPo(r3)
            androidx.compose.ui.text.font.FontSynthesis$Companion r3 = androidx.compose.ui.text.font.FontSynthesis.INSTANCE
            int r9 = r3.m8404getAllGVVA2EU()
            androidx.compose.ui.text.font.PlatformFontLoader r3 = r12.platformFontLoader
            java.lang.Object r10 = r3.getCacheKey()
            r11 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r4.add(r5)
            int r2 = r2 + 1
            goto L67
        La4:
            java.util.List r0 = (java.util.List) r0
            androidx.compose.ui.text.font.TypefaceRequestCache r13 = r12.typefaceRequestCache
            androidx.compose.ui.text.font.FontFamilyResolverImpl$$ExternalSyntheticLambda3 r14 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$$ExternalSyntheticLambda3
            r14.<init>()
            r13.preWarmCache(r0, r14)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload(androidx.compose.ui.text.font.FontFamily, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypefaceResult preload$lambda$1(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResultResolve = fontFamilyResolverImpl.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, fontFamilyResolverImpl.platformFontLoader, new Function1() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FontFamilyResolverImpl.preload$lambda$1$0((TypefaceResult.Immutable) obj);
            }
        }, fontFamilyResolverImpl.createDefaultTypeface);
        if (typefaceResultResolve != null) {
            return typefaceResultResolve;
        }
        TypefaceResult typefaceResultResolve2 = fontFamilyResolverImpl.platformFamilyTypefaceAdapter.resolve(typefaceRequest, fontFamilyResolverImpl.platformFontLoader, new Function1() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FontFamilyResolverImpl.preload$lambda$1$1((TypefaceResult.Immutable) obj);
            }
        }, fontFamilyResolverImpl.createDefaultTypeface);
        if (typefaceResultResolve2 != null) {
            return typefaceResultResolve2;
        }
        throw new IllegalStateException("Could not load font");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preload$lambda$1$0(TypefaceResult.Immutable immutable) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preload$lambda$1$1(TypefaceResult.Immutable immutable) {
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /* JADX INFO: renamed from: resolve-DPcqOEQ */
    public State<Object> mo8359resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int fontStyle, int fontSynthesis) {
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.m8414interceptFontStyleT2F_aPo(fontStyle), this.platformResolveInterceptor.m8415interceptFontSynthesisMscr08Y(fontSynthesis), this.platformFontLoader.getCacheKey(), null));
    }

    private final State<Object> resolve(final TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new Function1() { // from class: androidx.compose.ui.text.font.FontFamilyResolverImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FontFamilyResolverImpl.resolve$lambda$0(this.f$0, typefaceRequest, (Function1) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypefaceResult resolve$lambda$0(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest, Function1 function1) {
        TypefaceResult typefaceResultResolve = fontFamilyResolverImpl.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, fontFamilyResolverImpl.platformFontLoader, function1, fontFamilyResolverImpl.createDefaultTypeface);
        if (typefaceResultResolve != null) {
            return typefaceResultResolve;
        }
        TypefaceResult typefaceResultResolve2 = fontFamilyResolverImpl.platformFamilyTypefaceAdapter.resolve(typefaceRequest, fontFamilyResolverImpl.platformFontLoader, function1, fontFamilyResolverImpl.createDefaultTypeface);
        if (typefaceResultResolve2 != null) {
            return typefaceResultResolve2;
        }
        throw new IllegalStateException("Could not load font");
    }
}
