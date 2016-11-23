package com.ss.bottomnavigation.utils;

import android.content.res.Resources;

/**
 * @author S.Shahini
 * @since 11/14/16
 */

public class Util {
    /**
     * this function get dp based value and convert it to px
     * @param dp value based on dp metric
     * @return return value based on px metric
     */
    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
