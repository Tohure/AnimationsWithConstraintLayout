package io.tohure.animationswithconstraintlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        addAnimation()
    }

    private fun addAnimation() {

        btnAskSize.setOnClickListener {
            updateConstraints(R.layout.activity_third_alt)
            btnAskSize.text = "ADD TO CART - 1234 INR"
        }

        ibtnClose.setOnClickListener {
            updateConstraints(R.layout.activity_third)
            btnAskSize.text = "SELECT SIZE"
        }
    }

    private fun updateConstraints(@LayoutRes id: Int) {

        ConstraintSet().apply {
            clone(this@ThirdActivity, id)
            applyTo(clContainer)
        }

        ChangeBounds().apply {
            interpolator = OvershootInterpolator()
            TransitionManager.beginDelayedTransition(clContainer, this)
        }

    }


}
