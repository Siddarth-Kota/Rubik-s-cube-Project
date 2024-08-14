import java.util.ArrayList;

public class Solve {
    private static ArrayList<String> moveLog = new ArrayList<String>();

    public static ArrayList<String> getMoveLog() {
        return moveLog;
    }

    public static int[][] R(int[][] cube) {
        moveLog.add("R");
        return Move.up(cube,3);
    }
    public static int[][] M(int[][] cube) {
        moveLog.add("M");
        return Move.up(cube,2);
    }
    public static int[][] L(int[][] cube) {
        moveLog.add("L");
        return Move.up(cube,1);
    }
    public static int[][] RPrime(int[][] cube) {
        moveLog.add("RPrime");
        return Move.down(cube,3);
    }
    public static int[][] MPrime(int[][] cube) {
        moveLog.add("MPrime");
        return Move.down(cube,2);
    }
    public static int[][] LPrime(int[][] cube) {
        moveLog.add("LPrime");
        return Move.down(cube,1);
    }
    public static int[][] U(int[][] cube) {
        moveLog.add("U");
        return Move.left(cube,1);
    }
    public static int[][] EPrime(int[][] cube) {
        moveLog.add("EPrime");
        return Move.left(cube,2);
    }
    public static int[][] DPrime(int[][] cube) {
        moveLog.add("DPrime");
        return Move.left(cube,3);
    }
    public static int[][] UPrime(int[][] cube) {
        moveLog.add("UPrime");
        return Move.right(cube,1);
    }
    public static int[][] E(int[][] cube) {
        moveLog.add("E");
        return Move.right(cube,2);
    }
    public static int[][] D(int[][] cube) {
        moveLog.add("D");
        return Move.right(cube,3);
    }
    public static int[][] FPrime(int[][] cube) {
        moveLog.add("FPrime");
        return Move.FaceTurnLeft(cube,1);
    }
    public static int[][] SPrime(int[][] cube) {
        moveLog.add("SPrime");
        return Move.FaceTurnLeft(cube,2);
    }
    public static int[][] B(int[][] cube) {
        moveLog.add("B");
        return Move.FaceTurnLeft(cube,3);
    }
    public static int[][] F(int[][] cube) {
        moveLog.add("F");
        return Move.FaceTurnRight(cube,1);
    }
    public static int[][] S(int[][] cube) {
        moveLog.add("S");
        return Move.FaceTurnRight(cube,2);
    }
    public static int[][] BPrime(int[][] cube) {
        moveLog.add("BPrime");
        return Move.FaceTurnRight(cube,3);
    }
    public static int[][] CubeTurnLeft(int[][] cube) {
        moveLog.add("CubeTurnLeft");
        return Move.changeViewLeft(cube);
    }
    public static int[][] CubeTurnRight(int[][] cube) {
        moveLog.add("CubeTurnRight");
        return Move.changeViewRight(cube);
    }
    public static int[][] CubeTurnUp(int[][] cube) {
        moveLog.add("CubeTurnUp");
        return Move.changeViewUp(cube);
    }
    public static int[][] CubeTurnDown(int[][] cube) {
        moveLog.add("CubeTurnDown");
        return Move.changeViewDown(cube);
    }
}
