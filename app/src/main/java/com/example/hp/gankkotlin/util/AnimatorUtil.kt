package com.example.hp.gankkotlin.util

import android.view.View
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

}