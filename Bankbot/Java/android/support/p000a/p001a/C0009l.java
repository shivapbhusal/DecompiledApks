package android.support.p000a.p001a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class C0009l extends ConstantState {
    boolean f49a;
    ColorStateList f50e;
    Mode f51i;
    int f52o;
    boolean f53p;
    int f54q;
    Mode f55r;
    Paint f56s;
    boolean f57t;
    ColorStateList f58u;
    C0008k f59w;
    Bitmap f60y;

    public C0009l() {
        this.f50e = null;
        this.f55r = C0014s.f73w;
        this.f59w = new C0008k();
    }

    public C0009l(C0009l c0009l) {
        this.f50e = null;
        this.f55r = C0014s.f73w;
        if (c0009l != null) {
            this.f54q = c0009l.f54q;
            this.f59w = new C0008k(c0009l.f59w);
            if (c0009l.f59w.f35d != null) {
                this.f59w.f35d = new Paint(c0009l.f59w.f35d);
            }
            if (c0009l.f59w.f44s != null) {
                this.f59w.f44s = new Paint(c0009l.f59w.f44s);
            }
            this.f50e = c0009l.f50e;
            this.f55r = c0009l.f55r;
            this.f57t = c0009l.f57t;
        }
    }

    public void m32e() {
        this.f58u = this.f50e;
        this.f51i = this.f55r;
        this.f52o = this.f59w.m27q();
        this.f53p = this.f57t;
        this.f49a = false;
    }

    public boolean m33e(int i, int i2) {
        return i == this.f60y.getWidth() && i2 == this.f60y.getHeight();
    }

    public int getChangingConfigurations() {
        return this.f54q;
    }

    public Drawable newDrawable() {
        return new C0014s();
    }

    public Drawable newDrawable(Resources resources) {
        return new C0014s();
    }

    public Paint m34q(ColorFilter colorFilter) {
        if (!m37q() && colorFilter == null) {
            return null;
        }
        if (this.f56s == null) {
            this.f56s = new Paint();
            this.f56s.setFilterBitmap(true);
        }
        this.f56s.setAlpha(this.f59w.m27q());
        this.f56s.setColorFilter(colorFilter);
        return this.f56s;
    }

    public void m35q(int i, int i2) {
        this.f60y.eraseColor(0);
        this.f59w.m30q(new Canvas(this.f60y), i, i2, null);
    }

    public void m36q(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        canvas.drawBitmap(this.f60y, null, rect, m34q(colorFilter));
    }

    public boolean m37q() {
        return this.f59w.m27q() < 255;
    }

    public void m38w(int i, int i2) {
        if (this.f60y == null || !m33e(i, i2)) {
            this.f60y = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.f49a = true;
        }
    }

    public boolean m39w() {
        return !this.f49a && this.f58u == this.f50e && this.f51i == this.f55r && this.f53p == this.f57t && this.f52o == this.f59w.m27q();
    }
}
