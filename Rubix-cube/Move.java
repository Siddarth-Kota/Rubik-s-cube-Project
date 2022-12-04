public class Move{  
  public static int[][] up(int[][] arr, int col) { // column is user input
    col--;
    //top
    int temp = arr[0][col];
    arr[0][col] = arr[6][col];
    arr[6][col] = arr[12][col];
    arr[12][col] = arr[15][col];
    arr[15][col] = temp;
    //mid
    temp = arr[1][col];
    arr[1][col] = arr[7][col];
    arr[7][col] = arr[13][col];
    arr[13][col] = arr[16][col];
    arr[16][col] = temp;   
    
    //bottom
    temp = arr[2][col];
    arr[2][col] = arr[8][col];
    arr[8][col] = arr[14][col];
    arr[14][col] = arr[17][col];
    arr[17][col] = temp;

    if(col == 2) {
      temp = arr[11][2];
      arr[11][2] = arr[9][2];
      arr[9][2] = arr[9][0];
      arr[9][0] = arr[11][0];
      arr[11][0] = temp;
      temp = arr[10][2];
      arr[10][2] = arr[9][1];
      arr[9][1] = arr[10][0];
      arr[10][0] = arr[11][1];
      arr[11][1] = temp;
    } else if (col == 0) {
      temp = arr[3][2];
      arr[3][2] = arr[5][2];
      arr[5][2] = arr[5][0];
      arr[5][0] = arr[3][0];
      arr[3][0] = temp;
      temp = arr[3][1];
      arr[3][1] = arr[4][2];
      arr[4][2] = arr[5][1];
      arr[5][1] = arr[4][0];
      arr[4][0] = temp;
    }
    return arr;
  } 

  public static int[][] down(int[][] arr, int col) {
    arr = up(arr, col);
    arr = up(arr, col);
    arr = up(arr, col);
    return arr;
  }

  public static int[][] left(int[][] arr, int row) {
    row--;
    
    int temp = arr[6+row][0];
    arr[6+row][0] = arr[9+row][0];
    arr[9+row][0] = arr[17-row][2];
    arr[17-row][2] = arr[3+row][0];
    arr[3+row][0] = temp;

    temp = arr[6+row][1];
    arr[6+row][1] = arr[9+row][1];
    arr[9+row][1] = arr[17-row][1];
    arr[17-row][1] = arr[3+row][1];
    arr[3+row][1] = temp;

    temp = arr[6+row][2];
    arr[6+row][2] = arr[9+row][2];
    arr[9+row][2] = arr[17-row][0];
    arr[17-row][0] = arr[3+row][2];
    arr[3+row][2] = temp;
//everything below this has been switched
    if(row == 0) {
      temp = arr[0][2];
      arr[0][2] = arr[0][0];
      arr[0][0] = arr[2][0];
      arr[2][0] = arr[2][2];
      arr[2][2] = temp;
      temp = arr[0][1];
      arr[0][1] = arr[1][0];
      arr[1][0] = arr[2][1];
      arr[2][1] = arr[1][2];
      arr[1][2] = temp;
    } else if (row == 2) {
      temp = arr[12][2];
      arr[12][2] = arr[14][2];
      arr[14][2] = arr[14][0];
      arr[14][0] = arr[12][0];
      arr[12][0] = temp;
      temp = arr[12][1];
      arr[12][1] = arr[13][2];
      arr[13][2] = arr[14][1];
      arr[14][1] = arr[13][0];
      arr[13][0] = temp;
    }
    return arr;
  }

  public static int[][] right(int[][] arr, int row) {
    arr = left(arr, row);
    arr = left(arr, row);
    arr = left(arr, row);
    return arr;
  }

  public static int[][] changeViewUp(int[][] arr) {
    arr = up(arr, 1);
    arr = up(arr, 2);
    arr = up(arr, 3);
    return arr;
  }

  public static int[][] changeViewDown(int[][] arr) {
    arr = down(arr, 1);
    arr = down(arr, 2);
    arr = down(arr, 3);
    return arr;
  }

  public static int[][] changeViewLeft(int[][] arr) {
    arr = left(arr, 1);
    arr = left(arr, 2);
    arr = left(arr, 3);
    return arr;
  }

  public static int[][] changeViewRight(int[][] arr) {
    arr = right(arr, 1);
    arr = right(arr, 2);
    arr = right(arr, 3);
    return arr;
  }

  public static int[][] FaceTurnLeft(int[][] arr, int col) {
    arr = changeViewLeft(arr);
    arr = up(arr, col);
    arr = changeViewRight(arr);
    return arr;
  }

  public static int[][] FaceTurnRight(int[][] arr, int col) {
    arr = changeViewLeft(arr);
    arr = down(arr, col);
    arr = changeViewRight(arr);
    return arr;
  }
}