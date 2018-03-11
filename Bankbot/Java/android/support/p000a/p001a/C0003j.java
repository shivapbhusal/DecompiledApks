package android.support.p000a.p001a;

import android.graphics.Path;

class C0003j {
    protected C0010o[] f2d = null;
    String f3f;
    int f4g;

    public C0003j(C0003j c0003j) {
        this.f3f = c0003j.f3f;
        this.f4g = c0003j.f4g;
        this.f2d = C0018y.m73q(c0003j.f2d);
    }

    public void m1q(Path path) {
        path.reset();
        if (this.f2d != null) {
            C0010o.m43q(this.f2d, path);
        }
    }

    public boolean mo1q() {
        return false;
    }

    public String m3w() {
        return this.f3f;
    }
}
