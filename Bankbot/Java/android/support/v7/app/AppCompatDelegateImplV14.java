package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper.CallbackWrapper;
import android.util.Log;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class AppCompatDelegateImplV14 extends AppCompatDelegateImplV11 {
    private static final String KEY_LOCAL_NIGHT_MODE = "appcompat:local_night_mode";
    private static TwilightManager sTwilightManager;
    private boolean mApplyDayNightCalled;
    private boolean mHandleNativeActionModes = true;
    private int mLocalNightMode = -100;

    class AppCompatWindowCallbackV14 extends AppCompatWindowCallbackBase {
        AppCompatWindowCallbackV14(Callback callback) {
            super(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return AppCompatDelegateImplV14.this.isHandleNativeActionModesEnabled() ? startAsSupportActionMode(callback) : super.onWindowStartingActionMode(callback);
        }

        final ActionMode startAsSupportActionMode(ActionMode.Callback callback) {
            Object callbackWrapper = new CallbackWrapper(AppCompatDelegateImplV14.this.mContext, callback);
            android.support.v7.view.ActionMode startSupportActionMode = AppCompatDelegateImplV14.this.startSupportActionMode(callbackWrapper);
            return startSupportActionMode != null ? callbackWrapper.getActionModeWrapper(startSupportActionMode) : null;
        }
    }

    AppCompatDelegateImplV14(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    private int getNightModeToApply() {
        return mapNightModeToYesNo(this.mLocalNightMode == -100 ? AppCompatDelegate.getDefaultNightMode() : this.mLocalNightMode);
    }

    private TwilightManager getTwilightManager() {
        if (sTwilightManager == null) {
            sTwilightManager = new TwilightManager(this.mContext.getApplicationContext());
        }
        return sTwilightManager;
    }

    private int mapNightModeToYesNo(int i) {
        switch (i) {
            case -1:
                switch (((UiModeManager) this.mContext.getSystemService("uimode")).getNightMode()) {
                    case 0:
                        return 0;
                    case 2:
                        return 2;
                    default:
                        return 1;
                }
            case 0:
                return getTwilightManager().isNight() ? 2 : 1;
            case 2:
                return 2;
            default:
                return 1;
        }
    }

    private boolean updateConfigurationForNightMode(int i) {
        int i2;
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        int i3 = configuration.uiMode & 48;
        switch (i) {
            case 1:
                i2 = 16;
                break;
            case 2:
                i2 = 32;
                break;
            default:
                i2 = 0;
                break;
        }
        if (i3 == i2) {
            return false;
        }
        configuration.uiMode = (configuration.uiMode & -49) | i2;
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return true;
    }

    public boolean applyDayNight() {
        this.mApplyDayNightCalled = true;
        return updateConfigurationForNightMode(getNightModeToApply());
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && this.mLocalNightMode == -100) {
            this.mLocalNightMode = bundle.getInt(KEY_LOCAL_NIGHT_MODE, -100);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mLocalNightMode != -100) {
            bundle.putInt(KEY_LOCAL_NIGHT_MODE, this.mLocalNightMode);
        }
    }

    public void setHandleNativeActionModesEnabled(boolean z) {
        this.mHandleNativeActionModes = z;
    }

    public void setLocalNightMode(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
                if (this.mLocalNightMode != i) {
                    this.mLocalNightMode = i;
                    if (this.mApplyDayNightCalled) {
                        applyDayNight();
                        return;
                    }
                    return;
                }
                return;
            default:
                Log.d("AppCompatDelegate", "setLocalNightMode() called with an unknown mode");
                return;
        }
    }

    Callback wrapWindowCallback(Callback callback) {
        return new AppCompatWindowCallbackV14(callback);
    }
}
