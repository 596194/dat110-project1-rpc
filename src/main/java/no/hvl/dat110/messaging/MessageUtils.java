package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;
	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

//	takes a Message as parameter and returns a segment, encapsulated with payload length and padding
	public static byte[] encapsulate(Message message) {

//		setting the length of the segment to 128bytes
		byte[] segment=new byte[SEGMENTSIZE];

//		saving the message byte[] to data
		byte[] data = message.getData();

//		test
//		for (int i=0;i<;i++){
//
//		}

//		setting the length of payload as header (index 0 = length)
		segment[0]= (byte) data.length;

//		adding the payload to the segment, from index 1 and forward
		int i=0;
		while(i<data.length){
			segment[i + 1] = data[i];
			i++;
		}

		return segment;
	}

//	takes a segment as parameter and returns a message, decapsulating down to the payload
	public static Message decapsulate(byte[] segment) {

//		new array with the length of payload (value from segment header)
		byte[] data=new byte[segment[0]];

//		adding the payload from segment to data[]

		for(int i=0;i<segment[0];i++){
			data[i]=segment[i+1];
		}
//		returning a new message with the payload (data) as parameter
		return new Message(data);
		
	}
	
}
