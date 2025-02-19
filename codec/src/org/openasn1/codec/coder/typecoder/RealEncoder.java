package org.openasn1.codec.coder.typecoder;

import java.io.IOException;

import org.openasn1.codec.coder.ASN1Encoder;

public class RealEncoder extends TypeEncoder<Double> {
		public RealEncoder(Double encodable, TypeInformation typeInformation) {
			super(encodable, typeInformation);
		}

		@Override
		public void encode(ASN1Encoder encoder) throws IOException {
			encoder.encodeAsReal(getEncodable(), getTypeInformation());
		}
}
