public class SecondLayer {
    
    private int[][] cube;
    private final SolveHelper helper;

    public SecondLayer(int[][] cube) {
        this.cube = cube;
        helper = new SolveHelper();
    }

    public int[][] solveSecondLayer(int[][] cube) {
        this.cube = cube;
        positionSecEdges();
        return cube;
    }

    public void positionSecEdges() {
        cube = helper.CubeRotateRight(cube);
        cube = helper.CubeRotateRight(cube);
        System.out.println(TroubleShooter.tempPrint(cube));
        while(!isSecondLayer()) {
            //are the 4 top edge pieces yellow edges
            if(noEasyMove()) {
                if(cube[7][1] != cube[7][2] || cube[10][1] != cube[10][0]) {
                    rightInsert();
                }
                else if(cube[7][1] != cube[7][0] || cube[4][1] != cube[4][2]) {
                    leftInsert();
                }
                else if(cube[7][1] == cube[10][0] && cube[10][1] == cube[7][2]) {
                    rightInsert();
                }
                else if(cube[7][1] == cube[4][2] && cube[4][1] == cube[7][0]) {
                    leftInsert();
                }
                else {
                    cube = helper.D(cube);
                    cube = helper.E(cube);
                }
            }
            //does bottom edge color match front center
            else if(cube[6][1] == cube [7][1] && cube[2][1] != 2) {
                //does top edge color match right side center
                if(cube[2][1] == cube[10][1]) {
                    rightInsert();
                }
                //does top edge color match left side center
                else if(cube[2][1] == cube[4][1]) {
                    leftInsert();
                }
                else {
                    System.out.println("Error, Normal");
                    return;
                }
            }
            else if(isNeededEdgeThere()) {
                cube = helper.U(cube);
            }
            else {
                cube = helper.D(cube);
                cube = helper.E(cube);
            }
        }
    }


    public void rightInsert() {
        cube = helper.U(cube);
        cube = helper.R(cube);
        cube = helper.UPrime(cube);
        cube = helper.RPrime(cube);
        cube = helper.UPrime(cube);
        cube = helper.FPrime(cube);
        cube = helper.U(cube);
        cube = helper.F(cube);
    }
    
    public void leftInsert() {
        cube = helper.UPrime(cube);
        cube = helper.LPrime(cube);
        cube = helper.U(cube);
        cube = helper.L(cube);
        cube = helper.U(cube);
        cube = helper.F(cube);
        cube = helper.UPrime(cube);
        cube = helper.FPrime(cube);
    }

    public boolean isNeededEdgeThere() {
        return ((cube[3][1] == cube[7][1] && cube[1][0] != 2) ||
                (cube[6][1] == cube[7][1] && cube[2][1] != 2) ||
                (cube[9][1] == cube[7][1] && cube[1][2] != 2) ||
                (cube[17][1] == cube[7][1] && cube[0][1] != 2));
    }

    public boolean noEasyMove() {
        return ((cube[3][1] == 2 || cube[1][0] == 2) && 
                (cube[6][1] == 2 || cube[2][1] == 2) && 
                (cube[9][1] == 2 || cube[1][2] == 2) && 
                (cube[17][1] == 2 || cube[0][1] == 2));
    }
    
    public boolean isSecondLayer() {
        for(int i = 0; i < 3; i++) {
            for(int j = 4; j < 11; j += 3) {
                if(cube[j][i] != cube[j][1]) {
                    return false;
                }
            }
            if(cube[16][i] != cube[16][1]) {
                return false;
            }
        }
        return true;
    }
}
