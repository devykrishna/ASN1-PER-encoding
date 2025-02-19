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
package org.openasn1.compiler.stages.asn1ast.tagging;

import org.openasn1.compiler.Exceptions.CompilationStoppingException;
import org.openasn1.compiler.astutils.helpers.LogginHelper;
import org.openasn1.parser.generated.syntaxtree.SequenceType;

/**
 * This class checks if a given ASN.1 Sequence should use Automatic Tagging and
 * rudinmentary checks if the restrictions on tagging of a Sequence are met
 *
 * @author Clayton Hoss
 *
 */
public class SequenceAutomaticTaggingDecidingVisitor extends ComponentTypeListsAutomaticTaggingVisitor {
    /**
     * @see org.openasn1.parser.generated.visitor.DepthFirstVisitor#visit(org.openasn1.parser.generated.syntaxtree.SequenceType)
     */
    @Override
    public void visit(SequenceType n) {
        super.visit(n);
        if ((getUseAutomaticTaggingInRoot() == true)
                && (getUseAutomatictaggingInExtension() == false)) {
            throw new CompilationStoppingException(
                    "Extension in Sequence can only be tagged if root has at least one tag (line "
                            + LogginHelper.getCurrentLine(n));
        }
    }
}