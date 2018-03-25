package android.support.p000a.p001a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class C0015t extends ConstantState {
    private final ConstantState f83q;

    public C0015t(ConstantState constantState) {
        this.f83q = constantState;
    }

    public int getChangingConfigurations() {
        return this.f83q.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        C0017w c0017w = new C0017w();
        c0017w.q = this.f83q.newDrawable();
        c0017w.q.setCallback(c0017w.f86t);
        return c0017w;
    }

    public Drawable newDrawable(Resources resources) {
        C0017w c0017w = new C0017w();
        c0017w.q = this.f83q.newDrawable(resources);
        c0017w.q.setCallback(c0017w.f86t);
        return c0017w;
    }
}
