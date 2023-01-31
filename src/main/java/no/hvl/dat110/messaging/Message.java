package no.hvl.dat110.messaging;

import java.util.Arrays;


public class Message {

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;

	// constructor of Message with data as parameter
	public Message(byte[] data) {

//		check if data is not null and not longer than 127 bytes
		if (data != null && data.length <= 127) {
//			if yes, parameter data is saved as this.data
			this.data = data;

		}
	}

	public byte[] getData() {
		return this.data; 
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
