package com.dedett.qqzan;

import adrt.ADRTLogCatReader;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        Bundle bundle2 = bundle;
        ADRTLogCatReader.onContext(this, "com.aide.ui");
        super.onCreate(bundle2);
        boolean requestWindowFeature = requestWindowFeature(1);
        setContentView(C0000R.layout.main);
        Intent intent = r12;
        Intent intent2 = new Intent();
        try {
            ComponentName startService = startService(intent.setClass(this, Class.forName("com.dedett.qqzan.Floatw")));
        } catch (Throwable e) {
            Throwable th = e;
            NoClassDefFoundError noClassDefFoundError = r12;
            NoClassDefFoundError noClassDefFoundError2 = new NoClassDefFoundError(th.getMessage());
            throw noClassDefFoundError;
        }
    }

    public MainActivity() {
        Activity activity = this;
    }
}
