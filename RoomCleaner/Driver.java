import kareltherobot.*;
import javax.swing.*;

public class Driver implements Directions {
	Robot roomba;
	// declared here so it is visible in all the methods!!
	// It will be assigned a value in the getInfo method
	public static final String CYAN_BOLD_BRIGHT = "\033[1;96m"; // CYAN
	public static final String RESET = "\033[0m"; // Text Reset

	// You will add very many variables!!

	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();
		d.getInfo();
		d.cleanRoom();
		d.displayResults();
	}

	public void TurnRight() {
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();
	}

	public void Turn180() {
		roomba.turnLeft();
		roomba.turnLeft();
	}

	/**
	 * This method gets info from the user in the following order: 1. Ask the user
	 * which world file they wish to process. Right now, that world file name is
	 * hardcoded in. 2. Ask the user for the starting location and direction of the
	 * Robot. A new Robot should be constructed and assigned to the global
	 * (instance) variable named roomba that is declared on line 10.
	 * 
	 * An inelegant way to interact with the user is via the console, using
	 * System.out.println and a Scanner that scans System.in (input from the
	 * console). A more elegant way to get user input might include using a
	 * JOptionPane.
	 */
	private void getInfo() {
		String wrldName;
		Object[] Worldselection = { "Basic Room", "Advanced Room" };
		String initialSelection = "Basic Room";
		Object selection = JOptionPane.showInputDialog(null, "Which world would you like to use?", "World Selection",
				JOptionPane.QUESTION_MESSAGE, null, Worldselection, initialSelection);
		String selectionStr = selection.toString();
		selectionStr = Character.toLowerCase(selectionStr.charAt(0)) + selectionStr.substring(1);
		wrldName = selectionStr.replaceAll("\\s", "") + ".wld";
		System.out.println(wrldName);
		JFrame frame = new JFrame("Robot positioning");
		int result = JOptionPane.showConfirmDialog(null, "Do you want to start the program?");
		switch (result) {
			case JOptionPane.YES_OPTION:
				System.out.println("Yes");
				break;
			case JOptionPane.NO_OPTION:
				System.out.println("No");
				break;
			case JOptionPane.CANCEL_OPTION:
				System.out.println("Cancel");
				break;
			case JOptionPane.CLOSED_OPTION:
				System.out.println("Closed");
				break;
		}

		JTextField xcordField = new JTextField();
		JTextField ycordField = new JTextField();
		String message = "What x Cordinate and Y cordinate should we start at (x first then y) (basic = 11,6)(advanced = 100,4)";
		result = JOptionPane.showOptionDialog(frame, new Object[] { message, xcordField, ycordField },
				"Run roomba", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		int x = Integer.parseInt(xcordField.getText());
		int y = Integer.parseInt(ycordField.getText());
		roomba = new Robot(x, y, Directions.East, 0);
		World.readWorld(wrldName);
		World.setVisible(true);
		World.setDelay(0);

	}

	/**
	 * This method will have all the logic that takes the Robot to every location
	 * and cleans up all piles of beepers. Think about ways you can break this
	 * large, complex task into smaller, easier to solve problems.
	 */
	int beepnum;
	int maxbeep = -1;
	int hordist = 0;
	int verdist = 0;
	int hordistmax;
	int verdistmax;
	double area;
	double numbeep;
	int totbeep;

	private void cleanRoom() {
		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		while (roomba.frontIsClear()) {
			if (roomba.nextToABeeper()) {
				numbeep++;
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
					beepnum++;
					totbeep++;
					if (beepnum >= maxbeep) {
						maxbeep = beepnum;
						hordistmax = hordist;
						verdistmax = verdist;
					}
				}
			}
			roomba.move();
			area++;
			hordist++;
			if (roomba.nextToABeeper()) {
				numbeep++;
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
					beepnum++;
					totbeep++;
					if (beepnum >= maxbeep) {
						maxbeep = beepnum;
						hordistmax = hordist;
						verdistmax = verdist;
					}
				}
			}
			beepnum = 0;
			if (!roomba.frontIsClear()) {
				Turn180();
				while (roomba.frontIsClear()) {
					roomba.move();
					hordist--;
				}
				roomba.turnLeft();
				if(!roomba.frontIsClear()) {
					break;
				}
				roomba.move();
				verdist++;
				roomba.turnLeft();
			}
		}
	}
	// obviously, lots more here

	/**
	 * This method displays the results of cleaning the room. All of the info in the
	 * pdf that describes the problem need to be displayed. You can present this
	 * info in the console (boring) or you can present using JOptionPane (cool!)
	 */
	private void displayResults() {

		double avepile = Math.round(totbeep / numbeep);
		double dirpile = Math.round((numbeep / area) * 10000);
		System.out.println(CYAN_BOLD_BRIGHT + "The area of the room " + area + RESET);
		System.out.println(CYAN_BOLD_BRIGHT + "The number of piles is " + numbeep + RESET);
		System.out.println(CYAN_BOLD_BRIGHT + "The total amount of beepers is " + totbeep + RESET);
		System.out.println(CYAN_BOLD_BRIGHT + "The biggest pile was " + maxbeep + RESET);
		System.out.println(CYAN_BOLD_BRIGHT + "The biggest pile is " + verdistmax + " units down from start" + RESET);
		System.out.println(CYAN_BOLD_BRIGHT + "The biggest pile is " + hordistmax + " to the right from start" + RESET);
		System.out.println(CYAN_BOLD_BRIGHT + "The average pile size is " + avepile + RESET);
		System.out.println(CYAN_BOLD_BRIGHT + "The percent dirty is " + dirpile / 100 + "%" + RESET);
	}

}
