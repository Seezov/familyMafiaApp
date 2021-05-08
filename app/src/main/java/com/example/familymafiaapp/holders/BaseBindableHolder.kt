package com.example.familymafiaapp.holders

import android.view.View

abstract class BaseBindableHolder<T>(itemView: View) : BaseHolder(itemView) {

    abstract fun onBind(item: T)
}