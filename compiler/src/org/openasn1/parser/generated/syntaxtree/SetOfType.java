//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;SET_TKN&gt;
 * nodeToken1 -> &lt;OF_TKN&gt;
 * typeOrNamedType -> TypeOrNamedType()
 * </PRE>
 */
public class SetOfType implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public TypeOrNamedType typeOrNamedType;

   public SetOfType(NodeToken n0, NodeToken n1, TypeOrNamedType n2) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = n1;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      typeOrNamedType = n2;
      if ( typeOrNamedType != null ) typeOrNamedType.setParent(this);
   }

   public SetOfType(TypeOrNamedType n0) {
      nodeToken = new NodeToken("SET");
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = new NodeToken("OF");
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      typeOrNamedType = n0;
      if ( typeOrNamedType != null ) typeOrNamedType.setParent(this);
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

