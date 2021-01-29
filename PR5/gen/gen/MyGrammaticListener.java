package gen;// Generated from /Users/mikekopotov/Documents/Avtomati/PR5/src/main/java/MyGrammatic.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammaticParser}.
 */
public interface MyGrammaticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyGrammaticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MyGrammaticParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammaticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MyGrammaticParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammaticParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(MyGrammaticParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammaticParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(MyGrammaticParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammaticParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(MyGrammaticParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammaticParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(MyGrammaticParser.MulContext ctx);
}