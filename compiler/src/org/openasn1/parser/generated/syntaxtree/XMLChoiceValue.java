//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;LESSER_THAN_TKN&gt;
 * nodeToken1 -> &lt;AMPERSAND_TKN&gt;
 * nodeToken2 -> &lt;IDENTIFIER&gt;
 * nodeToken3 -> &lt;GREATER_THAN_TKN&gt;
 * xMLValue -> XMLValue()
 * nodeToken4 -> &lt;XMLENDTAGBRACKET_TKN&gt;
 * nodeToken5 -> &lt;AMPERSAND_TKN&gt;
 * nodeToken6 -> &lt;IDENTIFIER&gt;
 * nodeToken7 -> &lt;GREATER_THAN_TKN&gt;
 * </PRE>
 */
public class XMLChoiceValue implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public NodeToken nodeToken1;
   public NodeToken nodeToken2;
   public NodeToken nodeToken3;
   public XMLValue xMLValue;
   public NodeToken nodeToken4;
   public NodeToken nodeToken5;
   public NodeToken nodeToken6;
   public NodeToken nodeToken7;

   public XMLChoiceValue(NodeToken n0, NodeToken n1, NodeToken n2, NodeToken n3, XMLValue n4, NodeToken n5, NodeToken n6, NodeToken n7, NodeToken n8) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = n1;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      nodeToken2 = n2;
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
      nodeToken3 = n3;
      if ( nodeToken3 != null ) nodeToken3.setParent(this);
      xMLValue = n4;
      if ( xMLValue != null ) xMLValue.setParent(this);
      nodeToken4 = n5;
      if ( nodeToken4 != null ) nodeToken4.setParent(this);
      nodeToken5 = n6;
      if ( nodeToken5 != null ) nodeToken5.setParent(this);
      nodeToken6 = n7;
      if ( nodeToken6 != null ) nodeToken6.setParent(this);
      nodeToken7 = n8;
      if ( nodeToken7 != null ) nodeToken7.setParent(this);
   }

   public XMLChoiceValue(NodeToken n0, XMLValue n1, NodeToken n2) {
      nodeToken = new NodeToken("<");
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeToken1 = new NodeToken("&");
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      nodeToken2 = n0;
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
      nodeToken3 = new NodeToken(">");
      if ( nodeToken3 != null ) nodeToken3.setParent(this);
      xMLValue = n1;
      if ( xMLValue != null ) xMLValue.setParent(this);
      nodeToken4 = new NodeToken("</");
      if ( nodeToken4 != null ) nodeToken4.setParent(this);
      nodeToken5 = new NodeToken("&");
      if ( nodeToken5 != null ) nodeToken5.setParent(this);
      nodeToken6 = n2;
      if ( nodeToken6 != null ) nodeToken6.setParent(this);
      nodeToken7 = new NodeToken(">");
      if ( nodeToken7 != null ) nodeToken7.setParent(this);
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

