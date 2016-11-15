package com.ss.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ss.bottomnavigation.events.OnItemClickListener;
import com.ss.bottomnavigation.utils.AnimationHelper;
import com.ss.bottomnavigation.utils.LayoutParamsHelper;

/**
 * @author S.Shahini
 * @since 11/13/16
 */

public class TabItem extends FrameLayout implements View.OnClickListener {
    private OnItemClickListener onItemClickListener;
    private byte position;

    //Attributes
    private String text;
    private Drawable icon;
    private int textColor;

    //Views
    private TextView textView;
    private ImageView iconImageView;

    private boolean isActive = false;
    private byte type = BottomNavigation.TYPE_FIXED;
    private AnimationHelper animationHelper;
    private BottomNavigation bottomNavigation;

    public TabItem(Context context) {
        super(context);
        parseCustomAttributes(null);
    }

    public TabItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseCustomAttributes(attrs);
    }

    public TabItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseCustomAttributes(attrs);
    }

    public TabItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        parseCustomAttributes(attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        checkParent();
    }

    private void setupView() {

        setOnClickListener(this);
        animationHelper=new AnimationHelper(getContext(),type);

        textView = new TextView(getContext());
        textView.setTextColor(textColor);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(LayoutParamsHelper.getTabItemTextLayoutParams(getContext(), isActive, type));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);

        iconImageView = new ImageView(getContext());
        iconImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iconImageView.setImageDrawable(icon);
        iconImageView.setLayoutParams(LayoutParamsHelper.getTabItemIconLayoutParams(getContext(), isActive, type));
        if (position==bottomNavigation.getDefaultItem()) {
            isActive=true;
            animationHelper.animateActivate(textView, iconImageView);
        }else {
            animationHelper.animateDeactivate(textView, iconImageView);
        }

        switch (type) {
            case BottomNavigation.TYPE_FIXED:
                addView(iconImageView);
                addView(textView);
                break;
            case BottomNavigation.TYPE_DYNAMIC:
                if (isActive) {
                    addView(iconImageView);
                    addView(textView);
                } else {
                    addView(iconImageView);
                    addView(textView);
                }
                break;
        }
    }

    private void parseCustomAttributes(AttributeSet attributeSet) {
        if (attributeSet != null) {
            //get xml attributes
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.TabItem, 0, 0);
            try {
                text = typedArray.getString(R.styleable.TabItem_tab_text);
                Log.i("View", "parseCustomAttributes: text=> " + text);
                textColor = typedArray.getColor(R.styleable.TabItem_tab_text_color, ContextCompat.getColor(getContext(), R.color.default_text_color));
                icon = typedArray.getDrawable(R.styleable.TabItem_tab_icon);
            } finally {
                typedArray.recycle();
            }
        }
    }

    private void checkParent() {
        post(new Runnable() {
            @Override
            public void run() {
                if (getParent() instanceof BottomNavigation) {
                    bottomNavigation=(BottomNavigation)getParent();
                    type =bottomNavigation.getType();
                    setupView();
                } else {
                    throw new RuntimeException("TabItem parent must be BottomNavigation!");
                }
            }
        });
    }

    public void setSelected(boolean isActive) {
        if (this.isActive != isActive) {
            notifyChange();
            this.isActive = isActive;
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setPosition(byte position) {
        this.position = position;
    }

    public byte getPosition() {
        return this.position;
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onClick(position);
        }
    }

    private void notifyChange() {
        switch (type) {
            case BottomNavigation.TYPE_FIXED:
                if (isActive){
                    animationHelper.animateDeactivate(textView,iconImageView);
                }else {
                    animationHelper.animateActivate(textView,iconImageView);
                }
                break;
            case BottomNavigation.TYPE_DYNAMIC:
                if (isActive){
                    animationHelper.animateDeactivate(textView,iconImageView);
                }else {
                    animationHelper.animateActivate(textView,iconImageView);
                }
                break;
        }
    }
}
