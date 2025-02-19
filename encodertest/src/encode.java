import java.io.*;
import org.openasn1.codec.coder.ASN1Encoder;
import org.openasn1.codec.coder.per.BasicPEREncoder;
import org.openasn1.codec.coder.typecoder.ObjectIdentifierEncoder;
import org.openasn1.codec.coder.typecoder.TypeInformation;
import org.openasn1.codec.util.bit.BasicBitOutputStream;
import org.openasn1.codec.util.converter.HexConverter;

import Telematics.manager.CodingManager;
import Telematics.om.Telematics;

public class encode{ 
public static void main(String[] args) {
//	System.out.println("Helloo world");
 	try { 
		testSpecificationExampleOfAnnexA ();
 	} catch(IOException exception) {
      		exception.printStackTrace();
	}
}

public static void testSpecificationExampleOfAnnexA ()
 throws IOException {

	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	CodingManager manager = new CodingManager();
	ASN1Encoder encoder = new BasicPEREncoder(outputStream , true); 
	manager.setDefaultEncoder(encoder);
	
	Telematics telematics = DataModelRepository.basicRecord(); 
	manager.encodeTelematics(telematics);
	String actualResult = HexConverter.encode(outputStream.toByteArray()); 
	System.out.println("Actual Result: " +actualResult );
	
 
}
}
