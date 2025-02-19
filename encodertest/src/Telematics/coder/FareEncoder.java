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

import org.openasn1.codec.coder.ASN1Encoder;
import org.openasn1.codec.coder.typecoder.*;
import Telematics.om.*;

public class FareEncoder extends TypeEncoder<Fare> {
	public FareEncoder(Fare encodable, TypeInformation typeInformation) {
		super(encodable, typeInformation);
	}

	@Override
	public void encode(ASN1Encoder encoder) throws IOException {
		ArrayList<TypeEncoder> componentEncoderList = new ArrayList<TypeEncoder>();

		componentEncoderList.add(
new RealEncoder(getEncodable().getAmount(), FareTypeInformation._amountTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getStartFare(), FareTypeInformation._startFareTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getDistanceCharge(), FareTypeInformation._distanceChargeTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getTimeCharge(), FareTypeInformation._timeChargeTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getTollways(), FareTypeInformation._tollwaysTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getExtras(), FareTypeInformation._extrasTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getTax(), FareTypeInformation._taxTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getTips(), FareTypeInformation._tipsTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new RealEncoder(getEncodable().getRate(), FareTypeInformation._rateTypeInformation.getTypeInformation())
);
		componentEncoderList.add(
new PrintableStringEncoder(getEncodable().getUnit(), FareTypeInformation._unitTypeInformation.getTypeInformation())
);

		encoder.encodeAsSet(componentEncoderList, getTypeInformation());
	}
}
