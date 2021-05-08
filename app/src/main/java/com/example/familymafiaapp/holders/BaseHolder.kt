package com.example.familymafiaapp.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

open class BaseHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer