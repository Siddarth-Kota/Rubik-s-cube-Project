import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    final String TEXT_PURPLE = "\u001B[35m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_RESET = "\u001B[0m";
    

    Cube C = new Cube();
    ArrayList<String> moveLog = new ArrayList<String>();
    

    Scanner in = new Scanner(System.in);
    System.out.println(C);
    Boolean Win = false, x = true;
    while(!Win) {
      System.out.println("Please Enter a Move!");
      String move = in.nextLine();
      move = move.toUpperCase();
      if(move.equals("L"))
        C.L();
      else if(move.equals("M"))
        C.M();
      else if(move.equals("R"))
        C.R();
      else if(move.equals("R'"))
        C.RPrime();
      else if(move.equals("M'"))
        C.MPrime();
      else if(move.equals("L'"))
        C.LPrime();
      else if(move.equals("U"))
        C.U();
      else if(move.equals("E"))
        C.E();
      else if(move.equals("D"))
        C.D();
      else if(move.equals("U'"))
        C.UPrime();
      else if(move.equals("E'"))
        C.EPrime();
      else if(move.equals("D'"))
        C.DPrime();
      else if(move.equals("B"))
        C.B();        
      else if(move.equals("F"))
        C.F();
      else if(move.equals("S"))
        C.S();
      else if(move.equals("B'"))
        C.BPrime();
      else if(move.equals("F'"))
        C.FPrime();
      else if(move.equals("S'"))
        C.SPrime();
      else if(move.equals("CUBE TURN LEFT"))
        C.CubeTurnLeft();
      else if(move.equals("CUBE TURN RIGHT"))
        C.CubeTurnRight();
      else if(move.equals("CUBE TURN DOWN"))
        C.CubeTurnDown();
      else if(move.equals("CUBE TURN UP"))
        C.CubeTurnUp();
      else if(move.equals("ROTATE RIGHT"))
        C.CubeRotateRight();
      else if(move.equals("ROTATE LEFT"))
        C.CubeRotateLeft();
      else if(move.equals("RAND"))
        C.randomize();
      else if(move.equals("SOLVE")) {
        System.out.println(TEXT_BLUE + C.solveWhiteCross() + TEXT_RESET);
        System.out.println(C);
        System.out.println(TEXT_BLUE + C.solveWhiteCorners() + TEXT_RESET);
        System.out.println(C);
        System.out.println("\n" + TEXT_GREEN + C.getMasterMoveList() + TEXT_RESET + "\n");
      }
      else if(move.equals("TEST")) {
      }
      else if(move.equals("PRINT"))
        System.out.println(moveLog);
      else if(move.equals("END")) {
        System.out.println("Ending the Program!");
        in.close();
        System.exit(0);
      }
      else {
        System.out.println("Invalid Move -.-");
        x = false;
      }
      System.out.println(C);
      if(x) {
        Win = C.isWin();
        x = true;
      }
    }
    System.out.println(TEXT_PURPLE + "Good job! You solved the cube!" + TEXT_RESET);
    in.close();
  }
}