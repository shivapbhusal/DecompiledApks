package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Parcel;

class MediaBrowserCompatApi23 {

    interface ItemCallback {
        void onError(String str);

        void onItemLoaded(Parcel parcel);
    }

    class ItemCallbackProxy extends android.media.browse.MediaBrowser.ItemCallback {
        protected final ItemCallback mItemCallback;

        public ItemCallbackProxy(ItemCallback itemCallback) {
            this.mItemCallback = itemCallback;
        }

        public void onError(String str) {
            this.mItemCallback.onError(str);
        }

        public void onItemLoaded(MediaItem mediaItem) {
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            this.mItemCallback.onItemLoaded(obtain);
        }
    }

    MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback itemCallback) {
        return new ItemCallbackProxy(itemCallback);
    }

    public static void getItem(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (android.media.browse.MediaBrowser.ItemCallback) obj2);
    }
}
