package zama.training.standalone;

import java.util.Date;

public class App {
	private static Integer counter = 0;
	
	public static void main(String[] args) throws InterruptedException {
		String javaVersion = "65_Rakesh - Java version: "+System.getProperty("java.version")+": ";
	
		while(true){
			System.out.println(javaVersion + new Date() +" - Event: "+counter );
			counter++;
			Thread.sleep(3000);
		}
	}

}
