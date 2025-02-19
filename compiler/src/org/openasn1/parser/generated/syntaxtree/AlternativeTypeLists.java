//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * rootAlternativeTypeList -> RootAlternativeTypeList()
 * nodeOptional -> [ &lt;COMMA_TKN&gt; ExtensionAndException() [ ExtensionAdditionAlternatives() ] [ OptionalExtensionMarker() ] ]
 * </PRE>
 */
public class AlternativeTypeLists implements Node {
   private Node parent;
   public RootAlternativeTypeList rootAlternativeTypeList;
   public NodeOptional nodeOptional;

   public AlternativeTypeLists(RootAlternativeTypeList n0, NodeOptional n1) {
      rootAlternativeTypeList = n0;
      if ( rootAlternativeTypeList != null ) rootAlternativeTypeList.setParent(this);
      nodeOptional = n1;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
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

