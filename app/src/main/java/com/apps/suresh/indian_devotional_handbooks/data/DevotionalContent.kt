package com.apps.suresh.indian_devotional_handbooks.data

import java.util.ArrayList
import java.util.HashMap

object DevotionalContent {

    val ITEMS: MutableList<HandBookItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, HandBookItem> = HashMap()


    init {
        addItem(HandBookItem("1","అధ్మాత్మిక దర్శిని","Adhyatmika_Darshini_Two_side_view.pdf", "Adhyatmika_Darshini_Two_side_view.pdf"))
        addItem(HandBookItem("2","అధ్మాత్మిక దర్శిని-2","Adhyatmika_Darshini-2_Two_side_view.pdf", "Adhyatmika_Darshini-2_Two_side_view.pdf"))

        addItem(HandBookItem("3","Adhyatmika_Darshini-3","Adhyatmika_Darshini_Two_side_view.pdf", "Adhyatmika_Darshini_One_side_view.pdf"))

        addItem(HandBookItem("4","Adhyatmika_Darshini-4","Adhyatmika_Darshini-2_Two_side_view.pdf", "Adhyatmika_Darshini-2_Two_side_view.pdf"))
    }

    private fun addItem(item: HandBookItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    data class HandBookItem(val id: String, val bookTitle: String, val twoSidesBookFileName: String, val oneSideBookFileName: String) {
        override fun toString(): String = bookTitle
    }
}
