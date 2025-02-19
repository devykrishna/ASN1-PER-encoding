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
package org.openasn1.compiler.stages.omast.codeoutput.omcoder;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openasn1.compiler.astutils.OMAndASN1ASTStorage;
import org.openasn1.compiler.interfaces.OMAndASN1ASTModifier;
import org.openasn1.compiler.omast.AbstractASN1Type;
import org.openasn1.compiler.stages.omast.codeoutput.omcoder.decoder.OMDecoderCodeGeneratingVisitor;
import org.openasn1.compiler.stages.omast.codeoutput.omcoder.encoder.OMEncoderCodeGeneratingVisitor;
import org.openasn1.compiler.stages.omast.codeoutput.omcoder.typeinformation.OMCoderNodeInformationCollector;
import org.openasn1.compiler.stages.omast.codeoutput.omcoder.typeinformation.OMCoderTypeInformationRenderer;

/**
 * @author Clayton Hoss
 * 
 */
public class OMCoderCodeGenerator implements OMAndASN1ASTModifier {
	private static Logger LOGGER = Logger.getLogger("ASN1Compiler");

	/**
	 * @see org.openasn1.compiler.stages.generics.ASTModifier#init(java.util.Properties)
	 */
	public boolean init(Properties prop) {
		return true;
	}

	/**
	 * @see org.openasn1.compiler.stages.generics.ASTModifier#modifyAST(java.lang.Object)
	 */
	public OMAndASN1ASTStorage modifyAST(OMAndASN1ASTStorage storage) {

		for (String name : storage.getModuleNameList()) {
			LOGGER
					.debug("Generating encoder classes for module '" + name
							+ "'");

			AbstractASN1Type type = storage.getOMRootByModuleName(name);

			try {
				OMEncoderCodeGeneratingVisitor visitor = new OMEncoderCodeGeneratingVisitor();
				type.accept(visitor);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				OMDecoderCodeGeneratingVisitor visitor = new OMDecoderCodeGeneratingVisitor();
				type.accept(visitor);
			} catch (IOException e) {
				e.printStackTrace();
			}

			OMCoderNodeInformationCollector informationCollector = new OMCoderNodeInformationCollector(
					storage);
			informationCollector.collectNodeInformation(type);

			OMCoderTypeInformationRenderer renderer = new OMCoderTypeInformationRenderer(
					storage);
			renderer.renderTypeInformation(informationCollector
					.getNodeInformation());
		}

		return storage;
	}

}
