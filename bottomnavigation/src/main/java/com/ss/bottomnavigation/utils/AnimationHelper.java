package com.ss.bottomnavigation.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ss.bottomnavigation.BottomNavigation;

/**
 * @author S.Shahini
 * @since 11/13/16
 */

public class AnimationHelper {
    private Context context;
    private byte type;
    private static int ANIMATION_DURATION=100;

    public AnimationHelper(Context context,byte type) {
        this.context = context;
        this.type=type;
    }

    public void animateDeactivate(final TextView tabText, final ImageView tabIcon) {
        switch (type) {
            case BottomNavigation.TYPE_FIXED:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0.5f);
                alphaAnimation.setDuration(ANIMATION_DURATION);
                alphaAnimation.setFillAfter(true);
                ValueAnimator paddingAnimator=ValueAnimator.ofInt(
                        Util.dpToPx(FixedDimens.TAB_PADDING_TOP_ACTIVE)
                        ,Util.dpToPx(FixedDimens.TAB_PADDING_TOP_INACTIVE)
                );
                paddingAnimator.setDuration(ANIMATION_DURATION);
                paddingAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams tabIconLayoutParams = (FrameLayout.LayoutParams) tabIcon.getLayoutParams();
                        tabIconLayoutParams.topMargin = (int) valueAnimator.getAnimatedValue();
                        Log.i("View", "onAnimationUpdate: topMargin=> " + tabIconLayoutParams.topMargin);
                        tabIcon.setLayoutParams(tabIconLayoutParams);
                    }
                });
                ScaleAnimation fScaleAnimation=new ScaleAnimation(1.1f,1,1.1f,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1f);

                AnimationSet animationSet=new AnimationSet(true);
                animationSet.setDuration(100);
                animationSet.addAnimation(fScaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setFillAfter(true);

                tabIcon.startAnimation(alphaAnimation);
                tabText.startAnimation(animationSet);
                paddingAnimator.start();
                break;

            case BottomNavigation.TYPE_DYNAMIC:
                AlphaAnimation dAlphaAnimation = new AlphaAnimation(1f, 0.5f);
                dAlphaAnimation.setDuration(ANIMATION_DURATION);
                dAlphaAnimation.setFillAfter(true);
                ValueAnimator dPaddingAnimator=ValueAnimator.ofInt(
                        Util.dpToPx(DynamicDimens.TAB_PADDING_TOP_ACTIVE)
                        ,Util.dpToPx(DynamicDimens.TAB_PADDING_TOP_INACTIVE)
                );
                dPaddingAnimator.setDuration(ANIMATION_DURATION);
                dPaddingAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams tabIconLayoutParams= (FrameLayout.LayoutParams) tabIcon.getLayoutParams();
                        tabIconLayoutParams.topMargin=(int)valueAnimator.getAnimatedValue();
                        Log.i("View", "onAnimationUpdate: topMargin=> "+tabIconLayoutParams.topMargin);
                        tabIcon.setLayoutParams(tabIconLayoutParams);

                    }
                });

                ScaleAnimation dScaleAnimation=new ScaleAnimation(1,0,1,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1f);

                AnimationSet dAnimationSet=new AnimationSet(true);
                dAnimationSet.setDuration(100);
                dAnimationSet.addAnimation(dScaleAnimation);
                dAnimationSet.setFillAfter(true);
                tabText.startAnimation(dAnimationSet);
                tabIcon.startAnimation(dAlphaAnimation);
                dPaddingAnimator.start();
                break;
        }
    }

    public void animateActivate(final TextView tabText, final ImageView tabIcon) {
        switch (type) {
            case BottomNavigation.TYPE_FIXED:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1f);
                alphaAnimation.setDuration(ANIMATION_DURATION);
                alphaAnimation.setFillAfter(true);

                ValueAnimator paddingAnimator=ValueAnimator.ofInt(
                        Util.dpToPx(FixedDimens.TAB_PADDING_TOP_INACTIVE)
                        ,Util.dpToPx(FixedDimens.TAB_PADDING_TOP_ACTIVE)
                );
                paddingAnimator.setDuration(ANIMATION_DURATION);
                paddingAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams tabIconLayoutParams= (FrameLayout.LayoutParams) tabIcon.getLayoutParams();
                        tabIconLayoutParams.topMargin=(int)valueAnimator.getAnimatedValue();
                        tabIcon.setLayoutParams(tabIconLayoutParams);

                    }
                });

                ScaleAnimation fTextScaleAnimation=new ScaleAnimation(1,1.1f,1,1.1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1f);
                AnimationSet animationSet=new AnimationSet(true);
                animationSet.setDuration(ANIMATION_DURATION);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(fTextScaleAnimation);
                animationSet.setFillAfter(true);

                tabIcon.startAnimation(alphaAnimation);
                tabText.startAnimation(animationSet);
                paddingAnimator.start();
                break;
            case BottomNavigation.TYPE_DYNAMIC:

                AlphaAnimation dAlphaAnimation = new AlphaAnimation(0.5f, 1f);
                dAlphaAnimation.setDuration(ANIMATION_DURATION);
                dAlphaAnimation.setFillAfter(true);

                ValueAnimator dPaddingAnimator=ValueAnimator.ofInt(
                        Util.dpToPx(DynamicDimens.TAB_PADDING_TOP_INACTIVE)
                        ,Util.dpToPx(DynamicDimens.TAB_PADDING_TOP_ACTIVE)
                );
                dPaddingAnimator.setDuration(ANIMATION_DURATION);
                dPaddingAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        FrameLayout.LayoutParams tabIconLayoutParams= (FrameLayout.LayoutParams) tabIcon.getLayoutParams();
                        tabIconLayoutParams.topMargin=(int)valueAnimator.getAnimatedValue();
                        tabIcon.setLayoutParams(tabIconLayoutParams);
                    }
                });

                ScaleAnimation dTextScaleAnimation=new ScaleAnimation(0,1.1f,0,1.1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,1f);

                AnimationSet dAnimtationSet=new AnimationSet(true);
                dAnimtationSet.setDuration(ANIMATION_DURATION);
                dAnimtationSet.addAnimation(dTextScaleAnimation);
                dAnimtationSet.setFillAfter(true);
                tabText.startAnimation(dAnimtationSet);
                tabIcon.startAnimation(dAlphaAnimation);
                dPaddingAnimator.start();
                break;
        }

    }
}
