package com.dedett.qqzan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String action_boot = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        BootBroadcastReceiver bootBroadcastReceiver = this;
        Context context2 = context;
        if (intent.getAction().equals(action_boot)) {
            Intent intent2 = r8;
            Intent intent3 = intent3;
            try {
                intent3 = new Intent(context2, Class.forName("com.dedett.qqzan.MainActivity"));
                Intent intent4 = intent2;
                intent2 = intent4.addFlags(268435456);
                context2.startActivity(intent4);
            } catch (Throwable e) {
                Throwable th = e;
                NoClassDefFoundError noClassDefFoundError = r14;
                NoClassDefFoundError noClassDefFoundError2 = new NoClassDefFoundError(th.getMessage());
                throw noClassDefFoundError;
            }
        }
    }

    public BootBroadcastReceiver() {
        BroadcastReceiver broadcastReceiver = this;
    }
}
