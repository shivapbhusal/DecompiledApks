package android.support.p000a.p001a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class C0006h {
    private int f18a;
    private String f19d = null;
    private float f20e = 0.0f;
    private float f21i = 0.0f;
    private float f22o = 0.0f;
    private final Matrix f23p = new Matrix();
    final ArrayList f24q = new ArrayList();
    private float f25r = 0.0f;
    private int[] f26s;
    private float f27t = 0.0f;
    private float f28u = 1.0f;
    private final Matrix f29w = new Matrix();
    private float f30y = 1.0f;

    public C0006h(C0006h c0006h, ArrayMap arrayMap) {
        this.f20e = c0006h.f20e;
        this.f25r = c0006h.f25r;
        this.f27t = c0006h.f27t;
        this.f30y = c0006h.f30y;
        this.f28u = c0006h.f28u;
        this.f21i = c0006h.f21i;
        this.f22o = c0006h.f22o;
        this.f26s = c0006h.f26s;
        this.f19d = c0006h.f19d;
        this.f18a = c0006h.f18a;
        if (this.f19d != null) {
            arrayMap.put(this.f19d, this);
        }
        this.f23p.set(c0006h.f23p);
        ArrayList arrayList = c0006h.f24q;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof C0006h) {
                this.f24q.add(new C0006h((C0006h) obj, arrayMap));
            } else {
                C0003j c0005g;
                if (obj instanceof C0005g) {
                    c0005g = new C0005g((C0005g) obj);
                } else if (obj instanceof C0004f) {
                    c0005g = new C0004f((C0004f) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f24q.add(c0005g);
                if (c0005g.f3f != null) {
                    arrayMap.put(c0005g.f3f, c0005g);
                }
            }
        }
    }

    private void m13q(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.f26s = null;
        this.f20e = C0011p.m44q(typedArray, xmlPullParser, "rotation", 5, this.f20e);
        this.f25r = typedArray.getFloat(1, this.f25r);
        this.f27t = typedArray.getFloat(2, this.f27t);
        this.f30y = C0011p.m44q(typedArray, xmlPullParser, "scaleX", 3, this.f30y);
        this.f28u = C0011p.m44q(typedArray, xmlPullParser, "scaleY", 4, this.f28u);
        this.f21i = C0011p.m44q(typedArray, xmlPullParser, "translateX", 6, this.f21i);
        this.f22o = C0011p.m44q(typedArray, xmlPullParser, "translateY", 7, this.f22o);
        String string = typedArray.getString(0);
        if (string != null) {
            this.f19d = string;
        }
        m15w();
    }

    private void m15w() {
        this.f23p.reset();
        this.f23p.postTranslate(-this.f25r, -this.f27t);
        this.f23p.postScale(this.f30y, this.f28u);
        this.f23p.postRotate(this.f20e, 0.0f, 0.0f);
        this.f23p.postTranslate(this.f21i + this.f25r, this.f22o + this.f27t);
    }

    public String m16q() {
        return this.f19d;
    }

    public void m17q(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        TypedArray w = C0000a.m0w(resources, theme, attributeSet, C0012q.f67w);
        m13q(w, xmlPullParser);
        w.recycle();
    }
}
