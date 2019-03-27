package net.kibotu.android.recyclerviewpresenter

import android.view.View

data class RecyclerViewModel<T : Comparable<T>>(
    val model: T,
    val uuid: String = UIDGenerator.newUID().toString(),
    /**
     * Invokes click listener.
     *
     * @param item  Model of the adapter.
     * @param view  View that has been clicked.
     * @param position Adapter position of the clicked element.
     */
    val onItemClickListener: ((item: T, view: View, position: Int) -> Unit)? = null
)