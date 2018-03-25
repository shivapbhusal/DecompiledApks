package android.support.v4.content;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public final class SharedPreferencesCompat {

    public final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper;

        interface Helper {
            void apply(Editor editor);
        }

        class EditorHelperApi9Impl implements Helper {
            private EditorHelperApi9Impl() {
            }

            public void apply(Editor editor) {
                EditorCompatGingerbread.apply(editor);
            }
        }

        class EditorHelperBaseImpl implements Helper {
            private EditorHelperBaseImpl() {
            }

            public void apply(Editor editor) {
                editor.commit();
            }
        }

        private EditorCompat() {
            if (VERSION.SDK_INT >= 9) {
                this.mHelper = new EditorHelperApi9Impl();
            } else {
                this.mHelper = new EditorHelperBaseImpl();
            }
        }

        public static EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new EditorCompat();
            }
            return sInstance;
        }

        public void apply(Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
