package com.nbadal.ktlint.actions

import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer
import com.intellij.codeInsight.intention.impl.BaseIntentionAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.nbadal.ktlint.KtlintConfigStorage

class KtlintDisableAction : BaseIntentionAction() {
    override fun getFamilyName() = "ktlint"

    override fun getText() = "Disable ktlint"

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?) = true

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {
        // Disable and restart analyzer to clear annotations
        KtlintConfigStorage.instance(project).enableKtlint = false
        DaemonCodeAnalyzer.getInstance(project).restart()
    }
}
