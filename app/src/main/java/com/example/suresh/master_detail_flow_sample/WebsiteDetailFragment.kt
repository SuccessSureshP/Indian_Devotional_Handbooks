package com.example.suresh.master_detail_flow_sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.suresh.master_detail_flow_sample.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_website_detail.*
import kotlinx.android.synthetic.main.website_detail.view.*

import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle

/**
 * A fragment representing a single Website detail screen.
 * This fragment is either contained in a [WebsiteListActivity]
 * in two-pane mode (on tablets) or a [WebsiteDetailActivity]
 * on handsets.
 */
class WebsiteDetailFragment : Fragment(), OnPageChangeListener, OnLoadCompleteListener,
OnPageErrorListener  {

    private val TAG = WebsiteDetailFragment::class.java!!.simpleName

    override fun onPageChanged(page: Int, pageCount: Int) {
        pageNumber = page
       // setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount))
    }

    override fun loadComplete(nbPages: Int) {

    }

    override fun onPageError(page: Int, t: Throwable?) {
        Log.e(TAG, "Cannot load page $page")
    }

    internal var pageNumber: Int = 0

    /**
     * The dummy content this fragment is presenting.
     */
    val SAMPLE_FILE = "Adhyatmika_Darshini.pdf"
    private var item: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.toolbar_layout?.title = item?.content
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.website_detail, container, false)

        // Show the dummy content as text in a TextView.
//        item?.let {
//            rootView.website_detail.text = it.details
//        }

        rootView.pdfView.fromAsset(SAMPLE_FILE)
            .defaultPage(pageNumber)
            .onPageChange(this)
            .enableAnnotationRendering(true)
            .onLoad(this)
            .scrollHandle(DefaultScrollHandle(this.context))
            .spacing(5) // in dp
            .onPageError(this)
            .load()
        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
