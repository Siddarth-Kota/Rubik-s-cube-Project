import java.util.ArrayList;

public class SolveHelper {

    private static ArrayList<String> moveLog;

    public SolveHelper() {
        moveLog = new ArrayList<String>();
    }

    public static ArrayList<String> getMoveLog() {
        ArrayList<String> sender = moveLog;
        moveLog = new ArrayList<String>();
        return sender;
    }

    /**
     * @return the center number for what face the color tile is at
     * @param color the center tile color being seached for
     */
    public int findFace(int[][] cube, int color) { 
        if(cube[1][1] == color)
            return 1;
        else if(cube[4][1] == color)
            return 4;
        else if(cube[7][1] == color)
            return 7;
        else if(cube[10][1] == color)
            return 10;
        else if(cube[13][1] == color)
            return 13;
        else if(cube[16][1] == color)
            return 16;
        return -1;
    }

    /**
     * 
     * @param cube
     * @param face the face (number) being analyzed
     * @param loc direction from face of target edge tile
     * @return color of targetted edge tile (number)
     */
    public int getEdgeColor(int[][] cube, int face, String loc) {
        switch(loc) {
            case "top": return cube [face - 1] [1];
            case "left": return cube [face] [0];
            case "bottom": return cube [face + 1] [1];
            case "right": return cube [face] [2];
        }
        return -1;
    }

    public int getCornerColor(int [][] cube, int face, String loc) {
        switch(loc) {
            case "topleft": return cube [face - 1][0];
            case "topright": return cube [face - 1][2];
            case "bottomleft": return cube [face + 1][0];
            case "bottomright": return cube [face + 1][2];
        }
        return -1;
    }

    public int[][] R(int[][] cube) {
        moveLog.add("R");
        return Move.up(cube,3);
    }
    public int[][] M(int[][] cube) {
        moveLog.add("M");
        return Move.down(cube,2);
    }
    public int[][] L(int[][] cube) {
        moveLog.add("L");
        return Move.down(cube,1);
    }
    public int[][] RPrime(int[][] cube) {
        moveLog.add("R'");
        return Move.down(cube,3);
    }
    public int[][] MPrime(int[][] cube) {
        moveLog.add("M'");
        return Move.up(cube,2);
    }
    public int[][] LPrime(int[][] cube) {
        moveLog.add("L'");
        return Move.up(cube,1);
    }
    public int[][] U(int[][] cube) {
        moveLog.add("U");
        return Move.left(cube,1);
    }
    public int[][] EPrime(int[][] cube) {
        moveLog.add("E'");
        return Move.left(cube,2);
    }
    public int[][] DPrime(int[][] cube) {
        moveLog.add("D'");
        return Move.left(cube,3);
    }
    public int[][] UPrime(int[][] cube) {
        moveLog.add("U'");
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
        moveLog.add("F'");
        return Move.FaceTurnLeft(cube,1);
    }
    public int[][] SPrime(int[][] cube) {
        moveLog.add("S'");
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
        moveLog.add("B'");
        return Move.FaceTurnRight(cube,3);
    }
    public int[][] Y(int[][] cube) {
        moveLog.add("Y");
        return Move.changeViewLeft(cube);
    }
    public int[][] YPrime(int[][] cube) {
        moveLog.add("Y'");
        return Move.changeViewRight(cube);
    }
    public int[][] X(int[][] cube) {
        moveLog.add("X");
        return Move.changeViewUp(cube);
    }
    public int[][] XPrime(int[][] cube) {
        moveLog.add("X'");
        return Move.changeViewDown(cube);
    }
    public int[][] Z(int[][] cube) {
        moveLog.add("Z");
        return Move.CubeRotateRight(cube);
    }
    public int[][] ZPrime(int[][] cube) {
        moveLog.add("Z'");
        return Move.CubeRotateLeft(cube);
    }
    /**
     * 
     * @param currentFace the current face the center color is on
     * @param newFace the target face for the center colo
     */
    public int[][] setFace(int[][] cube, int currentFace, int newFace) {
        if(currentFace == newFace) 
            return cube;
        //set TOP face
        else if(newFace == 1) {
            if(currentFace == 7) {
                cube = X(cube);
            }
            else if(currentFace == 4) {
                cube = YPrime(cube);
                cube = X(cube);
            }
            else if(currentFace == 10) {
                cube = Y(cube);
                cube = X(cube);
            }
            else if(currentFace == 13) {
                cube = X(cube);
                cube = X(cube);
            }
            else if(currentFace == 16) {
                cube = XPrime(cube);
            }
        }
        //set FRONT face
        else if(newFace == 7) {
            if(currentFace == 1) {
                cube = XPrime(cube);
            }
            else if(currentFace == 4) {
                cube = YPrime(cube);
            }
            else if(currentFace == 10) {
                cube = Y(cube);
            }
            else if(currentFace == 13) {
                cube = X(cube);
            }
            else if(currentFace == 16) {
                cube = XPrime(cube);
                cube = XPrime(cube);
            }
        }
        //set LEFT face
        else if(newFace == 4) {
            if(currentFace == 1) {
                cube = XPrime(cube);
                cube = Y(cube);
            }
            else if(currentFace == 7) {
                cube = Y(cube);
            }
            else if(currentFace == 10) {
                cube = Y(cube);
                cube = Y(cube);
            }
            else if(currentFace == 13) {
                cube = X(cube);
                cube = Y(cube);
            }
            else if(currentFace == 16) {
                cube = YPrime(cube);
            }
        }
        //set RIGHT face
        else if(newFace == 10) {
            if(currentFace == 1) {
                cube = XPrime(cube);
                cube = YPrime(cube);
            }
            else if(currentFace == 7) {
                cube = YPrime(cube);
            }
            else if(currentFace == 4) {
                cube = YPrime(cube);
                cube = YPrime(cube);
            }
            else if(currentFace == 13) {
                cube = X(cube);
                cube = YPrime(cube);
            }
            else if(currentFace == 16) {
                cube = Y(cube);
            }
        }
        //set bottom face
        else if(newFace == 13) {
            if(currentFace == 1) {
                cube = XPrime(cube);
                cube = XPrime(cube);
            }
            else if(currentFace == 7) {
                cube = XPrime(cube);
            }
            else if(currentFace == 10) {
                cube = Y(cube);
                cube = XPrime(cube);
            }
            else if(currentFace == 4) {
                cube = YPrime(cube);
                cube = XPrime(cube);
            }
            else if(currentFace == 16) {
                cube = X(cube);
            }
        }
        //set BACK face
        else if(newFace == 16) {
            if(currentFace == 1) {
                cube = X(cube);
            }
            else if(currentFace == 7) {
                cube = X(cube);
                cube = X(cube);
            }
            else if(currentFace == 10) {
                cube = YPrime(cube);
            }
            else if(currentFace == 13) {
                cube = XPrime(cube);
            }
            else if(currentFace == 4) {
                cube = Y(cube);
            }
        }
        return cube;
    }
}
