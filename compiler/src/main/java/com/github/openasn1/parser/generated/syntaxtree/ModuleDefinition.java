//
// Generated by JTB 1.3.2
//

package com.github.openasn1.parser.generated.syntaxtree;

/**
 * Grammar production:
 * <PRE>
 * moduleIdentifier -> ModuleIdentifier()
 * nodeToken -> &lt;DEFINITIONS_TKN&gt;
 * nodeOptional -> [ TagDefault() ]
 * nodeOptional1 -> [ ExtensionDefault() ]
 * nodeToken1 -> &lt;ASSIGN_OP_TKN&gt;
 * nodeToken2 -> &lt;BEGIN_TKN&gt;
 * moduleBody -> ModuleBody()
 * nodeToken3 -> &lt;END_TKN&gt;
 * </PRE>
 */
public class ModuleDefinition implements Node {
   private Node parent;
   public ModuleIdentifier moduleIdentifier;
   public NodeToken nodeToken;
   public NodeOptional nodeOptional;
   public NodeOptional nodeOptional1;
   public NodeToken nodeToken1;
   public NodeToken nodeToken2;
   public ModuleBody moduleBody;
   public NodeToken nodeToken3;

   public ModuleDefinition(ModuleIdentifier n0, NodeToken n1, NodeOptional n2, NodeOptional n3, NodeToken n4, NodeToken n5, ModuleBody n6, NodeToken n7) {
      moduleIdentifier = n0;
      if ( moduleIdentifier != null ) moduleIdentifier.setParent(this);
      nodeToken = n1;
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeOptional = n2;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      nodeOptional1 = n3;
      if ( nodeOptional1 != null ) nodeOptional1.setParent(this);
      nodeToken1 = n4;
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      nodeToken2 = n5;
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
      moduleBody = n6;
      if ( moduleBody != null ) moduleBody.setParent(this);
      nodeToken3 = n7;
      if ( nodeToken3 != null ) nodeToken3.setParent(this);
   }

   public ModuleDefinition(ModuleIdentifier n0, NodeOptional n1, NodeOptional n2, ModuleBody n3) {
      moduleIdentifier = n0;
      if ( moduleIdentifier != null ) moduleIdentifier.setParent(this);
      nodeToken = new NodeToken("DEFINITIONS");
      if ( nodeToken != null ) nodeToken.setParent(this);
      nodeOptional = n1;
      if ( nodeOptional != null ) nodeOptional.setParent(this);
      nodeOptional1 = n2;
      if ( nodeOptional1 != null ) nodeOptional1.setParent(this);
      nodeToken1 = new NodeToken("::=");
      if ( nodeToken1 != null ) nodeToken1.setParent(this);
      nodeToken2 = new NodeToken("BEGIN");
      if ( nodeToken2 != null ) nodeToken2.setParent(this);
      moduleBody = n3;
      if ( moduleBody != null ) moduleBody.setParent(this);
      nodeToken3 = new NodeToken("END");
      if ( nodeToken3 != null ) nodeToken3.setParent(this);
   }

   public void accept(com.github.openasn1.parser.generated.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(com.github.openasn1.parser.generated.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(com.github.openasn1.parser.generated.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(com.github.openasn1.parser.generated.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }
}
