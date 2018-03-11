package android.support.p000a.p001a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public class C0014s extends C0000a {
    static final Mode f73w = Mode.SRC_IN;
    private final Rect f74a;
    private C0009l f75e;
    private ConstantState f76i;
    private final float[] f77o;
    private final Matrix f78p;
    private PorterDuffColorFilter f79r;
    private ColorFilter f80t;
    private boolean f81u;
    private boolean f82y;

    private C0014s() {
        this.f81u = true;
        this.f77o = new float[9];
        this.f78p = new Matrix();
        this.f74a = new Rect();
        this.f75e = new C0009l();
    }

    private C0014s(C0009l c0009l) {
        this.f81u = true;
        this.f77o = new float[9];
        this.f78p = new Matrix();
        this.f74a = new Rect();
        this.f75e = c0009l;
        this.f79r = m57q(this.f79r, c0009l.f50e, c0009l.f55r);
    }

    private void m49e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0009l c0009l = this.f75e;
        C0008k c0008k = c0009l.f59w;
        Stack stack = new Stack();
        stack.push(c0008k.f39h);
        int eventType = xmlPullParser.getEventType();
        Object obj = 1;
        while (eventType != 1) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0006h c0006h = (C0006h) stack.peek();
                if ("path".equals(name)) {
                    C0005g c0005g = new C0005g();
                    c0005g.m10q(resources, attributeSet, theme, xmlPullParser);
                    c0006h.f24q.add(c0005g);
                    if (c0005g.m3w() != null) {
                        c0008k.f46u.put(c0005g.m3w(), c0005g);
                    }
                    obj2 = null;
                    c0009l.f54q = c0005g.g | c0009l.f54q;
                } else if ("clip-path".equals(name)) {
                    C0004f c0004f = new C0004f();
                    c0004f.m5q(resources, attributeSet, theme, xmlPullParser);
                    c0006h.f24q.add(c0004f);
                    if (c0004f.m3w() != null) {
                        c0008k.f46u.put(c0004f.m3w(), c0004f);
                    }
                    c0009l.f54q |= c0004f.g;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0006h c0006h2 = new C0006h();
                        c0006h2.m17q(resources, attributeSet, theme, xmlPullParser);
                        c0006h.f24q.add(c0006h2);
                        stack.push(c0006h2);
                        if (c0006h2.m16q() != null) {
                            c0008k.f46u.put(c0006h2.m16q(), c0006h2);
                        }
                        c0009l.f54q |= c0006h2.f18a;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    private static Mode m51q(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case MotionEventCompat.AXIS_RZ /*14*/:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    public static C0014s m52q(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            C0014s c0014s = new C0014s();
            c0014s.q = ResourcesCompat.getDrawable(resources, i, theme);
            c0014s.f76i = new C0019z(c0014s.q.getConstantState());
            return c0014s;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C0014s.m53q(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static C0014s m53q(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0014s c0014s = new C0014s();
        c0014s.m60w(resources, xmlPullParser, attributeSet, theme);
        return c0014s;
    }

    private void m54q(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0009l c0009l = this.f75e;
        C0008k c0008k = c0009l.f59w;
        c0009l.f55r = C0014s.m51q(C0011p.m45q(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0009l.f50e = colorStateList;
        }
        c0009l.f57t = C0011p.m46q(typedArray, xmlPullParser, "autoMirrored", 5, c0009l.f57t);
        c0008k.f36e = C0011p.m44q(typedArray, xmlPullParser, "viewportWidth", 7, c0008k.f36e);
        c0008k.f43r = C0011p.m44q(typedArray, xmlPullParser, "viewportHeight", 8, c0008k.f43r);
        if (c0008k.f36e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0008k.f43r <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0008k.f42q = typedArray.getDimension(3, c0008k.f42q);
            c0008k.f47w = typedArray.getDimension(2, c0008k.f47w);
            if (c0008k.f42q <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0008k.f47w <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0008k.m28q(C0011p.m44q(typedArray, xmlPullParser, "alpha", 4, c0008k.m31w()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0008k.f48y = string;
                    c0008k.f46u.put(string, c0008k);
                }
            }
        }
    }

    private boolean m55q() {
        return false;
    }

    private static int m56w(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (ViewCompat.MEASURED_SIZE_MASK & i);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.q != null) {
            this.q.draw(canvas);
            return;
        }
        copyBounds(this.f74a);
        if (this.f74a.width() > 0 && this.f74a.height() > 0) {
            ColorFilter colorFilter = this.f80t == null ? this.f79r : this.f80t;
            canvas.getMatrix(this.f78p);
            this.f78p.getValues(this.f77o);
            float abs = Math.abs(this.f77o[0]);
            float abs2 = Math.abs(this.f77o[4]);
            float abs3 = Math.abs(this.f77o[1]);
            float abs4 = Math.abs(this.f77o[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f74a.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.f74a.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f74a.left, (float) this.f74a.top);
                if (m55q()) {
                    canvas.translate((float) this.f74a.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f74a.offsetTo(0, 0);
                this.f75e.m38w(min, height);
                if (!this.f81u) {
                    this.f75e.m35q(min, height);
                } else if (!this.f75e.m39w()) {
                    this.f75e.m35q(min, height);
                    this.f75e.m32e();
                }
                this.f75e.m36q(canvas, colorFilter, this.f74a);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.q != null ? DrawableCompat.getAlpha(this.q) : this.f75e.f59w.m27q();
    }

    public int getChangingConfigurations() {
        return this.q != null ? this.q.getChangingConfigurations() : super.getChangingConfigurations() | this.f75e.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (this.q != null) {
            return new C0019z(this.q.getConstantState());
        }
        this.f75e.f54q = getChangingConfigurations();
        return this.f75e;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.q != null ? this.q.getIntrinsicHeight() : (int) this.f75e.f59w.f47w;
    }

    public int getIntrinsicWidth() {
        return this.q != null ? this.q.getIntrinsicWidth() : (int) this.f75e.f59w.f42q;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.q != null ? this.q.getOpacity() : -3;
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
        if (this.q != null) {
            this.q.inflate(resources, xmlPullParser, attributeSet);
        } else {
            m60w(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void invalidateSelf() {
        if (this.q != null) {
            this.q.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.q != null ? this.q.isStateful() : super.isStateful() || !(this.f75e == null || this.f75e.f50e == null || !this.f75e.f50e.isStateful());
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.q != null) {
            this.q.mutate();
        } else if (!this.f82y && super.mutate() == this) {
            this.f75e = new C0009l(this.f75e);
            this.f82y = true;
        }
        return this;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.q != null) {
            return this.q.setState(iArr);
        }
        C0009l c0009l = this.f75e;
        if (c0009l.f50e == null || c0009l.f55r == null) {
            return false;
        }
        this.f79r = m57q(this.f79r, c0009l.f50e, c0009l.f55r);
        invalidateSelf();
        return true;
    }

    PorterDuffColorFilter m57q(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object m58q(String str) {
        return this.f75e.f59w.f46u.get(str);
    }

    void m59q(boolean z) {
        this.f81u = z;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.q != null) {
            this.q.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.q != null) {
            this.q.setAlpha(i);
        } else if (this.f75e.f59w.m27q() != i) {
            this.f75e.f59w.m29q(i);
            invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        if (this.q != null) {
            this.q.setBounds(i, i2, i3, i4);
        } else {
            super.setBounds(i, i2, i3, i4);
        }
    }

    public void setBounds(Rect rect) {
        if (this.q != null) {
            this.q.setBounds(rect);
        } else {
            super.setBounds(rect);
        }
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
            return;
        }
        this.f80t = colorFilter;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.q != null ? this.q.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.q != null) {
            this.q.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public void m60w(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.q != null) {
            DrawableCompat.inflate(this.q, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0009l c0009l = this.f75e;
        c0009l.f59w = new C0008k();
        TypedArray w = C0000a.m0w(resources, theme, attributeSet, C0012q.f64q);
        m54q(w, xmlPullParser);
        w.recycle();
        c0009l.f54q = getChangingConfigurations();
        c0009l.f49a = true;
        m49e(resources, xmlPullParser, attributeSet, theme);
        this.f79r = m57q(this.f79r, c0009l.f50e, c0009l.f55r);
    }
}
