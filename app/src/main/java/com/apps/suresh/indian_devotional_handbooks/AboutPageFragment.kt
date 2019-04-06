package com.apps.suresh.indian_devotional_handbooks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.suresh.indian_devotional_handbooks.data.DevotionalContent
import kotlinx.android.synthetic.main.activity_devotional_handbook_detail.*
import kotlinx.android.synthetic.main.fragment_devotional_handbook_detail.view.*

import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle

/**
 * A fragment representing a single Website detail screen.
 * This fragment is either contained in a [DevotionalHandBooksListActivity]
 * in two-pane mode (on tablets) or a [DevotionalHandBookDetailActivity]
 * on handsets.
 */
class AboutPageFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_about_page, container, false)

        return rootView
    }
}
