package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {

		byte[] segment=new byte[SEGMENTSIZE];
		byte[] data;

		// TODO - START

		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer
		data = message.getData();

//		setting first byte if segment as the payload
//		segment[0] = message.getPayloadIndex(); //
//		trying again:

//		this.data = Arrays.copyOf(data,data.length);

//		segment = Arrays.copyOf(data,127);
		segment[0]= (byte) data.length;
		int i=0;
		while(i<data.length){
			segment[i + 1] = data[i];
			i++;
		}


//		copy data into segment from index 1
//		for (int i = 0; i < 127; i++) {
//			segment[i + 1] = data[i];
//		}
//		segment = Arrays.copyOfRange(data,0,127);


//		if (true)
//			throw new UnsupportedOperationException(TODO.method());

		// TODO - END
		return segment;

	}

	public static Message decapsulate(byte[] segment) {

		Message message=null;
		byte[] temp=new byte[segment[0]];
		
//		 TODO - START
		// decapsulate segment and put received payload data into a message
//		byte[] seg=segment;

		for(int i=0;i<segment[0];i++){
			temp[i]=segment[i+1];
		}
//		while(segment[i]!=null){
//			temp[i-1]=segment[i];
//			i++;
//		}
		message = new Message(temp);
//		take byte[] segment as param
//		from index 1, copy into message
//		message.setData(Arrays.copyOfRange(segment, 1,127));
//		wrong, copies whole array instead of just payload

//		if (true)
//			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		
		return message;
		
	}
	
}
