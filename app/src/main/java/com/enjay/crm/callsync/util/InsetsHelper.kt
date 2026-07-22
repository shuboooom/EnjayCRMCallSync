package com.enjay.crm.callsync.util

import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private data class InitialPadding(
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int,
)

private data class InitialMargins(
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int,
)

private fun View.recordInitialPadding() = InitialPadding(
    left = paddingLeft,
    top = paddingTop,
    right = paddingRight,
    bottom = paddingBottom,
)

private fun View.recordInitialMargins(): InitialMargins? {
    val params = layoutParams as? ViewGroup.MarginLayoutParams ?: return null
    return InitialMargins(
        left = params.leftMargin,
        top = params.topMargin,
        right = params.rightMargin,
        bottom = params.bottomMargin,
    )
}

private fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        requestApplyInsets()
    } else {
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

fun View.applyInsetPadding(
    left: Boolean = false,
    top: Boolean = false,
    right: Boolean = false,
    bottom: Boolean = false,
    insetTypes: Int = WindowInsetsCompat.Type.systemBars(),
    consume: Boolean = false,
) {
    val initialPadding = recordInitialPadding()

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val appliedInsets = insets.getInsets(insetTypes)
        view.setPadding(
            initialPadding.left + if (left) appliedInsets.left else 0,
            initialPadding.top + if (top) appliedInsets.top else 0,
            initialPadding.right + if (right) appliedInsets.right else 0,
            initialPadding.bottom + if (bottom) appliedInsets.bottom else 0,
        )

        if (consume) WindowInsetsCompat.CONSUMED else insets
    }

    requestApplyInsetsWhenAttached()
}

fun View.applyInsetMargins(
    left: Boolean = false,
    top: Boolean = false,
    right: Boolean = false,
    bottom: Boolean = false,
    insetTypes: Int = WindowInsetsCompat.Type.systemBars(),
    consume: Boolean = false,
) {
    val initialMargins = recordInitialMargins() ?: return

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        val appliedInsets = insets.getInsets(insetTypes)
        val params = view.layoutParams as? ViewGroup.MarginLayoutParams
        if (params != null) {
            params.leftMargin = initialMargins.left + if (left) appliedInsets.left else 0
            params.topMargin = initialMargins.top + if (top) appliedInsets.top else 0
            params.rightMargin = initialMargins.right + if (right) appliedInsets.right else 0
            params.bottomMargin = initialMargins.bottom + if (bottom) appliedInsets.bottom else 0
            view.layoutParams = params
        }

        if (consume) WindowInsetsCompat.CONSUMED else insets
    }

    requestApplyInsetsWhenAttached()
}

fun View.applyTopSystemBarMargin() {
    applyInsetMargins(top = true)
}

fun View.applyBottomSystemBarPadding() {
    applyInsetPadding(bottom = true)
}

fun View.applyTopSystemBarPadding() {
    applyInsetPadding(top = true)
}

fun View.applyHorizontalSystemBarPadding() {
    applyInsetPadding(left = true, right = true)
}