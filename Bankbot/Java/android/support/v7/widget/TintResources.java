package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class TintResources extends Resources {
    private final Context mContext;

    public TintResources(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mContext = context;
    }

    public Drawable getDrawable(int i) {
        return AppCompatDrawableManager.get().onDrawableLoadedFromResources(this.mContext, this, i);
    }

    final Drawable superGetDrawable(int i) {
        return super.getDrawable(i);
    }
}
