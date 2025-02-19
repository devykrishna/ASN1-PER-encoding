//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;IDENTIFIER&gt;
 * nodeToken1 -> &lt;AMPERSAND_TKN&gt;
 * nodeToken2 -> &lt;LEFT_PARENTHESIS_TKN&gt;
 * nodeToken3 -> &lt;AMPERSAND_TKN&gt;
 * xMLNumberForm -> XMLNumberForm()
 * nodeToken4 -> &lt;AMPERSAND_TKN&gt;
 * nodeToken5 -> &lt;RIGHT_PARENTHESIS_TKN&gt;
 * </PRE>
 */
public class XMLNameAndNumberForm implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public NodeToken nodeToken2;
   public NodeToken nodeToken3;
   public XMLNumberForm xMLNumberForm;
   public NodeToken nodeToken4;
   public NodeToken nodeToken5;

   public XMLNameAndNumberForm(NodeToken n0, NodeToken n1, NodeToken n2, NodeToken n3, XMLNumberForm n4, NodeToken n5, NodeToken n6) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = n1;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      nodeToken2 = n2;
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
      nodeToken3 = n3;
      if ( nodeToken3 != null ) nodeToken3.setParent(this);
      xMLNumberForm = n4;
      if ( xMLNumberForm != null ) xMLNumberForm.setParent(this);
      nodeToken4 = n5;
      if ( nodeToken4 != null ) nodeToken4.setParent(this);
      nodeToken5 = n6;
      if ( nodeToken5 != null ) nodeToken5.setParent(this);
   }

   public XMLNameAndNumberForm(NodeToken n0, XMLNumberForm n1) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = new NodeToken("&");
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      nodeToken2 = new NodeToken("(");
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
      nodeToken3 = new NodeToken("&");
      if ( nodeToken3 != null ) nodeToken3.setParent(this);
      xMLNumberForm = n1;
      if ( xMLNumberForm != null ) xMLNumberForm.setParent(this);
      nodeToken4 = new NodeToken("&");
      if ( nodeToken4 != null ) nodeToken4.setParent(this);
      nodeToken5 = new NodeToken(")");
      if ( nodeToken5 != null ) nodeToken5.setParent(this);
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

