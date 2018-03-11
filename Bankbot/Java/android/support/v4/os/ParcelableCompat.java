package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ParcelableCompat {

    class CompatCreator implements Creator {
        final ParcelableCompatCreatorCallbacks mCallbacks;

        public CompatCreator(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
            this.mCallbacks = parcelableCompatCreatorCallbacks;
        }

        public Object createFromParcel(Parcel parcel) {
            return this.mCallbacks.createFromParcel(parcel, null);
        }

        public Object[] newArray(int i) {
            return this.mCallbacks.newArray(i);
        }
    }

    private ParcelableCompat() {
    }

    public static Creator newCreator(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        return VERSION.SDK_INT >= 13 ? ParcelableCompatCreatorHoneycombMR2Stub.instantiate(parcelableCompatCreatorCallbacks) : new CompatCreator(parcelableCompatCreatorCallbacks);
    }
}
