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
package org.openasn1.codec.coder.typecoder;

import java.io.IOException;
import java.util.HashMap;

import org.openasn1.codec.coder.ASN1Decoder;


/**
 * @author Marc Weyland
 *
 * @param <T>
 */
public class EnumeratedDecoder<T extends Enum> extends TypeDecoder<T> {
	private HashMap<T, EnumeratedItemTypeInformation> enumTypeMap;
	
	public EnumeratedDecoder(HashMap<T, EnumeratedItemTypeInformation> enumTypeMap, TypeInformation typeInformation) {
		super(typeInformation);
		this.enumTypeMap = enumTypeMap;
	}
	
	private HashMap<T, EnumeratedItemTypeInformation> getEnumTypeMap() {
		return this.enumTypeMap;
	}

	@Override
	public T decode(ASN1Decoder decoder) throws IOException {
		return decoder.decodeEnumerated(getEnumTypeMap(), getTypeInformation());
	}
}