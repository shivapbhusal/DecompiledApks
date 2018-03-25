package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.v4.view.MotionEventCompat;
import java.util.Locale;

public final class TextUtilsCompat {
    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final TextUtilsCompatImpl IMPL;
    public static final Locale ROOT = new Locale("", "");

    class TextUtilsCompatImpl {
        private TextUtilsCompatImpl() {
        }

        private static int getLayoutDirectionFromFirstChar(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case (byte) 1:
                case (byte) 2:
                    return 1;
                default:
                    return 0;
            }
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            if (!(locale == null || locale.equals(TextUtilsCompat.ROOT))) {
                String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
                if (maximizeAndGetScript == null) {
                    return getLayoutDirectionFromFirstChar(locale);
                }
                if (maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.ARAB_SCRIPT_SUBTAG) || maximizeAndGetScript.equalsIgnoreCase(TextUtilsCompat.HEBR_SCRIPT_SUBTAG)) {
                    return 1;
                }
            }
            return 0;
        }

        public String htmlEncode(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                switch (charAt) {
                    case MotionEventCompat.AXIS_GENERIC_3 /*34*/:
                        stringBuilder.append("&quot;");
                        break;
                    case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                        stringBuilder.append("&amp;");
                        break;
                    case MotionEventCompat.AXIS_GENERIC_8 /*39*/:
                        stringBuilder.append("&#39;");
                        break;
                    case '<':
                        stringBuilder.append("&lt;");
                        break;
                    case '>':
                        stringBuilder.append("&gt;");
                        break;
                    default:
                        stringBuilder.append(charAt);
                        break;
                }
            }
            return stringBuilder.toString();
        }
    }

    class TextUtilsCompatJellybeanMr1Impl extends TextUtilsCompatImpl {
        private TextUtilsCompatJellybeanMr1Impl() {
            super();
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            return TextUtilsCompatJellybeanMr1.getLayoutDirectionFromLocale(locale);
        }

        public String htmlEncode(String str) {
            return TextUtilsCompatJellybeanMr1.htmlEncode(str);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            IMPL = new TextUtilsCompatJellybeanMr1Impl();
        } else {
            IMPL = new TextUtilsCompatImpl();
        }
    }

    private TextUtilsCompat() {
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return IMPL.getLayoutDirectionFromLocale(locale);
    }

    public static String htmlEncode(String str) {
        return IMPL.htmlEncode(str);
    }
}
