package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private Callback mActionMenuPresenterCallback;
    private int mButtonGravity;
    private ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private final RtlSpacingHelper mContentInsets;
    private final AppCompatDrawableManager mDrawableManager;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final android.support.v7.widget.ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    private OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    class C02421 implements android.support.v7.widget.ActionMenuView.OnMenuItemClickListener {
        C02421() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return Toolbar.this.mOnMenuItemClickListener != null ? Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(menuItem) : false;
        }
    }

    class C02432 implements Runnable {
        C02432() {
        }

        public void run() {
            Toolbar.this.showOverflowMenu();
        }
    }

    class C02443 implements OnClickListener {
        C02443() {
        }

        public void onClick(View view) {
            Toolbar.this.collapseActionView();
        }
    }

    class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
            Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
            Toolbar.this.mExpandedActionView = null;
            Toolbar.this.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            Toolbar.this.ensureCollapseButtonView();
            if (Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            if (Toolbar.this.mExpandedActionView.getParent() != Toolbar.this) {
                android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = GravityCompat.START | (Toolbar.this.mButtonGravity & 112);
                generateDefaultLayoutParams.mViewType = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            if (!(this.mMenu == null || this.mCurrentExpandedItem == null)) {
                this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
            }
            this.mMenu = menuBuilder;
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public void setCallback(Callback callback) {
        }

        public void updateMenuView(boolean z) {
            Object obj = null;
            if (this.mCurrentExpandedItem != null) {
                if (this.mMenu != null) {
                    int size = this.mMenu.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }
    }

    public class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(int i) {
            this(-2, -1, i);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.mViewType = 0;
            this.gravity = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = 0;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        void copyMarginsFromCompat(MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public class SavedState extends BaseSavedState {
        public static final Creator CREATOR = new C02451();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        final class C02451 implements Creator {
            C02451() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContentInsets = new RtlSpacingHelper();
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new C02421();
        this.mShowOverflowMenuRunnable = new C02432();
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.Toolbar, i, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = obtainStyledAttributes.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = 48;
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, 0);
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset;
        }
        dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset;
        }
        dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset;
        }
        dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset;
        }
        this.mMaxButtonHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        this.mContentInsets.setAbsolute(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0));
        if (!(dimensionPixelOffset == Integer.MIN_VALUE && dimensionPixelOffset2 == Integer.MIN_VALUE)) {
            this.mContentInsets.setRelative(dimensionPixelOffset, dimensionPixelOffset2);
        }
        this.mCollapseIcon = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = obtainStyledAttributes.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        text = obtainStyledAttributes.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text)) {
            setSubtitle(text);
        }
        this.mPopupContext = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        text = obtainStyledAttributes.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text)) {
            setNavigationContentDescription(text);
        }
        drawable = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_logo);
        if (drawable != null) {
            setLogo(drawable);
        }
        text = obtainStyledAttributes.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text)) {
            setLogoDescription(text);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(obtainStyledAttributes.getColor(R.styleable.Toolbar_titleTextColor, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(obtainStyledAttributes.getColor(R.styleable.Toolbar_subtitleTextColor, -1));
        }
        obtainStyledAttributes.recycle();
        this.mDrawableManager = AppCompatDrawableManager.get();
    }

    private void addCustomViewsWithGravity(List list, int i) {
        int i2 = 1;
        int i3 = 0;
        if (ViewCompat.getLayoutDirection(this) != 1) {
            i2 = 0;
        }
        int childCount = getChildCount();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
        list.clear();
        LayoutParams layoutParams;
        if (i2 != 0) {
            for (i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i3 < childCount) {
            View childAt2 = getChildAt(i3);
            layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
            i3++;
        }
    }

    private void addSystemView(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        } else {
            layoutParams = generateLayoutParams(layoutParams);
        }
        layoutParams.mViewType = 1;
        if (!z || this.mExpandedActionView == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.mHiddenViews.add(view);
    }

    private void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = GravityCompat.START | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new C02443());
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new ImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = GravityCompat.END | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = GravityCompat.START | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int getChildHorizontalGravity(int i) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
        switch (absoluteGravity) {
            case 1:
            case 3:
            case 5:
                return absoluteGravity;
            default:
                return layoutDirection == 1 ? 5 : 3;
        }
    }

    private int getChildTop(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        switch (getChildVerticalGravity(layoutParams.gravity)) {
            case 48:
                return getPaddingTop() - i2;
            case 80:
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin) - i2;
            default:
                int i3;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                i2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                if (i2 < layoutParams.topMargin) {
                    i3 = layoutParams.topMargin;
                } else {
                    measuredHeight = (((height - paddingBottom) - measuredHeight) - i2) - paddingTop;
                    i3 = measuredHeight < layoutParams.bottomMargin ? Math.max(0, i2 - (layoutParams.bottomMargin - measuredHeight)) : i2;
                }
                return i3 + paddingTop;
        }
    }

    private int getChildVerticalGravity(int i) {
        int i2 = i & 112;
        switch (i2) {
            case 16:
            case 48:
            case 80:
                return i2;
            default:
                return this.mGravity & 112;
        }
    }

    private int getHorizontalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams);
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private int getVerticalMargins(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
    }

    private int getViewListMeasuredWidth(List list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        while (i3 < size) {
            View view = (View) list.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            i6 = layoutParams.leftMargin - i6;
            i = layoutParams.rightMargin - i5;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, i);
            i6 = Math.max(0, -i6);
            i5 = Math.max(0, -i);
            i3++;
            i4 += (view.getMeasuredWidth() + max) + max2;
        }
        return i4;
    }

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    private static boolean isCustomView(View view) {
        return ((LayoutParams) view.getLayoutParams()).mViewType == 0;
    }

    private int layoutChildLeft(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        i3 = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, i3, max + measuredWidth, view.getMeasuredHeight() + i3);
        return (layoutParams.rightMargin + measuredWidth) + max;
    }

    private int layoutChildRight(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        i3 = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, i3, max, view.getMeasuredHeight() + i3);
        return max - (layoutParams.leftMargin + measuredWidth);
    }

    private int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void measureChildConstrained(View view, int i, int i2, int i3, int i4, int i5) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height);
        int mode = MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView((View) this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl = this.mExpandedMenuPresenter == null ? null : this.mExpandedMenuPresenter.mCurrentExpandedItem;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.dismissPopupMenus();
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams ? new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getContentInsetEnd() {
        return this.mContentInsets.getEnd();
    }

    public int getContentInsetLeft() {
        return this.mContentInsets.getLeft();
    }

    public int getContentInsetRight() {
        return this.mContentInsets.getRight();
    }

    public int getContentInsetStart() {
        return this.mContentInsets.getStart();
    }

    public Drawable getLogo() {
        return this.mLogoView != null ? this.mLogoView.getDrawable() : null;
    }

    public CharSequence getLogoDescription() {
        return this.mLogoView != null ? this.mLogoView.getContentDescription() : null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        return this.mNavButtonView != null ? this.mNavButtonView.getContentDescription() : null;
    }

    public Drawable getNavigationIcon() {
        return this.mNavButtonView != null ? this.mNavButtonView.getDrawable() : null;
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public boolean hideOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.hideOverflowMenu();
    }

    public void inflateMenu(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public boolean isOverflowMenuShowPending() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        if (this.mTitleTextView == null) {
            return false;
        }
        Layout layout = this.mTitleTextView.getLayout();
        if (layout == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (layout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int measuredHeight;
        int measuredWidth;
        Object obj = ViewCompat.getLayoutDirection(this) == 1 ? 1 : null;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (!shouldLayout(this.mNavButtonView)) {
            i5 = paddingLeft;
        } else if (obj != null) {
            i8 = layoutChildRight(this.mNavButtonView, i8, iArr, minimumHeight);
            i5 = paddingLeft;
        } else {
            i5 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, minimumHeight);
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            if (obj != null) {
                i8 = layoutChildRight(this.mCollapseButtonView, i8, iArr, minimumHeight);
            } else {
                i5 = layoutChildLeft(this.mCollapseButtonView, i5, iArr, minimumHeight);
            }
        }
        if (shouldLayout(this.mMenuView)) {
            if (obj != null) {
                i5 = layoutChildLeft(this.mMenuView, i5, iArr, minimumHeight);
            } else {
                i8 = layoutChildRight(this.mMenuView, i8, iArr, minimumHeight);
            }
        }
        iArr[0] = Math.max(0, getContentInsetLeft() - i5);
        iArr[1] = Math.max(0, getContentInsetRight() - ((width - paddingRight) - i8));
        i5 = Math.max(i5, getContentInsetLeft());
        i8 = Math.min(i8, (width - paddingRight) - getContentInsetRight());
        if (shouldLayout(this.mExpandedActionView)) {
            if (obj != null) {
                i8 = layoutChildRight(this.mExpandedActionView, i8, iArr, minimumHeight);
            } else {
                i5 = layoutChildLeft(this.mExpandedActionView, i5, iArr, minimumHeight);
            }
        }
        if (!shouldLayout(this.mLogoView)) {
            i6 = i8;
            i7 = i5;
        } else if (obj != null) {
            i6 = layoutChildRight(this.mLogoView, i8, iArr, minimumHeight);
            i7 = i5;
        } else {
            i6 = i8;
            i7 = layoutChildLeft(this.mLogoView, i5, iArr, minimumHeight);
        }
        boolean shouldLayout = shouldLayout(this.mTitleTextView);
        boolean shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        i5 = 0;
        if (shouldLayout) {
            LayoutParams layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
            i5 = 0 + (layoutParams.bottomMargin + (layoutParams.topMargin + this.mTitleTextView.getMeasuredHeight()));
        }
        if (shouldLayout2) {
            layoutParams = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
            measuredHeight = (layoutParams.bottomMargin + (layoutParams.topMargin + this.mSubtitleTextView.getMeasuredHeight())) + i5;
        } else {
            measuredHeight = i5;
        }
        if (shouldLayout || shouldLayout2) {
            int paddingTop2;
            layoutParams = (LayoutParams) (shouldLayout ? this.mTitleTextView : this.mSubtitleTextView).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) (shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView).getLayoutParams();
            Object obj2 = ((!shouldLayout || this.mTitleTextView.getMeasuredWidth() <= 0) && (!shouldLayout2 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) ? null : 1;
            switch (this.mGravity & 112) {
                case 48:
                    paddingTop2 = (layoutParams.topMargin + getPaddingTop()) + this.mTitleMarginTop;
                    break;
                case 80:
                    paddingTop2 = (((height - paddingBottom) - layoutParams2.bottomMargin) - this.mTitleMarginBottom) - measuredHeight;
                    break;
                default:
                    paddingTop2 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    if (paddingTop2 < layoutParams.topMargin + this.mTitleMarginTop) {
                        i8 = layoutParams.topMargin + this.mTitleMarginTop;
                    } else {
                        measuredHeight = (((height - paddingBottom) - measuredHeight) - paddingTop2) - paddingTop;
                        i8 = measuredHeight < layoutParams.bottomMargin + this.mTitleMarginBottom ? Math.max(0, paddingTop2 - ((layoutParams2.bottomMargin + this.mTitleMarginBottom) - measuredHeight)) : paddingTop2;
                    }
                    paddingTop2 = paddingTop + i8;
                    break;
            }
            if (obj != null) {
                i8 = (obj2 != null ? this.mTitleMarginStart : 0) - iArr[1];
                i5 = i6 - Math.max(0, i8);
                iArr[1] = Math.max(0, -i8);
                if (shouldLayout) {
                    layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    measuredWidth = i5 - this.mTitleTextView.getMeasuredWidth();
                    i6 = this.mTitleTextView.getMeasuredHeight() + paddingTop2;
                    this.mTitleTextView.layout(measuredWidth, paddingTop2, i5, i6);
                    paddingTop2 = i6 + layoutParams.bottomMargin;
                    i6 = measuredWidth - this.mTitleMarginEnd;
                } else {
                    i6 = i5;
                }
                if (shouldLayout2) {
                    layoutParams = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                    measuredWidth = layoutParams.topMargin + paddingTop2;
                    measuredHeight = this.mSubtitleTextView.getMeasuredHeight() + measuredWidth;
                    this.mSubtitleTextView.layout(i5 - this.mSubtitleTextView.getMeasuredWidth(), measuredWidth, i5, measuredHeight);
                    i8 = layoutParams.bottomMargin + measuredHeight;
                    i8 = i5 - this.mTitleMarginEnd;
                } else {
                    i8 = i5;
                }
                i6 = obj2 != null ? Math.min(i6, i8) : i5;
            } else {
                i8 = (obj2 != null ? this.mTitleMarginStart : 0) - iArr[0];
                i7 += Math.max(0, i8);
                iArr[0] = Math.max(0, -i8);
                if (shouldLayout) {
                    layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                    i5 = this.mTitleTextView.getMeasuredWidth() + i7;
                    measuredWidth = this.mTitleTextView.getMeasuredHeight() + paddingTop2;
                    this.mTitleTextView.layout(i7, paddingTop2, i5, measuredWidth);
                    i8 = layoutParams.bottomMargin + measuredWidth;
                    measuredWidth = i5 + this.mTitleMarginEnd;
                    i5 = i8;
                } else {
                    measuredWidth = i7;
                    i5 = paddingTop2;
                }
                if (shouldLayout2) {
                    layoutParams = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                    i5 += layoutParams.topMargin;
                    paddingTop2 = this.mSubtitleTextView.getMeasuredWidth() + i7;
                    measuredHeight = this.mSubtitleTextView.getMeasuredHeight() + i5;
                    this.mSubtitleTextView.layout(i7, i5, paddingTop2, measuredHeight);
                    i8 = layoutParams.bottomMargin + measuredHeight;
                    i8 = this.mTitleMarginEnd + paddingTop2;
                } else {
                    i8 = i7;
                }
                if (obj2 != null) {
                    i7 = Math.max(measuredWidth, i8);
                }
            }
        }
        addCustomViewsWithGravity(this.mTempViews, 3);
        int size = this.mTempViews.size();
        i5 = i7;
        for (measuredWidth = 0; measuredWidth < size; measuredWidth++) {
            i5 = layoutChildLeft((View) this.mTempViews.get(measuredWidth), i5, iArr, minimumHeight);
        }
        addCustomViewsWithGravity(this.mTempViews, 5);
        i7 = this.mTempViews.size();
        for (measuredWidth = 0; measuredWidth < i7; measuredWidth++) {
            i6 = layoutChildRight((View) this.mTempViews.get(measuredWidth), i6, iArr, minimumHeight);
        }
        addCustomViewsWithGravity(this.mTempViews, 1);
        measuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
        i8 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        measuredWidth += i8;
        if (i8 < i5) {
            i8 = i5;
        } else if (measuredWidth > i6) {
            i8 -= measuredWidth - i6;
        }
        paddingLeft = this.mTempViews.size();
        measuredWidth = i8;
        for (i5 = 0; i5 < paddingLeft; i5++) {
            measuredWidth = layoutChildLeft((View) this.mTempViews.get(i5), measuredWidth, iArr, minimumHeight);
        }
        this.mTempViews.clear();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int max;
        int i5 = 0;
        int i6 = 0;
        int[] iArr = this.mTempMargins;
        if (ViewUtils.isLayoutRtl(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i3 = 1;
            i4 = 0;
        }
        int i7 = 0;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i7 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            max = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i6 = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mNavButtonView));
            i5 = max;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
            i7 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i5 = Math.max(i5, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.mCollapseButtonView));
        }
        int contentInsetStart = getContentInsetStart();
        int max2 = 0 + Math.max(contentInsetStart, i7);
        iArr[i4] = Math.max(0, contentInsetStart - i7);
        i7 = 0;
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max2, i2, 0, this.mMaxButtonHeight);
            i7 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i5 = Math.max(i5, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.mMenuView));
        }
        contentInsetStart = getContentInsetEnd();
        max2 += Math.max(contentInsetStart, i7);
        iArr[i3] = Math.max(0, contentInsetStart - i7);
        if (shouldLayout(this.mExpandedActionView)) {
            max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.mExpandedActionView));
        }
        if (shouldLayout(this.mLogoView)) {
            max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
            i5 = Math.max(i5, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i6 = ViewUtils.combineMeasuredStates(i6, ViewCompat.getMeasuredState(this.mLogoView));
        }
        i4 = getChildCount();
        i3 = 0;
        int i8 = i5;
        i5 = i6;
        while (i3 < i4) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType != 0) {
                i7 = i5;
                contentInsetStart = i8;
            } else if (shouldLayout(childAt)) {
                max2 += measureChildCollapseMargins(childAt, i, max2, i2, 0, iArr);
                max = Math.max(i8, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                i7 = ViewUtils.combineMeasuredStates(i5, ViewCompat.getMeasuredState(childAt));
                contentInsetStart = max;
            } else {
                i7 = i5;
                contentInsetStart = i8;
            }
            i3++;
            i5 = i7;
            i8 = contentInsetStart;
        }
        contentInsetStart = 0;
        i7 = 0;
        i6 = this.mTitleMarginTop + this.mTitleMarginBottom;
        max = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, max2 + max, i2, i6, iArr);
            contentInsetStart = getHorizontalMargins(this.mTitleTextView) + this.mTitleTextView.getMeasuredWidth();
            i7 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i5 = ViewUtils.combineMeasuredStates(i5, ViewCompat.getMeasuredState(this.mTitleTextView));
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            contentInsetStart = Math.max(contentInsetStart, measureChildCollapseMargins(this.mSubtitleTextView, i, max2 + max, i2, i6 + i7, iArr));
            i7 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i5 = ViewUtils.combineMeasuredStates(i5, ViewCompat.getMeasuredState(this.mSubtitleTextView));
        }
        contentInsetStart += max2;
        i7 = Math.max(i8, i7) + (getPaddingTop() + getPaddingBottom());
        contentInsetStart = ViewCompat.resolveSizeAndState(Math.max(contentInsetStart + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, ViewCompat.MEASURED_STATE_MASK & i5);
        i7 = ViewCompat.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i2, i5 << 16);
        if (shouldCollapse()) {
            i7 = 0;
        }
        setMeasuredDimension(contentInsetStart, i7);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        Menu peekMenu = this.mMenuView != null ? this.mMenuView.peekMenu() : null;
        if (!(savedState.expandedMenuItemId == 0 || this.mExpandedMenuPresenter == null || peekMenu == null)) {
            MenuItem findItem = peekMenu.findItem(savedState.expandedMenuItemId);
            if (findItem != null) {
                MenuItemCompat.expandActionView(findItem);
            }
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (i != 1) {
            z = false;
        }
        rtlSpacingHelper.setDirection(z);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null)) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((LayoutParams) childAt.getLayoutParams()).mViewType == 2 || childAt == this.mMenuView)) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        this.mContentInsets.setAbsolute(i, i2);
    }

    public void setContentInsetsRelative(int i, int i2) {
        this.mContentInsets.setRelative(i, i2);
    }

    public void setLogo(int i) {
        setLogo(this.mDrawableManager.getDrawable(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else if (this.mLogoView != null && isChildOrHidden(this.mLogoView)) {
            removeView(this.mLogoView);
            this.mHiddenViews.remove(this.mLogoView);
        }
        if (this.mLogoView != null) {
            this.mLogoView.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        if (this.mLogoView != null) {
            this.mLogoView.setContentDescription(charSequence);
        }
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder != null || this.mMenuView != null) {
            ensureMenuView();
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            if (peekMenu != menuBuilder) {
                if (peekMenu != null) {
                    peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    peekMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter.setExpandedActionViewsExclusive(true);
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
                    menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    actionMenuPresenter.initForMenu(this.mPopupContext, null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
                    actionMenuPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(actionMenuPresenter);
                this.mOuterActionMenuPresenter = actionMenuPresenter;
            }
        }
    }

    public void setMenuCallbacks(Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
        if (this.mMenuView != null) {
            this.mMenuView.setMenuCallbacks(callback, callback2);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(this.mDrawableManager.getDrawable(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else if (this.mNavButtonView != null && isChildOrHidden(this.mNavButtonView)) {
            removeView(this.mNavButtonView);
            this.mHiddenViews.remove(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new TextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TruncateAt.END);
                if (this.mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
                }
                if (this.mSubtitleTextColor != 0) {
                    this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else if (this.mSubtitleTextView != null && isChildOrHidden(this.mSubtitleTextView)) {
            removeView(this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int i) {
        this.mSubtitleTextAppearance = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextAppearance(context, i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.mSubtitleTextColor = i;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new TextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TruncateAt.END);
                if (this.mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
                }
                if (this.mTitleTextColor != 0) {
                    this.mTitleTextView.setTextColor(this.mTitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else if (this.mTitleTextView != null && isChildOrHidden(this.mTitleTextView)) {
            removeView(this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, int i) {
        this.mTitleTextAppearance = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.mTitleTextColor = i;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextColor(i);
        }
    }

    public boolean showOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.showOverflowMenu();
    }
}
