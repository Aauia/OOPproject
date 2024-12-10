package Main;

import java.io.IOException;

public class Tester {
	public static void main(String[] args) {
		try {
			(new Managing()).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
