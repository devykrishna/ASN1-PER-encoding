//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeOptional -> [ &lt;LESSER_THAN_TKN&gt; ]
 * upperEndValue -> UpperEndValue()
 * </PRE>
 */
public class UpperEndpoint implements Node {
   private Node parent;
   public NodeOptional nodeOptional;
   public UpperEndValue upperEndValue;

   public UpperEndpoint(NodeOptional n0, UpperEndValue n1) {
      nodeOptional = n0;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      upperEndValue = n1;
      if ( upperEndValue != null ) upperEndValue.setParent(this);
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

