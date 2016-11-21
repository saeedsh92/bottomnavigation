package com.ss.bottomnavigation;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.ss.bottomnavigation.events.OnItemClickListener;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;
import com.ss.bottomnavigation.utils.AnimationHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author S.Shahini
 * @since 11/13/16
 */

public class BottomNavigation extends LinearLayout {

    private byte type;

    public static final byte TYPE_FIXED = 1;
    public static final byte TYPE_DYNAMIC = 0;

    private OnSelectedItemChangeListener onSelectedItemChangeListener;
    private byte defaultItem = 0;
    private byte selectedItemPosition = defaultItem;

    List<TabItem> tabItems = new ArrayList<>();
    private Typeface typeface;

    public BottomNavigation(Context context) {
        super(context);
        if (!isInEditMode()) {
            setup();
        }
    }

    public BottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            setup();
        }
    }

    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            setup();
        }
    }

    public BottomNavigation(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()) {
            setup();
        }
    }

    private void setup() {
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        setMinimumHeight(getContext().getResources().getDimensionPixelSize(R.dimen.bottom_navigation_min_width));
    }

    private void setupChildren() {
        if (getChildCount() > 0) {
            if (getChildCount() >= 3 && getChildCount() <= 5) {

                if (getChildCount() > 3) {
                    type = TYPE_DYNAMIC;
                } else {
                    type = TYPE_FIXED;
                }

                for (byte i = 0; i < getChildCount(); i++) {
                    if (!(getChildAt(i) instanceof TabItem)) {
                        throw new RuntimeException("Bottom navigation only accept tab item as child.");
                    } else {
                        final TabItem tabItem = (TabItem) getChildAt(i);
                        tabItem.setPosition(i);
                        tabItems.add(tabItem);
                        tabItem.setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onClick(byte position) {
                                if (position!=selectedItemPosition) {
                                    selectedItemPosition = position;
                                    onSelectedItemChanged();
                                    if (onSelectedItemChangeListener != null) {
                                        postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                onSelectedItemChangeListener.onSelectedItemChanged(tabItem.getId());
                                            }
                                        }, AnimationHelper.ANIMATION_DURATION);
                                    }
                                }
                            }
                        });
                    }
                }
            } else {
                throw new RuntimeException("Bottom navigation child count must between 3 to 5 only.");
            }
        } else {
            throw new RuntimeException("Bottom navigation can't be empty!");
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setupChildren();
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

    public byte getType() {
        return type;
    }

    public void setDefaultItem(byte position) {
        this.defaultItem = position;
    }

    public int getDefaultItem() {
        return defaultItem;
    }

    public void setOnSelectedItemChangeListener(OnSelectedItemChangeListener onSelectedItemChangeListener) {
        this.onSelectedItemChangeListener = onSelectedItemChangeListener;
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public void setTypeface(final Typeface typeface) {
        this.typeface = typeface;
        for (int i = 0; i < tabItems.size(); i++) {
            final TabItem tabItem=tabItems.get(i);
            tabItem.post(new Runnable() {
                @Override
                public void run() {
                    tabItem.setTypeface(typeface);
                }
            });
        }
    }
}
