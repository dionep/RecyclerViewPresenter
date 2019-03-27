package net.kibotu.android.recyclerviewpresenter.app.kotlin

import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import net.kibotu.android.recyclerviewpresenter.PresenterAdapter
import net.kibotu.android.recyclerviewpresenter.RecyclerViewModel
import net.kibotu.android.recyclerviewpresenter.app.R
import net.kibotu.android.recyclerviewpresenter.app.misc.FakeDataGenerator.createRandomImageUrl


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PresenterAdapter<RecyclerViewModel<String>>()
        list.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        list.adapter = adapter

        adapter.onItemClick { item, view, position ->
            toast("$position. ${item.model}")
        }

        adapter.onFocusChange { item, view, hasFocus, position -> }


        for (i in 0 until 100) {
            adapter.append(RecyclerViewModel(createRandomImageUrl()), PhotoPresenter::class.java)
            adapter.append(RecyclerViewModel(createRandomImageUrl()), LabelPresenter::class.java)
        }

        //        adapter.update(0, "https://raw.githubusercontent.com/kibotu/RecyclerViewPresenter/master/screenshot.png");

        adapter.notifyDataSetChanged()
    }

    fun toast(message: String?) {
        if (isEmpty(message))
            return

        runOnUiThread {
            val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.BOTTOM, 0, 100)
            toast.show()
        }
    }
}