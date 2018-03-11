package com.sistlias.esnioteh;

import android.support.v7.app.AppCompatDelegate;
import dalvik.system.DexClassLoader;

public class C0248q extends DexClassLoader {
    private static final String[] f116h = new String[]{C0248q.m101q(C0248q.m102q("C:\f<4X*\u0004!5I<\u000e\"")), C0248q.m101q(C0248q.m102q("^7\u001d9+Es\f"))};
    int[] f117a;
    String f118d;
    int[] f119e;
    int f120f;
    int f121g;
    String f122i;
    int[] f123o;
    int f124p;
    int f125q;
    int f126r;
    int f127s;
    int f128t;
    int f129u;
    int[] f130w;
    int f131y;

    public C0248q(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
        this.f125q = 11687;
        this.f130w = new int[]{26, 87, 82, 9313, 10869};
        this.f119e = new int[]{4, 69, 40, 81, 92, 10, 2};
        this.f126r = 10278;
        this.f128t = 57;
        this.f131y = 61;
        this.f129u = 5151;
        this.f122i = f116h[0];
        this.f123o = new int[0];
        this.f124p = 68;
        this.f117a = new int[]{82, 62, 24, 8696, 8, 27};
        this.f127s = 18484;
        this.f118d = f116h[1];
        this.f120f = 73;
        this.f121g = 10;
        this.f131y = ((this.f124p + 7550) + (this.f121g + this.f123o.length)) + (14099 - this.f127s);
        this.f119e[1] = this.f130w.length + 88;
    }

    private static String m101q(char[] cArr) {
        int length = cArr.length;
        for (int i = 0; length > i; i++) {
            int i2;
            char c = cArr[i];
            switch (i % 5) {
                case 0:
                    i2 = 43;
                    break;
                case 1:
                    i2 = 83;
                    break;
                case 2:
                    i2 = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    break;
                case 3:
                    i2 = 79;
                    break;
                default:
                    i2 = 88;
                    break;
            }
            cArr[i] = (char) (i2 ^ c);
        }
        return new String(cArr).intern();
    }

    private static char[] m102q(String str) {
        char[] toCharArray = str.toCharArray();
        if (toCharArray.length < 2) {
            toCharArray[0] = (char) (toCharArray[0] ^ 88);
        }
        return toCharArray;
    }
}
