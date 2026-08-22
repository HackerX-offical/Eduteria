package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: PathParser.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u0005\u001aX\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002\u001aX\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a\r\u0010\u001e\u001a\u00020\r*\u00020\rH\u0082\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u001f"}, d2 = {"EmptyArray", "", "getEmptyArray", "()[F", "toPath", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", TypedValues.AttributesType.S_TARGET, "drawArc", "", "p", "x0", "", "y0", "x1", "y1", "a", "b", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcToBezier", "cx", "cy", "e1x", "e1y", "start", "sweep", "toRadians", "ui-graphics"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PathParserKt {
    private static final float[] EmptyArray = new float[0];

    private static final double toRadians(double d2) {
        return (d2 / ((double) 180)) * 3.141592653589793d;
    }

    public static final float[] getEmptyArray() {
        return EmptyArray;
    }

    public static /* synthetic */ Path toPath$default(List list, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = AndroidPath_androidKt.Path();
        }
        return toPath(list, path);
    }

    public static final Path toPath(List<? extends PathNode> list, Path path) {
        int i;
        float f2;
        int i2;
        PathNode pathNode;
        float f3;
        float f4;
        float x1;
        float x2;
        float y2;
        float dy2;
        float f5;
        float f6;
        float dx1;
        float dy1;
        float dy22;
        List<? extends PathNode> list2 = list;
        Path path2 = path;
        int iMo5856getFillTypeRgk1Os = path2.mo5856getFillTypeRgk1Os();
        path2.rewind();
        path2.mo5858setFillTypeoQ8Xj4U(iMo5856getFillTypeRgk1Os);
        PathNode pathNode2 = list2.isEmpty() ? PathNode.Close.INSTANCE : list2.get(0);
        int size = list2.size();
        float f7 = 0.0f;
        int i3 = 0;
        float arcStartX = 0.0f;
        float arcStartY = 0.0f;
        float x = 0.0f;
        float y = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        while (i3 < size) {
            PathNode pathNode3 = list2.get(i3);
            if (pathNode3 instanceof PathNode.Close) {
                path2.close();
                i = size;
                f2 = f7;
                i2 = i3;
                pathNode = pathNode3;
                arcStartX = f8;
                x = arcStartX;
                arcStartY = f9;
            } else {
                if (pathNode3 instanceof PathNode.RelativeMoveTo) {
                    PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode3;
                    x += relativeMoveTo.getDx();
                    y += relativeMoveTo.getDy();
                    path2.relativeMoveTo(relativeMoveTo.getDx(), relativeMoveTo.getDy());
                    i = size;
                    f2 = f7;
                    i2 = i3;
                    f8 = x;
                    f9 = y;
                } else {
                    if (pathNode3 instanceof PathNode.MoveTo) {
                        PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode3;
                        float x3 = moveTo.getX();
                        float y3 = moveTo.getY();
                        path2.moveTo(moveTo.getX(), moveTo.getY());
                        x = x3;
                        f8 = x;
                        y = y3;
                        f9 = y;
                    } else {
                        if (pathNode3 instanceof PathNode.RelativeLineTo) {
                            PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode3;
                            path2.relativeLineTo(relativeLineTo.getDx(), relativeLineTo.getDy());
                            x += relativeLineTo.getDx();
                            dy2 = relativeLineTo.getDy();
                        } else {
                            if (pathNode3 instanceof PathNode.LineTo) {
                                PathNode.LineTo lineTo = (PathNode.LineTo) pathNode3;
                                path2.lineTo(lineTo.getX(), lineTo.getY());
                                x2 = lineTo.getX();
                                y2 = lineTo.getY();
                            } else if (pathNode3 instanceof PathNode.RelativeHorizontalTo) {
                                PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode3;
                                path2.relativeLineTo(relativeHorizontalTo.getDx(), f7);
                                x += relativeHorizontalTo.getDx();
                            } else if (pathNode3 instanceof PathNode.HorizontalTo) {
                                PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode3;
                                path2.lineTo(horizontalTo.getX(), y);
                                x = horizontalTo.getX();
                            } else if (pathNode3 instanceof PathNode.RelativeVerticalTo) {
                                PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode3;
                                path2.relativeLineTo(f7, relativeVerticalTo.getDy());
                                dy2 = relativeVerticalTo.getDy();
                            } else if (pathNode3 instanceof PathNode.VerticalTo) {
                                PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode3;
                                path2.lineTo(x, verticalTo.getY());
                                y = verticalTo.getY();
                            } else {
                                if (pathNode3 instanceof PathNode.RelativeCurveTo) {
                                    PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode3;
                                    path2.relativeCubicTo(relativeCurveTo.getDx1(), relativeCurveTo.getDy1(), relativeCurveTo.getDx2(), relativeCurveTo.getDy2(), relativeCurveTo.getDx3(), relativeCurveTo.getDy3());
                                    dx1 = relativeCurveTo.getDx2() + x;
                                    dy1 = relativeCurveTo.getDy2() + y;
                                    x += relativeCurveTo.getDx3();
                                    dy22 = relativeCurveTo.getDy3();
                                } else {
                                    if (pathNode3 instanceof PathNode.CurveTo) {
                                        PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode3;
                                        path.cubicTo(curveTo.getX1(), curveTo.getY1(), curveTo.getX2(), curveTo.getY2(), curveTo.getX3(), curveTo.getY3());
                                        float x22 = curveTo.getX2();
                                        float y22 = curveTo.getY2();
                                        float x32 = curveTo.getX3();
                                        float y32 = curveTo.getY3();
                                        x = x32;
                                        y = y32;
                                        i = size;
                                        f2 = f7;
                                        i2 = i3;
                                        pathNode = pathNode3;
                                        arcStartX = x22;
                                        arcStartY = y22;
                                    } else if (pathNode3 instanceof PathNode.RelativeReflectiveCurveTo) {
                                        if (pathNode2.getIsCurve()) {
                                            float f10 = x - arcStartX;
                                            f6 = y - arcStartY;
                                            f5 = f10;
                                        } else {
                                            f5 = f7;
                                            f6 = f5;
                                        }
                                        PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode3;
                                        path.relativeCubicTo(f5, f6, relativeReflectiveCurveTo.getDx1(), relativeReflectiveCurveTo.getDy1(), relativeReflectiveCurveTo.getDx2(), relativeReflectiveCurveTo.getDy2());
                                        dx1 = relativeReflectiveCurveTo.getDx1() + x;
                                        dy1 = relativeReflectiveCurveTo.getDy1() + y;
                                        x += relativeReflectiveCurveTo.getDx2();
                                        dy22 = relativeReflectiveCurveTo.getDy2();
                                    } else {
                                        if (pathNode3 instanceof PathNode.ReflectiveCurveTo) {
                                            if (pathNode2.getIsCurve()) {
                                                float f11 = 2;
                                                x = (x * f11) - arcStartX;
                                                y = (f11 * y) - arcStartY;
                                            }
                                            PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode3;
                                            path.cubicTo(x, y, reflectiveCurveTo.getX1(), reflectiveCurveTo.getY1(), reflectiveCurveTo.getX2(), reflectiveCurveTo.getY2());
                                            x1 = reflectiveCurveTo.getX1();
                                            float y1 = reflectiveCurveTo.getY1();
                                            float x23 = reflectiveCurveTo.getX2();
                                            float y23 = reflectiveCurveTo.getY2();
                                            x = x23;
                                            y = y23;
                                            i = size;
                                            f2 = f7;
                                            i2 = i3;
                                            pathNode = pathNode3;
                                            arcStartY = y1;
                                        } else if (pathNode3 instanceof PathNode.RelativeQuadTo) {
                                            PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode3;
                                            path.relativeQuadraticTo(relativeQuadTo.getDx1(), relativeQuadTo.getDy1(), relativeQuadTo.getDx2(), relativeQuadTo.getDy2());
                                            arcStartX = relativeQuadTo.getDx1() + x;
                                            arcStartY = relativeQuadTo.getDy1() + y;
                                            x += relativeQuadTo.getDx2();
                                            dy2 = relativeQuadTo.getDy2();
                                        } else if (pathNode3 instanceof PathNode.QuadTo) {
                                            PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode3;
                                            path.quadraticTo(quadTo.getX1(), quadTo.getY1(), quadTo.getX2(), quadTo.getY2());
                                            arcStartX = quadTo.getX1();
                                            arcStartY = quadTo.getY1();
                                            x2 = quadTo.getX2();
                                            y2 = quadTo.getY2();
                                        } else if (pathNode3 instanceof PathNode.RelativeReflectiveQuadTo) {
                                            if (pathNode2.getIsQuad()) {
                                                f3 = x - arcStartX;
                                                f4 = y - arcStartY;
                                            } else {
                                                f3 = f7;
                                                f4 = f3;
                                            }
                                            PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode3;
                                            path.relativeQuadraticTo(f3, f4, relativeReflectiveQuadTo.getDx(), relativeReflectiveQuadTo.getDy());
                                            x1 = f3 + x;
                                            float f12 = f4 + y;
                                            x += relativeReflectiveQuadTo.getDx();
                                            y += relativeReflectiveQuadTo.getDy();
                                            arcStartY = f12;
                                            i = size;
                                            f2 = f7;
                                            i2 = i3;
                                            pathNode = pathNode3;
                                        } else if (pathNode3 instanceof PathNode.ReflectiveQuadTo) {
                                            if (pathNode2.getIsQuad()) {
                                                float f13 = 2;
                                                x = (x * f13) - arcStartX;
                                                y = (f13 * y) - arcStartY;
                                            }
                                            PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode3;
                                            path.quadraticTo(x, y, reflectiveQuadTo.getX(), reflectiveQuadTo.getY());
                                            float f14 = x;
                                            x = reflectiveQuadTo.getX();
                                            arcStartX = f14;
                                            i = size;
                                            f2 = f7;
                                            i2 = i3;
                                            arcStartY = y;
                                            pathNode = pathNode3;
                                            y = reflectiveQuadTo.getY();
                                        } else if (pathNode3 instanceof PathNode.RelativeArcTo) {
                                            PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode3;
                                            float arcStartDx = relativeArcTo.getArcStartDx() + x;
                                            float arcStartDy = relativeArcTo.getArcStartDy() + y;
                                            f2 = f7;
                                            pathNode = pathNode3;
                                            i = size;
                                            i2 = i3;
                                            drawArc(path, x, y, arcStartDx, arcStartDy, relativeArcTo.getHorizontalEllipseRadius(), relativeArcTo.getVerticalEllipseRadius(), relativeArcTo.getTheta(), relativeArcTo.isMoreThanHalf(), relativeArcTo.isPositiveArc());
                                            arcStartX = arcStartDx;
                                            x = arcStartX;
                                            arcStartY = arcStartDy;
                                        } else {
                                            i = size;
                                            f2 = f7;
                                            i2 = i3;
                                            pathNode = pathNode3;
                                            if (!(pathNode instanceof PathNode.ArcTo)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode;
                                            drawArc(path, x, y, arcTo.getArcStartX(), arcTo.getArcStartY(), arcTo.getHorizontalEllipseRadius(), arcTo.getVerticalEllipseRadius(), arcTo.getTheta(), arcTo.isMoreThanHalf(), arcTo.isPositiveArc());
                                            arcStartX = arcTo.getArcStartX();
                                            x = arcStartX;
                                            arcStartY = arcTo.getArcStartY();
                                        }
                                        arcStartX = x1;
                                    }
                                    i3 = i2 + 1;
                                    path2 = path;
                                    pathNode2 = pathNode;
                                    size = i;
                                    f7 = f2;
                                    list2 = list;
                                }
                                y += dy22;
                                arcStartX = dx1;
                                arcStartY = dy1;
                            }
                            y = y2;
                            x = x2;
                        }
                        y += dy2;
                    }
                    i = size;
                    f2 = f7;
                    i2 = i3;
                }
                pathNode = pathNode3;
                i3 = i2 + 1;
                path2 = path;
                pathNode2 = pathNode;
                size = i;
                f7 = f2;
                list2 = list;
            }
            y = arcStartY;
            i3 = i2 + 1;
            path2 = path;
            pathNode2 = pathNode;
            size = i;
            f7 = f2;
            list2 = list;
        }
        return path;
    }

    private static final void drawArc(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, boolean z, boolean z2) {
        double d9;
        double d10;
        double d11 = (d8 / ((double) 180)) * 3.141592653589793d;
        double dCos = Math.cos(d11);
        double dSin = Math.sin(d11);
        double d12 = ((d2 * dCos) + (d3 * dSin)) / d6;
        double d13 = (((-d2) * dSin) + (d3 * dCos)) / d7;
        double d14 = ((d4 * dCos) + (d5 * dSin)) / d6;
        double d15 = (((-d4) * dSin) + (d5 * dCos)) / d7;
        double d16 = d12 - d14;
        double d17 = d13 - d15;
        double d18 = 2;
        double d19 = (d12 + d14) / d18;
        double d20 = (d13 + d15) / d18;
        double d21 = (d16 * d16) + (d17 * d17);
        if (d21 == 0.0d) {
            return;
        }
        double d22 = (1.0d / d21) - 0.25d;
        if (d22 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d21) / 1.99999d);
            drawArc(path, d2, d3, d4, d5, d6 * dSqrt, d7 * dSqrt, d8, z, z2);
            return;
        }
        double dSqrt2 = Math.sqrt(d22);
        double d23 = d16 * dSqrt2;
        double d24 = dSqrt2 * d17;
        if (z == z2) {
            d9 = d19 - d24;
            d10 = d20 + d23;
        } else {
            d9 = d19 + d24;
            d10 = d20 - d23;
        }
        double dAtan2 = Math.atan2(d13 - d10, d12 - d9);
        double dAtan22 = Math.atan2(d15 - d10, d14 - d9) - dAtan2;
        if (z2 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d25 = d9 * d6;
        double d26 = d10 * d7;
        arcToBezier(path, (d25 * dCos) - (d26 * dSin), (d25 * dSin) + (d26 * dCos), d6, d7, d2, d3, d11, dAtan2, dAtan22);
    }

    private static final void arcToBezier(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d10 * d11) / 3.141592653589793d));
        double dCos = Math.cos(d8);
        double dSin = Math.sin(d8);
        double dCos2 = Math.cos(d9);
        double dSin2 = Math.sin(d9);
        double d12 = -d4;
        double d13 = d12 * dCos;
        double d14 = d5 * dSin;
        double d15 = (d13 * dSin2) - (d14 * dCos2);
        double d16 = d12 * dSin;
        double d17 = d5 * dCos;
        double d18 = (dSin2 * d16) + (dCos2 * d17);
        double d19 = d10 / ((double) iCeil);
        double d20 = d18;
        double d21 = d15;
        int i = 0;
        double d22 = d6;
        double d23 = d7;
        double d24 = d9;
        while (i < iCeil) {
            double d25 = d24 + d19;
            double dSin3 = Math.sin(d25);
            double dCos3 = Math.cos(d25);
            int i2 = i;
            double d26 = (d2 + ((d4 * dCos) * dCos3)) - (d14 * dSin3);
            double d27 = d11;
            double d28 = d3 + (d4 * dSin * dCos3) + (d17 * dSin3);
            double d29 = (d13 * dSin3) - (d14 * dCos3);
            double d30 = (dSin3 * d16) + (dCos3 * d17);
            double d31 = d25 - d24;
            int i3 = iCeil;
            double dTan = Math.tan(d31 / ((double) 2));
            double dSin4 = (Math.sin(d31) * (Math.sqrt(d27 + ((3.0d * dTan) * dTan)) - ((double) 1))) / ((double) 3);
            path.cubicTo((float) (d22 + (d21 * dSin4)), (float) (d23 + (d20 * dSin4)), (float) (d26 - (dSin4 * d29)), (float) (d28 - (dSin4 * d30)), (float) d26, (float) d28);
            dSin = dSin;
            d19 = d19;
            d22 = d26;
            d23 = d28;
            i = i2 + 1;
            d24 = d25;
            d20 = d30;
            iCeil = i3;
            d21 = d29;
            dCos = dCos;
            d11 = d27;
        }
    }
}
