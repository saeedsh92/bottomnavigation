package com.ss.bottomnavigation.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ss.bottomnavigation.BottomNavigation;

/**
 * @author S.Shahini
 * @since 11/13/16
 */

public class LayoutParamsHelper {
    public static FrameLayout.LayoutParams getTabItemIconLayoutParams(Context context, boolean isActive, int bottomNavigationType) {
        int iconSize = Util.dpToPx(Dimens.TAB_ICON_SIZE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iconSize, iconSize);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;

        switch (bottomNavigationType) {
            case BottomNavigation.TYPE_FIXED:
                if (isActive) {
                    layoutParams.topMargin = Util.dpToPx(FixedDimens.TAB_PADDING_TOP_ACTIVE);
                } else {
                    layoutParams.topMargin = Util.dpToPx(FixedDimens.TAB_PADDING_TOP_INACTIVE);
                }
                return layoutParams;
            case BottomNavigation.TYPE_DYNAMIC:
                if (isActive) {
                    layoutParams.topMargin = Util.dpToPx(DynamicDimens.TAB_PADDING_TOP_ACTIVE);
                } else {
                    layoutParams.topMargin = Util.dpToPx(DynamicDimens.TAB_PADDING_TOP_INACTIVE);
                }
                return layoutParams;
        }
        return null;
    }

    public static FrameLayout.LayoutParams getTabItemTextLayoutParams(Context context, boolean isActive, int bottomNavigationType) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;

        switch (bottomNavigationType) {
            case BottomNavigation.TYPE_FIXED:
                layoutParams.bottomMargin = Util.dpToPx(FixedDimens.TAB_PADDING_BOTTOM);
                layoutParams.rightMargin = Util.dpToPx(FixedDimens.TAB_PADDING_RIGHT);
                layoutParams.leftMargin = Util.dpToPx(FixedDimens.TAB_PADDING_LEFT);

                if (isActive) {
                    layoutParams.topMargin = Util.dpToPx(FixedDimens.TAB_ICON_SIZE) + Util.dpToPx(FixedDimens.TAB_PADDING_TOP_ACTIVE);
                } else {
                    layoutParams.topMargin = Util.dpToPx(FixedDimens.TAB_ICON_SIZE) + Util.dpToPx(FixedDimens.TAB_PADDING_TOP_INACTIVE);
                }
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
