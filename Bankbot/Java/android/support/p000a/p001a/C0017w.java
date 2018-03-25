package android.support.p000a.p001a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
public class C0017w extends C0000a implements Animatable {
    private Context f84e;
    private ArgbEvaluator f85r;
    private final Callback f86t;
    private C0013r f87w;

    private C0017w() {
        this(null, null, null);
    }

    private C0017w(Context context) {
        this(context, null, null);
    }

    private C0017w(Context context, C0013r c0013r, Resources resources) {
        this.f85r = null;
        this.f86t = new C0002e(this);
        this.f84e = context;
        if (c0013r != null) {
            this.f87w = c0013r;
        } else {
            this.f87w = new C0013r(context, c0013r, this.f86t, resources);
        }
    }

    static TypedArray m61q(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static C0017w m63q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0017w c0017w = new C0017w(context);
        c0017w.m67q(resources, xmlPullParser, attributeSet, theme);
        return c0017w;
    }

    private void m64q(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m64q((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f85r == null) {
                    this.f85r = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f85r);
            }
        }
    }

    private void m65q(String str, Animator animator) {
        animator.setTarget(this.f87w.f72w.m58q(str));
        if (VERSION.SDK_INT < 21) {
            m64q(animator);
        }
        if (this.f87w.f69e == null) {
            this.f87w.f69e = new ArrayList();
            this.f87w.f71r = new ArrayMap();
        }
        this.f87w.f69e.add(animator);
        this.f87w.f71r.put(animator, str);
    }

    private boolean m66q() {
        ArrayList arrayList = this.f87w.f69e;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.q != null) {
            this.q.draw(canvas);
            return;
        }
        this.f87w.f72w.draw(canvas);
        if (m66q()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.q != null ? DrawableCompat.getAlpha(this.q) : this.f87w.f72w.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.q != null ? this.q.getChangingConfigurations() : super.getChangingConfigurations() | this.f87w.f70q;
    }

    public ConstantState getConstantState() {
        return this.q != null ? new C0015t(this.q.getConstantState()) : null;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.q != null ? this.q.getIntrinsicHeight() : this.f87w.f72w.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.q != null ? this.q.getIntrinsicWidth() : this.f87w.f72w.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.q != null ? this.q.getOpacity() : this.f87w.f72w.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        m67q(resources, xmlPullParser, attributeSet, null);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isRunning() {
        if (this.q != null) {
            return ((AnimatedVectorDrawable) this.q).isRunning();
        }
        ArrayList arrayList = this.f87w.f69e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStateful() {
        return this.q != null ? this.q.isStateful() : this.f87w.f72w.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.q != null) {
            this.q.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    protected void onBoundsChange(Rect rect) {
        if (this.q != null) {
            this.q.setBounds(rect);
        } else {
            this.f87w.f72w.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.q != null ? this.q.setLevel(i) : this.f87w.f72w.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        return this.q != null ? this.q.setState(iArr) : this.f87w.f72w.setState(iArr);
    }

    public void m67q(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.q != null) {
            DrawableCompat.inflate(this.q, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray q;
                if ("animated-vector".equals(name)) {
                    q = C0017w.m61q(resources, theme, attributeSet, C0012q.f66t);
                    int resourceId = q.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0014s q2 = C0014s.m52q(resources, resourceId, theme);
                        q2.m59q(false);
                        q2.setCallback(this.f86t);
                        if (this.f87w.f72w != null) {
                            this.f87w.f72w.setCallback(null);
                        }
                        this.f87w.f72w = q2;
                    }
                    q.recycle();
                } else if ("target".equals(name)) {
                    q = resources.obtainAttributes(attributeSet, C0012q.f68y);
                    String string = q.getString(0);
                    int resourceId2 = q.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f84e != null) {
                            m65q(string, AnimatorInflater.loadAnimator(this.f84e, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    q.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public void setAlpha(int i) {
        if (this.q != null) {
            this.q.setAlpha(i);
        } else {
            this.f87w.f72w.setAlpha(i);
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.q != null) {
            this.q.setColorFilter(colorFilter);
        } else {
            this.f87w.f72w.setColorFilter(colorFilter);
        }
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.q != null) {
            return this.q.setVisible(z, z2);
        }
        this.f87w.f72w.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.q != null) {
            ((AnimatedVectorDrawable) this.q).start();
        } else if (!m66q()) {
            ArrayList arrayList = this.f87w.f69e;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.q != null) {
            ((AnimatedVectorDrawable) this.q).stop();
            return;
        }
        ArrayList arrayList = this.f87w.f69e;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
