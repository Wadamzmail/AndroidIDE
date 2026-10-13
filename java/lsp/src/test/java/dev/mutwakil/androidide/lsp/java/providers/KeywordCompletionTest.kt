 /*
  *  This file is part of AndroidIDE.
  *
  *  AndroidIDE is free software: you can redistribute it and/or modify
  *  it under the terms of the GNU General Public License as published by
  *  the Free Software Foundation, either version 3 of the License, or
  *  (at your option) any later version.
  *
  *  AndroidIDE is distributed in the hope that it will be useful,
  *  but WITHOUT ANY WARRANTY; without even the implied warranty
  *  of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  *  GNU General Public License for more details.
  *
  *  You should have received a copy of the GNU General Public License
  *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
  */

package dev.mutwakil.androidide.lsp.java.providers

import com.google.common.truth.Truth.assertThat
import dev.mutwakil.androidide.lsp.java.JavaLSPTest
import dev.mutwakil.androidide.lsp.models.CompletionParams
import dev.mutwakil.androidide.models.Position
import dev.mutwakil.androidide.progress.ICancelChecker
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class KeywordCompletionTest {

  @Before
  fun setup() {
    JavaLSPTest.setup()
  }

  @Test
  fun packageDeclaration() {
    probe("completion/keywords/PackageDeclarationTest")
  }

  @Test
  fun importDeclaration() {
    probe("completion/keywords/ImportDeclarationTest")
  }

  @Test
  fun topLevelTypeDeclaration() {
    probe("completion/keywords/TopLevelTypeDeclarationTest")
  }

  @Test
  fun classModifiers() {
    probe("completion/keywords/ClassModifiersTest")
  }

  @Test
  fun classBody() {
    probe("completion/keywords/ClassBodyTest")
  }

  @Test
  fun fieldModifiers() {
    probe("completion/keywords/FieldModifiersTest")
  }

  @Test
  fun fieldType() {
    probe("completion/keywords/FieldTypeTest")
  }

  @Test
  fun methodModifiers() {
    probe("completion/keywords/MethodModifiersTest")
  }

  @Test
  fun methodReturnType() {
    probe("completion/keywords/MethodReturnTypeTest")
  }

  @Test
  fun methodThrows() {
    probe("completion/keywords/MethodThrowsTest")
  }

  @Test
  fun methodBody() {
    probe("completion/keywords/MethodBodyTest")
  }

  @Test
  fun localVariableType() {
    probe("completion/keywords/LocalVariableTypeTest")
  }

  @Test
  fun localVariableModifiers() {
    probe("completion/keywords/LocalVariableModifiersTest")
  }

  @Test
  fun expression() {
    probe("completion/keywords/ExpressionTest")
  }

  @Test
  fun throwStatement() {
    probe("completion/keywords/ThrowStatementTest")
  }

  @Test
  fun returnStatement() {
    probe("completion/keywords/ReturnStatementTest")
  }

  @Test
  fun ifStatement() {
    probe("completion/keywords/IfStatementTest")
  }

  @Test
  fun elseStatement() {
    probe("completion/keywords/ElseStatementTest")
  }

  @Test
  fun forStatement() {
    probe("completion/keywords/ForStatementTest")
  }

  @Test
  fun whileStatement() {
    probe("completion/keywords/WhileStatementTest")
  }

  @Test
  fun doStatement() {
    probe("completion/keywords/DoStatementTest")
  }

  @Test
  fun switchCase() {
    probe("completion/keywords/SwitchCaseTest")
  }

  @Test
  fun switchDefault() {
    probe("completion/keywords/SwitchDefaultTest")
  }

  @Test
  fun switchExpressionYield() {
    probe("completion/keywords/SwitchExpressionYieldTest")
  }

  @Test
  fun tryStatement() {
    probe("completion/keywords/TryStatementTest")
  }

  @Test
  fun catchClause() {
    probe("completion/keywords/CatchClauseTest")
  }

  @Test
  fun finallyClause() {
    probe("completion/keywords/FinallyClauseTest")
  }

  @Test
  fun synchronizedStatement() {
    probe("completion/keywords/SynchronizedStatementTest")
  }

  @Test
  fun tryWithResources() {
    probe("completion/keywords/TryWithResourcesTest")
  }

  @Test
  fun constructorBody() {
    probe("completion/keywords/ConstructorBodyTest")
  }

  @Test
  fun constructorInvocation() {
    probe("completion/keywords/ConstructorInvocationTest")
  }

  @Test
  fun lambdaBody() {
    probe("completion/keywords/LambdaBodyTest")
  }

  @Test
  fun classExtends() {
    probe("completion/keywords/ClassExtendsTest")
  }

  @Test
  fun classImplements() {
    probe("completion/keywords/ClassImplementsTest")
  }

  @Test
  fun interfaceBody() {
    probe("completion/keywords/InterfaceBodyTest")
  }

  @Test
  fun interfaceMethod() {
    probe("completion/keywords/InterfaceMethodTest")
  }

  @Test
  fun annotationInterfaceBody() {
    probe("completion/keywords/AnnotationInterfaceBodyTest")
  }

  @Test
  fun annotationDefault() {
    probe("completion/keywords/AnnotationDefaultTest")
  }

  @Test
  fun enumDeclaration() {
    probe("completion/keywords/EnumDeclarationTest")
  }

  @Test
  fun enumConstants() {
    probe("completion/keywords/EnumConstantsTest")
  }

  @Test
  fun enumBody() {
    probe("completion/keywords/EnumBodyTest")
  }

  @Test
  fun enumConstantClassBody() {
    probe("completion/keywords/EnumConstantClassBodyTest")
  }

  @Test
  fun recordDeclaration() {
    probe("completion/keywords/RecordDeclarationTest")
  }

  @Test
  fun recordHeader() {
    probe("completion/keywords/RecordHeaderTest")
  }

  @Test
  fun recordBody() {
    probe("completion/keywords/RecordBodyTest")
  }

  @Test
  fun recordConstructor() {
    probe("completion/keywords/RecordConstructorTest")
  }

  @Test
  fun sealedModifier() {
    probe("completion/keywords/SealedModifierTest")
  }

  @Test
  fun nonSealedModifier() {
    probe("completion/keywords/NonSealedModifierTest")
  }

  @Test
  fun permitsClause() {
    probe("completion/keywords/PermitsClauseTest")
  }

  @Test
  fun primitiveType() {
    probe("completion/keywords/PrimitiveTypeTest")
  }

  @Test
  fun newExpression() {
    probe("completion/keywords/NewExpressionTest")
  }

  @Test
  fun thisExpression() {
    probe("completion/keywords/ThisExpressionTest")
  }

  @Test
  fun superExpression() {
    probe("completion/keywords/SuperExpressionTest")
  }

  @Test
  fun instanceofExpression() {
    probe("completion/keywords/InstanceofExpressionTest")
  }

  private fun probe(file: String) {
    JavaLSPTest.apply {
      openFile(file)

      val pos = cursorPosition()
      val items = completionTitles(pos)

      println()
      println("==================================================")
      println("Keyword completion probe: $file")
      println("Cursor: $pos")
      println("Items:")
      items.forEach { println("  - $it") }
      println("==================================================")
      println()

      assertThat(items).isNotNull()
    }
  }

  private fun completionTitles(pos: Position): List<CharSequence> {
    return JavaLSPTest.server
      .complete(
        CompletionParams(
          pos,
          JavaLSPTest.file!!,
          ICancelChecker.NOOP,
        ).apply {
          prefix = ""
        },
      )
      .items
      .map { it.ideLabel }
  }
}