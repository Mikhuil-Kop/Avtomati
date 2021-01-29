package gen;// Generated from /Users/mikekopotov/Documents/Avtomati/PR5/src/main/java/MyGrammatic.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MyGrammaticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MyGrammaticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MyGrammaticParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MyGrammaticParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammaticParser#add}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(MyGrammaticParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by {@link MyGrammaticParser#mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(MyGrammaticParser.MulContext ctx);
}