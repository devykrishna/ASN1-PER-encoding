//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeToken -> &lt;LEFT_BRACE_TKN&gt;
 * group -> Group()
 * nodeToken1 -> &lt;COMMA_TKN&gt;
 * plane -> Plane()
 * nodeToken2 -> &lt;COMMA_TKN&gt;
 * row -> Row()
 * nodeToken3 -> &lt;COMMA_TKN&gt;
 * cell -> Cell()
 * nodeToken4 -> &lt;RIGHT_BRACE_TKN&gt;
 * </PRE>
 */
public class Quadruple implements Node {
   private Node parent;
   public NodeToken nodeToken;
   public Group group;
   public NodeToken nodeToken1;
   public Plane plane;
   public NodeToken nodeToken2;
   public Row row;
   public NodeToken nodeToken3;
   public Cell cell;
   public NodeToken nodeToken4;

   public Quadruple(NodeToken n0, Group n1, NodeToken n2, Plane n3, NodeToken n4, Row n5, NodeToken n6, Cell n7, NodeToken n8) {
      nodeToken = n0;
      if ( nodeToken != null ) nodeToken.setParent(this);
      group = n1;
      if ( group != null ) group.setParent(this);
      nodeToken1 = n2;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      plane = n3;
      if ( plane != null ) plane.setParent(this);
      nodeToken2 = n4;
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
      row = n5;
      if ( row != null ) row.setParent(this);
      nodeToken3 = n6;
      if ( nodeToken3 != null ) nodeToken3.setParent(this);
      cell = n7;
      if ( cell != null ) cell.setParent(this);
      nodeToken4 = n8;
      if ( nodeToken4 != null ) nodeToken4.setParent(this);
   }

   public Quadruple(Group n0, Plane n1, Row n2, Cell n3) {
      nodeToken = new NodeToken("{");
      if ( nodeToken != null ) nodeToken.setParent(this);
      group = n0;
      if ( group != null ) group.setParent(this);
      nodeToken1 = new NodeToken(",");
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      plane = n1;
      if ( plane != null ) plane.setParent(this);
      nodeToken2 = new NodeToken(",");
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
      row = n2;
      if ( row != null ) row.setParent(this);
      nodeToken3 = new NodeToken(",");
      if ( nodeToken3 != null ) nodeToken3.setParent(this);
      cell = n3;
      if ( cell != null ) cell.setParent(this);
      nodeToken4 = new NodeToken("}");
      if ( nodeToken4 != null ) nodeToken4.setParent(this);
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

