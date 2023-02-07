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
		
		byte[] returnval = null;
		
		// TODO - START



//		The rpcid and param must be encapsulated according to the RPC message format
//		returnval = RPCUtils.encapsulate(rpcid,param);

//		The return value from the RPC call must be decapsulated according to the RPC message format


				
		if (true)
			throw new UnsupportedOperationException(TODO.method());
		
		// TODO - END
		return returnval;
		
	}

}
