//
// Generated by JTB 1.3.2
//

package org.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * nodeChoice -> &lt;SEQUENCE_TKN&gt; &lt;LEFT_BRACE_TKN&gt; ExtensionAndException() [ OptionalExtensionMarker() ] &lt;RIGHT_BRACE_TKN&gt;
 *       | &lt;SEQUENCE_TKN&gt; &lt;LEFT_BRACE_TKN&gt; ComponentTypeLists() &lt;RIGHT_BRACE_TKN&gt;
 *       | &lt;SEQUENCE_TKN&gt; &lt;LEFT_BRACE_TKN&gt; &lt;RIGHT_BRACE_TKN&gt;
 * </PRE>
 */
public class SequenceType implements Node {
   private Node parent;
   public NodeChoice nodeChoice;

   public SequenceType(NodeChoice n0) {
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

