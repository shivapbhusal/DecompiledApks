package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ViewPropertyAnimatorCompatJB {

    final class C01401 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimatorListener val$listener;
        final /* synthetic */ View val$view;

        C01401(ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            this.val$listener = viewPropertyAnimatorListener;
            this.val$view = view;
        }

        public void onAnimationCancel(Animator animator) {
            this.val$listener.onAnimationCancel(this.val$view);
        }

        public void onAnimationEnd(Animator animator) {
            this.val$listener.onAnimationEnd(this.val$view);
        }

        public void onAnimationStart(Animator animator) {
            this.val$listener.onAnimationStart(this.val$view);
        }
    }

    ViewPropertyAnimatorCompatJB() {
    }

    public static void setListener(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            view.animate().setListener(new C01401(viewPropertyAnimatorListener, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public static void withEndAction(View view, Runnable runnable) {
        view.animate().withEndAction(runnable);
    }

    public static void withLayer(View view) {
        view.animate().withLayer();
    }

    public static void withStartAction(View view, Runnable runnable) {
        view.animate().withStartAction(runnable);
    }
}
