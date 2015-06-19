package com.{package};


import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class AnimateWidth {
    private View parentView;
    private int layoutId;
    private int animationTime;
    private int baseWidth;
    private int widthToReach;
    private View layoutToAnim;

    public AnimateWidth(View view, int id, int time, int widthFrom, int widthTo) {
        parentView = view;
        layoutId = id;
        animationTime = time;
        baseWidth = widthFrom;
        widthToReach = widthTo;
    }

    public void playAnimation() {

        layoutToAnim = parentView.findViewById(layoutId);
        ValueAnimator anim = ValueAnimator.ofInt(baseWidth, widthToReach);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = layoutToAnim.getLayoutParams();
                layoutParams.width = val;
                layoutToAnim.setLayoutParams(layoutParams);
            }
        });

        anim.setDuration(animationTime);
        anim.start();
    }
}