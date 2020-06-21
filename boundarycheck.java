package AI_Project;

public class boundarycheck {

	
	
	int checkBoundary(int vx,int vy) {
		
		int boundary = 0;
		for (int i = 0; i <= 9; i++) {
			if (vx == 0 && vy == i || vx == i && vy == 0 || vx == 9 && vy == i
					|| vx == i && vy == 9) {
				boundary = 1;
			}
		}
		return boundary;
	}
}
