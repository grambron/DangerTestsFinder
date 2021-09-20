package com.github.grambron.dangertestsfinder.panel

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.Content
import com.intellij.ui.content.ContentFactory


class BadTestsCountPanelFactory: ToolWindowFactory {

    override fun createToolWindowContent(p0: Project, toolWindow: ToolWindow) {
        val myToolWindow = MyToolWindow()
        val contentFactory = ContentFactory.SERVICE.getInstance()
        val content: Content = contentFactory.createContent(myToolWindow.getContent(), "", false)
        toolWindow.contentManager.addContent(content)
    }

}