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
package org.openasn1.compiler.stages.omast.codeoutput.omcoder.encoder;

import java.io.Writer;
import java.util.Stack;

import org.openasn1.compiler.Exceptions.CompilationStoppingException;
import org.openasn1.compiler.omast.ASN1TypeAssignment;
import org.openasn1.compiler.omast.AbstractASN1Type;
import org.openasn1.compiler.omast.AbstractOMVisitor;
import org.openasn1.compiler.omast.AggregatedASN1Type;
import org.openasn1.compiler.omast.ComplexASN1Type;
import org.openasn1.compiler.omast.EnumASN1Type;
import org.openasn1.compiler.omast.ReferencedASN1Type;
import org.openasn1.compiler.omast.SimpleASN1Type;
import org.openasn1.compiler.utils.GlobalConfiguration;


/**
 * @author Clayton Hoss
 * 
 */
public class OMEncoderEncodeCodeGeneratingVisitor extends AbstractOMVisitor {

	private OMEncoderTemplateRenderer renderer;

	/**
	 * holds types on root level. Finally ending up in type assignment
	 */
	private Stack<AbstractASN1Type> childStack = new Stack<AbstractASN1Type>();

	private String moduleName;

	public OMEncoderEncodeCodeGeneratingVisitor(String moduleName, Writer writer) {
		this.moduleName = moduleName;
		this.renderer = new OMEncoderTemplateRenderer(writer,
				GlobalConfiguration.getInstance().getProperty(
						"compiler.templates.path")
						+ "/omcoder");
	}

	/**
	 * @return the renderer
	 */
	protected OMEncoderTemplateRenderer getRenderer() {
		return renderer;
	}

	/**
	 * @param renderer
	 *            the renderer to set
	 */
	protected void setRenderer(OMEncoderTemplateRenderer renderer) {
		this.renderer = renderer;
	}

	/**
	 * @return the moduleName
	 */
	protected String getModuleName() {
		return this.moduleName;
	}

	/**
	 * @param moduleName
	 *            the moduleName to set
	 */
	protected void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the classInformationStack
	 */
	protected Stack<AbstractASN1Type> getChildStack() {
		return this.childStack;
	}

	/**
	 * @see org.openasn1.compiler.omast.AbstractOMVisitor#visit(org.openasn1.compiler.omast.ASN1TypeAssignment)
	 */
	@Override
	public void visit(ASN1TypeAssignment type) {
		super.visit(type);

		getChildStack().clear();
	}

	/**
	 * @see org.openasn1.compiler.omast.AbstractOMVisitor#visit(org.openasn1.compiler.omast.ComplexASN1Type)
	 */
	@Override
	public void visit(ComplexASN1Type type) {
		getRenderer().renderEncodeFunctionEncoderComplexType(type);
	}

	/**
	 * @see org.openasn1.compiler.omast.AbstractOMVisitor#visit(org.openasn1.compiler.omast.ReferencedASN1Type)
	 */
	@Override
	public void visit(ReferencedASN1Type type) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openasn1.compiler.omast.AbstractOMVisitor#visit(org.openasn1.compiler.omast.AggregatedASN1Type)
	 */
	@Override
	public void visit(AggregatedASN1Type type) {
		if (type.getChild().getName() == null) {
			type.getChild().setName(type.getName());
		}
	}

	@Override
	public void visit(EnumASN1Type type) {
		throw new CompilationStoppingException(
				"Enum encoding not yet implemented!");
	}

	/**
	 * @see org.openasn1.compiler.omast.AbstractOMVisitor#visit(org.openasn1.compiler.omast.SimpleASN1Type)
	 */
	@Override
	public void visit(SimpleASN1Type type) {
		getRenderer().renderEncodeFunctionEncoderSimpleType(type);
	}
}