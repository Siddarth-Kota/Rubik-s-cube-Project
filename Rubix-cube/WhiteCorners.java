public class WhiteCorners {
    private int[][] cube;
    private final SolveHelper helper;

    public WhiteCorners(int[][] cube) {
        this.cube = cube;
        helper = new SolveHelper();
    }

    public int[][] solveWhiteCorners(int[][] cube) {
        this.cube = cube;
        positionCornerPiece();
        System.out.println(isFirstLayer());
        return cube;
    }

    public void positionCornerPiece() {
        while(!isFirstLayer()) {
            //bottom right, right side
            if(cube[11][0] == 1) {
                while(cube[8][2] != cube[7][1] || cube[12][2] != cube[10][1]) {
                    cube = helper.UPrime(cube);
                    cube = helper.E(cube);
                }
                cube = helper.D(cube);
                cube = helper.F(cube);
                cube = helper.DPrime(cube);
                cube = helper.FPrime(cube);
            }
            //bottom left, left side
            if(cube[5][2] == 1) {
                while(cube[8][0] != cube [7][1] || cube[12][0] != cube[4][1]) {
                    cube = helper.UPrime(cube);
                    cube = helper.E(cube);
                }
                cube = helper.DPrime(cube);
                cube = helper.RPrime(cube);
                cube = helper.D(cube);
                cube = helper.R(cube);
            }
            //top right, right side
            if(cube[9][0] == 1) {
                cube = helper.RPrime(cube);
                cube = helper.DPrime(cube);
                cube = helper.R(cube);
            }
            //top left, left side
            if(cube[3][2] == 1) {
                cube = helper.LPrime(cube);
                cube = helper.D(cube);
                cube = helper.L(cube);
            }
            //bottom, bottom side
            if(cube[12][2] == 1) {
                while(cube[6][2] == cube[7][1] && cube[9][0] == cube[10][1] && cube[2][2] == 1) {
                    cube = helper.UPrime(cube);
                    cube = helper.E(cube);
                }
                cube = helper.RPrime(cube);
                cube = helper.D(cube);
                cube = helper.R(cube);
            }
            //top, top side
            if(cube[2][2] == 1 && (cube[6][2] != cube[7][1] || cube[9][0] != cube[10][1])) {
                cube = helper.RPrime(cube);
                cube = helper.DPrime(cube);
                cube = helper.R(cube);
            }
            cube = helper.CubeTurnRight(cube);
        }
    }

    public boolean isFirstLayer() {
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(cube[i][j] != 1) {
                    return false;
                }
            }
            if(cube[3][i] != cube[4][1] || cube[6][i] != cube[7][1] || cube [9][i] != cube[10][1] || cube [17][i] != cube[16][1]) {
                return false;
            }
        }
        return true;
    }
}
