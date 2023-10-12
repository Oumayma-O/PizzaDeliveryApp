package com.example.pizzadeliveryapp.activities

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface OnItemClickListener {
    fun onItemClick(view: View, position: Int)
}

class RecyclerItemClickListener(
    private val recyclerView: RecyclerView,
    private val listener: OnItemClickListener
) : RecyclerView.SimpleOnItemTouchListener() {

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val childView = rv.findChildViewUnder(e.x, e.y)
        if (childView != null) {
            listener.onItemClick(childView, rv.getChildAdapterPosition(childView))
        }
        return super.onInterceptTouchEvent(rv, e)
    }
}
