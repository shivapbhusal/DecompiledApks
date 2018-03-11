package android.support.p000a.p001a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region.Op;
import android.support.v4.util.ArrayMap;

class C0008k {
    private static final Matrix f33p = new Matrix();
    private final Matrix f34a;
    private Paint f35d;
    float f36e;
    private PathMeasure f37f;
    private int f38g;
    private final C0006h f39h;
    private final Path f40i;
    private final Path f41o;
    float f42q;
    float f43r;
    private Paint f44s;
    int f45t;
    final ArrayMap f46u;
    float f47w;
    String f48y;

    public C0008k() {
        this.f34a = new Matrix();
        this.f42q = 0.0f;
        this.f47w = 0.0f;
        this.f36e = 0.0f;
        this.f43r = 0.0f;
        this.f45t = 255;
        this.f48y = null;
        this.f46u = new ArrayMap();
        this.f39h = new C0006h();
        this.f40i = new Path();
        this.f41o = new Path();
    }

    public C0008k(C0008k c0008k) {
        this.f34a = new Matrix();
        this.f42q = 0.0f;
        this.f47w = 0.0f;
        this.f36e = 0.0f;
        this.f43r = 0.0f;
        this.f45t = 255;
        this.f48y = null;
        this.f46u = new ArrayMap();
        this.f39h = new C0006h(c0008k.f39h, this.f46u);
        this.f40i = new Path(c0008k.f40i);
        this.f41o = new Path(c0008k.f41o);
        this.f42q = c0008k.f42q;
        this.f47w = c0008k.f47w;
        this.f36e = c0008k.f36e;
        this.f43r = c0008k.f43r;
        this.f38g = c0008k.f38g;
        this.f45t = c0008k.f45t;
        this.f48y = c0008k.f48y;
        if (c0008k.f48y != null) {
            this.f46u.put(c0008k.f48y, this);
        }
    }

    private static float m19q(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    private float m20q(Matrix matrix) {
        float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
        float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
        float q = C0008k.m19q(fArr[0], fArr[1], fArr[2], fArr[3]);
        hypot = Math.max(hypot, hypot2);
        return hypot > 0.0f ? Math.abs(q) / hypot : 0.0f;
    }

    private void m23q(C0006h c0006h, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        c0006h.f29w.set(matrix);
        c0006h.f29w.preConcat(c0006h.f23p);
        for (int i3 = 0; i3 < c0006h.f24q.size(); i3++) {
            Object obj = c0006h.f24q.get(i3);
            if (obj instanceof C0006h) {
                m23q((C0006h) obj, c0006h.f29w, canvas, i, i2, colorFilter);
            } else if (obj instanceof C0003j) {
                m24q(c0006h, (C0003j) obj, canvas, i, i2, colorFilter);
            }
        }
    }

    private void m24q(C0006h c0006h, C0003j c0003j, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        float f = ((float) i) / this.f36e;
        float f2 = ((float) i2) / this.f43r;
        float min = Math.min(f, f2);
        Matrix w = c0006h.f29w;
        this.f34a.set(w);
        this.f34a.postScale(f, f2);
        f = m20q(w);
        if (f != 0.0f) {
            c0003j.m1q(this.f40i);
            Path path = this.f40i;
            this.f41o.reset();
            if (c0003j.mo1q()) {
                this.f41o.addPath(path, this.f34a);
                canvas.clipPath(this.f41o, Op.REPLACE);
                return;
            }
            Paint paint;
            C0005g c0005g = (C0005g) c0003j;
            if (!(c0005g.f15u == 0.0f && c0005g.f8i == 1.0f)) {
                float f3 = (c0005g.f15u + c0005g.f9o) % 1.0f;
                float f4 = (c0005g.f8i + c0005g.f9o) % 1.0f;
                if (this.f37f == null) {
                    this.f37f = new PathMeasure();
                }
                this.f37f.setPath(this.f40i, false);
                float length = this.f37f.getLength();
                f3 *= length;
                f4 *= length;
                path.reset();
                if (f3 > f4) {
                    this.f37f.getSegment(f3, length, path, true);
                    this.f37f.getSegment(0.0f, f4, path, true);
                } else {
                    this.f37f.getSegment(f3, f4, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f41o.addPath(path, this.f34a);
            if (c0005g.f6e != 0) {
                if (this.f35d == null) {
                    this.f35d = new Paint();
                    this.f35d.setStyle(Style.FILL);
                    this.f35d.setAntiAlias(true);
                }
                paint = this.f35d;
                paint.setColor(C0014s.m56w(c0005g.f6e, c0005g.f17y));
                paint.setColorFilter(colorFilter);
                canvas.drawPath(this.f41o, paint);
            }
            if (c0005g.f11q != 0) {
                if (this.f44s == null) {
                    this.f44s = new Paint();
                    this.f44s.setStyle(Style.STROKE);
                    this.f44s.setAntiAlias(true);
                }
                paint = this.f44s;
                if (c0005g.f5a != null) {
                    paint.setStrokeJoin(c0005g.f5a);
                }
                if (c0005g.f10p != null) {
                    paint.setStrokeCap(c0005g.f10p);
                }
                paint.setStrokeMiter(c0005g.f13s);
                paint.setColor(C0014s.m56w(c0005g.f11q, c0005g.f12r));
                paint.setColorFilter(colorFilter);
                paint.setStrokeWidth((f * min) * c0005g.f16w);
                canvas.drawPath(this.f41o, paint);
            }
        }
    }

    public int m27q() {
        return this.f45t;
    }

    public void m28q(float f) {
        m29q((int) (255.0f * f));
    }

    public void m29q(int i) {
        this.f45t = i;
    }

    public void m30q(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        m23q(this.f39h, f33p, canvas, i, i2, colorFilter);
    }

    public float m31w() {
        return ((float) m27q()) / 255.0f;
    }
}
