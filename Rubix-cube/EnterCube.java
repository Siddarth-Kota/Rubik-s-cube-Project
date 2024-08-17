import java.util.Scanner;
public class EnterCube {

    private static int whiteCount = 0;
    private static int blueCount = 0;
    private static int redCount = 0;
    private static int orangeCount = 0;
    private static int greenCount = 0;
    private static int yellowCount = 0;

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
        Boolean complete = false;
        while(!complete) {
            result = new int[18][3];
            Scanner in = new Scanner(System.in);
            System.out.println(TEXT_CYAN + "Face the cube such that the " + TEXT_RESET + "WHITE" + TEXT_CYAN + " side is facing you and the " + TEXT_GREEN + "GREEN" + TEXT_CYAN + " side is on top" + TEXT_RESET);
            System.out.println(TEXT_CYAN + "Enter the color of each square starting left to right then up to down" + TEXT_RESET);
            System.out.println("1 = White, " + TEXT_YELLOW + "2 = Yellow, " + TEXT_ORANGE + "3 = Orange, " + "\n" + TEXT_GREEN + "4 = Green, " + TEXT_BLUE + "5 = Blue, " + TEXT_RED + "6 = Red, " + TEXT_RESET);
            for(int i  = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(TEXT_CYAN + "Enter tile: " + TEXT_RESET);
                    int input = in.nextInt();
                    result[i][j] = input;
                }
            }
            System.out.println(TEXT_CYAN + "Face the cube such that the " + TEXT_RED + "RED" + TEXT_CYAN + " side is facing you and the " + TEXT_RESET + "WHITE" + TEXT_CYAN + " side is on top" + TEXT_RESET);
            System.out.println(TEXT_CYAN + "Enter the color of each square starting left to right" + TEXT_RESET);
            System.out.println("1 = White, " + TEXT_YELLOW + "2 = Yellow, " + TEXT_ORANGE + "3 = Orange, " + "\n" + TEXT_GREEN + "4 = Green, " + TEXT_BLUE + "5 = Blue, " + TEXT_RED + "6 = Red, " + TEXT_RESET);
            for(int i  = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(TEXT_CYAN + "Enter tile: " + TEXT_RESET);
                    int input = in.nextInt();
                    result[i][j] = input;
                }
            }
            System.out.println(TEXT_CYAN + "Face the cube such that the " + TEXT_BLUE + "BLUE" + TEXT_CYAN + " side is facing you and the " + TEXT_RESET + "WHITE" + TEXT_CYAN + " side is on top" + TEXT_RESET);
            System.out.println(TEXT_CYAN + "Enter the color of each square starting left to right" + TEXT_RESET);
            System.out.println("1 = White, " + TEXT_YELLOW + "2 = Yellow, " + TEXT_ORANGE + "3 = Orange, " + "\n" + TEXT_GREEN + "4 = Green, " + TEXT_BLUE + "5 = Blue, " + TEXT_RED + "6 = Red, " + TEXT_RESET);
            for(int i  = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(TEXT_CYAN + "Enter tile: " + TEXT_RESET);
                    int input = in.nextInt();
                    result[i][j] = input;
                }
            }
            System.out.println(TEXT_CYAN + "Face the cube such that the " + TEXT_ORANGE + "ORANGE" + TEXT_CYAN + " side is facing you and the " + TEXT_RESET + "WHITE" + TEXT_CYAN + " side is on top" + TEXT_RESET);
            System.out.println(TEXT_CYAN + "Enter the color of each square starting left to right" + TEXT_RESET);
            System.out.println("1 = White, " + TEXT_YELLOW + "2 = Yellow, " + TEXT_ORANGE + "3 = Orange, " + "\n" + TEXT_GREEN + "4 = Green, " + TEXT_BLUE + "5 = Blue, " + TEXT_RED + "6 = Red, " + TEXT_RESET);
            for(int i  = 9; i < 12; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(TEXT_CYAN + "Enter tile: " + TEXT_RESET);
                    int input = in.nextInt();
                    result[i][j] = input;
                }
            }
            System.out.println(TEXT_CYAN + "Face the cube such that the " + TEXT_YELLOW + "YELLOW" + TEXT_CYAN + " side is facing you and the " + TEXT_BLUE + "BLUE" + TEXT_CYAN + " side is on top" + TEXT_RESET);
            System.out.println(TEXT_CYAN + "Enter the color of each square starting left to right" + TEXT_RESET);
            System.out.println("1 = White, " + TEXT_YELLOW + "2 = Yellow, " + TEXT_ORANGE + "3 = Orange, " + "\n" + TEXT_GREEN + "4 = Green, " + TEXT_BLUE + "5 = Blue, " + TEXT_RED + "6 = Red, " + TEXT_RESET);
            for(int i  = 12; i < 15; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(TEXT_CYAN + "Enter tile: " + TEXT_RESET);
                    int input = in.nextInt();
                    result[i][j] = input;
                }
            }
            System.out.println(TEXT_CYAN + "Face the cube such that the " + TEXT_GREEN + "GREEN" + TEXT_CYAN + " side is facing you and the " + TEXT_YELLOW + "YELLOW" + TEXT_CYAN + " side is on top" + TEXT_RESET);
            System.out.println(TEXT_CYAN + "Enter the color of each square starting left to right" + TEXT_RESET);
            System.out.println("1 = White, " + TEXT_YELLOW + "2 = Yellow, " + TEXT_ORANGE + "3 = Orange, " + "\n" + TEXT_GREEN + "4 = Green, " + TEXT_BLUE + "5 = Blue, " + TEXT_RED + "6 = Red, " + TEXT_RESET);
            for(int i  = 15; i < 18; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(TEXT_CYAN + "Enter tile: " + TEXT_RESET);
                    int input = in.nextInt();
                    result[i][j] = input;
                }
            }
            if(isCubeValid(result)) {
                complete = true;
                System.out.println(TEXT_CYAN + "Here is your entered cube: " + TEXT_RESET);
                System.out.println(TroubleShooter.tempPrint(result));
                System.out.println(TEXT_CYAN + "is this correct? (Y or N)" + TEXT_RESET);
                in.nextLine();
                String ans = in.nextLine();
                if(ans.equals("N")) {
                    complete = false;
                    System.out.println("Please Re-enter cube");
                }
                else {
                    System.out.println("Perfect! stating cube!\n\n");
                }
            }
            else {
                System.out.println("Sorry and invalid cube was entered, please try again. \n");
            }
        }
        return result;
    }

    public static boolean isCubeValid(int[][] cube) {
        for(int i = 0; i < 18; i++) {
            for(int j = 0; j < 3; j++) {
                if(cube[i][j] == 1) {whiteCount++;}
                else if(cube[i][j] == 2) {yellowCount++;}
                else if(cube[i][j] == 3) {orangeCount++;}
                else if(cube[i][j] == 4) {greenCount++;}
                else if(cube[i][j] == 5) {blueCount++;}
                else if(cube[i][j] == 6) {redCount++;}
            }
        }
        return (whiteCount == 9 || yellowCount == 9 || orangeCount == 9 || greenCount == 9 || blueCount == 9 || redCount == 9);
        
    }
}
