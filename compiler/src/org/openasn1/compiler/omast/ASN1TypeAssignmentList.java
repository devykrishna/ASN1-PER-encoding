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
package org.openasn1.compiler.omast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Clayton Hoss
 *
 */
public class ASN1TypeAssignmentList extends AbstractASN1Type {

	private List<ASN1TypeAssignment> list = new ArrayList<ASN1TypeAssignment>();

	/**
	 * @see org.openasn1.compiler.omast.OMVisitable#accept(org.openasn1.compiler.omast.OMVisitor)
	 */
	public void accept(OMVisitor vis) {
		vis.visit(this);

	}


	/**
	 * @param arg0
	 * @return
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(ASN1TypeAssignment arg0) {
		arg0.setParent(this);
		return this.list.add(arg0);
	}


	/**
	 * @return the list
	 */
	public List<ASN1TypeAssignment> getList() {
		return this.list;
	}

}
