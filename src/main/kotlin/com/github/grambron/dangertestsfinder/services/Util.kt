package com.github.grambron.dangertestsfinder.services

import com.jetbrains.python.psi.PyClass
import com.jetbrains.python.psi.PyFunction

val PyClass.isTestClass
    get() = children.isNotEmpty() && children[0].children.any { it.text == "unittest.TestCase" }

val PyFunction.isNameInvalid
    get() = parameterList.parameters.firstOrNull()?.text == "self"
            && name?.let { it.startsWith("test") && it.contains("c") } ?: false

