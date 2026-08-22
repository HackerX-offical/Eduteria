package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import com.appnew.android.Utils.Const;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {Const.POSITION, "x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "pathRotate"};
    HashMap<String, CustomVariable> customAttributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    private static final float xRotate(float f2, float f3, float f4, float f5, float f6, float f7) {
        return (((f6 - f4) * f3) - ((f7 - f5) * f2)) + f4;
    }

    private static final float yRotate(float f2, float f3, float f4, float f5, float f6, float f7) {
        return ((f6 - f4) * f2) + ((f7 - f5) * f3) + f5;
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = motionPaths.width;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        this.position = this.time;
        float f9 = motionPaths.x;
        float f10 = motionPaths.y;
        float f11 = f2;
        float f12 = (motionPaths2.x + (f5 / 2.0f)) - ((f6 / 2.0f) + f9);
        float f13 = (motionPaths2.y + (f7 / 2.0f)) - (f10 + (f8 / 2.0f));
        float f14 = ((f5 - f6) * f3) / 2.0f;
        this.x = (int) ((f9 + (f12 * f11)) - f14);
        float f15 = ((f7 - f8) * f4) / 2.0f;
        this.y = (int) ((f10 + (f13 * f11)) - f15);
        this.width = (int) (f6 + r9);
        this.height = (int) (f8 + r12);
        float f16 = Float.isNaN(motionKeyPosition.mPercentX) ? f11 : motionKeyPosition.mPercentX;
        float f17 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f11 = motionKeyPosition.mPercentY;
        }
        float f18 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.x = (int) (((motionPaths.x + (f16 * f12)) + (f18 * f13)) - f14);
        this.y = (int) (((motionPaths.y + (f12 * f17)) + (f13 * f11)) - f15);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public MotionPaths(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i, i2, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i3 == 2) {
            initScreen(i, i2, motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    void initPolar(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float f2;
        float f3 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f3;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f4 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f3 : motionKeyPosition.mPercentWidth;
        float f5 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f3 : motionKeyPosition.mPercentHeight;
        float f6 = motionPaths2.width;
        float f7 = motionPaths.width;
        float f8 = motionPaths2.height;
        float f9 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (f7 + ((f6 - f7) * f4));
        this.height = (int) (f9 + ((f8 - f9) * f5));
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            float f10 = Float.isNaN(motionKeyPosition.mPercentX) ? f3 : motionKeyPosition.mPercentX;
            float f11 = motionPaths2.x;
            float f12 = motionPaths.x;
            this.x = (f10 * (f11 - f12)) + f12;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f3 = motionKeyPosition.mPercentY;
            }
            float f13 = motionPaths2.y;
            float f14 = motionPaths.y;
            this.y = (f3 * (f13 - f14)) + f14;
        } else if (i3 == 2) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f15 = motionPaths2.x;
                float f16 = motionPaths.x;
                fMin = ((f15 - f16) * f3) + f16;
            } else {
                fMin = Math.min(f5, f4) * motionKeyPosition.mPercentX;
            }
            this.x = fMin;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f17 = motionPaths2.y;
                float f18 = motionPaths.y;
                f2 = (f3 * (f17 - f18)) + f18;
            } else {
                f2 = motionKeyPosition.mPercentY;
            }
            this.y = f2;
        } else {
            float f19 = Float.isNaN(motionKeyPosition.mPercentX) ? f3 : motionKeyPosition.mPercentX;
            float f20 = motionPaths2.x;
            float f21 = motionPaths.x;
            this.x = (f19 * (f20 - f21)) + f21;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f3 = motionKeyPosition.mPercentY;
            }
            float f22 = motionPaths2.y;
            float f23 = motionPaths.y;
            this.y = (f3 * (f22 - f23)) + f23;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d2 = ((this.x + (this.width / 2.0f)) - motionPaths.x) - (motionPaths.width / 2.0f);
        double d3 = ((this.y + (this.height / 2.0f)) - motionPaths.y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motion;
        this.x = (float) Math.hypot(d3, d2);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.y = (float) (Math.atan2(d3, d2) + 1.5707963267948966d);
        } else {
            this.y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    void initScreen(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = motionPaths.width;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        this.position = this.time;
        float f9 = motionPaths.x;
        float f10 = motionPaths.y;
        float f11 = motionPaths2.x + (f5 / 2.0f);
        float f12 = motionPaths2.y + (f7 / 2.0f);
        float f13 = (f5 - f6) * f3;
        this.x = (int) ((f9 + ((f11 - ((f6 / 2.0f) + f9)) * f2)) - (f13 / 2.0f));
        float f14 = (f7 - f8) * f4;
        this.y = (int) ((f10 + ((f12 - (f10 + (f8 / 2.0f))) * f2)) - (f14 / 2.0f));
        this.width = (int) (f6 + f13);
        this.height = (int) (f8 + f14);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.x = (int) (motionKeyPosition.mPercentX * ((int) (i - this.width)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.y = (int) (motionKeyPosition.mPercentY * ((int) (i2 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width - motionPaths.width;
        float f6 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f2 = motionKeyPosition.mPercentX;
        }
        float f7 = motionPaths.x;
        float f8 = motionPaths.width;
        float f9 = motionPaths.y;
        float f10 = motionPaths.height;
        float f11 = f2;
        float f12 = (motionPaths2.x + (motionPaths2.width / 2.0f)) - ((f8 / 2.0f) + f7);
        float f13 = (motionPaths2.y + (motionPaths2.height / 2.0f)) - ((f10 / 2.0f) + f9);
        float f14 = f12 * f11;
        float f15 = (f5 * f3) / 2.0f;
        this.x = (int) ((f7 + f14) - f15);
        float f16 = f13 * f11;
        float f17 = (f6 * f4) / 2.0f;
        this.y = (int) ((f9 + f16) - f17);
        this.width = (int) (f8 + r7);
        this.height = (int) (f10 + r8);
        float f18 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f19 = (int) ((motionPaths.x + f14) - f15);
        this.x = f19;
        float f20 = (int) ((motionPaths.y + f16) - f17);
        this.x = f19 + ((-f13) * f18);
        this.y = f20 + (f12 * f18);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    private boolean diff(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean zDiff = diff(this.x, motionPaths.x);
        boolean zDiff2 = diff(this.y, motionPaths.y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z2 = zDiff | zDiff2 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    void getCenter(double d2, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fSin = this.x;
        float fCos = this.y;
        float f2 = this.width;
        float f3 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f4 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                fSin = f4;
            } else if (i3 == 2) {
                fCos = f4;
            } else if (i3 == 3) {
                f2 = f4;
            } else if (i3 == 4) {
                f3 = f4;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d2, fArr2, new float[2]);
            float f5 = fArr2[0];
            float f6 = fArr2[1];
            double d3 = f5;
            double d4 = fSin;
            double d5 = fCos;
            fSin = (float) ((d3 + (Math.sin(d5) * d4)) - ((double) (f2 / 2.0f)));
            fCos = (float) ((((double) f6) - (d4 * Math.cos(d5))) - ((double) (f3 / 2.0f)));
        }
        fArr[i] = fSin + (f2 / 2.0f) + 0.0f;
        fArr[i + 1] = fCos + (f3 / 2.0f) + 0.0f;
    }

    void getCenter(double d2, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f2;
        float fSin = this.x;
        float fCos = this.y;
        float f3 = this.width;
        float f4 = this.height;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f9 = (float) dArr[i];
            float f10 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                fSin = f9;
                f5 = f10;
            } else if (i2 == 2) {
                fCos = f9;
                f7 = f10;
            } else if (i2 == 3) {
                f3 = f9;
                f6 = f10;
            } else if (i2 == 4) {
                f4 = f9;
                f8 = f10;
            }
        }
        float f11 = (f6 / 2.0f) + f5;
        float fCos2 = (f8 / 2.0f) + f7;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d2, fArr3, fArr4);
            float f12 = fArr3[0];
            float f13 = fArr3[1];
            float f14 = fArr4[0];
            float f15 = fArr4[1];
            f2 = 2.0f;
            double d3 = fSin;
            double d4 = fCos;
            fSin = (float) ((((double) f12) + (Math.sin(d4) * d3)) - ((double) (f3 / 2.0f)));
            fCos = (float) ((((double) f13) - (Math.cos(d4) * d3)) - ((double) (f4 / 2.0f)));
            double d5 = f5;
            double dSin = ((double) f14) + (Math.sin(d4) * d5);
            double d6 = f7;
            float fCos3 = (float) (dSin + (Math.cos(d4) * d6));
            fCos2 = (float) ((((double) f15) - (d5 * Math.cos(d4))) + (Math.sin(d4) * d6));
            f11 = fCos3;
        } else {
            f2 = 2.0f;
        }
        fArr[0] = fSin + (f3 / f2) + 0.0f;
        fArr[1] = fCos + (f4 / f2) + 0.0f;
        fArr2[0] = f11;
        fArr2[1] = fCos2;
    }

    void getCenterVelocity(double d2, int[] iArr, double[] dArr, float[] fArr, int i) {
        float fSin = this.x;
        float fCos = this.y;
        float f2 = this.width;
        float f3 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f4 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                fSin = f4;
            } else if (i3 == 2) {
                fCos = f4;
            } else if (i3 == 3) {
                f2 = f4;
            } else if (i3 == 4) {
                f3 = f4;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d2, fArr2, new float[2]);
            float f5 = fArr2[0];
            float f6 = fArr2[1];
            double d3 = f5;
            double d4 = fSin;
            double d5 = fCos;
            fSin = (float) ((d3 + (Math.sin(d5) * d4)) - ((double) (f2 / 2.0f)));
            fCos = (float) ((((double) f6) - (d4 * Math.cos(d5))) - ((double) (f3 / 2.0f)));
        }
        fArr[i] = fSin + (f2 / 2.0f) + 0.0f;
        fArr[i + 1] = fCos + (f3 / 2.0f) + 0.0f;
    }

    void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f2 = this.width;
        float f3 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f4 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f2 = f4;
            } else if (i3 == 4) {
                f3 = f4;
            }
        }
        fArr[i] = f2;
        fArr[i + 1] = f3;
    }

    void setView(float f2, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f3;
        float f4 = this.x;
        float f5 = this.y;
        float f6 = this.width;
        float f7 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            double[] dArr4 = this.mTempValue;
            int i3 = iArr[i2];
            dArr4[i3] = dArr[i2];
            this.mTempDelta[i3] = dArr2[i2];
        }
        float f8 = Float.NaN;
        int i4 = 0;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i4 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i4]) && (dArr3 == null || dArr3[i4] == 0.0d)) {
                f3 = f8;
            } else {
                double d2 = dArr3 != null ? dArr3[i4] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i4])) {
                    d2 = this.mTempValue[i4] + d2;
                }
                f3 = f8;
                float f13 = (float) d2;
                float f14 = (float) this.mTempDelta[i4];
                if (i4 == 1) {
                    f8 = f3;
                    f4 = f13;
                    f9 = f14;
                } else if (i4 == 2) {
                    f8 = f3;
                    f5 = f13;
                    f10 = f14;
                } else if (i4 == 3) {
                    f8 = f3;
                    f6 = f13;
                    f11 = f14;
                } else if (i4 == 4) {
                    f8 = f3;
                    f7 = f13;
                    f12 = f14;
                } else if (i4 == 5) {
                    f8 = f13;
                }
                i4++;
            }
            f8 = f3;
            i4++;
        }
        float f15 = f8;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f2, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d3 = f4;
            double d4 = f5;
            float fSin = (float) ((((double) f16) + (Math.sin(d4) * d3)) - ((double) (f6 / 2.0f)));
            float fCos = (float) ((((double) f17) - (Math.cos(d4) * d3)) - ((double) (f7 / 2.0f)));
            double d5 = f9;
            double d6 = f10;
            float fSin2 = (float) (((double) f18) + (Math.sin(d4) * d5) + (Math.cos(d4) * d3 * d6));
            float fCos2 = (float) ((((double) f19) - (d5 * Math.cos(d4))) + (d3 * Math.sin(d4) * d6));
            if (dArr2.length >= 2) {
                dArr2[0] = fSin2;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f15)) {
                motionWidget.setRotationZ((float) (((double) f15) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f4 = fSin;
            f5 = fCos;
        } else if (!Float.isNaN(f15)) {
            motionWidget.setRotationZ((float) (((double) 0.0f) + ((double) f15) + Math.toDegrees(Math.atan2(f10 + (f12 / 2.0f), f9 + (f11 / 2.0f)))));
        }
        float f20 = f4 + 0.5f;
        float f21 = f5 + 0.5f;
        motionWidget.layout((int) f20, (int) f21, (int) (f20 + f6), (int) (f21 + f7));
    }

    void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f2 = this.x;
        float fCos = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f2 = f5;
            } else if (i3 == 2) {
                fCos = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d2 = f2;
            double d3 = fCos;
            float fSin = (float) ((((double) centerX) + (Math.sin(d3) * d2)) - ((double) (f3 / 2.0f)));
            fCos = (float) ((((double) centerY) - (d2 * Math.cos(d3))) - ((double) (f4 / 2.0f)));
            f2 = fSin;
        }
        float f6 = f3 + f2;
        float f7 = f4 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f2 + 0.0f;
        fArr[i + 1] = fCos + 0.0f;
        fArr[i + 2] = f6 + 0.0f;
        fArr[i + 3] = fCos + 0.0f;
        fArr[i + 4] = f6 + 0.0f;
        fArr[i + 5] = f7 + 0.0f;
        fArr[i + 6] = f2 + 0.0f;
        fArr[i + 7] = f7 + 0.0f;
    }

    void setDpDt(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f8 = (float) dArr[i];
            double d2 = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f4 = f8;
            } else if (i2 == 2) {
                f6 = f8;
            } else if (i2 == 3) {
                f5 = f8;
            } else if (i2 == 4) {
                f7 = f8;
            }
        }
        float f9 = f4 - ((0.0f * f5) / 2.0f);
        float f10 = f6 - ((0.0f * f7) / 2.0f);
        fArr[0] = (f9 * (1.0f - f2)) + (((f5 * 1.0f) + f9) * f2) + 0.0f;
        fArr[1] = (f10 * (1.0f - f3)) + (((f7 * 1.0f) + f10) * f3) + 0.0f;
    }

    void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = fArr[r1];
                i++;
            }
        }
    }

    boolean hasCustomData(String str) {
        return this.customAttributes.containsKey(str);
    }

    int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    int getCustomData(String str, double[] dArr, int i) {
        CustomVariable customVariable = this.customAttributes.get(str);
        int i2 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        while (i2 < iNumberOfInterpolatedValues) {
            dArr[i] = r2[i2];
            i2++;
            i++;
        }
        return iNumberOfInterpolatedValues;
    }

    void setBounds(float f2, float f3, float f4, float f5) {
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        this.mPathMotionArc = motionWidget.motion.mPathMotionArc;
        this.mAnimateRelativeTo = motionWidget.motion.mAnimateRelativeTo;
        this.mPathRotate = motionWidget.motion.mPathRotate;
        this.mDrawPath = motionWidget.motion.mDrawPath;
        this.mAnimateCircleAngleTo = motionWidget.motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }
}
