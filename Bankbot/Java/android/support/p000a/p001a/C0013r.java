package android.support.p000a.p001a;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.ArrayMap;
import java.util.ArrayList;

class C0013r extends ConstantState {
    ArrayList f69e;
    int f70q;
    ArrayMap f71r;
    C0014s f72w;

    public C0013r(Context context, C0013r c0013r, Callback callback, Resources resources) {
        int i = 0;
        if (c0013r != null) {
            this.f70q = c0013r.f70q;
            if (c0013r.f72w != null) {
                ConstantState constantState = c0013r.f72w.getConstantState();
                if (resources != null) {
                    this.f72w = (C0014s) constantState.newDrawable(resources);
                } else {
                    this.f72w = (C0014s) constantState.newDrawable();
                }
                this.f72w = (C0014s) this.f72w.mutate();
                this.f72w.setCallback(callback);
                this.f72w.setBounds(c0013r.f72w.getBounds());
                this.f72w.m59q(false);
            }
            if (c0013r.f69e != null) {
                int size = c0013r.f69e.size();
                this.f69e = new ArrayList(size);
                this.f71r = new ArrayMap(size);
                while (i < size) {
                    Animator animator = (Animator) c0013r.f69e.get(i);
                    Animator clone = animator.clone();
                    String str = (String) c0013r.f71r.get(animator);
                    clone.setTarget(this.f72w.m58q(str));
                    this.f69e.add(clone);
                    this.f71r.put(clone, str);
                    i++;
                }
            }
        }
    }

    public int getChangingConfigurations() {
        return this.f70q;
    }

    public Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 21.");
    }

    public Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 21.");
    }
}
