package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertController.AlertParams;
import android.support.v7.appcompat.R;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    private AlertController mAlert;

    public class Builder {
        private final AlertParams f94P;
        private int mTheme;

        public Builder(Context context) {
            this(context, AlertDialog.resolveDialogTheme(context, 0));
        }

        public Builder(Context context, int i) {
            this.f94P = new AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f94P.mContext, this.mTheme, false);
            this.f94P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.f94P.mCancelable);
            if (this.f94P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f94P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.f94P.mOnDismissListener);
            if (this.f94P.mOnKeyListener != null) {
                alertDialog.setOnKeyListener(this.f94P.mOnKeyListener);
            }
            return alertDialog;
        }

        public Context getContext() {
            return this.f94P.mContext;
        }

        public Builder setAdapter(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f94P.mAdapter = listAdapter;
            this.f94P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f94P.mCancelable = z;
            return this;
        }

        public Builder setCursor(Cursor cursor, OnClickListener onClickListener, String str) {
            this.f94P.mCursor = cursor;
            this.f94P.mLabelColumn = str;
            this.f94P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.f94P.mCustomTitleView = view;
            return this;
        }

        public Builder setIcon(int i) {
            this.f94P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.f94P.mIcon = drawable;
            return this;
        }

        public Builder setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f94P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.f94P.mIconId = typedValue.resourceId;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean z) {
            this.f94P.mForceInverseBackground = z;
            return this;
        }

        public Builder setItems(int i, OnClickListener onClickListener) {
            this.f94P.mItems = this.f94P.mContext.getResources().getTextArray(i);
            this.f94P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, OnClickListener onClickListener) {
            this.f94P.mItems = charSequenceArr;
            this.f94P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMessage(int i) {
            this.f94P.mMessage = this.f94P.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.f94P.mMessage = charSequence;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f94P.mItems = this.f94P.mContext.getResources().getTextArray(i);
            this.f94P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f94P.mCheckedItems = zArr;
            this.f94P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f94P.mCursor = cursor;
            this.f94P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f94P.mIsCheckedColumn = str;
            this.f94P.mLabelColumn = str2;
            this.f94P.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.f94P.mItems = charSequenceArr;
            this.f94P.mOnCheckboxClickListener = onMultiChoiceClickListener;
            this.f94P.mCheckedItems = zArr;
            this.f94P.mIsMultiChoice = true;
            return this;
        }

        public Builder setNegativeButton(int i, OnClickListener onClickListener) {
            this.f94P.mNegativeButtonText = this.f94P.mContext.getText(i);
            this.f94P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f94P.mNegativeButtonText = charSequence;
            this.f94P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, OnClickListener onClickListener) {
            this.f94P.mNeutralButtonText = this.f94P.mContext.getText(i);
            this.f94P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f94P.mNeutralButtonText = charSequence;
            this.f94P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            this.f94P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener) {
            this.f94P.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
            this.f94P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            this.f94P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setPositiveButton(int i, OnClickListener onClickListener) {
            this.f94P.mPositiveButtonText = this.f94P.mContext.getText(i);
            this.f94P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, OnClickListener onClickListener) {
            this.f94P.mPositiveButtonText = charSequence;
            this.f94P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.f94P.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, OnClickListener onClickListener) {
            this.f94P.mItems = this.f94P.mContext.getResources().getTextArray(i);
            this.f94P.mOnClickListener = onClickListener;
            this.f94P.mCheckedItem = i2;
            this.f94P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, OnClickListener onClickListener) {
            this.f94P.mCursor = cursor;
            this.f94P.mOnClickListener = onClickListener;
            this.f94P.mCheckedItem = i;
            this.f94P.mLabelColumn = str;
            this.f94P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, OnClickListener onClickListener) {
            this.f94P.mAdapter = listAdapter;
            this.f94P.mOnClickListener = onClickListener;
            this.f94P.mCheckedItem = i;
            this.f94P.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, OnClickListener onClickListener) {
            this.f94P.mItems = charSequenceArr;
            this.f94P.mOnClickListener = onClickListener;
            this.f94P.mCheckedItem = i;
            this.f94P.mIsSingleChoice = true;
            return this;
        }

        public Builder setTitle(int i) {
            this.f94P.mTitle = this.f94P.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.f94P.mTitle = charSequence;
            return this;
        }

        public Builder setView(int i) {
            this.f94P.mView = null;
            this.f94P.mViewLayoutResId = i;
            this.f94P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view) {
            this.f94P.mView = view;
            this.f94P.mViewLayoutResId = 0;
            this.f94P.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            this.f94P.mView = view;
            this.f94P.mViewLayoutResId = 0;
            this.f94P.mViewSpacingSpecified = true;
            this.f94P.mViewSpacingLeft = i;
            this.f94P.mViewSpacingTop = i2;
            this.f94P.mViewSpacingRight = i3;
            this.f94P.mViewSpacingBottom = i4;
            return this;
        }

        public AlertDialog show() {
            AlertDialog create = create();
            create.show();
            return create;
        }
    }

    protected AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
    }

    protected AlertDialog(Context context, int i) {
        this(context, i, true);
    }

    AlertDialog(Context context, int i, boolean z) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(Context context, boolean z, OnCancelListener onCancelListener) {
        super(context, resolveDialogTheme(context, 0));
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        this.mAlert = new AlertController(context, this, getWindow());
    }

    static int resolveDialogTheme(Context context, int i) {
        if (i >= ViewCompat.MEASURED_STATE_TOO_SMALL) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mAlert.onKeyDown(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mAlert.onKeyUp(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, CharSequence charSequence, OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i, charSequence, null, message);
    }

    void setButtonPanelLayoutHint(int i) {
        this.mAlert.setButtonPanelLayoutHint(i);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }
}
