//
// Generated by JTB 1.3.2
//

package com.github.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;FROM_TKN&gt;
 * constraint -> Constraint()
 * </PRE>
 */
public class PermittedAlphabet implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public Constraint constraint;

   public PermittedAlphabet(NodeToken n0, Constraint n1) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      constraint = n1;
      if ( constraint != null ) constraint.setParent(this);
   }

   public PermittedAlphabet(Constraint n0) {
      nodeToken = new NodeToken("FROM");
      if ( nodeToken != null ) nodeToken.setParent(this);
      constraint = n0;
      if ( constraint != null ) constraint.setParent(this);
   }

   public void accept(com.github.openasn1.parser.generated.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(com.github.openasn1.parser.generated.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(com.github.openasn1.parser.generated.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(com.github.openasn1.parser.generated.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}
