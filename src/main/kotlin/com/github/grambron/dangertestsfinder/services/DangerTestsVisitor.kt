package com.github.grambron.dangertestsfinder.services

import com.intellij.codeInspection.LocalInspectionToolSession
import com.intellij.codeInspection.ProblemsHolder
import com.jetbrains.python.inspections.PyInspectionVisitor
import com.jetbrains.python.psi.PyClass
import com.jetbrains.python.psi.PyFunction

class DangerTestsVisitor(
    holder: ProblemsHolder,
    session: LocalInspectionToolSession
) : PyInspectionVisitor(holder, session) {

    override fun visitPyClass(node: PyClass) {
        if (node.isTestClass) {
            node.methods.filter { it.isNameInvalid}.forEach { registerProblem(it) }
        }
    }

    private fun registerProblem(it: PyFunction) {
        holder?.registerProblem(it.nameIdentifier!!, "Invalid method name")
    }

}