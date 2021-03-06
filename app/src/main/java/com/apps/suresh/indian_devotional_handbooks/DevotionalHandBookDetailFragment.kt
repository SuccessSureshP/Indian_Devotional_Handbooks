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
class DevotionalHandBookDetailFragment : Fragment(), OnPageChangeListener, OnLoadCompleteListener,
OnPageErrorListener  {

    private val TAG = DevotionalHandBookDetailFragment::class.java!!.simpleName

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

    private var twoPane = false

    private var item: DevotionalContent.HandBookItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the bookTitle specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load bookTitle from a bookTitle provider.
                item = DevotionalContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                twoPane = it.getBoolean(ARG_TWO_PANE)
                activity?.toolbar_layout?.title = item?.bookTitle
            }
        }
    }

    //@SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_devotional_handbook_detail, container, false)

        var fileName = if(twoPane) item?.twoSidesBookFileName else item?.oneSideBookFileName


        //rootView.pdfWebView.settings.javaScriptEnabled = true
        //rootView.pdfWebView.settings.pluginState = WebSettings.PluginState.ON

        //rootView.pdfWebView.loadUrl ("https://www.theringer.com/nfl/2019/4/3/18293446/arizona-cardinals-revolutionize-nfl-draft-josh-rosen-kyler-murray")

        //rootView.pdfWebView.loadUrl ("https://www.slideshare.net/sureshpokkuluri/adhyatmika-darshini-onesideview")
        //rootView.pdfWebView.loadUrl ("https://www.slideshare.net/sureshpokkuluri/adhyatmika-darshini-twosideview")
        //rootView.pdfWebView.loadUrl ("https://unsplash.com/")


        //rootView.pdfView.fromUri(Uri.parse ("http://www.africau.edu/images/default/sample.pdf"))
        rootView.pdfView.fromAsset(fileName)
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
        const val ARG_TWO_PANE = "two_pane"
    }
}
