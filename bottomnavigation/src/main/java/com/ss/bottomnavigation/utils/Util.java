package com.ss.bottomnavigation.utils;

import android.content.res.Resources;

/**
 * @author S.Shahini
 * @since 11/14/16
 */

public class Util {
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
