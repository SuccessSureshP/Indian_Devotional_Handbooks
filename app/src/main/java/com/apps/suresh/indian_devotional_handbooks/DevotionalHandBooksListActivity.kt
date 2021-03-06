package com.apps.suresh.indian_devotional_handbooks

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.apps.suresh.indian_devotional_handbooks.data.DevotionalContent
import kotlinx.android.synthetic.main.activity_devotional_handbook_list.*
import kotlinx.android.synthetic.main.handbook_list_content.view.*
import kotlinx.android.synthetic.main.handbooks_list.*

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [DevotionalHandBookDetailActivity] representing
 * item twoSidesBookFileName. On tablets, the activity presents the list of items and
 * item twoSidesBookFileName side-by-side using two vertical panes.
 */
class DevotionalHandBooksListActivity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devotional_handbook_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener { view ->
            if (twoPane) {
                this.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.website_detail_container, AboutPageFragment())
                    .commit()
            } else {
                val intent = Intent(view.context, AboutPageActivity::class.java)
                view.context.startActivity(intent)
            }
        }

        if (website_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        setupRecyclerView(website_list)
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, DevotionalContent.ITEMS, twoPane)
    }

    class SimpleItemRecyclerViewAdapter(private val parentActivity: DevotionalHandBooksListActivity,
                                        private val values: List<DevotionalContent.HandBookItem>,
                                        private val twoPane: Boolean) :
            RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        private val onClickListener: View.OnClickListener

        init {
            onClickListener = View.OnClickListener { v ->
                val item = v.tag as DevotionalContent.HandBookItem
                if (twoPane) {
                    val fragment = DevotionalHandBookDetailFragment().apply {
                        arguments = Bundle().apply {
                            putString(DevotionalHandBookDetailFragment.ARG_ITEM_ID, item.id)
                            putBoolean(DevotionalHandBookDetailFragment.ARG_TWO_PANE, twoPane)
                        }
                    }
                    parentActivity.supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.website_detail_container, fragment)
                            .commit()
                } else {
                    val intent = Intent(v.context, DevotionalHandBookDetailActivity::class.java).apply {
                        putExtra(DevotionalHandBookDetailFragment.ARG_ITEM_ID, item.id)
                    }
                    v.context.startActivity(intent)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.handbook_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            holder.idView.text = item.id
            holder.contentView.text = item.bookTitle

            with(holder.itemView) {
                tag = item
                setOnClickListener(onClickListener)
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val idView: TextView = view.id_text
            val contentView: TextView = view.content
        }
    }
}
