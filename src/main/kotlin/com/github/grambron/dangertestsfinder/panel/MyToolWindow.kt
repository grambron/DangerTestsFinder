package com.github.grambron.dangertestsfinder.panel

import com.github.grambron.dangertestsfinder.services.CurrentFileAnalyser
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel


class MyToolWindow {
    private lateinit var currentCount: JLabel
    private lateinit var myToolWindowContent: JPanel
    private lateinit var refreshToolWindowButton: JButton

    init {
        refreshToolWindowButton.addActionListener { countBadTests() }
    }

    private fun countBadTests() {
        val count = CurrentFileAnalyser.findBadTestsCount()
        if (count == null) {
            printNoFileOpened()
        } else {
            printTroubles(count)
        }
    }

    private fun printTroubles(count: Int) {
        currentCount.text = "Danger tests count: $count"
    }

    private fun printNoFileOpened() {
        currentCount.text = "No python file opened"
    }

    fun getContent(): JPanel {
        return myToolWindowContent
    }

    init {
        countBadTests()
    }
}
