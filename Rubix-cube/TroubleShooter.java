public class TroubleShooter {
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";
    private static final String TEXT_YELLOW = "\u001B[93m";
    private static final String TEXT_ORANGE = "\u001B[38;5;208m";
    private static final String TEXT_BLUE = "\u001B[34m";
    private static final String TEXT_WHITE = "\u001B[37m";
    private static final String TEXT_RESET = "\u001B[0m";

    public static int[][] cube;

    public static String GetColor(int i, int j) {
        String ans = "";
        if(cube[i][j] == 1) {
          ans += TEXT_WHITE + "■ " + TEXT_RESET;
          return ans;
        }
        else if(cube[i][j] == 2) {
          ans += TEXT_YELLOW + "■ " + TEXT_RESET;
          return ans;
        }
        else if(cube[i][j] == 3) {
          ans += TEXT_ORANGE + "■ " + TEXT_RESET;
          return ans;
        }
        else if(cube[i][j] == 4) {
          ans += TEXT_GREEN + "■ " + TEXT_RESET;
          return ans;
        }
        else if(cube[i][j] == 5) {
          ans += TEXT_BLUE + "■ " + TEXT_RESET;
          return ans;
        }
        else if(cube[i][j] == 6) {
          ans += TEXT_RED + "■ " + TEXT_RESET;
          return ans;
        }
        return "END PROGRAM!!!!!";
      }
    
    public static String tempPrint(int[][] arr) {
        cube = arr;
        return "      " + GetColor(0,0) + GetColor(0,1) + GetColor(0,2) + "\n" +
               "      " + GetColor(1,0) + GetColor(1,1) + GetColor(1,2) + "\n" +
               "      " + GetColor(2,0) + GetColor(2,1) + GetColor(2,2) + "\n" +
               GetColor(3,0) + GetColor(3,1) + GetColor(3,2)  + GetColor(6,0) + GetColor(6,1) + GetColor(6,2) + GetColor(9,0) + GetColor(9,1) + GetColor(9,2) + "\n" +
               GetColor(4,0) + GetColor(4,1) + GetColor(4,2)  + GetColor(7,0) + GetColor(7,1) + GetColor(7,2) + GetColor(10,0) + GetColor(10,1) + GetColor(10,2) + "\n" +
               GetColor(5,0) + GetColor(5,1) + GetColor(5,2)  + GetColor(8,0) + GetColor(8,1) + GetColor(8,2) + GetColor(11,0) + GetColor(11,1) + GetColor(11,2) + "\n" +
               "      " + GetColor(12,0) + GetColor(12,1) + GetColor(12,2) + "\n" +
               "      " + GetColor(13,0) + GetColor(13,1) + GetColor(13,2) + "\n" +
               "      " + GetColor(14,0) + GetColor(14,1) + GetColor(14,2) + "\n" +
               "      " + GetColor(15,0) + GetColor(15,1) + GetColor(15,2) + "\n" +
               "      " + GetColor(16,0) + GetColor(16,1) + GetColor(16,2) + "\n" +
               "      " + GetColor(17,0) + GetColor(17,1) + GetColor(17,2) + "\n" + "\n";
    }
}
