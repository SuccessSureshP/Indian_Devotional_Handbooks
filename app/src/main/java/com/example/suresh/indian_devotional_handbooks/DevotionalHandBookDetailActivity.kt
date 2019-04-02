package com.example.suresh.indian_devotional_handbooks

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.NavUtils
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_devotional_handbook_detail.*

/**
 * An activity representing a single Website detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item twoSidesBookFileName are presented side-by-side with a list of items
 * in a [DevotionalHandBooksListActivity].
 */
class DevotionalHandBookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_devotional_handbook_detail)
        setSupportActionBar(detail_toolbar)
        app_bar.setExpanded(false,true)

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = DevotionalHandBookDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(DevotionalHandBookDetailFragment.ARG_ITEM_ID,
                            intent.getStringExtra(DevotionalHandBookDetailFragment.ARG_ITEM_ID))
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.devotional_handbook_container, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> {
                    // This ID represents the Home or Up button. In the case of this
                    // activity, the Up button is shown. Use NavUtils to allow users
                    // to navigate up one level in the application structure. For
                    // more twoSidesBookFileName, see the Navigation pattern on Android Design:
                    //
                    // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                    NavUtils.navigateUpTo(this, Intent(this, DevotionalHandBooksListActivity::class.java))
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
}
