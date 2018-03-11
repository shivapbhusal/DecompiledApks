package com.sistlias.esnioteh;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class ebarenv extends Application {
    private static final String[] f97l = new String[]{m93q(m98w("P\u0011\u001e")), m93q(m98w("M\u001b\u001d#5C")), m93q(m98w("@\u0001\n.$DH\u001f#%U\u0006")), m93q(m98w("I\u0007\u000042")), m93q(m98w("V\u0006\u001f,6F\u001b\u0003+4\u0005\t\u001f&")), m93q(m98w("@\u0001\u0006")), m93q(m98w("U\t\u00004")), m93q(m98w("\\\u000b\u0003")), m93q(m98w("B\u0007\u0004&")), m93q(m98w("I\u000b\u001d53@\u0004\u001e*2NH\t\">@\f")), m93q(m98w("B\u0003")), m93q(m98w("I\u0018")), m93q(m98w("K\u0018\u0004&0L\u0004\bg3Q\u0012\u001f+6\u0005\u0004\u0018")), m93q(m98w("F\u001b\f")), m93q(m98w("L\u001a\u000e(\"@\u000bM5/@\u0004\u001f"))};
    int f98a = 68;
    boolean f99d = false;
    int f100e;
    boolean f101f;
    int f102g;
    int f103h;
    boolean f104i;
    int f105j = (this.f107o - 15728);
    private Application f106k = null;
    int f107o = 2940;
    String f108p = f97l[1];
    int f109q;
    int f110r = 85;
    boolean f111s = true;
    int[] f112t;
    int f113u;
    int f114w = 4251;
    String f115y;

    public ebarenv() {
        m95q(true);
    }

    private static int m91q(String str) {
        return str.length();
    }

    private static int m92q(String str, String str2) {
        return str.lastIndexOf(str2);
    }

    private static String m93q(char[] cArr) {
        int length = cArr.length;
        for (int i = 0; length > i; i++) {
            int i2;
            char c = cArr[i];
            switch (i % 5) {
                case 0:
                    i2 = 37;
                    break;
                case 1:
                    i2 = 104;
                    break;
                case 2:
                    i2 = AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
                    break;
                case 3:
                    i2 = 71;
                    break;
                default:
                    i2 = 87;
                    break;
            }
            cArr[i] = (char) (i2 ^ c);
        }
        return new String(cArr).intern();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m94q(int r5) {
        /*
        r4 = this;
        r2 = 0;
        r1 = 1;
        r0 = r4.f99d;
        if (r1 == r0) goto L_0x0015;
    L_0x0006:
        r0 = r4.f98a;
        if (r0 == 0) goto L_0x0015;
    L_0x000a:
        r0 = r4.f108p;
        r0 = m91q(r0);
        if (r0 <= 0) goto L_0x0049;
    L_0x0012:
        r0 = r1;
    L_0x0013:
        if (r1 != r0) goto L_0x0015;
    L_0x0015:
        r0 = r4.f111s;
        if (r1 != r0) goto L_0x004b;
    L_0x0019:
        r0 = r1;
    L_0x001a:
        r3 = r4.f107o;
        if (r3 == 0) goto L_0x004d;
    L_0x001e:
        r3 = r1;
    L_0x001f:
        if (r3 != r1) goto L_0x004f;
    L_0x0021:
        r3 = r1;
    L_0x0022:
        if (r0 != r3) goto L_0x0051;
    L_0x0024:
        r0 = r1;
    L_0x0025:
        r4.f101f = r0;
        r0 = r4.f108p;
        r3 = f97l;
        r3 = r3[r2];
        r0 = m92q(r0, r3);
        if (r0 > 0) goto L_0x0034;
    L_0x0033:
        r1 = r2;
    L_0x0034:
        r4.f101f = r1;
        r0 = r4.f107o;
        r1 = r4.f98a;
        r0 = r0 + r1;
        r0 = r0 + 2;
        r0 = r0 + -9;
        r1 = r4.f108p;
        r1 = m91q(r1);
        r0 = r0 - r1;
        r4.f114w = r0;
        return;
    L_0x0049:
        r0 = r2;
        goto L_0x0013;
    L_0x004b:
        r0 = r2;
        goto L_0x001a;
    L_0x004d:
        r3 = r2;
        goto L_0x001f;
    L_0x004f:
        r3 = r2;
        goto L_0x0022;
    L_0x0051:
        r0 = r2;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sistlias.esnioteh.ebarenv.q(int):void");
    }

    private void m95q(boolean z) {
        int i = 0;
        this.f108p = f97l[3];
        this.f108p = f97l[2];
        try {
            boolean z2;
            this.f104i = (((true == this.f111s ? 1 : 0) == 1 ? 1 : 0) != 1 ? 1 : 0) == (this.f99d == this.f99d ? 1 : 0);
            if (m91q(this.f108p) <= 0) {
                if ((this.f111s ? 1 : 0) == 1) {
                    if ((this.f114w != 0 ? 1 : 0) != 0) {
                        z2 = false;
                        this.f111s = z2;
                        this.f102g = (((z ? 1 : 0) + 28) + (this.f98a * 50)) - this.f110r;
                        switch ((z ? 1 : 0) + ((this.f99d ? 1 : 0) - this.f114w)) {
                            case 29:
                                this.f115y = f97l[4];
                                this.f114w = (this.f107o + 2589) + 17142;
                                return;
                            case 1464:
                                this.f114w = (((this.f99d ? 1 : 0) + 52) - (this.f111s ? 1 : 0)) - m92q(this.f108p, f97l[5]);
                                if (((this.f98a == 0) == this.f111s ? 1 : 0) != 1) {
                                    int q = (this.f114w + 10) + ((-4002 - m92q(this.f108p, "u")) + 44);
                                    int i2 = (this.f110r * 15181) - 88;
                                    if (z) {
                                        i = 1;
                                    }
                                    this.f98a = q + (i2 - i);
                                    this.f114w = (this.f114w - 20) + this.f110r;
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
            z2 = true;
            this.f111s = z2;
            if (z) {
            }
            this.f102g = (((z ? 1 : 0) + 28) + (this.f98a * 50)) - this.f110r;
        } catch (Exception e) {
            this.f107o = (this.f111s ? 1 : 0) + (((z ? 1 : 0) + ((this.f110r * this.f114w) + ((this.f98a * 95) - 762216))) - this.f98a);
            if (this.f99d) {
                if (this.f98a != 0) {
                    this.f111s = false;
                    this.f112t = new int[19];
                } else {
                    this.f111s = false;
                    this.f112t = new int[19];
                }
                this.f112t[9] = (z ? 1 : 0) + m91q(this.f108p);
            } else {
                return;
            }
        }
        if (z) {
        }
        if (this.f99d) {
        }
        switch ((z ? 1 : 0) + ((this.f99d ? 1 : 0) - this.f114w)) {
            case 29:
                this.f115y = f97l[4];
                this.f114w = (this.f107o + 2589) + 17142;
                return;
            case 1464:
                if (this.f99d) {
                }
                if (this.f111s) {
                }
                this.f114w = (((this.f99d ? 1 : 0) + 52) - (this.f111s ? 1 : 0)) - m92q(this.f108p, f97l[5]);
                if (this.f98a == 0) {
                }
                if ((this.f98a == 0) == this.f111s) {
                }
                if (((this.f98a == 0) == this.f111s ? 1 : 0) != 1) {
                    int q2 = (this.f114w + 10) + ((-4002 - m92q(this.f108p, "u")) + 44);
                    int i22 = (this.f110r * 15181) - 88;
                    if (z) {
                        i = 1;
                    }
                    this.f98a = q2 + (i22 - i);
                    this.f114w = (this.f114w - 20) + this.f110r;
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m96q(boolean z, int i, int i2) {
        int i3 = 0;
        m99q();
        int i4 = (((z ? 1 : 0) * 72) + 97) + ((((this.f114w + 70) + 48) - this.f110r) + (-1658 - ((this.f99d ? 1 : 0) * 24)));
        if (this.f111s) {
            i3 = 1;
        }
        i4 += i3 + 5;
    }

    private void m97w(int i) {
        this.f105j = (((this.f99d ? 1 : 0) - 3588) - this.f110r) + this.f114w;
        this.f113u = i - 6123;
        this.f105j = (((this.f107o + 348) + 2145) + 79) - 99;
    }

    private static char[] m98w(String str) {
        char[] toCharArray = str.toCharArray();
        if (toCharArray.length < 2) {
            toCharArray[0] = (char) (toCharArray[0] ^ 87);
        }
        return toCharArray;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate() {
        /*
        r10 = this;
        r9 = 6;
        r2 = 1;
        r8 = 3;
        r7 = 7;
        r1 = 0;
        r0 = 271263564; // 0x102b274c float:3.3754077E-29 double:1.34022008E-315;
        r3 = r10.f114w;
        r3 = 6776 - r3;
        r0 = r0 + r3;
        r0 = r0 + 11;
        r3 = r10.f114w;
        r3 = r3 * 31;
        r0 = r0 - r3;
        r10.f110r = r0;
        r10.m95q(r2);
        r0 = r10.f98a;
        r3 = 58;
        r10.m96q(r2, r0, r3);
        r3 = super.getApplicationContext();
        r0 = r10.f114w;
        r0 = r0 + -4;
        r0 = r0 + -17091;
        r0 = r0 + -58;
        r4 = r10.f98a;
        r0 = r0 + r4;
        r4 = r10.f114w;
        r4 = r4 + 10756;
        r4 = r4 + 83;
        r0 = r0 + r4;
        r10.f103h = r0;
        r0 = r10.f98a;
        if (r0 == 0) goto L_0x0195;
    L_0x003c:
        r0 = r2;
    L_0x003d:
        if (r0 == 0) goto L_0x0043;
    L_0x003f:
        r0 = r10.f99d;
        if (r0 != r2) goto L_0x0198;
    L_0x0043:
        r0 = r2;
    L_0x0044:
        r10.f101f = r0;
        r0 = 94644; // 0x171b4 float:1.32624E-40 double:4.67603E-319;
        r4 = r10.f108p;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r5 = f97l;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r6 = 6;
        r5 = r5[r6];	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r4 = m92q(r4, r5);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r0 + r4;
        r4 = r10.f107o;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r0 + r4;
        r0 = r0 + -11560;
        r4 = r10.f110r;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r4 = r4 * 65;
        r4 = r4 + 40;
        r4 = r4 + r0;
        r5 = r10.f107o;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f99d;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x019b;
    L_0x0067:
        r0 = r2;
    L_0x0068:
        r0 = r0 * 5216;
        r0 = r0 + r5;
        r0 = r0 + 31;
        r0 = r0 + -7;
        r0 = r4 - r0;
        r10.f113u = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = 7;
        r10.f105j = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f105j;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r10.m97w(r0);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r4 = com.sistlias.esnioteh.C0249w.m107q(r3);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f98a;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 != 0) goto L_0x01b0;
    L_0x0083:
        r0 = r10.f110r;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x019e;
    L_0x0087:
        r3 = r2;
    L_0x0088:
        r0 = r10.f110r;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x01a1;
    L_0x008c:
        r0 = r2;
    L_0x008d:
        if (r3 != r0) goto L_0x01b0;
    L_0x008f:
        r0 = r10.f107o;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x01a4;
    L_0x0093:
        r0 = r2;
    L_0x0094:
        if (r0 != r2) goto L_0x00b5;
    L_0x0096:
        r0 = r10.f107o;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x01a7;
    L_0x009a:
        r0 = r2;
    L_0x009b:
        if (r2 != r0) goto L_0x00b5;
    L_0x009d:
        r0 = r10.f108p;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = "o";
        r0 = m92q(r0, r3);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 <= 0) goto L_0x01aa;
    L_0x00a7:
        r3 = r2;
    L_0x00a8:
        r0 = r10.f108p;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r5 = "a";
        r0 = m92q(r0, r5);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 <= 0) goto L_0x01ad;
    L_0x00b2:
        r0 = r2;
    L_0x00b3:
        if (r3 != r0) goto L_0x00b5;
    L_0x00b5:
        r0 = r1;
    L_0x00b6:
        r10.f104i = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f108p;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = f97l;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r5 = 11;
        r3 = r3[r5];	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = m92q(r0, r3);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = 67 - r0;
        r3 = r10.f108p;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = m91q(r3);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r0 + r3;
        r10.f109q = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = r4.m121q();	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = 56;
        r10.f100e = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f100e;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r10.m94q(r0);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r10.m99q();	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f100e;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = 58 - r0;
        r4 = r10.f100e;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r0 + r4;
        r0 = r0 + 18485;
        r0 = r0 + 1222;
        r0 = r0 + 74;
        r0 = r0 + 2116;
        r10.f107o = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r3 == 0) goto L_0x01c0;
    L_0x00f2:
        r0 = r10.f99d;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x01b3;
    L_0x00f6:
        r0 = r2;
    L_0x00f7:
        r0 = 17296 - r0;
        r0 = r0 + 98;
        r4 = r0 + 34;
        r0 = r10.f111s;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x01b6;
    L_0x0101:
        r0 = r2;
    L_0x0102:
        r0 = r0 + 49;
        r0 = r0 + -18293;
        r0 = r0 + -68;
        r0 = r0 + r4;
        r10.f98a = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f107o;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r0 + 57;
        r10.f110r = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = android.app.Instrumentation.newApplication(r3, r10);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r10.f106k = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = 0;
        r10.f104i = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f104i;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r10.m95q(r0);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = f97l;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = 12;
        r0 = r0[r3];	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r10.f115y = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f115y;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = m91q(r0);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f111s;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x01b9;
    L_0x0131:
        r0 = r2;
    L_0x0132:
        r0 = r3 - r0;
        r3 = r10.f114w;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = r3 + 32;
        r3 = r3 + 34;
        r3 = r3 + 31;
        r0 = r0 + r3;
        r10.f107o = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f106k;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0.onCreate();	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f99d;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = r10.f111s;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 != r3) goto L_0x01bc;
    L_0x014a:
        r0 = r2;
    L_0x014b:
        r10.f101f = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f111s;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x01be;
    L_0x0151:
        r0 = r2;
    L_0x0152:
        r0 = r0 * 75;
        r0 = r0 + 52;
        r3 = r10.f98a;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = r3 + 8415;
        r0 = r0 + r3;
        r3 = r10.f110r;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = r3 + 17;
        r4 = 699426; // 0xaac22 float:9.80105E-40 double:3.455624E-318;
        r3 = r3 - r4;
        r0 = r0 - r3;
        r10.f103h = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
    L_0x0166:
        r0 = r10.f99d;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r2 != r0) goto L_0x0275;
    L_0x016a:
        r0 = r2;
    L_0x016b:
        if (r0 != r2) goto L_0x0278;
    L_0x016d:
        r0 = r2;
    L_0x016e:
        r10.f104i = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = f97l;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = 14;
        r0 = r0[r3];	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r10.f108p = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
    L_0x0178:
        r0 = r10.f108p;
        r3 = f97l;
        r4 = 8;
        r3 = r3[r4];
        r0 = m92q(r0, r3);
        r0 = 39 - r0;
        r0 = r0 + 14815;
        r10.f107o = r0;
        r0 = r10.f107o;
        if (r0 == 0) goto L_0x0442;
    L_0x018e:
        r0 = r2;
    L_0x018f:
        if (r2 != r0) goto L_0x0192;
    L_0x0191:
        r1 = r2;
    L_0x0192:
        r10.f111s = r1;
        return;
    L_0x0195:
        r0 = r1;
        goto L_0x003d;
    L_0x0198:
        r0 = r1;
        goto L_0x0044;
    L_0x019b:
        r0 = r1;
        goto L_0x0068;
    L_0x019e:
        r3 = r1;
        goto L_0x0088;
    L_0x01a1:
        r0 = r1;
        goto L_0x008d;
    L_0x01a4:
        r0 = r1;
        goto L_0x0094;
    L_0x01a7:
        r0 = r1;
        goto L_0x009b;
    L_0x01aa:
        r3 = r1;
        goto L_0x00a8;
    L_0x01ad:
        r0 = r1;
        goto L_0x00b3;
    L_0x01b0:
        r0 = r2;
        goto L_0x00b6;
    L_0x01b3:
        r0 = r1;
        goto L_0x00f7;
    L_0x01b6:
        r0 = r1;
        goto L_0x0102;
    L_0x01b9:
        r0 = r1;
        goto L_0x0132;
    L_0x01bc:
        r0 = r1;
        goto L_0x014b;
    L_0x01be:
        r0 = r1;
        goto L_0x0152;
    L_0x01c0:
        r0 = 15;
        r0 = new int[r0];	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r10.f112t = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f112t;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = 7;
        r4 = r10.f98a;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r4 = r4 + 6775;
        r4 = r4 + 7259;
        r0[r3] = r4;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        super.onCreate();	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f114w;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x026c;
    L_0x01d8:
        r0 = r2;
    L_0x01d9:
        if (r2 != r0) goto L_0x01f1;
    L_0x01db:
        r0 = 0;
        r10.f104i = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f104i;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = 14772; // 0x39b4 float:2.07E-41 double:7.2983E-320;
        r4 = 5880; // 0x16f8 float:8.24E-42 double:2.905E-320;
        r10.m96q(r0, r3, r4);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r10.f98a;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        if (r0 == 0) goto L_0x026f;
    L_0x01eb:
        r0 = r2;
    L_0x01ec:
        if (r2 == r0) goto L_0x0272;
    L_0x01ee:
        r0 = r2;
    L_0x01ef:
        r10.f104i = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
    L_0x01f1:
        r0 = r10.f108p;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = f97l;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r4 = 10;
        r3 = r3[r4];	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = m92q(r0, r3);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = r10.f108p;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = m91q(r3);	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r0 = r0 - r3;
        r0 = r0 + 9;
        r0 = r0 + -74;
        r3 = r10.f110r;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = r3 + 83;
        r4 = r10.f107o;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        r3 = r3 + r4;
        r0 = r0 - r3;
        r10.f114w = r0;	 Catch:{ InstantiationException -> 0x0214, IllegalAccessException -> 0x027f, ClassNotFoundException -> 0x02cd }
        goto L_0x0166;
    L_0x0214:
        r0 = move-exception;
        r3 = r10.f107o;
        r3 = r3 * 33;
        r3 = r3 + 9067;
        r10.f102g = r3;
        r10.f101f = r1;
        r3 = r10.f101f;
        r10.m95q(r3);
        r3 = r10.f110r;
        r3 = 1720 - r3;
        r10.f102g = r3;
        r0.printStackTrace();
        r0 = r10.f108p;
        r3 = f97l;
        r4 = 13;
        r3 = r3[r4];
        r0 = m92q(r0, r3);
        r0 = r0 + -5384;
        r3 = r10.f108p;
        r3 = m91q(r3);
        r0 = r0 + r3;
        r0 = r0 + -3924;
        r10.f107o = r0;
        r0 = r10.f98a;
        if (r0 == 0) goto L_0x0178;
    L_0x024a:
        r0 = r10.f98a;
        r3 = r10.f107o;
        r0 = r0 - r3;
        r3 = r0 + 81;
        r0 = r10.f99d;
        if (r0 == 0) goto L_0x027b;
    L_0x0255:
        r0 = r2;
    L_0x0256:
        r0 = r3 - r0;
        r10.f110r = r0;
        r0 = new int[r7];
        r10.f112t = r0;
        r3 = r10.f112t;
        r0 = r10.f99d;
        if (r0 == 0) goto L_0x027d;
    L_0x0264:
        r0 = r2;
    L_0x0265:
        r4 = 5;
        r0 = r0 + 21;
        r3[r4] = r0;
        goto L_0x0178;
    L_0x026c:
        r0 = r1;
        goto L_0x01d9;
    L_0x026f:
        r0 = r1;
        goto L_0x01ec;
    L_0x0272:
        r0 = r1;
        goto L_0x01ef;
    L_0x0275:
        r0 = r1;
        goto L_0x016b;
    L_0x0278:
        r0 = r1;
        goto L_0x016e;
    L_0x027b:
        r0 = r1;
        goto L_0x0256;
    L_0x027d:
        r0 = r1;
        goto L_0x0265;
    L_0x027f:
        r0 = move-exception;
        r3 = r0;
        r0 = r10.f110r;
        if (r0 == 0) goto L_0x02c5;
    L_0x0285:
        r0 = r2;
    L_0x0286:
        r4 = r10.f114w;
        if (r4 == 0) goto L_0x02c7;
    L_0x028a:
        r4 = r2;
    L_0x028b:
        if (r0 != r4) goto L_0x02cb;
    L_0x028d:
        r0 = r10.f107o;
        if (r0 == 0) goto L_0x02c9;
    L_0x0291:
        r0 = r2;
    L_0x0292:
        if (r2 == r0) goto L_0x02cb;
    L_0x0294:
        r0 = r2;
    L_0x0295:
        r10.f99d = r0;
        r10.m95q(r1);
        r0 = f97l;
        r4 = 9;
        r0 = r0[r4];
        r10.f115y = r0;
        r0 = r10.f115y;
        r4 = 55;
        r5 = r10.f114w;
        r10.m100q(r0, r4, r5);
        r3.printStackTrace();
        r0 = 9;
        r0 = new int[r0];
        r10.f112t = r0;
        r0 = r10.f112t;
        r3 = 8;
        r4 = r10.f114w;
        r4 = r4 + -65;
        r5 = r10.f98a;
        r4 = r4 + r5;
        r4 = r4 + -19786;
        r0[r3] = r4;
        goto L_0x0178;
    L_0x02c5:
        r0 = r1;
        goto L_0x0286;
    L_0x02c7:
        r4 = r1;
        goto L_0x028b;
    L_0x02c9:
        r0 = r1;
        goto L_0x0292;
    L_0x02cb:
        r0 = r1;
        goto L_0x0295;
    L_0x02cd:
        r0 = move-exception;
        r3 = r0;
        r0 = r10.f98a;	 Catch:{ all -> 0x034f }
        if (r0 == 0) goto L_0x0347;
    L_0x02d3:
        r0 = r2;
    L_0x02d4:
        if (r0 == r2) goto L_0x0349;
    L_0x02d6:
        r0 = r2;
    L_0x02d7:
        if (r0 == r2) goto L_0x02dd;
    L_0x02d9:
        r0 = r10.f99d;	 Catch:{ all -> 0x034f }
        if (r0 == r2) goto L_0x02dd;
    L_0x02dd:
        r0 = r10.f111s;	 Catch:{ all -> 0x034f }
        if (r0 == 0) goto L_0x034d;
    L_0x02e1:
        r0 = r10.f107o;	 Catch:{ all -> 0x034f }
        if (r0 == 0) goto L_0x034b;
    L_0x02e5:
        r0 = r2;
    L_0x02e6:
        if (r0 != r2) goto L_0x034d;
    L_0x02e8:
        r0 = r2;
    L_0x02e9:
        r10.f104i = r0;	 Catch:{ all -> 0x034f }
        r0 = 1;
        r10.f111s = r0;	 Catch:{ all -> 0x034f }
        r0 = 23;
        r10.f103h = r0;	 Catch:{ all -> 0x034f }
        r0 = r10.f103h;	 Catch:{ all -> 0x034f }
        r10.m97w(r0);	 Catch:{ all -> 0x034f }
        r0 = r10.f99d;
        if (r2 == r0) goto L_0x02fb;
    L_0x02fb:
        r10.f111s = r2;
        r10.m97w(r8);
        r0 = r10.f99d;
        if (r0 == 0) goto L_0x035a;
    L_0x0304:
        r0 = r2;
    L_0x0305:
        r0 = r0 + -72;
        r0 = r0 + -32;
        r4 = r10.f98a;
        r4 = 35 - r4;
        r4 = r4 + -88;
        r4 = r4 + 59;
        r4 = r4 + 22;
        r0 = r0 + r4;
        switch(r0) {
            case 39: goto L_0x03b0;
            case 10967: goto L_0x035c;
            default: goto L_0x0317;
        };
    L_0x0317:
        r3.printStackTrace();
        r0 = r10.f99d;
        if (r0 == 0) goto L_0x03c5;
    L_0x031e:
        r0 = r2;
    L_0x031f:
        r0 = r0 + -29;
        r0 = r0 + -38;
        r0 = r0 + -32;
        switch(r0) {
            case 78: goto L_0x03eb;
            case 3652: goto L_0x03c8;
            case 9670: goto L_0x040d;
            default: goto L_0x0328;
        };
    L_0x0328:
        r0 = r10.f98a;
        r3 = r10.f110r;
        r0 = r0 * r3;
        r3 = r0 + -9975;
        r0 = r10.f99d;
        if (r0 == 0) goto L_0x043c;
    L_0x0333:
        r0 = r2;
    L_0x0334:
        r0 = r0 + r3;
        r3 = r0 + 48;
        r0 = r10.f111s;
        if (r0 == 0) goto L_0x043f;
    L_0x033b:
        r0 = r2;
    L_0x033c:
        r4 = 458065; // 0x6fd51 float:6.41886E-40 double:2.26314E-318;
        r0 = r0 * 1518;
        r0 = r0 + r4;
        r0 = r0 + r3;
        r10.f102g = r0;
        goto L_0x0178;
    L_0x0347:
        r0 = r1;
        goto L_0x02d4;
    L_0x0349:
        r0 = r1;
        goto L_0x02d7;
    L_0x034b:
        r0 = r1;
        goto L_0x02e6;
    L_0x034d:
        r0 = r1;
        goto L_0x02e9;
    L_0x034f:
        r0 = move-exception;
        r1 = r10.f99d;
        if (r2 == r1) goto L_0x0354;
    L_0x0354:
        r10.f111s = r2;
        r10.m97w(r8);
        throw r0;
    L_0x035a:
        r0 = r1;
        goto L_0x0305;
    L_0x035c:
        r0 = r10.f107o;
        r0 = 5597 - r0;
        r0 = r0 + 17230;
        r4 = r0 + 5254;
        r0 = r10.f99d;
        if (r0 == 0) goto L_0x03a8;
    L_0x0368:
        r0 = r2;
    L_0x0369:
        r0 = r4 - r0;
        r4 = r10.f107o;
        r0 = r0 + r4;
        r0 = r0 + 81;
        r4 = r10.f114w;
        r4 = 3 - r4;
        r0 = r0 + r4;
        r4 = r10.f107o;
        r4 = r4 * 18199;
        r4 = r4 + 7905;
        r0 = r0 - r4;
        r10.f109q = r0;
        r0 = r10.f111s;
        if (r0 == 0) goto L_0x03aa;
    L_0x0382:
        r0 = r2;
    L_0x0383:
        r0 = r0 + -34;
        r10.f109q = r0;
        r0 = r10.f111s;
        if (r0 == 0) goto L_0x03ac;
    L_0x038b:
        r0 = r2;
    L_0x038c:
        r0 = 87 - r0;
        r0 = r0 + 5277;
        r4 = r0 + 11;
        r0 = r10.f99d;
        if (r0 == 0) goto L_0x03ae;
    L_0x0396:
        r0 = r2;
    L_0x0397:
        r0 = r0 * 3;
        r5 = r10.f108p;
        r6 = "b";
        r5 = m92q(r5, r6);
        r0 = r0 + r5;
        r0 = r4 - r0;
        r10.f105j = r0;
        goto L_0x0317;
    L_0x03a8:
        r0 = r1;
        goto L_0x0369;
    L_0x03aa:
        r0 = r1;
        goto L_0x0383;
    L_0x03ac:
        r0 = r1;
        goto L_0x038c;
    L_0x03ae:
        r0 = r1;
        goto L_0x0397;
    L_0x03b0:
        r0 = new int[r9];
        r10.f112t = r0;
        r0 = r10.f112t;
        r4 = r10.f98a;
        r4 = r4 * 70;
        r4 = 77 - r4;
        r5 = r10.f107o;
        r5 = 5263 - r5;
        r4 = r4 - r5;
        r0[r8] = r4;
        goto L_0x0317;
    L_0x03c5:
        r0 = r1;
        goto L_0x031f;
    L_0x03c8:
        r10.m95q(r2);
        r0 = 14665; // 0x3949 float:2.055E-41 double:7.2455E-320;
        r10.f105j = r0;
        r0 = r10.f105j;
        r10.m94q(r0);
        r0 = r10.f108p;
        r3 = "s";
        r0 = m92q(r0, r3);
        r0 = r0 + -38;
        r3 = r10.f108p;
        r3 = m91q(r3);
        r0 = r0 + r3;
        r0 = r0 + 21;
        r10.f110r = r0;
        goto L_0x0328;
    L_0x03eb:
        r0 = r10.f107o;
        r0 = r0 * 12339;
        r0 = r0 + 46;
        r10.f102g = r0;
        r0 = r10.f108p;
        r3 = "t";
        r0 = m92q(r0, r3);
        r0 = 65 - r0;
        r3 = r10.f114w;
        r0 = r0 - r3;
        r3 = r10.f107o;
        r3 = r3 * 11;
        r3 = -15205 - r3;
        r3 = r3 + 476;
        r0 = r0 + r3;
        r10.f109q = r0;
        goto L_0x0328;
    L_0x040d:
        r0 = r10.f108p;
        r3 = f97l;
        r3 = r3[r7];
        r0 = m92q(r0, r3);
        r3 = r10.f107o;
        r3 = r3 * 92;
        r4 = r10.f107o;
        r3 = r3 - r4;
        r3 = r3 + -12;
        r0 = r0 + r3;
        r3 = r10.f98a;
        r3 = r3 + 15190;
        r3 = r3 + -8610;
        r0 = r0 + r3;
        r3 = r10.f114w;
        r3 = r3 + 4416;
        r3 = r3 + -83;
        r0 = r0 - r3;
        r10.f100e = r0;
        r0 = r10.f108p;
        r3 = 8276; // 0x2054 float:1.1597E-41 double:4.089E-320;
        r4 = r10.f107o;
        r10.m100q(r0, r3, r4);
        goto L_0x0328;
    L_0x043c:
        r0 = r1;
        goto L_0x0334;
    L_0x043f:
        r0 = r1;
        goto L_0x033c;
    L_0x0442:
        r0 = r1;
        goto L_0x018f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sistlias.esnioteh.ebarenv.onCreate():void");
    }

    public void m99q() {
        int i = 1;
        this.f104i = true;
        m95q(this.f104i);
        int i2 = this.f107o - 10108;
        if (!this.f111s) {
            i = 0;
        }
        this.f100e = i2 - (i * 50);
    }

    public void m100q(String str, int i, int i2) {
        int i3 = 0;
        int i4 = ((((((i2 + 12) - 85) + 54) - this.f114w) + 19165) + 16329) - 68;
        i4 = (((this.f98a + 8497) - (this.f99d ? 1 : 0)) + 90) - this.f98a;
        if (this.f99d) {
            i3 = 1;
        }
        i4 += ((i3 + 19086) + this.f110r) + 4668;
    }
}
