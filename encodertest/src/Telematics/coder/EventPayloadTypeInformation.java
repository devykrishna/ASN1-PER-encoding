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
public final class EventPayloadTypeInformation {
	static private TypeInformation typeInformation;
	
	
	
	private EventPayloadTypeInformation() { }
	
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

	public static class _accidentTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 0));
			getTypeInformation().getTagList().addAll(AccidentTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(AccidentTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _theftTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 1));
			getTypeInformation().getTagList().addAll(TheftTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(TheftTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _driverLoginTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 2));
			getTypeInformation().getTagList().addAll(DriverStatusTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(DriverStatusTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _driverLogoutTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 3));
			getTypeInformation().getTagList().addAll(DriverStatusTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(DriverStatusTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _driverAlarmTriggerTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 4));
			getTypeInformation().getTagList().addAll(AlarmTriggerTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(AlarmTriggerTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _passengerAlarmTriggerTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 5));
			getTypeInformation().getTagList().addAll(AlarmTriggerTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(AlarmTriggerTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _irregularDrivingTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 6));
			getTypeInformation().getTagList().addAll(IrregularDrivingTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(IrregularDrivingTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _passengerOnTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 7));
			getTypeInformation().getTagList().addAll(PassengerOnTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(PassengerOnTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _passengerOffTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 8));
			getTypeInformation().getTagList().addAll(PassengerOffTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(PassengerOffTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _irregularHWAccessedTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 9));
			getTypeInformation().getTagList().addAll(IrregularHWAccessedTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(IrregularHWAccessedTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _tripStartTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 10));
			getTypeInformation().getTagList().addAll(TripStartTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(TripStartTypeInformation.getTypeInformation().getConstraint());
		}
	}

	public static class _tripEndTypeInformation {
		private static TypeInformation typeInformation = new TypeInformation();
		
		public static TypeInformation getTypeInformation() { return typeInformation; }
		
		
		static {
			getTypeInformation().setTagList(new ArrayList<Tag>());
			getTypeInformation().getTagList().add(new Tag(IMPLICIT, CONTEXT_SPECIFIC, 11));
			getTypeInformation().getTagList().addAll(TripEndTypeInformation.getTypeInformation().getTagList());
			getTypeInformation().setExtensible(false);
			getTypeInformation().setOptional(false);
			getTypeInformation().setConstraint(TripEndTypeInformation.getTypeInformation().getConstraint());
		}
	}


	static public TypeInformation getTypeInformation() {
    	return typeInformation; 
    }
}
