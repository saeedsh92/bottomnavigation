package com.ss.bottomnavigation.utils;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ss.bottomnavigation.BottomNavigation;

/**
 * @author S.Shahini
 * @since 11/13/16
 * this class used for providing necessary layout params
 */

public class LayoutParamsHelper {

    /**
     * this method provide tab icon layout params
     * @param bottomNavigationType layout params can be different according to {@link BottomNavigation#type}
     * @return return appropriate layout params for tab icon
     */
    public static FrameLayout.LayoutParams getTabItemIconLayoutParams(int bottomNavigationType) {
        int iconSize = Util.dpToPx(Dimens.TAB_ICON_SIZE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iconSize, iconSize);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        switch (bottomNavigationType) {
            case BottomNavigation.TYPE_FIXED:
                layoutParams.topMargin = Util.dpToPx(FixedDimens.TAB_PADDING_TOP_INACTIVE);
                return layoutParams;
            case BottomNavigation.TYPE_DYNAMIC:
                layoutParams.topMargin = Util.dpToPx(DynamicDimens.TAB_PADDING_TOP_INACTIVE);
                return layoutParams;
        }
        return null;
    }

    /**
     * this provide tab label layout params
     * @param bottomNavigationType layout params can be different according to {@link BottomNavigation#type}
     * @return return appropriate layout params for tab label
     */
    public static FrameLayout.LayoutParams getTabItemTextLayoutParams(int bottomNavigationType) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;

        switch (bottomNavigationType) {
            case BottomNavigation.TYPE_FIXED:
                layoutParams.bottomMargin = Util.dpToPx(FixedDimens.TAB_PADDING_BOTTOM);
                layoutParams.rightMargin = Util.dpToPx(FixedDimens.TAB_PADDING_RIGHT);
                layoutParams.leftMargin = Util.dpToPx(FixedDimens.TAB_PADDING_LEFT);
                layoutParams.topMargin = Util.dpToPx(FixedDimens.TAB_ICON_SIZE) + Util.dpToPx(FixedDimens.TAB_PADDING_TOP_INACTIVE);
                return layoutParams;
            case BottomNavigation.TYPE_DYNAMIC:
                layoutParams.bottomMargin = Util.dpToPx(DynamicDimens.TAB_PADDING_BOTTOM_ACTIVE);
                layoutParams.rightMargin = Util.dpToPx(DynamicDimens.TAB_PADDING_RIGHT);
                layoutParams.leftMargin = Util.dpToPx(DynamicDimens.TAB_PADDING_LEFT);
                layoutParams.topMargin = Util.dpToPx(FixedDimens.TAB_ICON_SIZE) + Util.dpToPx(FixedDimens.TAB_PADDING_TOP_ACTIVE);
                return layoutParams;
        }
        return null;
    }

}
