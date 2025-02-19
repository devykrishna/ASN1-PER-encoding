/*  
 *   This file was generated by openASN.1 - an open source ASN.1 toolkit for java
 *
 *   openASN.1 is Copyright (C) 2007 Clayton Hoss, Marc Weyland
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
package Telematics.coder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.openasn1.codec.coder.TagClass.*;
import static org.openasn1.codec.coder.TaggingMode.*;

import org.openasn1.codec.coder.Tag;
import org.openasn1.codec.coder.TagClass;
import org.openasn1.codec.coder.typecoder.*;
import org.openasn1.codec.constraints.*;
import org.openasn1.codec.constraints.subtype.*;

import Telematics.om.*;
public final class ReasonTypeInformation {
	static private TypeInformation typeInformation;
	
	
	
	private ReasonTypeInformation() { }
	
	/**
	 * Static class initialisation. 
	 * Fill and set type information
	 */
	static {
    	typeInformation = new TypeInformation();
    	
    	ArrayList<Tag> tagList = new ArrayList<Tag>();
    	typeInformation.setTagList(tagList);
    	
    	typeInformation.setExtensible(false);
	}

	public static class _codeTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 0));
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
		}
	}

	public static class _statusTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 1));
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
		}
	}

	public static class _descriptionTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 2));
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
		}
	}


	static public TypeInformation getTypeInformation() {
    	return typeInformation; 
    }
}
