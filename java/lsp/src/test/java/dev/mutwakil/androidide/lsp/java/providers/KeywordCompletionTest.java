package dev.mutwakil.androidide.lsp.java.providers;

import static com.google.common.truth.Truth.assertThat;

import dev.mutwakil.androidide.lsp.java.JavaLSPTest;
import dev.mutwakil.androidide.lsp.models.CompletionParams;
import dev.mutwakil.androidide.models.Position;
import dev.mutwakil.androidide.progress.ICancelChecker;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

/**
 * Tests keyword completion in different Java 17 syntactic contexts.
 *
 * <p>These tests are intentionally broad for now. The main purpose is to run completion at
 * carefully selected AST positions so that KeywordCompletionProvider can log and expose the
 * actual TreePath for each context.
 *
 * @author Akash Yadav
 */
@RunWith(RobolectricTestRunner.class)
public class KeywordCompletionTest {

  @Before
  public void setup() {
    JavaLSPTest.setup();
  }

  @Test
  public void packageDeclaration() {
    probe("completion/keywords/PackageDeclarationTest");
  }

  @Test
  public void importDeclaration() {
    probe("completion/keywords/ImportDeclarationTest");
  }

  @Test
  public void topLevelTypeDeclaration() {
    probe("completion/keywords/TopLevelTypeDeclarationTest");
  }

  @Test
  public void classModifiers() {
    probe("completion/keywords/ClassModifiersTest");
  }

  @Test
  public void classBody() {
    probe("completion/keywords/ClassBodyTest");
  }

  @Test
  public void fieldModifiers() {
    probe("completion/keywords/FieldModifiersTest");
  }

  @Test
  public void fieldType() {
    probe("completion/keywords/FieldTypeTest");
  }

  @Test
  public void methodModifiers() {
    probe("completion/keywords/MethodModifiersTest");
  }

  @Test
  public void methodReturnType() {
    probe("completion/keywords/MethodReturnTypeTest");
  }

  @Test
  public void methodThrows() {
    probe("completion/keywords/MethodThrowsTest");
  }

  @Test
  public void methodBody() {
    probe("completion/keywords/MethodBodyTest");
  }

  @Test
  public void localVariableType() {
    probe("completion/keywords/LocalVariableTypeTest");
  }

  @Test
  public void localVariableModifiers() {
    probe("completion/keywords/LocalVariableModifiersTest");
  }

  @Test
  public void expression() {
    probe("completion/keywords/ExpressionTest");
  }

  @Test
  public void throwStatement() {
    probe("completion/keywords/ThrowStatementTest");
  }

  @Test
  public void returnStatement() {
    probe("completion/keywords/ReturnStatementTest");
  }

  @Test
  public void ifStatement() {
    probe("completion/keywords/IfStatementTest");
  }

  @Test
  public void elseStatement() {
    probe("completion/keywords/ElseStatementTest");
  }

  @Test
  public void forStatement() {
    probe("completion/keywords/ForStatementTest");
  }

  @Test
  public void whileStatement() {
    probe("completion/keywords/WhileStatementTest");
  }

  @Test
  public void doStatement() {
    probe("completion/keywords/DoStatementTest");
  }

  @Test
  public void switchCase() {
    probe("completion/keywords/SwitchCaseTest");
  }

  @Test
  public void switchDefault() {
    probe("completion/keywords/SwitchDefaultTest");
  }

  @Test
  public void switchExpressionYield() {
    probe("completion/keywords/SwitchExpressionYieldTest");
  }

  @Test
  public void tryStatement() {
    probe("completion/keywords/TryStatementTest");
  }

  @Test
  public void catchClause() {
    probe("completion/keywords/CatchClauseTest");
  }

  @Test
  public void finallyClause() {
    probe("completion/keywords/FinallyClauseTest");
  }

  @Test
  public void synchronizedStatement() {
    probe("completion/keywords/SynchronizedStatementTest");
  }

  @Test
  public void tryWithResources() {
    probe("completion/keywords/TryWithResourcesTest");
  }

  @Test
  public void constructorBody() {
    probe("completion/keywords/ConstructorBodyTest");
  }

  @Test
  public void constructorInvocation() {
    probe("completion/keywords/ConstructorInvocationTest");
  }

  @Test
  public void lambdaBody() {
    probe("completion/keywords/LambdaBodyTest");
  }

  @Test
  public void classExtends() {
    probe("completion/keywords/ClassExtendsTest");
  }

  @Test
  public void classImplements() {
    probe("completion/keywords/ClassImplementsTest");
  }

  @Test
  public void interfaceBody() {
    probe("completion/keywords/InterfaceBodyTest");
  }

  @Test
  public void interfaceMethod() {
    probe("completion/keywords/InterfaceMethodTest");
  }

  @Test
  public void annotationInterfaceBody() {
    probe("completion/keywords/AnnotationInterfaceBodyTest");
  }

  @Test
  public void annotationDefault() {
    probe("completion/keywords/AnnotationDefaultTest");
  }

  @Test
  public void enumDeclaration() {
    probe("completion/keywords/EnumDeclarationTest");
  }

  @Test
  public void enumConstants() {
    probe("completion/keywords/EnumConstantsTest");
  }

  @Test
  public void enumBody() {
    probe("completion/keywords/EnumBodyTest");
  }

  @Test
  public void enumConstantClassBody() {
    probe("completion/keywords/EnumConstantClassBodyTest");
  }

  @Test
  public void recordDeclaration() {
    probe("completion/keywords/RecordDeclarationTest");
  }

  @Test
  public void recordHeader() {
    probe("completion/keywords/RecordHeaderTest");
  }

  @Test
  public void recordBody() {
    probe("completion/keywords/RecordBodyTest");
  }

  @Test
  public void recordConstructor() {
    probe("completion/keywords/RecordConstructorTest");
  }

  @Test
  public void sealedModifier() {
    probe("completion/keywords/SealedModifierTest");
  }

  @Test
  public void nonSealedModifier() {
    probe("completion/keywords/NonSealedModifierTest");
  }

  @Test
  public void permitsClause() {
    probe("completion/keywords/PermitsClauseTest");
  }

  @Test
  public void primitiveType() {
    probe("completion/keywords/PrimitiveTypeTest");
  }

  @Test
  public void newExpression() {
    probe("completion/keywords/NewExpressionTest");
  }

  @Test
  public void thisExpression() {
    probe("completion/keywords/ThisExpressionTest");
  }

  @Test
  public void superExpression() {
    probe("completion/keywords/SuperExpressionTest");
  }

  @Test
  public void instanceofExpression() {
    probe("completion/keywords/InstanceofExpressionTest");
  }

  private void probe(String file) {
    JavaLSPTest.apply(
        () -> {
          openFile(file);

          Position position = cursorPosition();

          List<CharSequence> items = completionTitles(position);

          System.out.println();
          System.out.println("==================================================");
          System.out.println("Keyword completion probe: " + file);
          System.out.println("Cursor: " + position);
          System.out.println("Items: " + items);
          System.out.println("==================================================");
          System.out.println();

          assertThat(items).isNotNull();
        });
  }

  private List<CharSequence> completionTitles(Position position) {
    return JavaLSPTest.server
        .complete(
            new CompletionParams(
                position,
                JavaLSPTest.file,
                ICancelChecker.NOOP) {
              {
                setPrefix("");
              }
            })
        .getItems()
        .stream()
        .map(item -> item.getIdeLabel())
        .collect(java.util.stream.Collectors.toList());
  }
}