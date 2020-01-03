package com.seven.clip.emojendar

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.seven.clip.emojendar.fragments.MainGameFragment
import com.vanniktech.emoji.EmojiManager
import com.vanniktech.emoji.google.GoogleEmojiProvider


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EmojiManager.install(GoogleEmojiProvider())

        initFragments(savedInstanceState)
    }
    private fun initFragments(savedInstanceState: Bundle?) {
        if (findViewById<View>(R.id.fragment_container) != null) {
            if (savedInstanceState != null) return
            val mainGameFragment = MainGameFragment()
            pushFragment(mainGameFragment, null)
        }
    }

    fun pushFragment(fragment: Fragment, bundle: Bundle?) {
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        val previousFragment = supportFragmentManager.findFragmentByTag("currentFragment")
        ft.setCustomAnimations(
            R.anim.frag_fade_zoom_in_enter,
            R.anim.frag_fade_zoom_in_exit,
            R.anim.frag_fade_zoom_out_enter,
            R.anim.frag_fade_zoom_out_exit
        )
        if (previousFragment != null) ft.hide(previousFragment)
        if (bundle != null) fragment.arguments = bundle
        ft.add(R.id.fragment_container, fragment, "currentFragment")
        if (previousFragment != null) ft.addToBackStack(null)
        ft.commit()
    }

}
