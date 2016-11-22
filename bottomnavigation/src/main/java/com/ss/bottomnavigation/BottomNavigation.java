package com.ss.bottomnavigation;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;
import com.ss.bottomnavigation.events.OnTabItemClickListener;
import com.ss.bottomnavigation.utils.AnimationHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Shahini
 * @since 11/13/16
 */

public class BottomNavigation extends LinearLayout implements OnTabItemClickListener {

    private int type;

    public static final int TYPE_FIXED = 1;
    public static final int TYPE_DYNAMIC = 0;

    private OnSelectedItemChangeListener onSelectedItemChangeListener;
    private int defaultItem = 0;
    private int selectedItemPosition = defaultItem;

    List<TabItem> tabItems = new ArrayList<>();
    private Typeface typeface;

    public BottomNavigation(Context context) {
        super(context);
        if (!isInEditMode()) {
            setup(null);
        }
    }

    public BottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            setup(attrs);
        }
    }

    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            setup(attrs);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()) {
            setup(attrs);
        }
    }

    private void setup(AttributeSet attributeSet) {
        parseAttributes(attributeSet);
        switch (mode) {
            case MODE_TABLET:
                setOrientation(VERTICAL);
                setGravity(Gravity.CENTER_HORIZONTAL);
                break;
            default:
            case MODE_PHONE:
                setOrientation(HORIZONTAL);
                setGravity(Gravity.LEFT);
                break;
        }
        setMinimumHeight(getContext().getResources().getDimensionPixelSize(R.dimen.bottom_navigation_min_width));
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setupChildren();
    }

    private void setupChildren() {
        if (getChildCount() > 0) {
            if (getChildCount() >= 3 && getChildCount() <= 5) {

                if (getChildCount() > 3) {
                    type = TYPE_DYNAMIC;
                } else {
                    type = TYPE_FIXED;
                }

                for (int i = 0; i < getChildCount(); i++) {
                    if (!(getChildAt(i) instanceof TabItem)) {
                        throw new RuntimeException("Bottom navigation only accept tab item as child.");
                    } else {
                        final TabItem tabItem = (TabItem) getChildAt(i);
                        tabItem.setPosition(i);
                        tabItems.add(tabItem);
                        tabItem.setOnTabItemClickListener(this);
                    }
                }
            } else {
                throw new RuntimeException("Bottom navigation child count must between 3 to 5 only.");
            }
        } else {
            throw new RuntimeException("Bottom navigation can't be empty!");
        }
    }

    private void onSelectedItemChanged() {
        for (int i = 0; i < tabItems.size(); i++) {
            if (tabItems.get(i).getPosition() == selectedItemPosition) {
                tabItems.get(i).setSelected(true);
            } else {
                tabItems.get(i).setSelected(false);
            }
        }
    }

    public int getType() {
        return type;
    }

    public void setDefaultItem(int position) {
        this.defaultItem = position;
    }

    public int getDefaultItem() {
        return defaultItem;
    }


    public Typeface getTypeface() {
        return typeface;
    }

    public void setTypeface(final Typeface typeface) {
        this.typeface = typeface;
        for (int i = 0; i < tabItems.size(); i++) {
            final TabItem tabItem = tabItems.get(i);
            tabItem.post(new Runnable() {
                @Override
                public void run() {
                    tabItem.setTypeface(typeface);
                }
            });
        }
    }

    public void setOnSelectedItemChangeListener(OnSelectedItemChangeListener onSelectedItemChangeListener) {
        this.onSelectedItemChangeListener = onSelectedItemChangeListener;
        onSelectedItemChangeListener.onSelectedItemChanged(tabItems.get(defaultItem).getId());

    }

    @Override
    public void onTabItemClick(final int position) {
        if (position != selectedItemPosition) {
            selectedItemPosition = position;
            onSelectedItemChanged();
            if (onSelectedItemChangeListener != null) {
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onSelectedItemChangeListener.onSelectedItemChanged(tabItems.get(position).getId());
                    }
                }, AnimationHelper.ANIMATION_DURATION);
            }
        }
    }


    public static final int MODE_PHONE = 0;
    public static final int MODE_TABLET = 1;
    private int mode = HORIZONTAL;

    private void parseAttributes(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.BottomNavigation);
            try {
                mode = typedArray.getInteger(R.styleable.BottomNavigation_mode, MODE_PHONE);
            } finally {
                typedArray.recycle();
            }
        }
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

}
