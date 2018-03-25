package android.support.p000a.p001a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;

@TargetApi(21)
abstract class C0000a extends Drawable {
    Drawable f0q;

    C0000a() {
    }

    static TypedArray m0w(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void clearColorFilter() {
        if (this.f0q != null) {
            this.f0q.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        return this.f0q != null ? this.f0q.getCurrent() : super.getCurrent();
    }

    public int getMinimumHeight() {
        return this.f0q != null ? this.f0q.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f0q != null ? this.f0q.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        return this.f0q != null ? this.f0q.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        return this.f0q != null ? this.f0q.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        return this.f0q != null ? this.f0q.getTransparentRegion() : super.getTransparentRegion();
    }

    public boolean isAutoMirrored() {
        if (this.f0q != null) {
            DrawableCompat.isAutoMirrored(this.f0q);
        }
        return false;
    }

    public void jumpToCurrentState() {
        if (this.f0q != null) {
            DrawableCompat.jumpToCurrentState(this.f0q);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f0q != null) {
            this.f0q.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f0q != null ? this.f0q.setLevel(i) : super.onLevelChange(i);
    }

    public void setAutoMirrored(boolean z) {
        if (this.f0q != null) {
            DrawableCompat.setAutoMirrored(this.f0q, z);
        }
    }

    public void setChangingConfigurations(int i) {
        if (this.f0q != null) {
            this.f0q.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f0q != null) {
            this.f0q.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f0q != null) {
            this.f0q.setFilterBitmap(z);
        }
    }

    public boolean setState(int[] iArr) {
        return this.f0q != null ? this.f0q.setState(iArr) : super.setState(iArr);
    }
}
