package com.github.grambron.dangertestsfinder.services

import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.project.ProjectManager
import com.intellij.psi.PsiManager
import com.jetbrains.python.psi.PyFile


object CurrentFileAnalyser {

    fun findBadTestsCount(): Int? {
        val project = ProjectManager.getInstance().openProjects.first()
        val document = FileEditorManager.getInstance(project).selectedTextEditor?.document ?: return null
        val file = FileDocumentManager.getInstance().getFile(document) ?: return null
        val psiFile = PsiManager.getInstance(project).findFile(file) ?: return null
        val pyFile = psiFile as? PyFile ?: return null
        return analyseFile(pyFile)
    }

    private fun analyseFile(pyFile: PyFile): Int {
        return pyFile.topLevelClasses
            .filter { it.isTestClass }
            .sumOf { pyClass ->
                pyClass.methods.count { it.isNameInvalid }
            }
    }

}