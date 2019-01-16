package com.example.suresh.master_detail_flow_sample.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
//        for (i in 1..COUNT) {
//            addItem(createDummyItem(i))
//        }

        addItem(DummyItem("1","DNA Team DNA TeamDNA TeamDNA TeamDNA TeamDNA TeamDNA TeamDNA TeamDNA Team","\nDIG Native mobile Apps(DNA)  team builds the Health Connect Android and IOS apps. \n\n\nTeam repositories: \n\n   Coming soon"))
        addItem(DummyItem("2","FUEGO Team","\nFuego team builds the backend APIs which talks to EMR Systems like EPIC. Many teams uses those APIs. \n\n\nTeam repositories: \n\n   Coming soon"))

        addItem(DummyItem("3","HIELO Team","\nHIELO team builds the backend APIs for communications platform: WebRTC SDK Mobile & Web. (Video backend) \n\n\nTeam repositories: \n\n   Coming soon"))

        addItem(DummyItem("4","FESTIVUS Team","\nPatient facing web frontend. \n\n\nTeam repositories: \n\n   Coming soon"))

        addItem(DummyItem("5","WATCHTOWER Team","\nProvider facing web frontend. \n\n\nTeam repositories: \n\n   Coming soon"))

        addItem(DummyItem("6","QA Team","\nQA team does the Quality assurance and testing of the Mobile and Web apps. They also do the automation work. \n\n\nTeam repositories: \n\n   Coming soon"))
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
