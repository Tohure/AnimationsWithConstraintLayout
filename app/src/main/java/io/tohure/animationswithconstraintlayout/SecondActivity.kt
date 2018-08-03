package io.tohure.animationswithconstraintlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private var selectedView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        addAnimation()
    }

    private fun addAnimation() {

        clContainer.setOnClickListener {
            Log.d("thr", "container")
            toDefault()
        }

        ivJavaLogo.setOnClickListener {
            Log.d("thr", "java")
            if (selectedView != ivJavaLogo) {
                updateConstraints(R.layout.activity_second_java)
                selectedView = ivJavaLogo
            } else {
                toDefault()
            }
        }

        ivKotlinLogo.setOnClickListener {
            Log.d("thr", "kotlin")
            if (selectedView != ivKotlinLogo) {
                updateConstraints(R.layout.activity_second_kotlin)
                selectedView = ivKotlinLogo
            } else {
                toDefault()
            }
        }

    }

    private fun toDefault() {
        if (selectedView != null) {
            updateConstraints(R.layout.activity_second)
            selectedView = null
        }
    }

    private fun updateConstraints(@LayoutRes id: Int) {
        ConstraintSet().apply {
            clone(this@SecondActivity, id)
            applyTo(clContainer)
        }

        ChangeBounds().apply {
            interpolator = OvershootInterpolator()
            TransitionManager.beginDelayedTransition(clContainer, this)
        }
    }
}
