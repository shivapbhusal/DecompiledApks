package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperDonut.DrawableWrapperState;

class DrawableWrapperHoneycomb extends DrawableWrapperDonut {

    class DrawableWrapperStateHoneycomb extends DrawableWrapperState {
        DrawableWrapperStateHoneycomb(DrawableWrapperState drawableWrapperState, Resources resources) {
            super(drawableWrapperState, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new DrawableWrapperHoneycomb(this, resources);
        }
    }

    DrawableWrapperHoneycomb(Drawable drawable) {
        super(drawable);
    }

    DrawableWrapperHoneycomb(DrawableWrapperState drawableWrapperState, Resources resources) {
        super(drawableWrapperState, resources);
    }

    public void jumpToCurrentState() {
        this.mDrawable.jumpToCurrentState();
    }

    DrawableWrapperState mutateConstantState() {
        return new DrawableWrapperStateHoneycomb(this.mState, null);
    }
}
