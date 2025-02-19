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
package org.openasn1.codec.coder.per;


import static org.openasn1.codec.util.ASN1Constants.BITPATTERN_00111111;
import static org.openasn1.codec.util.ASN1Constants.BITPATTERN_01111111;
import static org.openasn1.codec.util.ASN1Constants.BITPATTERN_10000000;
import static org.openasn1.codec.util.ASN1Constants.BITPATTERN_11000000;
import static org.openasn1.codec.util.ASN1Constants.BITPATTERN_11111111;
import static org.openasn1.codec.util.ASN1Constants.SIZE_16K;
import static org.openasn1.codec.util.ASN1Constants.SIZE_64K;
import static org.openasn1.codec.util.ASN1Constants.SIZE_ONE_OCTET;
import static org.openasn1.codec.util.ASN1Constants.SIZE_THREE_OCTETS;
import static org.openasn1.codec.util.ASN1Constants.SIZE_TWO_OCTETS;
import static org.openasn1.codec.util.ASN1Constants.SIZE_FOUR_OCTETS;
import static org.openasn1.codec.util.ASN1Constants.SIZE_FIVE_OCTETS;
import static org.openasn1.codec.util.ASN1Constants.SIZE_SIX_OCTETS;
import static org.openasn1.codec.util.ASN1Constants.SIZE_SEVEN_OCTETS;
import static org.openasn1.codec.util.ASN1Constants.SIZE_EIGHT_OCTETS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.math.BigInteger;

import org.openasn1.codec.coder.ASN1Encoder;
import org.openasn1.codec.coder.TagClass;
import org.openasn1.codec.coder.exceptions.EncoderException;
import org.openasn1.codec.coder.typecoder.EnumeratedItemTypeInformation;
import org.openasn1.codec.coder.typecoder.EnumeratedSortContainer;
import org.openasn1.codec.coder.typecoder.TypeEncoder;
import org.openasn1.codec.coder.typecoder.TypeEncoderComparator;
import org.openasn1.codec.coder.typecoder.TypeInformation;
import org.openasn1.codec.constraints.Constraint;
import org.openasn1.codec.constraints.character.BMPStringInfo;
import org.openasn1.codec.constraints.character.IA5StringInfo;
import org.openasn1.codec.constraints.character.NumericStringInfo;
import org.openasn1.codec.constraints.character.PrintableStringInfo;
import org.openasn1.codec.constraints.character.RestrictedCharacterStringInfo;
import org.openasn1.codec.constraints.character.VisibleStringInfo;
import org.openasn1.codec.constraints.visitor.PERIntegerSizeConstraintVisitor;
import org.openasn1.codec.constraints.visitor.PERRestrictedCharacterStringPermittedAlphabetConstraintVisitor;
import org.openasn1.codec.constraints.visitor.PERRestrictedCharacterStringSizeConstraintVisitor;
import org.openasn1.codec.util.MathUtil;
import org.openasn1.codec.util.bit.BasicBitOutputStream;
import org.openasn1.codec.util.bit.BitField;
import org.openasn1.codec.util.bit.BitOutputStream;
import org.openasn1.codec.util.bit.DynamicBitField;
import org.openasn1.codec.util.bit.EmptyBitField;
import org.openasn1.codec.util.bit.StaticBitField;


/**
 * @author Marc Weyland
 *
 */
abstract public class PEREncoder implements ASN1Encoder {

	private static int rangeBitTable[] = { 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,
			6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
			7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
			8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8,
			8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 };

	private boolean isOctetAligned = true;
	
	/**
	 * Returns if the Encoder is octet aligned 
	 * 
	 * @return the alignment of this encoder
	 */
	public boolean isOctetAligned() {
		return isOctetAligned;
	}

	/**
	 * Sets the octet alignment of this encoder
	 * 
	 * @param isOctetAligned true if octet alignment should be kept
	 */
	public void setOctetAligned(boolean octetAligned) {
		this.isOctetAligned = octetAligned;
	}

	private static int getNeededBitsForRange(long range) {
		return rangeBitTable[(int) range];
	}

	private BitOutputStream _bitOutputStream;

	public PEREncoder(OutputStream outputStream, boolean octetAligned) {
		this._bitOutputStream = new BasicBitOutputStream(outputStream);
		setOctetAligned(octetAligned);
	}

	public PEREncoder(BitOutputStream bitOutputStream, boolean octetAligned) {
		this._bitOutputStream = bitOutputStream;
		setOctetAligned(octetAligned);
	}

	protected BitOutputStream getBitOutputStream() {
		return this._bitOutputStream;
	}

	protected void setBitOutputStream(BitOutputStream bitOutputStream) {
		this._bitOutputStream = bitOutputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this._bitOutputStream = new BasicBitOutputStream(outputStream);
	}

	public void finish() throws IOException {
		// write remaining bits octet alined
		getBitOutputStream().flush();
	}

	protected void keepOctetAlignment() throws IOException {
		if (getBitOutputStream().getPendingBits() > 0) {
			getBitOutputStream().flush();
			//System.out.print("PERencoder : keepOctetAlignment flushed\n");
		}
	}
	
	/**
	 * PER encoding of NULL value
	 * 
	 * Note: NULL PER encoding does not generate bits on the line 
	 * 
	 * @see org.openasn1.codec.coder.ASN1Encoder#encodeAsNull(java.lang.Object, org.openasn1.codec.coder.typecoder.TypeInformation)
	 */
	public void encodeAsNull(TypeInformation typeInformation) throws IOException {
		/**
		 * Nothing to do here
		 */
	}

	/**
     * Encoding of the octet string type. The encoding is a sequence of eight
     * bits.
     * 
     * @see "X.691-0207 16"
     */
	public void encodeAsOctetString(byte[] values, TypeInformation typeInformation) throws IOException {
		if (!typeInformation.hasConstraint()) {
			encodeUnconstrainedOctetString(values, typeInformation);
		} else {
			encodeConstrainedOctetString(values, typeInformation);
		}
	}

	/**
     * Encoding of the boolean type. Encoding is a single bit
     * 
     * Note: There is no difference between the UNALIGNED and the ALIGNED
     * variant.
     * 
     * @see "X.691-0207 11"
     */
	public void encodeAsBoolean(boolean value, TypeInformation typeInformation) throws IOException {
		if (value == true) {
			getBitOutputStream().writeBit(1);
		} else {
			getBitOutputStream().writeBit(0);
		}
	}

	/**
     * Encoding of a non-negative-binary-integer into a fixed size field
     * 
     * Puts the integer into a field which is a fixed number of bits specified
     * by the 'bits' parameter
     * 
     * @see "X.691-0207 10.3.5"
     */
	protected BitField encodeAsNonNegativeBinaryIntegerIntoBits(long value, int bits) throws IOException {
		//System.out.print("PERencoder: encodeAsNonNegativeBinaryIntegerIntoBits :  value "+value +" bits "+bits + "\n");
	/*	if (value < 0) {
			throw new EncoderException("The value to be encoded as a non-negative-binary-integer may not be negative");
		}*/
		if (bits < 1) {
			throw new EncoderException("The amount of bits used to encode the value must be greater than 0");
		}

		StaticBitField bitField = new StaticBitField(bits);

		bitField.setValue(0, bits - 1, value);

		return bitField;
	}

	/**
     * Encoding of a non-negative-binary-integer into a fixed size field
     * 
     * Puts the integer into a field which is a fixed number of octets specified
     * by the 'octets' parameter. Only one or two octets are permittet.
     * 
     * @see "X.691-0207 10.3.5"
     */
	protected BitField encodeAsNonNegativeBinaryIntegerIntoOctets(long value, int octets) throws IOException {
		//System.out.print("PERencoder: encodeAsNonNegativeBinaryIntegerIntoOctets :  value "+value +" octes "+octets + "\n");
		if (value < 0) {
			throw new EncoderException("The value to be encoded as a non-negative-binary-integer may not be negative");
		}
  
		if ((octets < 1) || (octets > 8)) {
			throw new EncoderException("The amount of octets used to encode the value must be 1 or 2");
		}

		StaticBitField bitField = new StaticBitField(octets * 8);

		bitField.setValue(0, octets * 8 - 1, value);

		return bitField;
	}

