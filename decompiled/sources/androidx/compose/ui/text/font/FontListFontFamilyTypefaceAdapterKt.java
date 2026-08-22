package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.AsyncTypefaceCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\fH\u0002¨\u0006\r"}, d2 = {"firstImmediatelyAvailable", "Lkotlin/Pair;", "", "Landroidx/compose/ui/text/font/Font;", "", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "createDefaultTypeface", "Lkotlin/Function1;", "ui-text"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, Function1<? super TypefaceRequest, ? extends Object> function1) {
        Object objInvoke;
        Object objInvoke2;
        Object objM12393constructorimpl;
        Object objM8348unboximpl;
        int size = list.size();
        List listMutableListOf = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int loadingStrategy = font.getLoadingStrategy();
            if (FontLoadingStrategy.m8374equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m8379getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                    if (asyncTypefaceResult == null) {
                        asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                    }
                    if (asyncTypefaceResult != null) {
                        objInvoke2 = asyncTypefaceResult.m8348unboximpl();
                    } else {
                        Unit unit = Unit.INSTANCE;
                        try {
                            objInvoke = platformFontLoader.loadBlocking(font);
                        } catch (Exception unused) {
                            objInvoke = function1.invoke(typefaceRequest);
                        }
                        Object obj = objInvoke;
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj, false, 8, null);
                        objInvoke2 = obj;
                    }
                }
                if (objInvoke2 == null) {
                    objInvoke2 = function1.invoke(typefaceRequest);
                }
                return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m8409synthesizeTypefaceFxwP2eA(typefaceRequest.m8435getFontSynthesisGVVA2EU(), objInvoke2, font, typefaceRequest.getFontWeight(), typefaceRequest.m8434getFontStyle_LCdwA()));
            }
            if (FontLoadingStrategy.m8374equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m8380getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                    AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                    if (asyncTypefaceResult2 == null) {
                        asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                    }
                    if (asyncTypefaceResult2 != null) {
                        objM8348unboximpl = asyncTypefaceResult2.m8348unboximpl();
                    } else {
                        Unit unit2 = Unit.INSTANCE;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            objM12393constructorimpl = Result.m12393constructorimpl(platformFontLoader.loadBlocking(font));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.INSTANCE;
                            objM12393constructorimpl = Result.m12393constructorimpl(ResultKt.createFailure(th));
                        }
                        Object obj2 = Result.m12399isFailureimpl(objM12393constructorimpl) ? null : objM12393constructorimpl;
                        AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj2, false, 8, null);
                        objM8348unboximpl = obj2;
                    }
                }
                if (objM8348unboximpl != null) {
                    return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m8409synthesizeTypefaceFxwP2eA(typefaceRequest.m8435getFontSynthesisGVVA2EU(), objM8348unboximpl, font, typefaceRequest.getFontWeight(), typefaceRequest.m8434getFontStyle_LCdwA()));
                }
            } else {
                if (!FontLoadingStrategy.m8374equalsimpl0(loadingStrategy, FontLoadingStrategy.INSTANCE.m8378getAsyncPKNRLFQ())) {
                    throw new IllegalStateException("Unknown font type " + font);
                }
                AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM8340get1ASDuI8 = asyncTypefaceCache.m8340get1ASDuI8(font, platformFontLoader);
                if (asyncTypefaceResultM8340get1ASDuI8 != null) {
                    if (!AsyncTypefaceCache.AsyncTypefaceResult.m8346isPermanentFailureimpl(asyncTypefaceResultM8340get1ASDuI8.m8348unboximpl()) && asyncTypefaceResultM8340get1ASDuI8.m8348unboximpl() != null) {
                        return TuplesKt.to(listMutableListOf, FontSynthesis_androidKt.m8409synthesizeTypefaceFxwP2eA(typefaceRequest.m8435getFontSynthesisGVVA2EU(), asyncTypefaceResultM8340get1ASDuI8.m8348unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m8434getFontStyle_LCdwA()));
                    }
                } else if (listMutableListOf == null) {
                    listMutableListOf = CollectionsKt.mutableListOf(font);
                } else {
                    listMutableListOf.add(font);
                }
            }
        }
        return TuplesKt.to(listMutableListOf, function1.invoke(typefaceRequest));
    }
}
