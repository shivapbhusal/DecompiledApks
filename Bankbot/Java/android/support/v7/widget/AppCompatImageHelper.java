package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.ImageView;

class AppCompatImageHelper {
    private final AppCompatDrawableManager mDrawableManager;
    private final ImageView mView;

    AppCompatImageHelper(ImageView imageView, AppCompatDrawableManager appCompatDrawableManager) {
        this.mView = imageView;
        this.mDrawableManager = appCompatDrawableManager;
    }

    void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatImageView_android_src);
            if (drawableIfKnown != null) {
                this.mView.setImageDrawable(drawableIfKnown);
            }
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
            if (resourceId != -1) {
                drawableIfKnown = this.mDrawableManager.getDrawable(this.mView.getContext(), resourceId);
                if (drawableIfKnown != null) {
                    this.mView.setImageDrawable(drawableIfKnown);
                }
            }
            drawableIfKnown = this.mView.getDrawable();
            if (drawableIfKnown != null) {
                DrawableUtils.fixDrawable(drawableIfKnown);
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void setImageResource(int i) {
        if (i != 0) {
            Drawable drawable = this.mDrawableManager != null ? this.mDrawableManager.getDrawable(this.mView.getContext(), i) : ContextCompat.getDrawable(this.mView.getContext(), i);
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            this.mView.setImageDrawable(drawable);
            return;
        }
        this.mView.setImageDrawable(null);
    }
}
