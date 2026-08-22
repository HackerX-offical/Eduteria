package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.PathParser;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes8.dex */
class TransitionUtils {
    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final RectF transformAlphaRectF = new RectF();

    interface CornerSizeBinaryOperator {
        CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2);
    }

    static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    static float lerp(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    private TransitionUtils() {
    }

    static boolean maybeApplyThemeInterpolator(Transition transition, Context context, int i, TimeInterpolator timeInterpolator) {
        if (i == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(MotionUtils.resolveThemeInterpolator(context, i, timeInterpolator));
        return true;
    }

    static boolean maybeApplyThemeDuration(Transition transition, Context context, int i) {
        int iResolveThemeDuration;
        if (i == 0 || transition.getDuration() != -1 || (iResolveThemeDuration = MotionUtils.resolveThemeDuration(context, i, -1)) == -1) {
            return false;
        }
        transition.setDuration(iResolveThemeDuration);
        return true;
    }

    static boolean maybeApplyThemePath(Transition transition, Context context, int i) {
        PathMotion pathMotionResolveThemePath;
        if (i == 0 || (pathMotionResolveThemePath = resolveThemePath(context, i)) == null) {
            return false;
        }
        transition.setPathMotion(pathMotionResolveThemePath);
        return true;
    }

    static PathMotion resolveThemePath(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        if (typedValue.type == 16) {
            int i2 = typedValue.data;
            if (i2 == 0) {
                return null;
            }
            if (i2 == 1) {
                return new MaterialArcMotion();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i2);
        }
        if (typedValue.type == 3) {
            return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(typedValue.string)));
        }
        throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
    }

    static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils$$ExternalSyntheticLambda0
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public final CornerSize apply(CornerSize cornerSize) {
                return RelativeCornerSize.createFromCornerSize(rectF, cornerSize);
            }
        });
    }

    static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (isShapeAppearanceSignificant(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) ? false : true;
    }

    static float lerp(float f2, float f3, float f4, float f5, float f6) {
        return lerp(f2, f3, f4, f5, f6, false);
    }

    static float lerp(float f2, float f3, float f4, float f5, float f6, boolean z) {
        if (!z || (f6 >= 0.0f && f6 <= 1.0f)) {
            return f6 < f4 ? f2 : f6 > f5 ? f3 : lerp(f2, f3, (f6 - f4) / (f5 - f4));
        }
        return lerp(f2, f3, f6);
    }

    static int lerp(int i, int i2, float f2, float f3, float f4) {
        return f4 < f2 ? i : f4 > f3 ? i2 : (int) lerp(i, i2, (f4 - f2) / (f3 - f2));
    }

    static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, final RectF rectF, final RectF rectF2, final float f2, final float f3, final float f4) {
        return f4 < f2 ? shapeAppearanceModel : f4 > f3 ? shapeAppearanceModel2 : transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils.1
            @Override // com.google.android.material.transition.platform.TransitionUtils.CornerSizeBinaryOperator
            public CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF), cornerSize2.getCornerSize(rectF2), f2, f3, f4));
            }
        });
    }

    static Shader createColorShader(int i) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i, i, Shader.TileMode.CLAMP);
    }

    static View findDescendantOrAncestorById(View view, int i) {
        View viewFindViewById = view.findViewById(i);
        return viewFindViewById != null ? viewFindViewById : findAncestorById(view, i);
    }

    static View findAncestorById(View view, int i) {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static RectF getRelativeBounds(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static Rect getRelativeBoundsRect(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    static float calculateArea(RectF rectF) {
        return rectF.width() * rectF.height();
    }

    private static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int i) {
        RectF rectF = transformAlphaRectF;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i);
    }

    static void transform(Canvas canvas, Rect rect, float f2, float f3, float f4, int i, CanvasCompat.CanvasOperation canvasOperation) {
        if (i <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f2, f3);
        canvas.scale(f4, f4);
        if (i < 255) {
            saveLayerAlphaCompat(canvas, rect, i);
        }
        canvasOperation.run(canvas);
        canvas.restoreToCount(iSave);
    }

    static void maybeAddTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static void maybeRemoveTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }
}