	/**
     * Encoding as a non-negative-binary-integer
     * 
     * Puts the integer into a field which is a fixed number of bits, a fixed
     * number of octets, or a field that is the minimum number of octets needed
     * to hold it.
     * 
     * @see "X.691-0207 10.3.6"
     */
	protected BitField encodeAsNonNegativeBinaryInteger(long value) throws IOException {
		if (value < 0) {
			throw new EncoderException("The value to be encoded as a non-negative-binary-integer may not be negative");
		}

		DynamicBitField bitField = new DynamicBitField();

		if (value < SIZE_ONE_OCTET) {
			bitField.appendValue(value, 8);
		} else if (value < SIZE_TWO_OCTETS) {
			bitField.appendValue(value, 16);
		} else if (value < SIZE_THREE_OCTETS) {
			bitField.appendValue(value, 24);
		} else if (value < SIZE_FOUR_OCTETS) {
			bitField.appendValue(value, 32);
		} else if (value < SIZE_FIVE_OCTETS) {
			bitField.appendValue(value, 40);
		} else if (value < SIZE_SIX_OCTETS) {
			bitField.appendValue(value, 48);
		} else if (value < SIZE_SEVEN_OCTETS) {
			bitField.appendValue(value, 56);
		} else {
			bitField.appendValue(value, 64);
		}

		return bitField;
	}

