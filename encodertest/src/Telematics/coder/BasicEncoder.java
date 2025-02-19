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
import java.util.List;

import org.openasn1.codec.coder.ASN1Encoder;
import org.openasn1.codec.coder.typecoder.*;
import Telematics.om.*;

public class BasicEncoder extends TypeEncoder<Basic> {
	public BasicEncoder(Basic encodable, TypeInformation typeInformation) {
		super(encodable, typeInformation);
	}
	HashMap<EngineStatus,EnumeratedItemTypeInformation> enumTypeenginestatus = EngineStatusTypeInformation.getEnumTypeMap();
	HashMap<UsageMode,EnumeratedItemTypeInformation> enumTypeUsageMode = UsageModeTypeInformation.getEnumTypeMap();
	HashMap<KeyStatus,EnumeratedItemTypeInformation> enymTypeKeyStatus = KeyStatusTypeInformation.getEnumTypeMap();
	HashMap<EngineBlockedStatus,EnumeratedItemTypeInformation> enymTypeEngineBlockedStatus = EngineBlockedStatusTypeInformation.getEnumTypeMap();
	
	@Override
	public void encode(ASN1Encoder encoder) throws IOException {
		ArrayList<TypeEncoder> componentEncoderList = new ArrayList<TypeEncoder>();
		ArrayList<MilElement> encodablesList = new ArrayList<MilElement>();
		List<MilElement> mil = getEncodable().getMils();
		encodablesList.addAll(mil);
		
		componentEncoderList.add(
new PositionEncoder(getEncodable().getPosition(), BasicTypeInformation._positionTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getSpeed(), BasicTypeInformation._speedTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new IntegerEncoder(getEncodable().getDirection(), BasicTypeInformation._directionTypeInformation.getTypeInformation())
);

componentEncoderList.add(new SetOfEncoder<MilElement>(
		new MilElementEncoder(null,BasicTypeInformation._milsTypeInformation.__milsTypeInformation.getTypeInformation()),
		encodablesList, BasicTypeInformation._milsTypeInformation.getTypeInformation()));
	
componentEncoderList.add(
new RealEncoder(getEncodable().getFuel(), BasicTypeInformation._fuelTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new EngineStatusEncoder(enumTypeenginestatus, getEncodable().getEngineStatus(), BasicTypeInformation._engineStatusTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new KeyStatusEncoder(enymTypeKeyStatus, getEncodable().getKeyStatus(), BasicTypeInformation._keyStatusTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new IntegerEncoder(getEncodable().getDistanceToEmpty(), BasicTypeInformation._distanceToEmptyTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new IntegerEncoder(getEncodable().getOdometer(), BasicTypeInformation._odometerTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new TimeStampEncoder(getEncodable().getTimeStamp(), BasicTypeInformation._timeStampTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new UsageModeEncoder(enumTypeUsageMode, getEncodable().getUsageMode(), BasicTypeInformation._usageModeTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new EngineBlockedStatusEncoder(enymTypeEngineBlockedStatus, getEncodable().getEngineBlockedStatus(), BasicTypeInformation._engineBlockedStatusTypeInformation.getTypeInformation())
);

		encoder.encodeAsSequence(componentEncoderList, getTypeInformation());
	}
}
