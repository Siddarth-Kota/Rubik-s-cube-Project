import java.util.Scanner;
public class EnterCube {

    public static final String TEXT_RED = "\u001B[31;1m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[93m";
    public static final String TEXT_ORANGE = "\u001B[38;5;208m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_CYAN = "\033[36m";
    public static final String TEXT_WHITE = "\u001B[37m";
    public static final String TEXT_RESET = "\u001B[0m";

    public static int[][] enteredCube() {
        int[][] result = new int[18][3];
        int whiteCount = 0, blueCount = 0, redCount = 0, orangeCount = 0, greenCount = 0, yellowCount = 0;
        Scanner in = new Scanner(System.in);
        System.out.println(TEXT_CYAN + "Face the cube such that the " + TEXT_BLUE + "BLUE" + TEXT_CYAN + " side is facing you and the " + TEXT_RESET + "WHITE" + TEXT_CYAN + " side is on top" + TEXT_RESET);
        System.out.println(TEXT_CYAN + "Enter the color of each square starting left to right" + TEXT_RESET);
        System.out.println("1 = White, " + TEXT_YELLOW + "2 = Yellow, " + TEXT_ORANGE + "3 = Orange, " + "\n" + TEXT_GREEN + "4 = Green, " + TEXT_BLUE + "5 = Blue, " + TEXT_RED + "6 = Red, " + TEXT_RESET);
        for(int i  = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(TEXT_CYAN + "Enter tile: ");
                String raw = in.nextLine();
                int input = Integer.valueOf(raw);
                result[i][j] = input;
            }
        }


        return result;
    }

}
