package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCClientStopStub;

public class Controller  {
	
	private static int N = 5;
	
	public static void main (String[] args) throws InterruptedException {
		
		DisplayStub display;
		SensorStub sensor;
		
		RPCClient displayclient,sensorclient;
		
		System.out.println("Controller starting ...");
				
		// create RPC clients for the system
		displayclient = new RPCClient(Common.DISPLAYHOST,Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST,Common.SENSORPORT);
		
		// setup stop methods in the RPC middleware
		RPCClientStopStub stopdisplay = new RPCClientStopStub(displayclient);
		RPCClientStopStub stopsensor = new RPCClientStopStub(sensorclient);
				
		// TODO - START
		sensorclient.connect();
		displayclient.connect();
		// create local display and sensor stub objects
		sensor = new SensorStub(sensorclient);
		display = new DisplayStub(displayclient);

		// connect to sensor and display RPC servers


		// read value from sensor using RPC and write to display using RPC
//		use a int read() RPC call on the sensor
//		String temp = Integer.toString(sensor.read());

//		use a void write(String str) RPC call on the display to show current temp
//		display.write(temp);

		for (int i=0;i<N;i++){
			Thread.sleep(1000);
			display.write("" + sensor.read());
		}
		
		// TODO - END
		
		stopdisplay.stop();
		stopsensor.stop();
	
		displayclient.disconnect();
		sensorclient.disconnect();
		
		System.out.println("Controller stopping ...");
		
	}
}
