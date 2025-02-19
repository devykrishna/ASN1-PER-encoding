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
package org.openasn1.parser.attributes;

import org.openasn1.parser.generated.syntaxtree.NodeToken;
import org.openasn1.parser.generated.syntaxtree.Reference;
import org.openasn1.parser.generated.syntaxtree.valuereference;

/**
 * @author Clayton Hoss
 * 
 */
public class ReferenceAttributes {

	public static boolean isTypeReference(Reference ref) {
		return ref.nodeChoice.choice instanceof NodeToken;
	}

	public static boolean isValueReference(Reference ref) {
		return !isTypeReference(ref);
	}

	public static String getSymbol(Reference ref) {
		if (isTypeReference(ref)) {
			return ((NodeToken) ref.nodeChoice.choice).tokenImage;
		}
		return ((valuereference) ref.nodeChoice.choice).nodeToken.tokenImage;
	}

}
