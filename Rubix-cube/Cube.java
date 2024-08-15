import java.util.ArrayList;

public class Cube{
  
  private int [][] cube;
  private final WhiteCross whiteCross;
  private final WhiteCorners whiteCorners;

  public static final String TEXT_RED = "\u001B[31m";
  public static final String TEXT_GREEN = "\u001B[32m";
  public static final String TEXT_YELLOW = "\u001B[93m";
  public static final String TEXT_ORANGE = "\u001B[38;5;208m";
  public static final String TEXT_BLUE = "\u001B[34m";
  public static final String TEXT_PURPLE = "\u001B[35m";
  public static final String TEXT_WHITE = "\u001B[37m";
  public static final String TEXT_RESET = "\u001B[0m";

  public Cube(){ // 1 = white, 2 = yellow, 3 = orange, 4 = green, 5 = blue, 6 = red
    int[][] tempcube = {{1,1,1},{1,1,1},{1,1,1},
{6,6,6},{6,6,6},{6,6,6}, {5,5,5},{5,5,5},{5,5,5}, {3,3,3},{3,3,3},{3,3,3},
                         {2,2,2},{2,2,2},{2,2,2},
                         {4,4,4},{4,4,4},{4,4,4}};
    cube = tempcube;
    whiteCross = new WhiteCross(cube);
    whiteCorners = new WhiteCorners(cube);
  }

  public int [][] getCubeArray() {
    return cube;
  }

  public ArrayList<String> solve() {
    cube = whiteCross.solveWhiteCross(cube);
    return SolveHelper.getMoveLog();
  }

  public void tester() {
    cube = whiteCorners.solveWhiteCorners(cube);
  }

  public void randomize() { 
    for(int i = 0; i < 250; i++) {
      int x = (int)(Math.random() * 17) + 1;
      if(x == 1)
        cube = Move.up(cube, 1);
      else if(x == 2)
        cube = Move.up(cube, 2);
      else if(x == 3)
        cube = Move.up(cube, 3);
      else if(x == 4)
        cube = Move.left(cube, 1);
      else if(x == 5)
        cube = Move.left(cube, 2);
      else if(x == 6)
        cube = Move.left(cube, 3);
      else if(x == 7)
        cube = Move.right(cube,1);
      else if(x == 8)
        cube = Move.right(cube,2);
      else if(x == 9)
        cube = Move.right(cube,3);
      else if(x == 10)
        cube = Move.down(cube,1);
      else if(x == 11)
        cube = Move.down(cube,2);
      else if(x == 12)
        cube = Move.down(cube,3);
      else if(x == 13)
        cube = Move.FaceTurnLeft(cube, 1);
      else if(x == 14)
        cube = Move.FaceTurnLeft(cube, 2);
      else if(x == 15)
        cube = Move.FaceTurnLeft(cube, 3);
      else if(x == 16)
        cube = Move.FaceTurnRight(cube, 1);
      else if(x == 17)
        cube = Move.FaceTurnRight(cube, 2);
      else
        cube = Move.FaceTurnRight(cube, 3);
      
    }
  }

  public boolean isWin() { //First 3
    for(int i = 0; i < 3; i++) {
      for(int j = 1; j < cube[0].length; j++) {
        if(cube[i][j] != cube[i][j-1])
          return false;
      }
      if(cube[0][0] != cube[1][0] || cube[1][0] != cube[2][0])
        return false;
    }

    for(int i = 3; i < 6; i++) { //Next 3
      for(int j = 1; j < cube[0].length; j++) {
        if(cube[i][j] != cube[i][j-1])
          return false;
      }
      if(cube[3][0] != cube[4][0] || cube[4][0] != cube[5][0])
        return false;
    }

    for(int i = 6; i < 9; i++) { //Next 3
      for(int j = 1; j < cube[0].length; j++) {
        if(cube[i][j] != cube[i][j-1])
          return false;
      }
      if(cube[6][0] != cube[7][0] || cube[7][0] != cube[8][0])
        return false;
    }

    for(int i = 9; i < 12; i++) { //Next 3
      for(int j = 1; j < cube[0].length; j++) {
        if(cube[i][j] != cube[i][j-1])
          return false;
      }
      if(cube[9][0] != cube[10][0] || cube[10][0] != cube[11][0])
        return false;
    }

    for(int i = 12; i < 15; i++) { //Next 3
      for(int j = 1; j < cube[0].length; j++) {
        if(cube[i][j] != cube[i][j-1])
          return false;
      }
      if(cube[12][0] != cube[13][0] || cube[13][0] != cube[14][0])
        return false;
    }

    for(int i = 15; i < 18; i++) { //Last 3
      for(int j = 1; j < cube[0].length; j++) {
        if(cube[i][j] != cube[i][j-1])
          return false;
      }
      if(cube[15][0] != cube[16][0] || cube[16][0] != cube[17][0])
        return false;
    }
    return true;
  }

  public String GetColor(int i, int j) {
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

  public String toString() {
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

  public void R() {Move.up(cube,3);}
  public void M() {Move.up(cube,2);}
  public void L() {Move.up(cube,1);}
  public void RPrime() {Move.down(cube,3);}
  public void MPrime() {Move.down(cube,2);}
  public void LPrime() {Move.down(cube,1);}
  public void U() {Move.left(cube,1);}
  public void EPrime() {Move.left(cube,2);}
  public void DPrime() {Move.left(cube,3);}
  public void UPrime() {Move.right(cube,1);}
  public void E() {Move.right(cube,2);}
  public void D() {Move.right(cube,3);}
  public void FPrime() {Move.FaceTurnLeft(cube,1);}
  public void SPrime() {Move.FaceTurnLeft(cube,2);}
  public void B() {Move.FaceTurnLeft(cube,3);}
  public void F() {Move.FaceTurnRight(cube,1);}
  public void S() {Move.FaceTurnRight(cube,2);}
  public void BPrime() {Move.FaceTurnRight(cube,3);}
  public void CubeTurnLeft() {Move.changeViewLeft(cube);}
  public void CubeTurnRight() {Move.changeViewRight(cube);}
  public void CubeTurnUp() {Move.changeViewUp(cube);}
  public void CubeTurnDown() {Move.changeViewDown(cube);}
  public void CubeRotateRight() {Move.CubeRotateRight(cube);}
  public void CubeRotateLeft() {Move.CubeRotateLeft(cube);}
}