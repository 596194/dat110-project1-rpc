package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import no.hvl.dat110.TODO;

import static no.hvl.dat110.messaging.MessageUtils.SEGMENTSIZE;

public class RPCUtils {

	// Encapsulate the rpcid and payload in a byte array according to the RPC message syntax / format
	// include a byte that specifies what method used - string, int and so on?
	public static byte[] encapsulate(byte rpcid, byte[] payload) {
//		declaring rpcmsg with size 128
		byte[] rpcmsg = new byte[SEGMENTSIZE];

//		index 0 specifies what method used
		rpcmsg[0]=rpcid;

//		index 1-> is the payload
		int i=0;
		while(i<payload.length){
			rpcmsg[i + 1] = payload[i];
			i++;
		}
		return rpcmsg;
	}
	// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
	public static byte[] decapsulate(byte[] rpcmsg) {
//		saves rpcmsg as rpcmsgIn to be able to use it
		byte[] rpcmsgIn=rpcmsg;

//		declares payload as new byte[] with length to rpcmsgIn-1
		byte[] payload = new byte[rpcmsgIn.length-1];

//		for loop to copy from rpcmsgIn[i+1] to payload[i]
		for(int i=0;i<rpcmsgIn.length-1;i++){
			payload[i]=rpcmsgIn[i+1];
		}
		
		return payload;
		
	}

	// convert String to byte[]
	public static byte[] marshallString(String str) {

		return str.getBytes();
	}

	// convert byte[] to a String
	public static String unmarshallString(byte[] data) {

		return new String(data);
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = new byte[0];
		
		return encoded;
	}
	
	public static void unmarshallVoid(byte[] data) {

	}

	// convert boolean to a byte[] representation
	public static byte[] marshallBoolean(boolean b) {
		
		byte[] encoded = new byte[1];

		if (b) {
			encoded[0] = 1;
		} else
		{
			encoded[0] = 0;
		}

		return encoded;
	}

	// convert byte[] to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
	}

	// integer to byte[] representation
	public static byte[] marshallInteger(int x) {
//		ByteBuffer https://mkyong.com/java/java-convert-byte-to-int-and-vice-versa/
		return ByteBuffer.allocate(4).putInt(x).array();
	}
	
	// byte[] representation to integer
	public static int unmarshallInteger(byte[] data) {
//		ByteBuffer https://mkyong.com/java/java-convert-byte-to-int-and-vice-versa/
		return ByteBuffer.wrap(data).getInt();
		
	}
}
