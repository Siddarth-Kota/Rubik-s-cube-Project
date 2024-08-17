public class LastLayerCorners {
    
    private int[][] cube;
    private final SolveHelper helper;


    public LastLayerCorners(int[][] cube) {
        this.cube = cube;
        helper = new SolveHelper();
    }

    public int[][] solveLastLayerCorners(int[][] cube) {
        this.cube = cube;
        positionLastLayerCorners();
        return cube;
    }

    public void positionLastLayerCorners() {
        while(!isCornersSolved()) {
            //moves solved corners into right positions
            if(cube[17][0] == cube[17][2] && cube[9][0] == cube[9][2] && cube[6][0] == cube[6][2] && cube[3][0] == cube[3][2]) {
                cube = helper.U(cube);
            }
            //are there any matching corner faces
            else if(cube[17][0] == cube[17][2] || cube[9][0] == cube[9][2] || cube[6][0] == cube[6][2] || cube[3][0] == cube[3][2]) {
                if(cube[3][2] == cube[3][0]) {
                    adjacentCornerSwap();
                }
                //moves solved corners to left side of cube
                else {
                    cube = helper.U(cube);
                }
            }
            else if(cube[17][0] != cube[17][2] && cube[9][0] != cube[9][2] && cube[6][0] != cube[6][2] && cube[3][0] != cube[3][2]) {
                diagonalCornerSwap();
            }
            else {
                System.out.println("Error");
                System.out.println(TroubleShooter.tempPrint(cube));
                return;
            }
        }  
    }

    public void diagonalCornerSwap() {
        cube = helper.F(cube);
        cube = helper.R(cube);
        cube = helper.UPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
        cube = helper.FPrime(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.F(cube);
        cube = helper.R(cube);
        cube = helper.FPrime(cube);
    }

    public void adjacentCornerSwap() {
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.F(cube);
        cube = helper.R(cube);
        cube = helper.R(cube);
        cube = helper.UPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.R(cube);
        cube = helper.U(cube);
        cube = helper.RPrime(cube);
        cube = helper.FPrime(cube);
    }

    public boolean isCornersSolved() {
        return ((cube[17][0] == cube[16][1] && cube[17][2] == cube[16][1]) && 
                (cube[3][0] == cube[4][1] && cube[3][2] == cube[4][1]) &&
                (cube[6][0] == cube[7][1] && cube[6][2] == cube[7][1]) &&
                (cube[9][0] == cube[10][1] && cube[9][2] == cube[10][1]));
    }
}
