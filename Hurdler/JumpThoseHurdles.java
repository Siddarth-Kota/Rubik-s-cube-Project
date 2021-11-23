import java.util.ArrayList;
import java.util.Collections;
import kareltherobot.*;

public class JumpThoseHurdles {
	// This is the Robot we will use to jump the hurdles
	Robot hurdler = new Robot(1,1,Directions.East, 0);
	
	public static void main(String[] args) {
		new JumpThoseHurdles().start();
	}
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
	public static final String RESET = "\033[0m";  // Text Reset


	public void start() {
		loadWorld();
		ArrayList <Double> horizontal = new ArrayList<>();
		ArrayList <Double> vertical = new ArrayList<>();
		while(hurdler.nextToABeeper() == false) {
			double h = findHurdle();
			double v = climbHurdle();
			clearHurdle();
			horizontal.add(h);
			vertical.add(v);

			if(hurdler.nextToABeeper() == true) {
				Double hmax = Collections.max(horizontal);
				Double vmax = Collections.max(vertical);
				Double hmin = Collections.min(horizontal);
				Double vmin = Collections.min(vertical);
				Double hsum = 0.0;
				Double vsum = 0.0;

				for(double hnum : horizontal) {
					hsum += hnum;
				}
				for(double vnum : vertical) {
					vsum += vnum;
				}

				double haverage = hsum/ horizontal.size();
				double vaverage = hsum/ vertical.size();
				System.out.println(GREEN_BOLD_BRIGHT + "The horizontal distances in this world are " + horizontal + RESET);
				System.out.println(GREEN_BOLD_BRIGHT + "The Vertical distances in this world are " + vertical + RESET);
				System.out.println(YELLOW_BOLD_BRIGHT + "The shortest distance between two hurdles is " + hmin + RESET);
				System.out.println(CYAN_BOLD_BRIGHT + "The shortest vertical distance in this world is " + vmin + RESET);
				System.out.println(CYAN_BOLD_BRIGHT + "The largest horizontal distance in this world is " + hmax + RESET);
				System.out.println(YELLOW_BOLD_BRIGHT + "The Highest hurdle in this world is " + vmax + RESET);
				System.out.println(PURPLE_BOLD_BRIGHT + "The sum of the horizontal distances in this world are " + hsum + RESET);
				System.out.println(PURPLE_BOLD_BRIGHT + "The sum of the vertical distances in this world are " + vsum + RESET);
				System.out.println(RED_BOLD_BRIGHT + "The average horizontal distance in this world are " + haverage + RESET);
				System.out.println(RED_BOLD_BRIGHT+ "The average vertical distance in this world are " + vaverage + RESET);
				break;
			}
		}
	}
	public void TurnRight() {
		hurdler.turnLeft();
		hurdler.turnLeft();
		hurdler.turnLeft();
	}
		

	/**
	 * This method assumes the Robot is named hurdler and is facing East
	 * This moves hurdler to the next wall (hurdle). It returns the number
	 * of moves it took to get to the hurdle
	 */
	private int findHurdle() {
		int frontdistance = 0;
		while(hurdler.frontIsClear() == true) {
			hurdler.move();
			frontdistance++;
		}		
		return frontdistance;
	}
	/**
	 * This method assumes the Robot is named hurdler, is facing East and
	 * is at the base of the hurdle. 
	 * This moves the Robot to the top of the hurdle so that it can clear
	 * the wall.  
	 * @return The number of steps to get above the hurdle (height)
	 */
	int updistance = 0;
	private int climbHurdle() {
		while(!hurdler.frontIsClear()) {
			hurdler.turnLeft();
			hurdler.move();
			TurnRight();
			updistance++;

		}
		return updistance;
	}
	/** 
	 * Moves the Robot (hurdler) over the wall and moves it to the ground so 
	 * that the Robot has its back to the hurdle and is facing the next one.
	 */
	private void clearHurdle() {
		hurdler.move();
		TurnRight();
		while(updistance != 0 ) {
			hurdler.move();
			updistance--;
		}
		hurdler.turnLeft();
	}

	private void loadWorld() {
		// line below "hardcodes" this to use one specific world
		// it would be better to ask the user...
		String worldName = "worldb.wld";
		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);

	}

}
