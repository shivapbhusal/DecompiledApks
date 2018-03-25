package android.support.p000a.p001a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class C0002e implements Callback {
    final /* synthetic */ C0017w f1q;

    C0002e(C0017w c0017w) {
        this.f1q = c0017w;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f1q.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f1q.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f1q.unscheduleSelf(runnable);
    }
}
