package android.support.p000a.p001a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;

class C0019z extends ConstantState {
    private final ConstantState f88q;

    public C0019z(ConstantState constantState) {
        this.f88q = constantState;
    }

    public int getChangingConfigurations() {
        return this.f88q.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        Drawable c0014s = new C0014s();
        c0014s.q = (VectorDrawable) this.f88q.newDrawable();
        return c0014s;
    }

    public Drawable newDrawable(Resources resources) {
        Drawable c0014s = new C0014s();
        c0014s.q = (VectorDrawable) this.f88q.newDrawable(resources);
        return c0014s;
    }
}
