package com.example.practicekt.activity

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.practicekt.databinding.ActivityAnimationBinding
import kotlin.math.hypot

class AnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.propertyAnimateButton.setOnClickListener {
            viewPropertyAnimatorExample(binding.animatedTextView)
        }

        binding.circularRevealButton.setOnClickListener {
            circularRevealExample(binding.animatedTextView)
        }

        binding.valueAnimatorButton.setOnClickListener {
            valueAnimatorExample(binding.animatedTextView)
        }

        binding.springAnimatorButton.setOnClickListener {
            springAnimationExample(binding.animatedTextView)
        }
    }

    private fun viewPropertyAnimatorExample(view: View) {
        view.animate()
            .alpha(0f)
            .translationYBy(100f)
            .setDuration(500)
            .withEndAction {
                // Reset after animation ends
                view.alpha = 1f
                view.translationY = 0f
            }
            .start()
    }

    private fun circularRevealExample(view: View) {
        val cx = view.width / 2
        val cy = view.height / 2
        val finalRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()

        val circularReveal = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0f, finalRadius)
        view.visibility = View.VISIBLE
        circularReveal.start()
    }

    private fun valueAnimatorExample(view: View) {
        val animator = ValueAnimator.ofFloat(0f, 100f).apply {
            duration = 500
            interpolator = AccelerateDecelerateInterpolator()
            addUpdateListener { animation ->
                val animatedValue = animation.animatedValue as Float
                view.translationX = animatedValue
                view.alpha = 1 - (animatedValue / 100)
            }
        }
        animator.start()
    }

    private fun springAnimationExample(view: View) {
        val springAnim = SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0f).apply {
            spring.dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
            spring.stiffness = SpringForce.STIFFNESS_LOW
        }
        springAnim.setStartValue(100f)
        springAnim.start()
    }
}
