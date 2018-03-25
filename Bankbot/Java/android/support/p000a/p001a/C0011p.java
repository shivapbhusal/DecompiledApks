package android.support.p000a.p001a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

class C0011p {
    public static float m44q(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !C0011p.m47q(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int m45q(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0011p.m47q(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    public static boolean m46q(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !C0011p.m47q(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    public static boolean m47q(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int m48w(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !C0011p.m47q(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }
}
