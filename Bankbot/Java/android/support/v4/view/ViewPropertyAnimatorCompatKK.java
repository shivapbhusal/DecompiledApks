package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class ViewPropertyAnimatorCompatKK {

    final class C01411 implements AnimatorUpdateListener {
        final /* synthetic */ ViewPropertyAnimatorUpdateListener val$listener;
        final /* synthetic */ View val$view;

        C01411(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
            this.val$listener = viewPropertyAnimatorUpdateListener;
            this.val$view = view;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$listener.onAnimationUpdate(this.val$view);
        }
    }

    ViewPropertyAnimatorCompatKK() {
    }

    public static void setUpdateListener(View view, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        AnimatorUpdateListener animatorUpdateListener = null;
        if (viewPropertyAnimatorUpdateListener != null) {
            animatorUpdateListener = new C01411(viewPropertyAnimatorUpdateListener, view);
        }
        view.animate().setUpdateListener(animatorUpdateListener);
    }
}
