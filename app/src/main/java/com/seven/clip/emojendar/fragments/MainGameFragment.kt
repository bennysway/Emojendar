package com.seven.clip.emojendar.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.seven.clip.emojendar.R
import com.seven.clip.emojendar.SimpleAdapter
import kotlinx.android.synthetic.main.fragment_main_game.*
import life.sabujak.shyshark.ShySharkLayoutManager.Companion.SWIPE_BOTTOM
import life.sabujak.shyshark.ShySharkLayoutManager.Companion.SWIPE_LEFT
import life.sabujak.shyshark.ShySharkLayoutManager.Companion.SWIPE_RIGHT
import life.sabujak.shyshark.ShySharkLayoutManager.Companion.SWIPE_TOP
import life.sabujak.shyshark.listener.OnSwipeListener


class MainGameFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_game,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = SimpleAdapter(
            arrayListOf(
                R.drawable.ic_1f478_1f3fc,
                R.drawable.ic_1f3f4_2620,
                R.drawable.ic_1f602,
                R.drawable.ic_1f923,
                R.drawable.ic_1f603,
                R.drawable.ic_1f604,
                R.drawable.ic_1f606,
                R.drawable.ic_1f60a,
                R.drawable.ic_1f60b
            )
        )
        recyclerView.setOnSwipeListener(object :
            OnSwipeListener {
            override fun onChangeHorizontalDrag(direction: Int, percent: Float) {
            }

            override fun onChangeVerticalDrag(direction: Int, percent: Float) {
            }

            override fun onSwiped(position: Int, direction: Int) {
                when (direction) {
                    SWIPE_LEFT -> {
                        println("swiped LEFT!! $position")
                    }
                    SWIPE_RIGHT -> {
                        println("swiped RIGHT $position")
                    }
                    SWIPE_TOP -> {
                        recyclerView.previousView()
                    }
                    SWIPE_BOTTOM -> {
                        println("swiped BOTTOM $position")
                    }
                }
            }
        })
    }
}