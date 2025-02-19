/*
 *   openASN.1 - an open source ASN.1 toolkit for java
 *
 *   Copyright (C) 2007 Clayton Hoss, Marc Weyland
 *
 *   This file is part of openASN.1
 *
 *   openASN.1 is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License as 
 *   published by the Free Software Foundation, either version 3 of 
 *   the License, or (at your option) any later version.
 *
 *   openASN.1 is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with openASN.1. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package org.openasn1.compiler.astutils.visitors;

import java.util.ArrayList;
import java.util.List;

import org.openasn1.compiler.astutils.valueobjects.ObjectIdentifierValueObject;
import org.openasn1.compiler.astutils.valueobjects.StandardOIDValues;
import org.openasn1.parser.generated.syntaxtree.DefinitiveNameAndNumberForm;
import org.openasn1.parser.generated.syntaxtree.DefinitiveNumberForm;
import org.openasn1.parser.generated.syntaxtree.DefinitiveObjIdComponentList;
import org.openasn1.parser.generated.syntaxtree.ExtensionDefault;
import org.openasn1.parser.generated.syntaxtree.ModuleBody;
import org.openasn1.parser.generated.syntaxtree.ModuleIdentifier;
import org.openasn1.parser.generated.syntaxtree.NameForm;
import org.openasn1.parser.generated.syntaxtree.TagDefault;
import org.openasn1.parser.generated.visitor.DepthFirstVisitor;


/**
 * @author Clayton Hoss
 * 
 */
public class ModuleHeaderInformationExtractionVisitor extends DepthFirstVisitor {

	private List<Integer> moduleOID = new ArrayList<Integer>();

	private String moduleName;

	/*
	 * DefinitiveNameAndNumberForm() | NameForm() | DefinitiveNumberForm()
	 */

	/**
	 * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.ModuleIdentifier)
	 */
	@Override
	public void visit(ModuleIdentifier n) {
		setModuleName(n.modulereference.nodeToken.tokenImage);
		super.visit(n);
	}

	/**
	 * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.DefinitiveObjIdComponentList)
	 */
	@Override
	public void visit(DefinitiveObjIdComponentList n) {
		super.visit(n);
	}

	/**
	 * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.DefinitiveNameAndNumberForm)
	 */
	@Override
	public void visit(DefinitiveNameAndNumberForm n) {
		Integer i = new Integer(n.definitiveNumberForm.nodeToken.tokenImage);
		getModuleOID().add(i);
	}

	/**
	 * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.DefinitiveNumberForm)
	 */
	@Override
	public void visit(DefinitiveNumberForm n) {
		Integer i = new Integer(n.nodeToken.tokenImage);
		getModuleOID().add(i);
	}

	/**
	 * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.NameForm)
	 */
	@Override
	public void visit(NameForm n) {
		Integer i = StandardOIDValues.getInstance().getOIDValue(
				n.nodeToken.tokenImage);
		getModuleOID().add(i);
		super.visit(n);
	}

	/**
	 * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.ExtensionDefault)
	 */
	@Override
	public void visit(ExtensionDefault n) {
	}

	/**
	 * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.ModuleBody)
	 */
	@Override
	public void visit(ModuleBody n) {
	}

	/**
	 * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.TagDefault)
	 */
	@Override
	public void visit(TagDefault n) {
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return this.moduleName;
	}

	/**
	 * @param moduleName
	 *            the moduleName to set
	 */
	private void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the moduleOID
	 */
	private List<Integer> getModuleOID() {
		return this.moduleOID;
	}

	public ObjectIdentifierValueObject getModuleOIDValue() {
		return new ObjectIdentifierValueObject(getModuleOID());
	}
}
