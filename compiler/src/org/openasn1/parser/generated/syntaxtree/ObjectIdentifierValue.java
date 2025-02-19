//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;LEFT_BRACE_TKN&gt;
 * objIdComponentsList -> ObjIdComponentsList()
 * nodeToken1 -> &lt;RIGHT_BRACE_TKN&gt;
 * </PRE>
 */
public class ObjectIdentifierValue implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public ObjIdComponentsList objIdComponentsList;
   public NodeToken nodeToken1;

   public ObjectIdentifierValue(NodeToken n0, ObjIdComponentsList n1, NodeToken n2) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      objIdComponentsList = n1;
      if ( objIdComponentsList != null ) objIdComponentsList.setParent(this);
      nodeToken1 = n2;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
   }

   public ObjectIdentifierValue(ObjIdComponentsList n0) {
      nodeToken = new NodeToken("{");
      if ( nodeToken != null ) nodeToken.setParent(this);
      objIdComponentsList = n0;
      if ( objIdComponentsList != null ) objIdComponentsList.setParent(this);
      nodeToken1 = new NodeToken("}");
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

