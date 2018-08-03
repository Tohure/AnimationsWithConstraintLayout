package io.tohure.animationswithconstraintlayout

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        addAnimation()
    }

    private fun addAnimation() {
        var bigLayout = false
        val constraintSet1 = ConstraintSet()
        constraintSet1.clone(clContainer)
        val constraintSet2 = ConstraintSet()
        constraintSet2.clone(this, R.layout.activity_first_biggest)

        ivImage.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(clContainer)
                val constraint = if (bigLayout) constraintSet1 else constraintSet2
                constraint.applyTo(clContainer)
                bigLayout = !bigLayout
            }
        }

    }
}
