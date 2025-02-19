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

public class RunningEncoder extends TypeEncoder<Running> {
	public RunningEncoder(Running encodable, TypeInformation typeInformation) {
		super(encodable, typeInformation);
	}
	HashMap<FuelLevelStatus,EnumeratedItemTypeInformation> enumTypeFuelLevelStatus = FuelLevelStatusTypeInformation.getEnumTypeMap();
	HashMap<EngineOilLevelStatus,EnumeratedItemTypeInformation> enumTypeEngineOilLevelStatus = EngineOilLevelStatusTypeInformation.getEnumTypeMap();
	HashMap<EngineOilPressureWarning,EnumeratedItemTypeInformation> enumTypeEngineOilPressureWarning = EngineOilPressureWarningTypeInformation.getEnumTypeMap();
	HashMap<EngineCoolantLevelStatus,EnumeratedItemTypeInformation> enumTypeEngineCoolantLevelStatus = EngineCoolantLevelStatusTypeInformation.getEnumTypeMap();
	HashMap<BulbStatus,EnumeratedItemTypeInformation> enumTypeBulbStatus = BulbStatusTypeInformation.getEnumTypeMap();

	@Override
	public void encode(ASN1Encoder encoder) throws IOException {
		ArrayList<TypeEncoder> componentEncoderList = new ArrayList<TypeEncoder>();

		componentEncoderList.add(
new EngineOilLevelStatusEncoder(enumTypeEngineOilLevelStatus, getEncodable().getEngineOilLevelStatus(), RunningTypeInformation._engineOilLevelStatusTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getEngineOilTemperature(), RunningTypeInformation._engineOilTemperatureTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new EngineOilPressureWarningEncoder(enumTypeEngineOilPressureWarning, getEncodable().getEngineOilPressureWarning(), RunningTypeInformation._engineOilPressureWarningTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getEngineCoolantTemperature(), RunningTypeInformation._engineCoolantTemperatureTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new EngineCoolantLevelStatusEncoder(enumTypeEngineCoolantLevelStatus, getEncodable().getEngineCoolantLevelStatus(), RunningTypeInformation._engineCoolantLevelStatusTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getFuelLevel(), RunningTypeInformation._fuelLevelTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new FuelLevelStatusEncoder(enumTypeFuelLevelStatus, getEncodable().getFuelLevelStatus(), RunningTypeInformation._fuelLevelStatusTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getAveFuelConsumption(), RunningTypeInformation._aveFuelConsumptionTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getAveFuelConsumptionInLatestDrivingCycle(), RunningTypeInformation._aveFuelConsumptionInLatestDrivingCycleTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getAvgRunningSpeed(), RunningTypeInformation._avgRunningSpeedTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new BulbStatusEncoder(enumTypeBulbStatus, getEncodable().getBulbStatus(), RunningTypeInformation._bulbStatusTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new TimeStampEncoder(getEncodable().getTimeStamp(), RunningTypeInformation._timeStampTypeInformation.getTypeInformation())
);

		encoder.encodeAsSet(componentEncoderList, getTypeInformation());
	}
}
