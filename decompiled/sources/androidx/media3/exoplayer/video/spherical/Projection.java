package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static Projection createEquirectangular(int i) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public static Projection createEquirectangular(float f2, int i, int i2, float f3, float f4, int i3) {
        int i4;
        int i5 = i;
        Assertions.checkArgument(f2 > 0.0f);
        Assertions.checkArgument(i5 >= 1);
        Assertions.checkArgument(i2 >= 1);
        Assertions.checkArgument(f3 > 0.0f && f3 <= 180.0f);
        Assertions.checkArgument(f4 > 0.0f && f4 <= 360.0f);
        float radians = (float) Math.toRadians(f3);
        float radians2 = (float) Math.toRadians(f4);
        float f5 = radians / i5;
        float f6 = radians2 / i2;
        int i6 = i2 + 1;
        int i7 = ((i6 * 2) + 2) * i5;
        float[] fArr = new float[i7 * 3];
        float[] fArr2 = new float[i7 * 2];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < i5) {
            float f7 = radians / 2.0f;
            float f8 = (i8 * f5) - f7;
            int i11 = i8 + 1;
            float f9 = (i11 * f5) - f7;
            int i12 = 0;
            while (i12 < i6) {
                float f10 = radians;
                float f11 = radians2;
                int i13 = 0;
                int i14 = 2;
                while (i13 < i14) {
                    float f12 = f5;
                    float f13 = i12 * f6;
                    float f14 = f6;
                    float f15 = f8;
                    double d2 = f2;
                    double d3 = (f13 + 3.1415927f) - (f11 / 2.0f);
                    double d4 = i13 == 0 ? f8 : f9;
                    fArr[i9] = -((float) (Math.cos(d4) * Math.sin(d3) * d2));
                    fArr[i9 + 1] = (float) (d2 * Math.sin(d4));
                    int i15 = i9 + 3;
                    fArr[i9 + 2] = (float) (d2 * Math.cos(d3) * Math.cos(d4));
                    fArr2[i10] = f13 / f11;
                    int i16 = i10 + 2;
                    fArr2[i10 + 1] = ((i8 + i13) * f12) / f10;
                    if ((i12 == 0 && i13 == 0) || (i12 == i2 && i13 == 1)) {
                        System.arraycopy(fArr, i9, fArr, i15, 3);
                        i9 += 6;
                        i4 = 2;
                        System.arraycopy(fArr2, i10, fArr2, i16, 2);
                        i10 += 4;
                    } else {
                        i4 = 2;
                        i9 = i15;
                        i10 = i16;
                    }
                    i13++;
                    i14 = i4;
                    f5 = f12;
                    f6 = f14;
                    f8 = f15;
                }
                i12++;
                radians2 = f11;
                radians = f10;
                f5 = f5;
            }
            i5 = i;
            i8 = i11;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr, fArr2, 1)), i3);
    }

    public Projection(Mesh mesh, int i) {
        this(mesh, mesh, i);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i;
        this.singleMesh = mesh == mesh2;
    }

    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i, float[] fArr, float[] fArr2, int i2) {
            this.textureId = i;
            Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i2;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public static final class Mesh {
        private final SubMesh[] subMeshes;

        public Mesh(SubMesh... subMeshArr) {
            this.subMeshes = subMeshArr;
        }

        public int getSubMeshCount() {
            return this.subMeshes.length;
        }

        public SubMesh getSubMesh(int i) {
            return this.subMeshes[i];
        }
    }
}
