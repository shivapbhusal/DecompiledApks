package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompatApi23 {

    public interface Callback extends Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    class CallbackProxy extends CallbackProxy {
        public CallbackProxy(Callback callback) {
            super(callback);
        }

        public void onPlayFromUri(Uri uri, Bundle bundle) {
            ((Callback) this.mCallback).onPlayFromUri(uri, bundle);
        }
    }

    MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
