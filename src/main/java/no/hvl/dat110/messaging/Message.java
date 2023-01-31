package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;
//	private int payLoadIndex;

	// construction a Message with the data provided
	public Message(byte[] data) {

		// TODO - START
//		check if data is not null and not longer than 127 bytes
		if (data != null && data.length <= 127) {

//			this.payLoadIndex= data.length;

//			copying data into this.data
//			this.data = Arrays.copyOf(data,data.length);
			this.data = data;



//			makes this.data into a fixed byte array with length 127
//			this.data = new byte[127];
//			copying data into this.data, leaving padding empty
//			int i = 0;
//			while (i < data.length) {
//				this.data[i] = data[i];
//				i++;
//			}
		}
//		else{
//			throw new IllegalArgumentException("data null or too long");
//		}
//		 TODO - END

	}

	public byte[] getData() {
		return this.data; 
	}

	public void setData(byte[] data) {
		this.data = data;
	}
//	public byte getPayloadIndex(){
//		return (byte) this.payLoadIndex;
//	}
}
