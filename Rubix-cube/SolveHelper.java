import java.util.ArrayList;

public class SolveHelper {

    private static ArrayList<String> moveLog;

    public SolveHelper() {
        moveLog = new ArrayList<String>();
    }

    public static ArrayList<String> getMoveLog() {
        return moveLog;
    }

    public int[][] R(int[][] cube) {
        moveLog.add("R");
        return Move.up(cube,3);
    }
    public int[][] M(int[][] cube) {
        moveLog.add("M");
        return Move.up(cube,2);
    }
    public int[][] L(int[][] cube) {
        moveLog.add("L");
        return Move.up(cube,1);
    }
    public int[][] RPrime(int[][] cube) {
        moveLog.add("RPrime");
        return Move.down(cube,3);
    }
    public int[][] MPrime(int[][] cube) {
        moveLog.add("MPrime");
        return Move.down(cube,2);
    }
    public int[][] LPrime(int[][] cube) {
        moveLog.add("LPrime");
        return Move.down(cube,1);
    }
    public int[][] U(int[][] cube) {
        moveLog.add("U");
        return Move.left(cube,1);
    }
    public int[][] EPrime(int[][] cube) {
        moveLog.add("EPrime");
        return Move.left(cube,2);
    }
    public int[][] DPrime(int[][] cube) {
        moveLog.add("DPrime");
        return Move.left(cube,3);
    }
    public int[][] UPrime(int[][] cube) {
        moveLog.add("UPrime");
        return Move.right(cube,1);
    }
    public int[][] E(int[][] cube) {
        moveLog.add("E");
        return Move.right(cube,2);
    }
    public int[][] D(int[][] cube) {
        moveLog.add("D");
        return Move.right(cube,3);
    }
    public int[][] FPrime(int[][] cube) {
        moveLog.add("FPrime");
        return Move.FaceTurnLeft(cube,1);
    }
    public int[][] SPrime(int[][] cube) {
        moveLog.add("SPrime");
        return Move.FaceTurnLeft(cube,2);
    }
    public int[][] B(int[][] cube) {
        moveLog.add("B");
        return Move.FaceTurnLeft(cube,3);
    }
    public int[][] F(int[][] cube) {
        moveLog.add("F");
        return Move.FaceTurnRight(cube,1);
    }
    public int[][] S(int[][] cube) {
        moveLog.add("S");
        return Move.FaceTurnRight(cube,2);
    }
    public int[][] BPrime(int[][] cube) {
        moveLog.add("BPrime");
        return Move.FaceTurnRight(cube,3);
    }
    public int[][] CubeTurnLeft(int[][] cube) {
        moveLog.add("CubeTurnLeft");
        return Move.changeViewLeft(cube);
    }
    public int[][] CubeTurnRight(int[][] cube) {
        moveLog.add("CubeTurnRight");
        return Move.changeViewRight(cube);
    }
    public int[][] CubeTurnUp(int[][] cube) {
        moveLog.add("CubeTurnUp");
        return Move.changeViewUp(cube);
    }
    public int[][] CubeTurnDown(int[][] cube) {
        moveLog.add("CubeTurnDown");
        return Move.changeViewDown(cube);
    }
}
