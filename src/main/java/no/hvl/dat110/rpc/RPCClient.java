package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	// underlying messaging client used for RPC communication
	private MessagingClient msgclient;

	// underlying messaging connection used for RPC communication
	private MessageConnection connection;
	
	public RPCClient(String server, int port) {

		msgclient = new MessagingClient(server,port);
	}

//	establishing connection
	public void connect() {
//
		connection=msgclient.connect();

	}

//	closing connection
	public void disconnect() {
//
		connection.close();

	}

	/*
	 Make a remote call on the method on the RPC server by sending an RPC request message
	 and receive an RPC reply message rpcid is the identifier on the server side of the
	 method to be called param is the marshalled parameter of the method to be called
	 */
	public byte[] call(byte rpcid, byte[] param) {
//		The rpcid and param must be encapsulated according to the RPC message format
//		Sending on the connection a message with payload encapsulated in rpcid
		connection.send(new Message(RPCUtils.encapsulate(rpcid,param)));//sends a message

//		The return value from the RPC call must be decapsulated according to the RPC message format
//		Saving the received(and decapsulated) message in returnMsg
		Message returnMsg = connection.receive(); //receive also decapsulates

//		return RPCUtils.decapsulate(returnMsg.getData());
		return returnMsg.getData();


	}

}