	/**
     * Encoding as a 2's-complement-binary-integer
     * 
     * A signed integer is put into a field that is the minumum number of octets
     * needed to hold it
     * 
     * @see "X.691-0207 10.4"
     */
	protected BitField encodeAs2sComplementBinaryInteger(long value) throws IOException {
		//System.out.print("PERENcoder: encodeAs2sComplementBinaryInteger :Value "+value +"\n");
		byte signBit = (byte) ((value >> 24) & BITPATTERN_10000000);
		//System.out.print("PERENcoder: encodeAs2sComplementBinaryInteger :signBit "+signBit +"\n");
		DynamicBitField bitField = new DynamicBitField();

		if ((value >= -SIZE_ONE_OCTET / 2) && (value < SIZE_ONE_OCTET / 2)) {
			bitField.appendValue(value, 8);
		} else if ((value >= -SIZE_TWO_OCTETS / 2) && (value < SIZE_TWO_OCTETS / 2)) {
			bitField.appendValue((value >> 8) & BITPATTERN_01111111 | signBit, 8); 
			bitField.appendValue(value & BITPATTERN_11111111, 8);
		} else if ((value >= -SIZE_THREE_OCTETS / 2) && (value < SIZE_THREE_OCTETS / 2)) {
			bitField.appendValue((value >> 16) & BITPATTERN_01111111 | signBit, 8);
			bitField.appendValue((value >> 8) & BITPATTERN_11111111, 8);
			bitField.appendValue(value & BITPATTERN_11111111, 8);
		}  else if ((value >= -SIZE_FOUR_OCTETS / 2) && (value < SIZE_FOUR_OCTETS / 2)) {
			bitField.appendValue((value >> 24) & BITPATTERN_01111111 | signBit, 8);
			bitField.appendValue((value >> 16) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 8) & BITPATTERN_11111111, 8);
			bitField.appendValue(value & BITPATTERN_11111111, 8);
		} else if ((value >= -SIZE_FIVE_OCTETS / 2) && (value < SIZE_FIVE_OCTETS / 2)) {
			bitField.appendValue((value >> 32) & BITPATTERN_01111111, 8); //removed sign bit
			bitField.appendValue((value >> 24) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 16) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 8) & BITPATTERN_11111111, 8);
			bitField.appendValue(value & BITPATTERN_11111111, 8);
		} else if ((value >= -SIZE_SIX_OCTETS / 2) && (value < SIZE_SIX_OCTETS / 2)) {
			bitField.appendValue((value >> 40) & BITPATTERN_01111111, 8);
			bitField.appendValue((value >> 32) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 24) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 16) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 8) & BITPATTERN_11111111, 8);
			bitField.appendValue(value & BITPATTERN_11111111, 8);
		} else if ((value >= -SIZE_SEVEN_OCTETS / 2) && (value < SIZE_SEVEN_OCTETS / 2)) {
			bitField.appendValue((value >> 48) & BITPATTERN_01111111, 8);
			bitField.appendValue((value >> 40) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 32) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 24) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 16) & BITPATTERN_11111111, 8);
			bitField.appendValue((value >> 8) & BITPATTERN_11111111, 8);
			bitField.appendValue(value & BITPATTERN_11111111, 8);
		} else {
			bitField.appendValue(value, 64); //32 changed to 64
		}

		return bitField;
	}

	/**
     * Encoding of a normally small non-negative whole number
     * 
     * Encoding of a whole number that is expected to be small, but whose size
     * is potentially unlimited due to the presence of an extension marker.
     * (e.g. a choice index)
     * 
     * @see "X.691-0207 10.6"
     */
	protected void encodeNormallySmallNonNegativeWholeNumber(long value) throws IOException {
		if (value < 0) {
			throw new EncoderException("The normally small-non-negative-whole-number may not be negative");
		}

		if (value < 64) {
			getBitOutputStream().writeBit(0);
			BitField bitField = encodeAsNonNegativeBinaryIntegerIntoBits(value, 6);
			getBitOutputStream().writeBits(bitField);
		} else {
			getBitOutputStream().writeBit(1);

			BitField bitField = encodeSemiConstrainedWholeNumber(value, (long)0);

			// encode length determinant if needed, which corresponds to the
            // amount of octets
			if (bitField.getEncodingLength() > 0) {
				encodeLengthField(bitField.getEncodingLength(), 0);
			}

			// write bitfield
			getBitOutputStream().writeBits(bitField);
		}
	}

	/**
     * Encoding of a semi-constrained whole number
     * 
     * The offset from the lower bound (value-lowerBound) is placed into the
     * minimum number of octets as a non-negative-binary-integer. The number of
     * octets is first encoded in a length field L (Note: the procedures of this
     * method always produce the indefinite length case)
     * 
     * @see "X.691-0207 10.7"
     */
	protected BitField encodeSemiConstrainedWholeNumber(long value, long constrainedRootMinimum) throws IOException {
		//System.out.print("PERENcoder: encodeSemiConstrainedWholeNumber : VALUE "+value + " constrainedRootMinimum "+constrainedRootMinimum+ "\n");
		if (value < constrainedRootMinimum) {
			throw new EncoderException("The semi constrained value may not be smaller than the lower bound");
		}

		BitField bitField = encodeAsNonNegativeBinaryInteger(value - constrainedRootMinimum);

		// sets the amount of bits to be encoded
		//bitField.setEncodingLength(bitField.getSize());

		// encodeLengthField(bitField.getSize(), 0);
		// getBitOutputStream().writeBits(bitField);

		return bitField;
	}

	/**
     * Encodes a component as if it were a open type field.
     * 
     * @see "X.691-0207 10.2"
     */
	synchronized protected void encodeAsOpenTypeField(TypeEncoder typeEncoder) throws IOException {
		BitOutputStream oldStream = getBitOutputStream();

		finish();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BasicBitOutputStream newStream = new BasicBitOutputStream(baos);
		setBitOutputStream(newStream);

		typeEncoder.encode(this);
		finish();

		setBitOutputStream(oldStream);

		encodeLengthField(baos.size(), 0);

		for (byte dataByte : baos.toByteArray()) {
			getBitOutputStream().writeByte(dataByte);
		}
	}

	/**
     * Encoding of the ObjectIdentifier type.
     * 
     * Note: The ObjectIdentifier type is encoded using the content octets of a
     * BER preceeded by a length determinant.
     * 
     * @see "X.691-0207 23"
     * @see "X.690-0207 8.19"
     */
	public void encodeAsObjectIdentifier(List<Integer> value, TypeInformation typeInformation) throws IOException {
		int firstObjectIdentifierComponent = value.get(0);
		int secondObjectIdentifierComponent = value.get(1);

		/**
         * Derive the first subidentifier:
         * 
         * be X the firstObjectIdentifierComponent be Y the
         * secondObjectIdentifierComponent
         * 
         * then the subidentifier will be derived like this: subidentifier =
         * (X*40) + Y
         * 
         * @see "X.690-0207 8.19.4"
         */
		int firstSubIdentifier = (firstObjectIdentifierComponent * 40) + secondObjectIdentifierComponent;

		/**
         * Generate BER contents octets of the firstSubIdentifier and subsequent
         * subidentifiers if present.
         * 
         * Example: the value 180 will be b'1000000100110100'
         * 
         * @see "X.690-0207 8.19.5"
         */
		DynamicBitField bitField = encodeObjectIdentifierSubIdentifier(firstSubIdentifier);

		for (int i = 2; i < value.size(); i++) {
			int subIdentifier = value.get(i);

			DynamicBitField subIdentifierBitField = encodeObjectIdentifierSubIdentifier(subIdentifier);
			bitField.appendBits(subIdentifierBitField);
		}

		int usedOctets = (int) Math.ceil(bitField.getSize() / 8.0f);

		/**
         * Preceed BER conents octets with semi constrained length determinant
         * defining the amount of used octets in the encoding.
         * 
         * @see "X.691-0207 23"
         */
		encodeLengthField(usedOctets, 0);

		/**
         * Keep octet alignment of the bit field in the ALIGNED variant.
         * 
         * @see "X.691-0207 23"
         */
		keepOctetAlignment();

		/**
         * Write BER contents octets.
         * 
         * TODO: invoke procedures of 10.9
         * 
         * @see "X.691-0207 23"
         */
		getBitOutputStream().writeBits(bitField);

		/**
         * TODO: handle fragmentation
         */
	}

	private DynamicBitField encodeObjectIdentifierSubIdentifier(int firstSubIdentifier) {
		int bitLength = Math.max(0, (int) Math.ceil(Math.log(firstSubIdentifier) / Math.log(2))) + 1;
		int paddingBits = (7 - bitLength % 7) % 7;
		DynamicBitField bitField = new DynamicBitField();

		for (int i = 0; i < bitLength; i++) {
			int bitPosition = bitLength - i - 1;
			int bit = (firstSubIdentifier >> bitPosition) & 1;

			if ((bitField.getSize() % 8) == 0) {
				if (bitPosition < 7) {
					bitField.appendBit(0);
				} else {
					bitField.appendBit(1);
				}

				if (i == 0) {
					if ((bitLength % 7) > 0) {
						bitField.appendBits(0, paddingBits);
					}
				}
			}

			bitField.appendBit(bit);
		}

		return bitField;
	}

	/**
     * Encoding of the restricted character string type VisibleString.
     * 
     * The mapping of characters to encodable values follows the "International
     * Register of Coded Character Sets" no. 6 (ISO 646, USA Version X3.4 -
     * 1968) + SPACE.
     * 
     * Note: one unconstrained character is encoded on 7 bits. But the actual
     * amount of bits used is 8 bits since the amount of bits used in the
     * ALIGNED variant has to be a power of two.
     * 
     * @see "X.691-0207 27"
     * @see "X.680-0207 37.1"
     * @see <a href="http://www.itscj.ipsj.or.jp/ISO-IR/006.pdf">ISO Character
     *      Set Table 006</a>
     */
	public void encodeAsVisibleString(String value, TypeInformation typeInformation) throws IOException {
		//System.out.print("PEREncoder: encodeAsVisibleString------------------- :  value "+value + " constarint "+typeInformation.hasConstraint() +"\n");
		if (!typeInformation.hasConstraint()) {
			encodeUnconstrainedRestrictedCharacterString(value, typeInformation, VisibleStringInfo.getInstance());
		} else {
			encodeRestrictedCharacterString(value, typeInformation, VisibleStringInfo.getInstance());
		}
	}

	/**
     * Encoding of the restricted character string type IA5String.
     * 
     * The mapping of characters to encodable values follows the "International
     * Register of Coded Character Sets" no. 1 + 6 (ISO 646, USA Version X3.4 -
     * 1968) + SPACE + DELETE.
     * 
     * @see "X.691-0207 27"
     * @see "X.680-0207 37.1"
     * @see <a href="http://www.itscj.ipsj.or.jp/ISO-IR/001.pdf">ISO Character
     *      Set Table 001</a>
     * @see <a href="http://www.itscj.ipsj.or.jp/ISO-IR/006.pdf">ISO Character
     *      Set Table 006</a>
     */
	public void encodeAsIA5String(String value, TypeInformation typeInformation) throws IOException {
		if (!typeInformation.hasConstraint()) {
			encodeUnconstrainedRestrictedCharacterString(value, typeInformation, IA5StringInfo.getInstance());
		} else {
			encodeRestrictedCharacterString(value, typeInformation, IA5StringInfo.getInstance());
		}
	}

	/**
     * Encoding of the restricted character string type PrintableString.
     * 
     * The mapping of characters to encodable values follows the specification
     * X.680-0207 37.4 Table 8.
     * 
     * @see "X.680-0207 37.4 Table 8"
     */
	public void encodeAsPrintableString(String value, TypeInformation typeInformation) throws IOException {
		//System.out.print("PEREncoder: encodeAsPrintableString------------------- :  value "+value + " constarint "+typeInformation.hasConstraint() +"\n");
		if (!typeInformation.hasConstraint()) {
			encodeUnconstrainedRestrictedCharacterString(value, typeInformation, PrintableStringInfo.getInstance());
		} else {
			encodeRestrictedCharacterString(value, typeInformation, PrintableStringInfo.getInstance());
		}
	}

	/**
     * Encoding of the restricted character string type NumericString.
     * 
     * The mapping of characters to encodable values follows the specification
     * X.680-0207 37.4 Table 7.
     * 
     * @see "X.680-0207 37.4 Table 7"
     */
	public void encodeAsNumericString(String value, TypeInformation typeInformation) throws IOException {
		if (!typeInformation.hasConstraint()) {
			encodeUnconstrainedRestrictedCharacterString(value, typeInformation, NumericStringInfo.getInstance());
		} else {
			encodeRestrictedCharacterString(value, typeInformation, NumericStringInfo.getInstance());
		}
	}

	public void encodeAsGeneralString(String value, TypeInformation typeInformation) throws IOException {
		throw new RuntimeException("Not yet implemented!");
	}

	/**
     * Encoding of the restricted character string type BMPString.
     * 
     * The mapping of characters to encodable values follows the specification
     * X.680-0207 37.15.
     * 
     * @see "X.680-0207 37.15"
     */
	public void encodeAsBMPString(String value, TypeInformation typeInformation) throws IOException {
		if (!typeInformation.hasConstraint()) {
			encodeUnconstrainedRestrictedCharacterString(value, typeInformation, BMPStringInfo.getInstance());
		} else {
			encodeRestrictedCharacterString(value, typeInformation, BMPStringInfo.getInstance());
		}
	}

	private void encodeUnconstrainedRestrictedCharacterString(String value, TypeInformation typeInformation, RestrictedCharacterStringInfo characterStringInfo) throws IOException {
		int stringLength = value.length();

		int neededCharacterBits = (int) Math.ceil(Math.log(characterStringInfo.getAlphabetSize()) / Math.log(2));
		int neededCharacterBitsPowerOf2 = MathUtil.findNextPowerOf2(neededCharacterBits);
		// int largestEncodableIndex = (int)Math.pow(2,
        // neededCharacterBitsPowerOf2) - 1;
		keepOctetAlignment();
		encodeLengthField(stringLength, 0);

		if ((stringLength >= 0) && (stringLength < SIZE_16K)) {
			for (int i = 0; i < stringLength; i++) {
				int characterIndex = characterStringInfo.getCharacterIndex(value.charAt(i));
				//System.out.print("encodeUnconstrainedRestrictedCharacterString: 1  value "+characterIndex +"\n");
				BitField bitField = encodeAsNonNegativeBinaryIntegerIntoBits(characterIndex, neededCharacterBitsPowerOf2);
				getBitOutputStream().writeBits(bitField);
			}
		} else {
			// Fragment
			int multiplier = (int) Math.min(4, Math.floor(stringLength / (float) SIZE_16K));

			String subString = value.substring(0, multiplier * SIZE_16K);
			for (int i = 0; i < subString.length(); i++) {
				int characterIndex = characterStringInfo.getCharacterIndex(subString.charAt(i));
				//System.out.print("encodeUnconstrainedRestrictedCharacterString: 2  value "+characterIndex +"\n");
				BitField bitField = encodeAsNonNegativeBinaryIntegerIntoBits(characterIndex, neededCharacterBitsPowerOf2);
				getBitOutputStream().writeBits(bitField);
			}

			encodeUnconstrainedRestrictedCharacterString(value.substring(multiplier * SIZE_16K), typeInformation, characterStringInfo);
		}
	}

	private void encodeRestrictedCharacterString(String value, TypeInformation typeInformation, RestrictedCharacterStringInfo characterStringInfo) throws IOException {
		int stringLength = value.length();

		Constraint constraint = typeInformation.getConstraint();

		/**
         * Evaluate the size constraint and permitted alphabet constraint
         */
		PERRestrictedCharacterStringPermittedAlphabetConstraintVisitor permittedAlphabetVisitor = new PERRestrictedCharacterStringPermittedAlphabetConstraintVisitor(null, characterStringInfo);
		PERRestrictedCharacterStringSizeConstraintVisitor sizeVisitor = new PERRestrictedCharacterStringSizeConstraintVisitor(null);
		constraint.accept(permittedAlphabetVisitor);
		constraint.accept(sizeVisitor);

		/**
         * If the type is extensible then we add a '0' bit if the length is
         * within the extension root. Otherwise we add a '1' bit. And encode the
         * type as if it were unconstrained.
         * 
         * @see "X.691-0207 27.4"
         */
		if (sizeVisitor.isExtensible()) {
			if ((!sizeVisitor.hasConstrainedRootMaximum()) || (sizeVisitor.hasConstrainedRootMaximum() && (stringLength <= sizeVisitor.getConstrainedRootMaximum()))) {
				getBitOutputStream().writeBit(0);
			} else {
				getBitOutputStream().writeBit(1);
				encodeUnconstrainedRestrictedCharacterString(value, typeInformation, characterStringInfo);
				return;
			}
		}

		int neededCharacterBits = (int) Math.ceil(Math.log(permittedAlphabetVisitor.getAlphabetSize()) / Math.log(2));

		int neededCharacterBitsPowerOf2 = MathUtil.findNextPowerOf2(neededCharacterBits);
		int largestEncodableIndex = (int) Math.pow(2, neededCharacterBitsPowerOf2) - 1;

		boolean isAligned = true;
		boolean needLengthEncoding = true;
		if (sizeVisitor.hasConstrainedRootMaximum() && (sizeVisitor.getConstrainedRootMinimum() == sizeVisitor.getConstrainedRootMaximum()) && (sizeVisitor.getConstrainedRootMinimum() <= SIZE_64K)) {
			Long maxStringSize = sizeVisitor.getConstrainedRootMaximum();

			if (maxStringSize * neededCharacterBitsPowerOf2 <= 16) {
				isAligned = false;
			}

			needLengthEncoding = false;
		}

		if (permittedAlphabetVisitor.getUpperAlphabetIndex() > largestEncodableIndex) {
			permittedAlphabetVisitor.orderCanonically();
		}

		if (needLengthEncoding) {
			if (sizeVisitor.hasConstrainedMaximum()) {
				encodeLengthField(stringLength, sizeVisitor.getConstrainedMinimum(), sizeVisitor.getConstrainedMaximum());
			} else {
				encodeLengthField(stringLength, sizeVisitor.getConstrainedMinimum());
			}
		}

		if (isAligned) {
			keepOctetAlignment();
		}

		if ((stringLength >= 0) && (stringLength < SIZE_16K)) {
			for (int i = 0; i < stringLength; i++) {
				int characterIndex = permittedAlphabetVisitor.getCharacterIndex(value.charAt(i));
				BitField bitField = encodeAsNonNegativeBinaryIntegerIntoBits(characterIndex, neededCharacterBitsPowerOf2);
				getBitOutputStream().writeBits(bitField);
			}
		} else {
			// Fragment
			int multiplier = (int) Math.min(4, Math.floor(stringLength / (float) SIZE_16K));

			String subString = value.substring(0, multiplier * SIZE_16K);
			for (int i = 0; i < subString.length(); i++) {
				int characterIndex = permittedAlphabetVisitor.getCharacterIndex(subString.charAt(i));
				BitField bitField = encodeAsNonNegativeBinaryIntegerIntoBits(characterIndex, neededCharacterBitsPowerOf2);
				getBitOutputStream().writeBits(bitField);
			}

			/**
             * TODO: we can't do it this way because extensions would add wrong
             * extra information in every fragment.
             */
			encodeRestrictedCharacterString(value.substring(multiplier * SIZE_16K), typeInformation, characterStringInfo);
		}
	}

	/**
     * @see org.openasn1.codec.coder.ASN1Encoder#encodeAsEnumerated(java.lang.Enum,
     *      org.openasn1.codec.coder.typecoder.TypeInformation)
     */
	public <T extends Enum> void encodeAsEnumerated(HashMap<T, EnumeratedItemTypeInformation> enumTypeMap, T value, TypeInformation typeInformation) throws IOException {
		EnumeratedItemTypeInformation valueTypeInformation = enumTypeMap.get(value);
		//System.out.print("PEREncoder: encodeAsEnumerated-########################### :  value "+value +"\n");
		ArrayList<EnumeratedSortContainer> extensionRootContainerList = new ArrayList<EnumeratedSortContainer>();
		ArrayList<EnumeratedSortContainer> extensionAdditionContainerList = new ArrayList<EnumeratedSortContainer>();

		for (Enum enumConstant : (Enum[]) value.getDeclaringClass().getEnumConstants()) {
			EnumeratedItemTypeInformation itemTypeInformation = enumTypeMap.get(enumConstant);

			if ((itemTypeInformation != null) && itemTypeInformation.isExtensionAddition()) {
				extensionAdditionContainerList.add(new EnumeratedSortContainer(enumConstant, itemTypeInformation.getValue()));
			} else {
				extensionRootContainerList.add(new EnumeratedSortContainer(enumConstant, itemTypeInformation.getValue()));
			}
		}

		Collections.sort(extensionRootContainerList);
		/**
         * Extension additions are always defined in ascending order
         * 
         * @see "X.691-0207 13.1"
         */
		// Collections.sort(extensionAdditionContainerList);
		ArrayList<EnumeratedSortContainer> containerList = extensionRootContainerList;

		if (typeInformation.isExtensible()) {
			if (valueTypeInformation.isExtensionAddition()) {
				// not within the extension root
				getBitOutputStream().writeBit(1);

				containerList = extensionAdditionContainerList;
			} else {
				// within the extension root
				getBitOutputStream().writeBit(0);
			}
		}

		int index = 0;

		for (EnumeratedSortContainer container : containerList) {
			if (container.getEnumerated().equals(value)) {
				if (containerList.equals(extensionAdditionContainerList)) {
					/**
                     * If an extension marker is present and the value lies not
                     * within the extension root list.
                     * 
                     * @see "X.691-0207 13.3"
                     */
					//System.out.print("PEREncoder: encodeAsEnumerated-########################### :  1"+"\n");
					encodeSemiConstrainedWholeNumber(index,(long) 0);
				} else {
					/**
                     * If no extension marker is present or the value lies
                     * within the extension root list.
                     * 
                     * @see "X.691-0207 13.2"
                     */
					//System.out.print("PEREncoder: encodeAsEnumerated-########################### :  2"+"\n");
					BitField bitField = encodeConstrainedWholeNumber(index,(long) 0, (long) (containerList.size() - 1));

					if (bitField.getEncodingLength() > 0) {
						int length = (int) Math.ceil(bitField.getSize() / 8.0f);
						encodeLengthField(length, 1, bitField.getEncodingLength());
					}

					if (bitField.isOctetAligned()) {
						//System.out.print("PEREncoder: encodeAsEnumerated-###### isOctetAligned :  true"+"\n");
						keepOctetAlignment();
					}

					// write bitfield
					getBitOutputStream().writeBits(bitField);

				}

				return;
			}
			index++;
		}

		throw new RuntimeException("Encoding of enumerated type not failed!");
	}

	/**
     * Encoding of the choice type
     * 
     * Note: Encoding of choice types are not affected by PER-visible
     * constraints.
     * 
     * TODO: If one component is an untagged CHOICE then the component will
     * adopt the tag of the component with the smallest tag in the
     * "RootAlternativeTypeList" of the CHOICE type.
     * 
     * @see "X.691-0207 22"
     */
	public synchronized <T> void encodeAsChoice(List<TypeEncoder> componentEncoderList, TypeInformation typeInformation) throws IOException {
		TypeEncoder selectedAlternativeTypeEncoder = null;
		long encodingIndex = 0;

		ArrayList<ArrayList<TypeEncoder>> sortedLists = new ArrayList<ArrayList<TypeEncoder>>();
		ArrayList<TypeEncoder> rootComponentEncoderList = new ArrayList<TypeEncoder>();
		ArrayList<TypeEncoder> extensionAdditionComponentEncoderList = new ArrayList<TypeEncoder>();

		/**
         * Find our selectedAlternativeTypeEncoder and partition the component
         * Encoders into root- and extension addition lists.
         */
		for (TypeEncoder typeEncoder : componentEncoderList) {
			if (typeEncoder.getTypeInformation().isExtensionAddition()) {
				extensionAdditionComponentEncoderList.add(typeEncoder);
			} else {
				rootComponentEncoderList.add(typeEncoder);
			}

			if (typeEncoder.getEncodable() != null) {
				selectedAlternativeTypeEncoder = typeEncoder;
			}
		}
		if (selectedAlternativeTypeEncoder == null) {
			throw new RuntimeException("No CHOICE alternative set!");
		}

		if (!selectedAlternativeTypeEncoder.getTypeInformation().isExtensionAddition()) {
			/**
             * Our alternative component is no extension, so we need canonical
             * ordering.
             */

			/**
             * Iterate over all tag classes in the following order defined by
             * the enum: UNIVERSAL, APPLICATION, context-specific, PRIVATE.
             */
			for (TagClass tagClass : TagClass.values()) {
				ArrayList<TypeEncoder> encoderList = new ArrayList<TypeEncoder>();

				/**
                 * Iterate over all type encoders. Visit only root components.
                 */
				for (TypeEncoder typeEncoder : componentEncoderList) {
					if (typeEncoder.getTypeInformation().getTagList().size() > 0) {
						/**
                         * The canonical order for tags is based on the
                         * outermost tag of each type. So we use .get(0) to
                         * receive the outermost tag.
                         */
						if (!typeEncoder.getTypeInformation().isExtensionAddition()) {
							if (typeEncoder.getTypeInformation().getTagList().get(0).getTagClass().equals(tagClass)) {
								encoderList.add(typeEncoder);
							}
						}
					}
				}
				Collections.sort(encoderList, TypeEncoderComparator.getInstance());

				sortedLists.add(encoderList);
			}

			boolean indexFound = false;
			for (ArrayList<TypeEncoder> sortedList : sortedLists) {
				for (TypeEncoder typeEncoder : sortedList) {
					if (selectedAlternativeTypeEncoder.equals(typeEncoder)) {
						indexFound = true;
						break;
					}

					encodingIndex++;
				}
				if (indexFound) {
					break;
				}
			}

			if (!indexFound) {
				throw new RuntimeException("No encoding index for the CHOICE alternative can be determined!");
			}
		} else {
			/**
             * Our alternative component is an extension, so we don't need no
             * ordering.
             */

			/**
             * Iterate over all type encoders. Visit only extension components.
             * 
             * Note: ITU-T Rec. X.680 | ISO/IEC 8824-1, 28.4, requires that each
             * successive extension addition shall have a greater tag value than
             * the last added to the "ExtensionAdditionAlternativesList". So we
             * don't need sorting here.
             * 
             * @see "X.691-0207 22.2"
             */
			for (TypeEncoder typeEncoder : componentEncoderList) {
				if (typeEncoder.getTypeInformation().isExtensionAddition()) {
					if (selectedAlternativeTypeEncoder.equals(typeEncoder)) {
						break;
					}
					encodingIndex++;
				}
			}
		}

		boolean shouldEncodeIndex = true;

		/**
         * If the choice has only one alternative in the extension root, there
         * shall be no encoding for the index if that alternative is chosen.
         * 
         * @see "X.691-0207 22.4"
         */
		if (rootComponentEncoderList.size() == 1 && (!selectedAlternativeTypeEncoder.getTypeInformation().isExtensionAddition())) {
			shouldEncodeIndex = false;
		}

		/**
         * Write "extension bit" if neccessary.
         * 
         * @see "X.691-0207 22.5"
         */
		if (typeInformation.isExtensible()) {
			if (selectedAlternativeTypeEncoder.getTypeInformation().isExtensionAddition()) {
				getBitOutputStream().writeBit(1);
			} else {
				getBitOutputStream().writeBit(0);
			}
		}

		BitField bitField;

		/**
         * No "extension bit" present or selected alternative lies within the
         * extension root so we encode the index as an integer type followed by
         * the encoding of the selected alternative.
         * 
         * @see "X.691-0207 22.6, 22.7"
         */
		if (!typeInformation.isExtensible() || (!selectedAlternativeTypeEncoder.getTypeInformation().isExtensionAddition())) {
			if (shouldEncodeIndex) {
				bitField = encodeConstrainedWholeNumber(encodingIndex, (long)0, (long)rootComponentEncoderList.size() - 1);

				if (bitField.getEncodingLength() > 0) {
					int length = (int) Math.ceil(bitField.getSize() / 8.0f);
					;
					encodeLengthField(length, 1, bitField.getEncodingLength());
				}

				if (bitField.isOctetAligned()) {
					keepOctetAlignment();
				}

				// write bitfield
				getBitOutputStream().writeBits(bitField);
			}

			selectedAlternativeTypeEncoder.encode(this);
			return;
		}

		/**
         * The "extension bit" is present and the selected alternative does not
         * lie within the extension root so we encode the index as a small non
         * negative whole number followed by the encoding of the selected
         * alternative as if it were the value of an open type field.
         * 
         * @see "X.691-0207 22.8"
         */
		bitField = encodeSemiConstrainedWholeNumber(encodingIndex, (long) 0);

		if (bitField.getEncodingLength() > 0) {
			int length = (int) Math.ceil(bitField.getSize() / 8.0f);
			;
			encodeLengthField(length, 1, bitField.getEncodingLength());
		}

		if (bitField.isOctetAligned()) {
			keepOctetAlignment();
		}

		// write bitfield
		getBitOutputStream().writeBits(bitField);

		encodeAsOpenTypeField(selectedAlternativeTypeEncoder);
	}
	//real encoding
	public void encodeAsReal(double doubleObj, TypeInformation typeInformation) throws IOException {
		//System.out.print("PEREncoder: encodeAsReal------------------- :  value "+doubleObj +"\n");
					//DynamicBitField bitField = new DynamicBitField();
					ByteArrayOutputStream str = new ByteArrayOutputStream();
					
				//	if(doubleObj == 0) {str.write(0x00);} else
					if(doubleObj == Double.POSITIVE_INFINITY) { str.write(0x40); }
					else if(doubleObj == Double.NEGATIVE_INFINITY) { str.write(0x41); }
					else if (Double.isNaN(doubleObj)) {str.write(0x42);}
					byte[] encodedData = null;
					
					if (doubleObj != 0) {
						long bits = Double.doubleToRawLongBits(doubleObj);
						int signByte = (int) (bits >> (63 - 6)) & (1 << 6) | (1 << 7);
						int exponent = ((int) (bits >> 52) & 0x7FF) - (1023 + 52);
						long mantissa = (bits & 0xFFFFFFFFFFFFFL) | (1L << 52);
						// add the hidden bit
						while ((mantissa & 1) == 0) {
							mantissa >>= 1;
							exponent++;
						}
						// normalize
						byte[] exponentBytes = BigInteger.valueOf(exponent).toByteArray();
						byte[] matissaBytes = BigInteger.valueOf(mantissa/* >>scale */).toByteArray();

						if (exponentBytes.length <= 3) {
							str.write(signByte | (exponentBytes.length - 1));
						} else {
							str.write(signByte | 3);
							str.write(exponentBytes.length);
						}
						try {
							str.write(exponentBytes);
							str.write(matissaBytes);
						} catch (IOException e) {
							e.printStackTrace();
						}
						encodedData = str.toByteArray();
						//System.out.print("PEREncoder: encodeAsReal------------------- :" + Arrays.toString(encodedData)
						//		+ " length " + encodedData.length + "\n");
						encodeLengthField(encodedData.length, 0);
					} else if (doubleObj == 0) {
						str.write(0x00);
						encodedData = str.toByteArray();
						keepOctetAlignment();
						//System.out.print("PEREncoder: encodeAsReal------------------- :" + Arrays.toString(encodedData)
							//	+ " length " + encodedData.length + "\n");
					}
					//byte[] encodedData = str.toByteArray();
					//System.out.print("PEREncoder: encodeAsReal------------------- :"+ Arrays.toString(encodedData)+" length "+encodedData.length +"\n");
					//encodeLengthField(encodedData.length, 0);
					//keepOctetAlignment();//just added to setaligned = true case to be added here
					getBitOutputStream().writeBytes(encodedData);
					//System.out.print("PEREncoder: encodeAsReal------------------- :  encode success \n");	
	}

	/**
     * Encoding of the integer type
     * 
     * Note: unconstrained integers are encoded as specified in X.691-0207 10.8
     * (encoding of an unconstrained whole number).
     * 
     * @see "X.691-0207 12"
     */
	public void encodeAsInteger(long value, TypeInformation typeInformation) throws IOException {
		if (typeInformation.hasConstraint()) {
			encodeConstrainedInteger(value, typeInformation);
		} else {
			encodeUnconstrainedInteger(value, typeInformation);

		}
	}

	private void encodeConstrainedInteger(long value, TypeInformation typeInformation) throws IOException {
		Constraint constraint = typeInformation.getConstraint();
		//System.out.print("PEREncoder: encodeConstrainedInteger------------------- :  value "+value +"\n");
		/**
         * Evaluate the size constraint
         */
		PERIntegerSizeConstraintVisitor sizeVisitor = new PERIntegerSizeConstraintVisitor(null);
		constraint.accept(sizeVisitor);

		boolean hasConstrainedRootMinimum = sizeVisitor.hasConstrainedRootMinimum();
		boolean hasConstrainedRootMaximum = sizeVisitor.hasConstrainedRootMaximum();
		Long constrainedRootMinimum = (long) 0;
		Long constrainedRootMaximum = (long) 0;
		boolean isFixedSize = false;
		boolean isUpperBoundSet = false;

		if (hasConstrainedRootMinimum) {
			constrainedRootMinimum = sizeVisitor.getConstrainedRootMinimum();
		}
		if (hasConstrainedRootMaximum) {
			constrainedRootMaximum = sizeVisitor.getConstrainedRootMaximum();
		}

		/**
         * If the type is extensible then we add a '0' bit if the value is
         * within the extension root. Otherwise we add a '1' bit. And encode the
         * type as if it were unconstrained.
         * 
         * @see "X.691-0207 12.1"
         */
		if (sizeVisitor.isExtensible()) {
			boolean isValueInRoot = false;

			if (hasConstrainedRootMinimum && hasConstrainedRootMaximum) {
				if ((value >= constrainedRootMinimum) && (value <= constrainedRootMaximum)) {
					isValueInRoot = true;
				}
				isUpperBoundSet = (constrainedRootMaximum < SIZE_EIGHT_OCTETS);
				isFixedSize = (constrainedRootMinimum == constrainedRootMaximum);
			} else if (hasConstrainedRootMinimum && (!hasConstrainedRootMaximum)) {
				if ((value >= constrainedRootMinimum)) {
					isValueInRoot = true;
				}
			} else if ((!hasConstrainedRootMinimum) && hasConstrainedRootMaximum) {
				if ((value <= constrainedRootMaximum)) {
					isValueInRoot = true;
				}
				isUpperBoundSet = (constrainedRootMaximum < SIZE_EIGHT_OCTETS); //size_64K
			} else {
				isValueInRoot = true;
			}

			if (isValueInRoot) {
				getBitOutputStream().writeBit(0);
			} else {
				getBitOutputStream().writeBit(1);

				encodeUnconstrainedInteger(value, typeInformation);
				return;
			}
		}

		/**
         * Constraint restricts to single value. No addition to the field list.
         * 
         * @see "X.691-0207 12.2.1"
         */
		if (isFixedSize) {
			return;
		}

		BitField bitField = null;

		if (hasConstrainedRootMinimum && hasConstrainedRootMaximum) {
			/**
             * Constraint restricts value to a constrained whole number.
             * 
             * @see "X.691-0207 12.2.2"
             */
			bitField = encodeConstrainedWholeNumber(value, constrainedRootMinimum, constrainedRootMaximum);

			if (bitField.getEncodingLength() > 0) {
				int length = (int) Math.ceil(bitField.getSize() / 8.0f);
				//System.out.print("PERencoder: encodeConstrainedInteger :  length "+length +"\n");
				encodeLengthField(length, 1, bitField.getEncodingLength());

			}
		} else if (hasConstrainedRootMinimum && (!hasConstrainedRootMaximum)) {
			/**
             * Constraint restricts value to a semi constrained whole number.
             * 
             * @see "X.691-0207 12.2.3"
             */
			bitField = encodeSemiConstrainedWholeNumber(value, constrainedRootMinimum);

			if (bitField.getEncodingLength() > 0) {
				encodeLengthField(bitField.getEncodingLength(), 0);
			}
		} else {
			/**
             * Encode value as unconstrained whole number
             * 
             * @see "X.691-0207 12.2.4"
             */
			bitField = encodeUnconstrainedWholeNumber(value);

			if (bitField.getEncodingLength() > 0) {
				encodeLengthField(bitField.getEncodingLength(), 0);
			}
		}

		if (bitField.isOctetAligned()) {
			keepOctetAlignment();
		}

		// write bitfield
		getBitOutputStream().writeBits(bitField);
	}

	private void encodeUnconstrainedInteger(long value, TypeInformation typeInformation) throws IOException {
		// encode value as unconstrained whole number
		//System.out.print("PEREncoder: encodeUnConstrainedInteger------------------- :  value "+value +"\n");
		BitField bitField = encodeUnconstrainedWholeNumber(value);

		// encode length determinant if needed, which corresponds to the amount
        // of octets
		if (bitField.getEncodingLength() > 0) {
			//System.out.print("PERENcoder: encodeUnconstrainedInteger encoded length \n");
			encodeLengthField(bitField.getEncodingLength(), 0);
		}

		if (bitField.isOctetAligned()) {
			keepOctetAlignment();
		}

		// write bitfield
		getBitOutputStream().writeBits(bitField);
	}

	/**
     * Encoding of an unconstrained whole number (indefinite length case)
     * 
     * The integer type has no lower bound. Encoding as a
     * 2's-complement-binary-integer. Explicit length encoding is needed. The
     * encoded bit-field is octet-aligned.
     * 
     * @see "X.691-0207 10.8"
     */
	protected BitField encodeUnconstrainedWholeNumber(long value) throws IOException {
		//System.out.print("PERENcoder: encodeUnconstrainedWholeNumber " + value + "\n");
		// encodes the value as a 2's complement binary integer
		BitField bitField = encodeAs2sComplementBinaryInteger(value);
		// sets the amount of octets to be encoded
		int octets = (int) Math.ceil(bitField.getSize() / 8.0f);
		
		//System.out.print("PERENcoder: encodeUnconstrainedWholeNumber : bitField.getSize() "+bitField.getSize() + " octets "+octets +"\n");
		
		bitField.setEncodingLength(octets);

		// if Octet Aligned
		bitField.setOctetAligned(true);
		

		return bitField;
	}

	/**
     * Encoding of the sequence type
     * 
     * @see "X.691-0207 18"
     */
	public synchronized void encodeAsSequence(List<TypeEncoder> componentEncoderList, TypeInformation typeInformation) throws IOException {
		// pseudocode
		// if extension marker writeBit(1:one if values of extension additions
        // are present in this encoding|0)
		// foreach optionalOrDefaultComponent (add fragmented lengthencoding if
        // >= 64k):
		// writeBit(1:ifPresent|0:ifAbsent)
		// encodeComponents
		// if hasExtensionAdditions
		// writeCountOfExtensionAdditions (normally small number)
		// writePresenceBitMapOfThisExtensionAdditions
		// encodeExtensionAdditionsAsOpenTypeField

		ArrayList<TypeEncoder> rootComponentEncoderList = new ArrayList<TypeEncoder>();
		ArrayList<TypeEncoder> extensionComponentEncoderList = new ArrayList<TypeEncoder>();

		/**
         * Split up component list into root components and extension
         * components.
         */
		for (TypeEncoder typeEncoder : componentEncoderList) {
			if (typeEncoder.getTypeInformation().isExtensionAddition()) {
				extensionComponentEncoderList.add(typeEncoder);
			} else {
				rootComponentEncoderList.add(typeEncoder);
			}
		}

		boolean shouldEncodeAdditionComponent[] = null;
		int encodableAdditionComponents = 0;

		if (extensionComponentEncoderList.size() > 0) {
			/**
             * Interate over all addition component type encoders and write
             * default or optional present bit
             */
			shouldEncodeAdditionComponent = new boolean[extensionComponentEncoderList.size()];
			int index = 0;
			for (TypeEncoder typeEncoder : extensionComponentEncoderList) {
				if (typeEncoder.getTypeInformation().isOptional()) {
					shouldEncodeAdditionComponent[index] = (typeEncoder.getEncodable() != null);
				} else if (typeEncoder.getTypeInformation().hasDefaultValue()) {
					shouldEncodeAdditionComponent[index] = !(typeEncoder.getEncodable().equals(typeEncoder.getTypeInformation().getDefaultValue()));
				} else {
					shouldEncodeAdditionComponent[index] = true;
				}

				if (shouldEncodeAdditionComponent[index]) {
					encodableAdditionComponents++;
				}

				index++;
			}
		}

		if (typeInformation.isExtensible()) {
			if ((extensionComponentEncoderList.size() == 0) || (encodableAdditionComponents == 0)) {
				getBitOutputStream().writeBit(0);
			} else {
				getBitOutputStream().writeBit(1);
			}
		}

		/**
         * Interate over all root component type encoders and write default or
         * optional present bit
         */
		boolean shouldEncodeRootComponent[] = new boolean[rootComponentEncoderList.size()];
		int index = 0;
		for (TypeEncoder typeEncoder : rootComponentEncoderList) {
			if (typeEncoder.getTypeInformation().isOptional()) {
				shouldEncodeRootComponent[index] = (typeEncoder.getEncodable() != null);
			} else if (typeEncoder.getTypeInformation().hasDefaultValue()) {
				shouldEncodeRootComponent[index] = !(typeEncoder.getEncodable().equals(typeEncoder.getTypeInformation().getDefaultValue()));
			} else {
				shouldEncodeRootComponent[index] = true;
			}

			if (typeEncoder.getTypeInformation().isOptional() || typeEncoder.getTypeInformation().hasDefaultValue()) {
				if (shouldEncodeRootComponent[index]) {
					getBitOutputStream().writeBit(1);
				} else {
					getBitOutputStream().writeBit(0);
				}
			}

			index++;
		}

		/**
         * Encode components of the extension root
         */
		index = 0;
		for (TypeEncoder typeEncoder : rootComponentEncoderList) {
			if (shouldEncodeRootComponent[index]) {
				typeEncoder.encode(this);
			}

			index++;
		}

		if (encodableAdditionComponents == 0) {
			return;
		}

		/**
         * encode length of extension addition bitmap
         */
		encodeNormallySmallNonNegativeWholeNumber(extensionComponentEncoderList.size() - 1);

		/**
         * Interate over all addition component type encoders and write default
         * or optional present bit
         */
		index = 0;
		for (TypeEncoder typeEncoder : extensionComponentEncoderList) {
			if (typeEncoder.getTypeInformation().isOptional() || typeEncoder.getTypeInformation().hasDefaultValue()) {
				if (shouldEncodeAdditionComponent[index]) {
					getBitOutputStream().writeBit(1);
				} else {
					getBitOutputStream().writeBit(0);
				}
			} else {
				/**
				 * Mandatory fields are always present.
				 * 
				 * @see Dubuisson "ASN.1 - Communication between Heterogeneous Systems" 20.6.12
				 */
				getBitOutputStream().writeBit(1);
			}

			index++;
		}

		index = 0;
		for (TypeEncoder typeEncoder : extensionComponentEncoderList) {
			if (shouldEncodeAdditionComponent[index]) {
				encodeAsOpenTypeField(typeEncoder);
			}
			index++;
		}
	}

	/**
     * Encoding of the sequence-of type
     * 
     * @see "X.691-0207 19"
     */
	public <T> void encodeAsSequenceOf(TypeEncoder<T> encoderPrototype, List<T> elements, TypeInformation typeInformation) throws IOException {
		if (typeInformation.hasConstraint()) {
			encodeConstrainedSequenceOf(encoderPrototype, elements, typeInformation);
		} else {
			encodeUnconstrainedSequenceOf(encoderPrototype, elements, typeInformation);
		}
	}

	private <T> void encodeUnconstrainedSequenceOf(TypeEncoder<T> encoderPrototype, List<T> elements, TypeInformation typeInformation) throws IOException {
		int components = elements.size();

		if (components < SIZE_16K) {
			encodeLengthField(components, 0);

			for (T element : elements) {
				encoderPrototype.setEncodable(element);
				encoderPrototype.encode(this);
			}
		} else {
			/**
             * TODO: correct fragmentation.
             */

			// Fragment
			int multiplier = (int) Math.min(4, Math.floor(components / (float) SIZE_16K));

			encodeLengthField(multiplier * SIZE_16K, 0);

			for (int i = 0; i < multiplier * SIZE_16K; i++) {
				encoderPrototype.setEncodable(elements.get(0));
				encoderPrototype.encode(this);
				elements.remove(0);
			}
			ArrayList<T> subList = (ArrayList<T>) elements.subList(multiplier * SIZE_16K, elements.size() - 1);
			encodeAsSequenceOf(encoderPrototype, subList, typeInformation);
		}
	}

	private <T> void encodeConstrainedSequenceOf(TypeEncoder<T> encoderPrototype, List<T> elements, TypeInformation typeInformation) throws IOException {
		Constraint constraint = typeInformation.getConstraint();

		int components = elements.size();

		/**
         * Evaluate the size constraint
         */
		PERIntegerSizeConstraintVisitor sizeVisitor = new PERIntegerSizeConstraintVisitor(null);
		constraint.accept(sizeVisitor);

		boolean hasConstrainedRootMinimum = sizeVisitor.hasConstrainedRootMinimum();
		boolean hasConstrainedRootMaximum = sizeVisitor.hasConstrainedRootMaximum();
		Long constrainedRootMinimum = (long) 0;
		Long constrainedRootMaximum = (long) 0;
		boolean isFixedSize = false;
		boolean isUpperBoundSet = false;

		if (hasConstrainedRootMinimum) {
			constrainedRootMinimum = sizeVisitor.getConstrainedRootMinimum();
		}
		if (hasConstrainedRootMaximum) {
			constrainedRootMaximum = sizeVisitor.getConstrainedRootMaximum();
		}

		/**
         * If the type is extensible then we add a '0' bit if the component
         * count is within the extension root. Otherwise we add a '1' bit. And
         * encode the type as if it were unconstrained.
         * 
         * @see "X.691-0207 19.4"
         */
		if (sizeVisitor.isExtensible()) {
			boolean isValueInRoot = false;

			if (hasConstrainedRootMaximum) {
				if ((components >= constrainedRootMinimum) && (components <= constrainedRootMaximum)) {
					isValueInRoot = true;
				}
				isUpperBoundSet = (constrainedRootMaximum < SIZE_64K);
				isFixedSize = (constrainedRootMinimum == constrainedRootMaximum);
			} else {
				isValueInRoot = true;
			}

			if (isValueInRoot) {
				getBitOutputStream().writeBit(0);
			} else {
				getBitOutputStream().writeBit(1);

				encodeUnconstrainedSequenceOf(encoderPrototype, elements, typeInformation);
				return;
			}
		}

		/**
         * Constraint restricts component count to single value
         * 
         * @see "X.691-0207 19.5"
         */
		if ((!isFixedSize) || (constrainedRootMinimum >= SIZE_64K)) {
			if (hasConstrainedRootMinimum && hasConstrainedRootMaximum && isUpperBoundSet) {
				encodeLengthField(components, constrainedRootMinimum, constrainedRootMaximum);
			} else {
				encodeLengthField(components, 0);
			}
		}

		if (components < SIZE_64K) {
			for (T element : elements) {
				encoderPrototype.setEncodable(element);
				encoderPrototype.encode(this);
			}
		} else {
			/**
             * TODO: correct fragmentation.
             */

			// Fragment
			int multiplier = (int) Math.min(4, Math.floor(components / (float) SIZE_16K));

			for (int i = 0; i < multiplier * SIZE_16K; i++) {
				encoderPrototype.setEncodable(elements.get(0));
				encoderPrototype.encode(this);
				elements.remove(0);
			}
			ArrayList<T> subList = (ArrayList<T>) elements.subList(multiplier * SIZE_16K, elements.size() - 1);
			encodeAsSequenceOf(encoderPrototype, subList, typeInformation);
		}
	}

	protected void encodeConstrainedOctetString(byte[] values, TypeInformation typeInformation) throws IOException {
		Constraint constraint = typeInformation.getConstraint();

		/**
         * Evaluate the size constraint
         */
		PERRestrictedCharacterStringSizeConstraintVisitor sizeVisitor = new PERRestrictedCharacterStringSizeConstraintVisitor(null);
		constraint.accept(sizeVisitor);

		boolean hasConstrainedRootMaximum = sizeVisitor.hasConstrainedRootMaximum();
		boolean hasConstrainedRootMinimum = sizeVisitor.hasConstrainedRootMinimum();

		Long lowerBound = (long) 0;
		if (hasConstrainedRootMinimum) {
			lowerBound = sizeVisitor.getConstrainedRootMinimum();
		}

		Long upperBound = null;
		if (hasConstrainedRootMaximum) {
			upperBound = sizeVisitor.getConstrainedRootMaximum();
		}

		boolean isWithinTheExtensionRoot = true;

		/**
         * If the type is extensible then we add a '0' bit if the length is
         * within the extension root. Otherwise we add a '1' bit. In the '0'
         * case we encode the type as if the extension marker is not present.
         * 
         * @see "X.691-0207 16.3"
         */
		if (sizeVisitor.isExtensible()) {
			if ((!hasConstrainedRootMaximum) || (values.length <= upperBound)) {
				getBitOutputStream().writeBit(0);
			} else {
				isWithinTheExtensionRoot = false;
				getBitOutputStream().writeBit(1);
			}
		}

		if (isWithinTheExtensionRoot && hasConstrainedRootMaximum) {
			/**
             * Octet string is constrained to zero length (ub = 0). No encoding
             * shall be made.
             * 
             * @see "X.691-0207 16.5"
             */
			if (upperBound == 0) {
				return;
			}

			/**
             * Octet string is fixed length and the length is smaller or equal
             * to 2. The string will be encoded into "ub" octets.
             * 
             * @see "X.691-0207 16.6"
             */
			if ((lowerBound == upperBound) && (upperBound <= 2)) {
				getBitOutputStream().writeBytes(values);
				return;
			}

			/**
             * Octet string is fixed length and the length is greater than 2 but
             * smaller than 64k. The string will be encoded into "ub" octets.
             * (octet aligned).
             * 
             * @see "X.691-0207 16.7"
             */
			if ((lowerBound == upperBound) && (values.length < SIZE_64K)) {
				keepOctetAlignment();

				getBitOutputStream().writeBytes(values);
				return;
			}
		}

		/**
         * Octet string will be encoded with a length determinant and maybe
         * fragmentation.
         * 
         * @see "X.691-0207 16.8"
         */
		if (values.length < SIZE_16K) {
			if (hasConstrainedRootMaximum) {
				encodeLengthField(values.length, lowerBound, upperBound);
			} else {
				encodeLengthField(values.length, lowerBound);
			}

			keepOctetAlignment();

			getBitOutputStream().writeBytes(values);

			return;
		}

		// Fragmentation
		throw new RuntimeException("Octet String fragmentation is not yet implemented!");
	}

	protected void encodeUnconstrainedOctetString(byte[] values, TypeInformation typeInformation) throws IOException {
		if (values.length < SIZE_16K) {
			encodeLengthField(values.length, 0);

			keepOctetAlignment();

			getBitOutputStream().writeBytes(values);

			return;
		}

		// Fragmentation
		throw new RuntimeException("Octet String fragmentation is not yet implemented!");
	}

	/**
     * Encoding of a not bounded above length determinant (ALIGNED variant)
     * 
     * @see "X.691-0207 10.9.3"
     */
	protected void encodeLengthField(int length, long lowerBound) throws IOException {
		if (length < lowerBound) {
			throw new IllegalArgumentException("The length determinant may not be smaller than the lowerBound");
		}

		keepOctetAlignment();

		if (length < 128) {
			getBitOutputStream().writeByte((byte) length);
			//System.out.print("PERENcoder: encodeLengthField :length <128 "+length  +"\n");
		} else if (length < SIZE_16K) {
			int firstOctet = BITPATTERN_10000000;
			int secondOctet = 0;
			firstOctet |= (length >> 8) & BITPATTERN_00111111;
			secondOctet |= (length & BITPATTERN_11111111);
			getBitOutputStream().writeByte((byte) firstOctet);
			getBitOutputStream().writeByte((byte) secondOctet);
			//System.out.print("PERENcoder: encodeLengthField :length < SIZE_16K");
		} else {
			// Fragment
			int multiplier = (int) Math.min(4, Math.floor(length / SIZE_16K));
			int fragmentOctet = BITPATTERN_11000000 | multiplier;

			getBitOutputStream().writeByte((byte) fragmentOctet);
			//System.out.print("PERENcoder: encodeLengthField :else");
		}
	}

	/**
     * Encoding of a "fully bounded" length determinant (ALIGNED variant)
     * 
     * @see "X.691-0207 10.9.3"
     */
	protected void encodeLengthField(int length, long lowerBound, long upperBound) throws IOException {
		//System.out.print("PERencoder: encodeLengthField :  length "+length +" lowerBound "+lowerBound + " upperBound "+  upperBound+"\n");
		if (length > upperBound) {
			throw new IllegalArgumentException("The length determinant may not be greater than the upperBound");
		}
		if (length < lowerBound) {
			throw new IllegalArgumentException("The length determinant may not be smaller than the lowerBound");
		}

		/**
         * No length encoding since the length determinant is fixed by the type
         * definition (constrained by PER-visible constraints)
         * 
         * @see "X.691-0207 10.9.1"
         */
	 /*  if ((lowerBound == upperBound) && (lowerBound < SIZE_64K)) {
			System.out.print("encodeLengthField: setValue :  lowerBound == upperBound) && (lowerBound < SIZE_64K");
			return;

		}*/
		BitField bitField = encodeConstrainedWholeNumber(length, lowerBound, upperBound);
		if (upperBound < SIZE_64K) {
			if (bitField.isOctetAligned()) {
				keepOctetAlignment();
			}
			getBitOutputStream().writeBits(bitField);
		} else if (upperBound - lowerBound >= SIZE_64K) {
			encodeLengthField(length, lowerBound);
		}
	}

	/**
     * Encoding of a constrained whole number (ALIGNED variant)
     * 
     * The encoding of the value depends on the range (4 cases): 1. "range" is
     * less than or equal to 255 2. "range" is exactly 256 3. "range" is greater
     * than 256 and less than or equal to 64K 4. "range" is greater than 64K
     * 
     * @see "X.691-0207 10.5.7"
     */
	protected BitField encodeConstrainedWholeNumber(long value, Long constrainedRootMinimum, Long constrainedRootMaximum) throws IOException {
		//System.out.println("encodeConstrainedWholeNumber: value "+ value + " constrainedRootMinimum "+constrainedRootMinimum + " constrainedRootMaximum " +constrainedRootMaximum);
		long range = constrainedRootMaximum - constrainedRootMinimum + 1;

	/*	if (range == 1) {
			// empty bit-field
			return EmptyBitField.getInstance();
		}*/
		//System.out.println("encodeConstrainedWholeNumber: range "+ range );
		BitField bitField = null;
		if (range <= 255) {
			bitField = encodeAsNonNegativeBinaryIntegerIntoBits(value - constrainedRootMinimum, getNeededBitsForRange(range));
			//bitField.setOctetAligned(true);
		} else if (range == 256) {
			bitField.setOctetAligned(true);
			bitField = encodeAsNonNegativeBinaryIntegerIntoOctets(value - constrainedRootMinimum, 1);
		} else if (range <= SIZE_64K) {
			bitField = encodeAsNonNegativeBinaryIntegerIntoOctets(value - constrainedRootMinimum, 2);
			bitField.setOctetAligned(true);
		} else {
			//System.out.println("in integer undefined size case");
			int bitsNeccessary = (int) Math.ceil(Math.log(value) / Math.log(2));
			int octetsNeccessary = (int) Math.ceil(bitsNeccessary / 8.0f);
			//System.out.println("encodeConstrainedWholeNumber: bitsNeccessary "+ bitsNeccessary + " octetsNeccessary "+octetsNeccessary);
			bitField = encodeAsNonNegativeBinaryIntegerIntoOctets(value - constrainedRootMinimum, octetsNeccessary);
			bitField.setOctetAligned(true);
			bitField.setEncodingLength(octetsNeccessary);
		}

		return bitField;
	}
	
	/**
     * Encoding of the sequence-of type
     * 
     * @see "X.691-0207 19"
     */
	
	
}
