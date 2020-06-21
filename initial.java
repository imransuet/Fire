package AI_Project;

import java.util.Random;

public class initial {
	int x;
	int y;
	int getrendom() {
		Random r = new Random();
		x= r.nextInt(7-3) + 3;
		y= r.nextInt(7-3) + 3;
		x= x*10+y;
		return x;
		
	}

}
