package edu.soft;

import java.io.*;

import lejos.nxt.*;
import lejos.nxt.comm.*;

public class ConectarBT {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 NXTConnection connection = null;
		 
		 LCD.drawString("waiting for BT", 0,1 );
         connection = Bluetooth.waitForConnection(0,NXTConnection.RAW);
 		 DataInputStream dataIn = connection.openDataInputStream();
 		 
 		 
 		 int command;
 		 
 		 
 		 
 		//try {
 				while (true) {
 					command=dataIn.readInt();
 					switch (command) {
 						case 1:
 							LCD.clear();
 							Motor.A.setSpeed(500);	
 							 Motor.A.forward();
 							LCD.drawString("Forward",0,1);
 							break;
 							
 						case 2: 
 							LCD.clear();
 	                        Motor.A.setSpeed(500);
 	                        Motor.A.backward();
 							LCD.drawString("backward",0,1);
 	                        break;

 						case 99:
 							break;
 						default:
 							Motor.A.stop();
 					}
 					if (command==99) break;
 		      		// System.out.println(dataIn.readInt());
 				}
 				dataIn.close();
 				Thread.sleep(100);
 				LCD.clear();
 				LCD.drawString("Closing...",0,0);
 				Thread.sleep(200);
 				LCD.refresh();
 				connection.close();
 				LCD.clear();
 			/*} catch (IOException e ) {
 				System.out.println(" write error "+e); 
 		    }*/
		 
	}

}
