//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * namedValue -> NamedValue()
 * nodeListOptional -> ( &lt;COMMA_TKN&gt; NamedValue() )*
 * </PRE>
 */
public class ComponentValueList implements Node {
   private Node parent;
   public NamedValue namedValue;
   public NodeListOptional nodeListOptional;

   public ComponentValueList(NamedValue n0, NodeListOptional n1) {
      namedValue = n0;
      if ( namedValue != null ) namedValue.setParent(this);
      nodeListOptional = n1;
      if ( nodeListOptional != null ) nodeListOptional.setParent(this);
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

