import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    final String TEXT_PURPLE = "\u001B[35m";
    final String TEXT_RESET = "\u001B[0m";
    Cube C = new Cube();
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
      else if(move.equals("RPRIME"))
        C.RPrime();
      else if(move.equals("MPRIME"))
        C.MPrime();
      else if(move.equals("LPRIME"))
        C.LPrime();
      else if(move.equals("U"))
        C.U();
      else if(move.equals("E"))
        C.E();
      else if(move.equals("D"))
        C.D();
      else if(move.equals("UPRIME"))
        C.UPrime();
      else if(move.equals("EPRIME"))
        C.EPrime();
      else if(move.equals("DPRIME"))
        C.DPrime();
      else if(move.equals("B"))
        C.B();        
      else if(move.equals("F"))
        C.F();
      else if(move.equals("S"))
        C.S();
      else if(move.equals("BPRIME"))
        C.BPrime();
      else if(move.equals("FPRIME"))
        C.FPrime();
      else if(move.equals("SPRIME"))
        C.SPrime();
      else if(move.equals("CHANGEVIEWLEFT"))
        C.CubeTurnRight();
      else if(move.equals("CHANGEVIEWRIGHT"))
        C.CubeTurnRight();
      else if(move.equals("CHANGEVIEWDOWN"))
        C.CubeTurnDown();
      else if(move.equals("CHANGEVIEWUP"))
        C.CubeTurnUp();
      else if(move.equals("RANDOMIZE"))
        C.randomize();
      else if(move.equals("SOLVE"))
        C.solve();
      else if(move.equals("PRINT")) {
        System.out.println(Solve.getMoveLog());
      }
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