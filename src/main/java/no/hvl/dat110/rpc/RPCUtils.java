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
		
		byte[] rpcmsg = new byte[SEGMENTSIZE];

		rpcmsg[0]=rpcid;

		int i=0;
		while(i<payload.length){
			rpcmsg[i + 1] = payload[i];
			i++;
		}
		return rpcmsg;
	}
	// Decapsulate the rpcid and payload in a byte array according to the RPC message syntax
	public static byte[] decapsulate(byte[] rpcmsg) {

		byte[] rpcmsgIn=rpcmsg;
		byte[] payload = new byte[rpcmsgIn.length-1];

		for(int i=0;i<rpcmsgIn.length-1;i++){
			payload[i]=rpcmsgIn[i+1];
		}
		
		return payload;
		
	}

	// convert String to byte array
	public static byte[] marshallString(String str) {

		return str.getBytes();
	}

	// convert byte array to a String
	public static String unmarshallString(byte[] data) {

		return new String(data);
	}
	
	public static byte[] marshallVoid() {
		
		byte[] encoded = null;
		
		// TODO - START 
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
				
		// TODO - END
		
		return encoded;
		
	}
	
	public static void unmarshallVoid(byte[] data) {
		
		// TODO
		
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
	}

	// convert boolean to a byte array representation
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

	// convert byte array to a boolean representation
	public static boolean unmarshallBoolean(byte[] data) {
		
		return (data[0] > 0);
	}

	// integer to byte array representation
	public static byte[] marshallInteger(int x) {
//		uses ByteBuffer
		return ByteBuffer.allocate(4).putInt(x).array();
	}
	
	// byte array representation to integer
	public static int unmarshallInteger(byte[] data) {
		
		return ByteBuffer.wrap(data).getInt();
		
	}
}
