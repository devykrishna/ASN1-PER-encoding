//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;LEFT_BRACKET_TKN&gt;
 * nodeOptional -> [ TagClass() ]
 * classNumber -> ClassNumber()
 * nodeToken1 -> &lt;RIGHT_BRACKET_TKN&gt;
 * </PRE>
 */
public class Tag implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public NodeOptional nodeOptional;
   public ClassNumber classNumber;
   public NodeToken nodeToken1;

   public Tag(NodeToken n0, NodeOptional n1, ClassNumber n2, NodeToken n3) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeOptional = n1;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      classNumber = n2;
      if ( classNumber != null ) classNumber.setParent(this);
      nodeToken1 = n3;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
   }

   public Tag(NodeOptional n0, ClassNumber n1) {
      nodeToken = new NodeToken("[");
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeOptional = n0;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      classNumber = n1;
      if ( classNumber != null ) classNumber.setParent(this);
      nodeToken1 = new NodeToken("]");
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
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

