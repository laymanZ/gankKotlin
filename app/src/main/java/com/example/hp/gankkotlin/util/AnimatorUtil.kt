package com.example.hp.gankkotlin.util

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.hp.gankkotlin.R


object AnimatorUtil {

    private val DELAY = 80L
    private var mLastPosition = -1

    fun showItemAnim(view: View,
                     position: Int) {
        val context = view.context
        if (position > mLastPosition) {
            view.alpha = 0f
            view.postDelayed({
                val animation = AnimationUtils.loadAnimation(context, R.anim.recyclerview_item_anim)
                animation.setAnimationListener(object : Animation.AnimationListener {

                    override fun onAnimationStart(animation: Animation?) {
                        view.alpha = 1f
                    }

                    override fun onAnimationRepeat(animation: Animation?) {
                    }

                    override fun onAnimationEnd(animation: Animation?) {
                    }

                })
                view.startAnimation(animation)
            }, DELAY)
            mLastPosition = position
        }
    }


    fun fabAnim(view: View,
                duration: Long,
                interpolator: TimeInterpolator,
                startNum: Float,
                endNum: Float) {

        val moreAnimX = ObjectAnimator.ofFloat(view, "alpha", startNum, endNum)
        val moreAnimY = ObjectAnimator.ofFloat(view, "scaleX", startNum, endNum)
        val moreAnimZ = ObjectAnimator.ofFloat(view, "scaleY", startNum, endNum)
        val animSet = AnimatorSet().setDuration(duration)
        animSet.playTogether(moreAnimX, moreAnimY, moreAnimZ)
        animSet.interpolator = interpolator
        animSet.start()
    }


    fun revealAnim(target: View,
                   duration: Long,
                   isShow: Boolean) {
        if (!isShow) {
            val animator = ViewAnimationUtils.createCircularReveal(target,
                    ScreenUtils.getScreenWidth(target.context),
                    ScreenUtils.getScreenHeight(target.context),
                    0f,
                    ScreenUtils.getScreenHeight(target.context).toFloat())
            animator.setDuration(duration).start()
        } else {
            val animator = ViewAnimationUtils.createCircularReveal(target,
                    ScreenUtils.getScreenWidth(target.context),
                    ScreenUtils.getScreenHeight(target.context),
                    ScreenUtils.getScreenHeight(target.context).toFloat(),
                    0f)
            animator.setDuration(duration).start()
        }
    }

}