package net.kibotu.android.recyclerviewpresenter

import androidx.recyclerview.widget.RecyclerView

/**
 * Created by [Jan Rabe](https://about.me/janrabe).
 */

interface IBaseViewHolder {

    var onDetachListener: ((recyclerView: RecyclerView) -> Unit)?

    var onAttachListener: ((recyclerView: RecyclerView) -> Unit)?

    /**
     * [RecyclerView.Adapter.onBindViewHolder]
     */
    fun onViewAttachedToWindow()

    /**
     * [RecyclerView.Adapter.onViewDetachedFromWindow]
     */
    fun onViewDetachedFromWindow()

    /**
     * [RecyclerView.Adapter.onViewRecycled]
     */
    fun onViewRecycled() {

    }

    /**
     * [RecyclerView.Adapter.onFailedToRecycleView]
     */
    fun onFailedToRecycleView(): Boolean = false
}