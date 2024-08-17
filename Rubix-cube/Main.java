import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    final String TEXT_PURPLE = "\u001B[35m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_RED = "\u001B[31m";
    final String TEXT_RESET = "\u001B[0m";
    
    Scanner in = new Scanner(System.in);
    Cube C = new Cube();

    System.out.println("Enter \"E\" to enter your own cube or enter to generate a cube");
    String input = in.nextLine();
    input = input.replaceAll("\\s+","").toUpperCase();
    if(input.equals("E")) {
      System.out.println(EnterCube.enteredCube());
      //C.setCubeArray();
    }
    System.out.println(C);
    Boolean x = true;
    int moveCount = 0;
    while(true) {
      x = true;
      System.out.println("Total Manual Moves: " + moveCount);
      System.out.println("Please Enter a Move! (type \"end\" to end the program)");
      String move = in.nextLine();
      moveCount++;
      move = move.toUpperCase();
      //Manual Moves
      if(move.equals("L")) {C.L();}
      else if(move.equals("M")) {C.M();}
      else if(move.equals("R")) {C.R();}
      else if(move.equals("R'")) {C.RPrime();}
      else if(move.equals("M'")) {C.MPrime();}
      else if(move.equals("L'")) {C.LPrime();}
      else if(move.equals("U")) {C.U();}
      else if(move.equals("E")) {C.E();}
      else if(move.equals("D")) {C.D();}
      else if(move.equals("U'")) {C.UPrime();}
      else if(move.equals("E'")) {C.EPrime();}
      else if(move.equals("D'")) {C.DPrime();}
      else if(move.equals("B")) {C.B();}
      else if(move.equals("F")) {C.F();}
      else if(move.equals("S")) {C.S();}
      else if(move.equals("B'")) {C.BPrime();}
      else if(move.equals("F'")) {C.FPrime();}
      else if(move.equals("S'")) {C.SPrime();}
      else if(move.equals("Y")) {C.Y();}
      else if(move.equals("Y'")) {C.YPrime();}
      else if(move.equals("X'")) {C.XPrime();}
      else if(move.equals("X")) {C.X();}
      else if(move.equals("Z")) {C.Z();}
      else if(move.equals("Z'")) {C.ZPrime();}

      //Solve and Major Edit Controls
      else if(move.equals("RAND")) {
        C.randomize();
        moveCount--;
      }
      else if(move.equals("SOLVE")) {
        moveCount--;
        C.resetMoveLists();
        System.out.println("\n\n" + TEXT_RED + "White Cross Moves: " + TEXT_BLUE + C.formatPrint(C.solveWhiteCross()) + TEXT_RESET);
        System.out.println(C);
        System.out.println(TEXT_RED + "White Corners Moves: " + TEXT_BLUE + C.formatPrint(C.solveWhiteCorners()) + TEXT_RESET);
        System.out.println(C);
        System.out.println(TEXT_RED + "Second Layer Moves: " + TEXT_BLUE + C.formatPrint(C.solveSecondLayer()) + TEXT_RESET);
        System.out.println(C);
        System.out.println(TEXT_RED + "Yellow Cross Moves: " + TEXT_BLUE + C.formatPrint(C.solveYellowCross()) + TEXT_RESET);
        System.out.println(C);
        System.out.println(TEXT_RED + "Yellow Side Moves: " + TEXT_BLUE + C.formatPrint(C.solveYellowSide()) + TEXT_RESET);
        System.out.println(C);
        System.out.println(TEXT_RED + "Final Corners Moves: " + TEXT_BLUE + C.formatPrint(C.solveLastLayerCorners()) + TEXT_RESET);
        System.out.println(C);
        System.out.println(TEXT_RED + "Final Edges Moves: " + TEXT_BLUE + C.formatPrint(C.solveLastLayerEdges()) + TEXT_RESET);
        System.out.println(C);
        ArrayList<String> moveList = C.getMasterMoveList();
        System.out.println("\n" + TEXT_RED + "All Moves Used: " + TEXT_GREEN + C.formatPrint(moveList) + TEXT_RESET);
        System.out.println(TEXT_RED + "Total number of moves used to solve: " + TEXT_GREEN + moveList.size() + TEXT_RESET + "\n");
      }

      //Misc Controls
      else if(move.equals("TEST")) {
        moveCount--;
      }
      else if(move.equals("END")) {
        moveCount--;
        System.out.println("Ending the Program! (Total manual Moves: " + moveCount + ")");
        in.close();
        System.exit(0);
      }
      else {
        System.out.println("Invalid Move");
        moveCount--;
        x = false;
      }
      System.out.println(C);
      if(Cube.isWin() && x == true) {
        System.out.println(TEXT_PURPLE + "Good job! You solved the cube!" + TEXT_RESET);
      }
    }
  }
}