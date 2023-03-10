package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;

import static no.hvl.dat110.messaging.MessageUtils.SEGMENTSIZE;


public class MessageConnection {

	private DataOutputStream outStream; // for writing bytes to the underlying TCP connection
	private DataInputStream inStream; // for reading bytes from the underlying TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public MessageConnection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	// encapsulate the data contained in the Message and write to the output stream
	public void send(Message message) {

		byte[] data;

//		encapsulates the parameter Message and saves it in variable data
		data = MessageUtils.encapsulate(message);

//		send with using write on the outStream
		try{
			outStream.write(data);
		}
		catch(IOException ex){

		}

	}

	// read a segment from the input stream and decapsulate data into a Message
	public Message receive() {

		Message message = null;
		byte[] data = new byte[SEGMENTSIZE];

//		reading from inStream and decapsulating, returning the message
		try{
//			"read" reads from inStream to its parameter, here data
			inStream.readFully(data);

			message = MessageUtils.decapsulate(data);

		}
		catch(IOException ex){

		}

		return message;
		
	}

	// close the connection by closing streams and the underlying socket	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}