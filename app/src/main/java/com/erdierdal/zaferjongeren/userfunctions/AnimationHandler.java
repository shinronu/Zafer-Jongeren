package com.erdierdal.zaferjongeren.userfunctions;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
/**
 * Created by shinronu on 24-3-2015.
 */
public class AnimationHandler {
//    custom implementation for the activity screen where we give as parameters
//    the view on which we will execute the animation set
//    the duration of the animation
//    the visibility givin in floats from 0(hidden) to 1(default)
//    the x and y values both having the from and to value
    public Animation animate(View v, int duration, float fromAlpha, float toAlpha, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta){
        v.setVisibility(View.VISIBLE);
        Animation fadein = new AlphaAnimation(fromAlpha, toAlpha);
        fadein.setDuration(duration);
        fadein.setFillAfter(true);
        Animation slide = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        slide.setDuration(duration);
        slide.setFillAfter(true);
        AnimationSet animations = new AnimationSet(false);
        animations.setFillAfter(true);
        animations.addAnimation(fadein);
        animations.addAnimation(slide);
        return animations;
    }
}

