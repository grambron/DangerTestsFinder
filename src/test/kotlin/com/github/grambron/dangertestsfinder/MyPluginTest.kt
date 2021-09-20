package com.github.grambron.dangertestsfinder

import com.github.grambron.dangertestsfinder.services.DangerTestsVisitor
import com.intellij.codeInspection.LocalInspectionToolSession
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.jetbrains.python.psi.PyFile
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.mockito.Mockito.times

class MyPluginTest : BasePlatformTestCase() {

    fun testProblemsDetected() {
        val file = myFixture.configureByFile("someCodeExample.py") as PyFile

        val problemsHolder = Mockito.mock(ProblemsHolder::class.java)
        val session = Mockito.mock(LocalInspectionToolSession::class.java)

        Mockito.`when`(session.file).thenReturn(file)
        val visitor = DangerTestsVisitor(problemsHolder, session)
        file.topLevelClasses.forEach { it.accept(visitor) }

        Mockito.verify(problemsHolder, times(3))
            .registerProblem(any(), anyString())
    }


    override fun getTestDataPath() = "src/test/testData/pyExamples"
}
