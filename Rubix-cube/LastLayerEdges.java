public class LastLayerEdges {
    
    private int[][] cube;
    private final SolveHelper helper;


    public LastLayerEdges(int[][] cube) {
        this.cube = cube;
        helper = new SolveHelper();
    }

    public int[][] solveLastLayerEdges(int[][] cube) {
        this.cube = cube;
        positionLastLayerEdges();
        return cube;
    }

    public void positionLastLayerEdges() {
        while(!Cube.isWin()) {
            //is one of the edges already solved
            if((cube[3][0] == cube[3][1]) || 
                (cube[6][0] == cube[6][1]) ||
                (cube[9][0] == cube[9][1]) ||
                (cube[17][0] == cube[17][1])) {
                    //put solved edge in the back
                    if(cube[17][0] == cube[17][1]) {
                        //edgeSwap one: edge on the right needs to go to the left
                        if(cube[9][1] == cube[4][1]) {
                            EdgeCycle1();
                        }
                        else if(cube[3][1] == cube[10][1]) {
                            EdgeCycle2();
                        }
                        else {
                            cube = helper.U(cube);
                        }
                    }
                    else {
                        cube = helper.Y(cube);
                    }
            }
            //opposite edges need to swap
            else if(cube[6][1] == cube[16][1] && cube[17][1] == cube[7][1] && cube[9][1] == cube[4][1] && cube[3][1] == cube[10][1]) {
                oppositeEdgeSwap();
            }
            else if(cube[6][1] == cube[10][1] && cube[9][1] == cube[7][1] && cube[3][1] == cube[16][1] && cube[17][1] == cube[4][1]) {
                adjacentEdgeSwapRight();
            }
            else if(cube[6][1] == cube[4][1] && cube[9][1] == cube[16][1] && cube[3][1] == cube[7][1] && cube[17][1] == cube[10][1]) {
                adjacentEdgeSwapLeft();
            }
            else {
                System.out.println("Error");
                System.out.println(TroubleShooter.tempPrint(cube));
                return;
            }
        }
    }

    public void adjacentEdgeSwapRight() {
        cube = helper.MPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);
        cube = helper.UPrime(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);
        cube = helper.UPrime(cube);
        cube = helper.MPrime(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);
    }
    
    public void adjacentEdgeSwapLeft() {
        cube = helper.MPrime(cube);
        cube = helper.U(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);
        cube = helper.U(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);
        cube = helper.U(cube);
        cube = helper.MPrime(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);
    }

    public void oppositeEdgeSwap() {
        cube = helper.M(cube);
        cube = helper.M(cube);
        cube = helper.UPrime(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);
        cube = helper.U(cube);
        cube = helper.U(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);
        cube = helper.UPrime(cube);
        cube = helper.M(cube);
        cube = helper.M(cube);

    }

    public void EdgeCycle1() {
        cube = helper.R(cube);
        cube = helper.UPrime(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.UPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.R(cube);
        cube = helper.R(cube);
    }

    public void EdgeCycle2() {
        cube = helper.R(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
    }
}
