//
// Generated by JTB 1.3.2
//

package com.github.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * namedBit -> NamedBit()
 * nodeListOptional -> ( &lt;COMMA_TKN&gt; NamedBit() )*
 * </PRE>
 */
public class NamedBitList implements Node {
   private Node parent;
   public NamedBit namedBit;
   public NodeListOptional nodeListOptional;

   public NamedBitList(NamedBit n0, NodeListOptional n1) {
      namedBit = n0;
      if ( namedBit != null ) namedBit.setParent(this);
      nodeListOptional = n1;
      if ( nodeListOptional != null ) nodeListOptional.setParent(this);
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
