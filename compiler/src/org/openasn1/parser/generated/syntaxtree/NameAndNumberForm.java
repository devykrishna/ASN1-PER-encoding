//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;IDENTIFIER&gt;
 * nodeToken1 -> &lt;LEFT_PARENTHESIS_TKN&gt;
 * numberForm -> NumberForm()
 * nodeToken2 -> &lt;RIGHT_PARENTHESIS_TKN&gt;
 * </PRE>
 */
public class NameAndNumberForm implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public NumberForm numberForm;
   public NodeToken nodeToken2;

   public NameAndNumberForm(NodeToken n0, NodeToken n1, NumberForm n2, NodeToken n3) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = n1;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      numberForm = n2;
      if ( numberForm != null ) numberForm.setParent(this);
      nodeToken2 = n3;
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
   }

   public NameAndNumberForm(NodeToken n0, NumberForm n1) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = new NodeToken("(");
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      numberForm = n1;
      if ( numberForm != null ) numberForm.setParent(this);
      nodeToken2 = new NodeToken(")");
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
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

