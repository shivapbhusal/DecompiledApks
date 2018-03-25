package android.support.p000a.p001a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class C0004f extends C0003j {
    public C0004f(C0004f c0004f) {
        super(c0004f);
    }

    private void m4q(TypedArray typedArray) {
        String string = typedArray.getString(0);
        if (string != null) {
            this.f = string;
        }
        string = typedArray.getString(1);
        if (string != null) {
            this.d = C0018y.m72q(string);
        }
    }

    public void m5q(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
        if (C0011p.m47q(xmlPullParser, "pathData")) {
            TypedArray w = C0000a.m0w(resources, theme, attributeSet, C0012q.f65r);
            m4q(w);
            w.recycle();
        }
    }

    public boolean mo1q() {
        return true;
    }
}
