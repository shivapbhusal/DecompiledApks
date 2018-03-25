package android.support.p000a.p001a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class C0005g extends C0003j {
    Join f5a = Join.MITER;
    int f6e = 0;
    private int[] f7h;
    float f8i = 1.0f;
    float f9o = 0.0f;
    Cap f10p = Cap.BUTT;
    int f11q = 0;
    float f12r = 1.0f;
    float f13s = 4.0f;
    int f14t;
    float f15u = 0.0f;
    float f16w = 0.0f;
    float f17y = 1.0f;

    public C0005g(C0005g c0005g) {
        super(c0005g);
        this.f7h = c0005g.f7h;
        this.f11q = c0005g.f11q;
        this.f16w = c0005g.f16w;
        this.f12r = c0005g.f12r;
        this.f6e = c0005g.f6e;
        this.f14t = c0005g.f14t;
        this.f17y = c0005g.f17y;
        this.f15u = c0005g.f15u;
        this.f8i = c0005g.f8i;
        this.f9o = c0005g.f9o;
        this.f10p = c0005g.f10p;
        this.f5a = c0005g.f5a;
        this.f13s = c0005g.f13s;
    }

    private Cap m7q(int i, Cap cap) {
        switch (i) {
            case 0:
                return Cap.BUTT;
            case 1:
                return Cap.ROUND;
            case 2:
                return Cap.SQUARE;
            default:
                return cap;
        }
    }

    private Join m8q(int i, Join join) {
        switch (i) {
            case 0:
                return Join.MITER;
            case 1:
                return Join.ROUND;
            case 2:
                return Join.BEVEL;
            default:
                return join;
        }
    }

    private void m9q(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.f7h = null;
        if (C0011p.m47q(xmlPullParser, "pathData")) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f = string;
            }
            string = typedArray.getString(2);
            if (string != null) {
                this.d = C0018y.m72q(string);
            }
            this.f6e = C0011p.m48w(typedArray, xmlPullParser, "fillColor", 1, this.f6e);
            this.f17y = C0011p.m44q(typedArray, xmlPullParser, "fillAlpha", 12, this.f17y);
            this.f10p = m7q(C0011p.m45q(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f10p);
            this.f5a = m8q(C0011p.m45q(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f5a);
            this.f13s = C0011p.m44q(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f13s);
            this.f11q = C0011p.m48w(typedArray, xmlPullParser, "strokeColor", 3, this.f11q);
            this.f12r = C0011p.m44q(typedArray, xmlPullParser, "strokeAlpha", 11, this.f12r);
            this.f16w = C0011p.m44q(typedArray, xmlPullParser, "strokeWidth", 4, this.f16w);
            this.f8i = C0011p.m44q(typedArray, xmlPullParser, "trimPathEnd", 6, this.f8i);
            this.f9o = C0011p.m44q(typedArray, xmlPullParser, "trimPathOffset", 7, this.f9o);
            this.f15u = C0011p.m44q(typedArray, xmlPullParser, "trimPathStart", 5, this.f15u);
        }
    }

    public void m10q(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        TypedArray w = C0000a.m0w(resources, theme, attributeSet, C0012q.f63e);
        m9q(w, xmlPullParser);
        w.recycle();
    }
}
