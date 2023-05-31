package com.capstone.baliguide_app.ui.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.capstone.baliguide_app.R

class CustomInputText: AppCompatEditText  {
    private lateinit var textBackground: Drawable

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        background = textBackground
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }
    private fun init() {
        textBackground = ContextCompat.getDrawable(context, R.drawable.edittextstyle) as Drawable
    }
}