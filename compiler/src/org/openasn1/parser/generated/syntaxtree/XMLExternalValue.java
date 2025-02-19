//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeOptional -> [ XMLSequenceValue() ]
 * </PRE>
 */
public class XMLExternalValue implements Node {
   private Node parent;
   public NodeOptional nodeOptional;

   public XMLExternalValue(NodeOptional n0) {
      nodeOptional = n0;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
   }

   public void accept(org.openasn1.parser.generated.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(org.openasn1.parser.generated.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(org.openasn1.parser.generated.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(org.openasn1.parser.generated.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}

