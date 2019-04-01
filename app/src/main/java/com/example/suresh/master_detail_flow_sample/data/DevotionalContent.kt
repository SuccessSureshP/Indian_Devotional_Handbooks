package com.example.suresh.master_detail_flow_sample.data

import java.util.ArrayList
import java.util.HashMap

object DevotionalContent {

    val ITEMS: MutableList<HandBookItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, HandBookItem> = HashMap()


    init {
        addItem(HandBookItem("1","Adhyatmika_Darshini","Adhyatmika_Darshini.pdf"))
        addItem(HandBookItem("2","Adhyatmika_Darshini-2","Adhyatmika_Darshini-2.pdf"))

        addItem(HandBookItem("3","Adhyatmika_Darshini-3","Adhyatmika_Darshini.pdf"))

        addItem(HandBookItem("4","Adhyatmika_Darshini-4","Adhyatmika_Darshini-2.pdf"))

    }

    private fun addItem(item: HandBookItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore bookFileName information here.")
        }
        return builder.toString()
    }

    data class HandBookItem(val id: String, val bookTitle: String, val bookFileName: String) {
        override fun toString(): String = bookTitle
    }
}
