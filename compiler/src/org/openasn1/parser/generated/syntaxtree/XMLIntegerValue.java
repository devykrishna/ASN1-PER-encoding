//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeChoice -> SignedNumber()
 *       | &lt;LESSER_THAN_TKN&gt; &lt;AMPERSAND_TKN&gt; &lt;IDENTIFIER&gt; &lt;XMLTAGTERMINATINGBRACKET_TKN&gt;
 * </PRE>
 */
public class XMLIntegerValue implements Node {
   private Node parent;
   public NodeChoice nodeChoice;

   public XMLIntegerValue(NodeChoice n0) {
      nodeChoice = n0;
      if ( nodeChoice != null ) nodeChoice.setParent(this);
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

